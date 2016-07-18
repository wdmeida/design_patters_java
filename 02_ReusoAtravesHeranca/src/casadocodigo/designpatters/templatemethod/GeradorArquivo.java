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
	
	public final void gerarArquivo(String nome, Map<String, Object> propriedades) throws IOException {
		String conteudo = gerarConteudo(propriedades);
		byte[] bytes = conteudo.getBytes();
		bytes = processar(bytes);
		FileOutputStream fileout = new FileOutputStream(nome);
		fileout.write(bytes);
		fileout.close();
	}//gerarArquivo()
	
	protected byte[] processar(byte[] bytes) throws IOException {
		return bytes;
	}//processar()
	
	protected abstract String gerarConteudo(Map<String, Object> propriedades);
}//class GeradorArquivo
