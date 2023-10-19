package dsa;

public class SelectionSort {
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
		
	public static int[] selectionSort(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			int minPos = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minPos]>arr[j]) {
					minPos = j;
				}
			}
			int temp = arr[minPos];
			arr[minPos] = arr[i];
			arr[i] = temp;
		}
	
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {5,2,1,3};
		printarray(selectionSort(arr));

	}

}
