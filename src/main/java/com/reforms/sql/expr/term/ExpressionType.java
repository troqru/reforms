package com.reforms.sql.expr.term;

public enum ExpressionType {

    ET_SELECT_QUERY,
    ET_LINKING_SELECT_QUERY,
    ET_FROM_STATEMENT,
    ET_GROUP_BY_STATEMENT,
    ET_HAVING_STATEMENT,
    ET_ORDER_BY_STATEMENT,
    ET_SELECT_STATEMENT,
    ET_WHERE_STATEMENT,
    ET_CASE_EXPRESSION,
    ET_WHEN_THEN_EXPRESSION,
    ET_ELSE_EXPRESSION,
    ET_TABLE_EXPRESSION,
    ET_TABLE_JOIN_EXPRESSION,
    ET_TABLE_SUB_QUERY_EXPRESSION,
    ET_TABLE_VALUES_EXPRESSION,
    ET_BETWEEN_PREDICATE_EXPRESSION,
    ET_COMPARISON_PREDICATE_EXPRESSION,
    ET_EXISTS_PREDICATE_EXPRESSION,
    ET_IN_PREDICATE_EXPRESSION,
    ET_LIKE_PREDICATE_EXPRESSION,
    ET_ESCAPE_EXPRESSION,
    ET_NULLABLE_PREDICATE_EXPRESSION,
    ET_QUANTIFIED_COMPARISON_PREDICATE_EXPRESSION,
    ET_UNIQUE_PREDICATE_EXPRESSION,
    ET_VALUE_LIST_EXPRESSION,
    ET_VALUE_EXPRESSION,
    ET_EXTENDS_SELECTABLE_EXPRESSION,
    ET_AS_CLAUSE_EXPRESSION,
    ET_ASTERISK_EXPRESSION,
    ET_CAST_EXPRESSION,
    ET_COLLATE_EXPRESSION,
    ET_COLUMN_EXPRESSION,
    ET_FUNC_EXPRESSION,
    ET_GROUPING_COLUMN_REFERENCE_EXPRESSION,
    ET_MATH_EXPRESSION,
    ET_NOT_EXPRESSION,
    ET_SEARCH_GROUP_EXPRESSION,
    ET_SORT_KEY_EXPRESSION,
    ET_CONDITION_FLOW_TYPE_EXPRESSION,
    ET_LIMIT_EXPRESSION,
    ET_OFFSET_EXPRESSION,
    ET_PAGE_EXPRESSION,
    ET_KEY_WORD_EXPRESSION,
    ET_TOP_EXPRESSION,
    ET_TIME_ZONE_EXPRESSION,
    ET_TYPE_CAST_EXPRESSION,
    ;
}
