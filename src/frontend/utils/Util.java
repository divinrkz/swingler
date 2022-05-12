package frontend.utils;

import javax.swing.*;
import java.awt.*;

public class Util {
    public static ImageIcon resizeImage(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage();
        return new ImageIcon(image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
    }
}
