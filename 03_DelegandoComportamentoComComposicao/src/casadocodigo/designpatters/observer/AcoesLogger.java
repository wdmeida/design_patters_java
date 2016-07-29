package casadocodigo.designpatters.observer;

/*
 * A seguir, são apresentadas duas listagens de classes que implementam a interface Observador: AcoesLogger
 * e GraficoBarras. A classe AcoesLogger possui uma implementação bem simples e apenas registra a nova
 * quantidade recebida no console. Já a classe GraficoBarras utiliza o componente de geração de gráficos
 * JFreeChart para a criação de uma janela com um gráfico de barras que é atualizado toda vez que uma 
 * mudança é notificada.
 */
public class AcoesLogger implements Observador {

	@Override
	public void mudancaQuantidade(String acao, Integer qtd) {
		System.out.println("Alterada a quantidade da ação "
				+ acao + " para " + qtd);
	}//mudancaQuantidade(0
}//class AcoesLogger
