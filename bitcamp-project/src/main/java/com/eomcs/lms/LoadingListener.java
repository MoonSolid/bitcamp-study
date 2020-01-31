package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class LoadingListener implements ApplicationContextListener {



  @Override
  public void contextInitialized(Map<String, Object> context) {

    loadingApplication();
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {


    // 애플리케이션이 종료되면 이 메서드를 호출될 것이고,
    // 이 메서드에서는 애플리케이션이 작업한 데이터를 저장하는 일을 한다.
    closeingApplication();
  }



  private void loadingApplication() {

    System.out.println("환영합니다 !");
    System.out.println("@@@@@    *^-^*     @@@@@");
  }

  private void closeingApplication() {

    System.out.println("안녕히가세요!");
    System.out.println("@@@@@    *^o^*     @@@@@");
  }

}
