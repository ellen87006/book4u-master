package book4u;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
 
 
public class panelClass7 extends JPanel {
 
 
    JPanel editor;
 
    panelClass7 (){
 
                //editor.setBorder(BorderFactory.createLineBorder(Color.black));
 
                JPanel img = new JPanel();
                JPanel img2 = new JPanel();

                
                img.setPreferredSize(new Dimension(30,40));
                img.setBounds(5,20,200,200);
                img.setBorder(BorderFactory.createLineBorder(Color.black));
                img.setBackground(Color.white);
     
                img2.setPreferredSize(new Dimension(30,40));
                img2.setBounds(5,220,200,200);
                img2.setBorder(BorderFactory.createLineBorder(Color.black));
                img2.setBackground(Color.white);
                
                TextField text= new TextField("新增文字");
                text.setBounds(215, 120, 170, 250);
                add(text);
                
                add(img2);
                add(img);
                setLayout(null);
                setBackground(Color.white);
                
        }
        
}