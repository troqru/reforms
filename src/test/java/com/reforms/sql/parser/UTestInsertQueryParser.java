package com.reforms.sql.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.reforms.sql.expr.query.InsertQuery;
import com.reforms.sql.expr.viewer.SqlBuilder;

/**
 * @author evgenie
 */
public class UTestInsertQueryParser {

    @Test
    public void testInsertQueryParsing() {
        assertInsertQuery("INSERT INTO tableName (c1, c2) VALUES (1, 2)");
        assertInsertQuery("INSERT INTO tableName (c1, c2) VALUES (?, ?)");
        assertInsertQuery("INSERT INTO tableName VALUES (?, ?)");
        assertInsertQuery("INSERT INTO tableName (c1, c2) SELECT 1, 2");
        assertInsertQuery("INSERT INTO tableName (c1, c2) (SELECT 1, 2)");
        assertInsertQuery("INSERT INTO tableName (c1, c2) SELECT * FROM table2");
        assertInsertQuery("INSERT INTO tableName SELECT * FROM table2");
        assertInsertQuery("INSERT INTO tableName (SELECT * FROM table2)");
        assertInsertQuery("INSERT INTO tableName (SELECT * FROM table2 UNION SELECT * FROM table3)");
        assertInsertQuery("INSERT INTO tableName (c1, c2) (SELECT 1, 2 FROM table2 UNION SELECT 3, 4 FROM table3)");
    }

    @Test
    public void testInsertStatementParsing() {
        assertInsertStatementQuery("INSERT INTO tableName");
        assertInsertStatementQuery("INSERT INTO schemeName.tableName");
        assertInsertStatementQuery("INSERT INTO \"tableName\"");
        assertInsertStatementQuery("INSERT INTO \"schemeName\".\"tableName\"");
        assertInsertStatementQuery("INSERT INTO \"schemeName\".[tableName]");
        assertInsertStatementQuery("INSERT INTO [schemeName].[tableName]");
    }

    private void assertInsertStatementQuery(String query) {
        String newQuery = query + " VALUES (?, ?)";
        assertInsertQuery(newQuery);
    }

    @Test
    public void testInsertValuesParsing() {
        assertInsertValuesParsing("VALUES (1)");
        assertInsertValuesParsing("VALUES (1, ?)");
        assertInsertValuesParsing("VALUES (::filters)");
        assertInsertValuesParsing("VALUES (:filters)");
        assertInsertValuesParsing("VALUES (::#tdate)");
    }

    private void assertInsertValuesParsing(String query) {
        String newQuery = "INSERT INTO table1 " + query;
        assertInsertQuery(newQuery);
    }


    private void assertInsertQuery(String query) {
        assertInsertQuery(query, null);
    }

    private void assertInsertQuery(String query, String expectedQuery) {
        SqlParser sqlParser = new SqlParser(query);
        InsertQuery insertQuery = sqlParser.parseInsertQuery();
        assertQuery(expectedQuery != null ? expectedQuery : query, insertQuery);
    }

    private void assertQuery(String query, InsertQuery insertQuery) {
        assertEquals(query, queryToString(insertQuery));
    }

    private String queryToString(InsertQuery insertQuery) {
        SqlBuilder builder = new SqlBuilder();
        insertQuery.view(builder);
        return builder.getQuery();
    }
}