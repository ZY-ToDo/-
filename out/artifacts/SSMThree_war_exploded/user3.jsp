<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.codecoord.com" %>

<html>
<head>
    <title>用户页面</title>
</head>
<script src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    function search() {
        $.ajax({
            url:"${pageContext.request.contextPath}/byJson.action",
            type:"GET",
            success:function(data){
                $.each(data,function (index,users) {
                    var id = users.id;
                    var username = users.username;
                    var age = users.age;
                });
            }
        });
    }

</script>
<body>
    <div>
    <form>
        <div><h1>你好，你要查询吗</h1></div>
        <div><input type="button" value="查询" onclick="search()"/></div>
    </form>
    </div>
    <div id="users">

    </div>



</body>
</html>
