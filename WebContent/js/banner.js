$(document).ready(function(){
						   
	var animateDone=true;
	
	function getInDirectionTween(e,moveDirecrion,moveInSpeed,moveInType){
		moveInSpeed=parseInt(moveInSpeed);
		e.css("opacity","0");
		switch(moveDirecrion){
			case'0':e.css("left","0").css("top","0");
			e.animate({"left":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'1':e.css("left","0").css("top","-460px");
			e.animate({"top":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'2':e.css("left","460px").css("top","-460px");
			e.animate({"top":"0","left":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'3':e.css("left","460px").css("top","0");
			e.animate({"left":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'4':e.css("left","460px").css("top","460px");
			e.animate({"left":"0","top":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'5':e.css("left","0").css("top","460px");
			e.animate({"top":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'6':e.css("left","-460px").css("top","460px");
			e.animate({"left":"0","top":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'7':e.css("left","-460px").css("top","0");
			e.animate({"left":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'8':e.css("left","-460px").css("top","-460px");
			e.animate({"left":"0","top":"0","opacity":"1"},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
		}
	}

	function getOutDirectionTween(e,moveDirecrion,moveInSpeed,moveInType){
		moveInSpeed=parseInt(moveInSpeed);
		switch(moveDirecrion){
			case'0':e.animate({"left":"0","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'1':e.animate({"left":"0","top":"-460px","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'2':e.animate({"top":"-460px","left":"460px","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'3':e.animate({"left":"460px","top":"0","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'4':e.animate({"left":"460px","top":"460px","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'5':e.animate({"top":"460px","left":"0","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'6':e.animate({"left":"-460px","top":"460px","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'7':e.animate({"left":"-460px","top":"0","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
			case'8':e.animate({"left":"-460px","top":"-460px","opacity":0},{
				duration:moveInSpeed,easing:moveInType
			});
			break;
		}
	}

	function animateIn(e){
		var moveInDerection=e.attr('moveInDerection');
		var moveInSpeed=e.attr('moveInSpeed');
		var moveInType=e.attr('moveInType');
		getInDirectionTween(e,moveInDerection,moveInSpeed,moveInType);
	}
	
	function animateOut(e){
		var moveOutDerection=e.attr('moveOutDerection');
		var moveOutSpeed=e.attr('moveOutSpeed');
		var moveOutType=e.attr('moveOutType');
		getOutDirectionTween(e,moveOutDerection,moveOutSpeed,moveOutType);
	}
	
	function getMaxFromArray(arr){
		var max=arr[0];
		for(i=0;i<arr.length;i++){
			if(arr[i]>max)
			max=arr[i];
		}
		return max;
	}
	
	$(".banner-bt .pointer").click(function(){
		var currentClick=false;
		var current=$(".banner-bt").find(".active");
		var pretarget=current.attr("target");
		var target=$(this).attr("target");
		if(pretarget==target)currentClick=true;
		if(!currentClick){
			if(animateDone){
				current.removeClass("active");
				$(this).addClass("active");
				animateDone=false;
				var preObjectLeft=$(".left"+pretarget);
				var preObjectRight=$(".right"+pretarget);
				var objectLeft=$(".left"+target);
				var objectRight=$(".right"+target);
				preObjectLeft.css("z-index","0");
				preObjectRight.css("z-index","0");
				objectLeft.css("z-index","9999");
				objectRight.css("z-index","9999");
				var speedArray=[objectLeft.attr('moveInSpeed'),objectLeft.attr('fadeInSpeed'),objectRight.attr('moveInSpeed'),objectRight.attr('fadeInSpeed'),];
				var animateTime=parseInt(getMaxFromArray(speedArray))+1000;
				animateOut(preObjectLeft);
				animateOut(preObjectRight);
				animateIn(objectLeft);
				animateIn(objectRight);
				setTimeout(animateDoneFunction,animateTime);
			}
		}
	});
	
	function animateDoneFunction(){
		animateDone=true;
	}
	
	function initilAnimate(){
		$($(".banner-bt .pointer")[0]).click();
		var autoSwitch=function(){
			$(".banner-bt .pointer").each(function(e){
				if($(this).hasClass("active")){
					if(e==6)
					$(".banner-bt .pointer:eq(0)").click();else
					$(".banner-bt .pointer:eq("+(e+1)+")").click();
				}else{}
			});
		}
		window.setInterval(autoSwitch,3750);
	}
	
	initilAnimate();

});

