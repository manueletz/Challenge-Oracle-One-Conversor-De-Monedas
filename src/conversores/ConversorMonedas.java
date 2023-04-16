package conversores;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConversorMonedas {

	public static void main(String[] args) {
		// componente JFrame
		JFrame miJFrame = new JFrame("Ejemplo - Java Swing");
		miJFrame.setSize(500, 300);

		// componente JPanel
		JPanel miJPanel = new JPanel();
		miJPanel.setSize(300, 300);
		
		JPanel miJPanel2 = new JPanel();
		miJPanel2.setSize(300, 300);
		miJPanel2.setLayout(new GridBagLayout());

		// usamos este diseño para centrar los componentes de JPanel`
		miJPanel.setLayout(new GridBagLayout());

		// componente JTextField`
		JLabel miJLabel = new JLabel();
		miJLabel.setText("Dime tu opinión acerca de Java Swing:  ");

		// componente JTextArea
		JTextArea miJTextArea = new JTextArea(5, 20);

		// conecta los componentes JLabel y JTextField en JPanel`
		miJPanel.add(miJLabel);
		miJPanel.add(miJTextArea);
		
		//menu-convesiones
		//JOptionPane menu = new JOptionPane();
		//menu.showInputDialog("Conversor de Moneda");
		//menu.showInputDialog("Conversor de Temperatura");
		
		
	    Object[] sports = { "Football", "Cricket", "Squash", "Baseball", "Fencing", "Volleyball", "Basketball" };
	    JComboBox comboBox = new JComboBox(sports);
	    comboBox.setBounds(20,5,20,40);
	    //comboBox.setBounds(x, y, width, height);()
	    comboBox.setBounds(0,5,20,40);
	    comboBox.setSelectedIndex(1);
	    //JOptionPane.showMessageDialog(null, comboBox, "Fav Sports",
	    //JOptionPane.QUESTION_MESSAGE);
	    
		

		// conectar Jpanel a JFrame`
		miJFrame.add(miJPanel);


		//miJFrame.add(comboBox, BorderLayout.SOUTH);
		miJPanel2.add(comboBox);
		miJFrame.add(miJPanel2, BorderLayout.CENTER);
		
		// hacer visible JFrame
		miJFrame.setVisible(true);

	}
	
	

}

