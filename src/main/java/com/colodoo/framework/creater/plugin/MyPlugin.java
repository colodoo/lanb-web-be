package com.colodoo.framework.creater.plugin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

@Slf4j
public class MyPlugin extends PluginAdapter {
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }

    @Override
    public boolean validate(List<String> list) {
        return false;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        log.info("name:" + field.getName() + " type:" + field.getType().getShortName());
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }


    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        log.info(introspectedTable.getAllColumns().get(0).getJdbcTypeName());
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }
}