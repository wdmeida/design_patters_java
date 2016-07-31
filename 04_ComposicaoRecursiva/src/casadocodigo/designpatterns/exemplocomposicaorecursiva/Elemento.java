package casadocodigo.designpatterns.exemplocomposicaorecursiva;

/*
 * Para exemplificar vamos considerar o código do elemento de uma lista ligada. A classe Elemento
 * possui um atributo proximo que possui o mesmo tipo. Dessa forma, é possível encadear diversas
 * instâncias dessa classe formando uma lista. O método contar() é um método recursivo no qual o
 * próprio método é chamado novamente, porém na instância que estiver no atributo proximo. A condição
 * de parada é quando um elemento não possui próximo, significando que ele é o último elemento da lista
 * e deve retornar um. Se houver um pŕoximo elemento, então a contagem deve retornar um mais a contagem
 * do próximo.
 * 
 * Até então não tem muita diferença entre as estruturas que podem ser construídas em uma linguagem
 * estruturada, como C, em que podem-se criar estruturas de dados utilizando a construção struct. O
 * grande diferencial dessa definição recursiva de estruturas é a utilização do poliformismo. Dessa
 * forma, o tipo base utilizado na estrutura pode ser uma interface ou uma superclasse que possuem
 * diversas implementações. Sendo assim, diversos tipos podem ser utilizados na criação da estrutura e
 * a implementação de um pode ser abstraída pelos outros. Adicionalmente, essa estrutura também pode 
 * ser facilmente estendida através da criação de novos tipos que possuam a mesma implementação. 
 */
public class Elemento {
	private Object valor;
	private Elemento proximo;
	
	public Elemento(Object valor) {
		this.valor = valor;
	}

	public Object getValor() {
		return valor;
	}
	
	public Elemento getProximo() {
		return proximo;
	}

	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}
	
	public int contar() {
		if (proximo == null) 
			return 1;
		return 1 + proximo.contar();
	}
}//class Elemento
