package oop.Test;

//gym 회원 정보를 입력 받아 출력
public class Test06 {
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
    
    Member m2 = m1;
    
    // 기존 레퍼런스에 새 인스턴스의 주소를 저장한다.
    // 따라서 m1과 m2는 서로 다른 인스턴스의 주소를 갖고 있다.
    // 즉 m1과 m2가 가리키는 인스턴스가 다르다.
    m1 = new Member();
    m1.no = 200;
    
    
    System.out.println(m1.no);
    System.out.println(m2.no);
   
  }
}

