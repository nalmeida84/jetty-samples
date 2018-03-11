'use strict';

/* Controllers */

var controllers = angular.module('angularApp.controllers', []);

/*
 * // Clear browser cache (in development mode) // //
 * http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
 * app.run(function ($rootScope, $templateCache) {
 * $rootScope.$on('$viewContentLoaded', function () {
 * $templateCache.removeAll(); }); });
 * 
 */

controllers.controller('HelloController', function($log, $scope, HelloFactory) {
$scope.helloapp = "hello from Angular";	    
var promise = HelloFactory.sayHello();
promise.then(
	function(payload) { 
		$scope.hellorest = payload.data;
	},
    function(errorPayload) {
		$scope.hellorest = data;
		$log.error('error getting the data: ', errorPayload);
	});	    
});

controllers.controller('SortController', function($scope) {
	$scope.sortColumn = 'id'; // set the default sort type
	$scope.sortReverse = false;  // set the default sort order
});

app.controller('UsersController', function ($scope, UsersFactory, UserFactory, $location) {

	    // callback for ng-click 'editUser':
	    $scope.editUser = function (userId) {
	      $location.path('/user-detail/' + userId);
	    };

	    // callback for ng-click 'deleteUser':
	    $scope.deleteUser = function (userId) {
	      UserFactory.delete({ id: userId });
	      $scope.users = UsersFactory.query();
	    };

	    // callback for ng-click 'createUser':
	    $scope.createNewUser = function () {
	      $location.path('/user-creation');
	    };

	    $scope.users = UsersFactory.listUsers();
	  });


/*
 * 
 * app.controller('UserListCtrl', ['$scope', 'UsersService', 'UserService',
 * '$location', function ($scope, UsersFactory, UserFactory, $location) {
 *  // callback for ng-click 'editUser': $scope.editUser = function (userId) {
 * $location.path('/user-detail/' + userId); };
 *  // callback for ng-click 'deleteUser': $scope.deleteUser = function (userId) {
 * UserFactory.delete({ id: userId }); $scope.users = UsersFactory.query(); };
 *  // callback for ng-click 'createUser': $scope.createNewUser = function () {
 * $location.path('/user-creation'); };
 * 
 * $scope.users = UsersFactory.query(); }]);
 * 
 * app.controller('UserDetailCtrl', ['$scope', '$routeParams', 'UserService',
 * '$location', function ($scope, $routeParams, UserFactory, $location) {
 *  // callback for ng-click 'updateUser': $scope.updateUser = function () {
 * UserFactory.update($scope.user); $location.path('/user-list'); };
 *  // callback for ng-click 'cancel': $scope.cancel = function () {
 * $location.path('/user-list'); };
 * 
 * $scope.user = UserFactory.show({id: $routeParams.id}); }]);
 * 
 * app.controller('UserCreationCtrl', ['$scope', 'UsersService', '$location',
 * function ($scope, UsersFactory, $location) {
 *  // callback for ng-click 'createNewUser': $scope.createNewUser = function () {
 * UsersFactory.create($scope.user); $location.path('/user-list'); } }]);
 *  /*
 */