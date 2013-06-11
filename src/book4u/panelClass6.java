package book4u;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
 
 
public class panelClass6 extends JPanel {
 
 
    JPanel editor;
 
    panelClass6 (){
 
                //editor.setBorder(BorderFactory.createLineBorder(Color.black));
 
                JPanel img = new JPanel();
                JPanel img2 = new JPanel();
                JPanel img3 = new JPanel();
                
                img.setPreferredSize(new Dimension(30,40));
                img.setBounds(5,20,200,200);
                img.setBorder(BorderFactory.createLineBorder(Color.black));
                img.setBackground(Color.white);
     
                img2.setPreferredSize(new Dimension(30,40));
                img2.setBounds(5,220,200,200);
                img2.setBorder(BorderFactory.createLineBorder(Color.black));
                img2.setBackground(Color.white);
                add(img2);
                img3.setPreferredSize(new Dimension(30,40));
                img3.setBounds(205,20,185,400);
                img3.setBorder(BorderFactory.createLineBorder(Color.black));
                img3.setBackground(Color.white);
                add(img3);
     
                
                add(img);
                setLayout(null);
                setBackground(Color.white);
                
        }
        
}