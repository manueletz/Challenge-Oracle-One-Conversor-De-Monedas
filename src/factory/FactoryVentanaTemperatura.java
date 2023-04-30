package factory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

import javax.swing.JTextField;

public class FactoryVentanaTemperatura extends FactoryVentana {

	public FactoryVentanaTemperatura(String titulo, LinkedHashMap<String, String> detallesDeFactores,
			LinkedHashMap<String, BigDecimal> rates) {
		super(titulo, detallesDeFactores, rates);
		// TODO Auto-generated constructor stub
	}
	
	//Sobrescribir el metodo para que acepte negativos
	@Override
	public void esNumero(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if((car<'0' || car>'9'))

				if((car!='-') && (car!='.')) {
					e.consume();
				}
				if (car == '.' && a.getText().contains(".")) {
					e.consume();
				}
				if (car == '-' && a.getText().contains("-")) {
					e.consume();
				}
				if (a.getText().length() == 0 && car == '.') {
					e.consume();
				}
				
				if (a.getText().length() > 0 && car == '-') {
					e.consume();
				}

				if (a.getText().length() == 1 && car == '.' && a.getText().substring(0, 1).equals("-")) {
					e.consume();
				}

			}
		});
	}
	
	@Override
	public String Conversion(String simbolosConversion, String monto) {
		//super.Conversion(simbolosConversion, monto);
		/*	
		rates.put("C->F",new BigDecimal("1"));
		rates.put("C->K",new BigDecimal("1"));
		rates.put("F->C",new BigDecimal("1"));
		rates.put("F->K",new BigDecimal("1"));
		rates.put("K->C",new BigDecimal("1"));
		rates.put("K->F",new BigDecimal("1"));
		*/
		
		BigDecimal grados = new BigDecimal(monto);
		
		System.out.println(grados);
		
		BigDecimal resultado = new BigDecimal("0");
		String resultadoTexto;
		
		if (simbolosConversion.equals("C->F")) {
			resultado = (grados.multiply(new BigDecimal("1.8")).add(new BigDecimal("32")));
		}
		if (simbolosConversion.equals("C->K")) {
			resultado = (grados.add(new BigDecimal("273.15")));
		}

		if (simbolosConversion.equals("F->C")) {
			resultado = (grados.subtract(new BigDecimal("32")).multiply(new BigDecimal("5"))).divide(new BigDecimal("9"), 4,RoundingMode.HALF_UP);
		}
		if (simbolosConversion.equals("F->K")) {
			resultado = ((grados.subtract(new BigDecimal("32")).multiply(new BigDecimal("5"))).divide(new BigDecimal("9"), 4,RoundingMode.HALF_UP)).add(new BigDecimal("273.15"));
			System.out.println(resultado);
		}
		if (simbolosConversion.equals("K->C")) {
			resultado = grados.subtract(new BigDecimal("273.15"));
		}
		
		if (simbolosConversion.equals("K->F")) {
			resultado = ((grados.subtract(new BigDecimal("273.15")).multiply(new BigDecimal("9"))).divide(new BigDecimal("5"), 4,RoundingMode.HALF_UP)).add(new BigDecimal("32"));
			System.out.println(resultado);
		}
		
		System.out.println(resultado);
		//Rendondeo de un numero despues de dos digitos despues de cero
		//Funcion para colocar decimales representativos y no mostrar 00 en
		//cantidad pequeñas
		//Resto extrae la parte decimal de una numero
		resultadoTexto = (resultado.remainder(new BigDecimal(1))).toString();
		System.out.println(resultadoTexto);
		Integer verificarCero=0;
		Integer posicionesRedondeo=0;
		Boolean NoEsCero=false; 
		Integer dosNumerosDespuesDeCero=0;
		int i;
		
		if (resultadoTexto.substring(0, 1).equals("-")) {
			i=3;
		}else {
			i=2;
		}
		
		while (i <resultadoTexto.length()) {

			posicionesRedondeo++;

			if (i==3) {
				verificarCero += Integer.valueOf(resultadoTexto.substring(i,i+1));
			}else {
				verificarCero += Integer.valueOf(resultadoTexto.substring(i,i+1));
			}
			
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
		
		//Finalmente si todos los numeros son 0 despues del punto decimal
		//se colocará 2 posiciones decimales
		if (dosNumerosDespuesDeCero==0) {
			posicionesRedondeo=2;
		}
		
		//Resultado final de redondeo a las posiciones de dos digitos despues de cero
		resultado = resultado.setScale(posicionesRedondeo, RoundingMode.HALF_UP);
		//resultado = resultado.setScale(2, RoundingMode.HALF_UP);
		
	
		return resultado.toString();
	}

}
