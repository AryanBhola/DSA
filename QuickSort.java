package dsa;

public class QuickSort {
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	

	public static void quickSort(int[] arr, int start,int end) {
		if(start >= end) {
			return;
		}
		int pivot = partition(arr,start,end);
		quickSort(arr, start, pivot-1);
		quickSort(arr,pivot+1,end);
		
		
	}
	
	
	public static int partition(int arr[],int start, int end){
		int pivot  = arr[end];
		int i = start-1;
		//put all small elements to the left 
		for(int k=start;k<end;k++) {
			
			if(arr[k] <= pivot) {
				i++;
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
		//putting pivot into right position
		i++;
		int temp = pivot;
		arr[end] = arr[i];
		arr[i] = temp;
		
		
		return i;
	}
	
	public static void main(String[] args) {
		int arr[] = {6,3,9,8,2,5};
		quickSort(arr,0,arr.length-1);
		printarray(arr);
	}
}
