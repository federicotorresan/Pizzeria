import java.util.ArrayList;

public class Lista {
	ArrayList<String> pizzeOrdinate;
	ArrayList<String> pizzeCotte;
	ArrayList<String> pizzeInCoda;
	public Lista pizzePronte;

	// costruttore
	public Lista() {
		pizzeInCoda = new ArrayList<String>();
		pizzeOrdinate = new ArrayList<String>();
		pizzeCotte = new ArrayList<String>();
	}

	// metodi
	public synchronized void ordinaPizza(String NomePizza) {
		pizzeOrdinate.add(NomePizza);
		System.out.println("ho aggiunto una pizza al vettore ordinazione pizze");
		notifyAll();
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

	public synchronized void pizzaPronta(String NomePizza) {
		pizzeInCoda.add(NomePizza);
		pizzeCotte.add(NomePizza);
		notifyAll();
		System.out.println("La pizza : " + NomePizza + " è pronta");

	}

	public synchronized void prelevaPizza(String NomePizza) {
		while (!pizzeCotte.contains(NomePizza)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pizzeInCoda.remove(NomePizza);
		pizzeCotte.remove(NomePizza);
		System.out.println("Ho prelevato la pizza " + NomePizza);
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