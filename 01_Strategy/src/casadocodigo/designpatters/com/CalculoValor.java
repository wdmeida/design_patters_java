package casadocodigo.designpatters.com;

/*
 * Interface CalculoValor deve ser implementada para definir as formas de tarifação do estacionamento.
 * Isso é necessário para garantir que cada estacionamento possa implementar as suas formas de tarifação,
 * deixando o código mais modularizado e flexivel para que possa ser usado em diferentes aplicações.
 */
public interface CalculoValor {
	public double calcular(long tempo);
}
