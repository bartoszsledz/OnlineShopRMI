package server;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nazwa;
	private String producent;
	private double cena;
	private int iloscWMagazynie;

	public Product(int id, String nazwa, String producent, double cena, int iloscWMagazynie) {
		this.id = id;
		this.nazwa = nazwa;
		this.producent = producent;
		this.cena = cena;
		this.iloscWMagazynie = iloscWMagazynie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getProducent() {
		return producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getIloscWMagazynie() {
		return iloscWMagazynie;
	}

	public void setIloscWMagazynie(int iloscWMagazynie) {
		this.iloscWMagazynie = iloscWMagazynie;
	}

	@Override
	public String toString() {
		return "Produkt [id=" + id + ", nazwa=" + nazwa + ", producent=" + producent + ", cena=" + cena
				+ ", iloscWMagazynie=" + iloscWMagazynie + "]";
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
}