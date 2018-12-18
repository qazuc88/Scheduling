package com.paiban.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PaibanExample {
    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    protected boolean distinct;

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public PaibanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
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
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setPageInfo(Integer currentPage, Integer pageSize) {
        if(pageSize<1) throw new IllegalArgumentException("页大小不能小于1！");
        this.limit=pageSize;
        if(currentPage<1) throw new IllegalArgumentException("页数不能小于1！");
        this.offset=(currentPage-1)*pageSize;
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPeopleNameIsNull() {
            addCriterion("PeopleName is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNameIsNotNull() {
            addCriterion("PeopleName is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNameEqualTo(String value) {
            addCriterion("PeopleName =", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameNotEqualTo(String value) {
            addCriterion("PeopleName <>", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameGreaterThan(String value) {
            addCriterion("PeopleName >", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameGreaterThanOrEqualTo(String value) {
            addCriterion("PeopleName >=", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameLessThan(String value) {
            addCriterion("PeopleName <", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameLessThanOrEqualTo(String value) {
            addCriterion("PeopleName <=", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameLike(String value) {
            addCriterion("PeopleName like", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameNotLike(String value) {
            addCriterion("PeopleName not like", value, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameIn(List<String> values) {
            addCriterion("PeopleName in", values, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameNotIn(List<String> values) {
            addCriterion("PeopleName not in", values, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameBetween(String value1, String value2) {
            addCriterion("PeopleName between", value1, value2, "peopleName");
            return (Criteria) this;
        }

        public Criteria andPeopleNameNotBetween(String value1, String value2) {
            addCriterion("PeopleName not between", value1, value2, "peopleName");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("Month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("Month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("Month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("Month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("Month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("Month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("Month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("Month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("Month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("Month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("Month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("Month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("Day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("Day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("Day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("Day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("Day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("Day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("Day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("Day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("Day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("Day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("Day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("Day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("Year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("Year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("Year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("Year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("Year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("Year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("Year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("Year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("Year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("Year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("Year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("Year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("Date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("Date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("Date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("Date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("Date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andISDELETEIsNull() {
            addCriterion("ISDELETE is null");
            return (Criteria) this;
        }

        public Criteria andISDELETEIsNotNull() {
            addCriterion("ISDELETE is not null");
            return (Criteria) this;
        }

        public Criteria andISDELETEEqualTo(Boolean value) {
            addCriterion("ISDELETE =", value, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETENotEqualTo(Boolean value) {
            addCriterion("ISDELETE <>", value, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETEGreaterThan(Boolean value) {
            addCriterion("ISDELETE >", value, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETEGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ISDELETE >=", value, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETELessThan(Boolean value) {
            addCriterion("ISDELETE <", value, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETELessThanOrEqualTo(Boolean value) {
            addCriterion("ISDELETE <=", value, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETEIn(List<Boolean> values) {
            addCriterion("ISDELETE in", values, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETENotIn(List<Boolean> values) {
            addCriterion("ISDELETE not in", values, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETEBetween(Boolean value1, Boolean value2) {
            addCriterion("ISDELETE between", value1, value2, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andISDELETENotBetween(Boolean value1, Boolean value2) {
            addCriterion("ISDELETE not between", value1, value2, "ISDELETE");
            return (Criteria) this;
        }

        public Criteria andPeopleNameLikeInsensitive(String value) {
            addCriterion("upper(PeopleName) like", value.toUpperCase(), "peopleName");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(Remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }
    }

    /**
     *
     * @mbg.generated do_not_delete_during_merge Wed Oct 31 22:10:29 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        /**
         *
         * @mbg.generated Wed Oct 31 22:10:29 CST 2018
         */
        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andISDELETEEqualTo(Paiban.DELETED) : andISDELETENotEqualTo(Paiban.DELETED);
        }
    }

    /**
     *
     * @mbg.generated Wed Oct 31 22:10:29 CST 2018
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