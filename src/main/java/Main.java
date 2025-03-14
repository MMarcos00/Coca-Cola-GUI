import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new bienvenida().p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setBounds(500,100,350,450);

        // Cargar el icono y establecerlo como icono de la ventana
        ImageIcon icono = new ImageIcon("C:\\Users\\IBI\\Documents\\Proyecto\\src\\main\\resources\\icon.png");
        frame.setIconImage(icono.getImage());

        frame.setVisible(true);
    }
}