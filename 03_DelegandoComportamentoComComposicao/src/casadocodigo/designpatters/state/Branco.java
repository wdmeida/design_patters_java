package casadocodigo.designpatters.state;

import java.util.List;

public class Branco extends Cor {

	@Override
	void busca(No no, List<No> list) {
		no.setCor(new Cinza(), list);
	}
}
