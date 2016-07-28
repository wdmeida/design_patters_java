package casadocodigo.designpatters.state;

/*
 * Quando temos que representar estados de um objeto em um software, frequentemente utilizamos
 * enumerações. O problema é que muitas vezes as enumerações possuem apenas a definição dos 
 * estados, ficando a lógica específica de cada estado presa dentro dos condicionais na classe.
 * Construções do tipo enum podem definir métodos, inclusive abstratos, que podem ser sobrescritos
 * na definição de cada estado. Segue na listagem a seguir como as cores dos nós do grafo poderiam
 * ser definidas utilizando uma enumeração. Em relação ao resto do código, somente a inicialização
 * do atributo cor da classe No precisaria ser modificada.
 * 
 * Porém existem algumas situações em que a utilização de enumerações é desaconselhada na representação
 * de um estado. A primeria é quando é desejável que o estado seja um ponto de extensão e que novos
 * estados possam ser definidos. Nesse caso, como os possíveis estados são definidos dentro de uma
 * enumeração fixa, não se pode adicionar um novo sem a modificação do código do próprio enum. Outra
 * situação é quando algum estado precisa armazenar uma informação específica do objeto que está sendo
 * composto por ele. Nesse caso, como cada instância do enum é compartilhada por todos que a possuem, 
 * a informação não poderia ser diferente para cada uma.
 */

/*public enum EnumCor {
	
	BRANCO{
		public void busca(No no, List<No> list) {
			//Se fosse alterado para enum, o método ser cor teria que ser redefinido para aceitar enum.
			no.setCor(CINZA, list);
		}
	},
	CINZA{
		void assumiu(No no, List<No> list) {
			for(No adj: no.getAdjacentes())
				adj.buscaProfundidade(list);
			no.setCor(PRETO, list);
		}
	},
	PRETO{
		void assumiu(No no, List<No> list){
			list.add(no);
		}
	};
	
	void busca(No no, List<No> list){}
	void assumiu(No no, List<No> list){}
}//enum EnumCor
*/