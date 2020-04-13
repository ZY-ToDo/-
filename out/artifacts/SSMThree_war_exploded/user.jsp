<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://www.codecoord.com" %>

<html>
<head>
    <title>用户页面</title>
</head>
<script src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript">

    function test(data) {

        var id = data.type;
        // alert(id);
        window.location.href = "delete.action?id="+id;
    }
</script>
<body>
    <h1>用户信息</h1>
    <table width="800" border="1">
        <tr>
            <td>id</td><td>用户名</td><td>年龄</td><td>操作</td>
        </tr>
        <c:forEach items="${userlist}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.age}</td>

                <td><a href="#" id="delete" type="${user.id}" onclick="test(this)">删除</a></td>

            </tr>
        </c:forEach>
    </table>

</body>
</html>
