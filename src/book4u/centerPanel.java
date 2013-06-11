/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package book4u;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author 桌電
 */
public class centerPanel extends javax.swing.JPanel {
     MenuItem menuItem1 = new MenuItem();
    MenuItem menuItem2 = new MenuItem();
    private static ArrayList<arrayListType> myList;
    private int currentSquareIndex = -1;
    private Point p1;
    int x1, y1,orignx,origny;
    int isSelected = 0;
    private JLabel northWest = null;
    boolean moveEnable = false;
    boolean inout=true;
    Point point1 = null;
    Point point2 = null;
    private JLabel north = null;
    private mainFrame mainFrame;
    private JLabel northEast = null;

    private JLabel east = null;

    private JLabel southEast = null;

    private JLabel south = null;

    private JLabel southWest = null;

    private JLabel west = null;
    ImageIcon imageIcon = null;
    int x,dx,dy, y, w, h,count=0;
    public centerPanel(JFrame frame) {
        MouseListen mouse = new MouseListen();
        mainFrame = (book4u.mainFrame) frame;
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        northWest = new JLabel();
        northWest.setText("");
        northWest.setBorder(new LineBorder(Color.WHITE, 1));
        northWest.addMouseListener(mouse);
        northWest.addMouseMotionListener(mouse);
        northWest.setVisible(false);

        north = new JLabel();
        north.setText("");
        north.setBorder(new LineBorder(Color.WHITE, 1));
        north.addMouseListener(mouse);
        north.addMouseMotionListener(mouse);
        north.setVisible(false);

        northEast = new JLabel();
        northEast.setText("");
        northEast.setBorder(new LineBorder(Color.WHITE, 1));
        northEast.addMouseListener(mouse);
        northEast.addMouseMotionListener(mouse);
        northEast.setVisible(false);

        east = new JLabel();
        east.setText("");
        east.setBorder(new LineBorder(Color.WHITE, 1));
        east.addMouseListener(mouse);
        east.addMouseMotionListener(mouse);
        east.setVisible(false);

        southEast = new JLabel();
        southEast.setText("");
        southEast.setBorder(new LineBorder(Color.WHITE, 1));
        southEast.addMouseListener(mouse);
        southEast.addMouseMotionListener(mouse);
        southEast.setVisible(false);

        south = new JLabel();
        south.setText("");
        south.setBorder(new LineBorder(Color.WHITE, 1));
        south.addMouseListener(mouse);
        south.addMouseMotionListener(mouse);
        south.setVisible(false);

        southWest = new JLabel();
        southWest.setText("");
        southWest.setBorder(new LineBorder(Color.WHITE, 1));
        southWest.addMouseListener(mouse);
        southWest.addMouseMotionListener(mouse);
        southWest.setVisible(false);

        west = new JLabel();
        west.setText("");
        west.setBorder(new LineBorder(Color.WHITE, 1));
        west.addMouseListener(mouse);
        west.addMouseMotionListener(mouse);
        west.setVisible(false);
       myList = new ArrayList();
       initComponents();
    }
    public void MOUSEinit()
    {//this.imageIcon = imageIcon;
        //this.setBounds(256,107,40,30);

        
        x1 = myList.get(count).getWidth();
        y1 = myList.get(count).getHeight();
        isSelected = -1;
        northWest.setBounds(0, 0, 5, 5);
        north.setBounds((x1 - 3) / 2, 0, 5, 5);
        northEast.setBounds(x1 - 5, 0, 5, 5);
        east.setBounds(x1 - 5, (y1 - 3) / 2, 5, 5);
        southEast.setBounds(x1 - 5, y1 - 5, 5, 5);
        south.setBounds((x1 - 3) / 2, y1 - 5, 5, 5);
        southWest.setBounds(0, y1 - 5, 5, 5);
        west.setBounds(0, (y1 - 3) / 2, 5, 5);

        myList.get(count).setLayout(null);
        myList.get(count).setMinimumSize(new Dimension(20, 20));
        myList.get(count).addMouseListener(new MouseListen());
        myList.get(count).addMouseMotionListener(new MouseListen());
        myList.get(count).add(northWest, null);
        myList.get(count).add(north, null);
        myList.get(count).add(northEast, null);
        myList.get(count).add(east, null);
        myList.get(count).add(southEast, null);
        myList.get(count).add(south, null);
        myList.get(count).add(southWest, null);
        myList.get(count).add(west, null);
    }

