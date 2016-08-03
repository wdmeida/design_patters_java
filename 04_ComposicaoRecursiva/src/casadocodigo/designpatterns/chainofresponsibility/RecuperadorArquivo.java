package casadocodigo.designpatterns.chainofresponsibility;

/*
 * Para ficar mais concreto o entendimento do padrão, imagine que um arquivo, como uma lista de
 * certificados digitais revogados, é atualizado de forma periódica em um servidor remoto, contendo
 * a data em que sua validade é expirada. Para tornar recuperações frequentes mais eficientes a 
 * aplicação criou dois tipos de cache, sendo um em memória e outro na base de dados. Dessa forma, 
 * primeiro verifica-se se existe um arquivo válido em memória, em seguida no banco de dados e 
 * somente então, se não for encontrado, o arquivo é recuperado do servidor remoto.
 * 
 * Em uma implementação tradicional, toda essa lógica seria implementada na mesma classe, com diversos
 * condicionais em sequência para verificar se uma determinada estratégia seria adequada para recuperação
 * do arquivo. Utilizando o padrão Chain of Responsibility, cada possibilidade é implementada em uma classe
 * diferente, as quais são encadeadas em um fluxo de execução. Cada uma delas verifica se o arquivo existe
 * e é válido, retornando o mesmo em caso positivo e delegando a execução para a próxima instância da cadeia
 * em caso negativo.
 * 
 * Para implementarmos essa sequência de execução, o primeiro passo é definirmos uma superclasse que define
 * um elemento da cadeia. A classe RecuperadorArquivo, possui um atributo do seu mesmo tipo chamado proximo
 * que representa o próximo elemento. Essa classe também define um método abstrato chamado recuperarArquivo()
 * que é um hook method que deve ser implementado pelas subclasses para a recuperação do arquivo de acordo
 * com a estratégia desejada. Além disso, o método chamarProximo() é responsável por verificar se existe um
 * próximo elemento e invocà-lo. Adicionalmente, o método recuperar() tenta recuperar o arquivo, retornando-o
 * se ele for válido e chamando o próximo elemento da cadeia em caso negativo.
 */
public abstract class RecuperadorArquivo {
	private RecuperadorArquivo proximo;

	public RecuperadorArquivo(RecuperadorArquivo proximo) {
		this.proximo = proximo;
	}
	
	public Arquivo recuperar(String nome) {
		Arquivo a = recuperaArquivo(nome);
		if(a == null || !a.isValido())
			return chamarProximo(nome);
		else
			return a;
	}
	
	protected Arquivo chamarProximo(String nome) {
		if(proximo == null)
			throw new RuntimeException("Não foi possível recuperar o arquivo");
		return proximo.recuperar(nome);
	}
	
	protected abstract Arquivo recuperaArquivo(String nome);
}//class RecuperadorArquivo
