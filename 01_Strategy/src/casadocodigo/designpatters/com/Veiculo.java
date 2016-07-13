package casadocodigo.designpatters.com;

public class Veiculo {
	private String placa;
	private String modelo;
	
	public Veiculo(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}//class Veiculo 
