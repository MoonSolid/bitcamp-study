<%@page import="com.portfoli.domain.JobPosting"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<jsp:include page="/header.jsp"/>

<h1>공고 변경</h1>

<form action='update' method='post'>
공고번호: <input name='no' readonly type='text' value='${jobPosting.jobPostingNumber}'><br>
내용:<br>
<textarea name='content' rows='5' cols='60'>${jobPosting.content}</textarea><br>
최소경력: ${jobPosting.minimumCareer}<br>
직무: ${jobPosting.job}<br>
연봉: ${jobPosting.yearSalary}<br>
시작일: ${jobPosting.startDated}<br>
마감일: ${jobPosting.endDated}<br>
조회수: ${jobPosting.viewCount}<br>
<button>변경</button>
</form>
<jsp:include page="/footer.jsp"/>
    