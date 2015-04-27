<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<title>Products</title>
<script src="${pageContext.request.contextPath}/resource/js/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/controllers.js"></script>

<section class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img
                src="<c:url
                    value="/resource/images/${product.productId}.png"></c:url>"
                    alt="image" class="img-thumbnail" style="width: 100%" />
            </div>
            <div class="col-md-5">

                <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
            </p>
            <p>
                <strong>manufacturer</strong> : ${product.manufacturer}
            </p>
            <p>
                <strong>category</strong> : ${product.category.categoryName}
            </p>
            <p>
                <strong>Available units in stock </strong> :
                ${product.unitsInStock}
            </p>
            <h4>${product.unitPrice}USD</h4>
            <p ng-controller="cartCtrl">
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span> View Cart
                </a> <a href="<spring:url value="/products" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> back
                </a> <a href="#" class="btn btn-warning btn-large"
                        ng-click="addToCart('${product.productId}')"> <span
                        class="glyphicon-shopping-cart glyphicon"></span> Order Now
                </a>
            </p>
        </div>
    </div>
</section>
