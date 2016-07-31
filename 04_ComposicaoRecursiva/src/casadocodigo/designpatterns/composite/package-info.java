package casadocodigo.designpatterns.composite;

/**
 * O padrão Composite possui o objetivo de permitir que a mesma abstração possa ser utilizada
 * para uma instância simples e para seu conjunto. Uma abstração apresenta uma interface básica
 * com as operações que devem ser executadas tanto nos objetos simples quanto nos compostos. A
 * classe Simples apresenta um único indivíduo e a classe Composto representa o conjunto. Existe
 * uma relação de composição entre Composto e Abstração, que mostra que um objeto da classe 
 * Composto pode ser composto por outro também da classe Composto.
 * 
 * Os objetos organizados com o padrão Composite acabam seguindo uma estrutura de árvore. As folhas
 * seriam as classes simples, que não possuem a composição. Podem haver diversas classes desse tipo 
 * com diferentes implementações. Os ramos seriam representados pelas classes compostas, que seriam
 * compostas pelos seus filhos. O número de filhos de uma classe composta varia com a necessidade da
 * aplicação, podendo ser duas instâncias ou um conjunto.
 * 
 * O grande benefício do Composite é tornar totalmente transparente para os clientes o fato de estarem
 * trabalhando com um objeto simples ou composto. Isso torna muito simples adicionar uma implementação
 * de um objeto composto em uma hierarquia já existente na aplicação.
 */