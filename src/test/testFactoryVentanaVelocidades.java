package test;

import java.awt.EventQueue;

import factores.VelocidadesPorDefecto;
import factory.FactoryVentana;

public class testFactoryVentanaVelocidades {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VelocidadesPorDefecto velocidadesPorDefecto = new VelocidadesPorDefecto();
					FactoryVentana frameVelocidades = new FactoryVentana("Conversor de Velocidades",
							velocidadesPorDefecto.getVelocidades(),velocidadesPorDefecto.getRates());
					frameVelocidades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
