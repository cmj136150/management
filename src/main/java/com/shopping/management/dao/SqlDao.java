package com.shopping.management.dao;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface SqlDao {

    @Select("${sql}")
    List<Map> searchsql(
            @Param("sql") String sql,
            @Param("map") Map map);

    @Select("${sql}")
    void insertsql(
            @Param("sql") String sql,
            @Param("map") Map map);

    @Select("${sql}")
    void updatesql(
            @Param("sql") String sql,
            @Param("map") Map map);

    @Select("${sql}")
    void deletesql(
            @Param("sql") String sql,
            @Param("map") Map  map);
}
