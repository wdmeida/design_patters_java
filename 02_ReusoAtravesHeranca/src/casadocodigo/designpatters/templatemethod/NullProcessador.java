package casadocodigo.designpatters.templatemethod;

public class NullProcessador implements PosProcessador {

	@Override
	public byte[] processar(byte[] bytes) {
		return bytes;
	}

}
