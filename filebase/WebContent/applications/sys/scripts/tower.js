// 弹出模式窗口,用以选中列表或树中的某个值,弹出窗口中必须返回一个含两个元素的数组,
// 用以给父窗口中的idInput和nameInput
// 必须指定的参数 url :弹出窗口的url
// idInput:父窗口中的存储返回id的输入框名称
// nameInput:父窗口中的存储返回name的输入框名称
function selDialog(url,idInput,nameInput,popWidth,popHeight,scrollIt,winName){
	if(winName == null){
		winName = "_blank";
	}
	if(popWidth == null){
		popWidth = 600;
	}
	if(popHeight == null){
		popHeight = 500;
	}
	var result;
	var vArguments = null;
	var sFeatures = "center:yes;status:no;help:no";
	if( scrollIt ){
		sFeatures += ";scroll:yes";
	} else {
		sFeatures += ";scroll:no";
	}
	sFeatures += ";dialogWidth:" + popWidth + "px";
	sFeatures += ";dialogHeight:"+ popHeight +"px";
	
	result = showModalDialog(url,vArguments,sFeatures);
	if(result){
		document.all(idInput).value = result[0];
		document.all(nameInput).value = result[1];
		
		return true;
	} else {
		return false;
	}
}

// 举例:<input name="ALL_ITEM" onclick="SelectAll('ALL_ITEM','ITEM_ID')">
// <input name="ITEM_ID">  N个,则点击All_ITEM时,所有的ITEM_ID选中值与其相同.
function SelectAll(ctrlInputStr,inputStr){
	var ctrlChecked = document.all(ctrlInputStr).checked;
	if( document.all(inputStr)== null){
		alert("当前没有可以选择的记录！");
		document.all(ctrlInputStr).checked = false;
		document.all(ctrlInputStr).blur();
		return false;
	}else{
		var tmp = document.all(inputStr).length;
		
		if( (typeof tmp) == "undefined" ) {
			document.all(inputStr).checked=ctrlChecked;
		}else{
			for(var i=0;i<document.all(inputStr).length;i++){
				document.all(inputStr)[i].checked = ctrlChecked;
			}
		}
	}
	return true;
}
function selDialogVar(url,popWidth,popHeight,X,Y,scrollIt,winName){
	if(winName == null){
		winName = "_blank";
	}
	if(popWidth == null){
		popWidth = 600;
	}
	if(popHeight == null){
		popHeight = 500;
	}
	var result;
	var vArguments = null;
	var sFeatures = "center:yes;status:no;help:no";
	if( scrollIt ){
		sFeatures += ";scroll:yes";
	} else {
		sFeatures += ";scroll:no";
	}
	sFeatures += ";dialogWidth:" + popWidth + "px";
	sFeatures += ";dialogHeight:"+ popHeight +"px";
	
	var popX,popY;
	if(X == null){
		var openerX = window.screenLeft;
		var openerWidth = document.body.clientWidth;
		popX = openerX + (openerWidth - popWidth) / 2;
	}
	else
	{
	  popX = X;
	}
	
	if(Y == null){
		var openerY = window.screenLeft;
		var openerHeight = document.body.clientHeight;
		popY = openerY + (openerHeight - popHeight) / 2;
	}
	else
	{
	  popY = Y;
	}
	sFeatures += ";dialogLeft:" + popX + "px";
	sFeatures += ";dialogTop:"+ popY +"px";
	
	result = showModalDialog(url,vArguments,sFeatures);
	return result;
}
function closeDialog(idValue,nameValue){
	var result = new Array(idValue,nameValue);
	window.returnValue = result;
	window.close();
}
//编辑、删除操作时，checkbox框的检查验证 
//flag="edit"	 验证编辑操作
//flag="delete"  验证删除操作
//flag="needlist"	必须选择
function SelectCheck(inputStr,flag,inputDesc){
if(flag=='freeze'){
		var count=0;
		if( document.all(inputStr) == null){
			alert("当前没有可以冻结/解冻的记录！");
			return false;
		}else{
			var tmp = document.all(inputStr).length;
			
			if( (typeof tmp) == "undefined"){
					if(document.all(inputStr).checked==false){
						alert("请选择一条记录！");
						return false;
					}else{
				        if(!confirm("警告:将进行冻结/解冻操作，您确定吗?")){
				            return false;
				        }
						return true;
					}
			}else{
				for(var i=0;i<document.all(inputStr).length;i++){
					if(document.all(inputStr)[i].checked==true){
						count= count+1;
					}
				}
				if(count==0){
					alert("请选择一条记录！");
					return false;
				}
				else{
			        if(!confirm("警告:将进行冻结/解冻操作，您确定吗?")){
			            return false;
			        }
					return true;
				}
			}
		}
	}else    if(flag=='select'){
		var count = 0;
		var itmp = 0;
		if( document.all(inputStr)== null){
			alert("当前没有可以查看的记录！");
			return false;
		}else{
			var tmp = document.all(inputStr).length;
			
			if( (typeof tmp) == "undefined"){
					if(document.all(inputStr).checked==false){
						alert("请选择一条记录！");
						return false;
					}else{
						return document.all(inputStr).value;
					}
			}else{
				for(var i=0;i<document.all(inputStr).length;i++){
					if(document.all(inputStr)[i].checked==true){
						count= count+1;
						itmp = i;
					}
				}
				if(count==0){
					alert("请选择一条记录！");
					return false;
				}else if(count>1){
					alert("查看操作只能选择一条记录！");
					return false;
				}else{
					return document.all(inputStr)[itmp].value;
				}
			}
		}
	}else	if(flag=='edit'){
		var count = 0;
		var itmp = 0;
		if( document.all(inputStr)== null){
			alert("当前没有可以操作的记录！");
			return false;
		}else{
			var tmp = document.all(inputStr).length;
			
			if( (typeof tmp) == "undefined"){
					if(document.all(inputStr).checked==false){
						alert("请选择一条记录！");
						return false;
					}else{
						return document.all(inputStr).value;
					}
			}else{
				for(var i=0;i<document.all(inputStr).length;i++){
					if(document.all(inputStr)[i].checked==true){
						count= count+1;
						itmp = i;
					}
				}
				if(count==0){
					alert("请选择一条记录！");
					return false;
				}else if(count>1){
					alert("该操作只能选择一条记录！");
					return false;
				}else{
					return document.all(inputStr)[itmp].value;
				}
			}
		}
	}else	if(flag=='editObject'){
		var count = 0;
		var itmp = 0;
		if( document.all(inputStr)== null){
			alert("当前没有可以操作的记录！");
			return false;
		}else{
			var tmp = document.all(inputStr).length;
			
			if( (typeof tmp) == "undefined"){
					if(document.all(inputStr).checked==false){
						alert("请选择一条记录！");
						return false;
					}else{
						return document.all(inputStr);
					}
			}else{
				for(var i=0;i<document.all(inputStr).length;i++){
					if(document.all(inputStr)[i].checked==true){
						count= count+1;
						itmp = i;
					}
				}
				if(count==0){
					alert("请选择一条记录！");
					return false;
				}else if(count>1){
					alert("该操作只能选择一条记录！");
					return false;
				}else{
					return document.all(inputStr)[itmp];
				}
			}
		}
	}else if(flag=='delete'){
		var count=0;
		if( document.all(inputStr) == null){
			alert("当前没有可以操作的记录！");
			return false;
		}else{
			var tmp = document.all(inputStr).length;
			
			if( (typeof tmp) == "undefined"){
					if(document.all(inputStr).checked==false){
						alert("请选择一条记录！");
						return false;
					}else{
				        if(!confirm("您确定要进行操作吗?")){
				            return false;
				        }
						return true;
					}
			}else{
				for(var i=0;i<document.all(inputStr).length;i++){
					if(document.all(inputStr)[i].checked==true){
						count= count+1;
					}
				}
				if(count==0){
					alert("请选择一条记录！");
					return false;
				}
				else{
			        if(!confirm("您确定要进行操作吗?")){
			            return false;
			        }
					return true;
				}
			}
		}
	} else if (flag=='needlist') {
		var count=0;
		if( document.all(inputStr) == null){
			alert("当前没有可以选择的"+inputDesc+"！");
			return false;
		}else{
			var tmp = document.all(inputStr).length;
			
			if( (typeof tmp) == "undefined"){
					if(document.all(inputStr).checked==false){
						alert("请选择一条"+inputDesc+"！");
						return false;
					}else{
						return true;
					}
			}else{
				for(var i=0;i<document.all(inputStr).length;i++){
					if(document.all(inputStr)[i].checked==true){
						count= count+1;
					}
				}
				if(count==0){
					alert("请选择一条"+inputDesc+"！");
					return false;
				} else{
					return true;
				}
			}
		}
	}
}

