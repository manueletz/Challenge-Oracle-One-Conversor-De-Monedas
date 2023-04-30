package test;

import java.awt.EventQueue;

import factores.VolumenesPorDefecto;
import factory.FactoryVentana;

public class testFactoryVentanaVolumenes {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VolumenesPorDefecto volumenesPorDefecto = new VolumenesPorDefecto();
					FactoryVentana frameVolumenes = new FactoryVentana("Conversor de Volumenes",
							volumenesPorDefecto.getVolumenes(),volumenesPorDefecto.getRates());
					frameVolumenes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
	


