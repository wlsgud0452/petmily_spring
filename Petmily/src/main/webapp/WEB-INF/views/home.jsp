<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Petmily</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<jsp:include page="component/header.jsp"></jsp:include>
		</div>
		
		<div style="padding-top: 2rem"></div>

		<div class="row justify-content-center">
			<div class="col-11">
				<jsp:include page="component/home_slide_1.jsp"></jsp:include>
			</div>
		</div>
		
		
		<div style="padding-top: 5rem"></div>
		
		<div class="row justify-content-center text-center">
			<h2 class="mb-3" style ="color: #e8853e;">당신은 가족을 버리나요? 반려동물도 가족입니다.</h2>
		</div>
		
		<div style="padding-top: 1rem"></div>
		
		<div class="row justify-content-center text-end">
			<div class="col-11">
				<h6 class="mb-3">서울 열린데이터 광장 서울시 유기동물보호 현황 통계 참고</h6>			
			</div>
		</div>
		<div class="row justify-content-center text-end">
			<div class="col-11">
				<h6 class="mb-3">https://data.seoul.go.kr/dataList/369/S/2/datasetView.do</h6>			
			</div>
		</div>
		
		<div class="row justify-content-center">
			<div class="col-11">
				<jsp:include page="component/home_slide_2.jsp"></jsp:include>
			</div>
		</div>

		<div style="padding-top: 2rem"></div>

		<div class="row">
			<jsp:include page="component/footer.jsp"></jsp:include>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>