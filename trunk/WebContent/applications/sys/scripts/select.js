/**
 * Tower.Selector
 */

var Tower;
if (!Tower) Tower = new Class();
if (!Tower.Widget) Tower.Widget = new Class();

/*******************************************************************************
功能：调用选择框类

类构造方法参数：
	selectorId	: 选择框ID，必须指定
	inputName	: 隐藏提交域Name，必须指定
	url			: 下拉框内容页面url，必须指定，如:"ctrl?FUNC_ID=SelectUser"
	options		: 用户选项，可选，如：{ok:"选定",wait:"正在连接服务器，请耐心等待..."}
	events		: 用户事件，可选，如：{change:onSelectorChange}
	
options可用选项：
	selected	: 选中ID值数组；如['0001','0002',"0003"]表示选中了三个选项
	select		: 选择按钮文本，缺省值为"选择"。
	ok			: 确定按钮文本，缺省值为"确定"。
	cancle		: 取消按钮文本，缺省值为"取消"。
	wait		: 进度提示文本，缺省值为"正在载入，请稍候……"；"none"表示不输出提示文本。
	
events可用选项：
	change		: 选中ID改变后的事件，若未改变选择项，不会触发；事件处理方法可接收两个参数：selectedIds=数组（元素为String），选中的选项值；selector=选择器
	ok			: 点击确定按钮后的事件；事件处理方法可接收一个参数：selector=选择器
	cancle		: 点击取消按钮或点击控件外区域后的事件；事件处理方法可接收一个参数：selector=选择器
	select		: 点击选择按钮后的事件；事件处理方法可接收一个参数：selector=选择器
	list		: 接收到下拉框后的事件；事件处理方法可接收两个参数：selector=选择器；isSelectClicked=布尔值:true=点击选择按钮后获得下拉框，false=HTML文档载入后获得下拉框
	
属性：
	id			: 选择框ID，参见构造方法参数
	inputName	: 隐藏提交域Name，参见构造方法参数
	url			: 下拉框内容页面url，参见构造方法参数
	options		: 用户选项，参见构造方法参数
	events		: 用户事件，参见构造方法参数
	element		: 选择框控制的HTML元素，此元素的manager属性指向其选择器
	inputHolder	: 输入域容器，内含一个或多个name为inputName的input型HTML元素，如：<input name="[inputName]" value="[value1]"><input name="[inputName]" value="[value2]">...
	displayer	: 显示选中文本的输入框
	downList	: 下拉框容器
	downListContent	: 下拉框内容
	selectButton	: 选择按钮
	okButton		: 确定按钮 
	cancleButton	: 取消按钮 
	withWait		: 是否显示等候提示
	waitText		: 等候提示文本
方法：
	getInputHolderSelected ()
		功能：取得inputHolder中选中的ID（一个或多个）
		返回：String[]=选中ID数组
		
	setInputHolderSelected (selectedIds)
		功能：设置inputHolder中选中的ID（一个或多个）
		参数：selectedIds=数组（元素为String）
		
	getDownListSelected ()
		功能：取得downList中选中的ID（一个或多个）
		返回：String[]=选中ID数组
		
	setDownListAndDisplayerSelected (selectedIds)
		功能：设置downList中选中的ID，并且设置displayer中选中的文本
		参数：selectedIds=数组（元素为String）
		
	setDisplayerSelected (selectedIds)
		功能：设置displayer中选中的文本
		参数：selectedIds=数组（元素为String）
	
	
用法举例：
	完整用法：
		head标签中定义事件方法
		<script>
			function onReceiverChange(selectedIds,selector) {
				alert("选择更改了");
				selectedIds.each(function(id)){
					alert("用户选择ID=" + id);
				});
				alert("用户选择了这些人：" + selector.displayer.value);
			}
			function onReceiverOkClick(selector) {
				alert("用户点确定了");
			}
			function onReceiverCancleClick(selector) {
				alert("用户点取消了");
			}
		</script>
		页面中需要显示的位置创建选择框：
		<script>
		new Tower.Widget.Selector(
			"ReceiverSelector",								// 指定选择框ID
			"RECEIVER_ID",									// 指定提交域Name
			"ctrl?FUNC_ID=SelectUser&FLAG=MailReceiver",	// 指定下拉框页面url
			{
				selected:["01","05"],						// 指定已经选中的值
				select:"选择收件人",							// 指定选择按钮文本
				ok:"选定",									// 指定确定按钮文本
				cancle:"隐藏",								// 指定隐藏文本
				wait:"正在连接"								// 指定等候文本
			},
			{
				change:onReceiverChange,					// 处理change事件
				ok:onReceiverOkClick,						// 处理ok事件
				cancle:onReceiverCancleClick				// 处理cancle事件
			}
		);
		</script>
	简捷用法：
		<script>new Tower.Widget.Selector("ReceiverSelector","RECEIVER_ID","ctrl?FUNC_ID=SelectUser&FLAG=MailReceiver");</script>
	修改选择按钮文本：
		<script>new Tower.Widget.Selector("ReceiverSelector","RECEIVER_ID","ctrl?FUNC_ID=SelectUser&FLAG=MailReceiver",
			{select:"选择人员"});</script>
	仅处理事件：
		<script>new Tower.Widget.Selector("ReceiverSelector","RECEIVER_ID","ctrl?FUNC_ID=SelectUser&FLAG=MailReceiver",{},{change:onReceiverChange});</script>

 ******************************************************************************/
