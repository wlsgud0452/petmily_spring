<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.form-control {
	color: #a3a3a3;
	box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5);
	border-color: #a3a3a3;
	border-radius: 30px;
}

.page-link {
	color: black;
}
</style>

<script>
	function changeForm() {

		var form = document.posting

		var pcategory = document.getElementById('pcategory').value

		form.action = 'posting_write?pcategory=' + pcategory

		form.submit()

	}
</script>

<div class="container">
	<form action="posting" name="posting">

		<%
			String param = request.getParameter("pcategory");
			String attribute = (String) request.getAttribute("pcategory");
			
			
			if(param == null || param.equals("")){
		%>	
				<c:set var="pcategory" value="<%=attribute %>" />
		<% 		
			}
			
			if(attribute == null || attribute.equals("")){
		%>
		
				<c:set var="pcategory" value="<%=param %>" />
		<% 		
			}
		%>
		
		<div class="row justify-content-start my-2">

			<input type="hidden" name="pcategory" id="pcategory"
				value="${pcategory }">

			<c:choose>

				<c:when test="${pcategory eq 'walk'}">
					<h3>함께 산책</h3>
				</c:when>

				<c:when test="${pcategory eq 'volunteer'}">
					<h3>함께 봉사</h3>
				</c:when>

				<c:when test="${pcategory eq 'petcafe'}">
					<h3>함께 펫카페</h3>
				</c:when>

				<c:when test="${pcategory eq 'find'}">
					<h3>찾아주세요</h3>
				</c:when>

				<c:when test="${pcategory eq 'found'}">
					<h3>찾았어요</h3>
				</c:when>

			</c:choose>
			<h3 style="color: red;">${deleteMessege }</h3>
		</div>

		<div class="row my-3">
			<div class="col-3"></div>
			<!-- 드롭다운  -->
			
				<div class="col-1">
					<select class="form-select w-100"
						aria-label="Default select example" name="option">
						<option value="ptitle" selected>제목</option>
						<option value="user_uid">작성자</option>
						<option value="plocation">장소</option>
					</select>
				</div>
				<!-- 검색  -->
				<div class="col-3">
					<input type="text" class="form-control" name="query"
						id="exampleFormControlInput1" placeholder="검색어를 입력해 주세요">
				</div>

				<!-- 검색 버튼 -->
				<div class="col-1">
					<input class="btn btn-warning " type="submit" value="검색">
				</div>
			
			<div class="col-2"></div>
				
			<div class="col-1">
				<c:choose>
					<c:when test="${user.utype eq 'companion' }">
						<button class="btn btn-warning" type="button"
							onclick="changeForm()" style="display: block">작성</button>
					</c:when>

					<c:otherwise>
						<button class="btn btn-warning" type="button"
								style="display: none">작성</button>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-1"></div>
		</div>

		<div class="row justify-content-center my-5">
			<table class="table text-center">
				<thead style="background-color: #FB9E58;">
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">시간</th>
						<th scope="col">장소</th>
					</tr>
				</thead>

				<tbody>
					<!--   -->
					<c:forEach var="list" items="${postingList}" varStatus="status">
						<tr>
							<th scope="row">${paging.endRow - status.index }</th>
							<td><a
								href="posting_click?pid=${list.pid }&user_uid=${list.user_uid}&pcategory=${list.pcategory}">${list.ptitle }</a></td>
							<td>${list.user_uid }</td>
							<td>${list.pinitdate }</td>
							<td>${list.plocation_basic }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="row justify-content-center my-2">
			<nav aria-label="Page navigation example ">
				<ul class="pagination justify-content-center">
					<c:set var="startPage" value="paging.startPage" />
					<c:choose>

						<c:when test="${param.page eq '1'}">
							<!-- if -->
							<li class="page-item disabled"><a class="page-link">Previous</a></li>
						</c:when>
						
						<c:when test="${param.page > paging.startPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link" href="posting?page=${param.page - 1}&pcategory=${param.pcategory }">Previous </a></li>
						</c:when>

						<c:otherwise>
							<!-- else -->
							<li class="page-item"><a class="page-link"
								href="posting?page=${paging.startPage - 1}&pcategory=${param.pcategory }">Previous
							</a></li>
						</c:otherwise>

					</c:choose>
					
					
					<!-- int = startPage; i <= endPage; i++ -->
					<c:forEach var="count" begin="${paging.startPage}" end="${paging.endPage}">
						<li class="page-item"><a class="page-link"
							href="posting?page=${count}&pcategory=${param.pcategory }">${count}
						</a></li>
					</c:forEach>



					<c:choose>

						<c:when test="${param.page eq paging.totalPages}">
							<!-- if -->
							<li class="page-item disabled"><a class="page-link">Next</a></li>
						</c:when>
						
						<c:when test="${param.page eq paging.endPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link" href="posting?page=${paging.endPage + 1}&pcategory=${param.pcategory }">Next </a></li>
						</c:when>
						
						<c:when test="${param.page < paging.endPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link" href="posting?page=${param.page + 1}&pcategory=${param.pcategory }">Next </a></li>
						</c:when>

					</c:choose>
				</ul>
			</nav>
		</div>
	</form>
</div>
