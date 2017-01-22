/**
 * Created by parvinder.kumar on 16-01-2017.
 */

var cartApp=angular.module("cartApp",[]);
cartApp.controller("cartCtrl",function ($scope,$http) {

    $scope.refreshCart=function () {

        $http.get('/musicstore/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        })
    };

    $scope.clearCart=function () {
        $http.delete('/musicstore/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId=function (cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart(cartId);
    };
    
    $scope.addToCart=function (productId) {
        $http.put('/musicstore/rest/cart/add/'+productId).success(function () {
            alert("Product added successfully");
        })
    };

    $scope.removeFromCart=function (productId) {
        $http.put('/musicstore/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart();
        })
    };

    $scope.calGrandTotal=function () {
        var grandTotal=0;
        for(var i=0;i<$scope.cart.cartItems.length;i++){
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    }

});