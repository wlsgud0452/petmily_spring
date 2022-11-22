<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

var cnt = 1;
$(document).ready(function(){
	$("#apply").click(function() {
		
		if (cnt % 2 == 1) {
			$('#apply_form').show()
		}

		if (cnt % 2 == 0) {
			$('#apply_form').hide()
		}
		
		cnt += 1;
	})
	
	$('#apply_button').click(function(){
		$('#posting_apply_insert').submit();
	})
})


</script>
<div class="container">
	<div class="row justify-content-center my-4 text-center">
		<h4>${postingDetail.ptitle}</h4>

	</div>

	<div class="row justify-content-between my-2">
		<div class="col-4 text-start align-self-center">
			<c:choose>

				<c:when test="${postingUimage eq null }">
					<img src="user/profile_sample.png" height="60" width="60"
						class="rounded-circle" alt="">
				</c:when>

				<c:otherwise>
					<img src="user/${postingUimage }" height="40" width="40"
						class="rounded-circle" alt="">
				</c:otherwise>

			</c:choose>
			<span class="mx-2"> ${postingUid}</span>
		</div>

		<%
		String user_uid_temp_one = request.getParameter("user_uid");
		
		String user_uid_temp_two = (String) request.getAttribute("postingUid");
		
		String user_uid = null;
		
		if(!(user_uid_temp_one == null)){
			user_uid = user_uid_temp_one;
		}else{
			user_uid = user_uid_temp_two;
		}
		
		%>
		<c:set var="postAuthor" value="<%=user_uid%>" />


		<div class="col-2 text-end align-self-center">조회수 :
			${postingView}</div>
		<!-- pid , user_uid , aptitle , apcontent -->
		<form action="posting_apply_insert" name="posting_apply_insert"
			id="posting_apply_insert" method="post">
			<div class="row justify-content-between my-2">
				<div class="text-end">
					<input type="hidden" name="user_uid" value="${postingUid }">
					<input type="hidden" name="pid" value="${pid}"> <input
						type="hidden" name="pcategory" value="${postingDetail.pcategory}">
						
					<c:choose>
					
						<c:when test="${user_uid eq postAuthor}">
							<button class="btn btn-primary col-1 gy-2 align-self-center"
								type="button"
								onclick="location.href='posting_modify?pid=${pid}&pcategory=${postingDetail.pcategory}'"
								style="margin-top: 1.5rem; padding-top: 0.7rem; padding-bottom: 0.7rem;">수정하기</button>

							<button class="btn btn-danger col-1 gy-2 align-self-center"
								type="button"
								onclick="location.href='posting_delete?pid=${pid}&pcategory=${postingDetail.pcategory}'"
								style="margin-top: 1.5rem; padding-top: 0.7rem; padding-bottom: 0.7rem;">삭제하기</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-warning col-1 gy-2 align-self-center"
								type="button" onclick="#" name="apply" id="apply"
								style="margin-top: 1.5rem; padding-top: 0.7rem; padding-bottom: 0.7rem;">신청하기</button>
						</c:otherwise>

					</c:choose>
					
				</div>
			</div>


			<div class="row justify-content-center my-2" id="apply_form"
				style="display: none">
				<div class="col-10">
					<label for="title" class="form-label">신청 제목</label> <input
						type="text" class="form-control my-2" name="aptitle" id="aptitle"
						placeholder="신청제목을 입력해 주세요."> <label for="title"
						class="form-label">신청 내용</label>
					<textarea class="form-control" id="apcontent" name="apcontent"
						placeholder="신청내용을 작성해 주세요" rows="5"></textarea>

					<button class="btn btn-warning col-1 my-2 align-self-center"
						type="button" id="apply_button">신청</button>
				</div>
			</div>
		</form>
	</div>
	<div>${applyStatus}</div>
	<hr>

	<div class="row justify-content-between">
		<div class="col-4 text-start">
			<i class="bi bi-geo-alt" style="font-size: 1.7rem;"></i> <span
				class="mx-2">${postingDetail.plocation_basic}
				${postingDetail.plocation_detail}</span>
		</div>


		<div class="col-2 text-end align-self-center">${postingDetail.pinitdate}</div>
	</div>

	<!-- img -->
		<div class="row justify-content-center text-center my-5">
			<div class="col-8">
				<c:if test="${postingDetail.pimage1 ne null}">
					<img src="posting/${postingDetail.pimage1}" class="rounded my-1"
					alt="" style="width: 500px;"> 
				</c:if>
				<c:if test="${postingDetail.pimage2 ne null}">
					<img src="posting/${postingDetail.pimage2}" class="rounded my-1"
					alt="" style="width: 500px;"> 
				</c:if>
				<c:if test="${postingDetail.pimage3 ne null}">
					<img src="posting/${postingDetail.pimage3}" class="rounded my-1"
					alt="" style="width: 500px;"> 
				</c:if>
				
			</div>
		</div>
	<!-- 게시글 내용 -->
	<div class="row justify-content-center my-3">
		<div class="col-8 text-right">${postingDetail.pcontent}</div>

	</div>

	<hr>

	<div class="row my-2">
		<div class="col-4 text-start">

			<c:if test="${likeCheck eq '1'}">
				<!-- 좋아요를 누른 경우 -->
				<button type="button" class="btn btn-outline-danger active"
					data-bs-toggle="button" aria-pressed="true"
					onclick="location.href='posting_like_click?likeCheck=${likeCheck}&pid=${pid}'">
					<i class="bi bi-heart" style="font-size: 1.5rem;"></i>
				</button>
			</c:if>

			<c:if test="${likeCheck eq '0'}">
				<button type="button" class="btn btn-outline-danger"
					data-bs-toggle="button" aria-pressed="false"
					onclick="location.href='posting_like_click?likeCheck=${likeCheck}&pid=${pid}'">
					<i class="bi bi-heart" style="font-size: 1.5rem;"></i>
				</button>
			</c:if>
			<!-- arial-pressed 가 true이면 좋아요 1 추가 된다 이느낌인듯 -->
			<strong>좋아요 ${postingLike} 개</strong>

		</div>
	</div>

	<!-- 댓글 -->
	<!-- parent id가 pid인 걸 가져와서 댓글 쓴 사람의 아이디를 가지고 이미지를 불러오고 -->
	<!-- 그거의 댓글과 날짜를 보여주면 된다. -->
	<c:forEach var="comment" items="${commentList }" varStatus="status">
		<div class="row justify-content-center my-3">
			<div class="col-1 align-self-center">
				<c:choose>
					<c:when test="${commentImageList.get(status.index) eq null }">
						<img src="user/profile_sample.png" height="40" width="40"
							class="rounded-circle" alt="">
					</c:when>

					<c:otherwise>
						<img src="user/${commentImageList.get(status.index) }" height="40"
							width="40" class="rounded-circle" alt="">
					</c:otherwise>

				</c:choose>
			</div>
			<div class="col-2 text-start align-self-center">
				<span class="mx-2"> ${comment.user_uid}</span>
			</div>
			<div class="col-4 text-start align-self-center">
				<span>${comment.pcontent }</span>
			</div>
			<div class="col-2 text-end align-self-center">
				<h6>${comment.pinitdate }</h6>
			</div>
		</div>
	</c:forEach>

	<form action="posting_reply_insert" method="post" id="reply">
		<div class="row justify-content-center my-5">
			<div class="col-6">
				<input type="text" class="form-control" name="ureply"
					id="exampleFormControlInput1" placeholder="댓글을 입력해 주세요">
			</div>
			<input type="hidden" name="pid" value="${pid}">
			<div class="col-1">
				<input type="submit" class="btn btn-warning" value="입력">
			</div>
		</div>
	</form>

</div>

