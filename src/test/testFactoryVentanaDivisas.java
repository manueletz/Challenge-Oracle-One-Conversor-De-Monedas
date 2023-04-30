package test;

import java.awt.EventQueue;

import factores.DivisasPorDefecto;
import factory.FactoryVentana;

public class testFactoryVentanaDivisas {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DivisasPorDefecto divisasPorDefecto = new DivisasPorDefecto();
					FactoryVentana frameDivisas = new FactoryVentana("Conversor de Divisas",
							divisasPorDefecto.getDivisas(),divisasPorDefecto.getRates());
					frameDivisas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
