package com.colodoo.framework.manager.codeInfo.model;

import java.util.ArrayList;
import java.util.List;

public class CodeInfoExample {
    /**
     * code_info
     */
    protected String orderByClause;

    /**
     * code_info
     */
    protected boolean distinct;

    /**
     * code_info
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public CodeInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-24
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
     * @mbg.generated 2019-04-24
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-04-24
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * code_info 2019-04-24
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

        public Criteria andCodeInfoIdIsNull() {
            addCriterion("code_info_id is null");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdIsNotNull() {
            addCriterion("code_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdEqualTo(String value) {
            addCriterion("code_info_id =", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdNotEqualTo(String value) {
            addCriterion("code_info_id <>", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdGreaterThan(String value) {
            addCriterion("code_info_id >", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("code_info_id >=", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdLessThan(String value) {
            addCriterion("code_info_id <", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdLessThanOrEqualTo(String value) {
            addCriterion("code_info_id <=", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdLike(String value) {
            addCriterion("code_info_id like", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdNotLike(String value) {
            addCriterion("code_info_id not like", value, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdIn(List<String> values) {
            addCriterion("code_info_id in", values, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdNotIn(List<String> values) {
            addCriterion("code_info_id not in", values, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdBetween(String value1, String value2) {
            addCriterion("code_info_id between", value1, value2, "codeInfoId");
            return (Criteria) this;
        }

        public Criteria andCodeInfoIdNotBetween(String value1, String value2) {
            addCriterion("code_info_id not between", value1, value2, "codeInfoId");
            return (Criteria) this;
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("`value` is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("`value` is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("`value` =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("`value` <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("`value` >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("`value` >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("`value` <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("`value` <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("`value` like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("`value` not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("`value` in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("`value` not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("`value` between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("`value` not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }
    }

    /**
     *  * code_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * code_info 2019-04-24
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