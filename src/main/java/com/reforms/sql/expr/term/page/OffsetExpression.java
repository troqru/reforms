package com.reforms.sql.expr.term.page;

import com.reforms.sql.expr.term.Expression;
import com.reforms.sql.expr.term.ExpressionType;
import com.reforms.sql.expr.viewer.SqlBuilder;

import static com.reforms.sql.expr.term.ExpressionType.ET_OFFSET_EXPRESSION;
import static com.reforms.sql.parser.SqlWords.SW_OFFSET;

/**
 * Example:  OFFSET 10
 * @author evgenie
 */
public class OffsetExpression extends Expression {

    private String offsetWord = SW_OFFSET;

    private Expression offsetExpr;

    /** ROW or ROWS */
    private String rowsWord;

    public String getOffsetWord() {
        return offsetWord;
    }

    public void setOffsetWord(String offsetWord) {
        this.offsetWord = offsetWord;
    }

    public Expression getOffsetExpr() {
        return offsetExpr;
    }

    public void setOffsetExpr(Expression offsetExpr) {
        this.offsetExpr = offsetExpr;
    }

    public String getRowsWord() {
        return rowsWord;
    }

    public void setRowsWord(String rowsWord) {
        this.rowsWord = rowsWord;
    }

    @Override
    public ExpressionType getType() {
        return ET_OFFSET_EXPRESSION;
    }

    @Override
    public void view(SqlBuilder sqlBuilder) {
        sqlBuilder.appendSpace();
        sqlBuilder.appendWord(offsetWord);
        sqlBuilder.appendExpression(offsetExpr);
        if (rowsWord != null) {
            sqlBuilder.appendSpace();
            sqlBuilder.appendWord(rowsWord);
        }
    }
}
