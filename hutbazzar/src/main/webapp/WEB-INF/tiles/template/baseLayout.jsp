<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initialscale=1.0">
        <title><tiles:insertAttribute ignore="true" name="title" /></title>
        <link href="${pageContext.request.contextPath}/resource/css/bootstrap.css"
              rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resource/css/jumbotron.css"
              rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <ul class="nav nav-pills pull-right">
                    <tiles:insertAttribute name="navigation" />
                </ul>
                 
                <!--<h3 class="text-muted">Web Store</h3>-->
                <img
                    src="<c:url
                        value="/resource/images/logo2.png"></c:url>"
                        alt="image"  />            </div>

                <div class="jumbotron">
                    <h1>

                    <tiles:insertAttribute name="heading" />
                </h1>

                <p>
                    <tiles:insertAttribute name="tagline" />
                </p>
            </div> 

            <div class="row">
                <tiles:insertAttribute name="content" />
            </div>
            <div class="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>