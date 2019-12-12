var urlsss = 'http://127.0.0.1:8080/Hospital/QueryMedicineServlet';
//接收参数
$('#sel1').on('change', function() {
	var op = $(this).val();
	console.log("val--------" + op);
	
		//前后端交互查询
	console.log(urlsss);
	$.getJSON(urlsss, function(data) {
		console.log(data);
		$.each(data, function(index, item) {
			if(op == item.mname) {
				//动态生成列表
				function createtr() {
					var tr = document.createElement("tr");
					tr.id = "t" + item.mid;
					var txt = "txt"+item.mid;
					var count = item.mid;
					console.log(tr.id);
					var td;
					for(var i = 0; i < 3; i++) {
						td = tr.insertCell(tr.cells.length);
						if(i == 0) {
							td.width = 245;
							td.style.textAlign = "center";
							var result = '<font face="微软雅黑" size="3" >' + op + '</font>';
							td.innerHTML = result;
						}
						if(i == 1) {
							td.width = 70;
							var result = "<input type='text' style='width:30px;' id='"+txt+"'/>";
							td.innerHTML = result;
						}
						if(i == 2) {
							td.width = 35;
							var result = '<center><button><font color="red" id="' + count + '" onclick="deletetr(id)">x</font></button></center>';
							td.innerHTML = result;
						}
					}
					document.querySelector("#med").appendChild(tr);
					count++;
				}
				createtr();
			}
		});
	});
}); //单一添加下拉改变事件
$('#sel1').mousedown(function() { //当按下鼠标按钮的时候
	this.sindex = this.selectedIndex; //把当前选中的值得索引赋给下拉选中的索引
	this.selectedIndex = -1; //把下拉选中的索引改变为-1,也就是没有!
})
$('#sel1').mouseout(function() { //当鼠标移开的时候
	var index = $(this).get(0).selectedIndex; //获取下拉选中的索引
	if(index == -1) { //如果为-1,就是根本没有选
		this.selectedIndex = this.sindex; //就把下拉选中的索引改变成之前选中的值得索引,就默认选择的是之前选中的值
	}
});
$('#sel2').on('change', function() {
	var op = $(this).val();
	console.log("val--------" + op);	
		//前后端交互查询
	$.getJSON(urlsss, function(data) {
		$.each(data, function(index, item) {
			if(op == item.mname) {
				//动态生成列表
				function createtr() {
					var tr = document.createElement("tr");
					tr.id = "t" + item.mid;
					var txt = "txt"+item.mid;
					var count = item.mid;
					console.log(tr.id);
					var td;
					for(var i = 0; i < 3; i++) {
						td = tr.insertCell(tr.cells.length);
						if(i == 0) {
							td.width = 245;
							td.style.textAlign = "center";
							var result = '<font face="微软雅黑" size="3">' + op + '</font>';
							td.innerHTML = result;
						}
						if(i == 1) {
							td.width = 70;
							var result = "<input type='text' style='width:30px' id='"+txt+"'/>";
							td.innerHTML = result;
						}
						if(i == 2) {
							td.width = 35;
							var result = '<center><button><font color="red" id="' + count + '" onclick="deletetr(id)">x</font></button></center>';
							td.innerHTML = result;
						}
					}
					document.querySelector("#med").appendChild(tr);
					count++;
				}
				createtr();
			}
		});
	});
}); //单一添加下拉改变事件
$('#sel2').mousedown(function() { //当按下鼠标按钮的时候
	this.sindex = this.selectedIndex; //把当前选中的值得索引赋给下拉选中的索引
	this.selectedIndex = -1; //把下拉选中的索引改变为-1,也就是没有!
})
$('#sel2').mouseout(function() { //当鼠标移开的时候
	var index = $(this).get(0).selectedIndex; //获取下拉选中的索引
	if(index == -1) { //如果为-1,就是根本没有选
		this.selectedIndex = this.sindex; //就把下拉选中的索引改变成之前选中的值得索引,就默认选择的是之前选中的值
	}
});
$('#sel3').on('change', function() {
	var op = $(this).val();
	console.log("val--------" + op);
	
		//前后端交互查询
	$.getJSON(urlsss, function(data) {
		$.each(data, function(index, item) {
			if(op == item.mname) {
				//动态生成列表
				function createtr() {
					var tr = document.createElement("tr");
					tr.id = "t" + item.mid;
					var txt = "txt"+item.mid;
					var count = item.mid;
					console.log(tr.id);
					var td;
					for(var i = 0; i < 3; i++) {
						td = tr.insertCell(tr.cells.length);
						if(i == 0) {
							td.width = 245;
							td.style.textAlign = "center";
							var result = '<font face="微软雅黑" size="3">' + op + '</font>';
							td.innerHTML = result;
						}
						if(i == 1) {
							td.width = 70;
							var result = "<input type='text' style='width:30px' id='"+txt+"'/>";
							td.innerHTML = result;
						}
						if(i == 2) {
							td.width = 35;
							var result = '<center><button><font color="red" id="' + count + '" onclick="deletetr(id)">x</font></button></center>';
							td.innerHTML = result;
						}
					}
					document.querySelector("#med").appendChild(tr);
					count++;
				}
				createtr();
			}
		});
	});
}); //单一添加下拉改变事件
$('#sel3').mousedown(function() { //当按下鼠标按钮的时候
	this.sindex = this.selectedIndex; //把当前选中的值得索引赋给下拉选中的索引
	this.selectedIndex = -1; //把下拉选中的索引改变为-1,也就是没有!
})
$('#sel3').mouseout(function() { //当鼠标移开的时候
	var index = $(this).get(0).selectedIndex; //获取下拉选中的索引
	if(index == -1) { //如果为-1,就是根本没有选
		this.selectedIndex = this.sindex; //就把下拉选中的索引改变成之前选中的值得索引,就默认选择的是之前选中的值
	}
});
$('#sel4').on('change', function() {
	var op = $(this).val();
	console.log("val--------" + op);
	
		//前后端交互查询
	$.getJSON(urlsss, function(data) {
		$.each(data, function(index, item) {
			if(op == item.mname) {
				//动态生成列表
				function createtr() {
					var tr = document.createElement("tr");
					tr.id = "t" + item.mid;
					var txt = "txt"+item.mid;
					var count = item.mid;
					console.log(tr.id);
					var td;
					for(var i = 0; i < 3; i++) {
						td = tr.insertCell(tr.cells.length);
						if(i == 0) {
							td.width = 245;
							td.style.textAlign = "center";
							var result = '<font face="微软雅黑" size="3">' + op + '</font>';
							td.innerHTML = result;
						}
						if(i == 1) {
							td.width = 70;
							var result = "<input type='text' style='width:30px' id='"+txt+"'/>";
							td.innerHTML = result;
						}
						if(i == 2) {
							td.width = 35;
							var result = '<center><button><font color="red" id="' + count + '" onclick="deletetr(id)">x</font></button></center>';
							td.innerHTML = result;
						}
					}
					document.querySelector("#med").appendChild(tr);
					count++;
				}
				createtr();
			}
		});
	});
}); //单一添加下拉改变事件
$('#sel4').mousedown(function() { //当按下鼠标按钮的时候
	this.sindex = this.selectedIndex; //把当前选中的值得索引赋给下拉选中的索引
	this.selectedIndex = -1; //把下拉选中的索引改变为-1,也就是没有!
})
$('#sel4').mouseout(function() { //当鼠标移开的时候
	var index = $(this).get(0).selectedIndex; //获取下拉选中的索引
	if(index == -1) { //如果为-1,就是根本没有选
		this.selectedIndex = this.sindex; //就把下拉选中的索引改变成之前选中的值得索引,就默认选择的是之前选中的值
	}
});

//删除一行
function deletetr(id) {
	console.log("删除t" + id);
	for(var i = 1210; i <= 1230; i++) {
		if(i == id) {
			//$('#t'+i).html("");
			$('#t' + i).remove();
		}
	}
}