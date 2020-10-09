package cn.yesomething.domain;

import java.util.ArrayList;
import java.util.List;

public class FriendsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendsExample() {
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

        public Criteria andFriendsIdIsNull() {
            addCriterion("friends_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIsNotNull() {
            addCriterion("friends_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendsIdEqualTo(Integer value) {
            addCriterion("friends_id =", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotEqualTo(Integer value) {
            addCriterion("friends_id <>", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdGreaterThan(Integer value) {
            addCriterion("friends_id >", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("friends_id >=", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLessThan(Integer value) {
            addCriterion("friends_id <", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdLessThanOrEqualTo(Integer value) {
            addCriterion("friends_id <=", value, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdIn(List<Integer> values) {
            addCriterion("friends_id in", values, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotIn(List<Integer> values) {
            addCriterion("friends_id not in", values, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdBetween(Integer value1, Integer value2) {
            addCriterion("friends_id between", value1, value2, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("friends_id not between", value1, value2, "friendsId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNull() {
            addCriterion("friend_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("friend_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(Integer value) {
            addCriterion("friend_id =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(Integer value) {
            addCriterion("friend_id <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(Integer value) {
            addCriterion("friend_id >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_id >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(Integer value) {
            addCriterion("friend_id <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(Integer value) {
            addCriterion("friend_id <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<Integer> values) {
            addCriterion("friend_id in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<Integer> values) {
            addCriterion("friend_id not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(Integer value1, Integer value2) {
            addCriterion("friend_id between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_id not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNull() {
            addCriterion("friend_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNotNull() {
            addCriterion("friend_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNameEqualTo(String value) {
            addCriterion("friend_name =", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotEqualTo(String value) {
            addCriterion("friend_name <>", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThan(String value) {
            addCriterion("friend_name >", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_name >=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThan(String value) {
            addCriterion("friend_name <", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThanOrEqualTo(String value) {
            addCriterion("friend_name <=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLike(String value) {
            addCriterion("friend_name like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotLike(String value) {
            addCriterion("friend_name not like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIn(List<String> values) {
            addCriterion("friend_name in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotIn(List<String> values) {
            addCriterion("friend_name not in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameBetween(String value1, String value2) {
            addCriterion("friend_name between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotBetween(String value1, String value2) {
            addCriterion("friend_name not between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIsNull() {
            addCriterion("friend_type is null");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIsNotNull() {
            addCriterion("friend_type is not null");
            return (Criteria) this;
        }

        public Criteria andFriendTypeEqualTo(Integer value) {
            addCriterion("friend_type =", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotEqualTo(Integer value) {
            addCriterion("friend_type <>", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeGreaterThan(Integer value) {
            addCriterion("friend_type >", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_type >=", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLessThan(Integer value) {
            addCriterion("friend_type <", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("friend_type <=", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIn(List<Integer> values) {
            addCriterion("friend_type in", values, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotIn(List<Integer> values) {
            addCriterion("friend_type not in", values, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeBetween(Integer value1, Integer value2) {
            addCriterion("friend_type between", value1, value2, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_type not between", value1, value2, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeIsNull() {
            addCriterion("friend_group_type is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeIsNotNull() {
            addCriterion("friend_group_type is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeEqualTo(Integer value) {
            addCriterion("friend_group_type =", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotEqualTo(Integer value) {
            addCriterion("friend_group_type <>", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeGreaterThan(Integer value) {
            addCriterion("friend_group_type >", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_group_type >=", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeLessThan(Integer value) {
            addCriterion("friend_group_type <", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("friend_group_type <=", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeIn(List<Integer> values) {
            addCriterion("friend_group_type in", values, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotIn(List<Integer> values) {
            addCriterion("friend_group_type not in", values, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeBetween(Integer value1, Integer value2) {
            addCriterion("friend_group_type between", value1, value2, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_group_type not between", value1, value2, "friendGroupType");
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