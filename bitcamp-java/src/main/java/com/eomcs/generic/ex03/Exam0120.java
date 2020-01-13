package com.eomcs.generic.ex03;

import java.lang.reflect.Array;

public class Exam0120 {

  //제네릭의 타입을 지정할 때 수퍼 클래스를 지정하면 그 타입 및 서브 타입만 가능하다.
  // 즉 T 자리에 어떤 타입이라도 울 수 있다.
  //=> 다음클래스의 타입 파라미터는 
  //Manager 나 그 하위 클래스만 지정할 수 있다. 

  static class ArrayList<T extends Manager> {
    T[] arr;
    int index = 0;

    public ArrayList(Class<?> clazz) {
      this.arr = (T[])Array.newInstance(clazz, 10);
    }

    public void add(T v) {
      arr[index++] = v;
    }

    public T get(int index) {
      return arr[index];
    }

  } 

  public static void main(String[] args) {

    ArrayList<Manager> obj = new ArrayList<>(Manager.class);
    //ArrayList<Administrator> obj = new ArrayList<>(Administrator.class); //ok
    
    obj.add(new Manager());
    obj.add(new Administrator());

    System.out.println(obj.get(0));
    System.out.println(obj.get(1));
    System.out.println(obj.get(2));
    System.out.println(obj.get(3));
  }

}
