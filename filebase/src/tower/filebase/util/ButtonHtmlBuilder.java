package tower.filebase.util;

import java.util.Hashtable;

/**
 * 
 * @author fanlj
 *
 */
public class ButtonHtmlBuilder {
	/**
	 * <strong>输入：</strong><br>
	 * <br>1、操作权限码
	 * <strong>业务逻辑：</strong><br>
	 * <br>1、解析权限码
	 * <br>2、根据权限标志位获取获取权限状态
	 * <br>3、根据权限标志位判断应该有哪些权限
	 * <br>4、根据权限组装buttonHtml
	 * <strong>输出：</strong><br>
	 * <br>权限按钮的html
	 * <br>
	 */
	
	//目录权限码标识位
	private static int readFlag=3;	  //读取
	
	private static int editFlag=2;	  //编辑
	
	private static int ADMFlag=1;	  //增、删、改
	
	private static int destroyFlag=0; //销毁
	
	public static Hashtable buildHtml(String permNo ){
		Hashtable button = new Hashtable();
		char flag;
		
		//读权限
		flag = permNo.charAt(readFlag);
		if(flag == '1'){
			button.put("down", "");
		}
		//编辑
		flag = permNo.charAt(editFlag);
		if(flag == '1'){
			button.put("editDown", "");
			button.put("getVersion", "");
		}
		//增、删、改
		flag = permNo.charAt(ADMFlag);
		if(flag == '1'){
			button.put("add", "");
			button.put("editUp", "");
			button.put("copy", "");
			button.put("move", "");
			button.put("delete", "");
		}
		//销毁
		flag = permNo.charAt(destroyFlag);
		if(flag == '1'){
			button.put("rollBackVersion", "");
			button.put("destroy", "");
			
		}
		
		return button;
	}
}
