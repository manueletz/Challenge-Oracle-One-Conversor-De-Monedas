package test;

import java.awt.EventQueue;

import factores.LongitudesPorDefecto;
import factores.MasasPorDefecto;
import factory.FactoryVentana;

public class testFactoryVentanaMasas {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasasPorDefecto masasPorDefecto = new MasasPorDefecto();
					FactoryVentana frameMasas = new FactoryVentana("Conversor de Masas",
							masasPorDefecto.getMasas(),masasPorDefecto.getRates());
					frameMasas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
