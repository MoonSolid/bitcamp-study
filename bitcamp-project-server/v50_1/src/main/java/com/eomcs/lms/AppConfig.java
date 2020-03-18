package com.eomcs.lms;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.sql.MybatisDaoFactory;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;

// Spring IoC 컨테이너가 탐색할 패키지 설정
// => 지정한 패키지 및 그 하위 패키지를 모두 뒤져서
// @Component 애노테이션이 붙은 클래스를 찾아 객체를 생성한다.
@ComponentScan(value = "com.eomcs.lms")
public class AppConfig {


  public AppConfig() throws Exception {

  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    // Mybatis 설정 파일을 로딩할 때 사용할 입력 스트림 준비
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/lms/conf/mybatis-config.xml");

    // 트랜잭션 제어를 위해 오리지널 객체를 프록시 객체에 담아 사용한다.
    return new SqlSessionFactoryProxy(//
        new SqlSessionFactoryBuilder().build(inputStream));
  }

  @Bean
  public MybatisDaoFactory daoFactory(
      // 이 메서드를 호출할 때 Spring IoC 컨테이너에 들어 있는 개체를 원한다면,
      // 이렇게 파라미터로 선언하라.
      // 그러면 Spring IoC 컨테이너가 이 팩토리 메서드를 호출하기 전에
      // SqlSessionFactory를 먼저 준비한 다음에 이 메서드를 실행할 것이다.
      SqlSessionFactory sqlSessionFactory) {

    return new MybatisDaoFactory(sqlSessionFactory);
  }

  @Bean
  public PlatformTransactionManager TransactionManager(//
      // 필요한 값이 있다면 이렇게 파라미터로 선언만 하라.
      // 단 IoC 컨테이너에 들어 있는 값이어야 한다.

      SqlSessionFactory sqlSessionFactory//
  ) {
    return new PlatformTransactionManager(sqlSessionFactory);
  }

  @Bean
  public BoardDao BoardDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(BoardDao.class);
  }

  @Bean
  public LessonDao LessonDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(LessonDao.class);
  }

  @Bean
  public MemberDao MemberDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(MemberDao.class);
  }

  @Bean
  public PhotoBoardDao PhotoBoardDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(PhotoBoardDao.class);
  }

  @Bean
  public PhotoFileDao PhotoFileDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(PhotoFileDao.class);
  }

}

