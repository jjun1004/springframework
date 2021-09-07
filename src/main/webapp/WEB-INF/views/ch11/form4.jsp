<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
	<div class = "card-header">
		DTO 객체의 필드 값을 양식의 드롭다운리스트(select 태그)로 세팅
	</div>
	<div class="card-body">
		
		<form method="post" action = "form4"> <!-- 기본 값은 get -->
			<div>
			<!-- 이름이 똑같으면 묶기 쉽다, 레이블의 for는 id임 -->
				<c:forEach var="job" items = "${jobList}" varStatus="status">
					<span>
						<input type="radio" id="lang${status.count}" name="mjob" value="${job}"
					  		<c:if test="${member.mjob == job}">checked</c:if>/>
					  	<label for="lang${status.count}">${job}</label>
				  	</span>
			  	</c:forEach>
	  		</div>
	  		<button class = "btn btn-info btn-sm">제출</button>
		</form>
	
		<form:form modelAttribute="member" class = "mt-3"> <!-- method= post, action은 현재 기본경로 form3가 기본값 -->
			<div>
				<form:radiobuttons items="${jobList}" path="mjob"/>
				<!-- 단점: 세부적으로 스타일 수정 주기(css 등) 어려움 -->
			</div>
			<button class = "btn btn-info btn-sm">제출</button>
		</form:form>
		
		
		<form:form modelAttribute="member" class = "mt-3"> <!-- method= post, action은 현재 기본경로 form3가 기본값 -->
			<div>
			<%-- path는 code를 기준으로 같은지 다른지 비교 --%>
				<form:radiobuttons items="${cityList}" path="mcity" 
								itemValue="code" itemLabel="label"/>
				<!-- 단점: 세부적으로 스타일 수정 주기(css 등) 어려움 -->
			</div>
			<button class = "btn btn-info btn-sm">제출</button>
		</form:form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>