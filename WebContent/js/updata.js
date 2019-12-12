function ljx() {
			var url = 'http://127.0.0.1:8080/Hospital/AddDoctorServlet';

				
					console.log(1)
					var id = $(this).attr("id");		
					var num = id.substr(5 + 1);
					/*var url = 'http://127.0.0.1:8080/Hospitall/GetDoctorServlet?dId='+item.did+'';
					$.getJSON(url,function(data){
						data.dname;
					});*/
					
					$(this).hide();
						htmls+='<tr id="updoctr'+num+'">';
						htmls+=' <td id="nochang" padding="0">'+item.did+'</td>';
						htmls+=' <td style="padding: 0;"><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="xx" id="updocname'+num+'"/></td>';
						htmls+=' <td><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="helo" id="updocsex'+num+'"/></td>';
						htmls+=' <td><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="helo" id="updocage'+num+'"/></td>';
						htmls+=' <td><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="helo" id="updocphone'+num+'"/></td>';
						htmls+=' <td><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="helo" id="updoclevel'+num+'"/></td>';
						htmls+=' <td><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="helo" id="updockid'+num+'"/></td>';
						htmls+=' <td><input type="text" style="width:200px ; height: 50px;overflow: scroll;" value="helo" id="updocexp'+num+'"/></td>';
						htmls+=' <td><input type="button" class="doctorbtn" value="保存" size="5" style="cursor:pointer" id="baocun' + num + '" />';
						htmls+=' <input type="button" class="doctorbtn" value="取消" size="5" style="cursor:pointer" id="’quxiao' + num + '" /></td>';
						htmls+='</tr>';
						$('#doctr'+num+'').after(htmls);					
						document.getElementById('updocname'+num+'').value = item.dname;
						document.getElementById('updocsex'+num+'').value = item.dsex;
						document.getElementById('updocage'+num+'').value = item.dage;
						document.getElementById('updocphone'+num+'').value = item.dphone;
						document.getElementById('updoclevel'+num+'').value = item.dlevel;
						document.getElementById('updockid'+num+'').value = item.sub.kid;
						document.getElementById('updocexp'+num+'').value = item.dexp;
						
						$('#updata'+num+'').unbind();
						$('#baocun' + num + '').click(function(){
							$('#updata'+num+'').show();
							$(this).parent().parent().remove();
						});
				
}
				
					