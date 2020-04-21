<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"/>

<h1>공고 상세정보</h1>

<c:if test="${not empty jobPosting}">
<form action='update' method='post'>
공고번호: <input name='jobPostingNumber' readonly type='text' value='${jobPosting.jobPostingNumber}'><br>
공고제목: <input name='title' type='text' value='${jobPosting.title}'><br>
내용:<br>
<textarea name='content' rows='5' cols='60'>${jobPosting.content}</textarea><br>
최소경력: <input name='startDate' type='number' value='${jobPosting.minimumCareer}'><br>
직무: <input name='endDate' type='text' value='${jobPosting.job}'><br>
연봉: <input name='totalHours' type='number' value='${jobPosting.yearSalary}'><br>
시작일: <input name='dayHours' type='date' value='${jobPosting.startDated}'><br>
마감일: <input name='dayHours' type='date' value='${jobPosting.endDated}'><br>
조회수: <input name='viewCount' type='number' value='${jobPosting.viewCount}'><br>
<p>
<button>변경</button>
<a href='delete?no=${jobPosting.jobPostingNumber}'>삭제</a>
</p>
</form>
</c:if>

<c:if test="${empty jobPosting}">
<p>해당 공고가 없습니다.</p>
</c:if>

<jsp:include page="../footer.jsp"/>
    