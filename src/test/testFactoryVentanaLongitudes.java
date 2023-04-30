package test;

import java.awt.EventQueue;

import factores.LongitudesPorDefecto;
import factory.FactoryVentana;

public class testFactoryVentanaLongitudes {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongitudesPorDefecto longitudesPorDefecto = new LongitudesPorDefecto();
					FactoryVentana frameLongitudes = new FactoryVentana("Conversor de Longitudes",
							longitudesPorDefecto.getLongitudes(),longitudesPorDefecto.getRates());
					frameLongitudes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
