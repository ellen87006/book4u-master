package book4u;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
 
 
public class panelClass1 extends JPanel {
 
 
    JPanel editor;
 
    panelClass1 (){
 
                //editor.setBorder(BorderFactory.createLineBorder(Color.black));
 
                JPanel img = new JPanel();
                img.setPreferredSize(new Dimension(30,40));
                img.setBounds(50,50,300,300);
                img.setBorder(BorderFactory.createLineBorder(Color.black));
                img.setBackground(Color.white);
                setLayout(new OverlayLayout(this));
                setBackground(Color.white);
                add(img);
        }
        
}