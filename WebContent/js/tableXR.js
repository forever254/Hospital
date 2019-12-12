'use strict';

var _createClass = function() {
	function defineProperties(target, props) {
		for(var i = 0; i < props.length; i++) {
			var descriptor = props[i];
			descriptor.enumerable = descriptor.enumerable || false;
			descriptor.configurable = true;
			if("value" in descriptor) descriptor.writable = true;
			Object.defineProperty(target, descriptor.key, descriptor);
		}
	}
	return function(Constructor, protoProps, staticProps) {
		if(protoProps) defineProperties(Constructor.prototype, protoProps);
		if(staticProps) defineProperties(Constructor, staticProps);
		return Constructor;
	};
}();

function _toConsumableArray(arr) {
	if(Array.isArray(arr)) {
		for(var i = 0, arr2 = Array(arr.length); i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		return arr2;
	} else {
		return Array.from(arr);
	}
}

function _classCallCheck(instance, Constructor) {
	if(!(instance instanceof Constructor)) {
		throw new TypeError("Cannot call a class as a function");
	}
}

var Table = function() {
	function Table(el, options) {
		_classCallCheck(this, Table);

		this.$ele = el;
		this.default = {
			columns: [],
			data: []
		};
		this.options = $.extend({}, this.default, options);
	}

	_createClass(Table, [{
		key: 'init',
		value: function init() {
			this.render();
			return this;
		}
	}, {
		key: 'css',
		value: function css() {
			return '\n<style>\n            .Table{\n                position: relative;\n                padding: 10px;\n            }\n            \n            .Table .T-title{\n                overflow: auto;\n            }\n            .Table .T-title div{\n                text-align: center;\n                margin: 14px auto;\n                border-bottom: 2px solid #f7f7f9;\n                font-size: 22px;\n            }\n             .Table .T-content label{\n                text-align: right;display: block;font-size: 13px;margin-bottom: 3px;\n             }\n             .Table .T-content label select{\n                padding: 0px 8px 3px;font-size: 13px;margin-right: 17px;cursor: pointer;\n             }\n             .Table .T-content label input[name=T-search]{\n                font-size: 13px;height: 15px;\n             }\n              .Table .T-content table{\n                width:100%;border-right: 1px solid #e1e1e8;border-top: 1px solid #e1e1e8;\n              }\n              .Table .T-content table tr.even{\n                    background-color: #f8faff;;\n              }\n                .Table .T-content table tr:hover{\n                     background-color: #dce6ff;\n                     cursor: pointer;\n                }\n              .Table .T-content table td{\n                border-bottom:1px solid #e1e1e8;border-left: 1px solid #e1e1e8;padding: 5px 0px;text-align: center;\n              }\n              .Table #T-page ul{\n                  list-style: none;float: right;\n                  display: inline-block;-webkit-user-select: none; -ms-user-select: none;user-select: none; \xA0-moz-user-select:none;\n              }\n              .Table #T-page ul li{\n                display: inline;\n              }\n              .Table #T-page ul li a{\n                text-align: center;padding:2px 10px;background-color: #f8faff;cursor: pointer;border: 1px solid darkgray;font-size: 13px;\n              \n              }\n              .Table #T-page ul li.none{\n                display: none;\n            }\n              .Table #T-page ul li.directing{\n                    margin: 0 10px;\n              }\n              .Table #T-page ul li a.not_allow{\n                  cursor: not-allowed; \n                  pointer-events: none;\n                   color: #777;\n              }\n              .Table #T-page ul li a.active{\n                  background-color: #819ee9;\n                     color: white;    \n                       pointer-events: none;   \n                        cursor: not-allowed; \n              }\n          \n               .Table #T-page ul li a:hover:not(.active){\n                    background-color:  #dce6ff;\n                  \n               }\n        </style>';
		}
	}, {
		key: 'tableHtml',
		value: function tableHtml() {
			var _options = this.options,
				_options$title = _options.title,
				title = _options$title === undefined ? "" : _options$title,
				_options$columns = _options.columns,
				columns = _options$columns === undefined ? [] : _options$columns;

			var _container = [];
			_container.push(['<thead><tr>'].concat(_toConsumableArray(columns.map(function(c) {
				return '<td style="border-bottom:1px solid #e1e1e8;border-left: 1px solid #e1e1e8; padding: 5px 10px;text-align: center"><strong>' + c['title'] + '</strong></td>';
			})), ['</tr></thead>', '<tbody></tbody>']).join(''));

			var container = ['<div class="Table">', '<div class="T-title"style="overflow: auto;">', '<div>' + title + '</div>', '</div>', '<div class="T-content">', '<label for="T-sort">', '\u6BCF\u9875\u663E\u793A\u6761\u6570\uFF1A<select name="" id="T-pageNum">'].concat(_toConsumableArray([5, 10, 15].map(function(c) {
				return '<option value="' + c + '">' + c + '</option>';
			})), ['</select>', '\u6392\u5E8F\uFF1A<select name="" id="T-sort">'], _toConsumableArray(columns.map(function(c) {
				return '<option value="' + c.data + '">' + c.title + '</option>';
			})), ['</select><input type="text" name="T-search" placeholder="\u641C\u7D22"></label>', '<table border="0" cellspacing="0" cellpadding="0">'], _container, ['</table>', '<div id="T-page"></div>', '</div>', '</div>']).join('');

			return container;
		}
	}, {
		key: 'showDb',
		value: function showDb() {
			var opt = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};
			var cb = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : function() {
				return undefined;
			};
			var _options2 = this.options,
				_options2$columns = _options2.columns,
				columns = _options2$columns === undefined ? [] : _options2$columns,
				_options2$data = _options2.data,
				data = _options2$data === undefined ? [] : _options2$data;
			var _opt$num = opt.num,
				num = _opt$num === undefined ? 5 : _opt$num,
				_opt$page = opt.page,
				page = _opt$page === undefined ? 1 : _opt$page,
				_opt$sortBy = opt.sortBy,
				sortBy = _opt$sortBy === undefined ? columns[0].data : _opt$sortBy,
				_opt$searchVal = opt.searchVal,
				searchVal = _opt$searchVal === undefined ? "" : _opt$searchVal;

			//搜索功能

			if(searchVal !== "") {
				$('tbody', this.$ele).html('正在搜索中...');
				data = data.filter(function(d) {
					return Object.keys(d).some(function(key) {
						return new RegExp(searchVal).test(d[key]);
					});
				});
				cb(data);
				if(data.length === 0) {
					$('tbody', this.$ele).html('<tr><td colspan="' + columns.length + '">\u62B1\u6B49,\u672A\u627E\u5230\u76F8\u5173\u6570\u636E</td></tr>');

					return false;
				}
			} else {
				$('tbody', this.$ele).html('');
				cb(undefined);
			}

			//排序功能
			data = data.map(function(d) {
				Object.keys(d).map(function(k) {
					if(!isNaN(Number(d[k]))) d[k] = Number(d[k]);
				});
				return d;
			});
			data.sort(function(data1, data2) {
				if(data1[sortBy] < data2[sortBy]) {
					return -1;
				} else if(data1[sortBy] > data2[sortBy]) {
					return 1;
				} else {
					return 0;
				}
			});
			// console.log(data);
			var _container = [];

			//显示条数
			var _data = data.slice((page - 1) * num, page * num);

			for(var i = 0; i < _data.length; i++) {
				var td = [];
				for(var j = 0; j < columns.length; j++) {
					td.push('<td>' + _data[i][columns[j]['data']] + '</td>');
				}
				_container.push(['<tr class="' + (i % 2 === 0 ? 'even' : 'odd') + '">'].concat(td, ['</tr>']).join(''));
			}
			$('tbody', this.$ele).html(_container.join(''));
		}
	}, {
		key: 'showPage',
		value: function showPage(data_) {
			var data = data_ || this.options.data;
			var num = Number($('#T-pageNum', this.$ele).val());
			//页码选择
			var f = function f(length) {
				return Array.from({
					length: length
				}, function(v, k) {
					return k + 1;
				});
			};
			$('#T-page', this.$ele).html('');
			if(data.length > num) {
				var pages = Math.ceil(data.length / num);

				var li_List = [];
				if(pages > 7) {
					var prev3 = f(5).map(function(i) {
						return '<li><a class="page pageNum  ' + (i === 1 ? 'active' : '') + '" data-index="' + i + '">' + i + '</a></li>';
					});
					li_List = [].concat(_toConsumableArray(prev3), ['<li><a class="page pageNum not_allow" data-index="6">...</a></li>', '<li><a class="page pageNum" data-index="7">' + pages + '</a></li>']);
				} else {
					li_List = f(pages).map(function(i) {
						return '<li><a  class="page pageNum ' + (i === 1 ? 'active' : '') + '" data-index="' + i + '">' + i + '</a></li>';
					});
				}

				var pageArr = ['<ul class="' + (pages > 7 ? 'ellipsis' : '') + '">', '<li><a class="prev not_allow">上一页</a></li>'].concat(_toConsumableArray(li_List), ['<li><a class="next">下一页</a></li>', '</ul>']);
				$('#T-page', this.$ele).html(pageArr.join(''));

				var that = this;
				var $ele = this.$ele;

				var $prev = $('#T-page', $ele).find('a.prev');
				var $next = $('#T-page', $ele).find('a.next');

				$('#T-page', $ele).find('a.page').on('click', function() {
					var $current = $(this);
					$('#T-page', $ele).find('a').removeClass('active');
					var length = $('#T-page', $ele).find('a.page').length;
					var $ul = $('#T-page', $ele).find('ul');
					var page = Number($current.text()),
						index = $current.data('index');
					$prev.removeClass('not_allow');
					$next.removeClass('not_allow');
					index === 1 && $prev.addClass('not_allow');
					index === length && $next.addClass('not_allow');

					if($ul.hasClass('ellipsis')) {
						var _ref = [$('a[data-index="1"]', $ele), $('a[data-index="2"]', $ele), $('a[data-index="3"]', $ele), $('a[data-index="4"]', $ele), $('a[data-index="5"]', $ele), $('a[data-index="6"]', $ele), $('a[data-index="7"]', $ele)],
							$li_1 = _ref[0],
							$li_2 = _ref[1],
							$li_3 = _ref[2],
							$li_4 = _ref[3],
							$li_5 = _ref[4],
							$li_6 = _ref[5],
							$li_7 = _ref[6];

						var _$prev = $('button.prev', $ele),
							_$next = $('button.next', $ele),
							endPage = Number($li_7.text());
						if($current.parent().next().find('a').text() === '...' || $current.parent().prev().find('a').text() === '...') {
							if(index === 1) {
								/*前后按钮*/

								$li_2.text(2);
								$li_2.removeClass('not_allow');
								$li_2.addClass('pageNum');

								$li_6.text('...');
								$li_6.addClass('not_allow');
								$li_6.removeClass('pageNum');

								$li_3.text(3);
								$li_4.text(4);
								$li_5.text(5);
								$current.addClass('active');
							} else if(index === 7) {
								$li_6.text(endPage - 1);
								$li_6.removeClass('not_allow');
								$li_6.addClass('pageNum');

								$li_2.text('...');
								$li_2.addClass('not_allow');
								$li_2.removeClass('pageNum');

								$li_3.text(endPage - 4);
								$li_4.text(endPage - 3);
								$li_5.text(endPage - 2);
								$current.addClass('active');
							} else {
								$li_4.text(page);
								$li_4.addClass('active');
								$li_5.text(page + 1);
								$li_3.text(page - 1);

								$li_2.text('...');
								$li_2.addClass('not_allow');
								$li_2.removeClass('pageNum');

								$li_6.text('...');
								$li_6.addClass('not_allow');
								$li_6.removeClass('pageNum');
								if(endPage - page === 3) {
									$li_6.text(endPage - 1);
									$li_6.removeClass('not_allow');
									$li_6.addClass('pageNum');
								}
								if(page === 4) {
									$li_2.text(2);
									$li_2.removeClass('not_allow');
									$li_2.addClass('pageNum');
								}
							}
						} else {
							$current.addClass('active');
						}
					} else {
						$current.addClass('active');
					}

					that.reShow($current.text());
				});

				$prev.on('click', function() {
					var index = $('a.active', $('#T-page', $ele)).data('index');
					$('#T-page', $ele).find('a.page').removeClass('active');
					$("a[data-index=" + (index - 1) + "]", $('#T-page', $ele)).trigger('click');
				});
				$next.on('click', function() {
					var index = $('a.active', $('#T-page', $ele)).data('index');
					$('#T-page', $ele).find('a.page').removeClass('active');
					$("a[data-index=" + (index + 1) + "]", $('#T-page', $ele)).trigger('click');
				});
			}
		}
	}, {
		key: 'reShow',
		value: function reShow() {
			var page = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 1;
			var cb = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : function() {
				return undefined;
			};

			var that = this;
			var $ele = this.$ele;
			var num = Number($('#T-pageNum', $ele).val());
			var sortBy = $('#T-sort', $ele).val();
			var searchVal = $.trim($('input[name=T-search]', $ele).val()) || "";
			that.showDb({
				num: num,
				sortBy: sortBy,
				searchVal: searchVal,
				page: page
			}, cb);
		}
	}, {
		key: 'events',
		value: function events() {
			var that = this;
			var $ele = this.$ele;
			$('#T-pageNum', $ele).on('change', function() {
				that.reShow();
				that.showPage();
			});

			$('#T-sort', $ele).on('change', function() {
				that.reShow();
				that.showPage();
			});

			$('input[name=T-search]', $ele).on('input propertychange', function() {
				that.reShow(1, function(data) {
					that.showPage(data);
				});
			});
		}
	}, {
		key: 'render',
		value: function render() {
			var opt = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

			var html = this.tableHtml();
			this.$ele.html(html);
			$('head').append(this.css());
			this.reShow();
			this.showPage();
			this.events();
		}
	}]);

	return Table;
}();

;
(function($) {
	$.fn.tableXR = function() {
		var opt = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

		var t = new Table(this, opt);
		t.init();
	};
})(jQuery);