package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Server {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.println("서버 실행중..");


    DatagramSocket socket = new DatagramSocket(8888);
    byte[] buf = new byte[8196];


    DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);
    System.out.println("데이터를 받으려면 엔터를 입력하세요.");
    scan.nextLine();

    socket.receive(emptyPacket);

    System.out.println("-------------------------------------------");
    scan.close();
    socket.close();

    System.out.println("-------------------------------------------");
    String message = new String(//
        emptyPacket.getData(), 0, emptyPacket.getLength(), "UTF-8");
    System.out.println("클라이언트의 데이터 출력");
    System.out.println("메시지 출력");
    System.out.println("클라이언트 " + message);
  }
}
