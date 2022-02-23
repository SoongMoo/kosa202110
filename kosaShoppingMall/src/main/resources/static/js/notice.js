$(function () {
	$("#empEmail").keyup(function(){
		$.ajax({
			type : "post",
			url : "emailCheck",
			dataType : "text",
			data: {"empEmail":$("#empEmail").val()},
			success : function(result){
				$("#emailCk").html(result);
				if(result == "사용가능한 이메일입니다."){
					$("#emailCk").css("color","blue");
				}else{
					$("#emailCk").css("color","red");
				}
			},
			error : function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			}
		});
	});
	$("#empId").keyup(function() {
		$.ajax({
			type:"post",
			url:"empIdCheck",
			dataType:"text",
			data:{"empId" :$("#empId").val()},
			success: function (result) {
				$("#IdCk").html(result);
				if(result=="사용 가능한 아이디입니다."){
					$("#IdCk").css("color","blue");
				}else{
					$("#IdCk").css("color","red");
				}
			},error : function () {
				alert("에러에러 에러에러");
			}
		
		});
	});
});
/*
	$(function(){
		$("#frm").submit(function(){
			if($("#empPw").val() != $("#empPwCon").val()){
				alert("비밀번호 확인이 다릅니다.");
				return false;
			}
		});
	});
*/