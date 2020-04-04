<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--移动设备优先-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--禁止缩放-->
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

		<title>CoderPlat - 开发者技术交流社区，简单而方便，程序人生，义无反顾</title>
		<link rel="stylesheet" href="${ctx}/css/main.css" />
		<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">

		
		<!--JS放在文章末尾，编译SEO优化-->
		<script src="${ctx}/js/jquery.min.js"></script>
		<script src="${ctx}/js/bootstrap.min.js"></script>
		<script src="${ctx}/js/nowTime.js"></script>
		
		
		<script type="text/javascript">
			function searchbig(x){
				x.style.width="301px";
				$(".write").hide();
			}
			function searchsmall(x){
				x.style.width="190px";
				$(".write").show();

			}
			function changeCaptcha(){
	        	$("#kchange").attr("src","${ctx}/kmycode");
			}
	</script>

	<script type="text/javascript">

			$(function(){
			    /** 按了回车键 */
			   $(document).keydown(function(event){
				   if(event.keyCode == 13){
					   $("#login-submit-btn").trigger("click");
				   }
			   })

			   /** 给登录按钮绑定点击事件  */
			   $("#login-submit-btn").on("click",function(){
				   /** 校验登录参数 ctrl+K */
				   var loginname = $("#loginname").val();
				   var password = $("#password").val();
				   var captchaCode = $("#captchaCode").val();
				   $("#loginform").submit();
				   
			   })
			   
		   })
	    </script>
	</head>
		
	<body>
		<!--头部-->
		<div class = "header">		
			<ul class="nav nav-tabs">
				<li ><img class="logo"  src="${ctx}/img/logo1.png" /></li>
		  		<li role="presentation" class="active"><a href="#">首页</a></li>
		  		<li role="presentation"><a href="#">文章</a></li>
		  		<li role="presentation"><a href="#">问答</a></li>
		  		<li role="presentation"><a href="#">个人主页</a></li>
		  		<li>
		  	<form>
		  		<div>
					<input onmousemove="searchbig(this)" onmouseout= "searchsmall(this)" style = "200px" id = "search" type="text" placeholder="搜点什么吧 ..." class="form-control">
		  		</div>
		  	</form>
				</li>
				<li role="presentation"><a class="write" style="display:block">写文章</a></li>
				<li role="presentation"><a class="question" href="#">提问</a></li>
				
				<c:choose>
				<c:when test="${sessionScope.user_session.status == 1}">
						<li><i class="glyphicon glyphicon-envelope envelope"></i></li>
						<li class="nowtime"><span id="nowTime"></span></li>
												
						<!--登录后的信息 -->
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#">${sessionScope.user_session.nickname}<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><div class="user-header">
											<img />
											<span>Empirefree</span>
											<span>1842449680@qq.com</span>
										</div>
									</li>
									<li>
										<div class="user-body">
											<a>文章</a>
											<a>问答</a>
											<a>我的主页</a>
										</div>
									</li>
			
									<li><div class="user-footer">
										<button>个人中心</button>
										<a href = "logout"><button >退出</button></a>
									</div>
									</li>
									<li class="divider"></li>
									<li><a href="#">分离的链接</a></li>
								</ul>
								
							</li>
						</c:when>
						<c:otherwise>
							<li role="presentation" class="login"><a href="#" data-toggle="modal" data-target="#mylogin">登录</a></li>
							<li role="presentation"><a href="logout">注册</a></li>
						</c:otherwise>
				</c:choose> 
				
				
			</ul>		
		</div>
		
		
		<!--中间核心代码-->
		<div class="container" style="width: 100%; height: 100%;">
			<div style="width: 1500px;height: 700px;margin: 0 auto;">
				<div class="lefttitle">
					<ul>
						<li >推荐&nbsp;<span class="badge">新</span></li>
						<li>Javaweb</li>
						<li>Linux</li>
						<li>计算机网络</li>
						<li>软件工程</li>
						<li>SSM</li>
						
					</ul>
					
				</div>
				
				<!--中间博文及相关图片-->
				<div class="mainarticle">
					<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>   
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="${ctx}/img/slide-1.jpg" alt="First slide">
								<div class="carousel-caption">标题 1</div>
							</div>
							<div class="item">
								<img src="${ctx}/img/slide-2.jpg" alt="Second slide">
								<div class="carousel-caption">标题 2</div>
							</div>
							<div class="item">
								<img src="${ctx}/img/slide-3.jpg" alt="Third slide">
								<div class="carousel-caption">标题 3</div>
							</div>
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						</a>
					</div> 
					
					<div>具体数据如下</div>
					
					<c:forEach items="${requestScope.articles}" var="article" varStatus="stat">
					    <div id="article1">
					        <section>
					            <article class="myaritcle">
					                <figure class="articleimg">
					                    <!--博文图片-->
					                    <a  href="QAQ">胡宇乔</a>
					                </figure>
					                <!--文章标题-->
					                <header class="articletitle">
					                    ${article.title }
					                </header>
					                <div class="articlcontent">${article.content }......</div>
					                <div><span class="articletime">${article.create_time }</span><span class="accessarticle">阅读全文</span></div>
					            </article>
					        </section>
					    </div>
					    </c:forEach>
						<div class="nextarticle"><fkjava:pager
				  	        pageIndex="${requestScope.pageModel.pageIndex}" 
				  	        pageSize="${requestScope.pageModel.pageSize}" 
				  	        recordCount="${requestScope.pageModel.recordCount}" 
				  	        style="digg"
				  	        submitUrl="${ctx}/article/selectArticle?pageIndex={0}"/> </div>
				</div>
				
				<!--右边基本信息-->
				<div class="rightinfo">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active">
						<a href="#home" data-toggle="tab">
							 推荐文章
						</a>
					</li>
					<li><a href="#ios" data-toggle="tab">iOS</a></li>
					
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="home">
						<p>菜鸟教程天秀</p>
					</div>
					<div class="tab-pane fade" id="ios">
						<p>My Dear Da Lao, please dai dai wo!!!</p>
					</div>
				</div>
				
			</div>
			</div>
		</div>
		
		<!--底部重要信息-->
		<div class="footer">
			<a>Copyright © 2018 CoderPlat 假装这是备案号</a> <i class="glyphicon glyphicon-heart text-danger"></i> by <i class="glyphicon glyphicon-user"></i><a href="#">胡宇乔</a></div>				
		</div>
				
		<!-- 个人登录 -->
		<div class="modal fade" id="mylogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="width: 440px; height: 490px;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="logintitle">
							快速登录
						</h4>
					</div>
					<form id = "loginform" action="login" method="post">
						<div class="modal-body">
						        <ul>
						            <li class="form-group">
						                <input class="form-control" type="text" style="height: 50px;" id="loginname" name="loginname" placeholder="请输入用户名或邮箱" >
						            </li>
						            <li class="form-group">
						                <input class="form-control" type="password" style="height: 50px;" id="password" name="password" placeholder="请输入密码">
						            </li>
						            <li  class="form-group">
						           		<input class="form-control pull-left margin-r-5" type="text" id="captchaCode"  name="captchaCode" style="width: 200px; height: 50px;" name="verificat" placeholder="验证码">
						           		<img class="verificat" src="${ctx }/kmycode" id="kchange" title="看不清，点击换一张" onclick="changeCaptcha()" style="width:80px;height: 50px; border-radius: 10px;" /><a href ="javascript:changeCaptcha()">换一张</a>
						           	</li>
									
									<!-- 错误信息提示 -->
						            <c:choose>
										<c:when test="${requestScope.message == null }">
											<span style="padding-top: 5px"><font color="green">${requestScope.message}</font></span>
										</c:when>
										<c:otherwise>
											<span style="padding-top: 5px"><font color="red">${requestScope.message}</font></span>
										</c:otherwise>
									</c:choose>
						            <li class="autologin">
						                <input type="checkbox" name="remember-me"> 下次自动登录
						            </li>
						        </ul>
						</div>
						<div class="modal-footer">
							<span>还没有账号？</span><a>立即注册</</a><a>忘记密码?</a><br />
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
							</button>
							<button type="button" type ="submit" class="btn btn-primary" id="login-submit-btn" autocomplete="off">
								登录
							</button>
						</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
			
			
			
	</body>
</html>
