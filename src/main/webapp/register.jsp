<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" href="css/register.css">
		<!--导入jquery-->
		<script src="js/jquery-3.3.1.js"></script>
		<script>
			function checkUser(){
				var uname=document.getElementById("username").value;
				$.ajax({
					type:"get",
					url:"user",
					data:"action=checkUser&uname="+uname,//break
					success:function (msg){if(msg==="true"){
						document.getElementById("showmsg").innerText="用户名已存在"	;
					}
					else{
						document.getElementById("showmsg").innerText="用户名可用";
					}}

				});
			}
			function register(){
				$.ajax({
					type:"get",
					url:"user",
					data:$("#registerForm").serialize(),//break
					success:function (msg){
						if(msg=="success")location.href="register_ok.html";
						else {
							document.getElementById("errormsg").innerText="注册失败请检查内容是否合法";
						}
					}

				});
			}
		</script>
    </head>
	<body>
	<!--引入头部-->
	<div id="header"></div>
        <!-- 头部 end -->
    	<div class="rg_layout">
    		<div class="rg_form clearfix">
    			<div class="rg_form_left">
    				<p>新用户注册</p>
    				<p>USER REGISTER</p>
    			</div>
    			<div class="rg_form_center">
					<span id="errormsg" style="color: red">提示:</span>
					<!--注册表单-->
    				<form id="registerForm" method="post">
						<!--提交处理请求的标识符-->
						<input type="hidden" name="action" value="register">
    					<table style="margin-top: 25px;">
    						<tr>
    							<td class="td_left">
    								<label for="username">用户名</label>
    							</td>
    							<td class="td_right">
    								<input type="text" onblur="checkUser()" id="username" name="username" placeholder="请输入账号">

    							</td>
								<td width="200px"><span id="showmsg"></span></td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="password">密码</label>
    							</td>
    							<td class="td_right">
    								<input type="text" id="password" name="password" placeholder="请输入密码">
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="email">Email</label>
    							</td>
    							<td class="td_right">
    								<input type="text" id="email" name="email" placeholder="请输入Email">
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="name">姓名</label>
    							</td>
    							<td class="td_right">
    								<input type="text" id="name" name="name" placeholder="请输入真实姓名">
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="telephone">手机号</label>
    							</td>
    							<td class="td_right">
    								<input type="text" id="telephone" name="telephone" placeholder="请输入您的手机号">
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="sex">性别</label>
    							</td>
    							<td class="td_right gender">
    								<input type="radio" id="sex" name="sex" value="男" checked> 男
    								<input type="radio" name="sex" value="女"> 女
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="birthday">出生日期</label>
    							</td>
    							<td class="td_right">
    								<input type="date" id="birthday" name="birthday" placeholder="年/月/日">
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left">
    								<label for="check">验证码</label>
    							</td>
    							<td class="td_right check">
    								<input type="text" id="check" name="check" class="check">
    								<img src="checkCode" height="32px" alt="" onclick="changeCheckCode(this)">
									<script type="text/javascript">
										//图片点击事件
										function changeCheckCode(img) {
											img.src="checkCode?"+new Date().getTime();
                                        }
									</script>
    							</td>
    						</tr>
    						<tr>
    							<td class="td_left"> 
    							</td>
    							<td class="td_right check"> 
									<button type="button" class="submit" onclick="register()">注册</button>
									<span id="msg" style="color: red;"></span>
    							</td>
    						</tr>
    					</table>
    				</form>
    			</div>
    			<div class="rg_form_right">
    				<p>
    					已有账号？
    					<a href="#">立即登录</a>
    				</p>
    			</div>
    		</div>
    	</div>
        <!--引入尾部-->
    	<div id="footer"></div>
		<!--导入布局js，共享header和footer-->
		<script type="text/javascript" src="js/include.js"></script>
    	
    </body>
</html>