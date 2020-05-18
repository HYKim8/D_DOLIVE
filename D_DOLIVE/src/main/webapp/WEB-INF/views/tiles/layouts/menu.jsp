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
<table>
  <tr>
    <td><a href="${context}/bizmember/do_select_one.do?email=이메일123&optionDiv=1">업체회원 조회</a></td>
  </tr>
</table>

