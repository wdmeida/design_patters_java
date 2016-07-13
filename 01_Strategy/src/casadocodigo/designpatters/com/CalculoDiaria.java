package casadocodigo.designpatters.com;

/*
 * A classe CalculoDiaria mostra um exemplo de uma classe que faz o cálculo da tarifa por dia. Observe
 * que essa classe possui um atributo que pode ser utilizado para parametrizar partes do algoritmo.
 * Dessa forma, quando a estratégia for alterada para o calculo do valor por dia, basta inserir a instância
 * dessa classe em ContaEstacionamento. Vale também ressaltar que essa mesma classe pode ser reaproveitada
 * para diferentes empresas em diferentes momentos, evitando assim a duplicação de código.
 */
public class CalculoDiaria implements CalculoValor {
	
	private long periodo;
	private long hora;
	private double valorDiaria;

	public CalculoDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public double calcular(long valor) {
		return valorDiaria * Math.ceil(periodo / hora);
	}
}//class CalculoDiaria
