//在tbl_gua表中，通过查询D_idFK，获取当前的挂号人的信息
//
var doctorid ;
var G_idfk;
$("#gets").click(function(){
	var url="http://127.0.0.1:8080/Hospital/QueryRegistrationServlet"
$.getJSON(url,function(data){
	var num=0;
	$.each(data, function(index,d) {
	var url = "http://127.0.0.1:8080/Hospital/GetGidByPid";
		var id=$("#ysid").val();
		doctorid = id;
		if(d.doctor.did==id){		
		var url='http://127.0.0.1:8080/Hospital/GetPatientServlet?pId='+d.patient.pid+'';
		var i=0;
		
		$.getJSON(url,function(data){
			num++;
			var html='';
				html+='<tr><td id="pname'+num+'">'+data.pname+'</td><td   id="pid'+num+'">'+data.pid+'</td><td><input class="btn btn-default" type="button" id="pbutton'+num+'" value="叫号" /></td></tr>';
			$('#pdxx_table').append(html);
			$("#dxx_table").trigger("create");
			$('#pbutton'+num+'').click(function(){
				var id = $(this).attr("id");
				var num = id.substr(7); 			
				var pid = $('#pid'+num+'').html();
				var urls = 'http://127.0.0.1:8080/Hospital/GetGidByPid?P_idFK='+pid;
				$.get(urls,function(data){
					G_idFK=data;
				});
				var url='http://127.0.0.1:8080/Hospital/GetPatientServlet?pId='+pid+'';
				$.getJSON(url,function(data){
					
						document.getElementById("brname").innerHTML = data.pname;
						document.getElementById("brage").innerHTML = data.page;
						document.getElementById("brsex").innerHTML = data.psex;
						document.getElementById("brphone").innerHTML = data.pphone;
						document.getElementById("brphone").innerHTML = data.pphone;
						document.getElementById("brpid").innerHTML = data.pid;

				});
				
			});
		});
		}		
	});
	var hts="";
		hts+='HAPPY DAYS'+$("#ysname").val()+'';
	$("#h3").empty();
	$("#h3").append(hts);
});
});

//------------------------------------------------------------------------//
var url = "http://127.0.0.1:8080/Hospital/QueryCheckServlet";

$.getJSON(url,function(data){
	
	$.each(data,function(index,m){
		if(m.jid!=500){
			var htm='';
			htm+='<li>';
			htm+='<span style="width:100px; display:inline-block"><a id="'+m.jname+'" style="color:white">'+m.jname+'</a></span><button id="bt'+m.jid+'">添加检查</button>';
			htm+='</li>';
			$("#xmjc").append(htm);
			
			$('#bt'+m.jid+'').click(function(){
				var html='<tr id="tr'+m.jid+'">';
					html+='	<td>'+m.jname+'</td>';
					html+='<td>'+m.jremark+'</td>';
					html+='<td><button id="bt'+m.jid+'"><font color="red">x</font></button></td>';
					html+='</tr>';
					$("#jctable").append(html);
					$('#jctable').on('click','#bt'+m.jid+'',dian);
					
					function dian(){
						var id = $(this).attr("id");
						var num = id.substr(2);
						$('#tr'+num+'').remove();
						
					}
			});
		}
		
	});
	
});

//------------------------------------------------------------------------//

//往数据库插入的信息有TBL_b的J_idFK,P_idFK,G_idFK
//tbl_xy的G_idFK,M_idFK,xy_num,xy_content
//tbl_km的G_idFK,KM_total
//tbl_gua的G_remarks



$("#scbg").click(function(){
		
	var jnum=311;
	
	
	var yszdbg = $("#textarea").val()+$("#cg").html();
	
	var parmstoupdate = {
			
	}
	var G_totaljian = 0;
	for(var i=0;i<6;i++)
		{			
			if($('#tr'+jnum+'').val()!=null){
				var parms = {
						J_idFK : jnum,
						G_idFK : G_idFK,
						Remarks: 0
					}
				var url="http://127.0.0.1:8080/Hospital/AddJDetailServlet"
					$.ajax({
						type:"POST",
						url:url,
						async:false,
						data:parms		
					})
					.success(function(){
						console.log("jum"+jnum);
						var url='http://127.0.0.1:8080/Hospital/QueryCheckServlet';
						$.ajax({
							type:"GET",
							url:url,
							async:false,	
						})
						.success(function(data){
							
							$.each(data,function(index,data){
								
									if(data.jid == jnum){
										G_totaljian += data.jprice;
									}
								
								
							});
						});
						
					});	
			}
			jnum++;
		}
	
	var mednum=1210;
	var G_totalyao=0;
	var medmany = 0;
	for(var i=0;i<20;i++)
		{			
			
			if($('#t'+mednum+'').val()!=null){
				var parms = {
						M_idFK : mednum,
						G_idFK : G_idFK,
						XY_num : $('#txt'+mednum).val()
					}
				medmany = $('#txt'+mednum).val();
				var url="http://127.0.0.1:8080/Hospital/AddDetailServlet";
				$.ajax({
					type:"POST",
					url:url,
					async:false,
					data:parms		
				})
				.success(function(){
						
						var url='http://127.0.0.1:8080/Hospital/GetDetailServlet?G_idFK='+G_idFK+'&M_idFK='+mednum+'';
						$.ajax({
							type:"GET",
							url:url,
							async:false,
								
						})
						.success(function(data){
				
							G_totalyao += data.med.mprice*medmany;
						});
				});
			
			}
			mednum++;
		}
	var  G_total = G_totalyao+G_totaljian ;
	var parmsto = {
			G_idFK : G_idFK,
			G_total : G_total,
			G_remarks : yszdbg
	}
	var url = 'http://127.0.0.1:8080/Hospital/UpdateMoneyServlet';
	$.ajax({
		type:"POST",
		url:url,
		async:false,
		data:parmsto	
	})
	.success(function(){
		console.log("成功了");
	});
});