// 检查有没有选择某个Radio,若没有提示选择,返回null
// 若选择了,返回被选择的radio实例
function SelectRadio(inputStr){
	var count = 0;
	if( document.all(inputStr)== null){
		alert("当前没有可以选择的记录！");
		return null;
	}else{
		var tmp = document.all(inputStr).length;
		
		if( (typeof tmp) == "undefined"){
				if(document.all(inputStr).checked==false){
					alert("请选择一条记录！");
					return null;
				}else{
					return document.all(inputStr);
				}
		}else{
			for(var i=0;i<document.all(inputStr).length;i++){
				if(document.all(inputStr)[i].checked==true){
					return document.all(inputStr)[i];
				}
			}
			alert("请选择一条记录！");
			return null;
		}
	}
}

function doMouseOver(tr){
	var oldClass = tr.className;
	tr.className = "hover";
	tr.setAttribute("oldClass",oldClass);
}
function doMouseOut(tr){
	var oldClass = tr.getAttribute("oldClass");
	if(oldClass){
		tr.className = oldClass;
	} else {
		tr.className = "";
	}
}
function popSel(url,popWidth,popHeight,X,Y,scrollIt,winName){
	if(winName == null){
		winName = "_blank";
	}
	if(popWidth == null){
		popWidth = 600;
	}
	if(popHeight == null){
		popHeight = 500;
	}
	var popX,popY;
	if(X == null){
		var openerX = window.screenLeft;
		var openerWidth = document.body.clientWidth;
		popX = openerX + (openerWidth - popWidth) / 2;
	}
	else
	{
	  popX = X;
	}
	
	if(Y == null){
		var openerY = window.screenLeft;
		var openerHeight = document.body.clientHeight;
		popY = openerY + (openerHeight - popHeight) / 2;
	}
	else
	{
	  popY = Y;
	}

	var feature = "status=no,resizable=no,menubar=no";
	if( scrollIt ){
		feature += ",scrollbars=yes";
	} else {
		feature += ",scrollbars=no";
	}
	feature += ",left=" + 100;
	feature += ",top=" + 100;
	feature += ",width=" + popWidth;
	feature += ",height=" + popHeight;
	
	var vArguments = null;
	var sFeatures = "center:yes;status:no;help:no";
	if( scrollIt ){
		sFeatures += ";scroll:yes";
	} else {
		sFeatures += ";scroll:no";
	}
	sFeatures += ";dialogWidth:" + popWidth + "px";
	sFeatures += ";dialogHeight:"+ popHeight +"px";
	//alert(feature);

	
	var win = window.open(url+"",winName,feature);
	win.focus();
}

