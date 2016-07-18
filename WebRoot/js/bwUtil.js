var bw;
if(!bw) bw={};
//得到项目根路径
bw.getRootPath=function getRootPath(){
    //获取当前网址，如： http://localhost:8088/test/test.jsp
    var curPath=window.document.location.href;
    //获取主机地址之后的目录，如： test/test.jsp
    var pathName=window.document.location.pathname;
    var pos=curPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8088
    var localhostPaht=curPath.substring(0,pos);
    //获取带"/"的项目名，如：/test/
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+2);
    return(localhostPaht+projectName);
};
var hex_chr = "0123456789abcdef";  
function rhex(num) {  
    str = "";  
    for (j = 0; j <= 3; j++) {  
        str += hex_chr.charAt((num >> (j * 8 + 4)) & 15) + hex_chr.charAt((num >> (j * 8)) & 15);  
    }  
    return str;  
}  
function str2blks_MD5(str) {  
    nblk = ((str.length + 8) >> 6) + 1;  
    blks = new Array(nblk * 16);  
    for (i = 0; i < nblk * 16; i++) {  
        blks[i] = 0;  
    }  
    for (i = 0; i < str.length; i++) {  
        blks[i >> 2] |= str.charCodeAt(i) << ((i % 4) * 8);  
    }  
    blks[i >> 2] |= 128 << ((i % 4) * 8);  
    blks[nblk * 16 - 2] = str.length * 8;  
    return blks;  
};  
function add(x, y) {  
    var lsw = (x & 65535) + (y & 65535);  
    var msw = (x >> 16) + (y >> 16) + (lsw >> 16);  
    return (msw << 16) | (lsw & 65535);  
};  
function rol(num, cnt) {  
    return (num << cnt) | (num >>> (32 - cnt));  
};  
function cmn(q, a, b, x, s, t) {  
    return add(rol(add(add(a, q), add(x, t)), s), b);  
};  
function ff(a, b, c, d, x, s, t) {  
    return cmn((b & c) | ((~b) & d), a, b, x, s, t);  
};  
function gg(a, b, c, d, x, s, t) {  
    return cmn((b & d) | (c & (~d)), a, b, x, s, t);  
};  
function hh(a, b, c, d, x, s, t) {  
    return cmn(b ^ c ^ d, a, b, x, s, t);  
};  
function ii(a, b, c, d, x, s, t) {  
    return cmn(c ^ (b | (~d)), a, b, x, s, t);  
};  
bw.md5Encode=function MD5(str) {  
    x = str2blks_MD5(str);  
    var a = 1732584193;  
    var b = -271733879;  
    var c = -1732584194;  
    var d = 271733878;  
    for (i = 0; i < x.length; i += 16) {  
        var olda = a;  
        var oldb = b;  
        var oldc = c;  
        var oldd = d;  
        a = ff(a, b, c, d, x[i + 0], 7, -680876936);  
        d = ff(d, a, b, c, x[i + 1], 12, -389564586);  
        c = ff(c, d, a, b, x[i + 2], 17, 606105819);  
        b = ff(b, c, d, a, x[i + 3], 22, -1044525330);  
        a = ff(a, b, c, d, x[i + 4], 7, -176418897);  
        d = ff(d, a, b, c, x[i + 5], 12, 1200080426);  
        c = ff(c, d, a, b, x[i + 6], 17, -1473231341);  
        b = ff(b, c, d, a, x[i + 7], 22, -45705983);  
        a = ff(a, b, c, d, x[i + 8], 7, 1770035416);  
        d = ff(d, a, b, c, x[i + 9], 12, -1958414417);  
        c = ff(c, d, a, b, x[i + 10], 17, -42063);  
        b = ff(b, c, d, a, x[i + 11], 22, -1990404162);  
        a = ff(a, b, c, d, x[i + 12], 7, 1804603682);  
        d = ff(d, a, b, c, x[i + 13], 12, -40341101);  
        c = ff(c, d, a, b, x[i + 14], 17, -1502002290);  
        b = ff(b, c, d, a, x[i + 15], 22, 1236535329);  
        a = gg(a, b, c, d, x[i + 1], 5, -165796510);  
        d = gg(d, a, b, c, x[i + 6], 9, -1069501632);  
        c = gg(c, d, a, b, x[i + 11], 14, 643717713);  
        b = gg(b, c, d, a, x[i + 0], 20, -373897302);  
        a = gg(a, b, c, d, x[i + 5], 5, -701558691);  
        d = gg(d, a, b, c, x[i + 10], 9, 38016083);  
        c = gg(c, d, a, b, x[i + 15], 14, -660478335);  
        b = gg(b, c, d, a, x[i + 4], 20, -405537848);  
        a = gg(a, b, c, d, x[i + 9], 5, 568446438);  
        d = gg(d, a, b, c, x[i + 14], 9, -1019803690);  
        c = gg(c, d, a, b, x[i + 3], 14, -187363961);  
        b = gg(b, c, d, a, x[i + 8], 20, 1163531501);  
        a = gg(a, b, c, d, x[i + 13], 5, -1444681467);  
        d = gg(d, a, b, c, x[i + 2], 9, -51403784);  
        c = gg(c, d, a, b, x[i + 7], 14, 1735328473);  
        b = gg(b, c, d, a, x[i + 12], 20, -1926607734);  
        a = hh(a, b, c, d, x[i + 5], 4, -378558);  
        d = hh(d, a, b, c, x[i + 8], 11, -2022574463);  
        c = hh(c, d, a, b, x[i + 11], 16, 1839030562);  
        b = hh(b, c, d, a, x[i + 14], 23, -35309556);  
        a = hh(a, b, c, d, x[i + 1], 4, -1530992060);  
        d = hh(d, a, b, c, x[i + 4], 11, 1272893353);  
        c = hh(c, d, a, b, x[i + 7], 16, -155497632);  
        b = hh(b, c, d, a, x[i + 10], 23, -1094730640);  
        a = hh(a, b, c, d, x[i + 13], 4, 681279174);  
        d = hh(d, a, b, c, x[i + 0], 11, -358537222);  
        c = hh(c, d, a, b, x[i + 3], 16, -722521979);  
        b = hh(b, c, d, a, x[i + 6], 23, 76029189);  
        a = hh(a, b, c, d, x[i + 9], 4, -640364487);  
        d = hh(d, a, b, c, x[i + 12], 11, -421815835);  
        c = hh(c, d, a, b, x[i + 15], 16, 530742520);  
        b = hh(b, c, d, a, x[i + 2], 23, -995338651);  
        a = ii(a, b, c, d, x[i + 0], 6, -198630844);  
        d = ii(d, a, b, c, x[i + 7], 10, 1126891415);  
        c = ii(c, d, a, b, x[i + 14], 15, -1416354905);  
        b = ii(b, c, d, a, x[i + 5], 21, -57434055);  
        a = ii(a, b, c, d, x[i + 12], 6, 1700485571);  
        d = ii(d, a, b, c, x[i + 3], 10, -1894986606);  
        c = ii(c, d, a, b, x[i + 10], 15, -1051523);  
        b = ii(b, c, d, a, x[i + 1], 21, -2054922799);  
        a = ii(a, b, c, d, x[i + 8], 6, 1873313359);  
        d = ii(d, a, b, c, x[i + 15], 10, -30611744);  
        c = ii(c, d, a, b, x[i + 6], 15, -1560198380);  
        b = ii(b, c, d, a, x[i + 13], 21, 1309151649);  
        a = ii(a, b, c, d, x[i + 4], 6, -145523070);  
        d = ii(d, a, b, c, x[i + 11], 10, -1120210379);  
        c = ii(c, d, a, b, x[i + 2], 15, 718787259);  
        b = ii(b, c, d, a, x[i + 9], 21, -343485551);  
        a = add(a, olda);  
        b = add(b, oldb);  
        c = add(c, oldc);  
        d = add(d, oldd);  
    }  
    return rhex(a) + rhex(b) + rhex(c) + rhex(d);  
} ;
$(document).ajaxComplete(function(event, xhr, settings) {  
    if(xhr.getResponseHeader("sessionstatus")=="timeOut"){  
        if(xhr.getResponseHeader("loginPath")){
        	var top = getTopWinow(); // 获取当前页面的顶层窗口对象
        	$.messager.alert('我的消息', '登录超时-请重新登录！', 'info');
        	top.location.href=xhr.getResponseHeader("loginPath");
        }else{  
           // alert("请求超时请重新登陆 !");  
        }  
    }  
});  

