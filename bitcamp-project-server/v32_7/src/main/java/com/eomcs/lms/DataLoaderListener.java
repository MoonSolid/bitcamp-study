package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardObjectFileDao;
import com.eomcs.lms.dao.LessonObjectFileDao;
import com.eomcs.lms.dao.MemberObjectFileDao;

public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    // 애플리케이션의 데이터를 처리할 객체를 준비한다.
    BoardObjectFileDao boardDao = new BoardObjectFileDao("./board.ser2");
    MemberObjectFileDao memberDao = new MemberObjectFileDao("./member.ser2");
    LessonObjectFileDao lessonDao = new LessonObjectFileDao("./lesson.ser2");


    // 이 메서드를 호출한 쪽(App)에서 Dao 객체를 사용할 수 있도록 Map 객체에 담아둔다.
    context.put("boardDao", boardDao);
    context.put("lessonDao", lessonDao);
    context.put("memberDao", memberDao);

  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}
}
