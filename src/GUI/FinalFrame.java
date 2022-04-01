package GUI;

import PaqC02.Reserva;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalFrame extends JFrame{
    private JTextPane tResumen;
    private JButton aceptarButton;
    private JPanel finalPanel;
    private JLabel jResumen;

    public FinalFrame(){

        setContentPane(finalPanel);
        setTitle("FinalFrame");
        setSize(300,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);

        jResumen.setText("Reserva realizada correctamente");
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        // TODO: place custom component creation code here
        FinalFrame myFrame = new FinalFrame();

    }
}
