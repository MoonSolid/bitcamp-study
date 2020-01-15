// Object 클래스의 메서드를 오버라이딩 하기 - hashCode()
package com.eomcs.oop.ex06.d;

public class Exam0220 {

    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.sum = kor + eng + math;
            this.aver = this.sum / 3f;
        }
        
        // hashCode()를 오버라이딩하면 원하는 값을 리턴할 수 있다.
        @Override
        public int hashCode() {
            // 무조건 모든 Score 인스턴스가 같은 해시코드를 갖게 하기
            return 1000;
        }
    }
    
    public static void main(String[] args) {
        Score s1 = new Score("홍길동", 100, 100, 100);
        Score s2 = new Score("홍길동", 100, 100, 100);
        
        // 같은 값을 가질 때 같은 해시값을 리턴하도록 
        // hashCode()를 오버라이딩 했기 때문에
        // 다음 출력은 같은 해시 값을 출력할 것이다.
        System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
        
        // hashCode()의 리턴 값을 비교하여 두 인스턴스의 값이 같은지 알아낼 수도 있다.
        System.out.println(s1.hashCode() == s2.hashCode());
        
    }
}






