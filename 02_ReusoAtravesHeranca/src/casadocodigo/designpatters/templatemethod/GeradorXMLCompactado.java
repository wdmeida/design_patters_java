package casadocodigo.designpatters.templatemethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
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
public class GeradorXMLCompactado extends GeradorArquivo {
	
	@Override
	protected byte[] processar(byte[] bytes) throws IOException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ZipOutputStream out = new ZipOutputStream(byteOut);
		out.putNextEntry(new ZipEntry("internal"));
		out.write(bytes);
		out.closeEntry();
		out.close();
		return byteOut.toByteArray();
	}//processar()
	
	@Override
	protected String gerarConteudo(Map<String, Object> propriedades) {
		StringBuilder propFileBuilder = new StringBuilder();
		propFileBuilder.append("<properties>");
		for(String prop : propriedades.keySet()) {
			propFileBuilder.append("<" + prop + ">" + propriedades.get(prop) + "</" + prop + ">");
		}
		propFileBuilder.append("</properties>");
		return propFileBuilder.toString();
	}//gerarConteudo()

}//class GerardorXMLCompactado
