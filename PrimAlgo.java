package dsa;
import java.util.*;

public class PrimAlgo {
	static class Edge{
		int src;
		int dest;
		int wt;
		 Edge(int src,int dest, int wt){
			 this.src = src;
			 this.dest = dest;	
			 this.wt = wt;
		 }
	}
	public static void createGraph(ArrayList<Edge> graph[]) {

		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0,1,10));
		graph[0].add(new Edge(0,2,15));
		graph[0].add(new Edge(0,3,30));
		
		graph[1].add(new Edge(1,0,10));
		graph[1].add(new Edge(1,3,40));
		
		graph[2].add(new Edge(2,0,15));		
		graph[2].add(new Edge(2,3,50));
		
		
		graph[3].add(new Edge(3,1,40));
		graph[3].add(new Edge(3,2,50));
		
	}
	
	static class Pair implements Comparable<Pair>{
		int vertex;
		int cost;
		
		Pair(int v, int c){
			this.vertex = v;
			this.cost = c;
		}
		@Override
		public int compareTo(Pair p) {
			return this.cost - p.cost; // Ascending sort
		}
		
	}
	public static void primMST(ArrayList<Edge> graph[]) {
		boolean vis[] = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0,0));
		int finalCost = 0;
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			
			if(!vis[curr.vertex]) {
				vis[curr.vertex] = true;
				finalCost += curr.cost;
				for(Edge e:graph[curr.vertex]) {
					pq.add(new Pair(e.dest,e.wt));
				}
			}
		}
		System.out.print("Final Minimum Cost = " + finalCost);
	}
	public static void main(String[] args) {
		ArrayList<Edge> graph[] = new ArrayList[4];
		createGraph(graph);
		System.out.print("MST ? ");
		primMST(graph);
		

	}


}
