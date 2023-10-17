package dsa;

public class StockBuySell {
	public static void stocks(int arr[]) {
		int maxProfit = 0;
		int profit = 0;
		int buy = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(buy<arr[i]) {
				profit = arr[i] - buy;
				//System.out.print(profit+"  ");
				if(profit>maxProfit) {
					maxProfit=profit;
				}
			}
			else if(buy>arr[i]) {
				buy = arr[i];
			}
		}
		System.out.print(maxProfit);
	}
	public static void main(String[] args) {
		int arr[] = {7,1,5,3,6,4};
		stocks(arr);
	}
}
