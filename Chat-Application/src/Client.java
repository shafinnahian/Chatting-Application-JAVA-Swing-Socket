import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client extends JFrame implements ActionListener {

    JTextField text1;
    JPanel textPanel;
    Box verticalOutput = Box.createVerticalBox();
    Client(){
        setLayout(null);

        JPanel panelServer = new JPanel();
        panelServer.setBackground(new Color(2, 89, 47));
        panelServer.setBounds(0, 0, 450, 70);
        panelServer.setLayout(null);
        add(panelServer);

        // back logo w/ exit response
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

        // add user logo
        ImageIcon imageUser = new ImageIcon(ClassLoader.getSystemResource("images/user2.png"));
        Image imageUserObject = imageUser.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);   // creating a scaled img object
        ImageIcon imageUserConverted1 = new ImageIcon(imageUserObject); // creating a scaled object
        JLabel userLogo = new JLabel(imageUserConverted1);
        userLogo.setBounds(40, 10, 48, 48);
        panelServer.add(userLogo);

        // add video logo
        ImageIcon imageVideo = new ImageIcon(ClassLoader.getSystemResource("images/video2.png"));
        Image imageVideoObject = imageVideo.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);   // creating a scaled img object
        ImageIcon imageVideoConverted1 = new ImageIcon(imageVideoObject); // creating a scaled object
        JLabel videoLogo = new JLabel(imageVideoConverted1);
        videoLogo.setBounds(300, 17, 30, 30);
        panelServer.add(videoLogo);

        // add phone logo
        ImageIcon imagePhone = new ImageIcon(ClassLoader.getSystemResource("images/phone3.png"));
        Image imagePhoneObject = imagePhone.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);   // creating a scaled img object
        ImageIcon imagePhoneConverted1 = new ImageIcon(imagePhoneObject); // creating a scaled object
        JLabel phoneLogo = new JLabel(imagePhoneConverted1);
        phoneLogo.setBounds(350, 17, 35, 30);
        panelServer.add(phoneLogo);

        // add menu logo
        ImageIcon imageMenu = new ImageIcon(ClassLoader.getSystemResource("images/menu.png"));
        Image imageMenuObject = imageMenu.getImage().getScaledInstance(10, 32, Image.SCALE_DEFAULT);   // creating a scaled img object
        ImageIcon imageMenuConverted1 = new ImageIcon(imageMenuObject); // creating a scaled object
        JLabel menuLogo = new JLabel(imageMenuConverted1);
        menuLogo.setBounds(390, 17, 32, 32);
        panelServer.add(menuLogo);

        // adding user-name
        JLabel nameServer =new JLabel("ClientUser");
        nameServer.setBounds(110, 12, 100, 18);
        nameServer.setForeground(Color.WHITE);
        nameServer.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        panelServer.add(nameServer);

        // add user status
        JLabel userStatus =new JLabel("Active now");
        userStatus.setBounds(110, 35, 100, 18);
        userStatus.setForeground(Color.WHITE);
        userStatus.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        panelServer.add(userStatus);

        // add texting panel
        textPanel = new JPanel();
        textPanel.setBounds(5, 75, 425, 570);
        add(textPanel);

        text1 = new JTextField();    // creates a textfield to write texts
        text1.setBounds(5, 665, 310, 40);
        text1.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        add(text1);

        // create a button to send texts
        JButton send = new JButton("Send");
        send.setBounds(320, 665, 123, 40);
        send.setBackground(new Color(2, 89, 47));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("Sans Serif", Font.BOLD, 18));

        send.addActionListener(this);

        add(send);

        setSize(450, 710);
        setLocation(200, 200);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        String out = text1.getText();
        JPanel p2 = formatLabel(out);

        textPanel.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);

        verticalOutput.add(right);
        verticalOutput.add(Box.createVerticalStrut(15));

        textPanel.add(verticalOutput, BorderLayout.PAGE_START);

        text1.setText("");  // empties the input bar after each message

        repaint();
        invalidate();
        validate();
    }

    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel(out);
        output.setFont(new Font("San Serif", Font.PLAIN, 25));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));

        panel.add(output);

        // to get real time in messages
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(simpleDateFormat.format(cal.getTime()));

        panel.add(time);

        return panel;
    }
    public static void main(String[] args) {
        new Client();

//        try{
//            ServerSocket skt = new ServerSocket(6001);
//
//            while (true){
//                Socket s = skt.accept();
//                DataInputStream din = new DataInputStream(s.getInputStream());  // takes the input of socket
//                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//
//                while (true){
//                    String messageRead = din.readUTF(); // reads the message of DataInputStream object
//                    JPanel panel = formatLabel()
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
