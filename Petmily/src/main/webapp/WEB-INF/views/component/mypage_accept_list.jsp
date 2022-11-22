<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	$(document).ready(function() {

		$('button[name=complete]').on("click", function() {
			var index = $(this).parent().parent().index() / 4;
			$('#index').val(index);
			$('#acceptlist').submit(); 
		})

	})
</script>

<form action="mypage_accept_complete" name="acceptlist"
	id="acceptlist">
	<div class="container">
		<div class="row my-3">
			<h2>
				<strong>신청수락내역</strong>
				<h6>반려인이 신청을 수락한 내역</h6>
			</h2>
		</div>

		<div class="row my-2">
			<div class="col-1">
				<img src="component/becompanion.png"
					style="width: 3em; height: 3rem; margin-right: 0.6rem">
			</div>
			<div class="col-6 align-self-center" style="padding-top: 0.8rem">
				<h4>
					<strong>완료대기 총 <strong style="color: #FB9E58">
							${fn:length(acceptList) } </strong> 건
					</strong>
				</h4>
			</div>
		</div>
		<input type="hidden" name="index" id="index">
		<div class="row my-2">
			<table class="table">
				<thead align="center">
					<tr>
						<th class="col" scope="col">번호</th>
						<th class="col" scope="col">제목</th>
						<th class="col" scope="col">작성자</th>
						<th class="col" scope="col">시간</th>
						<th class="col" scope="col">장소</th>
						<th class="col" scope="col">완료</th>
					</tr>
				</thead>
				<tbody align="center">
				
					<!-- forEach로 돌리면 되고 페이징 넣어보자 id를 detail-1~5 , detail-page-1~5 -->
					<c:forEach var="list" items="${acceptList }" varStatus="status">
						<tr>
							<th scope="row">${paging.endRow - status.index }</th>
							<td><a
								href="posting_click?pid=${list.pid }&user_uid=${list.user_uid}&pcategory=${list.pcategory}">${list.ptitle }</a></td>
							<td>${list.user_uid }</td>
							<td>${list.pinitdate }</td>
							<td>${list.plocation_basic }</td>
							<td><button type="button" class="btn btn-outline-primary"
									value="complete" name="complete" data-toggle="button"
									style="margin-right: 0.8rem;">완료</button></td>
						</tr>
						
							<input type="hidden" name="posting_pid" value="${list.pid }">
							<input type="hidden" name="posting_user_uid" value="${list.user_uid }">
							<input type="hidden" name="apid" value="${apidList.get(status.index) }">
					</c:forEach>
					<!-- 한 줄 끝 -->
				</tbody>
			</table>

		</div>

		<!-- 페이징 -->
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
							<li class="page-item"><a class="page-link"
								href="posting?page=${param.page - 1}&pcategory=${param.pcategory }">Previous
							</a></li>
						</c:when>

						<c:otherwise>
							<!-- else -->
							<li class="page-item"><a class="page-link"
								href="posting?page=${paging.startPage - 1}&pcategory=${param.pcategory }">Previous
							</a></li>
						</c:otherwise>

					</c:choose>
					<!-- int = startPage; i <= endPage; i++ -->
					<c:forEach var="count" begin="${paging.startPage}"
						end="${paging.endPage}">
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
							<li class="page-item"><a class="page-link"
								href="posting?page=${paging.endPage + 1}&pcategory=${param.pcategory }">Next
							</a></li>
						</c:when>

						<c:when test="${param.page < paging.endPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link"
								href="posting?page=${param.page + 1}&pcategory=${param.pcategory }">Next
							</a></li>
						</c:when>

					</c:choose>
				</ul>
			</nav>
		</div>
	</div>
</form>
