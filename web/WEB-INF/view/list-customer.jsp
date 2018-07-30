<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 28.07.18
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>


    <link type="text/css"
          rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">

    <div id="content">

        <%--Add new button:Add customer--%>
        <input type="button" value="Add user" onclick="window.location.href='showFormForAdd';return false;";
               class="add-button"

        />

        <%--Add our html table--%>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
        <%--Loop over and print our customers--%>
            <c:forEach var="tempCustomer" items="${customers}">

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                </tr>

            </c:forEach>
        </table>
    </div>
    </div>


</body>
</html>
