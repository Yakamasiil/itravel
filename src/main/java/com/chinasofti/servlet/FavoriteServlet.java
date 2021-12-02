package com.chinasofti.servlet;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.pojo.Favorite;
import com.chinasofti.pojo.Router;
import com.chinasofti.pojo.User;
import com.chinasofti.services.IFavoriteService;
import com.chinasofti.services.impl.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FavoriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out=resp.getWriter();
        String action=req.getParameter("action");
        IFavoriteService favoriteService=new FavoriteServiceImpl();

        if (action.equals("showbtn")){
            String rids=req.getParameter("rid");
            int rid=Integer.parseInt(rids);
            int uid=((User)req.getSession().getAttribute("user")).getUid();
            Favorite favorite=favoriteService.findFavoriteByRidAndUid(uid,rid);

            int count =favoriteService.fCount(rid);
            JSONObject jobj=new JSONObject();
            jobj.put("count",count);
            jobj.put("rid",rid);
            if ((favorite!=null)){
               jobj.put("flag",true);
            }
            else {
                jobj.put("flag",false);
            }
            out.write(jobj.toJSONString());
        }else if (action.equals("addFavorite")){
            String rids=req.getParameter("rid");
            int rid=Integer.parseInt(rids);
            int uid=((User)req.getSession().getAttribute("user")).getUid();
            Favorite favorite=new Favorite();
            Router router=new Router();
            router.setRid(rid);
            User user=new User();
            user.setUid(uid);
            favorite.setRouter(router);
            favorite.setUser(user);
            System.out.println("into serv");
            int count=favoriteService.addFavorite(favorite);
            if (count>0){
                out.write("true");
            }
            else {
                out.write("false");
            }

        }
        else if(action.equals("myFList")){
            int uid=((User)req.getSession().getAttribute("user")).getUid();

            List<Favorite> list=favoriteService.findAllFavoriteById(uid);

            req.setAttribute("list",list);
            req.getRequestDispatcher("myfavorite.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
