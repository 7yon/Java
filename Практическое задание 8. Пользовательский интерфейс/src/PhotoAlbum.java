import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class PhotoAlbum {

    public static void main(String[] args) throws IOException {
        MainWindow window  = new MainWindow();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}
