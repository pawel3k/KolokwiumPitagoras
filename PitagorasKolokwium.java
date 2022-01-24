import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KolokwiumPitagoras extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField wartosc_a = new JTextField("Podaj wartość przyprostokątnej (a)");
	JTextField wartosc_b = new JTextField("Podaj wartość przyprostokątnej (b)");
	JTextField wartosc_c = new JTextField("Podaj wartość przeciwprostokątnej (c)");
	JButton oblicz = new JButton("Oblicz!");
	
	public double Liczba_a;
	public double Liczba_b;
	public double Liczba_c;
	
	public JPanel mojPanel = new JPanel();
	public JPanel paneldoRys = new JPanel();
	
	public double getLiczba_a() {
		return Liczba_a;
	}

	public double getLiczbaB() {
		return Liczba_b;
	}

	public double getLiczbaC() {
		return Liczba_c;
	}

	public static void main(String[] args) {
		KolokwiumPitagoras frame = new KolokwiumPitagoras();
		frame.initUI();
	}

	private void initUI() {
		this.setLayout(new BorderLayout());
		
		mojPanel.add(wartosc_a);
		wartosc_a.setColumns(20);
		mojPanel.add(wartosc_b);
		wartosc_a.setColumns(20);
		mojPanel.add(wartosc_c);
		wartosc_a.setColumns(20);
		mojPanel.add(oblicz);
		oblicz.addActionListener(this);
		
		this.add(mojPanel, BorderLayout.NORTH);
	
		this.add(paneldoRys, BorderLayout.CENTER);
		
		
		this.setLayout(new GridLayout(4, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setTitle("Pitagoras");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(oblicz.equals(e.getSource())) {
			obliczanie();
		}
		
	}

	private void obliczanie() {
		try {
			
		boolean puste_a = wartosc_a.getText().isBlank();
		boolean puste_b = wartosc_b.getText().isBlank();
		boolean puste_c = wartosc_c.getText().isBlank();
		
		if((puste_a && puste_b && puste_c) || (puste_a && puste_b) || (puste_b && puste_c) || (puste_a && puste_c)) {
			JOptionPane.showMessageDialog(null, "Wprowadz brakujące dane!", "ALERT", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (!puste_a && !puste_b && !puste_c) {
			JOptionPane.showMessageDialog(null, "Zostaw jedno pole puste!", "ALERT", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(puste_a && (!puste_b && !puste_c)) {
			 Liczba_b = Double.parseDouble(wartosc_b.getText());
			 Liczba_c = Double.parseDouble(wartosc_c.getText());
			 
			 Liczba_a = Math.sqrt(Math.pow(Liczba_c, 2) - Math.pow(Liczba_a, 2));
			 wartosc_a.setText(String.valueOf(Liczba_a));
		}
		
		else if(puste_b && (!puste_a && !puste_c)) {
			 Liczba_a = Double.parseDouble(wartosc_a.getText());
			 Liczba_c = Double.parseDouble(wartosc_c.getText());
			 
			 Liczba_b = Math.sqrt(Math.pow(Liczba_c, 2) - Math.pow(Liczba_a, 2));
			 wartosc_b.setText(String.valueOf(Liczba_b));
		}
		
		else if (puste_c && (!puste_a && !puste_b)) {
			Liczba_a = Double.parseDouble(wartosc_a.getText());
			Liczba_b = Double.parseDouble(wartosc_b.getText());
			
			Liczba_c = Math.sqrt(Math.pow(Liczba_a, 2) + Math.pow(Liczba_b, 2));
			wartosc_c.setText(String.valueOf(Liczba_c));
			
		}
	}	catch (Exception e1) {
		System.out.println("Podaj poprawne liczby.");
		
	}
		
		repaint();
		
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.BLACK);
		
		g2.draw(new Line2D.Double(400, 400, 400 - Liczba_a*20, 400)); //przyprostokatna
		g2.draw(new Line2D.Double(400, 400, 400, 400 - Liczba_b*20)); //przyprostokatna
		g2.draw(new Line2D.Double(400- Liczba_a*20, 400, 400 , 400 - Liczba_b*20)); //przeciwprostokatna
	}

}
