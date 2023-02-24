package ejemplo1;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana de ejemplo del GridBagLayout.
 * Los componentes est�n en su sitio y las filas/columnas estiradas 
 * adecuadamente, pero los componentes ocupan el centro de las celdas y no se
 * han estirado.
 */
public class Ventana2 extends JFrame
 {
     /**
      * Constructor por defecto.
      */
     public Ventana2()
     {
         super ("Ejemplo 2 GridBagLayout");
         this.getContentPane().setLayout(new GridBagLayout());
         
         GridBagConstraints constraints = new GridBagConstraints();
         
         JTextArea cajaTexto = new JTextArea("Area texto");
         constraints.gridx = 0;
         constraints.gridy = 0;
         constraints.gridwidth = 2;
         constraints.gridheight = 2;
	 // Hay que estirar la fila 0.
         constraints.weighty = 1.0;
         this.getContentPane().add (cajaTexto, constraints);
	 // Restauramos el valor de weighty para no afectar a los siguientes
	 // componentes.
         constraints.weighty = 0.0;
         
         
         JButton boton1 = new JButton ("Boton 1");
         constraints.gridx = 2;
         constraints.gridy = 0;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
	 // Hay que estirar la fila 0
         constraints.weighty = 1.0;
         this.getContentPane().add (boton1, constraints);
	 // Restauramos el valor de weighty para no afectar a los siguientes
	 // componentes.
         constraints.weighty = 0.0;
         
         JButton boton2 = new JButton ("Boton 2");
         constraints.gridx = 2;
         constraints.gridy = 1;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
	 // Hay que estirar la fila 1.
         constraints.weighty = 1.0;
         this.getContentPane().add (boton2, constraints);
	 // Restauramos el valor de weighty para no afectar a los siguientes
	 // componentes.
         constraints.weighty = 0.0;
         
         JButton boton3 = new JButton ("Boton 3");
         constraints.gridx = 0;
         constraints.gridy = 2;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         this.getContentPane().add (boton3, constraints);
         
         JButton boton4 = new JButton ("Boton 4");
         constraints.gridx = 2;
         constraints.gridy = 2;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
         this.getContentPane().add (boton4, constraints);
         
         JTextField campoTexto = new JTextField ("Campo texto");
         constraints.gridx = 1;
         constraints.gridy = 2;
         constraints.gridwidth = 1;
         constraints.gridheight = 1;
	 // Hay que estirar la columna 1.
         constraints.weightx = 1.0;
         this.getContentPane().add (campoTexto, constraints);
	 // No restauramos nada, puesto que hemos acabado el c�digo. Lo
	 // pagaremos caro el d�a que pongamos m�s componentes aqu� detr�s
	 // en la misma ventana.
     }
}