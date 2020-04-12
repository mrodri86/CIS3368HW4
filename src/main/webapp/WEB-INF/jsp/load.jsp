<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator</title>
    <style>
        table {
            color: black;
            font-family: Helvetica, Arial, sans-serif;
            width: 640px;
            border-collapse: collapse;
            border-spacing: 0;
        }

        td, th {
            border: 1px solid black;
            height: 30px;
        }

        th{
            background: #FF3839 ;
            font-weight: bold;
            color: white;
        }

        td{
            text-align: left;
        }

        tbody tr:nth-child(even) {
            background-color: #FF1E20;
        }

        tbody tr:nth-child(odd) {
            background-color: #FF6C6E;
        }
    </style>
</head>
<body>

<h2>View Love Percentage & Result</h2>

<br/>
First Name: ${fname}
<br />
Second Name: ${sname}
<br/>
<br/>
Love Percentage: ${percentage}
<br/>
Love Result: ${result}
<br/>

<a href="/">Back</a>
<br/>
<form method="post" action="/save">
    <input type="hidden" name="id" value="">
    <input type="hidden" name="firstname" value="${fname}">
    <input type="hidden" name="secondname" value="${sname}">
    <input type="hidden" name="lovepercentage" value="${percentage}">
    <input type="hidden" name="loveresult" value="${result}">
    <input type="submit" value="Save">
</form>
<form action="/load">
    <input type="submit" value="Load">
</form>
<table>
    <tr>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Percentage</th>
        <th>Result</th>
    </tr>
    <c:forEach var = "listitem" items = "${lovelist}">
        <tr>
            <td>${listitem.getFname()}</td>
            <td>${listitem.getSname()}</td>
            <td>${listitem.getPercentage()}</td>
            <td>${listitem.getResult()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
