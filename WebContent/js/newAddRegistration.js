
			var pname = getParam('pname');
			//alert(pname);
			var pphone = getParam('pphone');
			

			var url = 'http://127.0.0.1:8080/Hospital/QueryPatientServlet';
			var temp;
			
			$.getJSON(url, function(data) {
				//alert('test msg 2')
				$.each(data, function(index, item) {
					//alert('test msg')
					//alert(item.pphone);
					if( /*item.pname == pname &&*/ item.pphone == pphone) {
						temp = item.pid;
						
						$('#InternalMedicine').click(function() {
							alert('test msg')
							Dialog({
								title: "内科",
								width: 400,
								iframeContent: {
									src: "nake.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#surgerydepartment').click(function() {
//							location.href = "wake.html?" + "pid=" + temp;
							Dialog({
								title: "外科",
								width: 400,
								iframeContent: {
									src: "wake.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#pediatricDepartment').click(function() {
//							location.href = "erke.html?" + "pid=" + temp;
							Dialog({
								title: "儿科",
								width: 400,
								iframeContent: {
									src: "erke.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#gynecologyDepartment').click(function() {
//							location.href = "fuke.html?" + "pid=" + temp;
							Dialog({
								title: "妇科",
								width: 400,
								iframeContent: {
									src: "fuke.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#stomatologyDepartment').click(function() {
//							location.href = "kouqiang.html?" + "pid=" + temp;
							Dialog({
								title: "口腔科",
								width: 400,
								iframeContent: {
									src: "kouqiang.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#dermatologyDepartment').click(function() {
//							location.href = "pifu.html?" + "pid=" + temp;
							Dialog({
								title: "皮肤科",
								width: 400,
								iframeContent: {
									src: "pifu.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#orthopedicsDepartment').click(function() {
//							location.href = "gu.html?" + "pid=" + temp;
							Dialog({
								title: "骨科",
								width: 400,
								iframeContent: {
									src: "gu.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
						$('#radiologyDepartment').click(function() {
//							location.href = "fangshe.html?" + "pid=" + temp;
							Dialog({
								title: "放射科",
								width: 400,
								iframeContent: {
									src: "fangshe.html?" + "pid=" + temp,
									height: 200
								},
								showButton: false,
								contentBgColor: "#f5f5f5"
							});
						});
					}
				});
			});