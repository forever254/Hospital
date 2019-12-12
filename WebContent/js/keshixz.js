/**
 * 
 */

var url = 'http://127.0.0.1:8080/Hospital/QuerySubjectServlet';
			$.getJSON(url, function(data) {
				$.each(data, function(index, item) {
					var opt = '<option value ="' + item.kid + '">' + item.kname + '</option>';
					$('#kid').append(opt);
				});
			});