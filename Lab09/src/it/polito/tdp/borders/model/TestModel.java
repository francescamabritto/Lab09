package it.polito.tdp.borders.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

//		System.out.println("TestModel -- TODO");
		
//		System.out.println("Creo il grafo relativo al 2000");
		model.createGraph(1900);
		
		List<Country> countries = model.getCountries();
		System.out.format("Trovate %d nazioni con confini nel 1816\n", countries.size());
		System.out.println(countries.toString());
		
		List<Border> borders = model.getBorders();
		System.out.format("Trovati %d confini nel 1816\n", borders.size());
		System.out.println(borders.toString());
		
//		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
		System.out.println(model.getTuttiVicini("United States of America").toString());
//		System.out.println(model.getTuttiVicini2("Italy").toString());
		
	}

}
