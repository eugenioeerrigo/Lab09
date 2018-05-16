package it.polito.tdp.borders.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		List<Country> countries = model.getCountries();
		System.out.format("Trovate %d nazioni\n", countries.size());
		//System.out.println(model.getCountries());
		
		System.out.println("Creo il grafo relativo al 2000");
		model.creaGrafo(2000);
		
		List<Border> bordi = model.getBordersConnYear();
		for(Border b : bordi)
			System.out.println("BORDO--"+b.toString());
		
		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
//		Map<Country, Integer> stats = model.getCountryCounts();
//		for (Country country : stats.keySet())
//			System.out.format("%s %d\n", country, stats.get(country));		
		
		
		List<Country> vicini = model.trovaVicini("Italy");
		for(Country c : vicini)
			System.out.println("VICINO--"+c.toString());
	}

}
