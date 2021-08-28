<%@ page contentType="text/html; charset=UTF-8" %>

<%
//System.out.println(request.getContextPath()); // 첫번 째 방법
//System.out.println(request.getServletContext().getContextPath()); // 두번 째 방법
//System.out.println(application.getContextPath()); //세번 째 방법
response.sendRedirect(application.getContextPath() + "/ch01/content"); // 첫 시작페이지

%> 

