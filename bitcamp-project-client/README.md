# 34 - 다중 클라이언트 요청을 동시에 처리하기

## 학습목표

- Thread의 사용 목적과 동작원리을 이해한다.
- Thread를 정의하고 사용할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/proxy/Worker.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/DaoProxyHelper.java 추가
- src/main/java/com/eomcs/lms/dao/proxy/XxxDaoProxy 변경
- src/main/java/com/eomcs/lms/ClientApp.java 변경

## 실습  

### 훈련 1: 서버와 통신을 담당할 실제 작업의 규칙을 정의하라.

- com.eomcs.dao.proxy.Worker 인터페이스를 정의한다.

### 훈련 2: DaoProxy를 도와 서버와의 연결을 담당할 객체를 정의하라. 

- com.eomcs.dao.proxy.DaoProxyHelper 를 정의한다.

### 훈련 3: DaoProxyHelper를 사용하도록 DaoProxy를 변경하라.

- com.eomcs.lms.dao.rpoxy.XxxDaoProxy 를 변경한다.

### 훈련 4: DaoProxyHelper가 추가된 것에 맞춰 ClientApp을 변경하라.

- com.eomcs.lms.ClientApp 변경한다.
  
