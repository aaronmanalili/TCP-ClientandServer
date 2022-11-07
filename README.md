# TCP-ClientandServer
This is a project/assignment for my CSIT 340 (Computer Networking) class.

For this project, I had to create a TCP Client and Server, and use sockets for both the client and server in order to communicate with each other.
The Client and Server has been programmed in Java, and I used Command Prompt on my laptop in order to have the client and server to communicate.
In order to run this project, open 2 command prompts - one for client, one for server.

First, I had to save the client and server on my Documents folder on my laptop.
Open 1 command prompt to run the Server (the Server has to run first).
Type in: cd Documents
Then, type: javac TCPserver.java
Once compiled, type: java TCPserver.java

// The Server is running, now you have to run the Client.

To run the Client:
1. Open another Command prompt.
2. Type: cd Documents
3. Type: javac TCPclient.java
4. Type: java TCPclient.java

Once the client is compiled and you type java TCPclient.java, it will run.

On the client side:
You will be asked to enter the client name (in my project, I entered my name), and it will print out the client name.
Then, the client will ask you to enter a number from 1 to 20, and prints it out.
It will then print out the sum of the first n natural numbers of the int you entered, and a socket will send a message to the Server of the sum.

Then the server will send the sum of the first n natural numbers to the client and the client will print it out.
The client will determine if the sent number from the server is either even or odd, and it will print a message if it is either even or odd.
The client then closes.

For the Server side, I was tasked with:
Printing the name of the server
Establish a connection with the TCP client.
Extracting the message from the client and print out the sum of the first n natural numbers
Make the server pick a random int from 1 to 50 and print it out
Lastly, calculate the sum of the random number + the sum value from the message from the TCP client, and then send a message to the client that has the calculated sum.

This project was completed on October 20, 2022.
