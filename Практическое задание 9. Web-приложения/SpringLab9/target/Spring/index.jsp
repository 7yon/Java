<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Decode/Encode string</title>
</head>
<body>
<form action="/req" method="post">
    <p>
    <div>Enter the string here:</div>
    <input type="text" name="string" value=""/>
    </p>

    <p><input name="nameOperation" type="radio" value='encode' checked/> Encode</p>
    <p><input name="nameOperation" type="radio" value='decode' /> Decode</p>
    <p><input type = submit value="Start"/></p>
</form>
</body>
</html>