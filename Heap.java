package dsa;
import java.util.*;
public class Heap {

	static class Heapp{
		ArrayList<Integer> arr = new ArrayList<>();
		
		public void add(int data) {
			//1. add at last
			arr.add(data);
			int child = arr.size()-1;
			int parent = (child-1)/2;
			while(arr.get(parent) > arr.get(child)) { //O(log n)
				int temp = arr.get(parent);
				arr.set(parent,child);
				arr.set(child,temp);
				
				child = parent;
				parent = (child-1)/2;
			}
		}
		public int getMin() {
			return arr.get(0);
		}
		public int delete() {
			int data = arr.get(0);
			// 1. swap first and last node val
			int temp = arr.get(0);
			arr.set(0,arr.get(arr.size()-1));
			arr.set(arr.size()-1,temp);
			
			// 2. Delete last element
			arr.remove(arr.size()-1);
			
			// 3. correct heap
			heapify(0);
			
			return data;
			
		}
		// idx = index for which heap has to be corrected
		public void heapify(int idx) {
			int left = 2*idx + 1;
			int right = 2*idx + 2;
			int minIdx = idx;
			
//			check for leaf nodes and the condition 
//			so that null condition does not occur
			if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
				minIdx = left;
			}
			if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
				minIdx = right;
			}
			// if minIdx was found different 
			if(minIdx != idx) {
				//swap
				int temp = arr.get(idx);
				arr.set(0,arr.get(minIdx));
				arr.set(minIdx ,temp);
				
			
			// if due to swap the heap was disturbed 
			heapify(minIdx);
			}
			
			
		}
		public  boolean  isEmpty() {
			return arr.size() == 0;
		}
		
		
	}
	public static void heapify(int arr[] ,int index, int size) {
		int left = 2*index + 1;
		int right = 2*index + 2;
		int maxIdx = index;
		
		if(left < size && arr[left] > arr[maxIdx]) {
			maxIdx = left;
			}
		if(right < size && arr[right] > arr[maxIdx]) {
			maxIdx = right;
		}
		if(maxIdx != index) {
			
			int temp = arr[index];
			arr[index] = arr[maxIdx];
			arr[maxIdx] = temp;
			
			heapify(arr,maxIdx,size);
		}
	}
	public static void heapSort(int arr[]) {
		// Step 1: Build MaxHeap
			int n = arr.length;
			for(int i=n/2;i>=0;i--) {
				heapify(arr,i,n);
			}
		// Step 2: push largest at the end 
			for(int i=n-1;i>0;i--) {
				//swap largest-first with last
				int temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				
				heapify(arr,0,i);
			}
		
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Heapp h = new Heapp();
		h.add(3);
		h.add(4);;
		h.add(1);
		h.add(5);
		
//		while(!h.isEmpty()) {
//			System.out.println(h.delete());
//		}
		int arr[] = {1,2,4,5,3};
		heapSort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
