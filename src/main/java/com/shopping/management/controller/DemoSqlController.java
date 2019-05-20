package com.shopping.management.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.management.model.JSONResult;
import com.shopping.management.model.RequertMap;
import com.shopping.management.model.SqlTemplate;
import com.shopping.management.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sql.do")
public class DemoSqlController {
    @Autowired
    private SqlService sqlService;

    @RequestMapping(params = "method=search")
    public JSONResult search(HttpServletRequest request){
        Map map= RequertMap.getParameterMap(request);
        PageHelper.startPage(Integer.parseInt(map.get("page").toString()),Integer.parseInt(map.get("limit").toString()));
//        String sql="select id,DATE_FORMAT(date,'%Y-%c-%d %h:%i:%s') as date,newstypeid,title,content,`read` from news";
        String sql="select id,DATE_FORMAT(date,'%Y-%c-%d') as date,newstypeid,title,content,`read` from news where 1=1 ";
        if(!map.get("title").equals("")){
            sql+=" and title like '%"+map.get("title").toString()+"%'";
        }
        if(!map.get("newstypeid").equals("")) {
            sql+=" and newstypeid='"+map.get("newstypeid").toString()+"'";
        }
        if(map.get("sort").equals("-id")){
            sql+=" order by id desc";
        }else{
            sql+=" order by id ";
        }
        List<Map> _list=sqlService.searchsql(sql,map);
        PageInfo<Map> pageInfo=new PageInfo<>(_list);
        return new JSONResult().ok(pageInfo);
    }

    @RequestMapping(params = "method=insert")
    public JSONResult insert(HttpServletRequest request){
        Map map= RequertMap.getParameterMap(request);
        String sql="insert into news (date,newstypeid,title,content,`read`) values" +
                "('"+map.get("date")+"','"+map.get("newstypeid")+"','"+map.get("title")+"','"+map.get("content")+"','"+map.get("read")+"')";
        sqlService.insertsql(sql,map);
        return new JSONResult().ok("success");
    }

    @RequestMapping(params = "method=delete")
    public JSONResult delete(HttpServletRequest request){
        Map map= RequertMap.getParameterMap(request);
        String sql="delete from news where id='"+map.get("id")+"' ";
        sqlService.deletesql(sql,map);
        return new JSONResult().ok("success");
    }

    @RequestMapping(params = "method=update")
    public JSONResult update(HttpServletRequest request){
        Map map= RequertMap.getParameterMap(request);
        //   :使用前提在map中能够找到对应key值
        String sql="update news set title=:newtitle where title=:oldtitle ";
        sql= SqlTemplate.changeSql(sql);
        sqlService.updatesql(sql,map);
        return new JSONResult().ok("success");
    }
}
