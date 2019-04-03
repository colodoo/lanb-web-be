package com.colodoo.manager.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Test {
    /**
     * 测试ID
     */
    private String testId;

    /**
     * 测试名
     */
    private String testName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 测试ID
     * @return test_id 测试ID
     */
    public String getTestId() {
        return testId;
    }

    /**
     * 测试ID
     * @param testId 测试ID
     */
    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }

    /**
     * 测试名
     * @return test_name 测试名
     */
    public String getTestName() {
        return testName;
    }

    /**
     * 测试名
     * @param testName 测试名
     */
    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}