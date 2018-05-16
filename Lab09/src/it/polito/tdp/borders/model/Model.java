package it.polito.tdp.borders.model;

import java.util.*;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	private BordersDAO bdao;
	private List<Country> countries;
	
	private CountryIdMap coMap;
	
	public Model() {
		bdao = new BordersDAO();
		coMap = new CountryIdMap();
		
		countries  = bdao.loadAllCountries(coMap);
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void creaGrafo(int year) {
		
		
	}

}
