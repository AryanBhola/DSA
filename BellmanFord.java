package dsa;
import java.util.*;

import dsa.CycleDetectionUndirectedGraphBFS.Edge;
public class BellmanFord {
	static class Edge{
		int src;
		int dest;
		int wt;
		 Edge(int src,int dest,int wt){
			 this.src = src;
			 this.dest = dest;	
			 this.wt = wt;
		 }
	}
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0,1,2));
		graph[0].add(new Edge(0,2,4));
		
		graph[1].add(new Edge(1,2,-4));
		
		graph[2].add(new Edge(2,3,2));
		
		graph[3].add(new Edge(3,4,4));
		
		graph[4].add(new Edge(4,1,-1));
		
	}
	public static void bellmanFord(ArrayList<Edge> graph[],int src) {
		int dist[] = new int[graph.length];
		// Initialize
		for(int i=0;i<dist.length;i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<graph.length-1;i++) {
			for(int j=0;j<graph.length;j++) {
				for(Edge e:graph[i]) {
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					// Relaxation
					if(dist[u] != Integer.MAX_VALUE && (dist[u] + wt < dist[v])) {
						dist[v] = dist[u] + wt;
					}
				}
			}
		}
		// Print Path
		for(int i=0;i<graph.length;i++) {
			System.out.print(dist[i]+" ");
		}
	}
	public static void main(String[] args) {
		ArrayList<Edge> graph[] = new ArrayList[5];
		createGraph(graph);
		System.out.print("Bellman Ford Shortest Path : ");
		bellmanFord(graph,0);//O(V+E)
	}

}
