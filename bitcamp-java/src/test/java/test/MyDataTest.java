package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDataTest {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("입력 : ");
    String command = br.readLine();

    Pattern p = Pattern.compile("^[0-9]{3}-[0-9]{4}-[0-9]{4}&");
    Matcher m = p.matcher(command);

    if (m.find()) {
      System.out.println("휴대폰 번호입니다.");
    } else {
      System.out.println("휴대폰 번호가 아닙니다.");
    }
  }
}


