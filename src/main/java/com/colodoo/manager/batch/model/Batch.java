package com.colodoo.manager.batch.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Batch {
	private String batchId;
	private Byte batchType;
	private Byte batchStatus;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private String updateUserId;
	private String remark;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId == null ? null : batchId.trim();
	}

	public Byte getBatchType() {
		return batchType;
	}

	public void setBatchType(Byte batchType) {
		this.batchType = batchType;
	}

	public Byte getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(Byte batchStatus) {
		this.batchStatus = batchStatus;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId == null ? null : updateUserId.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}