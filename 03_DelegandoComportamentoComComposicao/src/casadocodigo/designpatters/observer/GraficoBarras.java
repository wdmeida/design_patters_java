package casadocodigo.designpatters.observer;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * A seguir, são apresentadas duas listagens de classes que implementam a interface Observador: AcoesLogger
 * e GraficoBarras. A classe AcoesLogger possui uma implementação bem simples e apenas registra a nova
 * quantidade recebida no console. Já a classe GraficoBarras utiliza o componente de geração de gráficos
 * JFreeChart para a criação de uma janela com um gráfico de barras que é atualizado toda vez que uma 
 * mudança é notificada.
 */
public class GraficoBarras implements Observador {
	
	private DefaultCategoryDataset dataset;
	private JFrame frame = new JFrame("Gráfico barras");
	
	public GraficoBarras() {
		dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart(
				"Carteria de Ações", "Siglas", 
				"Quantidade", dataset, PlotOrientation.VERTICAL,
					false, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		frame.setContentPane(chartPanel);
		frame.setSize(500, 270);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mudancaQuantidade(String acao, Integer qtd) {
		dataset.setValue(qtd, "Quantidade", acao);
	}//mudancaQuantidade()

}//classGraficoBarras
