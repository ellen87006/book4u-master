package book4u;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
 
 
public class panelClass3 extends JPanel {
 
 
    JPanel editor;
 
    panelClass3 (){
 
                //editor.setBorder(BorderFactory.createLineBorder(Color.black));
 
                JPanel img = new JPanel();
                img.setPreferredSize(new Dimension(30,40));
                img.setBounds(5,50,380,380);
                img.setBorder(BorderFactory.createLineBorder(Color.black));
                img.setBackground(Color.white);
     
                add(img);
                setLayout(null);
                setBackground(Color.white);
                
        }
        
}