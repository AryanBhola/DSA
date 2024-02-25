package dsa;
import java.util.*;
public class ConnectingCitiesWithMinCost {
	static class Edge{
		int src;
		int dest;
		int cost;
		
		public Edge(int s, int d, int c){
			this.src = s;
			this.dest = d;
			this.cost = c;
		}
	}
	public static void createGraph(ArrayList<Edge> graph[],int cities[][]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		 for(int i=0;i<cities.length;i++){
			 for(int j=0;j<cities[0].length;j++) {				 
			 int src = i;
			 int dest = j;
			 int cost = cities[i][j];
			 if(cost != 0) {
			 Edge e = new Edge(src,dest,cost);
			 graph[i].add(e);
			 }
			 }
		 }
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
			return this.cost - p.cost;
		}
	}
	public static int city(ArrayList<Edge> graph[]) {
		boolean vis[] = new boolean[graph.length];
		int finalCost = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(0,0));
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			if(!vis[curr.vertex]) {
				System.out.println(curr.vertex + "<-vertex,cost-> " + curr.cost);
				vis[curr.vertex] = true;
				
				finalCost += curr.cost;
				for(Edge e:graph[curr.vertex]) {
					pq.add(new Pair(e.dest,e.cost));
				}
			}
		}
		return finalCost;
	}
	public static void main(String args[]) {
		int cities[][] ={{0,1,2,3,4},
						 {1,0,5,0,7},
						 {2,5,0,6,0},
						 {3,0,6,0,0},
						 {4,7,0,0,0}};
		int V = 5;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph,cities);
		System.out.print("Final Minimum Cost = " + city(graph));
	}
			
}
