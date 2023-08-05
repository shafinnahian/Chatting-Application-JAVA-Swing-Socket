import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Server extends JFrame implements ActionListener {

    Server(){
        setLayout(null);

        JPanel panelServer = new JPanel();
        panelServer.setBackground(new Color(2, 89, 47));
        panelServer.setBounds(0, 0, 450, 70);
        panelServer.setLayout(null);
        add(panelServer);

        // back logo w/ exit reponse
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("images/arrow2.png"));
        Image imageObject = image1.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);   // creating a scaled img object
        ImageIcon imageConverted1 = new ImageIcon(imageObject); // creating a scaled object
        JLabel back = new JLabel(imageConverted1);
        back.setBounds(5, 20, 23, 23);
        panelServer.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        ImageIcon imageUser = new ImageIcon(ClassLoader.getSystemResource("images/user2.png"));
        Image imageUserObject = imageUser.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);   // creating a scaled img object
        ImageIcon imageUserConverted1 = new ImageIcon(imageUserObject); // creating a scaled object
        JLabel userLogo = new JLabel(imageUserConverted1);
        userLogo.setBounds(90, 20, 24, 24);
        panelServer.add(userLogo);

        setSize(450, 700);
        setLocation(200, 200);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){

    }
    public static void main(String[] args) {
        new Server();
    }
}
