package ejemplo1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaConversion extends JFrame implements ActionListener{
		
	private JButton b[];
	//private String nombres[]={"Divisassss","Temperatura","Longitud","Masa","Volumen","Velocidad"};
	private boolean alternar = true;
	private Container c;
	private GridLayout cuadricula1, cuadricula2;
	
	public VentanaConversion(){
		super ( "Convertidor" );
		Icon moneda = new ImageIcon("imagenes/moneda.png");
		
		cuadricula1 = new GridLayout( 1, 2, 50, 5 );
		cuadricula2 = new GridLayout( 1, 1 );
		
		c = getContentPane();
		c.setLayout( cuadricula1 );
		c.setLayout( cuadricula2 );
		
	    Object[] sports = { "Football", "Cricket", "Squash", "Baseball", "Fencing", "Volleyball", "Basketball" };
	    JComboBox comboBox = new JComboBox(sports);
	    //comboBox.setBounds(20,5,20,40);
	    //comboBox.setBounds(0,5,20,40);
	    c.add(comboBox);
	    
	    JTextField resultado = new JTextField("", 5);
	    resultado.setText("valor");
	    
	    c.add(resultado);

	    
	    /*
		//crea y agrega botones
		b = new JButton[ nombres.length ];
		System.out.println(b[0]);
		
		for (int i = 0; i < nombres.length; i++ ){
			b[ i ] = new JButton ( nombres [ i ], moneda);
			b[ i ].addActionListener( this );
			c.add( b[ i ]);
		}
		*/
		
		setSize( 700, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if ( alternar ){
			c.setLayout( cuadricula2 );
			//DemoGridLayout ap = new DemoGridLayout(); //Agregar una nueva ventana
		}else{ 
			c.setLayout( cuadricula1 );
		}
		alternar = !alternar;
		c.validate();

	}
	
	public static void main ( String args[]){
		VentanaConversion ap = new VentanaConversion();
		
		ap.addWindowListener(
				new WindowAdapter() {
					public void windowClosing ( WindowEvent e ){
						System.exit(0);
					}
				}
				);
	}
}

	
	

