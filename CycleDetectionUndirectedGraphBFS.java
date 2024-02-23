package dsa;
import java.util.*;

public class CycleDetectionUndirectedGraphBFS { 
	static class Edge{
		int src;
		int dest;
		int wt;
		 Edge(int src,int dest){
			 this.src = src;
			 this.dest = dest;				 
		 }
	}
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<=9;i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[9].add(new Edge(9,1));
		graph[9].add(new Edge(9,5));
		
		graph[1].add(new Edge(1,9));
		graph[1].add(new Edge(1,5));
		
		graph[2].add(new Edge(2,4));
		
		graph[4].add(new Edge(4,2));
		
		
		graph[5].add(new Edge(5,9));
		graph[5].add(new Edge(5,2));
		graph[5].add(new Edge(5,1));
	}
	public static boolean bfsDetect(ArrayList<Edge> graph[]) {
		// At anypoint if 2 adjacent edges have same color cycle is there
		int color[] = new int[graph.length];
		Arrays.fill(color,-1);
		
		// Queue for BFS
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		color[1] = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(Edge e : graph[curr]) {
				int next = e.dest;
				
				if(color[next] == -1) {
					if(color[curr] == 1) {
						color[next] = 0;
					}
					else if(color[curr] == 0) {
						color[next] = 1;
					}
					//color[next] = (color[curr]) % 2;
					q.add(next);
				}
				if(color[curr] == color[next]) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		ArrayList<Edge> graph[] = new ArrayList[10];
		createGraph(graph);
		System.out.print("Cycle ? " + bfsDetect(graph));
		

	}

}
