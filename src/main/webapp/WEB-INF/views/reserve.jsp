<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>예약 목록</title>
</head>
<body>
<h1>예약 목록</h1>
<form action="reserve.jsp" method="post">
  이름: <input type="text" name="name" required><br>
  예약 인원: <input type="number" name="quantity" min="1" required><br>
  <input type="submit" value="예약하기">
</form>
</body>
</html>
