package searchengine.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GraphWriter {

	private WebGraph graph;
	
	public GraphWriter(WebGraph graph){
		this.graph = graph;
	}
	
	public void writeToFile(File indexFile, File arcFile) 
			throws FileNotFoundException{
		PrintWriter indxWriter = new PrintWriter(indexFile);
		PrintWriter arcWriter = new PrintWriter(arcFile);
		
		for (Node n: graph.getAllNodes()) {
			indxWriter.println(n.getUrl() + "\t" + n.getId());
		}
		indxWriter.close();
		
		for (Edge e: graph.getAllEdges()) {
			arcWriter.println(e.getFrom().getId() + "\t" + e.getTo().getId());
		}
		arcWriter.close();
	}
}
