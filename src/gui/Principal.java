package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
//import RSScaleLabel.*;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/tipo-de-cambio.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ImageIcon wallpaper = new ImageIcon("src/imagenes/pexels-karolina-grabowska-5980887.jpg");
		//ImageIcon wallpaper = new ImageIcon("src/imagenes/pexels-david-mcbee-730547.jpg");
		//ImageIcon wallpaper = new ImageIcon("src/imagenes/coins-paper-money-globe-white-statistic-form-background.jpg");
		ImageIcon wallpaper = new ImageIcon("src/imagenes/6256458.jpg");
		this.repaint();
		
		
		Secundario frameSecundario = new Secundario();
		frameSecundario.setVisible(false);
		//{"Divisas","Temperatura","Longitud","Masa","Volumen","Velocidad"};
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFont(new Font("Quicksand Medium", Font.BOLD, 14));
		ImageIcon myimagen = new ImageIcon("src/imagenes/currency_exchange_FILL0_wght400_GRAD0_opsz48.png");
		btnNewButton.setSize(48, 48);
		Icon icono = new ImageIcon(myimagen.getImage().getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(),
				Image.SCALE_DEFAULT));
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/currency_exchange_FILL0_wght400_GRAD0_opsz48.png")));
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameSecundario.setVisible(true);
			}
		});
		btnNewButton.setBounds(113, 65, 55, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/thermometer_FILL0_wght400_GRAD0_opsz48.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(113, 158, 55, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/straighten_FILL0_wght400_GRAD0_opsz48.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(113, 251, 55, 54);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/weight_FILL0_wght400_GRAD0_opsz48.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(281, 65, 55, 54);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/view_in_ar_FILL0_wght400_GRAD0_opsz48.png")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(281, 158, 55, 54);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/speed_FILL0_wght400_GRAD0_opsz48.png")));
		btnNewButton_5.setBounds(281, 251, 55, 54);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("CONVERSORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 10, 104, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Divisas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(113, 132, 55, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Longitud");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(98, 318, 83, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Temperatura");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(99, 225, 83, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Masa");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(281, 132, 55, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Volumen");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(281, 225, 55, 13);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Velocidad");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBounds(272, 318, 73, 13);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(-34, 0, 484, 371);
		contentPane.add(jLabel_Wallpaper);
		Icon iconoWallpaper = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT)); 
		jLabel_Wallpaper.setIcon(iconoWallpaper);
		

	}
}
