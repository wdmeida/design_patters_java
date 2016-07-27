package casadocodigo.designpatters.templatemethod;

/*
 * Para evitar a redundância de código, caso o cliente queira uma implementação que faça a compactação 
 * do arquivo e a criptografia, a implementação de uma variabilidade sera separada em uma outra classe.
 * Arquivo. Dessa forma, o método implementado nessa hierarquia de classes à parte será invocado como
 * parte da implementação do algoritmo.
 * O método processar() não está mais na mesma classe e sim na instância de PosProcessador que compões
 * GeradorArquivo. Dessa forma, qualquer implementação dessa interface pode ser utilizada para realizar o
 * pós-processamento do arquivo. A grande motivação dessa solução no cenário apresentado é que o processador
 * pode ser configurado independente da subclasse que está sendo utilizada, permitindo às duas variar de forma
 * independente.
 */
public interface PosProcessador {
	public byte[] processar(byte[] bytes);
}
