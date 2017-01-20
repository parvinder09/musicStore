/**
 * Created by parvinder.kumar on 16-01-2017.
 */

var cartApp=angular.module("cartApp",[]);
cartApp.controller("cartCtrl",function ($scope,$http) {

    $scope.refreshCart=function (cartId) {

        $http.get('/musicstore/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        })
    }

    $scope.clearCart=function () {
        $http.delete('/musicstore/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    }

    $scope.initCartId=function (cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart(cartId);
    }
    
    $scope.addToCart=function (productId) {
        $http.put('/musicstore/rest/cart/add/'+productId).success(function (data) {

          $scope.refreshCart($http.get('/musicstore/rest/cart/cartId'));
            console.log(productId);
            alert("Product added successfully");
        })
    }

    $scope.removeFromCart=function (productId) {
        $http.put('/musicstore/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/musicStore/rest/cart/cartId'));
        })
    }

})