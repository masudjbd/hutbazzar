<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Edit Page</h1>

<a href="${pageContext.request.contextPath}/users" class="btn btn-default">
    <i class="glyphicon glyphicon-hand-left"></i> Back
</a>


<form:form method="post" action="${pageContext.request.contextPath}/users/edit/${users.id}" 
           commandName="users" class="form-horizontal"  >
    <div class="form-group"> 
        <label for="usersName" class="col-sm-2 control-label">Category Name</label>
        <div class="col-sm-10">
            <form:input path="usersName" id="usersName" class="form-control"  /> 
            <form:errors path="usersName" cssClass="has-error" />

        </div>
    </div>
    <div class="form-group"> 
        <label for="usersDescription"  class="col-sm-2 control-label">Category Description</label>
        <div class="col-sm-10">
            <form:input path="usersDescription" id="usersDescription" class="form-control"  /> 
            <form:errors path="usersDescription" cssClass="has-error" />
        </div>
    </div>



    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/users" class="btn btn-default ">
        <i class="glyphicon glyphicon-hand-left"></i> Back
    </a>
</form:form>