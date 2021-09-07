<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
	<div class = "card-header">
		DTO 객체(Command Object)와 폼 연결
	</div>
	<div class="card-body">
		<form:form method="post" modelAttribute="member"> <!-- member가 dto 객체 -->
		  <div class="form-group">
		    <label for="mid">ID</label>
		    <form:input type="text" class="form-control" path="mid"/> <!-- path 때문에 id, name이 자동으로 들어감 -->
		  </div>
		  <div class="form-group">
		    <label for="mname">Name</label>
		    <form:input type="text" class="form-control" path="mname"/>
		  </div>
		  <div class="form-group">
		    <label for="mpasswrod">Password</label>
		    <form:password class="form-control" path="mpassword"/>
		  </div>
		  <div class="form-group">
		    <label for="mnation">Nation</label>
		    <form:input type="text" class="form-control" path="mnation"/> <!-- 끝태그 / 반드시 있어야 함 -->
		  </div>
		  	<button type="submit" class="btn btn-primary">Submit</button>
		 </form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>