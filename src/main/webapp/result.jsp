<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <jsp:useBean id="calc" class="com.example.tddservtask.beans.Calculator" scope="request"/>
    <h1>y = ${calc.y}</h1>
</body>
</html>
