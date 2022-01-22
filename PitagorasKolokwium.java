import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PitagorasKolokwium  extends JFrame implements ActionListener{
	
	JTextField pole_a;
	JTextField pole_b;
	JTextField pole_c;
	
	JButton wylicz;

	public static void main(String[] args) {
		PitagorasKolokwium frame = new PitagorasKolokwium();
		frame.initUI();

	}
	
	public void initUI() {
		
	pole_a = new JTextField();
	pole_b = new JTextField();	
	pole_c = new JTextField();
	
	wylicz = new JButton("Wylicz!");
	wylicz.addActionListener(this);
	
	this.add(pole_a);
	this.add(pole_b);
	this.add(pole_c);
	this.add(wylicz);
	
	this.setLayout(new GridLayout(4, 1));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setSize(500, 500);
	this.setVisible(true);
	
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(wylicz.equals(e.getSource())) {
			wylicz();
		}
		
	}


	private void wylicz() {	  // Tu coœ chyba nie dzia³a, jak znajdziesz co to jesteœ kotem !
		
		pole_a.setText("Podaj dwie d³ugoœci: ");
		pole_b.setText("Podaj dwie d³ugoœci: ");
		pole_c.setText("Podaj dwie d³ugoœci: ");
		
		String przyprostokatna1 = pole_a.getText();
		double przyprostokatnaLiczba1 = Double.parseDouble(przyprostokatna1);
		
		String przyprostokatna2 = pole_b.getText();
		double przyprostokatnaLiczba2 = Double.parseDouble(przyprostokatna2);
		
		String przeciwprostokatna = pole_c.getText();
		double przeciwprostokatnaLiczba = Double.parseDouble(przeciwprostokatna);
		
		if(pole_a.getText().isBlank()) {
			
			double wynik = Math.sqrt(Math.pow(przeciwprostokatnaLiczba, 2) - Math.pow(przyprostokatnaLiczba2, 2));
			pole_a.setText(String.valueOf(wynik));
			
		}
		
		else if(pole_b.getText().isBlank()) {
			
			double wynik = Math.sqrt(Math.pow(przeciwprostokatnaLiczba, 2) - Math.pow(przyprostokatnaLiczba1, 2));
			pole_a.setText(String.valueOf(wynik));
		
		}
		
		else if (pole_c.getText().isBlank()) {
			
			double wynik = Math.sqrt(Math.pow(przyprostokatnaLiczba1, 2) + Math.pow(przyprostokatnaLiczba2, 2));
			pole_c.setText(String.valueOf(wynik));
			
		}
	}

}
