'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'unittesting.controller',
		'unittesting.business' ]);
demoApp.constant("CONSTANTS", {
	retrieveAllItems : "/all-items-from-database",
	buildInfo : "/actuator/info",
	gitInfo : "/version"
});