$('#gbn').click(function() {
	window.location.href = "Menu.html";
});
var url = baseUrl + '/QueryDoctorServlet';

$.getJSON(url, function(data) {

	var htmlStr = '';

	var k = 0;
	$.each(data, function(index, item) {
		//拼接html字符串
		k++;
		htmlStr = '';
		htmlStr += '<tr id="doctr' + k + '">';
		htmlStr += '	<td>' + item.did + '</td>';
		htmlStr += '	<td>' + item.dname + '</td>';
		htmlStr += '	<td>' + item.dsex + '</td>';
		htmlStr += '	<td>' + item.dage + '</td>';
		htmlStr += '	<td>' + item.dphone + '</td>';
		htmlStr += '	<td>' + item.dlevel + '</td>';
		htmlStr += '	<td>' + item.sub.kid + '</td>';
		htmlStr += '	<td>' + item.dexp + '</td>';
		htmlStr += '	<td>';
		htmlStr += '	<input type="button" class="doctorbtn" value="修改" size="5" style="cursor:pointer" id="updata' + k + '" />';
		htmlStr += '	<input type="button" class="doctorbtn" value="删除" size="5" style="cursor:pointer" id="delet' + k + '"/>';
		htmlStr += '	</td>';
		htmlStr += '</tr>';

		//一行一行地追加到table中
		$("#doctor").append(htmlStr);

		//点击修改按钮
		var htmls = '';
		$("#doctor").on('click', '#updata' + k + '', ljx);

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
			htmls += '<tr id="updoctr' + num + '">';
			htmls += ' <td id="nochang" padding="0">' + item.did + '</td>';
			htmls += ' <td style="padding: 0;"><input type="text" class="add" size="5" style="overflow-x: scroll;" value="xx" id="updocname' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="5" style="overflow-x: scroll;" value="helo" id="updocsex' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="5" style="overflow-x: scroll;" value="helo" id="updocage' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="10" style="overflow-x: scroll;" value="helo" id="updocphone' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="7" style="overflow-x: scroll;" value="helo" id="updoclevel' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="5" style="overflow-x: scroll;" value="helo" id="updockid' + num + '"/></td>';
			htmls += ' <td><input type="text" class="add" size="20" style="overflow-x: scroll;" value="helo" id="updocexp' + num + '"/></td>';
			htmls += ' <td><input type="button" class="doctorbtn" value="保存" size="5" style="cursor:pointer" id="baocun' + num + '" />';
			htmls += '';
			htmls += '</tr>';
			$('#doctr' + num + '').after(htmls);
			$('#updocname' + num + '').val(item.dname);
			$('#updocsex' + num + '').val(item.dsex);
			document.getElementById('updocage' + num + '').value = item.dage;
			document.getElementById('updocphone' + num + '').value = item.dphone;
			document.getElementById('updoclevel' + num + '').value = item.dlevel;
			document.getElementById('updockid' + num + '').value = item.sub.kid;
			document.getElementById('updocexp' + num + '').value = item.dexp;

			$('#quxiao' + num).click(function() {

			});

			$('#baocun' + num + '').click(function() {

				$('#updata' + num + '').show();
				console.log($('#updocname' + num + '').val());
				var params = {
					D_id: item.did,
					D_name: $('#updocname' + num + '').val(),
					D_sex: $('#updocsex' + num + '').val(),
					D_age: $('#updocage' + num + '').val(),
					D_phone: $('#updocphone' + num + '').val(),
					D_level: $('#updoclevel' + num + '').val(),
					K_idFK: $('#updockid' + num + '').val(),
					D_exp: $('#updocexp' + num + '').val()

				};

				console.log(params);
				$('#updoctr' + num + '').remove();
				var url = baseUrl+'/UpdateDoctorServlet';
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
			var url = baseUrl+"/DeleteDoctorServlet";
			var params = {
				D_id: item.did
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
$('#adddoctor').click(function() {
	htmlStr = '';
	htmlStr += '<tr id="add">';
	htmlStr += '	<td>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addname" name="addname"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addsex" name="addsex"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addage" name="addage"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="10" id="addphone" name="addphone"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="7" id="addlevel" name="addlevel"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="5" id="addkid" name="addkid"/>' + '</td>';
	htmlStr += '	<td>' + '<input type="text" class="add" size="15" id="addexp" name="addexp"/>' + '</td>';
	htmlStr += '	<td>';
	htmlStr += '	<input type="button" class="doctorbtn" value="保存" size="5" style="cursor:pointer" id="save" />';
	htmlStr += '		<input type="button" class="doctorbtn" value="取消" size="5" style="cursor:pointer" id="quxiao"/>';
	htmlStr += '	</td>';
	htmlStr += '</tr>';

	$('#doctor').append(htmlStr);
	window.scrollTo(0, document.documentElement.scrollHeight-document.documentElement.clientHeight); 

});
//点击保存按钮
$('#doctor').off('click').on('click', '#save', function() {
	var url = baseUrl+'/AddDoctorServlet';

	var param = {
		D_name: $('#addname').val(),
		D_sex: $('#addsex').val(),
		D_age: $('#addage').val(),
		D_phone: $('#addphone').val(),
		D_level: $('#addlevel').val(),
		K_idFK: $('#addkid').val(),
		D_exp: $('#addexp').val()
	};

	$.post(url, param, function() {
		window.location.reload();
		alert('success adding');
	}).error(function() {
		alert('fail');
	});
});

//点击取消按钮
$('#doctor').on('click', '#quxiao', function() {
	$('#add').remove();
});