package designpattern.behavior.interpreter.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * parser根据token列表中不同的token，生成不同的AstNode的子类，并组装成一个树
 */
public class AstNode {

	List<AstNode> children = new ArrayList<>();
	//不同的子类实现不同的计算细节
	public Object getValue(){
		return null;
	}
}
