package casadocodigo.designpatters.com;

/*
 * A classe ContaEstacionamento delega para uma classe que a compõe o calculo do valor do estacionamento. A
 * interface CalculoValor abstrai o algoritmo de cálculo da tarifa. Observe que existe um método que permite 
 * que o atributo calculo seja alterado, permitindo a mudança desse algoritmo depois que o objeto foi criado.
 */
public class ContaEstacionamento {
	
	/*
	 * O Strategy é um padrão que deve ser utilizado quando uma classe possuir diversos algoritmos que possam ser
	 * utilizados de forma intercambiável. A solução proposta pelo padrão consiste em delegar a execução do 
	 * algoritmo para uma instância que compõe a classe principal. Dessa forma, quando a funcionalidade for invocada,
	 * no momemnto de execução do algoritmo, será invocado um método da instância que a compõe.
	 * 
	 * A principal consequência positiva é justamente o fato de o algoritmo poder ser alterado sem a modificação da classe.
	 * A partir dessa estrutura, novas implementações dele podem ser criadas e introduzidas posteriormente. Outro ponto positivo
	 * do padrão está no fato da lógica condicional na classe principal ser reduzida. Como a escolha do algoritmo está na 
	 * implementação do objeto que está compondo a classe, isso elimina a necessidade de ter condicionais para selecionar
	 * a lógica a ser executada. Outra consequência positiva está no fato de a implementação poder ser trocada em tempo de
	 * execução, fazendo que o comportamento da classe possa ser trocado dinamicamente.
	 * 
	 * No caso do Strategy, como em todos os demais Design Patters, existem pontos negativos. Devido a complexidade na criação
	 * do objeto, pois a instância da dependência precisa ser criada e configurada. Caso o atributo seja nulo, a classe pode 
	 * apresentar um comportamento inesperado. Outro problema dessa solução está no aumento do número de classes: há uma para
	 * cada algoritmo, criando uma maior dificuldade em seu gerenciamento.
	 */
	private CalculoValor calculo;
	
	private long inicio;
	private long fim;
	
	public double valorConta() {
		return calculo.calcular(fim - inicio);
	}
	
	public void setCalculo(CalculoValor calculo) {
		this.calculo = calculo;
	}
}//class ContaEstabeleciomento
