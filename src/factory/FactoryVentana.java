package factory;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import factores.DivisasPorDefecto;

import javax.swing.JList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

public class FactoryVentana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Object itemAnterior = null;
	private Boolean bloqueoDeEvento = false;
	private LinkedHashMap<String, BigDecimal> rates;

	public FactoryVentana(String titulo, LinkedHashMap<String, String> detallesDeFactores,
			LinkedHashMap<String, BigDecimal> rates) {
		this.rates=rates;
		setResizable(false);
		setTitle(titulo);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/tipo-de-cambio.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ImageIcon wallpaper = new ImageIcon("src/imagenes/6256458.jpg");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Convertir LinkedHashMap to array para items de comboBox
		String[] itemsComboBox = new String[detallesDeFactores.size()];
		detallesDeFactores.values().toArray(itemsComboBox);
		
		JComboBox comboBox = new JComboBox(itemsComboBox);
		comboBox.setName("comboBox");
		
		comboBox.setBounds(10, 39, 277, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(itemsComboBox);
		comboBox_1.setName("comboBox_1");		

		comboBox_1.setBounds(10, 212, 277, 38);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (!(textField.getText().length() == 1 && textField.getText().equals("-"))) {
					escribirConversionEnTextField(comboBox, comboBox_1, textField, textField_1);
				}
				
			}
		});
		
		//Evento cuando se cambia un elemento de la lista
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				cambiarItem(comboBox, comboBox_1, textField, textField_1, ie);
			}
		});

		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie2) {
				cambiarItem(comboBox_1, comboBox, textField_1, textField, ie2);
			}
		});
		
		textField.setBounds(313, 39, 96, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (!(textField_1.getText().length() == 1 && textField_1.getText().equals("-"))) {
					escribirConversionEnTextField(comboBox_1, comboBox, textField_1, textField);
				}
			}
		});
		
		textField_1.setColumns(10);
		textField_1.setBounds(313, 212, 96, 38);
		contentPane.add(textField_1);

		//Valores al inicar la aplicacion
		comboBox.setSelectedIndex(0);  //indice 0 en divisa es 'SVC'
		comboBox_1.setSelectedIndex(1);//indice 1 en divisa es 'USD'
		
		//En divisas se coloca un colón salvadoreño al iniciar aplicación
		textField.setText("1");
		
		//En divisas Conversion de colon salvadoreño a dolar al iniciar aplicacion
		escribirConversionEnTextField(comboBox, comboBox_1, textField, textField_1);
		
		esNumero(textField);
		esNumero(textField_1);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(-14, 0, 450, 273);
		contentPane.add(jLabel_Wallpaper);
		Icon iconoWallpaper = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
		jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT)); 
		jLabel_Wallpaper.setIcon(iconoWallpaper);

	}

	public void esNumero(JTextField a) {
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
	
    public static boolean isNumeric(String s)
    {
        if (s == null || s.equals("")) {
            return false;
        }
        return true;
    }
    
    String EliminarNotacionCientifica(double numero) {
        String d = "####################################";
        return new DecimalFormat("#." + d + d + d).format(numero);
    }
    
    String EliminarNotacionCientificaBigDecimal(BigDecimal numero) {
    	String d = "####################################";
    	return new DecimalFormat("#." + d + d + d).format(numero);
    }
	
	public String Conversion(String simbolosConversion, String monto) {
		BigDecimal tasaConversion = new BigDecimal("0");
		BigDecimal valor = new BigDecimal(monto);
		BigDecimal resultado = new BigDecimal("0");
		String resultadoTexto = "";
		
		//tasaConversion= tasasPorDefecto.getRates().get("SVC->USD");
		tasaConversion= rates.get(simbolosConversion);
		
		resultado = tasaConversion.multiply(valor);
		
		//Rendondeo de un numero despues de dos digitos despues de cero
		//Funcion para colocar decimales representativos y no mostrar 00 en
		//cantidad pequeñas
		//Resto extrae la parte decimal de una numero
		//resultadoTexto = (resultado.remainder(new BigDecimal(1))).toString();
		
		resultadoTexto = EliminarNotacionCientificaBigDecimal(resultado.remainder(new BigDecimal(1)));
		
		BigDecimal verificarCero = new BigDecimal("0");
		BigDecimal posicionesRedondeo = new BigDecimal("0");;
		Boolean NoEsCero=false; 
		BigDecimal dosNumerosDespuesDeCero = new BigDecimal("0");
		
		
		int i;
		if (resultadoTexto.substring(0, 1).equals("-")) {
			i=3;
		}else {
			i=2;
		}
		
		while (i <resultadoTexto.length()) {

			//posicionesRedondeo++;
			posicionesRedondeo = posicionesRedondeo.add(new BigDecimal("1"));
			
			verificarCero = verificarCero.add(new BigDecimal(resultadoTexto.substring(i,i+1)));
			
			if (verificarCero.compareTo(new BigDecimal("0"))==1) {//1 se utiliza en BigDecimal para mayor que
				NoEsCero=true;
			}
			
			if (NoEsCero==true) {
				dosNumerosDespuesDeCero = dosNumerosDespuesDeCero.add(new BigDecimal("1"));
			}
			
			if (dosNumerosDespuesDeCero.compareTo(new BigDecimal("2"))==0) {//0 se utiliza en BigDecimal para igual
				break;
			}
			
			i++;
		}


		//Finalmente si todos los numeros son 0 despues del punto decimal
		//se colocará 2 posiciones decimales
		if (dosNumerosDespuesDeCero.compareTo(new BigDecimal("0"))==0) {
			posicionesRedondeo = new BigDecimal("2");
		}
		
		//Resultado final de redondeo a las posiciones de dos digitos despues de cero
		resultado = resultado.setScale(posicionesRedondeo.intValue(), RoundingMode.HALF_UP);
		
		return EliminarNotacionCientificaBigDecimal(resultado);
	}

	private void cambiarItem(JComboBox comboBox, JComboBox comboBox_1, JTextField textField, JTextField textField_1,  ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.DESELECTED){
		      
			itemAnterior=ie.getItem();
		      
		}else if(ie.getStateChange() == ItemEvent.SELECTED) {

			if (ie.getItem()==comboBox_1.getSelectedItem()) {

		    	bloqueoDeEvento = true; 
	    		comboBox_1.setSelectedItem(itemAnterior);
	    		
		    }
	    	if (bloqueoDeEvento) {
	    		bloqueoDeEvento=false;
	    	}else {
	    		escribirConversionEnTextField(comboBox, comboBox_1, textField, textField_1);
	    	}
		}
	}

	private void escribirConversionEnTextField(JComboBox comboBox, JComboBox comboBox_1, JTextField textField, JTextField textField_1) {
		if (!textField.getText().isEmpty()) {

			String valor = textField.getText();
			
			if (isNumeric(valor)){
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
