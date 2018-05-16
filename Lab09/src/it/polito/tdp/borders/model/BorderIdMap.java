package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.Map;

public class BorderIdMap {
	
	private Map<Integer, Border> map;
	
	public BorderIdMap() {
		map = new HashMap<>();
	}
	
	public Border get(int id) {
		return map.get(id);
	}
	
	public Border get(Border border) {
		Border old = map.get(border.getId());
		if (old == null) {
			map.put(border.getId(), border);
			return border;
		}
		return old;
	}
	
	public void put(Border border, int id) {
		map.put(id, border);
	}
}
