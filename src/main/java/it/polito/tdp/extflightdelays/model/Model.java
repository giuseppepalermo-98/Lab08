package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.graph.WeightedMultigraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Map<Integer, Airport> mappaAirport;
	private Graph <Airport, DefaultWeightedEdge> grafo;
	private List<Volo> listaArchi;
	
	public Model() {
		mappaAirport= new HashMap<Integer, Airport>();
	}
	
	public void creaGrafo(int distanzaMedia) {
		this.grafo= new WeightedMultigraph<>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
		dao.loadAllAirports(mappaAirport);
		
		//Aggiungi i vertici
		Graphs.addAllVertices(grafo, mappaAirport.values());
		//System.out.println(String.format("Numero di vertici: %d", grafo.vertexSet().size()));
		listaArchi= dao.loadAllFlightsAmmissibili(distanzaMedia);
		for(Volo v: listaArchi) {
			Graphs.addEdge(grafo, mappaAirport.get(v.getORIGIN_AIRPORT()), mappaAirport.get(v.getDESTINATION_AIRPORT()),
					v.getDistance());
			
		}
		//System.out.println(String.format("Numero di vertici: %d Numero di archi: %d", grafo.vertexSet().size(), grafo.edgeSet().size()));
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public String listaArchi(){
		String result="";
		StringBuilder sb = new StringBuilder();
		
		for(Volo v: listaArchi) {
			sb.append(String.format("%35s ", this.mappaAirport.get(v.getORIGIN_AIRPORT()).getAirportName()));
			sb.append(String.format("%35s ", this.mappaAirport.get(v.getDESTINATION_AIRPORT()).getAirportName()));
			sb.append(String.format("%d ", v.getDistance()));
			sb.append("\n");
		}
		result += sb.toString();
		
		return result;
	}
}
