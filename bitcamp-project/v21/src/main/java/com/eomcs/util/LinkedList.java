package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  Node<E> first;

  Node<E> last;

  int size;

  public void add(E value) {
    Node<E> newNode = new Node<E>() ;

    newNode.value = value;

    if (first == null) {
      last = first = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }

    this.size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++)  {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= size)
      return;

    Node<E> newNode = new Node<>();
    newNode.value = value;

    Node<E> cursor = first;
    for (int i = 0; i < index - 1; i++)  {
      cursor = cursor.next;
    }

    if (index == 0) {  
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next; //현재 노드를 다음주소로 설정 한다
      cursor.next = newNode;      //그리고 현재 노드를 새로운 노드로 설정한다
    }

    this.size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index -1; i++)  {
      cursor = cursor.next;
    }

    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    }else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }

    deletedNode.next = null;
    size--;

    return deletedNode.value;

  }


  public E set(int index, E value) {
    if (index < 0 || index >= size)
      return null;

    Node<E> cursor = first;
    for (int i = 0; i < index; i++)  {
      cursor = cursor.next;
    }

    E oldValue = cursor.value;
    cursor.value = value;

    return oldValue;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];

    Node<E> cursor = first;
    for (int i = 0; i < size; i++)  {
      arr[i] = cursor.value; //첫번째 커서를 i번방에 담고
      cursor = cursor.next;  //다음커서로 이동함
    }
    
    return arr;
  }

  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) { //배열이 사이즈보다 적으면 새 배열을 만들어준다.

    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }
    
    
    Node<E> cursor = first;
    for (int i = 0; i < size; i++)  {
      arr[i] = cursor.value; //첫번째 커서를 i번방에 담고
      cursor = cursor.next;  //다음커서로 이동함
    }
    
    return arr;
  }
  
  public int size() {
    return this.size;
  }
  
  static class Node<T>  {
    T value;
    Node<T> next;
  }
}
