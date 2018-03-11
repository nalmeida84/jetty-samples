'use strict';

var services = angular.module('angularApp.services', [ 'ngResource' ]);

var baseUrl = 'http://localhost\\:4040';

// $http instead of $resource to avoid response json parsing
services.factory('HelloFactory', function($http) {
	return {
		sayHello : function() {
			return $http({
				method : 'GET',
				url : '/rest/hello'
			});
		}
	}
});

services.factory('UsersFactory', function($resource) {
	return	$resource(baseUrl + '/rest/users', {}, {
		listUsers : {
			method : 'GET',
			isArray : true
		}
	})
});

services.factory('UserFactory', function ($resource) { 
	return $resource(baseUrl + '/rest/user/:id', {}, { 
			getUser: { method: 'GET' },
			createUser: { method: 'POST', params: {name: '@name'} },
			updateUser: { method: 'PATCH', params: {id: '@id'} }, 
			deleteUser: { method: 'DELETE', params: {id: '@id'} } 
	}) 
});




//createUserRole: { method: 'POST', params: {name: '@name', id: '@id'} },
//updateUser: { method: 'PATCH', params: {id: '@id', name: '@name'} },
//addUserRole { method: 'PATCH', params: {userId: '@userId', roleId: '@roleId'} }

/*
 * services.factory('HelloService', function ($resource) { return
 * $resource(baseUrl + '/rest/hello', {}, { query: { method: 'GET', params: {} } })
 * });
 * 
 * 
 * services.factory('UsersService', function ($resource) { return
 * $resource(baseUrl + '/rest/users', {}, { query: { method: 'GET', isArray:
 * true }, create: { method: 'POST' } }) });
 * 
 * services.factory('UserService', function ($resource) { return
 * $resource(baseUrl + '/rest/user/:id', {}, { show: { method: 'GET' }, update: {
 * method: 'PUT', params: {id: '@id'} }, delete: { method: 'DELETE', params:
 * {id: '@id'} } }) });
 */