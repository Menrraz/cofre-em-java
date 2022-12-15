package empresa;

public class Real extends Moeda {
	double valor;
	Real(double valor) {
		valor = this.valor;
	}
	@Override
	public void info() {
		System.out.println("Real - " + valor);
	}
	@Override
	public double converter() {
		return this.valor*1;
	}
}
