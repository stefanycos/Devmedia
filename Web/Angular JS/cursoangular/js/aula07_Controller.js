app.controller("aula07_controller", function($scope){
    
    //Array
    $scope.nomes = ['Liliana', 'Antonio', 'Roseli', 'Stefany'];
    
    //Array de Objetos
    $scope.pessoas = [];
    $scope.pessoas.push(
        { 
            nome : 'Oliver Queen' , idade :  31, status :  false
        }
    );
     $scope.pessoas.push(
        { 
            nome : 'Moira Queen' , idade :  50, status :  false
        }
    );
     $scope.pessoas.push(
        { 
            nome : 'Tea Queen' , idade :  21, status :  true
        }
    );
    console.log($scope.pessoas);
    
    $scope.adicionaPessoa = function(){
        var nome = document.getElementById("nomepessoa");
        var idade = document.getElementById("idadepessoa");
        
        $scope.pessoas.push(
            { 
                nome : nome.value , idade :  idade.value
            }
        );
        nome.value = "";
        idade.value = "";    
    }
});