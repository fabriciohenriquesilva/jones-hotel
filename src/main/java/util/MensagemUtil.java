package util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MensagemUtil extends JOptionPane{
    
    public static void addInfo(Component parentComponent, String mensagem){
        JOptionPane.showMessageDialog(parentComponent, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void addAviso(Component parentComponent, String mensagem){
        JOptionPane.showMessageDialog(parentComponent, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void addErro(Component parentComponent, String mensagem){
        JOptionPane.showMessageDialog(parentComponent, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
}
