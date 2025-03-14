import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tcondiciones {
    JPanel p2;
    private JLabel lbl1;
    private JTextArea textArea1;
    private JCheckBox aceptoCheckBox;
    private JButton btn1;
    private JButton btn2;
    private JLabel lbllogo;

    public tcondiciones() {
        textArea1.setText("\n\tTÉRMINOS Y CONDICIONES\n\n"
                + "\tA. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DEL DESARROLLADOR.\n"
                + "\tB. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS.\n"
                + "\tC. EL DESARROLLADOR NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE.\n\n"
                + "\tLOS ACUERDOS LEGALES EXPUESTOS A CONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE\n"
                + "\t(EL DESARROLLADOR Y EL AUTOR MARCOS), NO SE RESPONSABILIZAN DEL USO QUE USTED\n"
                + "\tHAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)\n"
                + "\tSI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE.");
        textArea1.setEditable(false);
        // Deshabilitar el botón Continuar inicialmente
        btn1.setEnabled(false);

        // Acción para el botón Continuar
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (aceptoCheckBox.isSelected()) {
                    // Obtener la ventana principal y cerrarla antes de abrir la nueva
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p2);
                    if (frame != null) {
                        frame.dispose(); // Cierra la ventana actual
                    }

                    // Abrir la ventana principal (pprincipal)
                    JFrame mainFrame = new JFrame("Home");
                    pprincipal principal = new pprincipal();
                    mainFrame.setContentPane(principal.p3);
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.pack();
                    mainFrame.setBounds(325,100,700,500);
                    mainFrame.setResizable(false); // Evita que la ventana sea redimensionable

                    // Cargar y establecer el icono para la ventana principal
                    ImageIcon icono = new ImageIcon("C:\\Users\\IBI\\Documents\\Proyecto\\src\\main\\resources\\icon.png");
                    mainFrame.setIconImage(icono.getImage());

                    mainFrame.setVisible(true);
                }
            }
        });

        // Acción para el botón No Acepto
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "Al no aceptar los términos y condiciones, regresaras al formulario anterior.",
                        "Confirmación", JOptionPane.OK_CANCEL_OPTION);

                if (respuesta == JOptionPane.OK_OPTION) {
                    // Cerrar la ventana actual (tcondiciones)
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p2);
                    if (frame != null) {
                        frame.dispose(); // Cierra el formulario tcondiciones
                    }

                    // Abrir el formulario de bienvenida nuevamente
                    JFrame bienvenidaFrame = new JFrame("Login");
                    bienvenida bienvenidaForm = new bienvenida(); // Crear una nueva instancia de bienvenida
                    bienvenidaFrame.setContentPane(bienvenidaForm.p1); // Asume que 'p1' es el JPanel de bienvenida
                    bienvenidaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    bienvenidaFrame.pack();
                    bienvenidaFrame.setBounds(500, 100, 350, 450);
                    bienvenidaFrame.setResizable(false); // Evita que la ventana sea redimensionable

                    // Cargar y establecer el icono para la ventana de bienvenida
                    ImageIcon icono = new ImageIcon("C:\\Users\\IBI\\Documents\\Proyecto\\src\\main\\resources\\icon.png");
                    bienvenidaFrame.setIconImage(icono.getImage());

                    bienvenidaFrame.setVisible(true);
                }
            }
        });

        // Control del estado del CheckBox
        aceptoCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Habilitar o deshabilitar el botón Continuar según el estado del CheckBox
                btn1.setEnabled(aceptoCheckBox.isSelected());
            }
        });
    }
}