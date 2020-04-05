package test;

import java.util.Scanner;

public class Calculator {



  void plus() {

    Scanner scan = new Scanner(System.in);

    System.out.println("첫번째 숫자 : ");
    int a = scan.nextInt();

    System.out.println("두번째 숫자 : ");
    int b = scan.nextInt();

    int sum = a + b;

    System.out.printf("%d 더하기  %d 는  %d 입니다.", a, b, sum);

  }

}