function popSelStatus(url,popWidth,popHeight,X,Y,scrollIt,winName){
	if(winName == null){
		winName = "_blank";
	}
	if(popWidth == null){
		popWidth = 600;
	}
	if(popHeight == null){
		popHeight = 500;
	}
	var popX,popY;
	if(X == null){
		var openerX = window.screenLeft;
		var openerWidth = document.body.clientWidth;
		popX = openerX + (openerWidth - popWidth) / 2;
	}
	else
	{
	  popX = X;
	}
	
	if(Y == null){
		var openerY = window.screenLeft;
		var openerHeight = document.body.clientHeight;
		popY = openerY + (openerHeight - popHeight) / 2;
	}
	else
	{
	  popY = Y;
	}

	var feature = "status=yes,resizable=no,menubar=no";
	if( scrollIt ){
		feature += ",scrollbars=yes";
	} else {
		feature += ",scrollbars=no";
	}
	feature += ",left=" + 100;
	feature += ",top=" + 100;
	feature += ",width=" + popWidth;
	feature += ",height=" + popHeight;
	
	var vArguments = null;
	var sFeatures = "center:yes;status:no;help:no";
	if( scrollIt ){
		sFeatures += ";scroll:yes";
	} else {
		sFeatures += ";scroll:no";
	}
	sFeatures += ";dialogWidth:" + popWidth + "px";
	sFeatures += ";dialogHeight:"+ popHeight +"px";
	//alert(feature);

	
	var win = window.open(url+"",winName,feature);
	win.focus();
}

	function towerAddEventListener(element, eventType, handler, capture) {
		try	{
			if (element.addEventListener)
				element.addEventListener(eventType, handler, capture);
			else if (element.attachEvent)
				element.attachEvent("on" + eventType, handler, capture);
		} catch (e) {}
	}

	/**
	 * 从root确定的子树中查找标签名为htmltag且类名为clsName的子节点数组.
	 * 
	 * @param clsName 	要查找的className
	 * @param htmltag 	要查找的html标签名,用于限定范围,缺省为所有标签("*")
	 * @param root		Dom子树的根节点对象,缺省为document
	 *
	 * @return 符合条件的节点数组
	 */
	function getElementsByClassName(clsName,htmltag,root){
		// 若没有提供htmltag参数,使用通配符"*"
		htmltag = htmltag ? htmltag : "*";
		// 若没有提供root参数,使用document
		root = root ? root : document;
	    var arr = new Array();
	    var elems = root.getElementsByTagName(htmltag);
	    var elem;
	    var className;
	    var classNames;
	    for ( var i = 0; i < elems.length; i++ ){
	    	elem = elems[i]
	    	className = ""+ ( elem.getAttribute("className") || elem.getAttribute("class") );
	    	
	    	if (className.length == 0) continue;
	    	
	    	classNames = (className).split(" ");
	    	for (var j = 0; j < classNames.length; j ++) {
			    if ( classNames[j] == clsName ){ 
			    	arr[arr.length] = elem;
		    	}
	    	}
	    }  
	    return arr;  
	}
	
	
	
	//图片按比例缩放

	//调用：<img src="图片" onload="javascript:DrawImage(this)">
	function DrawImage(ImgD,maxWidth,maxHeight){
		var image=new Image();
		var iwidth = maxWidth; //定义允许图片宽度，当宽度大于这个值时等比例缩小
	
		var iheight = maxHeight; //定义允许图片高度，当宽度大于这个值时等比例缩小
	
		image.src=ImgD.src;
		if(image.width>0 && image.height>0){
			if(image.width/image.height>= iwidth/iheight){
				if(image.width>iwidth){
					ImgD.width=iwidth;
					ImgD.height=(image.height*iwidth)/image.width;
				}else{
					ImgD.width=image.width;
					ImgD.height=image.height;
				}
		
				ImgD.alt=image.width+"×"+image.height;
			}else{
				if(image.height>iheight){
					ImgD.height=iheight;
					ImgD.width=(image.width*iheight)/image.height;
				}else{
					ImgD.width=image.width;
					ImgD.height=image.height;
				}
				ImgD.alt=image.width+"×"+image.height;
			}
		}
	}
	
	
