package designpattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：树结构的专用模式
 */
public class CompositeTest {
	public static void main(String[] args) {
		BranchNode root = new BranchNode("公司");
		BranchNode jsb = new BranchNode("技术部");
		LeafNode node1 = new LeafNode("张三");
		LeafNode node2 = new LeafNode("李四");
		LeafNode node3 = new LeafNode("王五");
		jsb.add(node1).add(node2).add(node3);
		BranchNode rsb = new BranchNode("人事部");
		LeafNode leafNode1 = new LeafNode("如花");
		rsb.add(leafNode1);
		root.add(jsb).add(rsb);

		show(root, 0);
	}
	public static void show(Node node, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("--");
		}
		node.doSomething();
		if (node instanceof BranchNode) {
			for (Node subNode : ((BranchNode) node).nodes) {
				show(subNode, level+1);
			}
		}
	}

}
abstract class Node<T> {
	T data;

	public Node(T data) {
		this.data = data;
	}

	abstract public void doSomething();
}
class BranchNode extends Node {
	List<Node> nodes = new ArrayList<>();
	public BranchNode(Object data) {
		super(data);
	}
	public BranchNode add(Node node) {
		nodes.add(node);
		return this;
	}
	@Override
	public void doSomething() {
		System.out.println(data);
	}
}
class LeafNode extends Node {

	public LeafNode(Object data) {
		super(data);
	}

	@Override
	public void doSomething() {
		System.out.println(data);
	}
}