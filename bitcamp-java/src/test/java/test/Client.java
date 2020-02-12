package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);

    DatagramSocket socket = new DatagramSocket();

    String receiver = "localhost";
    int port = 8888;



    System.out.println("서버로 보낼 메시지를 입력하세요 : ");
    byte[] bytes = scan.nextLine().getBytes("UTF-8");

    DatagramPacket packet =
        new DatagramPacket(bytes, bytes.length, InetAddress.getByName(receiver), port);

    System.out.println("메시지를 보내려면 엔터를 입력하세요");
    scan.nextLine();
    socket.send(packet);

    scan.close();
    socket.close();



  }
}

