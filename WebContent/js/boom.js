function $$(selector, context) {
	return [].slice.call((context || document).querySelectorAll(selector));
}
$$(".button-box").forEach(function(el) {
	if($$("button", el).length === 1) {
		$("button", el).style.cssText = "display:block;margin:0 auto;";
	}
})
$('#about').click(function() {
	Dialog({
		title: "关于",
		width: 1100,
		iframeContent: {
			src: "lunbo.html",
			height: 600
		},
		showButton: false,
		contentBgColor: "#f5f5f5"
	});
});

$('#blood').click(function() {
	Dialog({
		title: "血常规",
		content: "注意事项:</br>抽血前24h不吃油腻、高蛋白实物，避免大量饮酒。抽血前24h的晚8h以后，禁食12h。</br>款额：500.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#cchao').click(function() {
	Dialog({
		title: "彩超",
		content: "注意事项:</br>检查前24h禁食，尽量少喝水。</br>款额：200.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#ray').click(function(){
	Dialog({
		title:"乳腺红外扫描",
		content:"注意事项:</br>检查前48h禁止饮用含有酒精的饮料，禁止服用扩血管剂、血管收缩剂，禁食禁水2h。</br>款额：200.00元",
		contentBgColor:"#f5f5f5"
	});
});

$('#knife').click(function() {
	Dialog({
		title: "宫颈刮片",
		content: "注意事项:</br>检查最好在非月经期进行。</br>款额：600.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#normal').click(function() {
	Dialog({
		title: "妇科常规",
		content: "注意事项:</br>检查最好在非月经期进行。</br>款额：600.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#heart').click(function() {
	Dialog({
		title: "乳腺摄影检查",
		content: "注意事项:</br>照射部位上的皮肤上不应有香粉、爽身粉或除臭剂之类的粉状物质。</br>款额：300.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#stomoch').click(function() {
	Dialog({
		title: "胃镜",
		content: "注意事项:</br>如当日上午检查，前一日晚餐后要禁食，当日免早餐；如当日下午检查，早餐可吃清淡半流质食物，中午禁食。</br>款额：400.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#pee').click(function() {
	Dialog({
		title: "尿检",
		content: "注意事项:</br>检查前24小时请勿进食、喝水。</br>款额：300.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#brain').click(function() {
	Dialog({
		title: "脑CT",
		content: "注意事项:</br>进入扫描室之前去除表面金属配饰。</br>款额：300.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#comic').click(function() {
	Dialog({
		title: "核磁共振",
		content: "注意事项:</br>检查前4h需要禁食和禁水，在进入扫描室前去除体表所有金属及其他影响检查及安全的物品。</br>款额：300.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#inside').click(function() {
	Dialog({
		title: "内科    3号楼|F2",
		content: "编号:101</br>内容: 内科学系自1921年建院之初即成立。经过近百年的传承及发展。内科以其严格而规范的住院医师、总住院医师轮转培训以及三级医师查房制度而闻名，由此培养出了一批又一批的内科大家。历代协和人始终在以严谨求精的态度尽力为每一位住院患者解除病痛。</br>医生人数：3人",
		contentBgColor: "#f5f5f5"
	});
});

$('#child').click(function() {
	Dialog({
		title: "儿科	6号楼|F4",
		content: "编号:103</br>内容:多年来，老刘の儿科为大量疑难病、罕见病患儿明确诊断、使患儿们得到及时治疗，重建了更多家庭幸福生活的希望。</br>医生人数：3人",
		contentBgColor: "#f5f5f5"
	});
});

$('#nerse').click(function(){
	Dialog({
		title:"神经外科		2号楼|F4",
		content:"编号:102</br>内容:我国著名的神经外科专家冯传宜教授、王维钧教授、尹昭炎教授等为老刘の医院神经外科的发展和壮大做了大量工作，并为我国神经外科的开展起到了积极的推动作用。</br>医生人数:3人",
		contentBgColor:"#f5f5f5"
	});
});

$('#outside').click(function(){
	Dialog({
		title:"普外科		2号楼|F1",
		content:"编号:102</br>内容:经过几十年几代人的不懈努力，现拥有158张病床及2个分子生物学实验室，已成为普外领域全国疑难重症疾病的诊治中心，拥有结构合理、素质优秀的人材梯队，多名专家在中华医学会和国内外杂志担任各种领导职务</br>医生人数:6人",
		contentBgColor:"#f5f5f5"
	});
});

$('#bond').click(function() {
	Dialog({
		title: "骨科	2号楼|F10",
		content: "编号:107</br>内容:目前骨科是一个以脊柱外科为重点，关节外科、老年创伤外科为特色，运动医学、骨肿瘤、足踝外科、微创外科等亚专业齐全的国内综合性骨科医学中心之一。</br>医生人数：3人",
		contentBgColor: "#f5f5f5"
	});
});

$('#cbond').click(function(){
	Dialog({
		title:"小儿骨科		2号楼|F9",
		content:"编号:107</br>内容:历经近半个世纪的发展，小儿骨科在人才储备、临床能力、学术水平等诸多方面均处于国内的领先地位。</br>医生人数:3人",
		contentBgColor:"#f5f5f5"
	});
});

$('#hbond').click(function(){
	Dialog({
		title:"创伤骨科		2号楼|F11",
		content:"编号:107</br>内容:作为全国知名的创伤骨科中心，每年要接待数万名来自全国各地的疑难、翻修以及并发症处理等患者，并诊治。</br>医生人数:3人",
		contentBgColor:"#f5f5f5"
	});
});

$('#obond').click(function(){
	Dialog({
		title:"骨肿瘤科		2号楼|F8",
		content:"编号:107</br>内容:国内床位数最多的骨与软组织肿瘤诊治中心，目前有额定床位48张；累计治疗骨与软组织肿瘤病例数最大的单位；建立了国内最为完善的骨与软组织肿瘤数据库。</br>医生人数:3人",
		contentBgColor:"#f5f5f5"
	});
});

$('#skin').click(function() {
	Dialog({
		title: "皮肤科		2号楼|F4",
		content: "编号:106</br>内容:经过近一个世纪来、几代人的不懈努力，老刘の医院皮肤科为我国的皮肤性病学发展做出了突出贡献。</br>医生人数：3人",
		contentBgColor: "#f5f5f5"
	});
});

$('#x-ray').click(function() {
	Dialog({
		title: "放射科		2号楼|F2",
		content: "编号:108</br>内容:放射科已形成种类齐全、设备先进、人员梯队合理的现代医学影像学体系，自2014年以来连续3年蝉联中国医院专科声誉排行榜 放射科 第一名。</br>医生人数：3人",
		contentBgColor: "#f5f5f5"
	});
});

$('#women').click(function() {
	Dialog({
		title: "妇科	8号楼|F5",
		content: "编号:104</br>内容:妇产科系是国家卫生部命名的林巧稚妇产科研究中心，国家级重点学科，全国妇产科疑难重症诊治中心，妇产科人才济济，专业齐全，学科发展平衡，实验室装备精良，教学具有特色以及独特的地位与作用。</br>医生人数：3人",
		contentBgColor: "#f5f5f5"
	});
});

$('#ear').click(function(){
	Dialog({
		title:"耳鼻喉科		3号楼|F7",
		content:"编号:109</br>内容:建院伊始，耳鼻咽喉科已独立建科，其中很多专家先后在北京和全国各地建立了耳鼻咽喉学科。老刘の医院耳鼻咽喉科在我国耳鼻咽喉科学的发展史上做出了不可磨灭的贡献。</br>医生人数:3人",
		contentBgColor:"#f5f5f5"
	});
});

$('#mouth').click(function(){
	Dialog({
		title:"口腔科		7号楼|F6",
		content:"编号:105</br>内容:1979年建立了口腔科实验室，开展了病理、免疫、生化等方面的科研和临床工作。经过90年代的扩建以及多年来的设备更新、人才引进，加之东、西两院的合并，口腔科不断发展壮大。</br>医生人数:3人",
		contentBgColor:"#f5f5f5"
	});
});

$('#m1-1').click(function() {
	Dialog({
		title: "头孢吡肟",
		content: "编号:1210</br>类别:抗生素</br>功能:消化道不适及腹泻</br>单价:55.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m1-2').click(function() {
	Dialog({
		title: "克拉霉素",
		content: "编号:1211</br>类别:抗生素</br>功能:恶心、呕吐及腹泻</br>单价:78.20元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m1-3').click(function() {
	Dialog({
		title: "头孢丙烯",
		content: "编号:1213</br>类别:抗生素</br>功能:过敏反应</br>单价:89.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m1-4').click(function() {
	Dialog({
		title: "头孢匹罗",
		content: "编号:1214</br>类别:抗生素</br>功能:恶心</br>单价:77.20元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m1-5').click(function() {
	Dialog({
		title: "强力霉素",
		content: "编号:1215</br>类别:抗生素</br>功能:胃肠道不适</br>单价:95.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m2-1').click(function() {
	Dialog({
		title: "单硝酸异山梨酯胶丸",
		content: "编号:1216</br>类别:心血管系统类</br>功能:抗心绞痛</br>单价:98.20元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m2-2').click(function() {
	Dialog({
		title: "地巴唑片",
		content: "编号:1217</br>类别:心血管系统类</br>功能:抗高血压</br>单价:80.20元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m2-3').click(function() {
	Dialog({
		title: "磷酸丙吡胺片",
		content: "编号:1218</br>类别:心血管系统类</br>功能:抗心律失常</br>单价:103.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m2-4').click(function() {
	Dialog({
		title: "磷酸二酯酶抑制剂",
		content: "编号:1219</br>类别:心血管系统类</br>功能:抗心功能不全</br>单价:203.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m2-5').click(function() {
	Dialog({
		title: "盐酸多巴胺注射液",
		content: "编号:1220</br>类别:心血管系统类</br>功能:周围血管扩张</br>单价:105.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m3-1').click(function() {
	Dialog({
		title: "丽珠维三联",
		content: "编号:1221</br>类别:消化系统用药</br>功能:十二指肠溃疡、胃溃疡</br>单价:58.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m3-2').click(function() {
	Dialog({
		title: "奥沙拉秦钠",
		content: "编号:1222</br>类别:消化系统用药</br>功能:治疗急、慢性溃疡性结肠炎</br>单价:59.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m3-3').click(function() {
	Dialog({
		title: "甲磺酸加贝酯",
		content: "编号:1223</br>类别:消化系统用药</br>功能:急性轻型（水肿型）胰腺炎的治疗</br>单价:87.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m3-4').click(function() {
	Dialog({
		title: "西咪替了",
		content: "编号:1224</br>类别:消化系统用药</br>功能:激性胃溃疡和上消化道出血</br>单价:78.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m3-5').click(function() {
	Dialog({
		title: "盐酸雷尼替丁片",
		content: "编号:1225</br>类别:消化系统用药</br>功能:缓解胃酸过多所致的胃痛、胃灼热感（烧心）、反酸</br>单价:118.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m4-1').click(function() {
	Dialog({
		title: "甲氨蝶呤",
		content: "编号:1226</br>类别:抗风湿类</br>功能:修复骨破坏</br>单价:58.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m4-2').click(function() {
	Dialog({
		title: "雷公藤总苷",
		content: "编号:1227</br>类别:抗风湿类</br>功能:抑制淋巴、单核细胞及抗炎作用</br>单价:52.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m4-3').click(function() {
	Dialog({
		title: "硫唑嘌呤",
		content: "编号:1228</br>类别:抗风湿类</br>功能:抑制细胞的合成和功能</br>单价:99.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m4-4').click(function() {
	Dialog({
		title: "非甾体抗炎药",
		content: "编号:1229</br>类别:抗风湿类</br>功能:阵痛、解热、抗炎作用</br>单价:109.00元",
		contentBgColor: "#f5f5f5"
	});
});

$('#m4-5').click(function() {
	Dialog({
		title: "青霉胺",
		content: "编号:1230</br>类别:抗风湿类</br>功能:风湿性关节炎</br>单价:68.00元",
		contentBgColor: "#f5f5f5"
	});
});