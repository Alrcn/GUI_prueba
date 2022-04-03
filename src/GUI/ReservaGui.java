package GUI;

import PaqC02.Hotel;
import PaqC02.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

public class ReservaGui extends  JFrame {

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
    private JComboBox cbRegimen;
    private JTextField tfPrecio;
    private JButton calcularButton;
    private JButton cancelarButton;
    private JButton limpiarButton;
    private JButton confirmarButton;
    private JPanel Reserva;
    private JLabel cbSelección;
    private JLabel selectReg;
    private JTextPane textHotel;
    private JLabel error;
    private JSpinner sEstandar;
    private JSpinner sBalcon;
    private JSpinner sSuite;
    private JTextField tfEntrada;
    private JTextField tfSalida;


    public ReservaGui() {

        try {
            FileInputStream fis = null;
            ObjectInputStream entrada = null;
            Hotel hotel;

            fis = new FileInputStream("hotel.dat");
            entrada = new ObjectInputStream(fis);
            hotel = (Hotel) entrada.readObject();
            fis.close(); //Cerrar el file
            entrada.close(); //Cerrar el object
            System.out.println(hotel.toString());




            setContentPane(Reserva);
            setTitle("Reservas");
            setSize(1300, 600);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(false);
            cbSelección.setVisible(false);
            selectReg.setVisible(false);
            error.setVisible(false);
            textHotel.setText(hotel.toString());




            //Boton limpiar
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
                    tfEntrada.setText("");
                    tfSalida.setText("");

                    tfPrecio.setText("");
                    sEstandar.setValue(0);
                    sBalcon.setValue(0);
                    sSuite.setValue(0);

                    estandarCheckBox.setSelected(false);
                    balcónCheckBox.setSelected(false);
                    suiteCheckBox.setSelected(false);

                    cbRegimen.setSelectedItem("Sin desyuno");
                    cbSelección.setVisible(false);
                    selectReg.setVisible(false);


                }
            });

            //Boton cancelar
            cancelarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainFrame myFrame = new MainFrame();
                    setVisible(false);
                    myFrame.setVisible(true);

                }
            });
            //Las checkbox´s
            estandarCheckBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (estandarCheckBox.isSelected()) {
                        cbSelección.setText("Has seleccionado Estandar ");
                        cbSelección.setVisible(true);
                    } else {
                        cbSelección.setVisible(false);
                    }
                }
            });

            balcónCheckBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (balcónCheckBox.isSelected()) {
                        cbSelección.setText("Has seleccionado Balcón ");
                        cbSelección.setVisible(true);
                    } else {
                        cbSelección.setVisible(false);
                    }
                }
            });
            suiteCheckBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (suiteCheckBox.isSelected()) {
                        cbSelección.setText("Has seleccionado Suite ");
                        cbSelección.setVisible(true);
                    } else {
                        cbSelección.setVisible(false);
                    }
                }
            });


            cbRegimen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectReg.setText("Has seleccionado " + (String) cbRegimen.getSelectedItem());
                    selectReg.setVisible(true);
                }
            });

            //Boton calcular precio
            calcularButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String aux;
                    int cantE;int cantB;int cantS;

                    if(estandarCheckBox.isSelected()||balcónCheckBox.isSelected()||suiteCheckBox.isSelected()){
                        cantE = ((Integer) sEstandar.getValue()).intValue();
                        cantB = ((Integer) sBalcon.getValue()).intValue();
                        cantS = ((Integer) sSuite.getValue()).intValue();
                        aux = String.valueOf(50 * cantE + 75*cantB + 100*cantS);

                        tfPrecio.setText(aux+"€");
                    }
                }
            });
            //Botón confirmar
            confirmarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reserva r1;
                    String aux;
                    int cant;

                    FileOutputStream fos = null;
                    ObjectOutputStream salida = null;


                    FinalFrame finalFrame = new FinalFrame();

                    //Con este if comprobamos que todos los campos han sido rellenados por el usuario
                    if(!Objects.equals(tfNombre.getText(), "")&& !Objects.equals(tfApellidos.getText(), "")
                            && !Objects.equals(tfDirección.getText(), "")&& !Objects.equals(tfTelefono.getText(), "")&& !Objects.equals(tfDNI.getText(), "")
                            && !Objects.equals(tfEmail.getText(), "")&& !Objects.equals(tfTarjeta.getText(), "")
                            && !Objects.equals(tfEntrada.getText(), "") && !Objects.equals(tfSalida.getText(), "") && (estandarCheckBox.isSelected()
                            || balcónCheckBox.isSelected() || suiteCheckBox.isSelected())) {

                        //Con estos if realizamos la reserva para el tipo de habitación seleccionada
                        if (estandarCheckBox.isSelected() && ((Integer) sEstandar.getValue()).intValue() > 0) {

                            r1 = new Reserva(tfDNI.getText(), tfNombre.getText(), tfApellidos.getText(), tfTelefono.getText(),
                                    tfEntrada.getText(), tfSalida.getText(), cbRegimen.getName());

                            aux = "estandar";
                            cant = ((Integer) sEstandar.getValue()).intValue();
                            hotel.HabitacionLibre(aux, r1, cant);



                        } else {
                        }

                        if (balcónCheckBox.isSelected() && ((Integer) sBalcon.getValue()).intValue() > 0) {


                            r1 = new Reserva(tfDNI.getText(), tfNombre.getText(), tfApellidos.getText(), tfTelefono.getText(),
                                    tfEntrada.getText(), tfSalida.getText(), cbRegimen.getName());

                            aux = "balcon";
                            cant = ((Integer) sBalcon.getValue()).intValue();

                            hotel.HabitacionLibre(aux, r1, cant);


                        } else {
                        }

                        if (suiteCheckBox.isSelected() && ((Integer) sSuite.getValue()).intValue() > 0) {


                            r1 = new Reserva(tfDNI.getText(), tfNombre.getText(), tfApellidos.getText(), tfTelefono.getText(),
                                    tfEntrada.getText(), tfSalida.getText(), cbRegimen.getName());


                            aux = "suite";
                            cant = ((Integer) sSuite.getValue()).intValue();

                            hotel.HabitacionLibre(aux, r1, cant);


                        } else {
                        }
                        setVisible(false);
                        finalFrame.setVisible(true);
                    }else {
                        error.setForeground(new Color(255, 0, 0));
                        error.setText("Debe rellenar todos los campos obligatorios");
                        error.setVisible(true);
                    }
                    try {

                        fos = new FileOutputStream("hotel.dat");
                        salida = new ObjectOutputStream(fos);
                        salida.writeObject(hotel);
                        fos.close();
                        salida.close();


                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }


            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        ReservaGui fram = new ReservaGui();

    }
}