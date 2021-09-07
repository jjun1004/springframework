<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
	<div class = "card-header">
		DTO 객체의 필드 값을 양식의 드롭다운리스트(select 태그)로 세팅
	</div>
	<div class="card-body">
<%-- 		<form method="get" action = "form3">
			<div>
						<!-- 이름이 똑같으면 묶기 쉽다, 레이블의 for는 id임 -->
						<c:forEach var="language" items = "${languageList}" varStatus="status"><span><input type="checkbox" 
					  	id="lang${status.count}" name="mlanguage" value="${language}"
					  	<c:forEach var="temp" items="${member.mlanguage}">
					  		<c:if test="${temp == language}">checked</c:if>
					  	</c:forEach>/><label for="lang${status.count}">${language}</label></span></c:forEach>
		  	</div>
		</form> --%>
		
		<form method="get" action = "form3">
			<div>
				<!-- 이름이 똑같으면 묶기 쉽다, 레이블의 for는 id임 -->
				<c:forEach var="language" items = "${languageList}" varStatus="status">
					<input type="checkbox" id="lang${status.count}" name="mlanguage" value="${language}"
				  	<c:forEach var="temp" items="${member.mlanguage}">
				  		<c:if test="${temp == language}">checked</c:if>
				  	</c:forEach>/>
				  	<label for="lang${status.count}">${language}</label>
			  	</c:forEach>
			  	<button class="btn btn-info btn-sm">제출</button> <!-- 버튼은 기본적으로 submit기능이 있음 -->
		  	</div>
		  	
		</form>
		
		<form:form modelAttribute="member" class = "mt-3"> <!-- method= post, action은 현재 기본경로 form3가 기본값 -->
			<div>
				<form:checkboxes items="${languageList}" path="mlanguage"/>
				<!-- 단점: 세부적으로 스타일 수정 주기(css 등) 어려움 -->
				<button class="btn btn-info btn-sm">제출</button>
			</div>
		</form:form>
		
		
		<form:form modelAttribute="member" class = "mt-3"> <!-- method= post, action은 현재 기본경로 form3가 기본값 -->
			<div><%-- path는 code를 기준으로 같은지 다른지 비교 --%>
				<form:checkboxes items="${skillList}" path="mskill" 
				itemValue="code" itemLabel="label"/>
				<!-- 단점: 세부적으로 스타일 수정 주기(css 등) 어려움 -->
				<button class="btn btn-info btn-sm">제출</button>
			</div>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>