<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Edit Page</h1>

<a href="${pageContext.request.contextPath}/category" class="btn btn-default">
    <i class="glyphicon glyphicon-hand-left"></i> Back
</a>


<form:form method="post" action="${pageContext.request.contextPath}/category/edit/${category.categoryId}" 
           commandName="category" class="form-horizontal"  >
    <div class="form-group"> 
        <label for="categoryName" class="col-sm-2 control-label">Category Name</label>
        <div class="col-sm-10">
            <form:input path="categoryName" id="categoryName" class="form-control"  /> 
            <form:errors path="categoryName" cssClass="has-error" />

        </div>
    </div>
    <div class="form-group"> 
        <label for="categoryDescription"  class="col-sm-2 control-label">Category Description</label>
        <div class="col-sm-10">
            <form:input path="categoryDescription" id="categoryDescription" class="form-control"  /> 
            <form:errors path="categoryDescription" cssClass="has-error" />
        </div>
    </div>



    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/category" class="btn btn-default ">
        <i class="glyphicon glyphicon-hand-left"></i> Back
    </a>
</form:form>