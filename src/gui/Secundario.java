package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Secundario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secundario frame = new Secundario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Secundario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//	      - Convertir de la moneda de tu país a Dólar
//	      - Convertir de la moneda de tu país  a Euros
//	      - Convertir de la moneda de tu país  a Libras Esterlinas
//	      - Convertir de la moneda de tu país  a Yen Japonés
//	      - Convertir de la moneda de tu país  a Won sul-coreano
	      
	    
		/*
		{
			"SLV": "SLV - Colón Salvadoreño", 
			"USD": "USD - Dólar Estadounidense",
			"EUR": "EUR - Euros",
			"GBP": "GBP - Libras Esterlinas",
			"JPY": "JPY - Yen Japonés",
			"KRW": "KRW - Won Surcoreano"
		}
		*/
		
		HashMap<String, String> divisas = new HashMap<String, String>();
		
		divisas.put("SLV", "SLV - Colón Salvadoreño");
		divisas.put("USD", "USD - Dólar Estadounidense");
		divisas.put("EUR", "EUR - Euros");
		divisas.put("GBP", "GBP - Libras Esterlinas");
		divisas.put("JPY", "JPY - Yen Japonés");
		divisas.put("KRW", "KRW - Won Surcoreano");
		
//		SLV->USD 1 - 0.11
//		SLV->EUR 1 - 0.10
//		SLV->GBP 1 - 0.092
//		SLV->JPY 1 - 15.29
//		SLV->KRW 1 - 152.03
		
//		USD->SLV 1 - 8.75
//		EUR->SLV 1 - 9.61
//		GBP->SLV 1 - 10.86
//		JPY->SLV 1 - 0.065
//		KRW->SLV 1 - 1 - 0.0066
		
		//BigDecimal cambios = new BigDecimal(0);

		//divisas.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		
		/*
	    for (String keyBase : divisas.keySet()) {
	        for (String keyResultado : divisas.keySet()) {
	        	if (!(keyBase == keyResultado)){
	        		System.out.println(keyBase + "->" + keyResultado);
	        	}
	        	
	        }
	    }
	    */
	    
		for (Map.Entry<String, String> entryPrimera : divisas.entrySet()) {
	        //System.out.println(entry.getKey() + " = " + entry.getValue());
			for (Map.Entry<String, String> entrySegunda : divisas.entrySet()) {
				if (!(entryPrimera.getKey()==entrySegunda.getKey())){
					System.out.println(entryPrimera.getKey()+"->"+entrySegunda.getKey());
				}
			}
	    }
	    
		
		
		
		String[] opcionesDivisas = new String[]{"Colón Salvadoreño", "Dólar Estadounidense",
				"EUR Euros", "GBP Libras Esterlinas", "JPY Yen Japonés", "KRW Won Sur Coreano"};
		JComboBox comboBox = new JComboBox(opcionesDivisas);
		//cbPais = new JComboBox<String>(new String[]{"Argentina", "Brasil", "Chile", "Colombia", "México", "Perú", "Uruguay"});
		comboBox.setBounds(10, 50, 277, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(opcionesDivisas);
		comboBox_1.setBounds(10, 133, 277, 38);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!textField.getText().isEmpty()) {
					Float valor = Float. parseFloat(textField.getText());
					if (valor>0){
						System.out.println(comboBox.getSelectedIndex());
						textField_1.setText(Float.toString((float) (valor*8.75)));
					}
				}else {
					textField_1.setText("");
				}
				
			}
		});

		textField.setText("1");
		

		textField.setBounds(313, 50, 96, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 133, 96, 38);
		contentPane.add(textField_1);
		
		esNumero(textField);

	}
	
	private void esNumero(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (a.getText().length() == 0 && c == '.'){
					e.consume();
				}else {
					if (!Character.isDigit(c) && c != '.') {
						e.consume();
					}
					if (c == '.' && a.getText().contains(".")) {
						e.consume();
					}
				}
			}
		});
	}
}
