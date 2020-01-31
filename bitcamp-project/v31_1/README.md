# 31_1 - `Observer` 디자인 패턴을 적용하여 클래스 구조를 변경

## 학습목표

- `Observer` 디자인 패턴의 용도와 이점을 이해한다.
- 옵저버 호출 규칙을 정의할 수 있다.
- 옵저버 구현체를 등록하고 제거하는 메서드를 추가할 수 있다.
- 특정 상태에서 옵저버를 호출할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/context/ApplicationContextListener.java 추가
- src/main/java/com/eomcs/lms/App.java 변경

## 실습  

### 훈련 1: App 클래스의 스태틱 필드와 메서드를 인스턴스 멤버로 전환한다.

- App.java (App.java.01)
  - 스태틱 필드와 스태틱 메서드를 인스턴스 필드와 인스턴스 메서드로 전환한다.
  - 보통 실무에서는 클래스의 일반적인 구조로 인스턴스 필드와 메서드를 사용한다.

### 훈련 2: 애플리케이션이 시작하거나 종료될 때 호출될 옵저버의 규칙을 정의한다.

- ApplicationContextListener.java (ApplicationContextListener.java.01)
  - Observer가 갖춰야 할 규칙을 정의한다.
  - 애플리케이션이 시작할 때 자동으로 호출할 메서드의 규칙을 정의한다.
  - 애플리케이션을 종료하기 전에 자동으로 호출할 메서드의 규칙을 정의한다.


### 훈련 3: App 객체에 옵저버를 등록하고 제거하고 실행시키는 기능을 추가한다.

- App.java
  - 옵저버를 등록하는 메서드를 추가한다.
  - 옵저버를 제거하는 메서드를 추가한다.
  - 애플리케이션을 시작할 때 옵저버를 호출한다.
  - 애플리케이션을 종료할 때 옵저버를 호출한다.
