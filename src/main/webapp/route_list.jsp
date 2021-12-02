<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>爱旅行-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <script src="js/jquery-3.3.1.js"></script>

    <script>
        function loadRouter(pageNo){
            var cid=document.getElementById("cid").value;

            $.ajax({
                type:"get",
                url:"router",
                data:"action=listpage&cid="+cid+"&pageNo="+pageNo,
                dataType:"json",
                success:function (data){

                    console.log(data);
                    var pageParm= '<i></i><span>第</span><span>'+pageNo+'</span>共 <span>'+data.totalpage+'</span>页<span>'+data.totalcount+'</span>条';
                    $("[class=page_num_inf]").html(pageParm);
                    $("#routelist").html("");
                    var pageStr=' <ul>'+
                  '    <li><a href="javascript:loadRouter(1)">首页</a></li>'+
                 '  <li class="threeword"><a href="javascript:loadRouter('+data.prev+')">上一页</a></li>'+
                 '  <li class="threeword"><a href="javascript:loadRouter('+data.next+')">下一页</a></li>'+
                 '  <li class="threeword"><a href="javascript:loadRouter('+data.totalpage+')">末页</a></li>'+
                 '  </ul>';
                 $("[class=pageNum]").html(pageStr);
                 var currentNo=$("#currentNo").val();
                 for(var i=0;i<data.list.length;i++){
                        var li='<li>'+
                            '   <div class="img"><img src="'+data.list[i].rimage+'" alt=""></div>'+
                            '    <div class="text1">'+
                            '        <p>'+data.list[i].rname+'</p>'+
                            '       <br/>'+
                            '        <p>'+data.list[i].routeIntroduce+'</p>'+
                            '   </div>'+
                            ' <div class="price">' +
                            '        <p class="price_num">'+
                            '             <span>&yen;</span>'+
                            '             <span>'+data.list[i].price+'</span>'+
                            '            <span>起</span>'+
                            '       </p>'+
                            '       <p><a href="router?rid='+data.list[i].rid+'&action=routeDetail">查看详情</a></p>'+
                            '  </div>'+
                            '  </li>';
                        $("#routelist").append($(li));
        }

                }
            });
        }

        $(function (){
            loadRouter(1);
        })
        function  go(){
            var a=document.getElementById("currentNo").value;
            loadRouter(a);
        }

    </script>
</head>

<body>
<!--引入头部-->
<div id="header"></div>
    <div class="page_one">
        <div class="contant">
            <div class="crumbs">
                <img src="images/search.png" alt="">
                <p>爱旅行><span>搜索结果</span></p>
            </div>
            <div class="xinxi clearfix">
                <input type="hidden" id="cid" value="${requestScope.cid}">
                <div class="left">
                    <div class="header">
                        <span>商品信息</span>
                        <span class="jg">价格</span>
                    </div>
                    <ul id="routelist">

                    </ul>
                    <div class="page_num_inf">

                    </div>
                    <input id="currentNo" type="text"/>
                    <button onclick="go()">GO</button>
                    <div class="pageNum">

                    </div>
                </div>
                <div class="right">
                    <div class="top">
                        <div class="hot">HOT</div>
                        <span>热门推荐</span>
                    </div>
                    <ul>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                            <div class="right">
                                <p>清远新银盏温泉度假村酒店/自由行套...</p>
                                <p>网付价<span>&yen;<span>899</span>起</span>
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--引入头部-->
    <div id="footer"></div>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
</body>

</html>