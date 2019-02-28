(function(){
    var app = angular.module("myApp", []);

    app.controller("myController", function ($scope, $http, $timeout) {
        // 導入主製程
        $scope.xclick = function() {
            $http({
                method: "POST",
                url: "test/query",
                headers: {
                    'Content-Type': 'application/json'
                },
                data: "world"
            }).then(function successCallBack(response) {
                alert(decodeURIComponent(response.data));
            }, function errorCallBack(error) {
                console.log(error);
                alert("請求失敗！");
            });
        };
    });
})();
