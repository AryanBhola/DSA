package dsa;

public class MergeSort {
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void mergeSort(int arr[], int start, int end) {
		if(start >= end) {
			return;
		}
		int mid  = start +(end-start)/2;
		mergeSort(arr,start,mid);//left part sorting
		mergeSort(arr,mid+1,end);// right part sorting
		merge(arr,start,mid,end);
		
	}
	public static void merge(int arr[] ,int start,int mid, int end) {
		int temp[] = new int[end-start+1];
		int i = start;//left iterator
		int j = mid+1;//right iterator
		int k = 0;
		while(i<=mid && j<=end) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;k++;
			}
			else {
			temp[k] = arr[j];
			j++;k++;
			}
		}
		//if anything is left in the leftPart
		while(i <=mid) {
			temp[k++] = arr[i++];
}
		while(j <= end) {
			temp[k++] = arr[j++];
		}
		// copy from tmep[] to arr[]
		for(k=0, i=start;k<temp.length; k++,i++) {
			arr[i] = temp[k];
		}
	}
	public static void main(String[] args) {
		int arr[] = {6,3,9,5,2,8};
		mergeSort(arr,0,arr.length -1);
		printarray(arr);
	}

}