/** 
* 在页面中任何嵌套层次的窗口中获取顶层窗口 
* @return 当前页面的顶层窗口对象 
*/
function getTopWinow() {
	var p = window;
	while (p != p.parent) {
		p = p.parent;
	}
	return p;
};
/**
 * 增加formatString功能
 * 
 * @author 孙宇
 * 
 * @example sy.formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * 
 * @returns 格式化后的字符串
 */
bw.formatString = function(str) {
	for (var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};
/**
 * 
 * 通用错误提示
 * 
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 * 
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 */
bw.onLoadError = {
	onLoadError : function(XMLHttpRequest) {
		if (parent.$ && parent.$.messager) {
			parent.$.messager.progress('close');
			parent.$.messager.alert('错误', XMLHttpRequest.responseText);
		} else {
			$.messager.progress('close');
			$.messager.alert('错误', XMLHttpRequest.responseText);
		}
	}
};
$.extend($.fn.datagrid.defaults, bw.onLoadError);
$.extend($.fn.treegrid.defaults, bw.onLoadError);
$.extend($.fn.tree.defaults, bw.onLoadError);
$.extend($.fn.combogrid.defaults, bw.onLoadError);
$.extend($.fn.combobox.defaults, bw.onLoadError);
$.extend($.fn.form.defaults, bw.onLoadError);

/**
 * 防止panel/window/dialog组件超出浏览器边界
 * 
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 */
bw.onMove = {
	onMove : function(left, top) {
		var l = left;
		var t = top;
		if (l < 1) {
			l = 1;
		}
		if (t < 1) {
			t = 1;
		}
		var width = parseInt($(this).parent().css('width')) + 14;
		var height = parseInt($(this).parent().css('height')) + 14;
		var right = l + width;
		var buttom = t + height;
		var browserWidth = $(window).width();
		var browserHeight = $(window).height();
		if (right > browserWidth) {
			l = browserWidth - width;
		}
		if (buttom > browserHeight) {
			t = browserHeight - height;
		}
		$(this).parent().css({/* 修正面板位置 */
			left : l,
			top : t
		});
	}
};
$.extend($.fn.dialog.defaults, bw.onMove);
$.extend($.fn.window.defaults, bw.onMove);
$.extend($.fn.panel.defaults, bw.onMove);
