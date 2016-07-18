package casadocodigo.designpatters.nullobject;

import javax.servlet.http.HttpServletRequest;

public class CookieFactory {
	public static Carrinho criarCarrinho(HttpServletRequest request){
		//Cria o objeto com os dados do carrinho ....
		return new Carrinho();
	}
}