Tower.Widget.Selector = new Class({
    initialize: function(selectorId,inputName,url,options,events){
    	this.id = selectorId;
    	this.inputName = inputName;
    	this.url = url;
    	// options:selected,select,ok,cancle,wait
		this.options = options ? options: {};
		// events:change(),ok(),cancle()
		this.events = events ? events: {};

		this.genHTML();

    	this.element = $(this.id);
    	this.element.manager = this;
		this.inputHolder = this.element.getElement(".inputHolder");
		this.displayer = this.element.getElement(".displayer");
		this.downList = this.element.getElement(".downList");
		this.downListContent = this.element.getElement(".downListContent");
		this.selectButton = this.element.getElement("input.selectButton");
		this.okButton = this.element.getElement("input.okButton");
		this.cancleButton = this.element.getElement("input.cancleButton");
		
		
		this.withWait = false;
		this.waitText = null;
		// 当未配置选项，或者选项wait不等于'none'，显示正在载入
		if(this.options["wait"] == null){
			this.waitText = "正在载入，请稍候……";
			this.withWait = true;
		} else if(this.options["wait"] != "none") {
			this.waitText = this.options["wait"];
			this.withWait = true;
		}

		this.initEvent();
    }
});

Tower.Widget.Selector.prototype.isDownListShowing = function () {
	return this.downList.hasClass("show");
};

Tower.Widget.Selector.prototype.getInputHolderSelected = function () {
	// 从inputHolder中的各隐藏域获得选中值
	var selectedIds = [];
	this.inputHolder.getElements("input").each(function (input) {
		selectedIds.push(input.getProperty("value"));
	});
	return selectedIds;
};

Tower.Widget.Selector.prototype.setInputHolderSelected = function (selectedIds) {
	// 用selectedIds，设置inputHolder的隐藏域，
	var inputHolderHtml = new String();
	var inputName = this.inputName;
	selectedIds.each(function (selectedId) {
		inputHolderHtml = inputHolderHtml.concat('<input type="hidden" name="' + inputName + '" value="' + selectedId + '">');
	});
	this.inputHolder.empty().setHTML(inputHolderHtml);
};

Tower.Widget.Selector.prototype.getDownListSelected = function () {
	// 从downListContent中获取选中值
	var selectedIds = [];
	this.downListContent.getElements("input").each(function(input) {
		if(input.getProperty("checked") == true) {
			selectedIds.push(input.getProperty("value"));
		}
	});
	return selectedIds;
};

Tower.Widget.Selector.prototype.setDownListAndDisplayerSelected = function (selectedIds) {
	// 设置downList中的各input选中状态，设置displayer文本
	var displayText = "";
	this.downListContent.getElements("input").each(function(input) {
		if(selectedIds.contains(input.value)) {
			input.setProperty("checked",true);
			if(displayText.length > 0 ) displayText = displayText.concat(",");
			displayText = displayText.concat(input.getProperty("text"));
		} else {
			input.setProperty("checked",false);
		}
	});
	this.displayer.setProperty("value",displayText);
};

Tower.Widget.Selector.prototype.setDisplayerSelected = function (selectedIds) {
	// 设置displayer文本
	var displayText = "";
	this.downListContent.getElements("input").each(function(input) {
		if(selectedIds.contains(input.value)) {
			if(displayText.length > 0 ) displayText = displayText.concat(",");
			displayText = displayText.concat(input.getProperty("text"));
		}
	});
	this.displayer.setProperty("value",displayText);
};

