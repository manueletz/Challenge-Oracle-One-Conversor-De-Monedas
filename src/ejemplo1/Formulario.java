package ejemplo1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario extends JFrame {
    
    // Componentes del formulario
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblPais;
    private JLabel lblFechaNacimiento;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JComboBox<String> cbPais;
    private JTextField txtFechaNacimiento;
    private JButton btnCrear;
    
    public Formulario() {
        // Configuración del JFrame
        super("Formulario de registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creación de componentes
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblTelefono = new JLabel("Teléfono:");
        lblEmail = new JLabel("Correo electrónico:");
        lblPais = new JLabel("País de residencia:");
        lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtEmail = new JTextField(20);
        cbPais = new JComboBox<String>(new String[]{"Argentina", "Brasil", "Chile", "Colombia", "México", "Perú", "Uruguay"});
        txtFechaNacimiento = new JTextField(20);
        btnCrear = new JButton("Crear");
        
        // Creación del panel y configuración del GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Agregar componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
      
        panel.add(lblNombre, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtNombre, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblApellido, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtApellido, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblTelefono, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtTelefono, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblEmail, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(txtEmail, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblPais, gbc.gridx = 1);
        gbc.gridy = 4;
        panel.add(cbPais, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblFechaNacimiento, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(txtFechaNacimiento, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(btnCrear, gbc);
        
        // Agregar el panel al JFrame
        add(panel);
        
        // Agregar listener al botón
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos del formulario
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String telefono = txtTelefono.getText();
                String email = txtEmail.getText();
                String pais = (String) cbPais.getSelectedItem();
                String fechaNacimiento = txtFechaNacimiento.getText();
                
                // Hacer algo con los datos del formulario
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Correo electrónico: " + email);
                System.out.println("País de residencia: " + pais);
                System.out.println("Fecha de nacimiento: " + fechaNacimiento);
            }
        });
        
        // Mostrar el JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Formulario f = new Formulario();
    }
}