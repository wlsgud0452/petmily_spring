<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#content {
	width: 30rem;
	height: 7rem;
	box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5);
	border-radius: 15px;
}

.bi-star, .bi-star-fill, .bi-star-half {
	font-size: 1.3rem;
	color: #FFE900;
}
</style>

<script>
	$(document).ready(function() {
		
		
		$('#detail-1').click(function() {
			if ($('#detail-page-1').css("display") == "none") {
				$('#detail-page-1').show();
			} else {
				$('#detail-page-1').hide();
			}
		})

		$('#detail-2').click(function() {
			if ($('#detail-page-2').css("display") == "none") {
				$('#detail-page-2').show();
			} else {
				$('#detail-page-2').hide();
			}
		})

		$('#detail-3').click(function() {
			if ($('#detail-page-3').css("display") == "none") {
				$('#detail-page-3').show();
			} else {
				$('#detail-page-3').hide();
			}
		})

		$('#detail-4').click(function() {
			if ($('#detail-page-4').css("display") == "none") {
				$('#detail-page-4').show();
			} else {
				$('#detail-page-4').hide();
			}
		})

		$('#detail-5').click(function() {
			if ($('#detail-page-5').css("display") == "none") {
				$('#detail-page-5').show();
			} else {
				$('#detail-page-5').hide();
			}
		})

		$('button[name=func1]').on("click", function() {
			var index = $(this).parent().parent().index() / 3;
			$('#index').val(index);
			$('#applylist').submit();
		})

		$('button[name=func2]').on("click", function() {
			var index = $(this).parent().parent().index() / 3;
			$('#index').val(index);
			$("#applylist").attr("action", "apply_delete");
			$('#applylist').submit();
		})

	})
	
</script>
<div class="container">
	<form action="mypage_participate_list" name="posting">


		<div class="row justify-content-start my-5">

		</div>

		<div class="row justify-content-center my-5">
			<table class="table text-center">
				<thead style="background-color: #FB9E58;">
					<tr>
						<th scope="col">번호</th>
						<th scope="col">게시판 번호</th>
						<th scope="col">작성자</th>
						<th scope="col">후기 내용</th>
						<th scope="col">후기 평점</th>
					</tr>
				</thead>

				<tbody>
					<!--   -->
					<c:forEach var="list" items="${reviewList}" varStatus="status">
						<tr>
							<th scope="row">${paging.endRow - status.index}</th>
							<td>${list.posting_pid }
							<div class="my-4" id="detail-page-${status.count}"
									style="display: none">
									<div id="content">
										<div class="container">

											<div class="row">
												<!-- 신청 시 보낸 메시지 내용 -->
												<p>리뷰 내용</p>
												<p>작성자 : ${list.from_uid }</p>
												<p>${list.revtext }</p>
											</div>
										</div>
									</div>
								</div> <!-- 상세보기 끝 --></td>
							<td>${list.from_uid }</td>
							<td><button type="button" class="btn btn-outline-dark"
									id="detail-${status.count }" data-toggle="button">
									<i class="bi bi-caret-down"></i>
								</button></td>
							<td>${list.revrating /2 } </td>
						</tr>
					</c:forEach>
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
								href="mypage_participate_list?page=${param.page - 1}">Previous
							</a></li>
						</c:when>

						<c:otherwise>
							<!-- else -->
							<li class="page-item"><a class="page-link"
								href="mypage_participate_list?page=${paging.startPage - 1}">Previous
							</a></li>
						</c:otherwise>

					</c:choose>
					<!-- int = startPage; i <= endPage; i++ -->
					<c:forEach var="count" begin="${paging.startPage}"
						end="${paging.endPage}">
						<li class="page-item"><a class="page-link"
							href="mypage_participate_list?page=${count}">${count}
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
								href="mypage_participate_list?page=${paging.endPage + 1}">Next
							</a></li>
						</c:when>

						<c:when test="${param.page < paging.endPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link"
								href="mypage_participate_list?page=${param.page + 1}">Next
							</a></li>
						</c:when>

					</c:choose>
				</ul>
			</nav>
		</div>
	</form>
</div>
