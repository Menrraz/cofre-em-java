package empresa;

public class Euro extends Moeda {
	double valor;
	Euro(double valor) {
		valor = this.valor;
	}
	@Override
	public void info() {
		System.out.println("Euro - " + valor);
	}
	@Override
	public double converter() {
		return this.valor*5.18;
	}
}
