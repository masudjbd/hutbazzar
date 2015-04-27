<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Details Page</h1>

<a href="${pageContext.request.contextPath}/category" class="btn btn-default">
    <i class="glyphicon glyphicon-hand-left"></i> Back
</a>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Name </th>
            <th>Description </th>
         </tr>
    </thead>
    <tbody>
        <tr>
            <td>${category.categoryName}</td>
            <td>${category.categoryDescription}</td>
         </tr>
    </tbody>

</table>
