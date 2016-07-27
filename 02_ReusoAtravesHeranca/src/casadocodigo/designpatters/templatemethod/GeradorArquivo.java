package casadocodigo.designpatters.templatemethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/*
 * Como no exemplo abaixo temos um algoritmo base em que os passos podem ser modificados de acordo com
 * a implementação, esse é um cenário adequado para implementação do padrão Template Method. A classe
 * GeradorArquivo, possui o método gerarArquivo() que define um algoritmo base para a criação do arquivo,
 * invocando os dois métodos abstratos processar() e gerarConteudo(). Esse método possui o modificador final
 * para que ele não possa ser sobrescrito nas subclasses. Note que o método processar() fornece uma
 * implementação default que retorna o próprio array de bytes, representando o caso em que não existe processamento
 * adicional após o arquivo ser gerado. Diferentemente, o método gerarConteudo() é abstrado e obrigatoriamente
 * precisará ser implementado.
 */
public abstract class GeradorArquivo {
	/*
	 * Para evitar a redundância de código, caso o cliente queira uma implementação que faça a compactação 
	 * do arquivo e a criptografia, a implementação de uma variabilidade sera separada em uma outra classe.
	 * Arquivo. Dessa forma, o método implementado nessa hierarquia de classes à parte será invocado como
	 * parte da implementação do algoritmo.
	 * O método processar() não está mais na mesma classe e sim na instância de PosProcessador que compões
	 * GeradorArquivo. Dessa forma, qualquer implementação dessa interface pode ser utilizada para realizar o
	 * pós-processamento do arquivo. A grande motivação dessa solução no cenário apresentado é que o processador
	 * pode ser configurado independente da subclasse que está sendo utilizada, permitindo às duas variar de forma
	 * independente. O padrão aplicado neste exemplo foi o design pattern Bridge.
	 */
	private PosProcessador processador;
	
	public GeradorArquivo() {
		/*
		 * Para soluções que não precisam de um PosProcessador, foi criado um objeto NullProcessador
		 * que retorna o próprio array de bytes recebico como parâmetro. Sendo assim, para garantir que
		 * não ocorra um NullPointerException caso o conteúdo da variável processador seja nulo, uma
		 * instância dessa classe será atribuida na criação do objeto. A instância utilizada na criação,
		 * utilizará o design pattern Null Object para solucionar esse problema.
		 */
		this.processador = new NullProcessador();
	}


	public void setProcessador(PosProcessador processador) {
		this.processador = processador;
	}


	public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
		String conteudo = gerarConteudo(propriedades);
		byte[] bytes = conteudo.getBytes();
		bytes = processador.processar(bytes);
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();
	}//gerarArquivo()
	
	protected abstract String gerarConteudo(Map<String, Object> propriedades);
}//class GeradorArquivo
