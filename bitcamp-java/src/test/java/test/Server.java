package test;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {

    ServerSocket serverSocket = new ServerSocket(9999);
    Socket socket = serverSocket.accept();

    PrintStream out = new PrintStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());

    String message = in.readUTF();
    System.out.println("클라이언트 : " + message);


    out.println("내가 바보면 넌 멍청이야");


    out.close();
    in.close();
    serverSocket.close();
    socket.close();



  }
}
