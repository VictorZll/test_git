<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!-- 此页面展示查询的所有数据 -->
<head>
<base href="<%=basePath%>"></base>
<style>
td {
	padding: 6px 40px;
}

tr:hover {
	background: linear-gradient(to right, orange, white);
	color: white;
}

a {
	text-decoration: none;
	color: white;
	background: purple;
	display: inline-block;
	text-align: center;
	line-height: 20px;
	border-radius: 5px;
	font-size: 14px;
	padding: 2px 6px;
}

a:hover {
	color: pink;
	background: green;
}

a:visited {
	color: pink;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="static/easyui/themes/icon.css">
<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script>
$(function(){
	$.get(
	"getById",
	{id:2},
	function(data){
		console.log(data);
	},
	"json"
	)
});
function remove(stuid){
	var isDelete=confirm("是否删除id是"+stuid+"的学生信息");
	if(isDelete){
		//使用location跳转到删除操作的jsp中，并将学号通过参数的方式传递给执行删除操作的jsp
		//location.href="manager/deleteStu.do?stuNo="+stuNo ;
		//使用ajax
		$.get(
			"removeById",
			{id:stuid},
			function(data){
				console.log(data);
				if(data){
					$.messager.show({
						title:'我的消息',
						msg:'消息将在0.5秒后关闭。',
						timeout:500,
						showType:'slide'
					});
					loadData();
				}
			},
			"json"
	)
	}
}
function updateStudent(stuNo){
	var isUpdate=confirm("是否修改学号是"+stuNo+"的学生信息");
	if(isUpdate){
		//使用location跳转到删除操作的jsp中，并将学号通过参数的方式传递给执行删除操作的jsp
		location.href="manager/getStuById.do?action=update&stuNo="+stuNo ;
	}
}
function edit(stuid){
	location.href="editById?id="+stuid;
}
function loadData(){
	$("#dg").datagrid({
		url:"listByPage",
	 	//toolbar:"#tb",//设置工具条
	    striped:true,//将行的展示条纹化
	    nowrap:false,//设置内容过多时是否换行，false是换行，true是不换行
	    loadMsg:"正在加载，请稍等.....",//设置加载数据时的提示信息
	    pagination:true,//设置显示分页工具条
	    rownumbers:true,//设置是否显示行号
	    singleSelect:true,//设置是否只能选中一行
	    pageNumber:1,//设置起始页码
	    pageSize:10,//设置每页展示的条数
	    pageList:[5,10,15],//设置每页展示展示的条数的下拉列表
	columns:[[
		//字段名。标题名。宽
		{field:"stuno",title:"学号",width:100},
		{field:"stuname",title:"姓名",width:100},
		{field:"stusex",title:"性别",width:100},//taxOrganId
		{field:"stuage",title:"年龄",width:100},//industryId
  		{field:"stuid",title:"id",width:100},
		{field:"operation",title:"操作",width:200,
			formatter: function(value,row,index){
				return "<a href='javascript:edit("+row.stuid+");'>修改</a>"+
				"&emsp;<a href='javascript:remove("+row.stuid+");'>删除</a>"+
				"&emsp;<a href='javascript:addTask("+row.stuid+");'>新增任务</a>";
				
		}}
	]]	
	});
}

$(function(){
	loadData();
});
</script>
</head>
<body>
	<form action="">
		<table id="dg" >
		
		</table>
	</form>
</body>
</html>