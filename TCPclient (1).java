//-------------------------------------------------------
//					CSIT 340-01 Project 2
//					Aaron Manalili CSIT 340-01
//-------------------------------------------------------

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class TCPclient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int total = 0;
		int i = 0;
		
		System.out.println("Enter the Client's name. ");
		Scanner scan = new Scanner(System.in);
		
		String client = scan.next();
		System.out.println("This is " + client + "'s Client");
		
		System.out.println("Enter a number from 1 to 20");
		Scanner scan1 = new Scanner(System.in);
		
		int number = scan1.nextInt(); // this is the variable where the user enters a number in the range of 1 to 20
		System.out.println("The number is: " + number);
		
		if(number > 0 || number < 20) 
		{
			while (i <= number) 
			{
				total = (number * (number - 1)) / 2; // calculates sum of the first n natural number with user number
				i++;
			}
			
			System.out.println("The Sum of the first " + number + " natural number(s) for the user input is: " + total);
		}
		
		if(number == 0) 
		{
			System.out.println("Invalid int. The int must be in the range of 1 to 20.");
		}
		if(number > 20) 
		{
			System.out.println("Invalid int. The int must be in the range of 1 to 20.");	
		}
		
		try
		{
			Socket clientSocket = new Socket("localhost", 5555); // create a client socket
		
			OutputStream dataToServer = clientSocket.getOutputStream(); //OutputStream sends data to server
		
			PrintWriter writer = new PrintWriter(dataToServer, true); // wraps OutputStream to send data in text
			writer.println("This is a message going to Server");
		
			InputStream ServerInput = clientSocket.getInputStream(); // reads data from server
		
			InputStreamReader dataReader = new InputStreamReader(ServerInput); // InputStreamReader wraps InputStream
		
			int readMssg = dataReader.read(); // reads a single character
			System.out.println("The random number from " + client + "'s Server is: " + readMssg);
			
			if(readMssg % 2 == 0) // checks to see if int from tcp server is even or odd
			{
				System.out.println(readMssg + " is even"); // the int from the server is even
			}
			else 
			{
				System.out.println(readMssg + " is odd."); // the int from the server is odd
			}
		
		System.out.println("Client closing.");
		clientSocket.close(); // closes socket
		
		}
		catch(Exception e) 
		{
			System.out.println(e); // Catches an error if there is an error in the try block
		}
		
		
		
	}

}
