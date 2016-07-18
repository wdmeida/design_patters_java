package casadocodigo.designpatters.templatemethod;

import java.io.IOException;
import java.util.Map;
/*
 * As duas próximas listagens apresentam as classes GeradorXMLCompactado e GeradorPropriedadesCriptografado
 * que implementam a classe GeradorArquivo, fornecendo uma implementação para os passos dos algoritmos
 * definidos na superclasse. A primeira implementação, no método gerarConteudo() cria um arquivo XML no
 * qual existe uma tag chamada <properties> e cada propriedade é um elemento dentro dessa tag. O método
 * processar() usa a classe ZipOutputStrem para gerar um arquivo compactado. Já na segunda listagem, o
 * método gerarConteudo() cria a estrutura de um arquivo de propriedades em que cada linha possui o formato
 * propriedade = valor. O método de processamento criptografa os bytes do arquivo utilizando um algoritmo
 * simples chamado cifra de César, em que o valor de cada byte é deslocado de acordo com o parâmetro delay.
 */
public class GeradorPropriedadesCriptografado extends GeradorArquivo {
	private int delay;
	
	public GeradorPropriedadesCriptografado(int delay) {
		this.delay = delay;
	}
	
	@Override
	protected byte[] processar(byte[] bytes) throws IOException {
		byte[] newBytes = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			newBytes[i] = (byte) ((bytes[i]+delay) % Byte.MAX_VALUE);
		}
		return newBytes;
	}//processar()

	@Override
	protected String gerarConteudo(Map<String, Object> propriedades) {
		StringBuilder propFileBuilder = new StringBuilder();
		for (String prop : propriedades.keySet()) {
			propFileBuilder.append(prop + "=" +propriedades.get(prop) + "\n");
		}
		return propFileBuilder.toString();
	}//gerarConteudo()

}//class GeradorPropriedadesCriptografado
