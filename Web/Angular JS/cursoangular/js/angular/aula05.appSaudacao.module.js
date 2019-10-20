//[] - Serve para colocar dependencias q a aplicação terá
var appSaudacao = angular.module('appSaudacao', []);

appSaudacao.filter('hello', function(){
    return function(nome){
        return "Hello " + nome + "!";
    }
});