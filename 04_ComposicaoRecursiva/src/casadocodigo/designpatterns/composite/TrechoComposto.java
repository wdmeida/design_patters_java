package casadocodigo.designpatterns.composite;

/*
 * Para a implementação do trecho composto, será aplicado o padrão Composite. Nesse caso, o trecho
 * composto possui dois atributos, respectivamente para representar o primeiro e o segundo trecho
 * que o compõe. Também existe um atributo que representa a taxa de conexão a ser paga de forma 
 * adicional ao preço de cada trecho individualmente. Note que no construtor é feita uma verificação
 * se o segundo treço começa no mesmo local em que o primeiro termina. Pode ser observado que as 
 * operações que precisavam ser implementadas delegam parte da execução para os trechos que compõem
 * o objeto.
 */
public class TrechoComposto implements TrechoAereo {
	private TrechoAereo primeiro;
	private TrechoAereo segundo;
	private double taxaconexao;
	
	public TrechoComposto(TrechoAereo primeiro, TrechoAereo segundo, double taxaconexao) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.taxaconexao = taxaconexao;
		
		if(primeiro.getDestino() != segundo.getOrigem())
			throw new RuntimeException("O destino do primeiro não é igual a origem do segundo.");
	}

	@Override
	public String getOrigem() {
		return primeiro.getOrigem();
	}

	@Override
	public String getDestino() {
		return segundo.getDestino();
	}

	@Override
	public double getPreco() {
		return primeiro.getPreco() + segundo.getPreco() + taxaconexao;
	}

}
