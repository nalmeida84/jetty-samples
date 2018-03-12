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
	return $resource(baseUrl + '/rest/users', {}, {
		listUsers : {
			method : 'GET',
			isArray : true
		}
	})
});

services.factory('UserFactory', function($resource) {
	return $resource(baseUrl + '/rest/user/:id', {}, {
		getUser : {
			method : 'GET'
		},
		createUser : {
			method : 'POST',
			params : {
				name : '@name'
			}
		},
		deleteUser : {
			method : 'DELETE',
			params : {
				id : '@id'
			}
		}
	})
});