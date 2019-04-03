package com.colodoo.framework.creater.service;

import com.colodoo.framework.utils.StringUtil;
import com.colodoo.framework.creater.config.CreaterCfg;
import com.colodoo.framework.creater.model.*;
import com.colodoo.framework.manager.menu.model.Menu;
import com.colodoo.framework.manager.menu.service.MenuService;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 逆向工程,从数据库生成生成相应的代码
 */
@Service
public class CreaterService {

	/* Mybatis Generator相关 */
	private final static String MYBATIS_GENERATOR_XML_PATH = "\\src\\main\\resources\\generatorConfig.xml";

	/* 路径相关 */
	private final static String JAVA_ROOT_PATH = "\\src\\main\\java\\";

	/* 模板相关 */
	private final static String TMP_DATAGRID_PATH = "\\src\\main\\resources\\templates\\creater\\datagrid";
	private final static String TMP_ROOT_PATH = "\\src\\main\\resources\\templates\\manager\\";

	/* 菜单相关 */
	private final static String DEFAULT_PARENT_MENU_ID = "349cb244e3e64a0a92a6721879f624d4";

	@Autowired
	CreaterMapper createrMapper;
	@Autowired
	CreaterCfg createrCfg;
	@Autowired
	MenuService menuService;

	/**
	 * 取查询语句
	 *
	 * @param tableName
	 * @return
	 */
	@Deprecated
	public String getSelectQuery(String tableName) {
		String resultSql = "";
		resultSql += "select ";
		List<Column> columns = createrMapper.getColumns(tableName, createrCfg.getTableSchema());

		for (int i = 0; i < columns.size(); i++) {
			Column column = columns.get(i);
			if (i == columns.size() - 1) {
				resultSql += column.getColumnName() + " as a." + StringUtil.underlineToCamel(column.getColumnName());
			} else {
				resultSql += column.getColumnName() + " as a." + StringUtil.underlineToCamel(column.getColumnName())
						+ ", ";
			}
		}

		resultSql += " from " + tableName + "<where> ";

		for (int i = 0; i < columns.size(); i++) {
			Column column = columns.get(i);
			if (i == columns.size() - 1) {
				resultSql += "a." + column.getColumnName() + " = #{" + StringUtil.underlineToCamel(column.getColumnName())
						+ "}";
			} else {
				resultSql += "a." + column.getColumnName() + " = #{" + StringUtil.underlineToCamel(column.getColumnName())
						+ "} and ";
			}
		}
		
		resultSql += "</where>";
		
		return resultSql;
	}

