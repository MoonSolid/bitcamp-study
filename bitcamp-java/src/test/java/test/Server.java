package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Server {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    DatagramSocket socket = new DatagramSocket(8888);
    System.out.println("서버 시작");

    byte[] buf = new byte[8196];

    DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);

    System.out.println("메시지를 받으려면 엔터를 입력하세요");
    scan.nextLine();
    socket.receive(emptyPacket);


    String message = new String(emptyPacket.getData(), 0, emptyPacket.getLength(), "UTF-8");



    System.out.println("클라이언트" + message);

    socket.close();



  }
}
