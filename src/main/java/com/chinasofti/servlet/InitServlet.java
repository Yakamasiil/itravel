package com.chinasofti.servlet;

import com.alibaba.fastjson.JSONArray;
import com.chinasofti.pojo.Category;
import com.chinasofti.services.ICategoryService;
import com.chinasofti.services.impl.CategoryServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class InitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICategoryService categoryService=new CategoryServicesImpl();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        List<Category> listc=categoryService.findAllCategory();
        String jsonstr=JSONArray.toJSON(listc).toString();
        System.out.println(jsonstr);
        out.write(jsonstr);
    }
}
