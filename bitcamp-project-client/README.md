# 36 - 데이터 관리를 전문 프로그램인 DBMS에게 맡기기

## 학습목표

- 오픈소스 DBMS 'MariaDB'를 설치할 수 있다.
- DBMS에 사용자와 데이터 베이스를 추가할 수 있다.
- 테이블 생성과 예제 데이터를 입력할 수 있다.
- JDBC API의 목적을 이해한다.
 - DBMS와의 통신을 담당하는 proxy 객체의 사용 규칙을 통일하는 것.
- JDBC Driver의 의미를 이해한다.
 - JDBC API 규칙에 따라 정의한 클래스들(라이브러리).
- JDBC API를 활용하여 DBMS에 데이터를 입력, 조회, 변경, 삭제할 수 있다.
- JDBC 프로그래밍 코드를 클래스로 캡슐화 할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/proxy/Worker.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/DaoProxyHelper.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/XxxDaoProxy 변경
- src/main/java/com/eomcs/lms/ClientApp.java 변경

## 실습  

### 훈련 1: 애플리케이션에서 사용할 사용자와 데이터베이스를 MariaDB에 추가한다.

- com.eomcs.dao.proxy.Worker 인터페이스를 정의한다.

### 훈련 2: DaoProxy를 도와 서버와의 연결을 담당할 객체를 정의하라. 

- com.eomcs.dao.proxy.DaoProxyHelper 를 정의한다.

### 훈련 3: DaoProxyHelper를 사용하도록 DaoProxy를 변경하라.

- com.eomcs.lms.dao.rpoxy.XxxDaoProxy 를 변경한다.

### 훈련 4: DaoProxyHelper가 추가된 것에 맞춰 ClientApp을 변경하라.

- com.eomcs.lms.ClientApp 변경한다.
  
