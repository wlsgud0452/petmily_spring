<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container my-5 text-center">
		<div class="row justify-content-center my-5">
			<div class="col-e ">

				<h2 style="color: #e8853e">
					<strong>회원가입</strong>
				</h2>

			</div>
		</div>
		<div class="row justify-content-center my-3">
			<div class="d-grid gap-2 col-4 mx-auto">
				<button class="btn btn-outline-secondary" type="button" onClick="location.href='signup_form'"
					style="color: #A3A3A3; padding-top: 0.9rem; padding-bottom: 0.9rem; box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5); border-color: #a3a3a3">ID
					, PW로 가입하기</button>
			</div>
		</div>
		<div class="row justify-content-center my-3">
			<div class="d-grid gap-2 col-4 mx-auto">
				<a
					href="https://kauth.kakao.com/oauth/authorize?client_id=c0adedd90ef6ae1146e57b65fcf48e85&redirect_uri=	
								http://localhost:8080/sign_up_kakao&response_type=code">
					<button class="btn btn-warning" type="button"
						style="color: #A39A42; font-padding: 1 rem; width: 100%; padding-top: 0.75rem; padding-bottom: 0.75rem; box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5); background-color: #FFE700; border-color: #FFE700">
						<img src="component/kakaotalk.png"
							style="width: 1.8rem; height: 1.8rem; margin-right: 0.6rem">카카오로
						가입하기
					</button>
				</a>
			</div>
		</div>
	</div>




