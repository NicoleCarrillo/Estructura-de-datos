import java.util.NoSuchElementException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


//BINARY SEARCH TREE
public class BinaryTree {
	
	//BinaryTreeNode root;
	int nodos=0;
	int leaves=0;
	int ans=0;
	boolean caso=false;
	BinaryTreeNode prev;


	public BinaryTreeNode insertNode(BinaryTreeNode root,BinaryTreeNode node) {
		if(root==null) {
			root = node;
			return root;
		}else {
			//GO LEFT
			//IF THE VALUE IS SMALLER
			if(node.value < root.value) {
				root.left=insertNode(root.left,node);
			}else if(node.value > root.value) {
				//GO RIGHT
				//IF THE VALUE IS BIGGER
				root.right=insertNode(root.right,node);
			}
		}
		return root;
	}




	public int minValue(BinaryTreeNode root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root.value;
	}

	
	//PARA BORRAR SIEMPRE TE VAS PRIMERO A LA DERECHA Y LUEGO A LA IZQUIERDA 
	//HASTA LLEGAR AL ULTIMO Y ESE ES EL QUE INTERCAMBIAS

	public BinaryTreeNode removeNode(BinaryTreeNode root, int key) {
		if(root == null) {
			return root;
		}
		///Else go down the tree
		if(key > root.value) {
			root.right = removeNode(root.right, key);
		}
		else if(key < root.value) {
			root.left = removeNode(root.left, key);
		}
		// if key is same as root value, then THIS IS THE NODE 
		// WE ARE TRYING TO DELEVE
		else
		{ 
			// node with only one child or no child 
			if (root.left == null) 
				return root.right; 
			else if (root.right == null) 
				return root.left; 
			
			root.value = minValue(root.right); 
			root.right = removeNode(root.right, root.value); 

		} 
		return root;	
	}

	public int sum(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		else return root.value+sum(root.left)+sum(root.right);

	}

	public int sumMax(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		int left=sumMax(root.left);
		int right=sumMax(root.right);

		return (left>right)?left:right+root.value;
	}
	
	//condicion ? if true : if false
	
	public int difMin(BinaryTreeNode root) {
		// Pointer to previous node in the  
	    // in-order traversal of the BST  
	    prev = null;  
	      
	    // To store the final ans  
	    ans = Integer.MAX_VALUE;  
	      
	    // Call in-order for the BST  
	    inorderMin(root);  
	      
	    // Returning the final answer  
	    return ans;  
	}
	
	public void inorderMin(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		inorderMin(root.left);
		
		if (prev!=null) {
			ans=Math.min(root.value-prev.value,ans);
		}
		prev=root;
		
		inorderMin(root.right);
		
	}

	public String search(BinaryTreeNode root, int key) throws Exception {
		if(root.value==key) {
			return "LO ENCONTRE" + root.value;
		}else if(root.value<key&&root.right!=null) {
			return search(root.right,key);
		}else if(root.value>key&&root.left!=null) {
			return search(root.left,key);
		}else {
			throw new NoSuchElementException ("NO HAY ESE ELEMENTO");
		}
	}


	public void destroy(BinaryTreeNode root) {
		root.left=null;
		root.right=null;
		root=null;
	}

