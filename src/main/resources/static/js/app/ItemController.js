'use strict'

var module = angular.module('unittesting.controller', []);
module.controller("ItemController", [ "$scope", "ItemBusinessService",
		function($scope, ItemBusinessService) {
	

			ItemBusinessService.buildInfo().then(function(value) {
				$scope.buildInfo= value.data;
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			
			ItemBusinessService.gitInfo().then(function(value) {
				$scope.gitInfo = value.data;
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
	
			$scope.getItems = function() {
				ItemBusinessService.getAllItems().then(function(value) {
					$scope.allItems= value.data;
					$scope.allUsers= null;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			},
			$scope.getUsers = function(){
				ItemBusinessService.getAllUsers().then(function(value) {
					$scope.allUsers= value.data;
					$scope.allItems=null;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
			
		} ]);