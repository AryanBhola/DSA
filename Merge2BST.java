package dsa;

import java.util.ArrayList;

import dsa.BinarySearchTree.Node;

public class Merge2BST {

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
	public static void inOrder(Node root,ArrayList<Integer> l) {
		if(root == null) {
			return;
		}
		inOrder(root.left,l);
		l.add(root.data);	
		inOrder(root.right,l);
		
	}
	public static void inOrderPrint(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		inOrderPrint(root.left);
				
		inOrderPrint(root.right);
		
	}
	public static ArrayList<Integer> mergeLists(ArrayList<Integer> l1,ArrayList<Integer> l2){
		ArrayList<Integer> merged = new ArrayList<>();
		int i=0,j=0;
		while(i< l1.size() && j < l2.size()) {
			if(l1.get(i)<l2.get(j)) {
				merged.add(l1.get(i));
				i++;
			}else if(l1.get(i) == l2.get(j)) {
				 merged.add(l1.get(i));
	                i++;
	                j++;
			}
			else {
				merged.add(l2.get(j));
				j++;
			}
		}
		while(i< l1.size()) {
			merged.add(l1.get(i));
			i++;
		}
		while(j< l2.size()) {
			merged.add(l2.get(j));
			j++;
		}
			return merged;
	}
	public static Node merge(Node root1,Node root2) {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		inOrder(root1,l1);
		inOrder(root2,l2);
		ArrayList<Integer> list = mergeLists(l1,l2);
		//System.out.print(list);
		return createBST(list,0,list.size()-1);
		
	}
	public static Node createBST(ArrayList<Integer> li, int l, int r) {
		if(l>r) {
			return null;
		}
		int mid = l +(r-l)/2;
		Node root = new Node(li.get(mid));
		root.left = createBST(li,l,mid-1);
		root.right = createBST(li,mid+1,r);
		return root;
	}
	
	public static void main(String[] args) {
		Node subroot1 = new Node(2);
		subroot1.left = new Node(1);
		//subroot1.right = new Node(4);
		
		Node subroot2 = new Node(3);
		subroot2.left = new Node(2);
		subroot2.right = new Node(5);
		
		Node subroot3 = new Node(5);
		subroot3.left = new Node(4);
		Node mergedRoot = merge(subroot1,subroot2);
		inOrderPrint(mergedRoot);
		System.out.println();
		
	}

}
