package it.uniroma1.connessione;

import java.net.Socket;

import it.uniroma1.model.EventManager;

public class Utils {
	

	public String interpretaOperazione( String messaggio) {
		if (messaggio.equals("")) 
			return "ERRORE\n";
		
		String operazione = messaggio.substring(0, messaggio.indexOf("$"));
		if (operazione.equals("add")) {
			return "add";
		} else if (operazione.equals("find") && messaggio.length() == 5) // find$ 5 caratteri
			return "find";
		else if (operazione.equals("find")) {
			return "findByDataAndTitolo";
		} else
			return "ERRORE\n";
	
	}

	public String getParametri(String messaggio) {
		return messaggio.substring(messaggio.indexOf("$") + 1);
	}

	public String getOrario(String parametri) {
		return parametri.substring(parametri.indexOf("@") + 1);
	}

	public String getTesto(String parametri) {
		return parametri.substring(parametri.indexOf("%") + 1, parametri.indexOf("@"));
	}

	public String getTitolo(String parametri) {
		return parametri.substring(parametri.indexOf("#") + 1, parametri.indexOf("%"));
	}

	public String getData(String parametri) {
		return parametri.substring(0, parametri.indexOf("#"));
	}
	
}