    public JPanel insertPictureFrame()
    {
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
            BufferedImage  img = new BufferedImage(getWidth(), getHeight(),
              BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
              0));// 设置合成规则
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(img, 0, 0, null);
            }
        };
        panel.setOpaque(false);
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        //panel.setLayout(null);
        
        panel.setBounds(50, 50, 100, 100);
        DropTarget dropTarget = new DropTarget(panel,new DragAndDropDropTargetListener());
        myList.add(new arrayListType(panel));
        add(panel, 0);
        updateUI();
         inout = true;
        myList.get(count).setBorder(new LineBorder(Color.BLUE, 1)); 
        MOUSEinit();
        count++;
       setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
       northWest.setVisible(false);
       north.setVisible(false);
       northEast.setVisible(false);
       east.setVisible(false);
       southEast.setVisible(false);
       south.setVisible(false);
       southWest.setVisible(false);
        west.setVisible(false);
        return panel;
    }

    public JTextPane insertTextArea()
    {
        JTextPane panel = new JTextPane(){
            public void paintComponent(Graphics g) {
            BufferedImage  img = new BufferedImage(getWidth(), getHeight(),
              BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
              0));// 设置合成规则
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(img, 0, 0, null);
            }
        };
        panel.setOpaque(false);
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        panel.setLayout(null);
        panel.setBounds(50, 50, 100, 100);
        panel.setDragEnabled(true);
        //panel.setEditable(true);
        myList.add(new arrayListType(panel));
        add(panel, 0);
        updateUI();
        return panel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightMenu = new java.awt.PopupMenu();
        leftPanel = new javax.swing.JPanel();
        rightPanel = new panelClass1();

        rightMenu.setActionCommand("popupMenu");
        rightMenu.setLabel("popupMenu1");
        rightMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightMenuActionPerformed(evt);
            }
        });
        menuItem1.setLabel("insertPictureFrame");
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem1_actionPerformed(e);
            }
        });
        menuItem2.setLabel("insertTextArea");
        menuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuItem2_actionPerformed(e);
            }
        });
        this.addMouseListener(new MouseRightListen());
        rightMenu.add(menuItem1);
        rightMenu.add(menuItem2);
        add(rightMenu);

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        DropTarget dropTarget = new DropTarget(leftPanel,new DragAndDropDropTargetListener());
        leftPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(2, 2));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        DropTarget dropTarget2 = new DropTarget(rightPanel,new DragAndDropDropTargetListener());
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new java.awt.Dimension(2, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rightMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rightMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel leftPanel;
    private java.awt.PopupMenu rightMenu;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
      void menuItem1_actionPerformed(ActionEvent e) {
          this.mainFrame.pictureFrameMenuActionPerformed();
}
 void menuItem2_actionPerformed(ActionEvent e) {
        this.mainFrame.textBoxMenuActionPerformed();
}
 
     public class MouseRightListen extends MouseAdapter 
     {
         @Override
         public void mousePressed(MouseEvent e) {
                int mods=e.getModifiers();
               if((mods&InputEvent.BUTTON3_MASK)!=0&&getRec(e.getPoint())==-1){
               rightMenu.show(centerPanel.this,e.getX(),e.getY());
               }
            }
     }
 
    public class MouseListen extends MouseAdapter 
        {
          @Override
           public void mouseClicked(MouseEvent e) {
                if(myList.isEmpty())
                    return;
                p1=e.getLocationOnScreen();
                p1.x-=centerPanel.this.getLocationOnScreen().x;
                p1.y-=centerPanel.this.getLocationOnScreen().y;
                 currentSquareIndex = getRec(p1);
                 if(currentSquareIndex>=0){              
                northWest.setVisible(true);
                north.setVisible(true);
                northEast.setVisible(true);
                east.setVisible(true);
                southEast.setVisible(true);
                south.setVisible(true);
                southWest.setVisible(true);
                west.setVisible(true);
                 isSelected = currentSquareIndex;
                 myList.get(isSelected).setBorder(new LineBorder(Color.BLACK, 4));

              //   System.out.printf("in");
                 inout = false;
                //myList.get(isSelected).repaint();
                 }
                 else 
                 {
             //        isSelected = currentSquareIndex;
                    inout = true;
                     myList.get(isSelected).setBorder(new LineBorder(Color.BLUE, 1));
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    northWest.setVisible(false);
                    north.setVisible(false);
                    northEast.setVisible(false);
                    east.setVisible(false);
                    southEast.setVisible(false);
                    south.setVisible(false);
                    southWest.setVisible(false);
                  west.setVisible(false);
             //   System.out.printf("out");
               // myList.get(currentSquareIndex).repaint();
                 }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(myList.isEmpty())
                    return;
                p1 = e.getPoint();
         //        p1=e.getLocationOnScreen();
          //      p1.x-=this.getLocationOnScreen().x;
            //    p1.y-=this.getLocationOnScreen().y;
                 currentSquareIndex = getRec(p1);   
                // isSelected = currentSquareIndex;
               if(inout){
                    System.out.printf("out");
                moveEnable = true;
               }
               else if(!inout)
               {
                   moveEnable = false;}
             //   p1 = e.getPoint();
            }
        @Override
           public void mouseReleased(MouseEvent e) {
             if(myList.isEmpty())
                    return;
              p1 = e.getLocationOnScreen();
                    if(currentSquareIndex>=0){
                     if(getCursor().getType()!=Cursor.DEFAULT_CURSOR){
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                   }  

               if(inout){
                    System.out.printf("out");
                moveEnable = true;
               }
              else
               {
                   moveEnable = false;}
                point1 = null;
                point2 = null;
               // p1=null;
                }
                       x = myList.get(isSelected).getX();
                        y = myList.get(isSelected).getY(); 
                        w = myList.get(isSelected).getWidth();
                        h = myList.get(isSelected).getHeight(); 
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(myList.isEmpty())
                    return;
                if (isSelected>=0) {
                    if (e.getComponent() == northWest) {
                    setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                    } else if (e.getComponent() == north) {
                    setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                    } else if (e.getComponent() == northEast) {
                    setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
                    } else if (e.getComponent() == east) {
                    setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
                    } else if (e.getComponent() == southEast) {
                    setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
                    } else if (e.getComponent() == south) {
                    setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
                    } else if (e.getComponent() == southWest) {
                    setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
                    } else if (e.getComponent() == west) {
                    setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
                    }else if(e.getComponent() == centerPanel.this){ 
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(myList.isEmpty())
                    return;
                if(e.getComponent() == centerPanel.this){ 
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                 if(myList.isEmpty())
                    return;
               // p1 = e.getPoint();
                  if(isSelected>=0){
                         x = myList.get(isSelected).getX();
                        y = myList.get(isSelected).getY(); 
                        w = myList.get(isSelected).getWidth();
                        h = myList.get(isSelected).getHeight();           

                        int type = getCursor().getType();
                        switch (type) {
                        case Cursor.NW_RESIZE_CURSOR://西北
                        if(w - e.getX() >20&& h - e.getY()>20){
                        w = w -e.getX();
                        h = h - e.getY();
                        myList.get(isSelected).setBounds(x + e.getX(), y+e.getY(), w, h);
                        } 
                        break;
                        case Cursor.N_RESIZE_CURSOR://北
                        if(h-e.getY()>20){
                        h = h -e.getY();
                        myList.get(isSelected).setBounds(x, y +  e.getY(),w, h);
                        }
                        break;
                        case Cursor.NE_RESIZE_CURSOR://東北
                        if(w + e.getX()>20 && h - e.getY()>20){
                        w = w +e.getX();
                        h = h -e.getY();
                        myList.get(isSelected).setBounds(x, y + e.getY(),w, h);
                        }
                        break;
                        case Cursor.E_RESIZE_CURSOR://東
                        if(w + e.getX()>20){
                        w = w + e.getX();
                        myList.get(isSelected).setBounds(x, y, w, h);
                        }
                        break;
                        case Cursor.SE_RESIZE_CURSOR://東南
                        if(w + e.getX()>20&& h + e.getY()>20){
                        w = w + e.getX();
                        h = h + e.getY();
                        myList.get(isSelected).setBounds(x, y, w, h);
                        }
                        break;
                        case Cursor.S_RESIZE_CURSOR://南
                        if(h+e.getY()>20){
                        h = h +e.getY();
                        myList.get(isSelected).setBounds(x, y, w, h);
                        }
                        break;
                        case Cursor.SW_RESIZE_CURSOR://西南
                        if(w-e.getX()>20&& h+e.getY()>20){
                        w = w - e.getX();
                        h = h +e.getY();
                        myList.get(isSelected).setBounds(x + e.getX(), y,w, h);
                        }
                        break;
                        case Cursor.W_RESIZE_CURSOR://西
                        if(w-e.getX()>20){
                        w = w -  e.getX();
                        myList.get(isSelected).setBounds(x + e.getX(), y,w, h);
                        }
                         break;
                        case Cursor.DEFAULT_CURSOR://拖動操作
                        if(moveEnable){
                           int moveX = e.getPoint().x - p1.x;
                           int moveY = e.getPoint().y - p1.y;
                            Point orgin = myList.get(isSelected).getLocation();
                           myList.get(isSelected).setBounds(orgin.x + moveX,orgin.y + moveY,w,h);
                               x=orgin.x + moveX;
                                y=orgin.y + moveY;         
                        }
                            break;
                        default: 
                        break;
                        }        

                        northWest.setBounds(0, 0, 5, 5);
                        north.setBounds((w - 3) / 2, 0, 5, 5);
                        northEast.setBounds(w - 5, 0, 5, 5);
                        east.setBounds(w - 5, (h - 3) / 2,5, 5);
                        southEast.setBounds(w - 5, h - 5, 5, 5);
                        south.setBounds((w - 3) / 2, h - 5,5, 5);
                        southWest.setBounds(0, h - 5, 5, 5);
                        west.setBounds(0, (h - 3) / 2, 5, 5);
                        myList.get(isSelected).repaint(); 

                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
               p1=e.getLocationOnScreen();
              p1.x-=centerPanel.this.getLocationOnScreen().x;
             p1.y-=centerPanel.this.getLocationOnScreen().y;
            currentSquareIndex = getRec(p1);
         if( currentSquareIndex>=0){
         isSelected = currentSquareIndex;      
         }
            }
        }
    
    
    
      private int getRec(Point pt) {
        Point touch = new Point(pt);
        System.out.printf("pt-%d,%d\n",pt.x,pt.y);
        if(myList.isEmpty())
            return -1;
        for (int i = myList.size()-1; i >= 0 ; i--) {
            System.out.printf("%d--%d,%d\n",i,myList.get(i).getLocation().x,myList.get(i).getLocation().y);
            touch.setLocation(pt.x-myList.get(i).getX(), pt.y-myList.get(i).getY());
            if (myList.get(i).contains(touch)) {
                System.out.println( i );
                return i;
            }
        }
        
        return -1;
    }
      
      
    class DragAndDropDropTargetListener implements DropTargetListener
    {

        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
            }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {
       }

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {
        }

        @Override
        public void dragExit(DropTargetEvent dte) {
        }

        @Override
        public void drop(DropTargetDropEvent dtde) {
            Transferable tr=dtde.getTransferable();
            JLabel s = null;
            try { 
            if(tr.isDataFlavorSupported(DataFlavor.stringFlavor)){ 
                s = (JLabel) tr.getTransferData(DataFlavor.stringFlavor); 
            } 
            } catch (IOException ex) { 
            } catch (UnsupportedFlavorException ex) { 
            } 
            
            DropTarget c=(DropTarget)dtde.getSource(); 
            JPanel d=(JPanel)c.getComponent(); 
            for(int i = 0;i < d.getComponentCount();i++)
                if(d.getComponent(i).getClass()==JLabel.class)
                    d.remove(i);
            d.setLayout(new OverlayLayout(d));
            //d.setBackground(new Color(0,0,0,0));
            s.addMouseListener(new MouseListen());
            s.addMouseListener(new MouseRightListen());
            s.addMouseMotionListener(new MouseListen());
            ImageIcon image = (ImageIcon) s.getIcon();
            image.setImage(image.getImage().getScaledInstance(d.getWidth(),d.getHeight(),Image.SCALE_DEFAULT));
            //anotherIcon.setImage(getScaledImage(anotherIcon.getImage(),d.getWidth(),d.getWidth()));
            s.setIcon(image);
            d.add(s,0);
            d.updateUI();
            
        }
    }

}
