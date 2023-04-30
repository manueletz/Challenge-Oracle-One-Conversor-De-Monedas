package test;

import java.awt.EventQueue;

import factores.TemperaturasPorDefecto;
import factory.FactoryVentanaTemperatura;

public class testFactoryVentanaTemperaturas {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperaturasPorDefecto temperaturasPorDefecto = new TemperaturasPorDefecto();
					FactoryVentanaTemperatura frameTemperaturas = new FactoryVentanaTemperatura("Conversor de Temperaturas",
							temperaturasPorDefecto.getTemperaturas(),temperaturasPorDefecto.getRates());
					frameTemperaturas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
