import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bienvenida extends JFrame {

    public static String texto;
    private JLabel label1;
    private JButton btn1;
    private JTextField textField1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbllogo;
    JPanel p1;

    public bienvenida() {


        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    texto = textField1.getText().trim();
                    if (texto.equals("")) {
                        JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
                    } else {
                        // Cerrar la ventana actual (bienvenida)
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p1);
                        if (frame != null) {
                            frame.dispose(); // Cierra el formulario de bienvenida
                        }

                        // Abrir el formulario tcondiciones
                        JFrame frame2 = new JFrame("Condiciones de Uso");
                        frame2.setContentPane(new tcondiciones().p2);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.pack();
                        frame2.setBounds(225, 100, 900, 500);
                        frame2.setResizable(false); // Evita que la ventana sea redimensionable

                        // Cargar y establecer el icono para la ventana tcondiciones
                        ImageIcon icono = new ImageIcon("C:\\Users\\IBI\\Documents\\Proyecto\\src\\main\\resources\\icon.png");
                        frame2.setIconImage(icono.getImage());

                        frame2.setVisible(true);
                    }
                }
            }
        });
    }
}