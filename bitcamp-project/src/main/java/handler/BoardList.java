package handler;

import java.util.Arrays;
import domain.Board;

public class BoardList {
  
  static final int DEFAULT_CAPACITY = 3;  //기본 사이즈 지정
  
  Board[] list;
  int size = 0;
  
  public BoardList() {                           //list에 사이즈 값으로 초기화
    this.list = new Board[DEFAULT_CAPACITY];
  }
  
  public BoardList(int capacity) {                 //리스트를 입력받고
    if (capacity < DEFAULT_CAPACITY || capacity > 10000) //입력값이 기본값보다 작거나 기본값이 10000보다크면
      this.list = new Board[DEFAULT_CAPACITY];           //리스트에 기본값을 넣고
    else                                                 //그게 아니라면
      this.list = new Board[capacity];                   //입력값을 넣는다 
  }

  public Board[] toArray() {
    /*
    Board[] arr = new Board[this.size];
    for (int i = 0; i < this.size; i++) {         //배열사이즈를 증가시키는 부분
      arr[i] = this.list[i];
    }
    */
    return Arrays.copyOf(this.list, this.size);
    
  }

  public void add(Board board) {
   if (this.size == this.list.length ) {  //현재 배열에 게시글 객체가 꽉 찼으면 배열을 늘린다.
     
     int oldCapacity = this.list.length;  //옛날 배열 갯수
     int newCapacity = oldCapacity + (oldCapacity >> 1); //새로운 배열의 갯수는 옛날배열갯수의 1.5배
     
     /* 
     Board[] arr = new Board[newCapacity];            
     for (int i = 0; i < this.list.length; i++) {  //추가로 증가
       arr[i] = this.list[i];       
     }
     this.list = arr;
     */
      
    this.list = Arrays.copyOf(this.list, newCapacity);//copyOf메서드는 새배열을 만들어주는메서드
      
     System.out.printf("새 배열을 %d 개 생성하였음", newCapacity);
   }
    this.list[this.size++] = board;
  }
  
  public Board get(int no) {                   //detail 부분
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}










