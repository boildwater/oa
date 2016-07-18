<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>测试系统</title>
<jsp:include page="comm/incl/incl.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		InitMenuTree();
	});
	function InitMenuTree() {
		var nav = $('#nav');
		$.ajax({
			type : "post",
			url : 'menuAction!execute.action',
			cache : false,
			dataType : 'json',
			success : function(r){
				_menus = r;
				/*得到模块名称，循环，每个模块下面设置一颗tree，并初始化tree的url*/
				$.each(_menus, function(i, n) {
					nav.accordion('add', {
						title : n.text,
						content : '<ul id="moduleTree'+n.id+'"></ul>',
						iconCls : n.iconCls
					});
					$('#moduleTree' + n.id).tree({
						url : 'menuAction!execute.action?moduleId=' + n.id,
						lines : false,
						onClick : function(node) {
							addTab(node);
						}
					});
				});
			}
		});
		var centerTabs = $('#centerTabs');
		function addTab(node) {
			/*如果是父节点，则不添加tab，直接返回*/
			if (node.state == 'closed' || node.children) {
				return;
			}
			/*判断tab是否已经打开，如果打开了就选中*/
			if (centerTabs.tabs('exists', node.text)) {
				centerTabs.tabs('select', node.text);
			} else {
				/*不是父节点，也没有打开，则添加tab*/
				/*tab的参数*/
				var opts = {
					title : node.text,
					closable : true,
					iconCls : node.iconCls,
					content : bw.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', node.attributes.url),
					border : false,
					fit : true
				};
				centerTabs.tabs('add', opts);
			}
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 60px;overflow: hidden;">
	</div>
	<div data-options="region:'west',title:'功能导航',split:true" style="width: 200px;overflow: hidden;">
		<div id="nav" class="easyui-accordion" data-options="fit:true,border:false"></div>
	</div>
	<div data-options="region:'east',title:'小工具',split:true,collapsed:true" style="width: 200px;overflow: hidden;"></div>
	<div data-options="region:'center'" style="overflow: hidden;">
		<div id="centerTabs" class="easyui-tabs" data-options="fit:true,border:false"></div>
	</div>
	<div data-options="region:'south'" style="height: 20px;overflow: hidden;text-align: center;">@雷平 since 2016</div>
</body>
</html>
