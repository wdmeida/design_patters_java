package casadocodigo.designpatters.factorymethod;

import casadocodigo.designpatters.templatemethod.GeradorArquivo;

/*
 * A classe ServicoProduto, representa um exemplo de uma subclasse da classe ServicoAbstrato para a
 * entidade Produto. Observe que ela implementa o hook method definido e cria a instância do DAO relacionado
 * com a classe Produto. No exemplo, a instância é criada quando o primeiro acesso é feito ao método. Essa
 * classe pode possuir métodos específicos de protudo, porém os métodos herdados da superclasse que utilizam
 * o método getDAO() também poderão ser utilizados.
 */
public class ServicoProduto extends ServicoAbstrato<Produto>{
	private DAO<Produto> dao;
	
	public ServicoProduto(GeradorArquivo gerador) {
		super(gerador);
	}

	public DAO<Produto> getDAO() {
		if (dao == null) {
			dao = new ProdutoDAO();
		}
		return dao;
	}
	
	//Funcionalidade específica.
	public double getPrecoproduto(Object produtoId) {
		Produto p = getDAO().recuperarPorId(produtoId);
		return p.getPreco();
	}
}
