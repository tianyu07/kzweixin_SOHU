package com.kuaizhan.kzweixin.dao.po.auto;

import com.kuaizhan.kzweixin.enums.ComponentResponseType;
import java.util.ArrayList;
import java.util.List;

public class FollowReplyPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FollowReplyPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> responseTypeCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            responseTypeCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getResponseTypeCriteria() {
            return responseTypeCriteria;
        }

        protected void addResponseTypeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            responseTypeCriteria.add(new Criterion(condition, value, "com.kuaizhan.kzweixin.dao.typehandler.ComponentResponseTypeHandler"));
            allCriteria = null;
        }

        protected void addResponseTypeCriterion(String condition, ComponentResponseType value1, ComponentResponseType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            responseTypeCriteria.add(new Criterion(condition, value1, value2, "com.kuaizhan.kzweixin.dao.typehandler.ComponentResponseTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || responseTypeCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(responseTypeCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidIsNull() {
            addCriterion("weixin_appid is null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidIsNotNull() {
            addCriterion("weixin_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidEqualTo(Long value) {
            addCriterion("weixin_appid =", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotEqualTo(Long value) {
            addCriterion("weixin_appid <>", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidGreaterThan(Long value) {
            addCriterion("weixin_appid >", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidGreaterThanOrEqualTo(Long value) {
            addCriterion("weixin_appid >=", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidLessThan(Long value) {
            addCriterion("weixin_appid <", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidLessThanOrEqualTo(Long value) {
            addCriterion("weixin_appid <=", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidIn(List<Long> values) {
            addCriterion("weixin_appid in", values, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotIn(List<Long> values) {
            addCriterion("weixin_appid not in", values, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidBetween(Long value1, Long value2) {
            addCriterion("weixin_appid between", value1, value2, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotBetween(Long value1, Long value2) {
            addCriterion("weixin_appid not between", value1, value2, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andResponseTypeIsNull() {
            addCriterion("response_type is null");
            return (Criteria) this;
        }

        public Criteria andResponseTypeIsNotNull() {
            addCriterion("response_type is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTypeEqualTo(ComponentResponseType value) {
            addResponseTypeCriterion("response_type =", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotEqualTo(ComponentResponseType value) {
            addResponseTypeCriterion("response_type <>", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeGreaterThan(ComponentResponseType value) {
            addResponseTypeCriterion("response_type >", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeGreaterThanOrEqualTo(ComponentResponseType value) {
            addResponseTypeCriterion("response_type >=", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeLessThan(ComponentResponseType value) {
            addResponseTypeCriterion("response_type <", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeLessThanOrEqualTo(ComponentResponseType value) {
            addResponseTypeCriterion("response_type <=", value, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeIn(List<ComponentResponseType> values) {
            addResponseTypeCriterion("response_type in", values, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotIn(List<ComponentResponseType> values) {
            addResponseTypeCriterion("response_type not in", values, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeBetween(ComponentResponseType value1, ComponentResponseType value2) {
            addResponseTypeCriterion("response_type between", value1, value2, "responseType");
            return (Criteria) this;
        }

        public Criteria andResponseTypeNotBetween(ComponentResponseType value1, ComponentResponseType value2) {
            addResponseTypeCriterion("response_type not between", value1, value2, "responseType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Integer value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Integer value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Integer value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Integer value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Integer> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Integer> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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