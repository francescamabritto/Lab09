package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;


import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	public Model() {
	
	}
	
	BordersDAO dao = new BordersDAO();
	private List<Country> allCountries = dao.loadAllCountries();
	private List <Border> borders = new ArrayList<>();
	
	Graph <Country, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

	public void createGraph(int anno) {
		
		List <Border> allBorderForYear = dao.getCountryPairs(anno);
		
		
		// aggiungo i vertici
		for(Country c: allCountries)
			graph.addVertex(c);	
		
		// aggiungo gli edges
		for(Country c: allCountries) {
			for(Border b: allBorderForYear) {
				if(!borders.contains(b)) {
					if(c.getCcode() == b.getState1no()  ) {
						
						Country countryTemp = new Country(b.getState2no(), b.getState2ab(), this.getNomeStatoByCodice(b.getState2no()));
						borders.add(b);
						
						graph.addEdge(c, countryTemp);
					}
				}
			}
		}
		//System.out.println(graph);
	}

	private String getNomeStatoByCodice(int state2no) {
		
		for(Country c : this.allCountries)
			if(c.getCcode()==state2no)
				return c.getStateNme();
		return null;
	}

	// metodo che trova gli stati con dei confini nell'anno selezionato
	public List<Country> getCountries() {
		List<Country>countries = new ArrayList<>();
		List<String>countriesAb = new ArrayList<>();
		
		for(Border b: borders) 
			countriesAb.add(b.getState1ab());
		
		for(Country c: this.allCountries) {
			if(countriesAb.contains(c.getStateAbb())) {
				c.setDegrees(graph.degreeOf(c));
				countries.add(c);
			}
		}
		return countries;
	}
	
	public int getNumberOfConnectedComponents() {
		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<>(graph);
		int res = ci.connectedSets().size();
		return res;
	}
	
	
	// lista nomi stati per combo box
	public List<String> getCountryNames(List<Country> countries) {
		List<String> countryNames = new ArrayList<>();
		for(Country c: countries) {
			countryNames.add(c.getStateNme());
		}
		return countryNames;
	}
	
	
	public List<String> getTuttiVicini(String stato) {
		
		List<String> nomiTuttiVicini =  new ArrayList<>();
		Country country = new Country();
		
		for(Country c: this.allCountries) {
			if (c.getStateNme().compareTo(stato)==0) {
				country = c;
				break;
			}
		}
		
		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<>(graph);
		Set<Country> raggiungibili = ci.connectedSetOf(country);
		
		for(Country c: raggiungibili) {
			nomiTuttiVicini.add(c.getStateNme());
		}
		
		return nomiTuttiVicini;
	}
	
	// metodo 2 (non funziona)
	List<Country> soluzione = new ArrayList<>();
	/**
	 * Si inizia inserendo lo stato scelto nella lista daVisitare. 
	 * L’algoritmo continua fino a quando la lista dei nodi daVisitare non si svuota. 
	 * Ad ogni passo si estrae un nodo dalla lista daVisitare e si inseriscono tutti 
	 * i nodi vicini a quello estratto (a meno di quelli già visitati) nella lista 
	 * daVisitare. Infine, il nodo estratto viene inserito nella lista dei Visitati.
	 * 
	 * @param List<Country>visitati, List<Country>daVisitare 
	 * @return
	 */
	public List<String> getTuttiVicini2(String stato) {
		List<Country> visitati = new ArrayList<>();
		List<Country> daVisitare = new ArrayList<>();
		
		Country country = new Country();
		for(Country c: this.allCountries) {
			if (c.getStateNme().compareTo(stato)==0)
				country = c;
		}
		daVisitare.add(country);
		
		ricorsione(daVisitare, visitati);
		
		List<String> nomiVisitati = this.getCountryNames(visitati);
		
		return nomiVisitati;
	}
	
	private void ricorsione(List<Country> daVisitare, List<Country>visitati) {
		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<>(graph);
		List<Country> daVisitareCopia = new ArrayList<>(daVisitare);
		
		if(daVisitare.isEmpty())
			this.soluzione = visitati;
		
		
		for(Country c: daVisitareCopia) {
			daVisitare.addAll(ci.connectedSetOf(c));
			if(!visitati.contains(c)) {
				visitati.add(c);
			}
			daVisitare.remove(c);
		}
		
		ricorsione(daVisitare, visitati);
		
	}

	public List<Border> getBorders() {
		// TODO Auto-generated method stub
		return this.borders;
	}
	
	
}
