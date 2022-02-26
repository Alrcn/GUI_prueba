package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Reserva extends  JFrame {
    private JTextField tfNombre;
    private JTextField tfApellidos;
    private JTextField tfDirección;
    private JTextField tfTelefono;
    private JTextField tfEmail;
    private JTextField tfDNI;
    private JTextField tfTarjeta;
    private JCheckBox estandarCheckBox;
    private JCheckBox balcónCheckBox;
    private JCheckBox suiteCheckBox;
    private JTextField tfEstandar;
    private JTextField tfBalcon;
    private JTextField tfSuite;
    private JComboBox cbRegimen;
    private JTextField tfPrecio;
    private JButton calcularButton;
    private JButton cancelarButton;
    private JButton limpiarButton;
    private JButton confirmarButton;
    private JPanel Reserva;
    private JLabel cbSelección;
    private JLabel selectReg;


    public Reserva(){
        setContentPane(Reserva);
        setTitle("Reservas");
        setSize(900,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
        cbSelección.setVisible(false);
        selectReg.setVisible(false);


        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNombre.setText("");
                tfApellidos.setText("");
                tfDirección.setText("");
                tfDNI.setText("");
                tfEmail.setText("");
                tfTarjeta.setText("");
                tfTelefono.setText("");

                tfPrecio.setText("");

                tfSuite.setText("0");
                tfBalcon.setText("0");
                tfEstandar.setText("0");

                estandarCheckBox.setSelected(false);
                balcónCheckBox.setSelected(false);
                suiteCheckBox.setSelected(false);

                cbRegimen.setSelectedItem("Sin desyuno");
                cbSelección.setVisible(false);
                selectReg.setVisible(false);



            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame = new MainFrame();
                setVisible(false);
                myFrame.setVisible(true);

            }
        });
        estandarCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbSelección.setText("Has seleccionado Estandar");
                cbSelección.setVisible(true);
            }
        });
        balcónCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbSelección.setText("Has seleccionado Balcón");
                cbSelección.setVisible(true);
            }
        });
        suiteCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbSelección.setText("Has seleccionado Suit");
                cbSelección.setVisible(true);
            }
        });


        cbRegimen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectReg.setText("Has seleccionado "+ (String) cbRegimen.getSelectedItem());
                selectReg.setVisible(true);
            }
        });
    }



    public static void main(String[] args) {
        Reserva fram = new Reserva();

    }
}
