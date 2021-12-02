package com.chinasofti.servlet;

import com.chinasofti.pojo.User;
import com.chinasofti.services.IUserServices;
import com.chinasofti.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("GBK");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out= resp.getWriter();
        IUserServices service=new UserServiceImpl();
       //得到业务动作
        String action=req.getParameter("action");
        if(action.equals("login")){
            String userName =req.getParameter("uname");
            String password=req.getParameter("password");
            User user=service.login(userName,password);
            if (user!=null){
//                req.getRequestDispatcher("index.jsp").forward(req,resp);
                req.getSession().setAttribute("user",user);

                out.write("true");
            }
            else{
                out.write("false");
            }
        }
        else if(action.equals("register")){
            User user=new User();

            user.setUserName(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setEmail(req.getParameter("email"));
            user.setName(req.getParameter("name"));
            user.setTelephone(req.getParameter("telephone"));
            user.setSex(1);//待修改
            user.setBirthday(req.getParameter("birthday"));
            user.setCode(null);
            System.out.println(user.getName());
            System.out.println(req.getParameter("username"));
            boolean flag=service.register(user);
            if (flag){
                out.write("success");
            }
            else{
                out.write("fail");
            }
        }
        else if(action.equals("loginout")){
            req.getSession().removeAttribute("user");
            resp.sendRedirect("login.jsp");
        }

        else if (action.equals("checkUser")){
            String uname=req.getParameter("uname");
            boolean flag=service.checkUserName(uname);
            out.write(flag+"");
        }
        else if (action.equals("checkCode")){
            String code=req.getParameter("code");
            String syscode=req.getSession().getAttribute("CHECKCODE_SERVER").toString();
            if(code.equals(syscode)){
                out.write("true");
            }
            else{
                out.write("false");
            }

        }
        else if (action.equals("activeAccount")){
            String code=req.getParameter("code");
            System.out.println(code);
            User user=service.findUserByCode(code);
            if (user!=null){

                int count=service.updateUserById(user.getUid());
                out.print("<h1>激活成功请<a href='login.jsp'>登录</a></h1>");
            }
        }
    }
}
