<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
#content {
	width: 30rem;
	height: 14rem;
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
			var index = $(this).parent().parent().index() / 4;
			$('#index').val(index);
			$('#acceptedlist').submit();
		})


	})
	
</script>



<form action="mypage_accepted_complete" name="acceptedlist" id="acceptedlist">
	<input type="hidden" name="message" id="message" value="${alert }">
	<div class="container">
		<div class="row my-3">
			<h2>
				<strong>신청 수락된 내역</strong>
				<h6>내가 신청 수락 해준 내역</h6>
			</h2>
		</div>

		<div class="row my-2">
			<div class="col-1">
				<img src="component/companion.png"
					style="width: 3em; height: 3rem; margin-right: 0.6rem">
			</div>
			<div class="col-6 align-self-center" style="padding-top: 0.8rem">
				<h4>
					<strong>완료대기 총 <strong style="color: #FB9E58">
							${fn:length(acceptedList) } </strong> 건
					</strong>
				</h4>
			</div>
		</div>
		<input type="hidden" name="index" id="index">
		<div class="row my-2">
			<table class="table">
				<thead align="center">
					<tr>
						<th class="col-2" scope="col">제목</th>
						<th class="col-3" scope="col">내용</th>
						<th class="col-2" scope="col">작성자</th>
						<th class="col-2" scope="col">상세보기</th>
						<th class="col-2" scope="col">확인</th>
					</tr>
				</thead>
				<tbody align="center">
					<!-- forEach로 돌리면 되고 페이징 넣어보자 id를 detail-1~5 , detail-page-1~5 -->
					<c:forEach var="accepted" items="${acceptedList }" varStatus="status">
						<c:set var="apcontent" value="${accepted.apcontent }"/>
						<c:set var="aptitle" value="${accepted.aptitle }"/> 
						<tr>
							<th style="text-align: center;" scope="row"><a
								href="posting_click?pid=${accepted.posting_pid }">${fn:substring(aptitle,0,10)}</a></th>
							<td>${fn:substring(apcontent,0,10)}<!-- 상세보기 띄는 곳 -->
								<div class="my-4" id="detail-page-${status.count}"
									style="display: none">

									<div id="content">
										<div class="container">

											<div class="row">
												<div class="col-5 gy-3" align="center">
													<!-- 프로필 이미지 넣는 곳  -->
													<img src="user/${acceptedUserInfoList.get(status.index).uimage}"
														class="rounded-circle" alt="..." style="width: 150px; height: 150px;"> <br>
			
													<div align="center">
														<!-- rate의 value에 유저의 별점이 들어오면 된다.  -->
														<c:set var="full" value="${userRating / 2 }" />
														<c:set var="half" value="${userRating % 2 }" />
														<c:set var="emp" value="${5 - full }" />

														<c:choose>
															<c:when test="${full >= 1}">
																<c:forEach var="full" begin="1" end="${full }">
																	<i class="bi bi-star-fill"></i>
																</c:forEach>
															</c:when>
														</c:choose>

														<c:choose>
															<c:when test="${half == 1}">
																<i class="bi bi-star-half"></i>
															</c:when>
														</c:choose>

														<c:choose>
															<c:when test="${emp >= 1}">
																<c:forEach var="full" begin="1" end="${emp }">
																	<i class="bi bi-star"></i>
																</c:forEach>
															</c:when>
														</c:choose>
													</div>
												</div>

												<div class="col-7 gy-3">
													<!-- 작성자명  -->
													<h5 style="color: #FB9E58;">
														<strong>${acceptedUserInfoList.get(status.index).uname }</strong>
													</h5>
													<!-- 신청 보낸 날짜  -->
													<p>${accepted.apdate }</p>
													<!-- 신청 시 보낸 메시지 내용 -->
													<p>${accepted.apcontent }</p>
												</div>
											</div>
										</div>
									</div>
								</div> <!-- 상세보기 끝 -->
							</td>
							<td>${accepted.user_uid}</td>
							<td style="text-align: center;">
								<!-- 상세보기 버튼 -->
								<button type="button" class="btn btn-outline-dark"
									id="detail-${status.count }" data-toggle="button">
									<i class="bi bi-caret-down"></i>
								</button>
							</td>
							<td style="text-align: center;">
								<button type="button" class="btn btn-outline-primary"
									value="accept" name="func1" data-toggle="button"
									style="margin-right: 0.8rem;">완료</button>
							</td>

						</tr>
						<input type="hidden" name="apid" value="${accepted.apid }">
						<input type="hidden" name="posting_pid"
							value="${accepted.posting_pid }">
						<input type="hidden" name="user_uid" value="${accepted.user_uid }">
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
							<li class="page-item"><a class="page-link" href="mypage_accepted_list?page=${param.page - 1}">Previous </a></li>
						</c:when>

						<c:otherwise>
							<!-- else -->
							<li class="page-item"><a class="page-link"
								href="mypage_accepted_list?page=${paging.startPage - 1}">Previous
							</a></li>
						</c:otherwise>

					</c:choose>
					<!-- int = startPage; i <= endPage; i++ -->
					<c:forEach var="count" begin="${paging.startPage}" end="${paging.endPage}">
						<li class="page-item"><a class="page-link"
							href="mypage_accepted_list?page=${count}">${count}
						</a></li>
					</c:forEach>

					<c:choose>

						<c:when test="${param.page eq paging.totalPages}">
							<!-- if -->
							<li class="page-item disabled"><a class="page-link">Next</a></li>
						</c:when>
						
						<c:when test="${param.page eq paging.endPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link" href="mypage_accepted_list?page=${paging.endPage + 1}">Next </a></li>
						</c:when>
						
						<c:when test="${param.page < paging.endPage}">
							<!-- if -->
							<li class="page-item"><a class="page-link" href="mypage_accepted_list?page=${param.page + 1}">Next </a></li>
						</c:when>

					</c:choose>
				</ul>
			</nav>
		</div>
	</div>
</form>