	public int height(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}else {
			return 1+ Math.max(height(root.left), height(root.right)); //SELECCIONA EL MAXIMO DE LOS DOS 
		}
	}

	public int nodeCount(BinaryTreeNode root) {	
		if(root!=null) {
			nodeCount(root.left);
			nodos++;
			nodeCount(root.right);
		}
		return nodos;
	}

	public int leavesCount(BinaryTreeNode root) {	
		if(root!=null) {
			leavesCount(root.left);
			if(root.left==null&&root.right==null)
				leaves++;
			leavesCount(root.right);
		}
		return leaves;
	}

	//search sin orden
	public boolean search2(BinaryTreeNode root,int key) {	
		if(root!=null) {
			if(root.value==key)
				caso= true;
			search2(root.left,key);
			if(root.left!=null&&root.left.value==key)
				caso=true;
			if(root.right!=null&&root.right.value==key)
				caso=true;
			search2(root.right,key);
			if(root.left!=null&&root.left.value==key)
				caso=true;
			if(root.right!=null&&root.right.value==key)
				caso=true;
		}
		return caso;
	}

	public BinaryTreeNode predecesor(BinaryTreeNode root){
		BinaryTreeNode current=root.left;
		while(current.right!=null) {
			current=current.right;
		}
		return current;
	}


	public void inorder(BinaryTreeNode root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.value+",");
			inorder(root.right);
		}
	}

	public void preorder(BinaryTreeNode root) {
		if(root!=null) {
			System.out.print(root.value+",");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void postorder(BinaryTreeNode root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.value+",");
		}
	}

	public void transversalOrder(BinaryTreeNode root) {
		int nivel=1;
		while(printTransversalOrder(root,nivel)) {
			nivel++;
		}
	}

	public boolean printTransversalOrder(BinaryTreeNode root, int nivel) {
		if(root==null) {
			return false;
		}
		if(nivel==1) {
			System.out.print(root.value+" , ");
			return true;
		}
		boolean left=printTransversalOrder(root.left, nivel-1);
		boolean right=printTransversalOrder(root.right, nivel-1);

		return right||left;
	}

	public void reverseTraveralOrder(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		// CREATE A EMPY QUEUE
		Queue<BinaryTreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		//CREATE A STACK
		Deque<Integer> stack = new ArrayDeque<>();

		BinaryTreeNode current;
		while(!queue.isEmpty()) {
			current=queue.poll();
			stack.push(current.value);

			if(current.right!=null) {
				queue.add(current.right);
			}

			if(current.left!=null) {
				queue.add(current.left);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.poll() + " ");
		}
	}


	//IMPRIME LA DIAGONAL \ ASI 
	public void diagonalPrint(BinaryTreeNode root) {
		// create an empty queue
		Queue<BinaryTreeNode> q = new ArrayDeque<>();

		// create a sentinel (dummy) node to denote end of a diagonal
		BinaryTreeNode sentinel=new BinaryTreeNode(-1);

		// enqueue all nodes of first diagonal in binary tree
		while(root!=null) {
			q.add(root);
			root=root.right;

		}

		// enqueue sentinel node at the end of each diagonal
		q.add(sentinel);

		// run till only sentinel is left
		while(q.size() != 1) {
			BinaryTreeNode current=q.poll();

			if(current!=sentinel) {
				System.out.print(current.value+" , ");

				BinaryTreeNode nodo=current.left;

				// enqueue nodes of next diagonal in binary tree
				while(nodo!=null) {
					q.add(nodo);
					nodo=nodo.right;
				}
			}else {
				// if end of current diagonal is reached, enqueue sentinel node
				q.add(sentinel);
				System.out.println(" ");
			}
		}
	}


	//IMPRIME LA DIAGONAL / ASI
	public void diagonalPrintReverse(BinaryTreeNode root) {
		// create an empty queue
		Queue<BinaryTreeNode> q = new ArrayDeque<>();

		// create a sentinel (dummy) node to denote end of a diagonal
		BinaryTreeNode sentinel=new BinaryTreeNode(-1);

		// enqueue all nodes of first diagonal in binary tree
		while(root!=null) {
			q.add(root);
			root=root.left;

		}

		// enqueue sentinel node at the end of each diagonal
		q.add(sentinel);

		// run till only sentinel is left
		while(q.size() != 1) {
			BinaryTreeNode current=q.poll();

			if(current!=sentinel) {
				System.out.print(current.value+" , ");

				BinaryTreeNode nodo=current.right;

				// enqueue nodes of next diagonal in binary tree
				while(nodo!=null) {
					q.add(nodo);
					nodo=nodo.left;
				}
			}else {
				// if end of current diagonal is reached, enqueue sentinel node
				q.add(sentinel);
				System.out.println(" ");
			}
		}
	}

	public boolean printAncestors(BinaryTreeNode root,BinaryTreeNode node) {

		if(root==null) {
			return false;
		}

		if(root.value==node.value) {
			return true;
		}

		boolean izq=printAncestors(root.left,node);

		boolean der=false;

		if(!izq) {
			der= printAncestors(root.right,node);
		}

		if(izq||der) {
			System.out.print(root.value+" , ");
		}
		return izq||der;
	}
	
	public int findCommonAncestor(BinaryTreeNode root,BinaryTreeNode node1, BinaryTreeNode node2){
		
		if(root==null) {
			return -1;
		}
		
		// if both x and y is smaller than root, LCA exists in left subtree
		if (root.value > Integer.max(node1.value, node2.value)) {
			return findCommonAncestor(root.left,node1,node2);
		}
		
		// if both x and y is greater than root, LCA exists in right subtree
		if (root.value < Integer.min(node1.value, node2.value)) {
			return findCommonAncestor(root.right,node1,node2);
		}
		
		// if one key is greater (or equal) than root and one key is smaller
		// (or equal) than root, then the current node is LCA
		return root.value;
		
		
	}
}
