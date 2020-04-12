<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator</title>

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


</body>
</html>
