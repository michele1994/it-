package it.uniroma1.model;

public class Evento {

	private String data;
	private String titolo;
	private String testo;
	private String orario;
	
	
	
	public Evento(String data, String titolo, String testo, String orario) {
		super();
		this.data = data;
		this.titolo = titolo;
		this.testo = testo;
		this.orario = orario;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getOrario() {
		return orario;
	}
	public void setOrario(String orario) {
		this.orario = orario;
	}

	@Override
	public String toString() {
		return "Evento [data=" + data + ", titolo=" + titolo + ", testo=" + testo + ", orario=" + orario + "]";
	}
	
	
	
}
