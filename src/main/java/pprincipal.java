import javax.swing.*;

public class pprincipal extends JFrame {
    // Declaración de componentes
    JPanel p3;
    private JLabel lbl1;
    private JTextField textFieldMaterno;
    private JLabel lbl2;
    private JTextField textFieldPaterno;
    private JLabel lbl3;
    private JTextField jTextfild3;
    private JLabel lblNombre;
    private JLabel lbl5;
    private JComboBox<String> comboBox1;  // Departamento
    private JLabel lbl6;
    private JComboBox<String> comboBox2;  // Antigüedad
    private JLabel lbl7;
    private JTextArea textArea1;
    private JLabel lblTitulo;
    private JLabel lbllogo;
    private JMenuBar jmenubar1;
    private JMenu jmenu;
    private JMenu jmenu2;
    private JMenu jmenu3;
    private JMenuItem jivacaciones;
    private JMenuItem jicreador;
    private JMenuItem jiNuevo;
    private JMenuItem jiSalir;
    private JMenuItem jiRegresar;

    public pprincipal() {
        // Deshabilitar la edición del JTextArea
        textArea1.setEditable(false);

        // Configuración de los ComboBox
        configurarComboBoxes();

        // Configuración de los eventos del menú
        configurarEventosMenu();
    }

    // Método para configurar los ComboBox
    private void configurarComboBoxes() {
        comboBox1.addItem("");
        comboBox1.addItem("Atención al Cliente");
        comboBox1.addItem("Logística");
        comboBox1.addItem("Gerencia");

        comboBox2.addItem("");
        comboBox2.addItem("1 año de servicio");
        comboBox2.addItem("2 a 6 años de servicio");
        comboBox2.addItem("7 o más años de servicio");
    }

    // Método para configurar los eventos del menú
    private void configurarEventosMenu() {
        jivacaciones.addActionListener(e -> calcularVacaciones());

        jicreador.addActionListener(e -> mostrarInfoCreador());

        jiNuevo.addActionListener(e -> limpiarCampos());

        jiRegresar.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p3);
            if (frame != null) {
                frame.dispose();
            }
            JFrame bienvenidaFrame = new JFrame("Login");
            bienvenida bienvenidaForm = new bienvenida();
            bienvenidaFrame.setContentPane(bienvenidaForm.p1);
            bienvenidaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bienvenidaFrame.pack();
            bienvenidaFrame.setBounds(500, 100, 350, 450);
            bienvenidaFrame.setVisible(true);
            bienvenidaFrame.setResizable(false);
            ImageIcon icono = new ImageIcon("C:\\Users\\IBI\\Documents\\Proyecto\\src\\main\\resources\\icon.png");
            bienvenidaFrame.setIconImage(icono.getImage());

            bienvenidaFrame.setVisible(true);

        });

        jiSalir.addActionListener(e -> System.exit(0));
    }

    // Método para calcular vacaciones
    private void calcularVacaciones() {
        if (jTextfild3.getText().equals("") || textFieldPaterno.getText().equals("") ||
                textFieldMaterno.getText().equals("") || comboBox1.getSelectedIndex() == 0 ||
                comboBox2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreCompleto = jTextfild3.getText() + " " + textFieldPaterno.getText() + " " + textFieldMaterno.getText();
        String departamento = comboBox1.getSelectedItem().toString();
        String antiguedad = comboBox2.getSelectedItem().toString();

        int diasVacaciones = 0;
        if (departamento.equals("Atención al Cliente")) {
            diasVacaciones = switch (antiguedad) {
                case "1 año de servicio" -> 6;
                case "2 a 6 años de servicio" -> 14;
                case "7 o más años de servicio" -> 20;
                default -> 0;
            };
        } else if (departamento.equals("Logística")) {
            diasVacaciones = switch (antiguedad) {
                case "1 año de servicio" -> 7;
                case "2 a 6 años de servicio" -> 15;
                case "7 o más años de servicio" -> 22;
                default -> 0;
            };
        } else if (departamento.equals("Gerencia")) {
            diasVacaciones = switch (antiguedad) {
                case "1 año de servicio" -> 10;
                case "2 a 6 años de servicio" -> 20;
                case "7 o más años de servicio" -> 30;
                default -> 0;
            };
        }

        textArea1.setText("El trabajador: " + nombreCompleto +
                "\n quien labora en: " + departamento +
                "\n con " + antiguedad +
                "\n tiene derecho a: " + diasVacaciones + " días de vacaciones.");
    }

    // Método para mostrar información del creador
    private void mostrarInfoCreador() {
        JOptionPane.showMessageDialog(null,
                "Desarrollado por: Marcos Méndez\n" +
                        "Correo: mendezmarcosgt@gmail.com\n" +
                        "© 2025 Todos los derechos reservados",
                "Información del Creador", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para limpiar campos
    private void limpiarCampos() {
        jTextfild3.setText("");
        textFieldPaterno.setText("");
        textFieldMaterno.setText("");
        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);
        textArea1.setText("");
    }
}
