$('#gbn').click(function() {
	window.location.href = "Menu.html";
});
var url = baseUrl + '/QueryPatientServlet';

$.getJSON(url, function(data) {

	var htmlStr = '';

	var k = 0;
	$.each(data, function(index, item) {
		//拼接html字符串
		k++;
		htmlStr = '';
		htmlStr += '<tr id="patient' + k + '">';
		htmlStr += '	<td>' + item.pid + '</td>';
		htmlStr += '	<td>' + item.pname + '</td>';
		htmlStr += '	<td>' + item.page + '</td>';
		htmlStr += '	<td>' + item.psex + '</td>';
		htmlStr += '	<td>' + item.pphone + '</td>';
		htmlStr += '	<td>';
		htmlStr += '	<input type="button" class="patientbtn" value="修改" size="5" style="cursor:pointer" id="updata' + k + '" />';
		htmlStr += '	<input type="button" class="patientbtn" value="删除" size="5" style="cursor:pointer" id="delet' + k + '"/>';
		htmlStr += '	</td>';
		htmlStr += '</tr>';

		//一行一行地追加到table中
		$("#patient").append(htmlStr);

		//点击修改按钮
		var htmls = '';
		$("#patient").on('click', '#updata' + k + '', ljx);

		function ljx() {

			console.log(1)
			var id = $(this).attr("id");
			var num = id.substr(5 + 1);
			/*var url = 'http://127.0.0.1:8080/Hospitall/GetDoctorServlet?dId='+item.did+'';
			$.getJSON(url,function(data){
				data.dname;
			});*/
			var htmls = '';
			$(this).hide();
			htmls += '<tr id="uppatient' + num + '">';
			htmls += ' <td id="nochang" padding="0">' + item.pid + '</td>';
			htmls += ' <td style="padding: 0;"><input type="text" class="add" size="5" style="overflow-x: scroll;" value="xx" id="uppaname' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="5" style="overflow-x: scroll;" value="helo" id="uppaage' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="5" style="overflow-x: scroll;" value="helo" id="uppasex' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="10" style="overflow-x: scroll;" value="helo" id="uppaphone' + num + '"/></td>';
			htmls += ' <td><input type="button" class="patientbtn" value="保存" size="5" style="cursor:pointer" id="baocun' + num + '" />';
			htmls += '';
			htmls += '</tr>';
			$('#patient' + num + '').after(htmls);
			$('#uppaname' + num + '').val(item.pname);
			$('#uppaage' + num + '').val(item.page);
			document.getElementById('uppasex' + num + '').value = item.psex;
			document.getElementById('uppaphone' + num + '').value = item.pphone;

			$('#quxiao' + num).click(function() {

			});

			$('#baocun' + num + '').click(function() {

				$('#updata' + num + '').show();
				console.log($('#uppaname' + num + '').val());
				var params = {
					P_id:item.pid,
					P_name:$('#uppaname'+num+'').val(),
					P_age:$('#uppaage'+num+'').val(),
					P_sex:$('#uppasex'+num+'').val(),
					P_phone:$('#uppaphone'+num+'').val()
				};

				console.log(params);
				$('#uppatient' + num + '').remove();
				var url = baseUrl + '/UpdatePatientServlet';
				$.post(url, params, function(data) {
					console.log(data);
					alert("update success");

					window.location.reload();
				}).error(function(XMLHttpRequest, textStatus) {

					alert("fail update");
				});
			});

		}

		//点击删除按钮

		$('#delet' + k + '').click(function() {
			var flag = confirm("Are U sure?");
			if(!flag) {
				return;
			}
			var url = baseUrl + "/DeletePatientServlet";
			var params = {
				P_id: item.pid
			};

			$.post(url, params, function() {
				window.location.reload();
				alert("delete success");

			}).error(function() {
				alert("fail");
			});
		});

	});

});
//点击添加按钮
$('#addpatient').click(function() {
	htmlStr = '';
	htmlStr += '<tr id="add">';
	htmlStr += '	<td>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addpname" name="addpname"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addpage" name="addpage"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addpsex" name="addpsex"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="10" id="addpphone" name="addpphone"/>' + '</td>';
	htmlStr += '	<td>';
	htmlStr += '	<input type="button" class="patientbtn" value="保存" size="5" style="cursor:pointer" id="save" />';
	htmlStr += '		<input type="button" class="patientbtn" value="取消" size="5" style="cursor:pointer" id="quxiao"/>';
	htmlStr += '	</td>';
	htmlStr += '</tr>';

	$('#patient').append(htmlStr);

});
//点击保存按钮
$('#patient').off('click').on('click', '#save', function() {
	var url = baseUrl + '/AddPatientServlet';

	var param = {
		P_name:$('#addpname').val(),
		P_age:$('#addpage').val(),
		P_sex:$('#addpsex').val(),
		P_phone:$('#addpphone').val()
	};

	$.post(url, param, function() {
		window.location.reload();
		alert('success adding');
	}).error(function() {
		alert('fail');
	});
});

//点击取消按钮
$('#patient').on('click', '#quxiao', function() {
	$('#add').remove();
});