
	<!--
/*
树结构
	子树:------------------------------------------------------------------------
	<div>
		节点1
		子树容器1
		节点2
		子树容器2
		...
		节点n
		子树容器n
	</div>
	----------------------------------------------------------------------------
	
	节点:------------------------------------------------------------------------
		<div>
			<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">父节点名称A</a>
			&nbsp;&nbsp;
			<a href="#" class="treeShowHideAll" onclick="showHideAll(this)">全部</a>
		</div>
		或(不带展开/折叠子树节点)
		<div>
			<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">父节点名称A</a>
		</div>
	----------------------------------------------------------------------------
	
	子树容器:---------------------------------------------------------------------
		<div>
			子树
		</div>
		或
		<div class="tree">
			子节点内容
		</div>
	----------------------------------------------------------------------------
		
示例:
	<div>
		<div>
			<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">父节点A</a>
			&nbsp;&nbsp;
			<a href="#" class="treeShowHideAll" onclick="showHideAll(this)">全部</a>
		</div>
		<div class="tree">
			<div>
				<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">子节点Aa</a>
			</div>
			<div class="tree">
				子节点Aa内容
			</div>
			<div>
				<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">子节点Ab</a>
			</div>
			<div class="tree">
				子节点Ab内容
			</div>
		</div>
		<div>
			<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">父节点B</a>
			&nbsp;&nbsp;
			<a href="#" class="treeShowHideAll" onclick="showHideAll(this)">全部</a>
		</div>
		<div class="tree">
			<div>
				<a href="#" class="treeIconOpen" onclick="doTreeIconClick(this)">子节点Ba</a>
			</div>
			<div class="tree">
				子节点Ba内容
			</div>
		</div>
	</div>
示例显示效果:
父节点A 全部
	子节点Aa
		子节点Aa内容
	子节点Ab
		子节点Ab内容
父节点B 全部
	子节点Ba
		子节点Ba内容

 */
	
	/**
	 * 菜单(树)图标点击事件处理方法.
	 * 
	 * @param nodeIcon 图标对象
	 */
	function doTreeIconClick(nodeIcon){
		var subTree = getSubTree(nodeIcon);
		//alert(tree);
		//listPropertiesOfObject(tree);
		
		var treeNode = getTreeNode(nodeIcon);
		
		if( containsClassName(treeNode,"treeNodeOpen")) {
			removeClassName(treeNode,"treeNodeOpen");
			addClassName(subTree,"treeHidden");
		} else {
			addClassName(treeNode,"treeNodeOpen");
			removeClassName(subTree,"treeHidden");
		}
		nodeIcon.blur();
	}
	
	function doTreeNodeTitleClick(nodeBody){
		var nodeIcon = getPreviousSiblingByTagName(nodeBody,"a");
		doTreeIconClick(nodeIcon);
		nodeBody.blur();
	}
	
	function doTreeNodeCrossClick(nodeCross){
		var nodeIcon = getNextSiblingByTagName(nodeCross,"a");
		doTreeIconClick(nodeIcon);
		nodeCross.blur();
	}
	
	function getTreeNode(nodeIcon){
		return nodeIcon.parentNode;
	}
	
	/**
	 * 根据子节点项目,获得子节点容器
	 * @param treeNodeItem	子节点项目,如节点图标,节点输入框,节点标题等
	 * @return 子节点容器
	 */
	function getSubTree(treeNodeItem) {
		//listPropertiesOfObject(nodeIcon);
		//listPropertiesOfObject(nodeIcon.parentNode);
		//listPropertiesOfObject(nodeIcon.parentNode.nextSibling);
		var subTree = treeNodeItem.parentNode;
		subTree = getNextSiblingByTagName(subTree,"div");
		if(containsClassName(subTree,"tree")){
			return subTree;
		}
		return null;
	}
	
	function showAllSelected(tree){
		var parentTree;
		var parentTreeNode;
		tree.getElements("input").each(function(input) {
			// 对选中的INPUT
			if(input.getProperty("checked") == true) {
				// 查找所在tree
				parentTree = getParentTree(input);
				while(parentTree != null) {
					// 查找父节点
					parentTreeNode = getNodeBySubTree(parentTree);
					if(parentTreeNode == null){
						break;
					}
					// 设置属性
		
					if(!containsClassName(parentTreeNode,"treeNodeOpen")) {
						addClassName(parentTreeNode,"treeNodeOpen");
						removeClassName(parentTree,"treeHidden");
					}
					
					parentTree = getParentTree(parentTreeNode);
				}
			}
		});
	}
	
	function getParentTree(treeNodeItem){
		var res = treeNodeItem;
		while(res != null) {
			if(containsClassName(res,"tree")){
				return res;
			}
			res = res.parentNode;
		}
		return null;
	}
	
	function getNodeBySubTree(subTree){
		var treeNode = getPreviousSiblingByTagName(subTree,"div");
		if(containsClassName(treeNode,"treeNode")){
			return treeNode;
		}
		return null;
	}
	
	/**
	 * 显示/折叠 子树
	 */
	function showHideAll(allIcon,tree){
		//listPropertiesOfObject(allIcon);
		var rootIcon = getPreviousSiblingByTagName(allIcon,"a");
		//listPropertiesOfObject(rootIcon);
		var rootTree = tree;		
		var treeNodes;
		var treeIcon;
		treeNodes = getElementsByClassName("treeNode","div",rootTree);
		//listPropertiesOfObject(allIcon);
		if ("展开"==getText(allIcon)){
			setText(allIcon,"收缩");
			
			for (var i = 0; i < treeNodes.length; i ++) {
				if(!containsClassName(treeNodes[i],"treeNodeOpen")){
					treeIcon = getElementsByClassName("treeIcon","a",treeNodes[i]);
					if(treeIcon && treeIcon.length > 0){
						doTreeIconClick(treeIcon[0]);
					}
				}
			}
		} else {
			setText(allIcon,"展开");
			
			for (var i = 0; i < treeNodes.length; i ++) {
				if(containsClassName(treeNodes[i],"treeNodeOpen")){
					treeIcon = getElementsByClassName("treeIcon","a",treeNodes[i]);
					if(treeIcon && treeIcon.length > 0){
						doTreeIconClick(treeIcon[0]);
					}
				}
			}
		}
		allIcon.blur();
	}
	
	function doCheckBoxClick(checkBox){
		// 移去焦点
		checkBox.blur();
		// 查询CheckBox容器
		var inputSpan = checkBox.parentNode;
		//listPropertiesOfObject(inputSpan);
		// 查询有无下级CheckBox,若有,更新所有下级的选中状态为当前CheckBox选中状态
		// 查询下级树
		var subTree = getSubTree(inputSpan);
		if(subTree){
			//alert(subTree.innerHTML);
			var subCheckBoxes = subTree.getElementsByTagName("input");
			//alert(subCheckBoxes.length);
			//alert(checkBox.checked);
			if(checkBox.checked){
				for(var i = 0; i < subCheckBoxes.length; i ++) {
					subCheckBoxes[i].checked = true;
				}
			} else {
				for(var i = 0; i < subCheckBoxes.length; i ++) {
					subCheckBoxes[i].checked = false;
				}
			}
		}
		
		// 查询所有上级CheckBox
		// 对每个上级查找其同级CheckBox
		// 若同级CheckBox中有选中的,更新其上级CheckBox为选中
		// 若同级CheckBox均未选中,更新其上级CheckBox为没选中
		var parentTree = inputSpan.parentNode.parentNode;
		while(parentTree&&containsClassName(parentTree,"tree")) {
			var subCheckBoxes = parentTree.getElementsByTagName("input");
			var allUnChecked = true;
		
			for(var i = 0; i < subCheckBoxes.length; i ++) {
				if(subCheckBoxes[i].checked) {
					allUnChecked = false;
					break;
				}
			}
			var parentTreeNode = getPreviousSiblingByTagName(parentTree,"div");
			
			if(containsClassName(parentTreeNode,"treeNode")){
				var parentCheckBox = parentTreeNode.getElementsByTagName("input");
				if(parentCheckBox && parentCheckBox.length > 0) {
					parentCheckBox = parentCheckBox[0];
					if(allUnChecked) {
						parentCheckBox.checked = false;
					} else {
						parentCheckBox.checked = true;
					}
				}
			}
			
			parentTree = parentTree.parentNode;
		}
	}
	
	function doTitle(title){
		var father = title.parentNode;
  	 	if(containsClassName(father,"treeNode")){
	  	 	var radio = father.getElementsByTagName("input");
	  	 	if(radio && radio.length > 0) {
	  	 		if(!radio.checked){
	  	 		radio.checked =true;
	  	 	}
	  	 }
	  	 	
  	 	}
  	}
  	
  	
	/* ----以下为通用方法,在以上的方法中使用--------------------------------------- */
	/**
	 * 显示某对象属性/方法(用于调试,此处不显示以on开头的属性/方法)
	 */
	function listPropertiesOfObject(obj){
		var res = "";
		res += "";
		for(var p in obj) {
			if((p+"").indexOf("on")==0
				||obj[p]==null||obj[p]==""
				||typeof(obj[p])=="function") 
				continue;
			res += p + " : " + typeof(obj[p]) + " = [" + obj[p]+"]\n";
		}
		alert(res);
		return res;
	}
	
	/**
	 * 查找自身节点最近的兄节点,并且其标签名为htmltag.
	 * 
	 * @param self 		自身节点
	 * @param htmltag 	要查找的html标签名,用于限定范围,缺省为所有标签("*")
	 *
	 * @return 符合条件的节点
	 */
	function getPreviousSiblingByTagName(self,htmltag){
		// 若没有提供htmltag参数,使用通配符"*"
		htmltag = htmltag ? htmltag.toUpperCase() : "*";
		
		var previous = self;
		var tagName;
		while(previous = previous.previousSibling) {
			//alert("tagName:"+previous.tagName);
			tagName = previous.tagName;
			//alert("=?:"+new String(tagName).toUpperCase());
			if (tagName && ("*" == htmltag || new String(tagName).toUpperCase() == htmltag) ) {
				//listPropertiesOfObject(previous);
				return previous;
			}
		}
	}
	
	/**
	 * 查找自身节点最近的弟节点,并且其标签名为htmltag.
	 * 
	 * @param self 		自身节点
	 * @param htmltag 	要查找的html标签名,用于限定范围,缺省为所有标签("*")
	 *
	 * @return 符合条件的节点
	 */
	function getNextSiblingByTagName(self,htmltag){
		// 若没有提供htmltag参数,使用通配符"*"
		htmltag = htmltag ? htmltag.toUpperCase() : "*";
		
		var next = self;
		var tagName;
		while(next = next.nextSibling) {
			//alert("tagName:"+next.tagName);
			tagName = next.tagName;
			//alert("=?:"+new String(tagName).toUpperCase());
			if (tagName && ("*" == htmltag || new String(tagName).toUpperCase() == htmltag) ) {
				//listPropertiesOfObject(next);
				return next;
			}
		}
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
	    for ( var i = 0; i < elems.length; i++ ){
	    	elem = elems[i]
	    	
	    	if (containsClassName(elem,clsName)){
		    	arr[arr.length] = elem;
	    	}
	    }  
	    return arr;
	}
	
	function setText(obj,text){
		if(document.all){
			obj.innerText = text;
		} else {
			obj.textContent = text;
		}
	}
	
	function getText(obj){
		if(document.all){
			return obj.innerText;
		} else {
			return obj.textContent;
		}
	}
	
	function getClassName(obj) {
		if(!obj)
			return null;
		var className = obj.getAttribute("class") || obj.getAttribute("className");
		return className;
	}
	
	function setClassName(obj,className){
		if(!obj)
			return;
		obj.setAttribute("class",className);
		obj.setAttribute("className",className);
	}
	
	function containsClassName(obj, className) {
		if ((getClassName(obj) && getClassName(obj).search(new RegExp("\\b" + className + "\\b")) != -1))
			return true;
		return false;
	}
	
	function addClassName(obj, className) {
		if (! containsClassName(obj, className)) {
			var orgClassName = getClassName(obj);
			setClassName(obj,(orgClassName ? orgClassName + " " : "") + className);
		}
	}
	
	function removeClassName(obj, className) {
		if (containsClassName(obj, className)) {
			var orgClassName = getClassName(obj);
			setClassName(obj,orgClassName.replace(new RegExp("\\s*\\b" + className + "\\b", "g"), ""));
		}
	}
	//-->