<!DOCTYPE html>
<html>
<head>
    <title>Hello FreeMarker</title>
</head>
<body>
<h1>Hello, ${user.name}!</h1>
<p>年龄：${user.age}</p>
<p>爱好：</p>
<ul>
    <#list user.hobbies as hobby>
        <li>${hobby}</li>
    </#list>
</ul>
</body>
</html>