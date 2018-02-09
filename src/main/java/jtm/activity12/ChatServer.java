package jtm.activity12;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class ChatServer implements Runnable {

	// Thread safe list of connections to connected clients
	static Vector<ChatServer> connections;
	// Common structures for all threads:
	static final int port = 9999; // port to listen on
	// server socket, which listens to new connections
	static ServerSocket server;

	/**
	 * This is entry point to start Chat Server. Note that this method do not
	 * use behavior which is implemented for Runnable interface.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// 1. initialize vector of connections#

		connections = new Vector();
		
//		ChatServer cServer = new ChatServer(new Socket());
//		connections.add(cServer);
		
		// 2. try to create ServerSocket on specified port
			try {
				server = new ServerSocket(port);
			} catch (IOException e) {
				// 3. handle exceptions (show exception and exit with error
				// status)
				e.printStackTrace();
				System.exit(1);
			}

			
			// Try to initialize client Socket in infinite loop with
			// server.accept() method
			while (true) {
				try {
					Socket client;
					client =  server.accept();
					// 3. if socket is initialized successfully, create new Thread
					// passing new ChatServer(socket) as a parameter for it.
					// Then invoke start() method for this thread
					Thread t1 = new Thread(new ChatServer(client));
					t1.start();
				} catch (IOException e) {
					e.printStackTrace();
				}	
		}
	}
	// Structures for separate threads:
	// reference to client socket when new connection is accepted
	private Socket client;
	private Scanner in; // for reading from client socket

	private PrintWriter out; // for writing to client socket

	/**
	 * This constructor is used to pass client Socket reference for new thread
	 * 
	 * @param client
	 */
	ChatServer(Socket client) {
		// 1. save passed client socket reference into current object
		this.client = client;
		// 2. Add newly created ChatServer into connections collection
		connections.add(this);
		// 3. Try to add input and output streams to the client socket
		// HINT: to see output for each entered message, construct PrintWriter
		// with auto flush option (or use flush() method)
		try {
			in = new Scanner(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
				// 3. handle exceptions

	/**
	 * This method processes each connected client and writes received messages
	 * to all other clients
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		// try to read lines in loop from the input reader of the
		// client and
		// write it to all clients (including current client) in form:
		// "> message"
		// HINT: use connections to traverse all clients and invoke
		// sendMsg(msg)
		// for them
		
		while(true) {
			String line;
			line = in.nextLine();
			if (line != null){
				sendMsg(line);
			}
		//  2. if message is "quit" or "exit", break loop
			if (line.equals("quit") || line.equals("exit")) {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		out.flush();
		out.close();
		in.close();
					
					// 4. finally close all inputs and outputs of the connection,
					// and
					// remove current object reference from connections collection
					// and handle exceptions for these operations, if necessary
				}

	/**
	 * This method is used to write message to the all connected clients
	 * 
	 * @param msg
	 */
	public void sendMsg(String msg) {
		// print passed message into output stream (out) with writer of
		// current
		// object
		for (ChatServer x : connections)
		{
			x.out.write("> " + msg +"\n");
			x.out.flush();
		}
	}
}
