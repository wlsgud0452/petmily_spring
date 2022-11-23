<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="mypage_modify_update_complete" method="post"
		enctype="multipart/form-data">
	<div class="container">
		<div class="row justify-content-center">
			<div class="text-center gy-3" style="color: #e8853e;">
				<h1>
					<strong>개인정보수정</strong>
				</h1>
			</div>
		</div>

		<div class="row">

			<div class="col-4 align-self-center">
				<!-- 선택된 사진 보이는 곳 -->
				<div class="row jstify-content-center">
					<div class="text-center gy-1">
						<c:choose>
							<c:when test="${userInfo.uimage eq null }">
								<img src="user/profile_sample.png" width="250" height="250"
									class="rounded-circle" alt="사진 선택시 변경" id="blah">
							</c:when>

							<c:otherwise>
								<img src="user/${userInfo.uimage }" width="250" height="250"
									class="rounded-circle" alt="사진 선택시 변경" id="blah">
							</c:otherwise>

						</c:choose>

					</div>
				</div>
				
				<input type="hidden" name="uimage" value="${userInfo.uimage }">
				
				<!-- 사진 선택 버튼 -->
				<div class="row justify-content-center">
					<div class="col my-3">
						<div class="input-group">
							<label class="input-group-text" for="inputGroupFile01">사진
								선택</label> <input type="file" class="form-control" name="file"
								accept="image/*"
								onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"
								value="사진선택">
						</div>
					</div>
				</div>
			</div>

			<div class="col-8">

				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-6 mb-3 gy-5">
						<label for="exampleFormControlInput1" class="form-label">ID
						</label> <input type="text" class="form-control" name="uid"
							id="exampleFormControlInput1" placeholder="아이디를 입력해 주세요"
							value="${uid}" readonly="readonly">
					</div>
					<div class="col-2"></div>
				</div>
				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-5 mb-3 gy-2">
						<label for="exampleFormControlInput1" class="form-label">이름
						</label> <input type="text" class="form-control" name="uname"
							id="exampleFormControlInput1" placeholder="이름을 입력해 주세요"
							value="${userInfo.uname}" readonly="readonly">
					</div>
					<div class="col-3 gy-2"></div>
				</div>
				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-6 mb-3 gy-2">
						<label for="exampleFormControlInput1" class="form-label">닉네임
						</label> <input type="text" class="form-control" name="unickname"
							id="exampleFormControlInput1" placeholder="닉네임을 입력해 주세요"
							value="${userInfo.unickname}">
					</div>
					<div class="col-2 gy-2"></div>
				</div>
				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-8 mb-3 gy-2">
						<label for="exampleFormControlInput1" class="form-label">이메일
						</label> <input type="email" class="form-control" name="uemail"
							id="exampleFormControlInput1" placeholder="이메일을 입력해 주세요"
							value="${userInfo.uemail}" readonly="readonly">
					</div>

				</div>
				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-7 mb-3 gy-2">
						<label for="exampleFormControlInput1" class="form-label">휴대폰
							번호 </label> <input type="tel" class="form-control" name="uphone"
							id="exampleFormControlInput1" placeholder="번호를 입력해 주세요"
							value="${userInfo.uphone}">
					</div>
					<div class="col-1 gy-2"></div>
				</div>
				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-6 mb-3 gy-2">
						<label for="exampleFormControlInput1" class="form-label">주소
						</label> <input type="text" class="form-control" name="uaddress_basic"
							value="${userInfo.uaddress_basic}" id="exampleFormControlInput1"
							placeholder="주소를 입력해 주세요">
					</div>
					<button class="btn col-1 gy-2 align-self-center" type="button"
						style="margin-top: 1.5rem; padding-top: 0.7rem; padding-bottom: 0.7rem; background-color: #e8853e;">검색</button>
					<div class="col-1 gy-2"></div>
				</div>
				<div class="row justify-content-center ">
					<!-- text field + 제목 -->
					<div class="col-8 mb-3">
						<input type="text" class="form-control" name="uaddress_detail"
							id="exampleFormControlInput1" placeholder="상세 주소를 입력해 주세요"
							value="${userInfo.uaddress_detail}">
					</div>
				</div>
			</div>

		</div>

		<div class="row justify-content-center ">
			<input class="btn col-6 gy-5" type="submit"
				style="background-color: #e8853e;" value="수정">
		</div>

		<div class="row justify-content-center" style="height: 4rem"></div>

	</div>
</form>
