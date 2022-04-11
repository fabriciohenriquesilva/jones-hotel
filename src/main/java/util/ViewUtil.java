package util;

import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class ViewUtil {
    
    public static void limparCampos(JInternalFrame tela) {
        for (Component c : tela.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }
}
