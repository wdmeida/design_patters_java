package casadocodigo.designpatters.factorymethod;

import java.util.List;
/*
 * A inteface DAO define os métodos gerais de acesso a dados que serão disponibilizados, como
 * para recuperação, gravação e exclusão de entidades. Essa interface precisará ser implementada
 * para cada entidade do sistema, para a criação dessas operações de cada uma. Note que a interface 
 * pussui um parâmetro genérico que é utilizado para determinar a entidade associada ao DAO e para
 * que essa entidade seja utilizada nos parâmetros e retornos dos métodos, variando de acordo com
 * que for setado na implementação.
 */
public interface DAO<E> {
	public E recuperarPorId(Object id);
	public void salvar(E entidade);
	public void excluir(Object id);
	public List<E> listarTodos();
}
