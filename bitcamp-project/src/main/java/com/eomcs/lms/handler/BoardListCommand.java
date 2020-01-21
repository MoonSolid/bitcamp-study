// listBoard() 메서드 변경
// => toArray()의 리턴 값을 사용하는 대신 iterator()의 리턴 값을 사용하여 목록 출력.
package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  List<Board> boardList;

  public BoardListCommand(List<Board> list) {
    this.boardList = list;
  }

  @Override
  public void execute() {
    Iterator<Board> iterator = boardList.iterator();
    while (iterator.hasNext()) {
      Board b = iterator.next();
      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }


}


