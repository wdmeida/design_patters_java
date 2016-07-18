package casadocodigo.designpatters.nullobject;

import javax.servlet.http.HttpServletRequest;

/*
 * O código ao utilizar o Null Object fica mais simples com a eliminação da parte responsável pelo
 * tratamento dos valores nulos. Outra coisa que precisa ser alterada é a própria classe CookieFactory
 * que deve retornar uma instância de CarrinhoNulo em vez de null quando nenhum carrinho do usuário
 * for encontrado.
 */
public class ApresentacaoCarrinho {
	public void colocarInformacoesCarrinho(HttpServletRequest request) {
		Carrinho c = CookieFactory.criarCarrinho(request);
		
		request.setAttribute("valor", c.getValor());
		request.setAttribute("qtd", c.getTamanho());
		
		if (request.getAttribute("username") == null) {
			request.setAttribute("userCarrinho", c.getNomeUsuario());
		} else {
			request.setAttribute("userCarrinho", request.getAttribute("username"));
		}
	}
}
