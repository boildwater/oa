<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE HTML">
<jsp:include page="${contextPath}/comm/incl/incl.jsp"></jsp:include>
<html>
  <head>
  <script type="text/javascript">
   $(function(){
	   $('#resourceManager_treegrid').treegrid({
		    url:'menuAction!getMenuTreeGrid.action?parentId=0',
		    idField:'id',
		    treeField:'name',
		    rownumbers:true,
		    pagination:true,
		    fitColumns:true,
		    autoRowHeight:true,
		    columns:[[
		        {field:'name',title:'资源名称',width:'20%'},
		        {field:'iconCls',title:'图标名称',width:'20%',align:'right'},
		        {field:'url',title:'资源地址',width:'30%'},
		        {field:'description',title:'资源描述',width:80}
		    ]]
		});
   });
  </script>
  </head>
  <body>
  
  <table id="resourceManager_treegrid"></table>
  </body>
</html>
