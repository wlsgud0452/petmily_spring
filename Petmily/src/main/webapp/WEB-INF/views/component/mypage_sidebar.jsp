<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<ul class="nav flex-column">
	
	  <li class="nav-item my-2"> 
	    <a class="nav-link" href="mypage_modify_login" style="color:black;"><p class="h5">개인정보 수정</p></a>
	  </li>
	  
	  <li class="nav-item my-2">
	   <a class="nav-link" href="mypage_challenge" style="color:black;"><p class="h5">도전과제 목록</p></a>
	  </li>
	  
	</ul>
	
	<hr>
		  
	<!-- 반려인만 -->
	<ul class="nav flex-column">
	 	<c:if test="${user.utype eq 'companion' }">
			<li class="nav-item my-2">
			 <p class="h5"><a class="nav-link" href="mypage_apply_list" style="color:black;">신청 내역</a></p>
			</li>
		</c:if>
		
		<c:if test="${user.utype eq 'companion' }">
			<li class="nav-item my-2">
			 <p class="h5"><a class="nav-link" href="mypage_accepted_list" style="color:black;">신청 수락한 내역</a></p>
			</li>
		</c:if>
		
		<li class="nav-item my-2">
		 <p class="h5"><a class="nav-link" href="mypage_accept_list" style="color:black;">신청 수락된 내역</a></p>
		</li>

	</ul>
	 
	<hr>
	 
	<ul class="nav flex-column">
	 
		<li class="nav-item my-2">
			<a class="nav-link" href="mypage_participate_list" style="color:black;"><p class="h5">완료 내역</p></a>
		</li>
		
		<li class="nav-item my-2">
			<a class="nav-link" href="mypage_write_list?&pcategory=volunteer" style="color:black;"><p class="h5">작성 내역</p></a>
		</li>
		  
	</ul>

