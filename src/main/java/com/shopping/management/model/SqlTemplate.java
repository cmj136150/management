package com.shopping.management.model;

public class SqlTemplate {
    public SqlTemplate(){

    }
    public static String changeSql(String sql){
        for(int index=0;index>=0;) {
            index = sql.indexOf(":", index + 1);
            if (index > -1) {
                sql = sql.substring(0, sql.indexOf(" ", index + 1)) + "}" + sql.substring(sql.indexOf(" ", index + 1), sql.length());
            }
        }
        sql=sql.replaceAll(":","#{map.");
        return sql;
    }
}
