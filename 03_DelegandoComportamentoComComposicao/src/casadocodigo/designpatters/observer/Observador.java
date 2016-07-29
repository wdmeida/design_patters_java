package casadocodigo.designpatters.observer;

/*
 * O exemplo que será abordado para o design pattern Observer será um objeto que representa uma
 * carteira de ações. Essa carteria possui um mapa com os códigos das ações e sua respectiva
 * quantidade. De acordo com as ações do usuário ou com gatilhos configurados na aplicação, ações
 * podem ser compradas ou vendidas alterando sua quantidade. A questão é que existem diversas classes
 * interessadas em saber quando uma informação é alterada nessa classe para poder executar sua lógica.
 * Por exemplo, um componente que exibe um gráfico com a quantidade de cada ação da carteira precisa
 * saber quando houve uma mudança para ser atualizado. Outro exemplo seria um componente que fizesse um
 * log das alterações realizadas. Poderia também existir um componente para fazer a auditoria dos dados.
 * 
 * Caso as notificações sejam feitas individualmente para cada necessidade, a classe que representa a
 * carteria de ações ficaria acoplada às classes que precissaria notificar. Isso não é desejável. Além 
 * de dificultar mudanças nas classes envolvidas, tornaria complicado a adição de novas classes interessadas
 * em mudanças nesssas informações.
 * 
 * Para resolver esse problema, o padrão Observer será implementado na solução. Será criada uma interface
 * Observador, a qual deve ser implementada pelas classes que desejam receber os eventos de mudança na
 * quantidade das ações. Implementações dessa inteface poderão ser registradas na classe CarteiraAcoes, 
 * cuja listagem também está apresentada, através do método addObservador(). Dessa forma, todos os 
 * observadores registrados receberão uma notificação quando uma mudança for realizada. Observe que o
 * método notificar() chama o método mudancaQuantidade() da interface Observador em todas as intâncias
 * registradas.
 */
public interface Observador {
	void mudancaQuantidade(String acao, Integer qtd);
}
