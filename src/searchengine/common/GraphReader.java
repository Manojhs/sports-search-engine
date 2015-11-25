package searchengine.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GraphReader {
	
	public WebGraph readFromFile(File index, File arc) 
			throws MalformedURLException, IOException {
		WebGraph graph = new WebGraph();
		Map<String,Node> allNodes = new HashMap<String,Node>();
		
		FileReader indxReader = new FileReader(index);
		FileReader arcReader = new FileReader(arc);

		BufferedReader reader = new BufferedReader(indxReader);
		String line;
		while ((line=reader.readLine())!=null) {
			URL url = new URL(line.split("\t")[0]);
			String id = line.split("\t")[1];
			Node node = new Node(url,id);
			graph.addNode(node);
			allNodes.put(id, node);
		}
		reader.close();
		
		reader = new BufferedReader(arcReader);
		
		while ((line=reader.readLine())!=null) {
			String id1 = line.split("\t")[0];
			String id2 = line.split("\t")[1];
			graph.addEdge(new Edge(allNodes.get(id1),allNodes.get(id2)));
		}
		reader.close();
		
		return graph;
		
	}
	
	

}
