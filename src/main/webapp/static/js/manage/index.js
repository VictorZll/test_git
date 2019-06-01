$(function(){
	$("#pf-hd .pf-user .xiala ").click(function(){
		console.log(1);
	    $("#pf-hd .pf-user .xiala ").animate({"color":"red","display":"inline-block"},1000);	
	});
	$("#pf-bd .slide-nav li").mouseover(function(){
		$(this).addClass("current").siblings().removeClass("current");
	});

});