package handler;

import java.util.Arrays;
import domain.Member;

public class MemberList {
  
  static final int MEMBER_SIZE = 3;
  
  Member[] list;
  int size = 0;
  
  public MemberList() {
    this.list = new Member[MEMBER_SIZE];
  }
  
  public MemberList(int capacity) {
    if (capacity < MEMBER_SIZE || capacity > 10000)
      this.list = new Member[MEMBER_SIZE];
    else
      this.list = new Member[capacity];
  }

  public Member[] toArray() {
    
    /*
    Member[] arr = new Member[this.size];
    for (int i = 0; i < this.size; i++) {
        arr[i] = this.list[i];
    }
    */
    return Arrays.copyOf(this.list, this.size);
  }
  
  
  public void add(Member member) {
    if (this.size == this.list.length ) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    
  }
}
