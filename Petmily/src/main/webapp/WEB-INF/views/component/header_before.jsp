<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg shadow-sm">
	<div class="container-fluid">
		<a class="navbar-brand" href="home"><img
			src="component/logo.png" width="45" height="40"
			style="margin-right: 1rem;"> PETMILY</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse " id="navbarNavDropdown">
			<ul class="navbar-nav mx-auto">

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home"> HOME </a></li>

				<li class="nav-item"><a class="nav-link mx-2"
					href="pet_dictionary_card?pstype=dog">펫과사전</a></li>
				<li class="nav-item"><a class="nav-link mx-2" href="error">도전</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mx-2"
					href="posting?pcategory=volunteer" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> 함께 </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item"
							href="posting?pcategory=volunteer&page=1">함께 봉사</a></li>
						<li><a class="dropdown-item" href="posting?pcategory=walk&page=1">함께
								산책</a></li>
						<li><a class="dropdown-item"
							href="posting?pcategory=petcafe&page=1">함께 펫카페</a></li>
					</ul></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mx-2"
					href="posting?pcategory=find" role="button"
					data-bs-toggle="dropdown" aria-expanded="false">구조 </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="posting?pcategory=find&page=1">찾아주세요</a></li>
						<li><a class="dropdown-item"
							href="posting?pcategory=found&page=1">찾았어요</a></li>
					</ul></li>
			</ul>

			<ul class="navbar-nav justify-content-end">

				<li class="nav-item"><a class="nav-link mx-2"
					href="signup_page">회원가입</a></li>

				<li class="nav-item"><a class="nav-link mx-2"
					href="login_page">로그인</a></li>

			</ul>
		</div>
	</div>
</nav>
