package handler;

import java.util.Arrays;
import domain.Lesson;

public class LessonList {

  static final int LESSON_SIZE = 3;
  
  Lesson[] list;  
  int size = 0;
  
  public LessonList() {
    this.list = new Lesson[LESSON_SIZE];
  }
  
  public LessonList(int capacity) {
    if (capacity < LESSON_SIZE  || capacity > 10000) 
      this.list = new Lesson[LESSON_SIZE]; 
      else 
        this.list = new Lesson[capacity];
  }

  public Lesson[] toArray() {
    
    
    /*
    Lesson[] arr = new Lesson[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    */
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Lesson lesson) {
    if (this.size == this.list.length) {
    int oldCapacity = this.list.length; 
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    
    this.list = Arrays.copyOf(this.list , newCapacity);
    }
  }
    
  
}
