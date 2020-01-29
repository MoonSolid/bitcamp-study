package test;

import java.io.FileOutputStream;

public class MyDataTest {



  public static void main(final String[] args) throws Exception {

    FileOutputStream out = new FileOutputStream("temp/test1.data");

    byte[] bytes = new byte[] {0x7a, 0x6b, 0x5c, 0x4d, 0x3e, 0x2f, 0x30};

    
   out.write(bytes, 2, 3);
   
   out.close();
   
   
   
   
    
    
  }

}


