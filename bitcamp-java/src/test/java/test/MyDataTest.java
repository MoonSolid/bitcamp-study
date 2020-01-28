package test;

import java.io.File;

public class MyDataTest {
  public static void main(final String[] args) {

    File dir = new File("temp");

    deleteFile(dir);

    System.out.println("디렉토리를 삭제하였습니다.");

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

    dir.delete();


  }

}


