package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import apis.TasasPorDefecto;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		
		divisas.put("SVC", "SVC - Colón Salvadoreño");
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
	    
		
		HashMap<String, String> divisasParaApi = new HashMap<String, String>();
		
		String base = "";
		String simbolos = "";
		
		for (Map.Entry<String, String> entryPrimera : divisas.entrySet()) {
	        base = entryPrimera.getKey();
	        simbolos = "";
			for (Map.Entry<String, String> entrySegunda : divisas.entrySet()) {
				if (!(entryPrimera.getKey()==entrySegunda.getKey())){
					//System.out.println(entryPrimera.getKey()+"->"+entrySegunda.getKey());
					simbolos += entrySegunda.getKey()+",";
	
				}
			}
			simbolos = simbolos.substring(0, simbolos.length()-1);
			divisasParaApi.put(base, simbolos);
	    }
		System.out.println(divisasParaApi);
		
		
		
		String[] opcionesDivisas = new String[]{"SVC Colón Salvadoreño", "USD Dólar Estadounidense",
				"EUR Euros", "GBP Libras Esterlinas", "JPY Yen Japonés", "KRW Won Sur Coreano"};
		JComboBox comboBox = new JComboBox(opcionesDivisas);
		

		//cbPais = new JComboBox<String>(new String[]{"Argentina", "Brasil", "Chile", "Colombia", "México", "Perú", "Uruguay"});
		comboBox.setBounds(10, 39, 277, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(opcionesDivisas);
		comboBox_1.setBounds(10, 212, 277, 38);
		contentPane.add(comboBox_1);
		comboBox_1.setSelectedIndex(1);
		
//		final String divisaOrigen  = "";
//		final String divisaDestino = "";
//		final String simbolosConversion = "";
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!textField.getText().isEmpty()) {
					//Float valor = Float.parseFloat(textField.getText());
					String valor = textField.getText();
					if (Float.parseFloat(valor)>0){
						System.out.println(comboBox.getSelectedIndex());//INDICE DE LAS LISTA EL PRIMERO ES 0
						System.out.println(comboBox.getSelectedItem());//NOMBRE DE LA LISTA
						System.out.println(comboBox_1.getSelectedItem());
						String divisaOrigen  = (String) comboBox.getSelectedItem();
						String divisaDestino = (String) comboBox_1.getSelectedItem();
						String simbolosConversion = divisaOrigen.substring(0,3)+"->"+divisaDestino.substring(0,3);
						System.out.println(simbolosConversion);
						String resultado=Conversion(simbolosConversion,valor);
						
						textField_1.setText(resultado);
						
						//textField_1.setText(Float.toString((float) (valor*8.75)));
					}
				}else {
					textField_1.setText("");
				}
				
			}
		});
		
		
		//Evento cuando se cambia un elemento de la lista
		comboBox.addItemListener(new ItemListener() {
			Object itemAnterior = null;
			public void itemStateChanged(ItemEvent ie) {
				//System.out.println(comboBox.getSelectedItem());
				//System.out.println(arg0.getStateChange());
				//System.out.println(ItemEvent.DESELECTED);
				
				  if(ie.getStateChange() == ItemEvent.DESELECTED){
				      System.out.println("Previous item: " + ie.getItem()); //edit: bracket was missing
				      //System.out.println(comboBox.getSelectedIndex());
				      //System.out.println("ComboBox_1: "+comboBox_1.getSelectedItem());
//				      if (ie.getItem()==comboBox_1.getSelectedItem()) {
//				    	  comboBox_1.setSelectedItem(ie.getItem());
//				      }
				      itemAnterior=ie.getItem();
				   } else if(ie.getStateChange() == ItemEvent.SELECTED) {
				      System.out.println("Current New item: " + ie.getItem());
				      if (ie.getItem()==comboBox_1.getSelectedItem()) {
				    	  System.out.println("Aqui: "+itemAnterior);
				    	  comboBox_1.setSelectedItem(itemAnterior);
				      }
				      
					  if (!textField.getText().isEmpty()) {
							//Float valor = Float.parseFloat(textField.getText());
							String valor = textField.getText();
							if (Float.parseFloat(valor)>0){
								System.out.println(comboBox.getSelectedIndex());//INDICE DE LAS LISTA EL PRIMERO ES 0
								System.out.println(comboBox.getSelectedItem());//NOMBRE DE LA LISTA
								System.out.println(comboBox_1.getSelectedItem());
								String divisaOrigen  = (String) comboBox.getSelectedItem();
								String divisaDestino = (String) comboBox_1.getSelectedItem();
								String simbolosConversion = divisaOrigen.substring(0,3)+"->"+divisaDestino.substring(0,3);
								System.out.println(simbolosConversion);
								String resultado=Conversion(simbolosConversion,valor);
								textField_1.setText(resultado);
								
								//textField_1.setText(Float.toString((float) (valor*8.75)));
							}
						}else {
							textField_1.setText("");
						}
				   }
				
				
//				if (ItemEvent.ITEM_LAST==comboBox.getSelectedIndex()) {
//					comboBox_1.setSelectedIndex(ItemEvent.ITEM_LAST);
//				}
				/*
				if (!textField.getText().isEmpty()) {
					//Float valor = Float.parseFloat(textField.getText());
					String valor = textField.getText();
					if (Float.parseFloat(valor)>0){
						System.out.println(comboBox.getSelectedIndex());//INDICE DE LAS LISTA EL PRIMERO ES 0
						System.out.println(comboBox.getSelectedItem());//NOMBRE DE LA LISTA
						System.out.println(comboBox_1.getSelectedItem());
						String divisaOrigen  = (String) comboBox.getSelectedItem();
						String divisaDestino = (String) comboBox_1.getSelectedItem();
						String simbolosConversion = divisaOrigen.substring(0,3)+"->"+divisaDestino.substring(0,3);
						System.out.println(simbolosConversion);
						String resultado=Conversion(simbolosConversion,valor);
						textField_1.setText(resultado);
						
						//textField_1.setText(Float.toString((float) (valor*8.75)));
					}
				}else {
					textField_1.setText("");
				}
				*/
				
			}
		});
		
		
		//valor de un color al iniciar de aplicacion
		textField.setText("1");
		
		textField.setBounds(313, 39, 96, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 212, 96, 38);
		contentPane.add(textField_1);

		//conversion a dolar al iniciar aplicacion
		TasasPorDefecto tasasPorDefecto = new TasasPorDefecto();
		BigDecimal valorDolar = tasasPorDefecto.getRates().get("SVC->USD");
		textField_1.setText(valorDolar.toString());

		//ACTUALIZAR LOS VALORES DE TASAS DE CONVERSION
		/*
		HashMap<String, BigDecimal> actualizar = new HashMap<String, BigDecimal>();
		
		actualizar.put("SVC->GBP", new BigDecimal("1000"));
		
		tasasPorDefecto.setRates(actualizar);
		System.out.println(tasasPorDefecto.getRates().get("SVC->GBP"));
		*/
		
		
		
		
		esNumero(textField);

	}

	private void esNumero(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (a.getText().length() == 0 && c == '.') {
					e.consume();
				} else {
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
	
	
	private String Conversion(String simbolosConversion, String monto) {
		BigDecimal tasaConversion = new BigDecimal("0");
		BigDecimal valor = new BigDecimal(monto);
		BigDecimal resultado = new BigDecimal("0");
		
		TasasPorDefecto tasasPorDefecto = new TasasPorDefecto();
		//tasaConversion= tasasPorDefecto.getRates().get("SVC->USD");
		tasaConversion= tasasPorDefecto.getRates().get(simbolosConversion);
		
		System.out.println(tasaConversion);
		System.out.println(monto);
		resultado = tasaConversion.multiply(valor);
		resultado = resultado.setScale(2, RoundingMode.HALF_UP);
		
		return resultado.toString();
	}
}
