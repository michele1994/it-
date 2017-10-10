package it.uniroma1.connessione;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.MalformedInputException;

import it.uniroma1.model.EventManager;

public class Server {

	private final static int PORT_NUMBER = 5554; // porta di ascolto
	private EventManager eventManager;

	public Server() {
		this.eventManager = new EventManager();
	}

	

	public static void main(String[] args) {
		Server server = new Server();
		ServerSocket socketConnessioni = null;
		try {
			socketConnessioni = new ServerSocket(PORT_NUMBER);
			while (true) {
				Socket socketDati = socketConnessioni.accept();
				
				//creazione nuovo thread per eseguire task socketDati
				ServerThread thread = new ServerThread(socketDati, server.eventManager);
				thread.start();//fa partire il metodo run di ogni singolo thread
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("porta occupata");
		} finally {
			try {
				socketConnessioni.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("socket aperta");
			}
		}

	}
}