Tower.Widget.Selector.prototype.onDomReady = function () {
	// 如果有选中值，获得url内容
	if(this.options["selected"] && this.options["selected"].length > 0) {
		this.getUrlContent(false,this.options["selected"]);
	}
};

Tower.Widget.Selector.prototype.onSelectButtonClick = function () {
	// 禁用selectButton
	this.selectButton.setProperty("disabled",true);
	// 调用select事件
	if(this.events["select"]) {
		this.events["select"](this);
	}
	// 获取下拉框内容
	this.getUrlContent(true);
};

Tower.Widget.Selector.prototype.onOkButtonClick = function () {
	// 从downList中获得选中值
	var downListSelectedIds = this.getDownListSelected();
	// 从inputHolder中获取选中值
	var inputHolderSelectedIds = this.getInputHolderSelected();
	
	// 获取选择项是否改变
	var changed = false;
	for(var i = 0; i < downListSelectedIds.length; i ++) {
		if(!inputHolderSelectedIds.contains(downListSelectedIds[i])){
			changed = true;
			break;
		}
	}
	if(!changed){
		for(var i = 0; i < inputHolderSelectedIds.length; i ++) {
			if(!downListSelectedIds.contains(inputHolderSelectedIds[i])){
				changed = true;
				break;
			}
		}
	}
	if(changed) {
		// 设置inputHolder选中值
		this.setInputHolderSelected(downListSelectedIds);
		// 设置显示文本
		this.setDisplayerSelected(downListSelectedIds);
		// 调用change事件
		if(this.events["change"]) {
			this.events["change"](downListSelectedIds,this);
		}
	}
	
	// 隐藏下拉框
	this.hideDownList();
	// 启用selectButton
	this.selectButton.removeProperty("disabled");
	// 调用ok事件
	if(this.events["ok"]) {
		this.events["ok"](this);
	}
};

Tower.Widget.Selector.prototype.onCancleButtonClick = function () {
	// 隐藏下拉框
	this.hideDownList();
	// 启用selectButton
	this.selectButton.removeProperty("disabled");
	// 调用cancle事件
	if(this.events["cancle"]) {
		this.events["cancle"](this);
	}
};

Tower.Widget.Selector.prototype.genHTML = function () {
	var selectorHtml = '<div class="selector"';
	selectorHtml += ' id="' + this.id + '">';
	selectorHtml += '<div class="inputHolder"></div>';
	selectorHtml += '<input class="displayer" type="text" readonly="readonly">';
	selectorHtml += '<input class="selectButton" type="button" value="'
		+ (this.options["select"] ? this.options["select"] : "选择")
		+ '">';
	selectorHtml += '<div class="downList">';
	selectorHtml += '<div class="downListContent"></div>';
	selectorHtml += '<div class="commandBar">';
	selectorHtml += '<input class="okButton" type="button" value="'
		+ (this.options["ok"] ? this.options["ok"] : "确定")
		+ '">';
	selectorHtml += '&nbsp;';
	selectorHtml += '<input class="cancleButton" type="button" value="'
		+ (this.options["cancle"] ? this.options["cancle"] : "取消")
		+ '">';
	selectorHtml += '</div>'; // end commandBar
	selectorHtml += '</div>'; // end downList
	selectorHtml += '</div>'; // end selector
	// 输出html
	document.writeln(selectorHtml);
};

Tower.Widget.Selector.prototype.showDownList = function () {
	//alert('now showDownList');
	this.downList.addClass("show");
	// 设置downList显示位置
	var displayerCoordinates = this.displayer.getCoordinates();
	this.downList.setStyle("left",displayerCoordinates.left + "px");
	this.downList.setStyle("top",displayerCoordinates.top + displayerCoordinates.height + "px");
	// 隐藏downList显示区域内的控件
	Tower.Util.hideShowCovered(this.downList);
};

Tower.Widget.Selector.prototype.onDocumentClick = function (event) {
	//alert("Catch Clicked!");
	// 获得当前事件对象	
	var el = event.target;
	
	// 若当前事件对象属于downList的孩子，不做操作；否则调用取消按钮click方法
	for (; el != null && el != this.downList; el = el.parentNode);
	if (el == null) {
		event.stop;
		this.onCancleButtonClick();
	}
};

Tower.Widget.Selector.prototype.hideDownList = function () {
	//alert('now hideDownList');
	this.downList.removeClass("show");
	// 显示downList显示区域内的控件
	Tower.Util.hideShowCovered(this.downList);
	// 移除事件
	document.removeEvent("click",this.onDocumentClickRef);
};

