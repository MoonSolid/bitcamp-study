// Worker 구현체 사용
package com.eomcs.oop.ex09.a.before;

public class Exam01 {
    public static void main(String[] args) {
        // 인터페이스 레퍼런스
        // => 인터페이스를 구현한 클래스의 객체 주소를 저장하는 변수
      BlueWorker w1 = new BlueWorker();
        
        
      WhiteWorker w2 = new WhiteWorker();
      JubuWorker w3 = new JubuWorker();
        
        // 인터페이스 구현체 호출
        w1.doFight();
        w2.doZingZing();
        w3.doSsingSsing();
        // 역할?
        // caller : Exam01
        // callee : BlueWorker, WhiteWorker, JubuWorker
        // 규칙: Worker
        
    }
}



