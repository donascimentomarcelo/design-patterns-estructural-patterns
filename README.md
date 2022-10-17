#  Design Patterns Estructural

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Mediator
* Proxy

#
### Adapter

O Padrão Adapter converte uma interface de uma classe para outra interface que o cliente espera encontrar. 
O Adaptador permite que classes com interfaces incompatíveis trabalhem juntas.

* Dado que possuo 3 objetos e desejo integrar `VGA` à `HDMI`
    * `TV` que implementa `HDMI`
    * `OldMonitor` que implementa `VGA`
    * `Computer` que tem um parâmetro chamado `HDMI`
* As interfaces `HDMI` e `VGA` são incompatíveis e não podem ser implementadas com os mesmos métodos
* Deve-se criar uma classe adater `HDMIToVGAAdapter` que implemente a interface que desejo fazer a adaptação,
nesse caso, é `HDMI`.
    * A classe adater `HDMIToVGAAdapter` deve ter método `connectPort` que receba um objeto do tipo `VGA` como parâmetro
    * O objeto do tipo `VGA` deve ser usado na implementação caso necessário
* Uso: 
    * Ter uma instancia do tipo `OldMonitor`
    * Passar essa instância como parâmetro no método `connectPort` do objeto `HDMIToVGAAdapter`
    * Chamar método que realize a implementação `sendImageAndSound`


![Alt text](imgs/adapter.jpg "Adapter")
#
### Bridge

Desacoplar uma abstração de sua implementação para que os dois possam variar independentemente.

* Possuir classe abstrata `Employee`
* Os objetos concretos `ITGuy` e `ProjectManager` devem estender essa classe
* Possuir interface `Converter` que deve ser implementada pelas classes `CSVConverter` e `JsonConverter`
* Uso:
    * Instanciar a classe do tipo converter que deseja utilizar
    * Ter uma instancia de `ITGuy` e `ProjectManager`
    * Passar objeto como parâmetro no `getEmployeeFormated` que vem do converter
* Com isso, evitamos de criar `ITGuyJson`, `ProjectManagerJson`, `ITGuyCsv` e `ProjectManagerCsv`, fazendo com que a 
aplicação possua um grande número de classes concretas.

![Alt text](imgs/bridge.jpg "Bridge")
#
### Composite

Compor objetos em estruturas de árvore para representar hierarquias todo-parte. Composite permite que clientes tratem 
objetos individuais e composições de objetos de maneira uniforme.

* Possuir uma interface `FileSystemItem`, que pode ser um nó ou uma folha (uma pasta ou um arquivo)
* Possuir uma classe concreta chamada `CompositeFolder`, que implementa `FileSystemItem`
    * A `CompositeFolder` deve ter uma lista de `FileSystemItem`, que podem ser tanto pastas como arquivos 
    (Onde ocorre o composite)
    

![Alt text](imgs/composite.jpg "Composite")
#
### Decorator

#
### Facade

#
### Flyweight

#
### Mediator 

#
### Proxy