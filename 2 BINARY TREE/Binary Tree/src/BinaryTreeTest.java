//BINARY SEARCH TREE
//NICOLE CARRILLO CAPRISTAN

public class BinaryTreeTest {
	
	public static void main(String[] args) throws Exception {
		//BinaryTreeNode leaf=new BinaryTreeNode(12);
		//BinaryTreeNode leaf2=new BinaryTreeNode(15);
		BinaryTreeNode root=null;
		
		//BinaryTreeNode root=new BinaryTreeNode(20);
		
		BinaryTreeNode leaf=new BinaryTreeNode(10);
		
		BinaryTree bt=new BinaryTree();
		//root=bt.insertNode(root,new BinaryTreeNode(20));
//		//root=bt.insertNode(root,new BinaryTreeNode(10));
//		root=bt.insertNode(root,leaf);
//		root=bt.insertNode(root,new BinaryTreeNode(30));
//		root=bt.insertNode(root,new BinaryTreeNode(8));
//		root=bt.insertNode(root,new BinaryTreeNode(15));
//		root=bt.insertNode(root,new BinaryTreeNode(2));
//		root=bt.insertNode(root,new BinaryTreeNode(25));
//		root=bt.insertNode(root,new BinaryTreeNode(40));
//		root=bt.insertNode(root,new BinaryTreeNode(14));
//		root=bt.insertNode(root,new BinaryTreeNode(13));
		//root=bt.insertNode(root,new BinaryTreeNode(1));
		//root=bt.insertNode(root,new BinaryTreeNode(3));
		
		
		///////////////////////////////////////////////////////////////////////
		root=bt.insertNode(root,new BinaryTreeNode(4));
		root=bt.insertNode(root,new BinaryTreeNode(2));
		root=bt.insertNode(root,new BinaryTreeNode(1));
		root=bt.insertNode(root,new BinaryTreeNode(3));
		root=bt.insertNode(root,new BinaryTreeNode(6));
		
		System.out.println(bt.difMin(root));
		
		//System.out.println(root.value);
		//bt.inorder(root);
		//bt.preorder(root);
		//bt.postorder(root);
		//bt.transversalOrder(root);
		//bt.reverseTraveralOrder(root);
		//bt.diagonalPrint(root);
		//bt.diagonalPrintReverse(root);
		//System.out.println(" ");
		//System.out.println("--------------------------");
		//System.out.println(bt.height(leaf));
		//System.out.println(bt.height(root));
		//System.out.println(" ");
		//System.out.println("--------------------------");
		//System.out.println(bt.sum(leaf));
		//System.out.println(bt.sum(root));
		//System.out.println(bt.sumMax(root));
		//System.out.println(" ");
		//System.out.println("--------------------------");
		//bt.removeNode(root, 20);
		//bt.inorder(root);
		//bt.removeNode(root, 30);
		//bt.removeNode(root, 8);
		//bt.removeNode(root, 15);
		//bt.inorder(root);
		//System.out.println("--------------------------");
		//System.out.println(bt.search(root,10));
		//System.out.println(bt.search(root,20));
		//System.out.println(bt.search(root,8));
		//System.out.println(bt.search(root,2));
		//System.out.println(bt.search(root,40));
		//System.out.println(bt.search(root,30));
		//System.out.println(bt.search(root,25));
		//System.out.println(bt.search(root,100));
		//System.out.println(bt.search2(root,24));
		//bt.printAncestors(root,leaf);
		//System.out.println(bt.nodeCount(root));
		//System.out.println(bt.leavesCount(root));
	}
}
