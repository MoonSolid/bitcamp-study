package oop.Test;

//gym 회원 정보를 입력 받아 출력
public class Test05 {
  public static void main(String[] args) {

    //회원 정보를 담을 수 있는 메모리의 설계도
    class Member {

      int no;
      String name;
      int birthYear;
      boolean gender;
      float height;
      float weight;
      boolean personalTraining;
    }

    //자바 원시 데이터 타입은 그냥 변수를 선언하는 순간 메모리도 준비된다.
    //변수가 곧 메모리이다.
    int i;

    i = 100; // ok!

    //그러나 레퍼런스는 메모리의 주소를 담는 변수이다.
    //레퍼런스를 선언했다고해서 해당 설계도의 메모리가 준비되는 것은 아니다.
    Member m1;
    m1 = new Member();
    m1.no = 100;
    System.out.println(m1); // 인스턴스에 부여된 고유 번호와 클래스명이 출력된다.
    System.out.println(m1.no);  //no 변수의 값을 출력한다.

    //레퍼런스의 주소를 없애는 방법
    m1 = null; //주소가 없다는 의미로 실제 메모리가에0으로 설정된다.
    System.out.println(m1);
    System.out.println(m1.no);

  }

}

