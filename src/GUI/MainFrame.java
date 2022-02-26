package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends  JFrame{
    private JPanel mainPanel;
    private JTextField tfUsuario;
    private JPasswordField tfContraseña;
    private JButton limpiarButton;
    private JButton entrarButton;
    private JLabel error_usuario;
    private JLabel error_contraseña;


    public MainFrame (){
        setContentPane(mainPanel);
        setTitle("Iniciar sesion");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        error_usuario.setVisible(false);
        error_contraseña.setVisible(false);




        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfUsuario.setText("");
                tfContraseña.setText("");
                error_usuario.setVisible(false);
                error_contraseña.setVisible(false);
            }
        });

        entrarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                        if(!Objects.equals(tfUsuario.getText(), "")  &&  (!Objects.equals(String.valueOf(tfContraseña.getPassword()),"" )))
                        {
                            Reserva reserva = new Reserva();
                            setVisible(false);
                            reserva.setVisible(true);
                        }else{
                            if(Objects.equals(tfUsuario.getText(), "")){
                                error_usuario.setForeground(new Color(255,0,0));
                                error_usuario.setText("Rellene el campo obligatorio");
                                error_usuario.setVisible(true);
                            }
                            if(Objects.equals(String.valueOf(tfContraseña.getPassword()), "")){
                                error_contraseña.setForeground(new Color(255,0,0));
                                error_contraseña.setText("Rellene el campo obligatorio");
                                error_contraseña.setVisible(true);
                            }

                        }



                }
            });


    }
    public static void main(String[] args) {
        // TODO: place custom component creation code here
    MainFrame myFrame = new MainFrame();

    }
}
