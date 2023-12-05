package dsa;
import java.util.*;
public class Q {
// given an array of lines on x axis find 2 lines where u can store most water
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(8);
		list.add(6);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(8);
		list.add(3);
		list.add(7);
		
		System.out.print(solve(list));
	}
		public static int solve(ArrayList<Integer> list) {
			int area = 0;
			int start=0,end=list.size() -1;
			int max = 0;
			while(start<end) {
				area = (end-start) * (Math.min(list.get(start),list.get(end)));
				max = Math.max(area, max);
				if(start<end) {start++;}
				else if(start>=end) {end++;}
			}
			return max;
		}

	

}
