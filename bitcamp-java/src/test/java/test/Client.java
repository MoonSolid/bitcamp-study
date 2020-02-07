package test;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws Exception {

    Socket socket = new Socket("localhost", 9999);

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());


    out.writeUTF("바보야 ");

    String response = in.nextLine();
    System.out.println(response);



    socket.close();
    out.close();
    in.close();
  }
}

