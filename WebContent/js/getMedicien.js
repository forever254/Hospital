//------------------查询所有的药物及种类------------------//
var url ="http://localhost:8080/Hospital/QueryMedicineServlet" ;
$.getJSON(url, function(data) {	
	//////////////将json对象转换成数组对象
	var keyAry = [];
	var valueAry = [];
	for(var key in data)
		{
		keyAry.push(key);
		valueAry.push(data[key]);
		}
	/////////////////
	var item=data.length;//药的数量
	var classnumble = 1;//药的种数
	console.log(item);
	for(var k=0;k<item;k++)
		{		
			if(k+1<item)
				{
					if(valueAry[k].mclass!=valueAry[k+1].mclass)
						{
							classnumble++;
						}
				}		
		}
	console.log(classnumble);
});
//-------------------------------------------------------------//

	
