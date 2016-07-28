package casadocodigo.designpatters.state;

import java.util.List;

/*
 *	A listagem a seguir apresenta a classe abstrata Cor e suas três subclasses. Observe que cada cor
 *	implementa os hook methods da definição do estado, de acordo com a descrição do algoritmo. Quando
 *	o nó do estado Branco recebe a chamada da busca, o mesmo deve passar para a cor Cinza. Essa, por
 *	sua vez, ao ser assumida pelo nó inicia o processamento de todos os nós adjascentes, assumindo a
 *	cor Preto ao seu final. Finalmente, ao se tornar Preto, o nó deve ser adicionado na lista recebida
 *	como parâmetro pelo algoritmo. 
 */
public abstract class Cor {
	void busca(No no, List<No> list) {}
	void assumiu(No no, List<No> list) {}
}//abstract class Cor
