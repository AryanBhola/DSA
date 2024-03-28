package dsa;


import java.util.*;
public class BinarySearchTree {

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
	public static Node insert(Node root, int val) {
		if(root == null) {
			root = new Node(val);
			return root;
		}
		if(val < root.data) {
			root.left = insert(root.left,val);
		}
		else {
			root.right = insert(root.right,val);
		}
		return root;
	}
	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");		
		inOrder(root.right);
		
	}
	public static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);				
		preOrder(root.right);
		
	}
		
	public static boolean searchBST(Node root,int key) {
		if(root == null) {
			return false;
		}
		if(root.data == key) {
			return true;
		}
		else {
			if(key < root.data) {
				return searchBST(root.left,key);
			}else {
				return searchBST(root.right,key);
			}
		}
		
		
	}
	// How to delete a node?????????????????????
	/*
	 case 1: NO child
	 case 2: ONE child
	 case 3: TWO children
	 */
	public static Node deleteNode(Node root, int key) {
		// Search for the node 
		
	
			if(key < root.data) {
				root.left =  deleteNode(root.left,key);
			}else if(key > root.data){
				root.right =  deleteNode(root.right,key);
			}
			else {
				//case1
		if(root.left == null && root.right == null) {
			return null;
		}
		//case2
		else if (root.right == null && root.left != null) {
			return root.left;
		}
		else if(root.left == null && root.right != null) {
			return root.right;
		}
		else {
		//case3
		int inOrderSuccessor = 	findSucessor(root.right);
		root.data = inOrderSuccessor;
		root.right = deleteNode(root.right,inOrderSuccessor);
		
		}
			
			
			}
		return root;
	}
	public static int findSucessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		return root.data;
	}
	//How to delete node end
	
	public static void printInRange(Node root, int k1, int k2) {
		if(root == null) {
			return;
		}
		if(root.data >= k1 && root.data <= k2) {
			printInRange(root.left,k1,k2);
			System.out.print(root.data + " ");
			printInRange(root.right,k1,k2);
			
		}
		else if(root.data > k2) {			
			printInRange(root.left,k1,k2);
		}
		else{			
			printInRange(root.right,k1,k2);
		}
		
		
	}
	//Print all paths from root to leaf
	// Use of backtracking
	public static void leafPaths(Node root,ArrayList<Integer> path) {
		if(root == null) {
			return;
		}
		path.add(root.data);
		if(root.left == null && root.right == null) {
			System.out.println(path);
		}
		leafPaths(root.left,path);
		leafPaths(root.right,path);
		path.remove(path.size()-1);
		
		
		
	}
	// VALIDATE BST
	public static boolean validBST(Node root, Node min, Node max) {
		if(root == null) {
			return true;
		}
	if(min != null && min.data >= root.data) {
		return false;
	}
	if(max != null && max.data <= root.data) {
		return false;
	}
		return validBST(root.left,min,root) && 
			   validBST(root.right,root,max);
		
		
	}
	// Mirror a BST
	public static Node mirrorBST(Node root) {
		if(root == null) {
			return null;
		}
	  
		Node mirror = new Node(root.data);	  
		mirror.left = mirrorBST(root.left);
		mirror.right = mirrorBST(root.right);		  
			  
			  
		
		return mirror;
	}
	
	// Size of the largest BST in BT(Start)
	
	// Size of the largest BST in BT(end)
	public static void main(String[] args) {
		int values[] = {5,1,3,4,2,7};
		Node root = null;
		//BUILD TREE
		for(int i=0;i<values.length;i++) {
			root = insert(root,values[i]);
		}
		inOrder(root);
		//SEARCH IN BST
		System.out.println();
		System.out.println(searchBST(root,9));
		Node n = deleteNode(root,3);
		inOrder(root);
		System.out.println();
		
		//Tree2
		Node root2 = new Node(8);
		root2.left = new Node(5);
		root2.left.right = new Node(6);
		root2.left.left = new Node(3);
		//root2.left.left.right = new Node(4);
		//root2.left.left.left = new Node(1);
		root2.right = new Node(10);
		root2.right.right = new Node(11);
		//root2.right.right.right = new Node(14);
		//PRINT IN RANGE
		
		//printInRange(root2,9,12);;
		
		// PRINT ALL PATHS FROM ROOT TO LEAF
		System.out.println();
		//leafPaths(root2,new ArrayList<Integer>());
		
		//VALID BST
		Node rootx = new Node(1);
		rootx.left = new Node(2);{
		rootx.right = new Node(3);
		rootx.left.left = new Node(4);
		rootx.left.right = new Node(5);
		rootx.right.left = new Node(6);
		rootx.right.right = new Node(7);
		//System.out.println("VALID BST? : "+ validBST(rootx,null,null));
		
		System.out.println();
		Node mirrorRoot = mirrorBST(root2);
		preOrder(mirrorRoot);
	}
	}
}
