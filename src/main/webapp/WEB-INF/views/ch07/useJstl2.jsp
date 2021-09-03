<%@ page contentType="text/html; charset=UTF-8" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- prefix는 마음대로 설정해도 되나 아래 c: 를 바꿔줘야함 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>


<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class = "card m-2">
		<div class = "card-header">
			JSTL을 이용해서 List 처리
		</div>
		<div class="card-body">
			<h6>[게시물 목록]</h6>
			<table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">No</th>
				      <th scope="col">Title</th>
				      <th scope="col">Content</th>
				      <th scope="col">Writer</th>
				      <th scope="col">Date</th>
				    </tr>
				 </thead>
				 <tbody>
				<c:forEach var="board" items="${boardList}"> <!-- 하나식 items에서 꺼내서 var로 넣음 for each문과 같음 -->
				    <tr>
						<th scope="row">${status.index}</th>
						<td>${board.title}</td>
						<td>${board.content}</td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/></td>
				    </tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>