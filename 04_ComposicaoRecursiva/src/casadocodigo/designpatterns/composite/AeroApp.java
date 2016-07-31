package casadocodigo.designpatterns.composite;

public class AeroApp {
	
	/*
	 * Observe que o TrechoComposto pode ser composto tanto por instâncias de TrechoSimples quanto
	 * por instâncias do próprio TrechoComposto de forma transparente, criando uma estrutura de
	 * árvore.
	 */
	public static void main(String[] args) {
		TrechoSimples ts1 = new TrechoSimples("São Paulo", "Brasília", 500);
		TrechoSimples ts2 = new TrechoSimples("Brasília", "Recife", 300);
		TrechoSimples ts3 = new TrechoSimples("Recife", "Natal", 350);
		TrechoComposto tc1 = new TrechoComposto(ts2, ts3, 30);
		TrechoComposto tc2 = new TrechoComposto(ts1, tc1, 50);
		
		System.out.println("Valor do da viagem: " + tc2.getPreco());
	}
}
