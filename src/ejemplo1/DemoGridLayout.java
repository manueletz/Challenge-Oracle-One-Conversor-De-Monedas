package ejemplo1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoGridLayout extends JFrame implements ActionListener{
	
	private JButton b[];
	private String nombres[]={"Divisas","Temperatura","Longitud","Masa","Volumen","Velocidad"};
	private boolean alternar = true;
	private Container c;
	private GridLayout cuadricula1, cuadricula2;
	
	public DemoGridLayout(){
		super ( "Demostración de GridLayout" );
		Icon moneda = new ImageIcon("imagenes/moneda.png");
		
		//cuadricula1 = new GridLayout( 2, 3, 5, 5 );
		cuadricula1 = new GridLayout( 1, 2, 5, 5 );
		cuadricula2 = new GridLayout( 3, 2 );

		c = getContentPane();
		c.setLayout( cuadricula1 );
		
		//crea y agrega botones
		b = new JButton[ nombres.length ];
		System.out.println(b[0]);
		
		for (int i = 0; i < nombres.length; i++ ){
			b[ i ] = new JButton ( nombres [ i ], moneda);
			b[ i ].addActionListener( this );
			c.add( b[ i ]);
		}
		
		setSize( 700, 300);
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
		DemoGridLayout ap = new DemoGridLayout();
		
		ap.addWindowListener(
				new WindowAdapter() {
					public void windowClosing ( WindowEvent e ){
						System.exit(0);
					}
				}
				);
	}
}
