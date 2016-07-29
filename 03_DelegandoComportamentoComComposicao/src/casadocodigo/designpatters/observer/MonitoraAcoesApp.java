package casadocodigo.designpatters.observer;

/*
 * Para finalizar o exemplo, associamos os observadores na carteria de ações e adicionamos ações
 * a carteira. No ínicio do código, as intâncias de GraficoBarras e AcoesLogger são criadas e associadas
 * ao objeto da classe CarteiraAcoes. Em seguida, o método Thread.sleep() é utilizado para gerar
 * um intevalo entre cada quantidade inserida na carteira de ações, para ser possível ver de forma 
 * progressiva as alterações no gráfico e as modificaçẽos registradas no console.
 */
public class MonitoraAcoesApp {

	public static void main(String[] args) throws Exception {
		GraficoBarras gb = new GraficoBarras();
		AcoesLogger al = new AcoesLogger();
		CarteiraAcoes c =  new CarteiraAcoes();
		c.addObservador(gb);
		c.addObservador(al);
		
		Thread.sleep(2000);
		c.adicionaAcoes("COMP02", 200);
		Thread.sleep(2000);
		c.adicionaAcoes("EMP34", 400);
		Thread.sleep(2000);
		c.adicionaAcoes("ACDF89", 300);
		Thread.sleep(2000);
		c.adicionaAcoes("EMP34", -200);
		Thread.sleep(2000);
		c.adicionaAcoes("COMP02", 150);
	}//main()

}//class MonitoraAcoesApp
