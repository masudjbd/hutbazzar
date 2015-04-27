<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <a href="<c:url value="/j_spring_security_logout" />"
                   class="btn btn-danger btn-mini pull-right">logout</a>
                <div class="pull-right" style="padding-right: 50px">
                    <a  class="btn btn-default" href="<spring:url value="/products"/>">Home</a>
                    <a class="btn btn-default" href="?language=en">English</a>|
                    <a class="btn btn-default" href="?language=nl">Dutch</a>  |
                    <a class="btn btn-default" href="?language=bn">বাংলা</a>  
                </div>
                <div class="container">
                    <h1>Products</h1>
                    <p>Add products</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal"
                       enctype="multipart/form-data">
                <fieldset>
                    <legend>Add new product</legend>

                    <form:errors path="*" cssClass="alert alert-danger" element="div"/>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                            <spring:message code="addProduct.form.productId.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="productId" path="productId" type="text"
                                        class="form-control" />
                            <form:errors path="productId" cssClass="text-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="unitPrice">
                            <spring:message code="addProduct.form.unitPrice.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="unitPrice" class="form-control"  path="unitPrice" />
                            <form:errors path="unitPrice" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="name">
                            <spring:message code="addProduct.form.name.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="name" class="form-control"  path="name" />
                            <form:errors path="name" cssClass="text-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="description">
                            <spring:message code="addProduct.form.description.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:textarea id="description" class="form-control"  path="description" rows="2" />
                            <form:errors path="description" cssClass="text-danger" />
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-lg-2" for="manufacturer">
                            <spring:message code="addProduct.form.manufacturer.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="manufacturer" class="form-control"  path="manufacturer" />
                            <form:errors path="manufacturer" cssClass="text-danger" />
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="control-label col-lg-2" for="unitsInStock">
                            <spring:message code="addProduct.form.unitsInStock.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="unitsInStock" class="form-control"  path="unitsInStock" />
                            <form:errors path="unitsInStock" cssClass="text-danger" />
                        </div>
                    </div>




                    <div class="form-group">
                        <label class="control-label col-lg-2" for="condition">
                            <spring:message code="addProduct.form.condition.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:radiobutton path="condt" value="New" />
                            New
                            <form:radiobutton path="condt" value="Old" />
                            Old
                            <form:radiobutton path="condt" value="Refurbished" />
                            Refurbished
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="category">
                            <spring:message code="addProduct.form.category.label" />
                        </label>
                        <div class="col-lg-10">



                            <form:select class="form-control"  path="category.categoryId">
                                 <form:options itemLabel="categoryName" itemValue="categoryId" items="${categories}"></form:options>
                            </form:select>

                            <form:errors path="category" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="productImage"> <spring:message
                                code="addProdcut.form.productImage.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="productImage" path="productImage" type="file"
                                        class="form-control" />
                            <form:errors path="productImage" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value="Add Product" />
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>