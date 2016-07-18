<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="comm/incl/incl.jsp"></jsp:include>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html">
<html>
<head>
<title>OA系统登录</title>
<link rel="stylesheet" href="css/login.css" type="text/css"></link>
<script type="text/javascript">
/**鼠标离开文本框是验证填写的数字是否合规*/
$(function() {
	$('#pwd').val('');
	$('.validatebox-text').bind('blur', function() {
		$(this).validatebox('enableValidation').validatebox('validate');
	});
});
/**单击验证码时，重新加载验证码*/
function reloadCodeImg() {
	var img = document.getElementById("ValidateCodeImg");
	img.src = bw.getRootPath()+"/ValidateCode.action?d=" + Math.random() + "";
}
/**用户登录*/
function submitForm() {
	$('#user_login').form('submit', {
		url : bw.getRootPath()+"/UserLoginCheck.action",
		cache : false,
		dataType : 'json',
		onSubmit : function() {
			/**提交前对密码进行md5加密*/
			//$('#pwd').val(bw.md5Encode($('#pwd').val()));
			user_password=bw.md5Encode($('#pwd').val());
			/*提交前先验证填写是否符合规范*/
			return $(this).form('enableValidation').form('validate');
		},
		success : function(r) {
			var res = r;
			res = eval("(" + res + ")");
			console.info(res);
			console.info(res.msg);
			if (res.msg == '登录成功') {
				// "登录验证通过，进入主界面
				console.info('成功');
				window.location.replace("index.jsp");
			} else {
				console.info('失败');
				$('#pwd').val(''); //清空密码
				$('#user_validateCode').val(''); //清空验证码
				reloadCodeImg(); //重新加载验证码
				$.messager.show({
					title:'登录提示',
					msg:res.msg,
					timeout:5000,
					showType:'slide'
				});
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.info(XMLHttpRequest.status);
			console.info(XMLHttpRequest.readyState);
			console.info(textStatus);
		}
	});
}
</script>
</head>
<body>
	<div class="main_panel">
		<form id="user_login" class="easyui-form" method="post" data-options="novalidate:true">
			<div class="user_name_panel">
				<input name="user_name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[2,10]',novalidate:true">
			</div>
			<div class="user_pwd_panel">
				<input name="user_pwd" id="pwd" class="easyui-validatebox textbox" type="password" data-options="required:true,novalidate:true">
			</div>
			<div class="user_validateCode_panel">
				<input name="user_validateCode" id="user_validateCode" class="easyui-validatebox textbox" data-options="required:true,validType:'length[4,4]',novalidate:true">
			</div>
			<div class="user_validateCode_img_panel">
				<a href="#" title="单击更换" onclick="reloadCodeImg();return false;"> <img id="ValidateCodeImg" alt="验证码" src="<%=path%>/ValidateCode.action"> </a>
			</div>
			<div class="user_login_btn">
				<a href="javascript:void(0)" onclick="submitForm()"> <img src="images/login_btn.png"> </a>
			</div>
		</form>
	</div>
</body>
</html>