package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class noEncontrado extends JFrame{
    private JTextPane tResumen;
    private JButton aceptarButton;
    private JPanel finalPanel;
    private JLabel jResumen;

    public noEncontrado(){

        setContentPane(finalPanel);
        setTitle("DNInoEncontrado");
        setSize(300,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);

        jResumen.setText("No se ha encontrado ningún cliente con ese DNI");
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    public static void main(String[] args) {
        // TODO: place custom component creation code here
        noEncontrado myFrame = new noEncontrado();

    }
}
