package dsa;

public class MaxSubarraySumKadane {

	public static int maxSubarray(int arr[]) {
		int maxsum = 0;
		int currsum = 0;
		for(int i=0;i<arr.length;i++) {
			currsum += arr[i];
			if(currsum<0) {
				currsum= 0;
			}
			if(currsum >maxsum) {
				maxsum = currsum;
			}
			
		}
		
		return maxsum;
	}
	public static void main(String[] args) {
		int arr[] = {2,-4,-1,-9,7,3,8};
		System.out.print(maxSubarray(arr));

	}

}
