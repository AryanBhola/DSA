package dsa;

public class InsertionSort {

	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public static int[] InsertionSort(int arr[]){
		//Selecting the element 
		for(int i=1;i<arr.length;i++){
			int curr = arr[i];
			int prev = i-1;
			
			// finding the right position
			while(prev>=0 && curr < arr[prev]) {
				arr[prev+1] = arr[prev];
				prev--;
			}
			//Insertion
			arr[prev+1] = curr;
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {5,4,1,3,2};		
		printarray(InsertionSort(arr));
	}

}
