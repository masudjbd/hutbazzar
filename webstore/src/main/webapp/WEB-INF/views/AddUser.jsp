<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Users</title>
    </head>
    <body>

        <section class="container">
            <form:form  commandName="users" class="form-horizontal">
                <fieldset>
                    <legend>Add new User</legend>

                    <form:errors path="*" cssClass="alert alert-danger" element="div"/>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="username">
                            <spring:message code="adduser.form.username.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="username" path="username" type="text"
                                        class="form:input-large" />
                            <form:errors path="username" cssClass="text-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2" for="password">
                            <spring:message code="adduser.form.password.label" />
                        </label>
                        <div class="col-lg-10">
                            <form:input id="password" path="password" type="password"/>
                            <form:errors path="password" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="roleType">
                            <spring:message code="adduser.form.roleType.label" />
                        </label>
                        
                        <div class="col-lg-10">
                            <form:checkbox  path="userAuthorities" value="ROLE_USER"/> USER
                            <form:checkbox path="userAuthorities" value="ROLE_ADMIN"/> ADMIN 
                            <form:errors path="userAuthorities" cssClass="text-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value="Add User" />
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>
