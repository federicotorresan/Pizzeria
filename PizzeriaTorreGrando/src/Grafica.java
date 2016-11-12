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
	Lista ls = new Lista();
	public int num = 0;
	


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
		Display display = Display.getDefault();
		createContents();
		shlPizzeriaTorregrando.open();
		shlPizzeriaTorregrando.layout();
		while (!shlPizzeriaTorregrando.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		listino= new Lista();//creato la lista
		
		shlPizzeriaTorregrando = new Shell();
		shlPizzeriaTorregrando.setSize(450, 424);
		shlPizzeriaTorregrando.setText("Pizzeria TorreGrando");
		
		List listCoda = new List(shlPizzeriaTorregrando, SWT.BORDER);
		listCoda.setBounds(10, 170, 116, 159);
		
		List listCottura = new List(shlPizzeriaTorregrando, SWT.BORDER);
		listCottura.setBounds(151, 170, 116, 160);
		
		List listPronte = new List(shlPizzeriaTorregrando, SWT.BORDER);
		listPronte.setBounds(308, 170, 116, 159);
		
		Button btnApri = new Button(shlPizzeriaTorregrando, SWT.NONE);
		btnApri.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
			}
		});
		btnChiudi.setBounds(335, 351, 89, 25);
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
						
						listCoda.add(Pizza);
						pizzeCoda++;	
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Apri pizzeria", "ERRORE", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCliente.setBounds(10, 101, 100, 25);
		btnCliente.setText("Arriva cliente");
		
		
		
		Label lblInserisci = new Label(shlPizzeriaTorregrando, SWT.NONE);
		lblInserisci.setBounds(10, 66, 154, 15);
		lblInserisci.setText("Inserisci qui la tua pizza : ");
		
		txtPizza = new Text(shlPizzeriaTorregrando, SWT.BORDER);
		txtPizza.setBounds(177, 63, 170, 21);
		
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