<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
	<div class = "card-header">
		DTO 객체의 필드 값을 양식의 드롭다운리스트(select 태그)로 세팅
	</div>
	<div class="card-body">
<%-- 		<form>
			<!-- 이름이 똑같으면 묶기 쉽다, 레이블의 for는 id임 -->
			<c:forEach var="Language" items = "${languageList}" varStatus="status">
				<div class="form-check form-check-inline">
					  <input class="form-check-input" type="checkbox" 
					  	id="lang${status.count}" name="mlanguage" value="${language}"
					  	<c:forEach var="temp" items="${member.mlanguage}">
					  		<c:if test="${temp == language}">checked</c:if>
					  	</c:forEach>
					  	>
					  <label class="form-check-label" for="lang${status.count}">${language}</label>
				</div>
			</c:forEach>
		</form> --%>
		
		<form:form modelAttribute="member"> <!-- method= post, action은 현재 기본경로 form3가 기본값 -->
			<div class="form-check form-check-inline">
				<form:checkboxes items="${languageList}" path="mlanguage" class="ml-2 mr-1"/>
				<!-- 단점: 세부적으로 스타일 수정 주기(css 등) 어려움 -->
			</div>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>