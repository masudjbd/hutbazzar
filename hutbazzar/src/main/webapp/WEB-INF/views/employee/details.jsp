<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Details Page</h1>

<a href="${pageContext.request.contextPath}/employee" class="btn btn-default">
    <i class="glyphicon glyphicon-hand-left"></i> Back
</a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Property </th>
            <th>Email </th>
            <th>Mobile </th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeEmail}</td>
            <td>${employee.employeeMobile}</td>
        </tr>
    </tbody>

</table>
