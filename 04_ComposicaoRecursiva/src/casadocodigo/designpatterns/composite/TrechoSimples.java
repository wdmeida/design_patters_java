package casadocodigo.designpatterns.composite;


/*
 * Para exemplificar a aplicação do padrão Composite, vamos modelar as classes que representam trechos
 * aéreos em uma aplicação de turismo. Para esse exercício vamos considerar que as informações principais
 * de um trecho aéreo são sua origem, seu destino e o seu preço. Muitas vezes, quando um cliente solicita 
 * um voo a partir de uma origem e um destino, não existe um voo direto que conecta aqueles dois aeroportos.
 * Nesse caso, normalmente busca-se então um voo que pousa em um aeroporto intermediário, de onde o cliente
 * pode pegar um outro voo até o seu destino. Nesse caso, além do preço dos dois trechos, deve-se adicionar
 * a taxa de conexão conbrada pelo aeroporto intermediário. A questão é independente do trecho aéreo ser
 * composto por mais de um trecho ou não, em certos pontos o sistema deve tratá-los de forma similar.
 * 
 * O primeiro passo é a definição de uma interface que irá definir quais serviços serão disponibilizados 
 * pela classe que representar o trecho simples e o composto. Pela descrição do problema, o trecho deve
 * ser capaz de retornar a origem, o destino e o preço. Sendo assim, a listagem a seguir apresenta a 
 * interface TrechoAereo que define métodos para recuperação dessas informações. Em seguida, é apresentado
 * o código da classe TrechoSimples, que possui uma implementação cuja lógica é apenas o acesso a atributos.
 */

public class TrechoSimples implements TrechoAereo {
	private String origem;
	private String destino;
	private double preco;
	
	public TrechoSimples(String origem, String destino, double preco) {
		this.origem = origem;
		this.destino = destino;
		this.preco = preco;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public double getPreco() {
		return preco;
	}
}
