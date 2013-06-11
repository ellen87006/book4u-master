package book4u;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
 
 
public class panelClass5 extends JPanel {
 
 
    JPanel editor;
 
    panelClass5 (){
 
                //editor.setBorder(BorderFactory.createLineBorder(Color.black));
 
                JPanel img = new JPanel();
                JPanel img2 = new JPanel();
                
                img.setPreferredSize(new Dimension(30,40));
                img.setBounds(25,100,350,350);
                img.setBorder(BorderFactory.createLineBorder(Color.black));
                img.setBackground(Color.white);
     
                TextField text= new TextField("新增文字");
                text.setBounds(25, 20, 350, 50);
                add(text);
    
                add(img);
                setLayout(null);
                setBackground(Color.white);
                
        }
        
}