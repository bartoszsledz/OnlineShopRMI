package server;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nazwa;
	private String producent;
	private double cena;
	private int iloscWKoszyku;

	public Order(int id, String nazwa, String producent, double cena, int iloscWMagazynie) {
		this.id = id;
		this.nazwa = nazwa;
		this.producent = producent;
		this.cena = cena;
		this.iloscWKoszyku = iloscWMagazynie;
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
		return iloscWKoszyku = iloscWKoszyku - (iloscWKoszyku - 1);
	}

	public void setIloscWMagazynie(int iloscWMagazynie) {
		this.iloscWKoszyku = iloscWMagazynie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", nazwa=" + nazwa + ", producent=" + producent + ", cena=" + cena
				+ ", iloscWMagazynie=" + iloscWKoszyku + "]";
	}
}