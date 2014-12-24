/**
 * Created by guoliangwang on 12/23/14.
 */

var ninjaApp = angular.module("ninjaApp", ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/assets/partials/defaultPage.html'
    })
        .when('/link1', {
            templateUrl: '/assets/partials/link1.html'
        })
        .when('/link2', {
            templateUrl: '/assets/partials/link2.html'
        })
        .when('/link3', {
            templateUrl: '/assets/partials/link3.html'
        })
        .otherwise({
            templateUrl: '/assets/partials/otherwise.html'
        });
    }]);


