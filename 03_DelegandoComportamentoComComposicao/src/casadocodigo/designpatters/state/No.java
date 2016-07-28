package casadocodigo.designpatters.state;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * A seção irá representar o padrão State, o qual utiliza composição para permitir essa
 * variação de comportamento de acordo com o estado de uma entidade do sistema. Nesse padrão,
 * os estados são representados a partir de classes que obedecem a uma abstração comum, podendo
 * ser uma interface ou uma superclasse. Dessa forma, a entidade é composta por um objeto do tipo dessa
 * abstração e, nos métodos de negócios, delega para ela o comportamento de toda parte que depende do
 * seu estado.
 * 
 * Para exemplificar, será implementada uma busca em profundidade. O primeiro passo da implementação
 * é definir um nó e quais os pontos da execução que diferem com o estado. No contexto do algoritmo,
 * as informações relevantes de um nó são o seu nome, seus nós adjacentes e sua cor. Essa classe
 * possui um método chamado buscaProfundidade() que irá efetivamente executar o algoritmo. Os pontos 
 * identificados que podem variar com o estado são: a própria execução da busca em profundidade, pois
 * no caso do nó ser preto ou cinza ela não deve ser executada; e quando o nó assume uma cor.
 */
public class No {
	private Set<No> adjacentes = new HashSet<>();
	private Cor cor;
	private String name;
	
	public No(String name) {
		this.name = name;
		cor = new Branco();
	}
	
	public void buscaProfundidade(List<No> list) {
		cor.busca(this, list);
	}
	
	public Set<No> getAdjacentes() {
		return adjacentes;
	}
	
	public void addAdjacentes(No adj) {
		adjacentes.add(adj);
	}
	
	public void setCor(Cor cor, List<No> list) {
		this.cor = cor;
		cor.assumiu(this, list);
	}
	
	public String toString() {
		return name;
	}
}//class No
