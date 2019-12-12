/**
 * 
 */
			$('#addBtn').click(function() {
				var url = baseUrl+'/AddPatientServlet';
				var parms = {
					P_name: $('#pName').val(),
					P_age: $('#pAge').val(),
					P_sex: $('#pSex').val(),
					P_phone: $('#pPhone').val(),

				};
				var temp = parms.P_name;
				var temp2 = parms.P_phone;
				$.post(url, parms, function(data) {
						alert('增加成功加入');
						$('#hidebtn').remove;
						var opt='<iframe src="http://127.0.0.1:8080/Hospital/newAddRegistration.html?' + 'pname=' + temp + "&pphone=" + temp2 +'" class="col-md-12 col-sm-12" width="100%" height="350" frameborder="0" style="border:0;" allowfullscreen></iframe>'
						
						$('#tsk').append(opt);
					//	location.href = "newAddRegistration.html?" + "pname=" + temp + "&pphone=" + temp2;
					})
					.error(function() {
						alert("增加失败");
					});
			});