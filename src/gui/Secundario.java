package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import apis.TasasPorDefecto;
import factores.DivisasPorDefecto;

import javax.swing.JList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Secundario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Object itemAnterior = null;
	private Boolean bloqueoDeEvento = false;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/tipo-de-cambio.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon wallpaper = new ImageIcon("src/imagenes/6256458.jpg");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HashMap<String, String> divisas = new HashMap<String, String>();
		
		divisas.put("SVC", "SVC - Colón Salvadoreño");
		divisas.put("USD", "USD - Dólar Estadounidense");
		divisas.put("EUR", "EUR - Euros");
		divisas.put("GBP", "GBP - Libras Esterlinas");
		divisas.put("JPY", "JPY - Yen Japonés");
		divisas.put("KRW", "KRW - Won Surcoreano");
		
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
		
		String[] opcionesDivisas = new String[]{"SVC Colón Salvadoreño",
												"USD Dólar Estadounidense",
									            "EUR Euros",
									            "GBP Libras Esterlinas",
									            "JPY Yen Japonés",
									            "KRW Won Sur Coreano"};
		
		JComboBox comboBox = new JComboBox(opcionesDivisas);
		
		comboBox.setBounds(10, 39, 277, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(opcionesDivisas);

		comboBox_1.setBounds(10, 212, 277, 38);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				escribirConversionEnTextField(comboBox, comboBox_1, textField, textField_1);
				
			}
		});
		
		
		//Evento cuando se cambia un elemento de la lista
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				
				if(ie.getStateChange() == ItemEvent.DESELECTED) {
					extracted(comboBox_1, comboBox, textField_1, textField, ie);
				}
				
				if(ie.getStateChange() == ItemEvent.SELECTED) {
					if (bloqueoDeEvento) {
						
						bloqueoDeEvento = false;
						
					}else {
						extracted(comboBox, comboBox_1, textField, textField_1, ie);
					}
				}
			}

		});
		

		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie2) {
				
				if(ie2.getStateChange() == ItemEvent.DESELECTED) {
					extracted(comboBox_1, comboBox, textField_1, textField, ie2);
				}
				
				if(ie2.getStateChange() == ItemEvent.SELECTED) {
					if (bloqueoDeEvento) {

						bloqueoDeEvento = false;
						
					}else {
						extracted(comboBox_1, comboBox, textField_1, textField, ie2);
					}
				}
			}
		});
		

		
		textField.setBounds(313, 39, 96, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				escribirConversionEnTextField(comboBox_1, comboBox, textField_1, textField);
			}
		});
		
		textField_1.setColumns(10);
		textField_1.setBounds(313, 212, 96, 38);
		contentPane.add(textField_1);

		//Divisas y valores al inicar la aplicacion
		comboBox.setSelectedIndex(0);  //indice 0 es divisa 'SVC'
		comboBox_1.setSelectedIndex(1);//indice 1 es divisa 'USD'
		
		//Colocar un colón salvadoreño al iniciar aplicación
		textField.setText("1");
		
		//Conversion de colon salvadoreño a dolar al iniciar aplicacion
		textField_1.setText(Conversion("SVC->USD", "1"));
		

		//ACTUALIZAR LOS VALORES DE TASAS DE CONVERSION
		/*
		HashMap<String, BigDecimal> actualizar = new HashMap<String, BigDecimal>();
		
		actualizar.put("SVC->GBP", new BigDecimal("1000"));
		
		tasasPorDefecto.setRates(actualizar);
		System.out.println(tasasPorDefecto.getRates().get("SVC->GBP"));
		*/
		
		esNumero(textField);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(-14, 0, 450, 273);
		contentPane.add(jLabel_Wallpaper);
		Icon iconoWallpaper = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
		jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT)); 
		jLabel_Wallpaper.setIcon(iconoWallpaper);

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
		String resultadoTexto = "";
		
		DivisasPorDefecto divisasPorDefecto = new DivisasPorDefecto();
		//tasaConversion= tasasPorDefecto.getRates().get("SVC->USD");
		tasaConversion= divisasPorDefecto.getRates().get(simbolosConversion);
		
		resultado = tasaConversion.multiply(valor);
		
		//Rendondeo de un numero despues de dos digitos despues de cero
		//Funcion para colocar decimales representativos y no mostrar 00 en
		//cantidad pequeñas
		//Resto extrae la parte decimal de una numero
		resultadoTexto = (resultado.remainder(new BigDecimal(1))).toString();
		
		Integer verificarCero=0;
		Integer posicionesRendonde=0;
		Boolean NoEsCero=false; 
		Integer dosNumerosDespuesDeCero=0;
		int i=2;
		while (i <resultadoTexto.length()) {

			posicionesRendonde++;
			
			verificarCero += Integer.valueOf(resultadoTexto.substring(i,i+1));
			
			if (verificarCero>0) {
				NoEsCero=true;
			}
			
			if (NoEsCero==true) {
				dosNumerosDespuesDeCero++;
			}
			
			if (dosNumerosDespuesDeCero==2) {
				break;
			}
			
			i++;
		}
	
		//Resultado final de redondeo a las posiciones de dos digitos despues de cero
		resultado = resultado.setScale(posicionesRendonde, RoundingMode.HALF_UP);
		//resultado = resultado.setScale(2, RoundingMode.HALF_UP);
		
		return resultado.toString();
	}
	
	private void extracted(JComboBox comboBox, JComboBox comboBox_1, JTextField textField, JTextField textField_1,  ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.DESELECTED){
		      //System.out.println("Previous item: " + ie.getItem()); //edit: bracket was missing
		      itemAnterior=ie.getItem();
		}else if(ie.getStateChange() == ItemEvent.SELECTED) {
			//System.out.println("Current New item: " + ie.getItem());
		    if (ie.getItem()==comboBox_1.getSelectedItem()) {
		    	//System.out.println("itemAnterior: "+itemAnterior);
		    	
		    	bloqueoDeEvento = true;  
	    		comboBox_1.setSelectedItem(itemAnterior);
	    		
		    }
		      
			escribirConversionEnTextField(comboBox, comboBox_1, textField, textField_1);
		}
	}

	private void escribirConversionEnTextField(JComboBox comboBox, JComboBox comboBox_1, JTextField textField, JTextField textField_1) {
		if (!textField.getText().isEmpty()) {

			String valor = textField.getText();
				
			if (Float.parseFloat(valor)>0){
				String divisaOrigen  = (String) comboBox.getSelectedItem();
				String divisaDestino = (String) comboBox_1.getSelectedItem();

				String simbolosConversion = 	divisaOrigen.substring(0,divisaOrigen.indexOf(" "))+"->"+
						  						divisaDestino.substring(0,divisaDestino.indexOf(" "));
				
				String resultado=Conversion(simbolosConversion,valor);
				textField_1.setText(resultado);
				
			}
		}else {
			textField_1.setText("");
		}
	}
}
