package searchengine.common;

import java.util.HashSet;
import java.util.Set;

public class WebGraph {
	
	Set<Node> allNodes;
	Set<Edge> allEdges;
	
	public WebGraph() {
		allNodes = new HashSet<Node>();
		allEdges = new HashSet<Edge>();
	}
	
	public void addNode(Node n) {
		allNodes.add(n);
	}
	
	public void addEdge(Edge e) {
		if(!allNodes.contains(e.getFrom()) || !allNodes.contains(e.getTo())) {
			throw new 
				IllegalArgumentException("Nodes for this edge are not in the graph");
		}
		allEdges.add(e);
	}

	public Set<Node> getAllNodes() {
		return allNodes;
	}

	public Set<Edge> getAllEdges() {
		return allEdges;
	}

}
