<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/icheck.min.js"></script>
        <title>Match Details</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <link href="./css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="./css/cmtListItem.css" rel="stylesheet" media="screen">
        <link href="./css/square/blue.css" rel="stylesheet" media="screen">
        <style type="text/css">
            body {
            	width:1300px;
                background-color: #666666;
                font-family: Verdana;
                font-size: 13px;
            } 
			.container {
                width: 95%;
                height: 1300px;
            } 
			#main {
                height: 85%;
            } 
			#left {
                width: 45.5%;
                height: 100%;
                float: left;
            } 
			#right {
                width: 54%;
                height: 100%;
                float: right;
            } 
			#video {
				background-color: #f5f5f5;
				border-radius: 0.7em;
                padding: 3%;
                width: 100%;
                height: 30%;
            } 
			#infoandfeature{
				display:block;
				text-align:center;
				background-color: #f5f5f5;
				border-radius: 0.7em;
                padding: 3%;
                width: 100%;
                height: 15%;
			}
			.row1 {
				padding-top:5%;
				height:35%;
			}
			.row2{
				padding-top:8%;
				height:40%;
			}
			.row1 .hm .aw .date {
				width: 20%;
				display:inline-block;
			}
			.row2 .styleIdx .tempoIdx .intensityIdx{
				width:25%;
				display:inline-block;
			}
			#review {
				background-color: #f5f5f5;
				border-radius: 0.7em;
                padding: 3%;
                width: 100%;
				text-align:justify;
                height: auto;
				
            } 
			.comment {
                width: 90%;
            }  
			
			#comment_section{
				height:300px;
				background-color: #f5f5f5;
				border-radius: 0.7em;
			}
			#comment_header{
				width: 95%;
				height: 10%;
				text-align:center;
				font-size:25px;
			}
			#commentList{
				background-color: #f5f5f5;
				border-radius: 0.7em;
				padding:25px;
				margin:0 auto;
			}
			
			.features div{
				margin-top: 5px;
				margin-left: 20px;
			}
			.features span{
				margin-left: 5px;
			}
        </style>
    </head>
    
    <body>
        <div class="container">
            <div id="header" style="width:95%; height:5%; text-align:center;">
                <a href="jz233/toMatchInfo.do" ><img style="position: absolute; top: 5px; left:150px;width:100px;height:100px;float:left;" src="./css/images/basketball-icon.png"></img></a><h1 id="page_title" style="color: #f7f7f7;">Match Details</h1>
            </div>
            <div id="main">
                <!-- news & video section-->
                <div id="left">
                    <div id="video">
                        <iframe width="500" height="300" src="https://www.youtube.com/embed/y-j_XzzueEs" frameborder="0">
                        </iframe>
                    </div>
					<div style="height: 0.5%;"></div>
					<div id="infoandfeature">
						<div class="row1">
							<div class="hm" style="font-size:25px; width:10%;display:inline-block;"></div>
							<div class="hmScore" style="font-size:18px; width:15%;display:inline-block;"></div>
							<div class="date" style="font-size:15px;width:20%;display:inline-block;"></div>
							<div class="awScore" style="font-size:18px; width:15%;display:inline-block;"></div>
							<div class="aw" style="font-size:25px; width:10%;display:inline-block;"></div>

						</div>
						<div class="row2">
							<div class="styleIdx" style="width:28%;display:inline-block;"></div>
							<div class="tempoIdx" style="width:28%;display:inline-block;"></div>
							<div class="intensityIdx" style="width:28%;display:inline-block;"></div>
						</div>
					</div>
					<div style="height: 0.5%;"></div>
                    <div id="review" style="overflow-x:auto;overflow-y:auto;">
                        <h5 style="text-align:center;"><b class="title">   	</b></h5>
                        <span class="scroll">   	 </span>
                    </div>
                </div>
				<div style="width: 0.5%; "></div>
                <!-- comment section-->
                <div id="right">
                	<div id="comment_section">
						<div id="comment_header">Comments</div>
	                	<form id="comment_form" class="comment_form" method="post" >
	                		<div class="features">
	                			<div>
	                    			<input type="hidden" name="matchid" value="${matchid}">
								</div>
		                        <div class="style">
		                            <input type="radio" name="style" value="0"><span>Offensive</span><input type="radio" name="style" value="1"><span>Defensive</span>
		                        </div>
		                        <div class="tempo">
		                            <input type="radio" name="tempo" value="0"><span>Very Slow</span><input type="radio" name="tempo" value="1"><span>Slow</span><input type="radio" name="tempo" value="2"><span>Medium</span> <input type="radio" name="tempo" value="3"><span>Fast</span><input type="radio" name="tempo" value="4"><span>Very Fast</span>
		                        </div>
		                        <div class="intensity">
		                            <input type="radio" name="intensity" value="0"><span>Very Weak</span><input type="radio" name="intensity" value="1"><span>Weak</span><input type="radio" name="intensity" value="2"><span>Medium</span><input type="radio" name="intensity" value="3"><span>Strong</span><input type="radio" name="intensity" value="4"><span>Very Strong</span>
		                        </div>
	                       
	                            <div class="comment">
	                                <textarea rows="5" style="width: 100%;" name="description"></textarea>
	                            </div>
								<div>
									<input id="submit_comment" type="button" value="Submit!"  style="float:right; margin-right:30px; margin-top:2%;">
								</div>
	                   	 	</div>
						</form>
					</div>
					<div style="clear:both;height:5px;"></div>
					<div id="commentList">
					</div>
                </div>
            </div>
        </div>
    </body>
	<script type="text/javascript">
		var resReview = [];	//array
		var latestTimeStamp;
		var count = 0;
		var new_idx = 0;
		$(document).ready(
			function(){
				$('input').iCheck({
				    radioClass: 'iradio_square-blue',
				    increaseArea: '20%' // optional
				  });
				  
				$.get("${pageContext.request.contextPath}/jz233/toQueryReview.do?matchid=" + '${matchid}',
					function(response){
						$(".title").html(response.title);
						resReview = response.review;
						console.log(resReview[2]);
						loadPage();
				});
				loadMatchInfoAndFeature();
				loadComments();
				longPolling();
			}
			
		);
		function loadPage(){
			
			for(var i=0; i<7 && i<resReview.length;i++){
				$(".scroll").append(resReview[i]);
				if(i == 6){
					$(".scroll").append("<a class=\"more\" href=\"javascript:return false;\">Read More</a>");
					$(".more").live("click",function(){
						$(".more").remove();
						var appendedText = "";
						for(var j=7; j<resReview.length;j++){
							appendedText = resReview[j];
							$(appendedText).appendTo('.scroll').hide().fadeIn('slow');
						}
					});
				}
			}
		}
		function loadMatchInfoAndFeature(){
			$.ajax({
				url: "${pageContext.request.contextPath}/jz233/toLoadMatchInfoAndFeature.do", 
				type: "GET",
				data: {
					matchid: '${matchid}'
				},
				success: function(data){ 	//InfoAndFeature object
					if(data.hmWin==true){
						$(".hm").css({'color':'#e80000','font-size':'30px'});
						$(".hmScore").css({'color':'#e80000','font-size':'20px'});
					}else{
						$(".aw").css({'color':'#e80000','font-size':'30px'});
						$(".awScore").css({'color':'#e80000','font-size':'20px'});					}
					$(".hm").text(data.hmName);
					$(".hmScore").text(data.hmScore);
					$(".date").text(data.matchDate);
					$(".aw").text(data.awName);
					$(".awScore").text(data.awScore);
					if(data.commentCounts == 0){
						$(".styleIdx").text("N/A");
						$(".tempoIdx").text("N/A");
						$(".intensityIdx").text("N/A");
					}else{
						if(data.styleIdx==0){
							$(".styleIdx").text("Offensive");
						}else{
							$(".styleIdx").text("Defensive");
						}
						switch(data.tempoIdx){
							case 0:
								$(".tempoIdx").text("Very Slow Tempo"); break;
							case 1:
								$(".tempoIdx").text("Slow Tempo"); break;
							case 2:
								$(".tempoIdx").text("Medium Tempo"); break;
							case 3:
								$(".tempoIdx").text("Fast Tempo"); break;
							case 4:
								$(".tempoIdx").text("Very Fast Tempo"); break;
						}
						switch(data.intensityIdx){
							case 0:
								$(".intensityIdx").text("Very Weak Intensity"); break;
							case 1:
								$(".intensityIdx").text("Weak Intensity"); break;
							case 2:
								$(".intensityIdx").text("Medium Intensity"); break;
							case 3:
								$(".intensityIdx").text("Strong Intensity"); break;
							case 4:
								$(".intensityIdx").text("Very Strong Intensity"); break;
							
						}
					}
					
					
				}
			});
				
		}
		$("#submit_comment").click(function(){
			if(!$("input:radio[name='style']").is(":checked")||!$("input:radio[name='tempo']").is(":checked")||!$("input:radio[name='intensity']").is(":checked")){
				alert('please select one option for each feature');
				return false;
			}
			var formData = $("#comment_form").serialize();	
			console.log(formData);
			$.post("${pageContext.request.contextPath}/jz233/toComment.do",
							formData,
							function(data){
								console.log(data);
								$("#comment_form").trigger('reset');
							}
							
			).fail(function(){alert("error");});
			$("#comment_form").reset();
		});
		
		function loadComments(){
			$.ajax({
				url: "${pageContext.request.contextPath}/jz233/toLoadComments.do",		//order by timestamp
				type: "GET",
				async: false,
				data: {
					matchid: '${matchid}'
				},
				success: function(response){		//comment list
					if(response==null){
						console.log('response is null');
					}
					showList(response);
					console.log("load comments succeed");
				},
				error: function(){console.log('load comment error');}
				
			});
		}
		function showList(cmtList){
			var info = "";
			var style="";
			var tempo="";
			var intensity="";
			if(cmtList.length==0){
				latestTimeStamp = new Date().getTime();
				console.log('no comment, lastestTimeStamp=' + latestTimeStamp);
				info="<div id='no_comment' style='width:80%;height:120px;'>No comment on this match.</div>";
			}else{
				$.each(cmtList,function(index, object){
					if(index==0){
						latestTimeStamp = object.commentTime;	
					}
					switch(object.matchStyle){
						case 0:
							style = "Offensive"; break;
						case 1:
							style = "Defensive"; break;
					}
					switch(object.matchTempo){
						case 0:
							tempo = "Very Slow"; break;
						case 1:
							tempo = "Slow"; break;
						case 2:
							tempo = "Medium"; break;
						case 3:
							tempo = "Fast"; break;
						case 4:
							tempo = "Very Fast"; break;
					}
					switch(object.matchIntensity){
						case 0:
							intensity = "Very Weak"; break;
						case 1:
							intensity = "Weak"; break;
						case 2:
							intensity = "Medium"; break;
						case 3:
							intensity = "Strong"; break;
						case 4:
							intensity = "Very Strong"; break;
					}
					info += "<div class=\"cmtContainer\"><div class='cmtContent'><div class=\"cmtUser\">User posted at		"
					+(new Date(object.commentTime)).toLocaleString()+"</div><div class=\"cmtComment\">"
					+object.description+"</div></div><div class=\"cmtFeature\"><div class=\"cmtStyle\" style='margin-top:10px;'>"
					+style+"</div><div class=\"cmtTempo\" style='margin-top:10px;'>"
					+tempo+"</div><div class=\"cmtIntensity\" style='margin-top:10px;'>"
					+intensity+"</div></div></div>";
				});
			}
			
			$("#commentList").html(info);
		}
		function longPolling() {
                $.ajax({
                    url: "${pageContext.request.contextPath}/jz233/toListenNewComments.do",
					type: "GET",
                    data: {
						matchid: '${matchid}',
						latestTimeStamp:  latestTimeStamp	//initial value is the last comment timestamp, will change afterwards
					},
                    timeout: 5000,
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        if (textStatus == "timeout") { 
							console.log("timeout");
                            longPolling(); // 递归调用
                        } else { 
							console.log("error, textStatus:"+textStatus+" " + latestTimeStamp),
                            longPolling();
                        }
                    },
                    success: function (data, textStatus) {
                        if (textStatus == "success") { // 请求成功
                            console.log("success");
							var info = "";
							var style="";
							var tempo="";
							var intensity="";
							console.log(data.length);
							if(data.length >0){	//
								$.each(data, function(index, object){
									if(index==0){
										latestTimeStamp = object.commentTime;
									}
									switch(object.matchStyle){
										case 0:
											style = "Offensive"; break;
										case 1:
											style = "Defensive"; break;
									}
									switch(object.matchTempo){
										case 0:
											tempo = "Very Slow"; break;
										case 1:
											tempo = "Slow"; break;
										case 2:
											tempo = "Medium"; break;
										case 3:
											tempo = "Fast"; break;
										case 4:
											tempo = "Very Fast"; break;
									}
									switch(object.matchIntensity){
										case 0:
											intensity = "Very Weak"; break;
										case 1:
											intensity = "Weak"; break;
										case 2:
											intensity = "Medium"; break;
										case 3:
											intensity = "Strong"; break;
										case 4:
											intensity = "Very Strong"; break;
									}
									$("#no_comment").remove();
									info += "<div id='comment_new_"+new_idx+"' class=\"cmtContainer\"><div class='cmtContent'><div class=\"cmtUser\">User posted at		"
									+(new Date(object.commentTime)).toLocaleString()+"</div><div class=\"cmtComment\">"
									+object.description+"</div></div><div class=\"cmtFeature\"><div class=\"cmtStyle\" style='margin-top:10px;'>"
									+style+"</div><div class=\"cmtTempo\" style='margin-top:10px;'>"
									+tempo+"</div><div class=\"cmtIntensity\" style='margin-top:10px;'>"
									+intensity+"</div></div></div>";
								});
								$("#commentList").prepend(info);
								blink("#comment_new_"+new_idx);
								
								if(data[0].styleIdx==0){
									$(".styleIdx").text("Offensive");
								}else{
									$(".styleIdx").text("Defensive");
								}
								switch(data[0].tempoIdx){
									case 0:
										$(".tempoIdx").text("Very Slow Tempo"); break;
									case 1:
										$(".tempoIdx").text("Slow Tempo"); break;
									case 2:
										$(".tempoIdx").text("Medium Tempo"); break;
									case 3:
										$(".tempoIdx").text("Fast Tempo"); break;
									case 4:
										$(".tempoIdx").text("Very Fast Tempo"); break;
								}
								switch(data[0].intensityIdx){
									case 0:
										$(".intensityIdx").text("Very Weak Intensity"); break;
									case 1:
										$(".intensityIdx").text("Weak Intensity"); break;
									case 2:
										$(".intensityIdx").text("Medium Intensity"); break;
									case 3:
										$(".intensityIdx").text("Strong Intensity"); break;
									case 4:
										$(".intensityIdx").text("Very Strong Intensity"); break;
									
								}
							}
							setTimeout(longPolling,3000);
							
                        }
                    }
                });
			}
			
			function blink(selector){
				if(count==3){
					count = 0;
					new_idx ++;
					return false;
				} 
				$(selector).fadeOut('slow', function(){
				    $(this).fadeIn('slow', function(){
						count++;
				        blink(this);
				    });
				});
			}
    </script>
</html>
