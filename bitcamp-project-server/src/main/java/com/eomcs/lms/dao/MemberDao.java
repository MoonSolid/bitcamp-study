package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//
public interface MemberDao {

  int insert(Member member) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

<<<<<<< HEAD
  default List<Member> findByKeyword(String keyword) throws Exception {
    return null;
  }
=======
  List<Member> findByKeyword(String keyword) throws Exception;

  Member findByEmailAndPassword(Map<String, Object> params) throws Exception;
>>>>>>> c7b707544800620c24a93d8eb97ece0d01374b03
}


