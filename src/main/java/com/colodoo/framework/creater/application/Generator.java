package com.colodoo.framework.creater.application;

import com.colodoo.framework.utils.StringUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java应用
 * 
 * @author colodoo
 *
 */
public class Generator {

	public static void main(String[] args) {
		Map values = new HashMap();
		values.put("targetPackage", "com.colodoo.manager.tbUser");
		values.put("tableName", "tb_user");
		Generator.runMybatis(values);
	}

	public static void runMybatis(Map<String, String> values) {
		try {
			String targetPackage = values.get("targetPackage");
			String tableName = values.get("tableName");
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File("src\\main\\resources\\generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			org.mybatis.generator.config.Configuration config = cp.parseConfiguration(configFile);
			for (Context ctx : config.getContexts()) {
				// 设置model生成位置
				JavaModelGeneratorConfiguration model = ctx.getJavaModelGeneratorConfiguration();
				model.setTargetPackage(targetPackage + ".model");
				model.setTargetProject("./src/main/java");
				model.getProperties().setProperty("enableSubPackages", "true");
				model.getProperties().setProperty("trimStrings", "true");
				// 设置xml文件生成位置
				SqlMapGeneratorConfiguration sqlMapper = ctx.getSqlMapGeneratorConfiguration();
				sqlMapper.setTargetPackage(targetPackage + ".service");
				sqlMapper.setTargetProject("./src/main/java");
				sqlMapper.getProperties().setProperty("enableSubPackages", "true");
				// 设置mapper接口文件生成位置
				JavaClientGeneratorConfiguration javaMapper = ctx.getJavaClientGeneratorConfiguration();
				javaMapper.setTargetPackage(targetPackage + ".service");
				javaMapper.setTargetProject("./src/main/java");
				javaMapper.getProperties().setProperty("enableSubPackages", "true");
				// 配置表信息
				ctx.getTableConfigurations().clear();
				TableConfiguration tableCfg = new TableConfiguration(ctx);
				tableCfg.setTableName(tableName);
				StringUtil.upperCase(StringUtil.underlineToCamel2(tableName));
				ctx.getTableConfigurations().add(tableCfg);
			}
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
