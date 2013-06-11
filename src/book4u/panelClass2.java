package book4u;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
 
 
public class panelClass2 extends JPanel {
 
 
    JPanel editor;
 
    panelClass2 (){
 
                //editor.setBorder(BorderFactory.createLineBorder(Color.black));
 
                JPanel img = new JPanel();
                img.setPreferredSize(new Dimension(30,40));
                img.setBounds(30,30,300,300);
                img.setBorder(BorderFactory.createLineBorder(Color.black));
                img.setBackground(Color.white);
                
                TextField text= new TextField("新增文字");
                text.setBounds(30, 350, 300, 50);
                add(text);
                
                add(img);
                setLayout(null);
                setBackground(Color.white);
                
        }
        
}