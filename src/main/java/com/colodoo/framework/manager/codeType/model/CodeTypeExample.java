package com.colodoo.framework.manager.codeType.model;

import java.util.ArrayList;
import java.util.List;

public class CodeTypeExample {
    /**
     * code_type
     */
    protected String orderByClause;

    /**
     * code_type
     */
    protected boolean distinct;

    /**
     * code_type
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public CodeTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-15
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * code_type 2019-04-15
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCodeTypeIdIsNull() {
            addCriterion("code_type_id is null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdIsNotNull() {
            addCriterion("code_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdEqualTo(String value) {
            addCriterion("code_type_id =", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdNotEqualTo(String value) {
            addCriterion("code_type_id <>", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdGreaterThan(String value) {
            addCriterion("code_type_id >", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("code_type_id >=", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdLessThan(String value) {
            addCriterion("code_type_id <", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdLessThanOrEqualTo(String value) {
            addCriterion("code_type_id <=", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdLike(String value) {
            addCriterion("code_type_id like", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdNotLike(String value) {
            addCriterion("code_type_id not like", value, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdIn(List<String> values) {
            addCriterion("code_type_id in", values, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdNotIn(List<String> values) {
            addCriterion("code_type_id not in", values, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdBetween(String value1, String value2) {
            addCriterion("code_type_id between", value1, value2, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIdNotBetween(String value1, String value2) {
            addCriterion("code_type_id not between", value1, value2, "codeTypeId");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameIsNull() {
            addCriterion("code_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameIsNotNull() {
            addCriterion("code_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameEqualTo(String value) {
            addCriterion("code_type_name =", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotEqualTo(String value) {
            addCriterion("code_type_name <>", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameGreaterThan(String value) {
            addCriterion("code_type_name >", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("code_type_name >=", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameLessThan(String value) {
            addCriterion("code_type_name <", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameLessThanOrEqualTo(String value) {
            addCriterion("code_type_name <=", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameLike(String value) {
            addCriterion("code_type_name like", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotLike(String value) {
            addCriterion("code_type_name not like", value, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameIn(List<String> values) {
            addCriterion("code_type_name in", values, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotIn(List<String> values) {
            addCriterion("code_type_name not in", values, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameBetween(String value1, String value2) {
            addCriterion("code_type_name between", value1, value2, "codeTypeName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNameNotBetween(String value1, String value2) {
            addCriterion("code_type_name not between", value1, value2, "codeTypeName");
            return (Criteria) this;
        }
    }

    /**
     *  * code_type
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * code_type 2019-04-15
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}