	/**
	 * 取查询语句，采用模板方式
	 *
	 * @param tableName
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Deprecated
	public String getSelectQueryByTemplate(String tableName) throws IOException, TemplateException {
		String resultStr = "";
		Configuration configuration = new Configuration();
		File dir = ResourceUtils.getFile("classpath:creater");
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("UTF-8");
		Template template = configuration.getTemplate("select.ftl");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<Column> columns = createrMapper.getColumns(tableName, createrCfg.getTableSchema());
		for (Column column : columns) {
			column.set_columnName(StringUtil.underlineToCamel(column.getColumnName()));
		}
		paramMap.put("columns", columns);
		paramMap.put("tableName", tableName);
		StringWriter writer = new StringWriter();
		template.process(paramMap, writer);
		return writer.toString();
	}

	/**
	 * 创建Mybatis字符串
	 *
	 * @param mybatisParm
	 * @return
	 */
	public String createMybatisString(BaseParm mybatisParm) {
		String result = "";
		try {
			List<String> warnings = new ArrayList<>();
			boolean overwrite = true;
			File configFile = new File(createrCfg.getSrcPath() + MYBATIS_GENERATOR_XML_PATH);
			ConfigurationParser cp = new ConfigurationParser(warnings);
			org.mybatis.generator.config.Configuration config = cp.parseConfiguration(configFile);
			for (Context ctx : config.getContexts()) {
				// 设置数据库
				JDBCConnectionConfiguration jdbcConnectionConfiguration = ctx.getJdbcConnectionConfiguration();
				jdbcConnectionConfiguration.setConnectionURL(createrCfg.getUrl());
				// 设置model生成位置
				JavaModelGeneratorConfiguration model = ctx.getJavaModelGeneratorConfiguration();
				model.setTargetPackage(mybatisParm.getPackageName() + ".model");
				model.setTargetProject(createrCfg.getSrcPath() + "/src/main/java");
				model.getProperties().setProperty("enableSubPackages", "true");
				model.getProperties().setProperty("trimStrings", "true");
				// 设置xml文件生成位置
				SqlMapGeneratorConfiguration sqlMapper = ctx.getSqlMapGeneratorConfiguration();
				sqlMapper.setTargetPackage(mybatisParm.getPackageName() + ".service");
				sqlMapper.setTargetProject(createrCfg.getSrcPath() + "/src/main/java");
				sqlMapper.getProperties().setProperty("enableSubPackages", "true");
				// 设置mapper接口文件生成位置
				JavaClientGeneratorConfiguration javaMapper = ctx.getJavaClientGeneratorConfiguration();
				javaMapper.setTargetPackage(mybatisParm.getPackageName() + ".service");
				javaMapper.setTargetProject(createrCfg.getSrcPath() + "/src/main/java");
				javaMapper.getProperties().setProperty("enableSubPackages", "true");
				// 配置表信息
				ctx.getTableConfigurations().clear();
				TableConfiguration tableCfg = new TableConfiguration(ctx);
				tableCfg.setTableName(mybatisParm.getTableName());
				tableCfg.setDomainObjectName(
						StringUtil.upperCase(StringUtil.underlineToCamel(mybatisParm.getTableName())));
				ctx.getTableConfigurations().add(tableCfg);
			}
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);

			// 生成VO类
			this.modelVOCreate(mybatisParm);

			result = "create mybatis done.";
		} catch (Exception e) {
			result = "create mybatis error.";
			e.printStackTrace();
		}
		return result;
	}
	
	public void modelVOCreate(BaseParm serviceParm) throws Exception {
		// 参数处理
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", StringUtil.underlineToCamel2(serviceParm.getTableName()));
		paramMap.put("packageName", serviceParm.getPackageName());

		String resultDirStr = createrCfg.getSrcPath() + JAVA_ROOT_PATH + serviceParm.getPackageName().replace(".", "\\")
				+ "\\model";
		String mapperDirStr = resultDirStr + "";
		File mapperDir = new File(mapperDirStr);
		if (!mapperDir.exists()) {
			mapperDir.mkdirs();
		}
		String mapperTargetFileName = StringUtil.upperCase(StringUtil.underlineToCamel(serviceParm.getTableName()))
				+ "VO.java";
		Writer mapperWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(mapperDirStr + "\\" + mapperTargetFileName)), "UTF-8"));
		Configuration mapperConfiguration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		File mapperTemplateDir = new File("src\\main\\resources\\creater");
		mapperConfiguration.setDirectoryForTemplateLoading(mapperTemplateDir);
		mapperConfiguration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
		mapperConfiguration.setDefaultEncoding("UTF-8");
		Template mapperTemplate = mapperConfiguration.getTemplate("modelVO.ftl");
		mapperTemplate.process(paramMap, mapperWriter);
		mapperWriter.close();
	}

	/**
	 * 创建接口类
	 *
	 * @param actionParm
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String createActionString(BaseParm actionParm) throws IOException, TemplateException {
		String resultStr = "";
		StringWriter writer = new StringWriter();
		String resultDirStr = createrCfg.getSrcPath() + JAVA_ROOT_PATH + actionParm.getPackageName().replace(".", "\\")
				+ "\\action";
		File resultDir = new File(resultDirStr);
		if (!resultDir.exists()) {
			resultDir.mkdir();
		}
		String targetFileName = StringUtil.upperCase(StringUtil.underlineToCamel(actionParm.getTableName()))
				+ "Action.java";
		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		File dir = new File("src\\main\\resources\\creater");
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
		configuration.setDefaultEncoding("UTF-8");
		Template template = configuration.getTemplate("action.ftl");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", StringUtil.underlineToCamel2(actionParm.getTableName()));
		paramMap.put("packageName", actionParm.getPackageName());
		Writer writer1 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(resultDirStr + "\\" + targetFileName)), "UTF-8"));
		template.process(paramMap, writer);
		template.process(paramMap, writer1);
		resultStr = writer.toString();
		writer.close();
		writer1.close();
		System.out.println(resultStr);
		return resultStr;
	}

	/**
	 * 生成服务类代码
	 *
	 * @param serviceParm
	 * @return
	 * @throws Exception
	 */
	public String createServiceString(BaseParm serviceParm) throws Exception {
		String resultStr = "";
		// 参数处理
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", StringUtil.underlineToCamel2(serviceParm.getTableName()));
		paramMap.put("packageName", serviceParm.getPackageName());

		StringWriter writer = new StringWriter();
		String resultDirStr = createrCfg.getSrcPath() + JAVA_ROOT_PATH + serviceParm.getPackageName().replace(".", "\\")
				+ "\\service";
		File resultDir = new File(resultDirStr);
		if (!resultDir.exists()) {
			resultDir.mkdir();
		}
		String targetFileName = StringUtil.upperCase(StringUtil.underlineToCamel(serviceParm.getTableName()))
				+ "Service.java";
		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		File dir = new File("src\\main\\resources\\creater");
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
		configuration.setDefaultEncoding("UTF-8");
		Template template = configuration.getTemplate("service.ftl");
		Writer writer1 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(resultDirStr + "\\" + targetFileName)), "UTF-8"));
		template.process(paramMap, writer);
		template.process(paramMap, writer1);
		resultStr = writer.toString();
		writer.close();
		writer1.close();

		// mapper接口部分生成
		this.mapperInterfaceCreate(serviceParm);
		// mapper配置文件部分
		this.mapperXmlCreates(serviceParm);

		return resultStr;
	}

	/**
	 * mapper配置文件生成
	 * 
	 * @param serviceParm
	 * @throws Exception
	 */
	private void mapperXmlCreates(BaseParm serviceParm) throws Exception {
		// 参数处理
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", StringUtil.underlineToCamel2(serviceParm.getTableName()));
		paramMap.put("packageName", serviceParm.getPackageName());
		paramMap.put("SQLstring", this.getSelectQueryByTemplate(serviceParm.getTableName()));
		
		String resultDirStr = createrCfg.getSrcPath() + JAVA_ROOT_PATH + serviceParm.getPackageName().replace(".", "\\")
				+ "\\service";
		String mapperDirStr = resultDirStr + "\\mapper";
		File mapperDir = new File(mapperDirStr);
		if (!mapperDir.exists()) {
			mapperDir.mkdirs();
		}
		String mapperTargetFileName = StringUtil.upperCase(StringUtil.underlineToCamel(serviceParm.getTableName()))
				+ "SQLMapper.xml";
		Writer mapperWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(mapperDirStr + "\\" + mapperTargetFileName)), "UTF-8"));
		Configuration mapperConfiguration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		File mapperTemplateDir = new File("src\\main\\resources\\creater\\mapper");
		mapperConfiguration.setDirectoryForTemplateLoading(mapperTemplateDir);
		mapperConfiguration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
		mapperConfiguration.setDefaultEncoding("UTF-8");
		Template mapperTemplate = mapperConfiguration.getTemplate("SQLMapperXml.ftl");
		mapperTemplate.process(paramMap, mapperWriter);
		mapperWriter.close();
	}

	/**
	 * mapper接口文件生成
	 * 
	 * @param serviceParm
	 * @throws Exception
	 */
	public void mapperInterfaceCreate(BaseParm serviceParm) throws Exception {

		// 参数处理
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tableName", StringUtil.underlineToCamel2(serviceParm.getTableName()));
		paramMap.put("packageName", serviceParm.getPackageName());

		String resultDirStr = createrCfg.getSrcPath() + JAVA_ROOT_PATH + serviceParm.getPackageName().replace(".", "\\")
				+ "\\service";
		String mapperDirStr = resultDirStr + "\\mapper";
		File mapperDir = new File(mapperDirStr);
		if (!mapperDir.exists()) {
			mapperDir.mkdirs();
		}
		String mapperTargetFileName = StringUtil.upperCase(StringUtil.underlineToCamel(serviceParm.getTableName()))
				+ "SQLMapper.java";
		Writer mapperWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File(mapperDirStr + "\\" + mapperTargetFileName)), "UTF-8"));
		Configuration mapperConfiguration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		File mapperTemplateDir = new File("src\\main\\resources\\creater\\mapper");
		mapperConfiguration.setDirectoryForTemplateLoading(mapperTemplateDir);
		mapperConfiguration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
		mapperConfiguration.setDefaultEncoding("UTF-8");
		Template mapperTemplate = mapperConfiguration.getTemplate("SQLMapper.ftl");
		mapperTemplate.process(paramMap, mapperWriter);
		mapperWriter.close();
	}

	/**
	 * 创建增删改查前端代码
	 *
	 * 1、tableName 表名 2、menuName 功能名 3、menuTitle 菜单标题 4、PK 主键
	 *
	 * @param datagridParm
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String createDatagridString(DatagridParm datagridParm) throws IOException, TemplateException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String tableName = datagridParm.getTableName();
		// 功能名
		String menuName = datagridParm.getMenuName();
		// 功能标题
		String menuTitle = datagridParm.getMenuTitle();

		// 填充变量
		paramMap.put("tableName", StringUtil.underlineToCamel(tableName));
		paramMap.put("menuName", menuName);
		paramMap.put("menuTitle", menuTitle);

		Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);

		// 目标目录字符串
		String targetDirPath = createrCfg.getSrcPath() + TMP_ROOT_PATH + StringUtil.underlineToCamel(tableName);
		// 目标目录
		File targetDir = new File(targetDirPath);

		// 如果不存在目标目录,则创建新的目录
		if (!targetDir.exists()) {
			targetDir.mkdir();
		}
		// 模板目录
		File dir = new File(createrCfg.getSrcPath() + TMP_DATAGRID_PATH);
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
		configuration.setDefaultEncoding("UTF-8");
		Template template = configuration.getTemplate("datagrid-base-crud-js.ftl");
		List<Column> columns = createrMapper.getColumns(tableName, createrCfg.getTableSchema());

		// 时间类型修改控件
		for (Column column : columns) {
			column.set_columnName(StringUtil.underlineToCamel(column.getColumnName()));
			String columnType = column.getColumnType();
			if (columnType.contains("datetime")) {
				column.setColumnType("easyui-datetimebox");
			} else {
				column.setColumnType("easyui-textbox");
			}
			if ("PRI".equals(column.getColumnKey())) {
				paramMap.put("PK", column.get_columnName());
			}
		}
		paramMap.put("columns", columns);

		// 目标文件名
		String targetFileName = menuName + ".ftl";

		// 写带字符串变量中
		StringWriter writer = new StringWriter();
		template.process(paramMap, writer);
		// 写入文件
		Writer writer1 = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(new File(targetDirPath + "\\" + targetFileName)), "UTF-8"));
		template.process(paramMap, writer1);

		// 创建功能菜单
		Menu menu = new Menu();
		menu.setMenuName(menuTitle);
		menu.setMenuUrl(
				StringUtil.underlineToCamel(tableName) + "/" + StringUtil.underlineToCamel(tableName) + "Manager");
		menu.setParentMenuId(DEFAULT_PARENT_MENU_ID);
		menuService.saveMenu(menu);

		return writer.toString();
	}

	/**
	 * 创建实体类字符串
	 *
	 * @param tableName
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Deprecated
	public String createModelString(String tableName) throws IOException, TemplateException {
		String resultStr = "";
		Configuration configuration = new Configuration();
		File dir = ResourceUtils.getFile("classpath:creater");
		configuration.setDirectoryForTemplateLoading(dir);
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setDefaultEncoding("UTF-8");
		Template template = configuration.getTemplate("model.ftl");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<Column> columns = createrMapper.getColumns(tableName, createrCfg.getTableSchema());
		for (Column column : columns) {
			String columnType = column.getColumnType();
			if (columnType.contains("varchar")) {
				column.setColumnType("String");
			}
			if (columnType.contains("datetime")) {
				column.setColumnType("Date");
			}
			if (columnType.contains("int")) {
				column.setColumnType("int");
			}
			column.set_columnName(StringUtil.underlineToCamel(column.getColumnName()));
		}
		paramMap.put("packageName", "com.colodoo");
		paramMap.put("columns", columns);
		tableName = StringUtil.underlineToCamel(tableName);
		paramMap.put("tableName", tableName);
		String resultFile = dir.getAbsolutePath() + "/model.java";
		StringWriter writer = new StringWriter();
		template.process(paramMap, writer);
		return writer.toString();
	}
}
