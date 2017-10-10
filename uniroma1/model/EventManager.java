package it.uniroma1.model;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
	
	private List<Evento> listaEventi;
	
	
   //costruttore eventManager
	public EventManager() {
		this.listaEventi= new ArrayList<>();
				}

	public List<Evento> getListaEventi() {
		return listaEventi;
	}
	
    // aggiunta evento in lista
	public String addEvento (String data, String titolo, String testo, String orario) {
		Evento nuovoEvento = new Evento(data, titolo, testo, orario);
		this.listaEventi.add(nuovoEvento);
		return nuovoEvento.toString();
	}
	
	//find all
	public String find() {
		String allEventi = "";
		for (Evento e : listaEventi) //sorta di for, utile con list
			allEventi += e.toString()+"\n";		
		if (allEventi.equals(""))
			return "Nessun evento";
		return allEventi;
	}
	
	//find specifico
	public String find( String data, String titolo) {
		for(Evento e : listaEventi) 
			if (e.getData().equals(data) && e.getTitolo().equals(titolo)) 
				return e.toString();
		return "Nessun evento";
		
		}

	

}
