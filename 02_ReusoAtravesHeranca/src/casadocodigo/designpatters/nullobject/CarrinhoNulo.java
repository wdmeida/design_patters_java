package casadocodigo.designpatters.nullobject;
/*
 * O padrão Null Object propõe a criação de uma classe para representar objetos nulos em uma aplicação.
 * Essa classe deve estender a classe original e implementar seus métodos de forma a executar o comportamento
 * esperado da aplicação quando um valor nulo for recebido. Dessa forma, em vez de se retornar um valor nulo,
 * retorna-se uma instância dessa nova classe.
 * 
 * A classe CarrinhoNulo apresentada na listagem a seguir exemplifica a criação de um Null Object para esse
 * contexto. Observe que os métodos retornam exatamente os valores que eram configurados para o caso do 
 * carrinho ser nulo. Nesse exemplo, apenas valores são retornados, porém em outros casos é preciso ter uma
 * lógica a ser executada dentro dos métodos.
 */
public class CarrinhoNulo extends Carrinho {
	public double getValor(){
		return 0.0;
	}
	
	public int getTamanho() {
		return 0;
	}
	
	public String getNomeUsuario(){
		return "<a href=login.jsp>Login</a>";
	}

}//class CarrinhoNulo
