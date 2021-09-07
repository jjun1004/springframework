<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
	<div class = "card-header">
		국제화를 적용한 폼
	</div>
	<div class="card-body">
		<form:form modelAttribute="member"> <!-- method="post" action="form5" -->
			<div class="form-group">
			    <label for="mid"><spring:message code="join.form.mid"/></label> <!-- code는 properties 파일 내부에서 확인 -->
			    <form:input type="text" class="form-control" path="mid"/> <!-- path 때문에 id, name이 자동으로 들어감 -->
			</div>
		  <div class="form-group">
		    <label for="mname"><spring:message code="join.form.mname"/></label>
		    <form:input type="text" class="form-control" path="mname"/>
		  </div>
		  <div class="form-group">
		    <label for="mpassword"><spring:message code="join.form.mpassword"/></label>
		    <form:password class="form-control" path="mpassword"/>
		  </div>
		  <div class="form-group">
		    <label for="mnation"><spring:message code="join.form.mnation"/></label>
		    <form:input type="text" class="form-control" path="mnation"/> <!-- 끝태그 / 반드시 있어야 함 -->
		  </div>
		  	<button type="submit" class="btn btn-primary"><spring:message code="join.form.submit"/></button>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>