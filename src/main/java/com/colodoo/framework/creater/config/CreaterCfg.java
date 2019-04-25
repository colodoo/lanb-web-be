package com.colodoo.framework.creater.config;

import java.io.File;
import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "creater")
@Component
public class CreaterCfg implements Serializable {

	private static final long serialVersionUID = 1L;

	public CreaterCfg() {
		this.srcPath = new File("").getAbsolutePath();
	}

	// 项目源代码地址
	private String srcPath;

	// 数据库名
	private String tableSchema;

	// 数据库地址
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
}
