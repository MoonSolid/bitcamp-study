package com.eomcs.lms;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    final int SIZE = 100;
    

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] email = new String[SIZE];
    String[] password = new String[SIZE];
    String[] photo = new String[SIZE];
    String[] tel = new String[SIZE];
    Date[] registeredDate = new Date[SIZE];
    int count = 0;

    for (int i = 0; i < SIZE; i++) {
      System.out.print("번호는? ");
      no[i] = keyboard.nextInt();

      keyboard.nextLine();

      System.out.print("이름은? ");
      name[i] = keyboard.nextLine();

      System.out.print("이메일은? ");
      email[i] = keyboard.nextLine();

      System.out.print("암호는? ");
      password[i] = keyboard.nextLine();

      System.out.print("사진는? ");
      photo[i] = keyboard.nextLine();

      System.out.print("전화는? ");
      tel[i] = keyboard.nextLine();

      System.out.print("가입일은? ");
      registeredDate[i] = keyboard.nextLine();
      
      count++;
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      String answer = keyboard.nextLine();
      if (!answer.equalsIgnoreCase("y")) {
        break;
        
              }
            }
            keyboard.close();
        
            System.out.println();
        
            for (int i = 0; i < count; i++) {
              System.out.printf("번호: %d\n", no[i]);
              System.out.printf("이름: %s\n", name[i]);
              System.out.printf("이메일: %s\n", email[i]);
              System.out.printf("암호: %s\n", password[i]);
              System.out.printf("사진: %s\n", photo[i]);
              System.out.printf("전화: %s\n", tel[i]);
              System.out.printf("가입일: %s\n", registeredDate[i]);
              System.out.println();
            }
          }
        }
        

        
