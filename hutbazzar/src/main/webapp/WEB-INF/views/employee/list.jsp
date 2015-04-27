<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Employee List Page</h1>
<section class="container">
    <div class="row">
        <c:if test="${!empty message}">
            <div class="alert alert-success" role="alert">${message}</div>
        </c:if>      
        <a href="${pageContext.request.contextPath}/employee/add" class="btn btn-primary">
            <i class="glyphicon glyphicon-plus-sign"></i> Add Employee
        </a>
        <table class="table table-striped" >
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.employeeName}</td>
                    <td>${employee.employeeEmail}</td>
                    <td>${employee.employeeMobile}</td>
                    <td>
                        <div class="btn-group">
                            <a href="${pageContext.request.contextPath}/employee/details/${employee.id}" 
                               class="btn btn-primary"><i 
                                    class="glyphicon glyphicon-eye-open"></i> Details </a>
                            <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}" 
                               class="btn btn-primary"><i 
                                    class="glyphicon glyphicon-edit"></i> Edit </a>
                            <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}" 
                               class="btn btn-danger"><i 
                                    class="glyphicon glyphicon-edit"></i> Delete </a>                                    
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
