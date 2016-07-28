package casadocodigo.designpatters.state;

import java.util.ArrayList;
import java.util.List;

/*
 * Nesse algoritmo, diversas ações dependem do estado do nó, como se ele deve ser adicionado na lista
 * ou se os nós adjacentes devem ser processados. Apesar disso, observe que nenhum comando condicional
 * foi utilizado na implementação.
 */
public class BuscaProfundidadeApp {
	public static void main(String[] args) {
		No a = new No("A"), b = new No("B"), c = new No("C"), d = new No("D"),
		   e = new No("E"), f = new No("F"), g = new No("G"), h = new No("H");
		
		a.addAdjacentes(b); 	b.addAdjacentes(c);
		c.addAdjacentes(d);		d.addAdjacentes(b);
		a.addAdjacentes(e); 	e.addAdjacentes(f);
		f.addAdjacentes(c); 	f.addAdjacentes(g);
		f.addAdjacentes(h);		a.addAdjacentes(h);
		
		List<No> l = new ArrayList<>();
		a.buscaProfundidade(l);
		
		for(No n : l) System.out.println(n);
	}//main()
}
