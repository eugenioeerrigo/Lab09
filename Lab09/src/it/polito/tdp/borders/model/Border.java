package it.polito.tdp.borders.model;

public class Border {
	
	private int id;
	private Country c1;
	private Country c2;
	private int year;
	
	public Border(int id, Country c1, Country c2, int year) {
		this.id = id;
		this.c1 = c1;
		this.c2 = c2;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getC1() {
		return c1;
	}

	public void setC1(Country c1) {
		this.c1 = c1;
	}

	public Country getC2() {
		return c2;
	}

	public void setC2(Country c2) {
		this.c2 = c2;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Border [id=" + id + ", c1=" + c1 + ", c2=" + c2 + ", year=" + year + "]";
	}

	
}
