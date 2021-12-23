<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	int y;
	public void test(){
		System.out.print("테스트");
	}
	public double calculator(double num1, double num2, String operator){
		double result = 0.0;
		if(operator.equals("+")) result = num1 + num2;
		else if(operator.equals("-")) result = num1 - num2;
		else if(operator.equals("*")) result = num1 * num2;
		else if(operator.equals("/")) result = num1 / num2;
		return  result;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 100까지의 합 구하기</title>
<script>
	var sum = 0;
	for (var i = 1; i <= 100 ; i++){
		sum += i;
	}
	document.write("1 ~ 100까지의 합은 " + sum + "<br />");
</script>
</head>
<body>
10 + 5 = <%= calculator(10, 5, "+") %><br />
10 - 5 = <%= calculator(10, 5, "-") %><br />
10 * 5 = <%= calculator(10, 5, "*") %><br />
10 / 5 = <%= calculator(10, 5, "/") %><br />
<%
	int sum = 0;
	for(int i = 1; i <= 100 ; i++){
		sum += i;
	}
%>
<%= "1 ~ 100까지의 합은 " + sum + "<br />" %>


<%  sum = 0; %>
<%	for(int i = 1; i <= 100 ; i++){ %>
<%		sum += i; %>
<% } %>
<%= "1 ~ 100까지의 합은 " + sum + "<br />" %>
</body>
</html>