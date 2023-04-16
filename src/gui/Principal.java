package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal framePrincipal = new Principal();
					framePrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Secundario frameSecundario = new Secundario();
		frameSecundario.setVisible(false);
		//{"Divisas","Temperatura","Longitud","Masa","Volumen","Velocidad"};
		
		JButton btnNewButton = new JButton("Divisas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameSecundario.setVisible(true);
			}
		});
		btnNewButton.setBounds(67, 46, 117, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Temperatura");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(67, 125, 117, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Longitud");
		btnNewButton_2.setBounds(67, 204, 117, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Masa");
		btnNewButton_3.setBounds(251, 46, 117, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Volumen");
		btnNewButton_4.setBounds(251, 125, 117, 33);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Velocidad");
		btnNewButton_5.setBounds(251, 204, 117, 33);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("CONVERSORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 10, 104, 13);
		contentPane.add(lblNewLabel);
	}
}
