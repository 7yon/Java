import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private ArrayList<ImageIcon> photos = new ArrayList<ImageIcon>();

    private JLabel photo;
    private GroupLayout layout;

    public MainWindow() {
        super("Cat Album");

        photo = new JLabel();
        layout = new GroupLayout(getContentPane());

        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setPreferredSize(new Dimension(550, 450));
        setResizable(false);

        addImage("1.jpg");
        addImage("2.jpg");
        addImage("3.jpg");
        addImage("main.jpg");

        addComponentsToWindow();
        showPhoto(3);
    }

    public void showPhoto(int i) {
        photo.setIcon(photos.get(i));
    }

    private void addImage(String path) {

        BufferedImage image = null;
        ImageIcon icon;
        try{
            image = ImageIO.read(new File(path));
            icon = new ImageIcon(image.getSubimage(0, 0, 400, 400));
            photos.add(icon);
        }
        catch (IOException e){ }
    }


    private void addComponentsToWindow(){

        ActionListener actionListener = new TestActionListener();

        JButton button1 = new JButton("Photo 1");
        JButton button2 = new JButton("Photo 2");
        JButton button3 = new JButton("Photo 3");

        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);

        button1.setActionCommand("0");
        button2.setActionCommand("1");
        button3.setActionCommand("2");

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(photo)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, button1, button2, button3);

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(photo)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(button1)
                        .addComponent(button2)
                        .addComponent(button3))
        );
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand());
            showPhoto(i);
        }
    }
}
