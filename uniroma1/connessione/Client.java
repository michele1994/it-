package it.uniroma1.connessione;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import it.uniroma1.model.EventManager;

public class Client {
	
	public static void main(String[] args) {
		while(true) {
		
		System.out.println("usa queste operazioni:");
		System.out.println("1) aggiungi: \"add\"");   //  ("add$data#titolo%testo@orario")
		System.out.println("2) vedi lista: \"find\""); // ("find$")
		System.out.println("3) cerca evento: \"find$\" "); // ("find$data#titolo%")
		Scanner reader = new Scanner(System.in); 
		System.out.println("inserisci comando: ");
		String operazione = reader.nextLine();
		

		String comando = "";
		
		// da qui 
		if (operazione == "add") {
		    comando = operazione + "$";
			System.out.println("inserisci data: ");
			String data = reader.nextLine();
			comando = comando + data + "#";
			System.out.println("inserisci titolo: ");
			String titolo = reader.nextLine();
			comando = comando + titolo + "%";
			System.out.println("inserisci testo: ");
			String testo = reader.nextLine();
			comando = comando + testo + "@";
			System.out.println("inserisci orario: ");
			String orario = reader.nextLine();
			comando = comando + orario;
			System.out.println(comando);
		}
		else if (operazione == "find") {
			  comando = operazione + "$";
		 }
		else if (operazione =="find$"){
			System.out.println("inserisci dati (data e titolo): ");
			String data = reader.nextLine();
		    comando =  operazione + data + "#";
		    System.out.println("inserisci titolo: ");
			String titolo = reader.nextLine();
			comando = comando + titolo + "%";
		}
		//fino a qui 
		Utils utils = new Utils();
		
		
		
		if ((utils.interpretaOperazione(comando ))=="ERRORE\n" ){
			System.out.println("Comando non valido\n ");
		}
		else {
			
			try {
				//creazione nuova socket per ogni messaggio 
				Socket socket = new Socket("127.0.0.1", 5554);
				DataOutputStream  out = new DataOutputStream(socket.getOutputStream());
				DataInputStream in = new DataInputStream (socket.getInputStream());
				out.writeUTF(comando);
				System.out.println("La risposta del Server è:" + in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		
		}
		
		
		
	}
	
	
}
