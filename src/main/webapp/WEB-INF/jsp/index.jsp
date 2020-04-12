<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Love Calculator API</title>
</head>
<body>

<h2>Love Calculator API</h2>

<form method="get" action="/getlovepercentage">
    First Name:<br>
    <input type="text" name="firstname">
    <br>
    Second Name:<br>
    <input type="text" name="secondname">
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
