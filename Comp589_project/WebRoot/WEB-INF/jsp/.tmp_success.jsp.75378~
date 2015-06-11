<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/team_select.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jqPaginator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
  
    <title>Basketball Video Management</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./css/listItem.css" rel="stylesheet" media="screen">
    <link href="./css/css.css" rel="stylesheet" media="screen">
    <link href="./css/buttons.css" rel="stylesheet" media="screen">
    <link href="./css/jquery-ui.min.css" rel="stylesheet" media="screen">
    <link href="./css/jquery-ui.structure.min.css" rel="stylesheet" media="screen">
    <link href="./css/jquery-ui.theme.min.css" rel="stylesheet" media="screen">
	
	
	<style type="text/css">
		body{
			width:1300px;
			text-align:center;
            background-color: #468499;
            font-family: Verdana;
            font-size: 13px;
		}
		.container{
			
			width: 95%;
			height: 750px;
		}
		#main{
			border-radius: 2em;
			background-color: #f5f5f5;
			height:85%;
		}
		#left{
			width: 45%;
			height: 100%;
			float: left;
		}
		#right{
			width: 55%;
			height: 100%;
			float: left;
		}
		#match_features {
			padding-left:10px;padding-top:5px; width:100%; height:35%;
		}
		#match_features ul{
			width:450px;list-style:none;float:left; clear:both;
		}
		#match_features li{
			width:150px;list-style:none;float:left; 
		}
		#match_features option{
			width:100px; 
		}
		
	    #hmSelect{width:80%;height:auto;line-height:15px;padding-left:10px;margin-top:5px;}
	    #awSelect{width:80%;height:auto;line-height:15px;padding-left:10px;margin-top:5px;}
		#hmSelect ul{
			width:250px;list-style:none;float:left; clear:both;
		}
		#awSelect ul{
			width:250px;list-style:none;float:left; clear:both;
		}
		#hmSelect li{
			width:100px;list-style:none;float:left; 
		}
		#awSelect li{
			width:100px;list-style:none;float:left; 
			
		}
	</style>
	
  </head>
  
  <body>
    <div class="container" >
    	<div id="header" style="width:95%; height:10%; text-align:center;"><h1 style="color: #f7f7f7;">Video Management</h1></div>
    	<div id="main">
	    	<div id="left" >
    			<form id="searchForm" action="jz233/toSearch.do" method="post">
    			<div id="condition" style="clear:both;height:55%;">
				
					<fieldset><legend>Home Team</legend>
			    		<div id="hmSelect" align="left">
			    			<ul>
							   <li>Conference</li><li><select class="hselC" name="hm_conference"><option>Please Select</option></select></li>
							</ul>	
							<ul>
							   <li>Division</li><li><select class="hselD" name="hm_division"><option>Please Select</option></select></li>
							</ul>	
							<ul> 
							   <li>Team</li><li><select class="hm_name" name="hm_name" style="width:185px;"><option>Please Select</option></select></li>
							</ul>
						</div>
					</fieldset>
					<fieldset><legend>AwayTeam</legend>
			    		<div id="awSelect" align="left">
			    			<ul>
							   <li>Conference</li><li><select class="aselC" name="aw_conference"><option>Please Select</option></select></li>
							</ul>	
							<ul>
							   <li>Division</li><li><select class="aselD" name="aw_division"><option>Please Select</option></select></li>
							</ul>	
							<ul> 
							   <li>Team</li><li><select  class="aw_name" name="aw_name" style="width:185px;"><option>Please Select</option></select></li>
							</ul>
						</div>
					</fieldset>
					<fieldset><legend>Features</legend>
					<div id="match_features" align=left >
						<ul>
							<li>Winner</li>
							<li>
								<select class="winner" name="winner">
									<option value="2">Any</option>
									<option value="1">Home Team</option>
									<option value="0">Away Team</option>
								</select>
							</li>
						</ul>
						<ul>
							<li>Game Style</li>
							<li>
								<select id="game_style">
									<option>Any</option>
									<option>Offensive</option>
									<option>Defensive</option>
								</select>
							</li>
						</ul>
						<ul>
							<li>Game Tempo</li>
							<li>
								<select id="game_tempo">
									<option>Any</option>
									<option>Very Slow</option>
									<option>Slow</option>
									<option>Medium</option>
									<option>Fast</option>
									<option>Very Fast</option>
								</select>
							</li>
						</ul>
						<ul>
							<li>Game Intensity</li>
							<li>
								<select id="game_intensity">
									<option>Any</option>
									<option>Very Weak</option>
									<option>Weak</option>
									<option>Medium</option>
									<option>Strong</option>
									<option>Very Strong</option>
								</select>
							</li>
						</ul>
						<ul>
							<li>Duration</li>
							<li>
								<select id="game_duration">
									<option>Any</option>
									<option>Regular Time</option>
									<option>1 OT</option>
									<option>2 OTs</option>
									<option>2+ OTs</option>
								</select>
							</li>
						</ul>
						<ul>
							<li>Match Date</li>	
							<li><input type="text" id="match_date" name="match_date" readonly></li>
						</ul>
					</div>
						
				</fieldset>
				<!--<div><input type="reset" id="reset" class="button button-square button-tiny" value="reset"></div>-->
				<button id="resetForm" type="button" class="button button-3d button-action button-pill" >Reset</button>
				</div>
				
				<div style="clear:both;"></div>
				
				
			</form>
			</div>
			<div id="right">
		    	<div style="width:100%; height:95%;">
		    		<ul style="list-style-type:none; clear:both;">
						<li style="float:left"><b>Search Result</b></li>
					</ul>
					
					<!-- 清理浮动-->
					<div style="clear:both;"></div>
					<!-- “载入中”图标-->
					<div class="search-background">
						<label><img src="./css/images/loader.gif" alt="" /></label>
					</div>
					<!-- 
						显示搜索结果
					-->
			    	<div id="listInfo" style="height:85%; width:100%; display:block;"></div>	
					<!-- 清理浮动-->
					<div style="clear:both;"></div>
					<!--
						显示页码
					-->
					<div class="pagination" id="pagination1"></div>						
	  		  	</div>
			</div>
	 	</div> 
   </div>
   
  </body>
  
  <script type="text/javascript">
   
	  function bring ( selecter ){	
			$('div.picTextGroup:eq(' + selecter + ')').stop().animate({		//出现列表时相关动画
				opacity  : '1.0', height: '80px'
			},"slow",function(){
				if(selecter < 6){ clearTimeout(Timer); }
			});
			selecter++;
			var Func = function(){ bring(selecter); };
			Timer = setTimeout(Func, 20);
		}
		function showLoader(){
			$('.search-background').fadeIn(200);
		}
		function hideLoader(){
			$('.search-background').fadeOut(200);
		};
	  
	   var returnData;
	   function setReturnData(rd){
			returnData = rd;
	   }
	   function getReturnData(){
	   		return returnData;
	   }
	  
	   
	   $(".hselC,.hselD,.aselC,.aselD,.hm_name,.aw_name,#match_date,.winner").die().live("change",function(){
			$("#listInfo,.pagination").empty();
			$("form").submit(doSearch());
		});
	  
	   $("#resetForm").click(function(){
	   		$("#listInfo,.pagination").empty();
			$("#searchForm")[0].reset();
			//$("form").submit(defaultSearch());	//controller中单独定义请求url
	   });	
	 /*
	   function defaultSearch(){
				
				$.post("${pageContext.request.contextPath}/jz233/toSearch.do",
							
							function(data){
								setReturnData(data); 
								setPageCount();	
								getDataByPage(1,data);
							}
					);
		 }	 
		 */
	    function doSearch(){
				var formData = $("form").serialize();
				$.post("${pageContext.request.contextPath}/jz233/toSearch.do",
							formData,
							function(data){
								setReturnData(data); 
								setPageCount();	
								getDataByPage(1,data);
							}
					);
		 }	 
		
		function setPageCount(){
			
			var rData = getReturnData();
			var info='<ul>';
			var count = Math.ceil(rData.length/6);
			$.jqPaginator('#pagination1', {
		        totalPages: count,
		        visiblePages: 8,
		        currentPage: 1,
		        onPageChange: function (num, type) {
					showLoader();
					getDataByPage(num,rData);
		        }
		    });
		}
		
		function getDataByPage(page,data1){
			var info = '';	
			$("#listInfo").empty();	//标签内容置空
			var lastIdx = 0;

		    for (var i=(page-1)*6; i<=(((data1.length!=page*6)&&(page==Math.ceil(data1.length/6)))?(data1.length-1):(page*6-1)); i++) {
			   /*info += "<div class=picTextGroup><p><a href=\"\" target=_blank><img height=70 alt=NBA src=\""
			  	 + data1[i].imgUrl
			    + "\" width=70 border=0></a><span class=\"title\"><a href='${pageContext.request.contextPath}/jz233/toDetails.do?match_id="+ data1[i].matchId +"' target=_self>"
			   +data1[i].hmName+"&nbsp;&nbsp;&nbsp;&nbsp;"+data1[i].hmScore+"&nbsp;&nbsp;&nbsp;&nbsp;"
			   +data1[i].awScore+"&nbsp;&nbsp;&nbsp;&nbsp;"+data1[i].awName+
			   "</a></span><br></p></div>"; */
			    info += "<div class=picTextGroup><a href='${pageContext.request.contextPath}/jz233/toDetails.do?match_id="+ data1[i].matchId +"' target=_self><img height=70 alt=NBA src=\""
			  	 + data1[i].imgUrl+ "\" width=70 border=0></a><div class=\"title\"><a href='${pageContext.request.contextPath}/jz233/toDetails.do?match_id="+ data1[i].matchId +"' target=_self>"
			   +"<div>"+data1[i].hmName+"</div><div>"+data1[i].hmScore+"</div><div>"
			   +data1[i].awScore+"</div><div>"+data1[i].awName+
			   "</div></a></div><div class='matchDate'></div><br></div>";   
		     }
		     $("#listInfo").html(info);
			 
			 var Timer  = '';
			 var selecter = 0;
			 bring(selecter);
			 
			 hideLoader();
		}
		
		var date_picker = $("#match_date").datepicker({
			showOn: "focus",
			dateFormat:"yy-mm-dd",
			onSelect: function(dateText,date_picker){
				$(this).change();
			}
		}).on("change",function(){
			$("#listInfo,.pagination").empty();$("form").submit(doSearch());
		});
		 
//		 function toDetail(match_id){
//		 	$.ajax({
//				url:'${pageContext.request.contextPath}/jz233/toDetails.do',
//				type:'GET',
//				data:{
//					match_id: match_id
//				},
//				success:function(){window.location.href=}
//			});
//		 }
		
  </script>	
</html>
