# FAQ sobre Programação Orientada a Objetos


### O que é Programação Orientada a Objetos (POO)?
A Programação Orientada a Objetos (POO) é um estilo de programação que estrutura o código em torno de 'objetos', unidades de software que colaboram entre si para solucionar problemas.

### Quais os pilares da POO?
São 4 pilares:

* Abstração: Refere-se à capacidade de esconder a complexidade e mostrar apenas as informações essenciais. 
* Encapsulamento: Refere-se ao conceito de esconder os detalhes internos de um objeto e fornecer métodos públicos para interagir com ele, garantindo maior controle sobre como os dados são acessados ou modificados.
* Herança: Permite que uma classe herde atributos e métodos de outra classe. A classe que herda é chamada de classe filha, e a classe original é a classe mãe.
* Polimorfismo: Permite que diferentes classes implementem o mesmo método de maneira distinta. O polimorfismo permite que o código trate objetos de diferentes tipos de maneira uniforme.

### O que são objetos?
Objetos são representações computacionais (domínio da solução) de entidades (concretas ou abstratas) do mundo real (domínio do problema). Possuem atributos e comportamentos. Um objeto é uma instância de uma classe.

### O que é uma classe?
uma classe é como um molde ou um modelo para criar objetos. Ela define a estrutura e o comportamento que os objetos terão. Pense em uma classe como uma planta de construção para casas: a planta descreve como as casas serão construídas, mas não é uma casa em si. Os objetos são as casas reais construídas a partir da planta.
Por exemplo, uma classe Carro pode ter atributos como cor, modelo e ano, e métodos como acelerar() e frear().

### O que é método construtor?
Um construtor é um método especial usado para inicializar objetos de uma classe. Ele é chamado automaticamente quando um novo objeto é criado. 
Em Java, o método construtor deve possuir o mesmo nome da classe e não deve ter retorno de valor.
Construtores podem ter parâmetros para permitir a inicialização com valores específicos.

### O que é encapsulamento?
Encapsulamento é o princípio de esconder os detalhes internos de uma classe e fornecer métodos públicos para acessar e modificar os dados de forma controlada. Isso garante que o estado do objeto seja protegido e modificado de maneira segura.

### O que é sobrecarga de método (method overloading)?
Sobrecarga de método é a capacidade de uma classe ter vários métodos com o mesmo nome, mas com parâmetros diferentes (número, tipo ou ordem). O compilador decide qual método chamar com base nos argumentos fornecidos.

### O que são atributos e métodos static?
São atributos e métodos que pertencem à classe e não a um objeto específico. Eles são compartilhados por todas as instâncias da classe. Atributos estáticos são úteis para armazenar informações que são comuns a todos os objetos da classe. Métodos estáticos são úteis para operações que não dependem do estado de um objeto. São invocados diretamente pela classe, sem a necessidade de criar uma instância. 

### O que é associação entre classes?
Associação é um relacionamento entre duas ou mais classes, indicando que objetos dessas classes se comunicam ou interagem entre si. É uma forma de modelar dependências e conexões no sistema.

### O que é multiplicidade em uma associação?
Multiplicidade especifica o número de objetos de uma classe que podem se relacionar com um objeto de outra classe. As multiplicidades mais comuns são:
1: Um objeto se relaciona com exatamente um objeto.
0..1: Um objeto se relaciona com zero ou um objeto.
* (ou 0..*): Um objeto se relaciona com zero ou muitos objetos.
1..*: Um objeto se relaciona com um ou muitos objetos.
n..m: Um objeto se relaciona com no mínimo "n" e no máximo "m" objetos.

### O que é navegabilidade em uma associação?
Navegabilidade define a direção em que a associação pode ser percorrida. Em outras palavras, indica se um objeto de uma classe pode acessar ou "conhecer" objetos da outra classe. A navegabilidade pode ser unidirecional ou bidirecional.
