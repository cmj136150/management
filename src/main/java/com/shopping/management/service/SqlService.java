package com.shopping.management.service;

import com.shopping.management.dao.SqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SqlService {
    @Autowired
    private SqlDao sqlDao;

    public List<Map> searchsql(String sql,Map map){
        return sqlDao.searchsql(sql,map);
    }

    public int insertsql(String sql,Map map){
       sqlDao.insertsql(sql,map);
       return 1;
    }

    public int updatesql(String sql,Map map){
        sqlDao.updatesql(sql,map);
        return 1;
    }

    public int deletesql(String sql,Map map){
        sqlDao.deletesql(sql,map);
        return 1;
    }


}
