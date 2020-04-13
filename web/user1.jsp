<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.codecoord.com" %>

<html>
<head>
    <title>用户页面</title>
</head>
<script src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#a_tz").click(function () {
            var gotoPage = $("#gotoPage").val()*1;
            alert(gotoPage)
            fy(gotoPage);
        });
    });

    function test(data) {

        var id = data.type;
        alert(id);
        window.location.href = "delete.action?id="+id;
    }
    function fy(data) {
        var gotoPageNo = data.type;

        window.location.href = "byPage.action?currentPage="+gotoPageNo;

    }
    function tz() {
        var a = document.getElementById("gotoPage").value;
        if(a>${pageBean.totalPage} || a<=0){
            alert("你输入的页码有误");
        }else {
            fy(a);
        }
    }
</script>
<body>

    <h1>用户信息</h1>
    <table width="800" border="1" >
        <tr>
            <td>id</td><td>用户名</td><td>年龄</td><td>操作</td>
        </tr>
        <c:forEach items="${pageBean.userList}" var="pageBean">
            <tr>
               <td>${pageBean.id}</td>
                <td>${pageBean.username}</td>
                <td>${pageBean.age}</td>
                <td><a href="#" id="delete" type="${pageBean.id}" onclick="test(this)">删除</a></td>

            </tr>
        </c:forEach>

    </table>
    <div style="height: 10px"></div>
    <div>
        现在是第${currentPage}/${pageBean.totalPage}页 &nbsp;&nbsp;
        <c:if test="${currentPage==1}">首页&nbsp;&nbsp;上一页</c:if>
        <c:if test="${currentPage>1}">
            <a href="#" onclick="fy(this)" type="1">首页</a>
            <a href="#" onclick="fy(this)" type="${currentPage-1}">上一页</a>
        </c:if>
        <c:if test="${currentPage<pageBean.totalPage}">
            <a href="#" onclick="fy(this)" type="${currentPage+1}">下一页</a>
            <a href="#" onclick="fy(this)" type="${pageBean.totalPage}">尾页</a>
        </c:if>
        <c:if test="${currentPage==pageBean.totalPage}">尾页&nbsp;&nbsp;下一页</c:if>&nbsp;&nbsp;
        跳转至<input type="text" style="height: 22px;width: 30px" id="gotoPage" name="gotoPage" >页
        <a href="#" id="a_tz">跳转</a>



    </div>


</body>
</html>
