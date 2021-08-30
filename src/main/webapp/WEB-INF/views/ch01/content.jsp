<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %> <!-- /는 webapp부터 시작. 서버가 접근하는 거라 WEB-INF 접근가능 -->

<div class = "card m-2">
		<div class = "card-header">
			프로젝트 생성 및 실행
		</div>
		
		<div class="card-body">
			<img src="${pageContext.request.contextPath}/resources/images/logo-spring.png"
				width="200px"/> <!-- 브라우저가 해석하는 부분이라 WEB-INF 불가능 -->
			<hr/>
				1. STS 설치	   <br/>
				2. 플러그인 설치  <br/>
				3. 프로젝트 생성  <br/>
				4. 프로젝트 설정  <br/>
		</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
