package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.Map;

public class CountryIdMap {
	
	private Map<Integer, Country> map;
	
	public CountryIdMap() {
		map = new HashMap<>();
	}
	
	public Country get(int id) {
		return map.get(id);
	}
	
	public Country get(Country country) {
		Country old = map.get(country.getCode());
		if (old == null) {
			map.put(country.getCode(), country);
			return country;
		}
		return old;
	}
	
	public void put(Country country, int id) {
		map.put(id, country);
	}
}
