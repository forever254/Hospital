function getParam(key) {
	var url = location.href;

	var index = url.indexOf('?');

	url = url.substr(index + 1);

	var params = url.split('&');

	for(var i = 0; i < params.length; i++) {
		var x = params[i].split('=');

		if(x[0] == key) {
			return x[1]; 
		}
	}
}

///挂号信息的获取(获得G_id,G_name,当前排队人数,就诊号,K_idFK,D_idFK)
var G_id;

var pid = getParam("Pid");
var url = 'http://127.0.0.1:8080/Hospital/GetGidByPid?P_idFK='+pid+'';
var G_totalmony = 0;
var doctorsay = '';
$.get(url,function(data){
	G_id = data;
	console.log("G_ID"+G_id)
	var url = 'http://127.0.0.1:8080/Hospital/GetRegistrationServlet?G_id='+G_id+'';

	$.getJSON(url,function(data){
		console.log(data);
		$("#gid").val(G_id);
		
		$("#pname").val(data.patient.pname);
		$("#kname").val(data.sub.kname);
		$("#dname").val(data.doctor.dname);
		G_totalmony = data.G_total;
		doctorsay = data.Remarks;
		console.log(G_totalmony);
		
		$("#yszdbg").html(''+doctorsay+'');
		$("#G_totalmj").html(''+G_totalmony+'');
	});
	
	///病人的信息获取(传的是G_id和P_idFK)
	//var url = "http://127.0.0.1:8080/Hospitall/GetPrescriptionServlet";
	//$.getJSON(url,function(data){
	//	
	//});


	///药物明细的内容
	//通过挂号id获取所有的信息
	//药方表的作用保存哪个病人的挂号id和总额，还有就是判断这个挂号单有没有结算
	var url = 'http://127.0.0.1:8080/Hospital/GetDetailByGid?G_idFK='+G_id+'';
	$.getJSON(url,function(data){
		
		console.log(data);
		$.each(data,function(index,data){
			var total=data.med.mprice*data.xynum;
			var htmlstr='';
			htmlstr+='<tr>';
			htmlstr+='	<td>'+data.med.mname+'</td>';
			htmlstr+='	<td>'+data.xynum+'</td>';
			htmlstr+='	<td>'+data.med.mprice+'</td>';
			htmlstr+='	<td>'+total+'</td>';
			htmlstr+='</tr>';		
			$('#ywmx').append(htmlstr);
		});
			
	});

	var url = 'http://127.0.0.1:8080/Hospital/GetJDetailByGidServlet?G_idFK='+G_id+'';
	$.getJSON(url,function(data){
		
		console.log(data);
		$.each(data,function(index,data){
			
			var htmls='';
				htmls+='<tr>';
				htmls+='	<td>'+data.che.jname+'</td>';
				htmls+='	<td>'+data.che.remarks+'</td>';
				htmls+='	<td>'+data.che.jprice+'</td>';
				htmls+='</tr>'
				
				console.log(htmls);
				$('#jcha').append(htmls);	
		});
			
	});
});


