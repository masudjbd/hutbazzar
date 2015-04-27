<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Add Page</h1>



<form:form method="post" action="${pageContext.request.contextPath}/employee/add" 
           commandName="employee" class="form-horizontal"  >
    <form:errors path="*" cssClass="has-error" />
    <div class="form-group"> 
        <label for="employeeName" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <form:input path="employeeName" id="employeeName" class="form-control"  /> 
            <form:errors path="employeeName" cssClass="has-error" />

        </div>
    </div>
    <div class="form-group"> 
        <label for="employeeEmail"  class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <form:input path="employeeEmail" id="employeeEmail" class="form-control"  /> 
            <form:errors path="employeeEmail" cssClass="has-error" />
        </div>
    </div>

    <div class="form-group"> 
        <label for="employeeMobile"  class="col-sm-2 control-label">Mobile</label>
        <div class="col-sm-10">
            <form:input path="employeeMobile" id="employeeMobile" class="form-control"  /> 
            <form:errors path="employeeMobile" cssClass="has-error" />
        </div>
    </div>
    <div class="form-group"> 
        <label for="employeeUserName"  class="col-sm-2 control-label">User Name</label>
        <div class="col-sm-10">
            <form:input path="employeeUserName" id="employeeUserName" class="form-control"  /> 
            <form:errors path="employeeUserName" cssClass="has-error" />
        </div>
    </div>


    <div class="form-group"> 
        <label for="dateOfBirth" class="col-sm-2 control-label">Date of Birth</label>
        <div class="col-sm-10">
            <form:input path="dateOfBirth" id="dateOfBirth" class="form-control"  /> 
            <form:errors path="dateOfBirth" cssClass="has-error" />
        </div>
    </div>

    <div class="form-group"> 
        <label for="officeStart" class="col-sm-2 control-label">Office Start</label>
        <div class="col-sm-10">
            <form:input path="officeStart" id="officeStart" class="form-control"  /> 
            <form:errors path="officeStart" cssClass="has-error" />
        </div>
    </div>

    <div class="form-group"> 
        <label for="officeEnd" class="col-sm-2 control-label">Office End</label>
        <div class="col-sm-10">
            <form:input path="officeEnd" id="officeEnd" class="form-control"  /> 
            <form:errors path="officeEnd" cssClass="has-error" />
        </div>
    </div>

    <div class="form-group"> 
        <label for="effectDate" class="col-sm-2 control-label">Effect Date</label>
        <div class="col-sm-10">
            <form:input path="effectDate" id="effectDate" class="form-control"  /> 
            <form:errors path="effectDate" cssClass="has-error" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/employee" class="btn btn-default ">
        <i class="glyphicon glyphicon-hand-left"></i> Back
    </a>
</form:form>