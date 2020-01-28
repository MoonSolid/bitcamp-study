// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710x {

  public static void main(String[] args) throws Exception {



    File dir = new File("tmep");

    deleteFile(dir);

    System.out.println("디렉토리를 삭제했습니다.");

  }


  static void deleteFile(File dir) {
    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        deleteFile(file);
      } else {
        file.delete();
      }
    }
    {
      dir.delete();
    }
  }

}

