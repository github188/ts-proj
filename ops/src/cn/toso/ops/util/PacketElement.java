package cn.toso.ops.util;

/**
 * 报文或报文头要素定义类
 * 
 * @author suilaiji
 */
public class PacketElement {

	/**
	 * 常量:左侧填充模式,fillMode可取值之一,对应配置文件中fillMode节点值填写left的情况
	 */
	public static final int FILL_MODE_LEFT = 1;

	/**
	 * 常量:右侧填充模式,fillMode可取值之一,对应配置文件中fillMode节点值填写right的情况
	 */
	public static final int FILL_MODE_RIGHT = 2;

	/**
	 * 要素名
	 */
	public String name;

	/**
	 * 要素描述
	 */
	public String description;

	/**
	 * 要素字节长度
	 */
	public int length;

	/**
	 * 要素填充字节
	 */
	public byte fillCharacter;

	/**
	 * 填充模式,可取值:Element.FILL_MODE_LEFT(左侧补齐),Element.FILL_MODE_RIGHT(右侧补齐)
	 */
	public int fillMode;

	/**
	 * 输出类的String描述,供调试用
	 */
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("[name:");
		res.append(name);
		res.append("; description:");
		res.append(description);
		res.append("; length:");
		res.append(length);
		res.append("; fillCharacter:");
		res.append(fillCharacter);
		res.append("; fillMode:");
		if (fillMode == FILL_MODE_LEFT) {
			res.append("left");
		} else if (fillMode == FILL_MODE_RIGHT) {
			res.append("right");
		} else {
			res.append("invalid (" + fillMode + ")");
		}
		res.append("]");
		return res.toString();
	}
}
