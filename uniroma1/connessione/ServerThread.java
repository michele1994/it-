package it.uniroma1.connessione;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import it.uniroma1.model.EventManager;

//sottoclassse di thread (extends)
public class ServerThread extends Thread {

	private Utils utils;
	private Socket socket;
	private EventManager eventManager;

	public ServerThread(Socket socket, EventManager eventManager) {
		super();// necessario ora
		this.socket = socket;
		this.utils = new Utils();
		this.eventManager = eventManager;

	}

	@Override
	public void run() {

		super.run();

		try {
			DataInputStream in;
			in = new DataInputStream(this.socket.getInputStream());
			DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());
			String messaggioAlServer = in.readUTF();
			String risultato = this.utils.interpretaOperazione(messaggioAlServer); // lettura dell'input al server
			String risposta = null;
			if (risultato == "add") {
				String parametri = utils.getParametri(messaggioAlServer);
				risposta = this.eventManager.addEvento(utils.getData(parametri), utils.getTitolo(parametri),
						utils.getTesto(parametri), utils.getOrario(parametri));
			}
			else if (risultato == "find")
				risposta = this.eventManager.find();
			else if (risultato == "findByDataAndTitolo") {
				String parametri = utils.getParametri(messaggioAlServer);
				risposta = this.eventManager.find(utils.getData(parametri), utils.getTitolo(parametri));
			} else
				risposta = "ERRORE";
			out.writeUTF(risposta);// invio del risultato
			System.out.println(risultato);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
