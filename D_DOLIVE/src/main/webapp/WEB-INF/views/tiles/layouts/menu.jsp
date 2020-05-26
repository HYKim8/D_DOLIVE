<%--
  /**
  * Class Name : menu.jsp
  * Description : tiles menu
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 15.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath }" />
  	<div style="margin : 77px 0 0 0;"><a href="${context}/member/gomypage.do">내 정보 조회</a></div>
    <div><a href="${context}/member/goupdate.do">내 정보 수정</a></div>
    <div><a href="${context}/reserv/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=10&searchWord=&optionDiv=1">예약목록 조회</a></div>
    <div><a href="${context}/notice/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=10">알림 신청 목록 조회</a></div>

