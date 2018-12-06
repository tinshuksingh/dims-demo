'use strict'

angular.module('unittesting.business', []).factory('ItemBusinessService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getAllItems = function() {
				return $http.get(CONSTANTS.retrieveAllItems);
			}
			service.getAllUsers = function() {
				return $http.get("https://reqres.in/api/users");
			}
			
			service.buildInfo = function() {
				return $http.get(CONSTANTS.buildInfo);
			}
			
			service.gitInfo = function() {
				return $http.get(CONSTANTS.gitInfo);
			}
			
			return service;
		} ]);