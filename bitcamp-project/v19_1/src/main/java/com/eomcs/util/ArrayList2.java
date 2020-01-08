package com.eomcs.util;

public class ArrayList2 {
  private static final int DEFAULT_CAPACITY = 10; //기본값을 상수로 설정
  Object[] elementData; //데이터값을 저장할 배열  선언
  int size;
  
  
  public ArrayList2() { //초기화문장 생성자
    
    this.elementData = new Object[100];  //배열의 크기를 100으로 설정
  }
    
public ArrayList2(int initialCapacity) { //초기값을 파라미터로 받음
  if (initialCapacity < DEFAULT_CAPACITY) { //초기값이 기본값보다 적으면
  this.elementData = new Object[DEFAULT_CAPACITY]; //배열에 기본값을넣고
  } else {         //그게아니라면
    this.elementData = new Object[initialCapacity]; //초기값을 넣는다
  }
}

//객체를 목록에 저장하는 add메서드 추가 
public void add(Object e) { //객체를 담을 e를 선언
  if (this.size == this.elementData.length) { //만약 값의길이가  배열의 길이와 같다면 
    int oldSize = this.elementData.length;    //이전 길이에 현재 크기 값의 길이를넣고
    int newSize = oldSize + (oldSize >> 1);  //새 길이에 예전길이의 1.5배를 저장
    
    Object[] newArr = new Object[newSize];//새 배열을 만들고 그 배열에 새 길이 넣음
    for (int i = 0; i < this.size; i++) { //기존 배열만큼
      newArr[i] = this.elementData[i]; //새로운배열에 현재 배열의 값을 저장
    }
    this.elementData = newArr;           //그후 현재 배열값에 새로운배열저장
  }
  this.elementData[this.size++] = e; //데이터에 받은 값 e 를 저장 하면서 
}                                    //배열의 사이즈 하나 증가

//객체를 목록에서 꺼내는 get메서드 추가
public Object get(int index) {   //index를 받아옴
  return this.elementData[index];  //데이터에 인덱스를 넣고 리턴 
}

//목록의 특정 위치 값을 변경하는 set메서드 추가
public void set(int index, Object e) {  //인덱스와  메서드를 적용할 값 변수를 받음
  this.elementData[index] = e;         //데이터의 인덱스에 받아온 e값을 넣음
}

//목록에 저장
public void remove(int index) { //배열 인덱스를 받아옴
  
   for (int i = index + 1; i < this.size; i++) {
     //삭제할 인덱스의 다음인덱스부터 배열의 사이즈까지 
     this.elementData[i - 1] = this.elementData[i];
     //삭제한 인덱스에 다음인덱스에 값을 넣음 (인덱스삭제후 한칸씩 땡겨옴)
   }
   this.size--; //인덱스가 하나 줄었으니 배열사이즈 하나 감소 시킴
}



}




