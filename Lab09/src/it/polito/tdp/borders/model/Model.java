package it.polito.tdp.borders.model;

import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	private BordersDAO bdao;
	private List<Country> countries;
	private List<Border> bordersConnYear;
	
	private CountryIdMap coMap;
	private BorderIdMap boMap;
	
	private Graph<Country, DefaultEdge> graph;
	
	public Model() {
		bdao = new BordersDAO();
		
		coMap = new CountryIdMap();
		boMap = new BorderIdMap();
		
		countries  = bdao.loadAllCountries(coMap);
		bordersConnYear = new ArrayList<>();
		
	}

	public List<Country> getCountries() {
		return countries;
	}
	
	public List<Border> getBordersConnYear() {
		return bordersConnYear;
	}
	
	public int degree(Country c) {
		return graph.degreeOf(c);
	}

	public void creaGrafo(int year) {
		this.graph = new SimpleGraph<>(DefaultEdge.class);
		
		Graphs.addAllVertices(graph, countries);
		
		bordersConnYear = bdao.getCountryPairs(year, coMap, boMap);
		for(Border b : bordersConnYear) {
			if(b.getC1().getCode()<b.getC2().getCode())
				this.graph.addEdge(b.getC1(), b.getC2());
		}
		
		
	}

	public int getNumberOfConnectedComponents() {
		
		ConnectivityInspector c = new ConnectivityInspector(graph);
		return c.connectedSets().size();
	}

	public Set<Country> trovaVicini(String stato) {
		
		Set<Country> visitati = new HashSet<>();
		Country curr = null;
		for(Country c : countries) {
			if(c.getName().compareTo(stato)==0)
				curr = c;
		}
		
		DepthFirstIterator<Country, DefaultEdge> dfv = new DepthFirstIterator<>(this.graph, curr);
		while (dfv.hasNext())
			visitati.add(dfv.next());
		
		return visitati;
	}

}
