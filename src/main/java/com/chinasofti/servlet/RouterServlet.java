package com.chinasofti.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.pojo.RouteImg;
import com.chinasofti.pojo.Router;
import com.chinasofti.services.IRouterImgService;
import com.chinasofti.services.IRouterServices;
import com.chinasofti.services.impl.RouterImgServiceImpl;
import com.chinasofti.services.impl.RouterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RouterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
       String action=req.getParameter("action");
        IRouterImgService iRouterImgService=new RouterImgServiceImpl();
       IRouterServices routerServices=new RouterServiceImpl();
       if(action.equals("listpage")){
           String cids=req.getParameter("cid");
           Integer pageSize=10;
           Integer cid=Integer.parseInt(cids);
           int totalCount=routerServices.totalCount(cid);
           int totalPage=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize+1);
           String pageNos=req.getParameter("pageNo");
           Integer pageNo=0;
           if (pageNos==null){
               pageNo=1;
           }else {
               pageNo=Integer.parseInt(pageNos);
           }


           Integer prey=pageNo;
           Integer nexy=pageNo;
           if (pageNo>1){
               prey--;
           }
           if(pageNo<totalPage){
               nexy++;
           }



           List<Router> listr=routerServices.findALLRouterPage(cid,pageSize,pageNo);

           req.setAttribute("listr",listr);
           req.setAttribute("totalCount",totalCount);
           req.setAttribute("totalPage",totalPage);
           req.setAttribute("cid",cid);
           req.setAttribute("prev",prey);
           req.setAttribute("next",nexy);
           req.setAttribute("pageno",pageNo);
           //list转为json数据格式
//           JSONArray jary=new JSONArray();
//           for (int i=0;i<listr.size();i++){
//               JSONObject jobj=new JSONObject();
//               jobj.put("name",listr.get(i).getRname());
//               jobj.put("price",listr.get(i).getPrice());
//               jary.add(jobj);
//           }
           JSONObject jobj=new JSONObject();
           jobj.put("totalpage",totalPage);
           jobj.put("totalcount",totalCount);
           jobj.put("prev",prey);
           jobj.put("next",nexy);
           jobj.put("list",JSONArray.toJSON(listr));
            out.write(jobj.toJSONString());
       }
       else if(action.equals("to_route_list")){
           String cids=req.getParameter("cid");
           req.setAttribute("cid",cids);
           req.getRequestDispatcher("route_list.jsp").forward(req,resp);
       }
       else if(action.equals("routeDetail")){
           String rids=req.getParameter("rid");
           int rid=Integer.parseInt(rids);
           Router router=routerServices.findRouterById(rid);
            List<RouteImg> list=iRouterImgService.findRouteById(rid);
            req.setAttribute("router",router);
            req.setAttribute("imglist",list);
            req.getRequestDispatcher("route_detail.jsp").forward(req,resp);
       }

    }
}