/**
 * download url lite
 *
 * @author: legend(legendsky@hotmail.com)
 * @link: http://www.ugia.cn/?p=122
 * @version: 1.0
 *
 * @param string   url     
 * @param string   callback  回调函数
 * @param string   data      post数据
 *
 * @return void
 */
/*
	用法一：直接把回调函输写在参数中
	downloadUrl(’http://www.ugia.cn/wp-data/test.htm’, 
			function (data, responseCode) {
				alert(data); // 这里处理返回的数据
			}
	);

	用法二：先定义回调函数，然后传入
	function test(data, responseCode) {
		alert(data); // 这里处理返回的数据
	}

	downloadUrl(’http://www.ugia.cn/wp-data/test.htm’, test);
*/
 function downloadUrl(url, callback, data) {
     // init
     url += url.indexOf("?") >= 0 ? "&" : "?";
     url += "random_download_url=" + Math.random();
    
     if (typeof data == 'undefined') {
         var data = null;
     }
  
     method = data ? 'POST' : 'GET';
    
     // create XMLHttpRequest object
     if (window.XMLHttpRequest) {
         var objXMLHttpRequest = new XMLHttpRequest();
     } else {
         var MSXML = ['MSXML2.XMLHTTP.6.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
         for(var n = 0; n < MSXML.length; n ++) {
             try {
                 var objXMLHttpRequest = new ActiveXObject(MSXML[n]);       
                 break;
             } catch(e){ }
         }
     }
    
     // send request
     with(objXMLHttpRequest) {
         //setTimeouts(30*1000,30*1000,30*1000,30*60*1000);
         try {
             open(method, url, true);
            
             if (method == 'POST') {
                 setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
             }
            
             send(data);           
         } catch(e) {
             alert(e);
         }
        
         // on ready
         onreadystatechange = function() {
             if (objXMLHttpRequest.readyState == 4) {
                 callback(objXMLHttpRequest.responseText, objXMLHttpRequest.status);
                 delete(objXMLHttpRequest);
             }
         }
     }
 }
 
	function clearTable(tbl,from,to){
		if(!tbl) return;
		var rowCount = tbl.rows.length;
		from = from ? (from < rowCount ? from : rowCount - 1 ) : 0;
		to = to ? (to > from ? to : from) : rowCount;
		for(var i = from; i < to; i ++) {
			tbl.deleteRow(from);
		}
	}
	/**
	 * 用法：addRowToTable(表ID,列1数据,列2数据,...);
	 */
	function addRowToTable(tbl) {
		if(!tbl) return;
		var args = arguments;
		if(args.length > 1){
			var row = tbl.insertRow();
			for(var i = 1; i < args.length; i ++) {
				var cell = row.insertCell();
				cell.innerHTML = args[i];
				cell.id = size;
			}
		}
	}
	/**
	*用法：addRowToTable(表ID,单元格的id,列1数据,列2数据,...);
	*/
	function addRowToTable(tbl,size) {
		if(!tbl) return;
		var args = arguments;
		if(args.length > 2){
			var row = tbl.insertRow();
			for(var i = 2; i < args.length; i ++) {
				var cell = row.insertCell();
				cell.innerHTML = args[i];
				cell.id = size;
				cell.align="center";
			}
		}
	}
	function isTelephone(tele){
	 	if(tele != null && tele.length > 0){
		    var reg = new RegExp("^(\\d{3,4}-)?\\d{7,8}(#\\d{1,4})?$");
		    var regM = new RegExp("^(13|15)\\d{9}$");
		    var regR = reg.test(tele);
		    var regMR = regM.test(tele);
		    if(regR == true || regMR == true){
		    	return true;
		    }else{
		    	alert("输入的电话格式不对，请从新输入");
		   		return false;
		    }
		 }else{
		 	return true;
		 }
	}
	
	function getAbsolutePos(el) {
		var r = { x: el.offsetLeft, y: el.offsetTop };
		if (el.offsetParent) {
			var tmp = getAbsolutePos(el.offsetParent);
			r.x += tmp.x;
			r.y += tmp.y;
		}
		return r;
	}