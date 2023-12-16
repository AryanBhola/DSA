package dsa;
import java.util.Stack;
public class MaxAreaInHistorgram {

	public static void main(String[] args) {
		int heights[] = {2,1,5,6,2,3};
		System.out.println(maxArea(heights));


	}
	public static int maxArea(int heights[]) {
		int maxA = Integer.MIN_VALUE;
		int nextSmallLeft[] = new int[heights.length];
		int nextSmallRight[] = new int[heights.length];
		Stack<Integer> s = new Stack<>();
		
		//Next small right
		for(int i=heights.length-1;i>=0;i--) {
			while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				nextSmallRight[i] = heights.length;
			}
			else {
				nextSmallRight[i] = s.peek();
			}
			s.push(i);
			}
		//Next Small Left
		for(int i=0;i<=heights.length-1;i++) {
			while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				nextSmallLeft[i] = -1;
			}
			else {
				nextSmallLeft[i] = s.peek();
			}
			s.push(i);
			}
		//area
		for(int i=0;i<heights.length;i++) {
			int length = heights[i];
			int width = nextSmallRight[i] - nextSmallLeft[i] - 1;
			int area = length * width;
			maxA = Math.max(area,maxA);
		}
		return maxA;
	}

}
