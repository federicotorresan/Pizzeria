import java.util.ArrayList;

public class Lista {
	ArrayList<String> pizzeOrdinate;
	ArrayList<String> pizzeCotte;
	ArrayList<String> pizzeInCoda;
	public Lista pizzePronte;
	private Grafica gr;

	// costruttore
	public Lista(Grafica gr) {
		pizzeInCoda = new ArrayList<String>();
		pizzeOrdinate = new ArrayList<String>();
		pizzeCotte = new ArrayList<String>();
		this.gr=gr;
	}

	// metodi
	public synchronized void ordinaPizza(String nome) {
		pizzeOrdinate.add(nome);
		System.out.println("Ho aggiunto una pizza");
		notifyAll();
		gr.aggiungiNuovoOrdine(nome);
	}

	public synchronized String pizzaInLista() {
		while (pizzeOrdinate.isEmpty()) { // true se è vuoto
			try {
				System.out.println("Attesa");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fine attesa");
		return pizzeOrdinate.remove(0);
	}

	public synchronized void pizzaPronta(String nome) {
		pizzeInCoda.add(nome);
		pizzeCotte.add(nome);
		notifyAll();
		System.out.println("La pizza: " + nome + " è pronta");
		gr.aggiungiNuovaCottura(nome);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void prelevaPizza(String nome) {
		while (!pizzeCotte.contains(nome)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pizzeInCoda.remove(nome);
		pizzeCotte.remove(nome);
		System.out.println("Il cliente ha prelevato la pizza: " + nome);
		gr.aggiungiNuovaPizzaPronta(nome);
	}

	public ArrayList<String> getOrdinazioniPizze() {
		return pizzeOrdinate;
	}

	public void setOrdinazioniPizze(ArrayList<String> ordinazioniPizze) {
		this.pizzeOrdinate = ordinazioniPizze;
	}

	public ArrayList<String> getPizzePronte() {
		return pizzeCotte;
	}

	public void setPizzePronte(ArrayList<String> pizzePronte) {
		this.pizzeCotte = pizzePronte;
	}
}