package empresa;

public class Dolar extends Moeda {
	double valor;
	Dolar(double valor) {
		valor = this.valor;
	}
	@Override
	public void info() {
		System.out.println("Dolar - " + valor);
	}
	@Override
	public double converter() {
		return this.valor*5.2;
	}

}