Tower.Widget.Selector.prototype.getUrlContent = function (isSelectClicked) {
	if(isSelectClicked && this.withWait) {
		// 显示正在载入
		this.downListContent.empty().setHTML(this.waitText);
		// 显示下拉框
		this.showDownList();
		// 禁用确定、取消按钮
		this.okButton.setProperty("disabled",true);
		this.cancleButton.setProperty("disabled",true);
	}
	
	// 获取下拉框内容
	downloadUrl(
		this.url,
		function (data, responseCode){
			// 设置downListContent
			this.downListContent.empty().setHTML(data);
			// 设置选中
			this.urlFinishCallBack(isSelectClicked);
			
		}.bind(this)
	);
};

Tower.Widget.Selector.prototype.urlFinishCallBack = function (isSelectClicked) {
	var selectedIds;
	if(isSelectClicked){
		// 若是Select按钮点击
		// 从inputHolder中的各隐藏域获得选中值
		selectedIds = this.getInputHolderSelected();
			
		// 设置downList中的各input选中状态，设置displayer文本
		this.setDownListAndDisplayerSelected(selectedIds);
		
		// 若显示正在载入
		if(this.withWait){
			// 隐藏downList显示区域内的控件
			Tower.Util.hideShowCovered(this.downList);
			// 启用确定、取消按钮
			this.okButton.removeProperty("disabled");
			this.cancleButton.removeProperty("disabled");
		} else {
			// 显示下拉框
			this.showDownList();
		}
		// 添加document.click事件，即点击别处隐藏本控件
		this.onDocumentClickRef = this.onDocumentClick.bind(this).bindWithEvent(this);
		document.addEvent("click",this.onDocumentClickRef);
	} else {
		// 否则domReady
		// 从options中获得选中值
		selectedIds = this.options["selected"];
		// 用selectedIds，设置inputHolder的隐藏域，
		this.setInputHolderSelected(selectedIds);
		// 设置displayer文本
		this.setDisplayerSelected(selectedIds);
	}
	// 调用urlFinish事件
	if(this.events["list"]) {
		this.events["list"](this,isSelectClicked);
	}
};

Tower.Widget.Selector.prototype.initEvent = function () {
	// DomReady事件
	window.addEvent(
		'domready', this.onDomReady.bind(this)
	);
	// 选择按钮click事件
	this.selectButton.addEvent(
		'click', this.onSelectButtonClick.bind(this)
	);
	// 确定按钮click事件
	this.okButton.addEvent(
		'click', this.onOkButtonClick.bind(this)
	);
	// 取消按钮click事件
	this.cancleButton.addEvent(
		'click', this.onCancleButtonClick.bind(this)
	);
};


/*
 * Utils
 */
if (!Tower.Util) Tower.Util = new Class({});
Tower.Util.hideShowCovered = function (el) {
	function getStyleProp(obj, style){
		var value = obj.style[style];
		if (!value) {
			if (document.defaultView && typeof (document.defaultView.getComputedStyle) == "function") { // Gecko, W3C
				value = document.defaultView.
					getComputedStyle(obj, "").getPropertyValue(style);
			} else if (obj.currentStyle) { // IE
				value = obj.currentStyle[style];
			} else {
				value = obj.style[style];
			}
		}
		return value;
	};

	var tags = new Array("applet", "iframe", "select");

	var p = getAbsolutePos(el);
	var EX1 = p.x;
	var EX2 = el.offsetWidth + EX1;
	var EY1 = p.y;
	var EY2 = el.offsetHeight + EY1;

	for (var k = tags.length; k > 0; ) {
		var ar = document.getElementsByTagName(tags[--k]);
		var cc = null;

		for (var i = ar.length; i > 0;) {
			cc = ar[--i];

			p = getAbsolutePos(cc);
			var CX1 = p.x;
			var CX2 = cc.offsetWidth + CX1;
			var CY1 = p.y;
			var CY2 = cc.offsetHeight + CY1;

			if (this.hidden || (CX1 > EX2) || (CX2 < EX1) || (CY1 > EY2) || (CY2 < EY1)) {
				if (!cc.__msh_save_visibility) {
					cc.__msh_save_visibility = getStyleProp(cc, "visibility");
				}
				cc.style.visibility = cc.__msh_save_visibility;
			} else {
				if (!cc.__msh_save_visibility) {
					cc.__msh_save_visibility = getStyleProp(cc, "visibility");
				}
				cc.style.visibility = "hidden";
			}
		}
	}
}