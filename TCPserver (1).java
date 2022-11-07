//-------------------------------------------------------
//					CSIT 340-01 Project 2
//					Aaron Manalili CSIT 340-01
//-------------------------------------------------------

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class RandomInt
{
	int min = 1, max = 50;
	int randomNum = (int) ((Math.random() * (max - min)) + min);	// this formula is to generate a random number in the range of 1 to 50 
}

public class TCPserver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			
		try
		{
		ServerSocket server = new ServerSocket(5555); // clientSocket listens for a knock from the client on PORT 1234
		
		Socket connectToClient = server.accept(); // if client is able to connect, then the client socket is accepted
		String hostname = server.getInetAddress().getCanonicalHostName(); // gets the Hostname from the client socket
		
		System.out.println("This is " + hostname + "'s server. Ready to receive."); // prints server name (1)
		
		RandomInt random = new RandomInt(); // calls the RandomInt class to get a random number from 1 - 50
		System.out.println("Random number from 1 - 50: " + random.randomNum); // Prints out a random num from 1 to 50
		
		InputStream inputfromClient = connectToClient.getInputStream(); // Reads data sent from client
		BufferedReader ClientInput = new BufferedReader (new InputStreamReader(inputfromClient)); // BufferedReader wraps InputStream to read data as String 
		int text = ClientInput.read(); // reads a character
		
		int total2 = random.randomNum + text;
		
		System.out.println("Random number from 1-50 + number from the server + received user number = " + total2);
		
		OutputStream sendtoClient = connectToClient.getOutputStream(); // sends data to client via OutputStream
		PrintWriter GotoClient = new PrintWriter(sendtoClient, true); // sends data to client in text format
		GotoClient.println("This is a message from the Server"); // helps prevent NumberFormatException from appearing
		
		System.out.println("Server closing.");
		server.close(); //closes server socket
		}
		catch(Exception e)
		{
			System.out.println(e); // Catches an error if there is an error in the try block	
		}
	
	}

}
