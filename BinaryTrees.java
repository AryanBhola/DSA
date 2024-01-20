package dsa;
import java.util.*;
public class BinaryTrees {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			
		}
	}

	static class BinaryTree{
		static int idx = -1;
		//This function will return the Parent Node
		public static Node buildTree(int nodes[]) {
			idx++;
			if(idx >= nodes.length) {
				return null;
			}
			if(nodes[idx] == -1) {
				return null;
			}
			//Parent
			Node newNode = new Node(nodes[idx]);
			// Left
			newNode.left = buildTree(nodes);
			// Right
			newNode.right = buildTree(nodes);
			
			return newNode;
		}
		
		public static void preOrder(Node root) {
			if(root == null) {
				return;
			}
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
			
		}
		public static void inOrder(Node root) {
			if(root == null) {
				//ystem.out.print(" ");
				return;
			}
			inOrder(root.left);
			System.out.print(root.data + " ");			
			inOrder(root.right);
			
		}
		public static void postOrder(Node root) {
			if(root == null) {
				return;
			}
			postOrder(root.left);					
			postOrder(root.right);
			System.out.print(root.data + " ");	
			
		}
	
	public static void levelOrder(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		
		while(!q.isEmpty()) {
			Node curr = q.poll();// removes present head
			System.out.print(curr.data + " ");
			if(curr == null) {
				q.add(null);
			}
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
			
		}
		
	}
	
	public static int height(Node root) {
		// If every node gives you their height using recursion 
		// calculation is easy
		if(root == null) {
			return 0; 
		}
		int leftH = height(root.left);
		int rightH = height(root.right);
		int height = Math.max(leftH,rightH) + 1;
		return height;
	}
	public static int nodeCount(Node root) {
		if(root == null) {
			return 0;
		}
		int leftN = nodeCount(root.left);
		int rightN = nodeCount(root.right) ;
		int nodes = leftN + rightN +1;
		return nodes;
	}
	public static int sumNodes(Node root) {
		if(root == null) {
			return 0;
		}
		int leftsum = sumNodes(root.left);
		int rightsum = sumNodes(root.right);
		int sum = root.data + leftsum + rightsum;
		return sum;
		
	}
	public static int diameter(Node root) {
		if(root == null) {
			return 0;
		}
		int ldiam = diameter(root.left);
		int rdiam = diameter(root.right);
		int lh = height(root.left);
		int rh = height(root.right);
	
		int selfdiam = lh + rh + 1;
		
		
		return Math.max(ldiam,Math.max(rdiam, selfdiam));
	}
	
	}
	/* checking if subroot is part of tree(start)*/
	public static boolean isIdentical(Node root,Node subroot) {
		if(root == null && subroot == null) {
			return true;
		}
		else if(root == null || subroot == null || root.data != subroot.data) {
			return false;
			}
		if(!isIdentical(root.left,subroot.left)) {
			return false;
		}
		if(!isIdentical(root.right,subroot.right)) {
			return false;
		}
		return true;
	}
	public static boolean isSubtree(Node root, Node subRoot) {
		if(root == null) {
			return false;
		}
		// we try to prove the false
		if(root.data == subRoot.data) {
			if(isIdentical(root, subRoot)) {
				return true;
			}
		}
		boolean left = isSubtree(root.left,subRoot);
		boolean right = isSubtree(root.right,subRoot);
		
		
		return left || right;
	}
	/* checking if subroot is part of tree(end)*/ 
	/*Top view of a binary tree start*/
	static class Info{
		Node node;
		int hd;//horizontal distance
		
		Info(Node node,int hd){
			this.node = node;
			this.hd = hd;
		}
	}
	public static void topView(Node root) {
		
		HashMap<Integer,Node> map = new HashMap<>();
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(root, 0));
		q.add(null);
		int max=0,min=0;
		while(!q.isEmpty()) {
			Info curr = q.remove();
			if(curr == null) {
				if(q.isEmpty()) {break;}
				else{q.add(null);}
			}
			else {
			if(!map.containsKey(curr.hd)) {				
				map.put(curr.hd, curr.node);
			}
			if(curr.node.left != null) {
				q.add(new Info(curr.node.left,curr.hd-1));
				min = Math.min(curr.hd-1, min);
			}
			if(curr.node.right != null) {
				q.add(new Info(curr.node.right,curr.hd+1));
				max = Math.max(curr.hd+1,max);
			}
				
		}
		}
		for(int i=min;i<=max;i++) { 
			System.out.println(map.get(i).data);
			}
		
		
	}
	/*Top view of a binary tree end */
	
	public static void klevel(Node root,int level,int k) {
		if(root == null) {
			return;
		}
		if(level == k) {
			System.out.print(root.data +" ");
			return;
		}
		klevel(root.left,level+1,k);
		klevel(root.right,level+1,k);
		
	}
	/*Lowest Common Ancestor Start*/
	public static boolean getPath(Node root, int n, ArrayList<Node> path) {
		if(root == null) {
			return false;
		}
		//add node 
		path.add(root);
		// check if data is n
		if(root.data == n) {
			return true;
		}
		//if yes return true
		//else go left 
		//then go right
		// if found on either side true else remove element from the list
		boolean foundleft = getPath(root.left,n,path);
		boolean foundright = getPath(root.right,n,path);
		
		if(foundleft || foundright) {
			return true;
		}
		//else
		path.remove(path.size() -1);
		return false;
	}
	
	public static Node lowestCommonAncestor(Node root,int n1,int n2) {
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		
		boolean p1 = getPath(root,n1,path1);
		boolean p2 = getPath(root,n2,path2);
		Node lca = null;
		
		for(int i=0;i<Math.min(path1.size(),path2.size());i++) {
			if(path1.get(i) != path2.get(i)) {
				lca = path1.get(i-1);
				break;
			}
			
		}
		return lca;
	}
	/*Lowest Common Ancestor end*/
	
	/*Min distance between node start*/
	public static int calPath(Node root, int n) { 
		if(root == null) {
			return -1;
		}
		
		if(root.data == n) {
			return 0;
		}
		
		int left = calPath(root.left,n);
		int right = calPath(root.right,n);
		
		if(left == -1 && right == -1){
			return -1;
		}else if(left == -1){
			return right+1;
		}else if(right == -1) {
			return left+1;
		}
		return left + right;
	}
	public static int minDist(Node root, int n1,int n2) {
		Node lcA = lowestCommonAncestor(root,n1,n2);
		int p1 = calPath(lcA,n1);
		int p2 = calPath(lcA,n2);
		
		return p1+p2;
		
	}
	/*Min distance between node end*/
	/*Sum Tree start*/
	public static int sumTree(Node root) {
		if (root == null) {			
			return 0;
		}
		int rootvalue = root.data;
		root.data = sumTree(root.left)+ sumTree(root.right);
		
		
		
		return root.data + rootvalue;
		
	}
	/*Sum tree end*/
	
	//BINARY TREE QESTIONS 
	//1. Tree is univalued or not 
	public static boolean univalued(Node root, int data) {
		if(root == null) {
			return true;
		}
		if(root.data != data) {
			return false;
		}
		 
		return univalued(root.left,data)&&univalued(root.right,data) ;
	}
	//INvert tree
	public static void invert(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node curr = q.remove();
			q2.add(curr.data);
			
			if(curr == null) {
				q.add(null);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
			if(curr.left != null) {
				q.add(curr.left);
			}
		}
		System.out.println(q2);
	}
	public static void main(String[] args) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,7,-1,-1,6,-1,-1};
		int subTree[] = {2,4,-1,-1,5};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
		tree.preOrder(root);
		System.out.println();
		tree.inOrder(root);
		System.out.println();
		tree.postOrder(root);
		System.out.println();
		tree.levelOrder(root);
		System.out.println();
		int h = tree.height(root);
		System.out.print("Height = "+h);
		System.out.println();
		int c = tree.nodeCount(root);
		System.out.print("Count = "+ c);
		System.out.println();
		int sum = tree.sumNodes(root);
		System.out.print("Node Sum = "+ sum);
		
		System.out.println();
		int diam = tree.diameter(root);
		System.out.print("Diameter = "+ diam);
		
		System.out.println();
		//Is subTree or not question
		Node root1 = new Node(1);
		root1.left = new Node(2);{
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		root1.right.left = new Node(6);
		root1.right.right = new Node(7);
		
		//subtree
		Node subroot1 = new Node(2);
		subroot1.left = new Node(4);
		subroot1.right = new Node(5);
		
		System.out.println("Subtree os the tree or not?: "+isSubtree(root1,subroot1));
		
		//Top view
		topView(root1);
		System.out.println();
		klevel(root1,1,3);
		
		//Lowest common ancestor
		System.out.println();
		int n1 = 4,n2 = 5;
		Node lca = lowestCommonAncestor(root1,n1,n2);
		System.out.println("Lowest Common Ancestor = "+lca.data);

		// min dist
//		int minDist = minDist(root1,n1,n2);
//		System.out.println("Min Dist b/w "+n1+"&"+n2+" = "+minDist);
//		System.out.println();
//		sumTree(root);
//		tree.preOrder(root);
//		System.out.println();
		
		// tree two
		Node root2 = new Node(1);
		root2.left = new Node(1);
		root2.right = new Node(1);
		root2.left.left = new Node(1);
		root2.left.right = new Node(1);
		root2.right.left = new Node(1);
		root2.right.right = new Node(1);
		int dat = root2.data;
		System.out.println("Univalued? = "+univalued(root2,dat));
	
		// Invert tree
		invert(root);
		//tree.preOrder(root);
	}
}}
