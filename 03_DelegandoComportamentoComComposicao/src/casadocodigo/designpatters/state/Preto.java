package casadocodigo.designpatters.state;

import java.util.List;

public class Preto extends Cor {

	@Override
	void assumiu(No no, List<No> list) {
		list.add(no);
	}
}
