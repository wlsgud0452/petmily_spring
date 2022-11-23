<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.form-label {
	font-weight: bold;
}

.form-control {
	color: #a3a3a3;
	padding-top: 0.85rem;
	padding-bottom: 0.85rem;
	box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5);
	border-color: #a3a3a3;
	border-radius: 15px;
	height: 3.3rem;
}
</style>

<script>
	$(document).ready(function() {
		$('#email_check').click(function(){
			
			alert('이메일과 일치하는 아이디가 있는지 확인 중입니다.이메일 전송 완료 알람이 뜰 떄까지 기다려주세요.');
			$.ajax({
	              url:'id_email',
	              type:'post',
	              data:{
	            	  	uemail : $('#uemail').val(), 
	            	  	uname : $('#uname').val()
	              },
	              success:function(response)
	              {
	            	  if(response == '입력하신 이름과 이메일로 일치하는 아이디가 없습니다.'){
	            		  alert(response);
	            	  }else{
	            		  $('#certifynum').attr('value',response);
	            		  alert('이메일 전송이 완료되었습니다.');
	            	  }
	            	  
	              }
	           });
		})
		
		$('#searchIdBtn').click(function(){
			if($('#uname').val().trim() == ""){
				alert("이름을 입력해주세요");
				focus($('#uname'));
				return;
			}
			
			if($('#uemail').val().trim() == ""){
				alert("이메일을 입력해주세요");
				focus($('#uemail'));
				return;
			}
			
			// 이메일 인증번호가 일치하는지 확인
			var insert_num = $('#uemail_certifynum').val(); 
			var answer = $('#certifynum').val();
			if(insert_num != answer || answer.length == 0){
				alert("인증번호가 틀렸습니다. 다시 확인해 주세요.");
				focus($('#ucertify_num'));
				return;
			}
			
			alert('이메일로 아이디 목록을 보냈습니다. 확인 해주세요.');
			document.searchId.submit();	
		})
	})
</script>

<div class="container">
	<div class="row justify-content-center text-center">

		<div class="col-4">

			<h3>아이디 찾기</h3>
		</div>
	</div>

	<div class="row justify-content-center text-center">

		<div class="col-4">
			<h6 style="color: #a3a3a3;">회원정보에 입력한 정보를 작성해 주세요</h6>
		</div>
	</div>
	<form action="search_id_click" name="searchId">
		<div class="row justify-content-center ">
			<div class="col-4 mb-3 gy-2">
				<label for="exampleFormControlInput1" class="form-label">이름
				</label> <input type="text" class="form-control" name="uname"
					id="uname" placeholder="이름을 입력해 주세요">
			</div>
		</div>

		<div class="row justify-content-center ">
			<div class="col-3 mb-3 gy-2">
				<label for="exampleFormControlInput1" class="form-label">이메일
				</label> <input type="email" class="form-control" name="uemail"
					id="uemail" placeholder="이메일을 입력해 주세요">
			</div>
			<!-- 이메일 인증 버튼 -->
			<button class="btn btn-warning col-1 gy-2 align-self-center"
				type="button" id="email_check"
				style="margin-top: 1.5rem; padding-top: 0.7rem; padding-bottom: 0.7rem;">인증</button>
		</div>

		<!-- 이메일 인증번호  -->
		<div class="row justify-content-center ">
			<div class="col-4 mb-3 gy-2">
				<label for="exampleFormControlInput1" class="form-label">이메일
					인증번호 </label> <input type="text" class="form-control" name="uemail_certifynum"
					id="uemail_certifynum" placeholder="인증번호를 입력해 주세요">
			</div>
		</div>
		
		<input type="hidden" name="certifynum" id="certifynum">

		<div class="row justify-content-center my-3">
			<div class="d-grid gap-2 col-4 mx-auto">
				<button class="btn btn-primary" type="button"
					name="searchIdBtn" id="searchIdBtn"
					style="background-color: #e8853e; padding-top: 0.9rem; padding-bottom: 0.9rem; 
					box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5); border-color: #a3a3a3">
					ID 찾기</button>
			</div>
		</div>
	</form>



</div>
