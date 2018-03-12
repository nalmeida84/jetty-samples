'use strict';

/* Controllers */

var controllers = angular.module('angularApp.controllers', []);

controllers.controller('HelloController', function($log, $scope, HelloFactory) {
	$scope.helloapp = "hello from Angular";
	var promise = HelloFactory.sayHello();
	promise.then(function(payload) {
		$scope.hellorest = payload.data;
	}, function(errorPayload) {
		$scope.hellorest = data;
		$log.error('error getting the data: ', errorPayload);
	});
});

controllers.controller('SortController', function($scope) {
	$scope.sortColumn = 'id'; // set the default sort type
	$scope.sortReverse = false; // set the default sort order
});

app.controller('UsersController', function($log, $scope, UsersFactory, UserFactory,
		$location) {

	// callback for ng-click 'editUser':
	$scope.editUser = function(userId) {
		$scope.users = UserFactory.getUser({
			id : userId
		});
	};

	// callback for ng-click 'deleteUser':
	$scope.deleteUser = function(userId) {
		UserFactory.deleteUser({
			id : userId
		});
		/* FIXME no está funcionando promise
		promise.then(function(response){
			$scope.users = UsersFactory.listUsers();
        },function(response){
        	$log.error('error deleting the user: ', response);
        });		
        */
	};

	// callback for ng-click 'createUser':
	$scope.createNewUser = function() {
		UserFactory.createUser({
			name : name
		});
		$scope.users = UsersFactory.listUsers();
	};

	$scope.users = UsersFactory.listUsers();
});