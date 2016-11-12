
public class Pizzaiolo extends Thread {
	
	Lista listino;
	String pizza;
	int tempo;
	
	public Pizzaiolo(Lista listino){
		this.listino=listino;
	}
	
	public synchronized void run(){
		if(listino.pizzeInCoda.isEmpty()==false){
			pizza=listino.pizzeInCoda.get(0);
		}
		switch(pizza){
		case "Margherita":
			tempo=4000;
			break;
		case "Diavola":
			tempo=5000;
			break;
		case "Prosciutto e funghi":
			tempo=6000;
			break;
		case "Quattro formaggi":
			tempo=5500;
			break;	
		case "Quattro stagioni":
			tempo=5000;
			break;	
		}
		
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notifyAll();
	}

}
