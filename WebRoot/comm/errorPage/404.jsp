<%@ page language="java" import="java.util.*"  isErrorPage="true" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style type="text/css">
body{margin:0;padding:0;background:#efefef;font-family:Georgia, Times, Verdana, Geneva, Arial, Helvetica, sans-serif;}

div#mother{margin:40px auto 0 auto;width:943px;height:572px;position:relative;}
div#errorBox{background: url("<%=path%>/images/404_bg.png") no-repeat top left;width:943px;height:572px;margin:auto;}
div#errorText{color:#39351e;padding:146px 0 0 446px }
div#errorText p{width:303px;font-size:14px;line-height:26px;}
div.link{height:50px;width:145px;float:left;}
div#home{margin:20px 0 0 444px;}
div#contact{margin:20px 0 0 25px;}
h1{font-size:40px;margin-bottom:35px;}
</style>
  </head>
  
  <body>
    <div id="mother">
	<div id="errorBox">
		<div id="errorText">
			<h1>Sorry..ҳ��û���ҵ���</h1>
			<p>�ƺ�����Ѱ�ҵ���ҳ���ƶ���ʧ�ˡ�<br />
			����Ҳ����ֻ�Ǽ��������һЩ������<br />
			�벻Ҫ���ģ���û�¡��������Դ�������Ҫ���������Ա��ϵ��<br />
			���ǲ�̫��ȫ���ҿ����������ص���</p>
		</div>
		<a href="<%=basePath %>" title="������ҳ">
			<div class="link" id="home"></div>
		</a>
		<a href="#" title="��ϵ����Ա">
			<div class="link" id="contact"></div>
		</a>
	</div>
</div>
  </body>
</html>
