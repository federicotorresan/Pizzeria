import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Grafica {
	
	
	protected Shell shlPizzeriaTorregrando;
	private Text txtPizza;
	public Lista listino;
	private String Pizza;
	public int pizzeCoda = 0;
	Lista ls;
	public int num = 0;
	List listCoda;
	List listCucina;
	List listCotte;
	Display display;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Grafica window = new Grafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlPizzeriaTorregrando.open();
		shlPizzeriaTorregrando.layout();
		while (!shlPizzeriaTorregrando.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void aggiungiNuovoOrdine(String s) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				listCoda.add(s);				
			}
		});		
	}
	
	public void aggiungiNuovaCottura(String s) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				listCoda.remove(s);	
				listCucina.add(s);
				}
		});		
	}
	
	public void aggiungiNuovaPizzaPronta(String s) {
		display.asyncExec(new Runnable() {			
			@Override
			public void run() {
				listCucina.remove(s);		
				listCotte.add(s);
			}
		});		
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		listino= new Lista(this);//creato la lista
		
		shlPizzeriaTorregrando = new Shell();
		shlPizzeriaTorregrando.setSize(450, 345);
		shlPizzeriaTorregrando.setText("Pizzeria TorreGrando");
		
		listCoda = new List(shlPizzeriaTorregrando, SWT.BORDER);
		listCoda.setBounds(10, 170, 116, 85);
		
		listCucina = new List(shlPizzeriaTorregrando, SWT.BORDER);
		listCucina.setBounds(151, 170, 116, 85);
		
		listCotte = new List(shlPizzeriaTorregrando, SWT.BORDER);
		listCotte.setBounds(308, 170, 116, 85);
		
		Button btnApri = new Button(shlPizzeriaTorregrando, SWT.NONE);
		btnApri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Pizzeria aperta");
				Pizzaiolo pizzaiolo1 = new Pizzaiolo(listino);
				Pizzaiolo pizzaiolo2 = new Pizzaiolo(listino);
				Thread t1 = new Thread(pizzaiolo1);
				t1.setName("Pizzaiolo 1");
				t1.start();
				Thread t2 = new Thread(pizzaiolo2);
				t2.setName("Pizzaiolo 2");
				t2.start();
				num = 1;
			}
		});
		btnApri.setBounds(10, 21, 75, 25);
		btnApri.setText("Apri Pizzeria");
		
		Button btnChiudi = new Button(shlPizzeriaTorregrando, SWT.NONE);
		btnChiudi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				num = 0;
				System.out.println("Pizzeria chiusa");
			}
		});
		btnChiudi.setBounds(335, 275, 89, 25);
		btnChiudi.setText("Chiudi Pizzeria");
		
		Button btnCliente = new Button(shlPizzeriaTorregrando, SWT.NONE);
		btnCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (num == 1){
					Pizza = txtPizza.getText();
					if (Pizza.isEmpty()){
						JOptionPane.showMessageDialog(null, "Manca nome pizza", "ERRORE", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Cliente c = new Cliente(Pizza, listino);
						Thread ThreadCliente = new Thread(c);
						ThreadCliente.start();
						pizzeCoda++;	
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Apri pizzeria", "ERRORE", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCliente.setBounds(10, 101, 100, 25);
		btnCliente.setText("Ordina Pizza!");
		
		
		
		Label lblInserisci = new Label(shlPizzeriaTorregrando, SWT.NONE);
		lblInserisci.setBounds(10, 66, 125, 15);
		lblInserisci.setText("Inserisci la pizza:");
		
		txtPizza = new Text(shlPizzeriaTorregrando, SWT.BORDER);
		txtPizza.setBounds(151, 63, 170, 21);
		
		Label lblPizzeInCoda = new Label(shlPizzeriaTorregrando, SWT.NONE);
		lblPizzeInCoda.setBounds(10, 149, 75, 15);
		lblPizzeInCoda.setText("Pizze in coda");
		
		Label lblPizzeInCottura = new Label(shlPizzeriaTorregrando, SWT.NONE);
		lblPizzeInCottura.setBounds(151, 149, 89, 15);
		lblPizzeInCottura.setText("Pizze in cottura");
		
		Label lblPizzePronte = new Label(shlPizzeriaTorregrando, SWT.NONE);
		lblPizzePronte.setBounds(308, 149, 75, 15);
		lblPizzePronte.setText("Pizze pronte");

	}
}