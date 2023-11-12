<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Initial data: a = 2.3; x: [0.2; 2.8]; delta-x: 0.002" %></h1>
<br/>
<h2><%= "Enter your x here: "%></h2>
<form action="hello-servlet" method="post">
  <input type="number" name="x" min="0.2" max="2.8" step="0.002">
  <input type="submit" value="get y">
</form>
</body>
</html>