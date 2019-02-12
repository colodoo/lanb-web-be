package com.colodoo.framework.creater.plugin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
public class OverIsMergeablePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        log.info("runtime:" + introspectedTable.getTargetRuntime());
        log.info("target project:" + sqlMap.getTargetProject());
        log.info("package:" + sqlMap.getTargetPackage());
        for (IntrospectedColumn column : introspectedTable.getAllColumns()) {
            log.info("name:" + column.getJdbcTypeName());
            log.info("type:" + column.getJdbcType());
            log.info("prop:" + column.getJavaProperty());
        }
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }
}
