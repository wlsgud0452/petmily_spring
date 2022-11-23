<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img src="component/gold_foot.png"
				width="24" height="24">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between"
				id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item">${user.uid }님 환영합니다!</li>
					<c:choose>
						<c:when test="${rate eq null }">
							<li class="nav-item mx-5">당신의 평점은  2.5점 입니다.</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item mx-5">당신의 평점은  ${rate / 2}점 입니다.</li>
						</c:otherwise>
					</c:choose>
					 
				</ul>
			</div>
		</div>
	</nav>
