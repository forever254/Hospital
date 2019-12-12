

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