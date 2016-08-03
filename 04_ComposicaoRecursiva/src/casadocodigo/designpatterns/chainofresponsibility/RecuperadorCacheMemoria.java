package casadocodigo.designpatterns.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

/*
 * Cada subclasse de RecuperadorArquivo deve implementar o método recuperaArquivo() buscando o arquivo
 * em uma fonte diferente. Pela descrição do problema, as implementações irão buscar o arquivo no banco
 * de dados, de um cache em memória e de um servidor remoto. A listagem a seguir apresenta a classe que
 * faz a busca em um cache em memória para exemplificar como seria uma dessas implementações. O método
 * recuperaArquivo() verifica se existe o arquivo no mapa e retorna nulo caso não exista. Para armazenar
 * novos arquivos no mapa, o método chamarProximo() também é implementado para permitir que se tenha 
 * acesso ao arquivo retornado pelo próximo.
 */
public class RecuperadorCacheMemoria extends RecuperadorArquivo {
	private Map<String, Arquivo> cache = new HashMap<String, Arquivo>();
	
	public RecuperadorCacheMemoria(RecuperadorArquivo proximo){
		super(proximo);
	}
	
	@Override
	protected Arquivo recuperaArquivo(String nome) {
		return cache.containsKey(nome) ? cache.get(nome) : null;
	}
	
	protected Arquivo chamarProximo(String nome) {
		Arquivo a = super.chamarProximo(nome);
		cache.put(nome, a);
		return a;
	}

}
