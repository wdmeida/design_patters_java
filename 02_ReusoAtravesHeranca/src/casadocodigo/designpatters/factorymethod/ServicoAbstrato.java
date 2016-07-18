package casadocodigo.designpatters.factorymethod;
/*
 * A classe ServicoAbstrato representa uma classe da camada de negócios que contém serviços relacionados
 * a uma entidade. Para prover sua funcionalidade, ela precisa da colaboração do DAO relacionado a mesma
 * entidade. Essa classe possui métodos com serviços gerais que são providos a todas as entidades. Um
 * exemplo é o método gravarEntidadeEmArquivo(), que recupera uma entidade a partir de seu identificador
 * e chama a instância de GeradorArquivo (aquela classe criada anteriormente nesse capítulo) para criação
 * de um arquivo com as propriedades da classe. Essas propriedades são obtidas através do método getMapa()
 * definido para o tipo Entidade. Vale ressaltar que qualquer subclasse de GeradorArquivo pode ser utilizada,
 * pois ela é passada no construtur da classe.
 * 
 * A grade questão é que os métodos gerais dessa classe abstrata precisam acessar o DAO para executar sua
 * funcionalidade, porém qual será a instância é algo que só será definido na subclasse, quando a entidade
 * com a qual se trabalha já terá sido definida. Dessa forma, a classe definiu um método abstrato chamado
 * getDAO(), que retorna a instância do DAO para ser utilizada. Assim, as subclasses devem implementar esse
 * método de forma a retornar a instância correta. Esse é um hook method com o objetivo de criar um objeto.
 */

import java.io.IOException;

import casadocodigo.designpatters.templatemethod.Entidade;
import casadocodigo.designpatters.templatemethod.GeradorArquivo;

public abstract class ServicoAbstrato<E> {
	public GeradorArquivo gerador;

	public ServicoAbstrato(GeradorArquivo gerador) {
		this.gerador = gerador;
	}
	
	public abstract DAO<E> getDAO();
	
	//Serviço geral
	public void gravarEntidadeEmArquivo(Object id, String nomeArquivo) throws IOException{
		E entidade = getDAO().recuperarPorId(id);
		gerador.gerarArquivo(nomeArquivo, 
							((Entidade)entidade).getMapa());
	}
}//class ServicoAbstrato
