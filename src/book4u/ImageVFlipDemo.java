package book4u;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ConvolveOp;
import java.awt.image.IndexColorModel;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;
public class ImageVFlipDemo extends JComponent {
    BufferedImage bi, orig;
    BufferedImage bi2, bi3;// �w�ƥ�
    RotateComponent temp;
    DisplayPanel displayPanel;
    int flag, i, j, k, s;
    float light, cont;
    boolean isEntered = false;
    public ImageVFlipDemo() {
    	
    }
    public ImageVFlipDemo(BufferedImage s) {
    	bi = s;
    	bi2 = s;
    	bi3 = s;
    	orig = s;
    	this.add(new JLabel(new ImageIcon(bi)));
        //this.pack();
        this.setVisible(true);;
    }
    BufferedImage getImage(){
    	return bi;
    }
    /*public void TRescaleOp(int flag, float light, float cont){ // flag = 1, light. flag = 0, cont.
    	removeAll();
    	this.flag = flag;
    	this.light = light;
    	this.cont = cont;
    	//bi2 = bi;
    	isEntered = true;
    	displayPanel = new DisplayPanel(bi);
    	displayPanel.changeOffSet(flag,light);
    	displayPanel.changeScaleFactor(flag, cont);
		displayPanel.rescale();
	    displayPanel.repaint();
        System.out.println(cont+"+"+light);
        bi = displayPanel.getImage();
        ImageVFlip(  i,  j,  k,  s);
        this.add(new JLabel(new ImageIcon(displayPanel.getImage())));
        this.setVisible(true);
        //return this;
    }*/
    public void  ImageVFlip( int i, int j, int k, int s,int flag, float light, float cont, int re) {		// i ����W�U���k����  j����
    	this.removeAll();
    	this.i = i;
    	this.j = j;
    	this.k = k;
    	this.s = s;
    	bi = orig;
    	if(s == 1){
	    	displayPanel = new DisplayPanel(bi);
	    	displayPanel.changeOffSet(flag,light);
	    	displayPanel.changeScaleFactor(flag, cont);
			displayPanel.rescale();
		    displayPanel.repaint();
		    bi = displayPanel.getImage();
		    isEntered = true;
    	}
    	if(!isEntered) bi = orig;
    	switch(flag){
    		case 1:
    			displayPanel = new DisplayPanel(bi,false);
    			displayPanel.sharpen();
    			displayPanel.repaint();
    			bi = displayPanel.getImage();
    		case 2:
    			displayPanel = new DisplayPanel(bi,false);
    			displayPanel.blur();
    			displayPanel.repaint();
    			bi = displayPanel.getImage();
    		case 3:
    			displayPanel = new DisplayPanel(bi,false);
    			displayPanel.sharpen();
    			displayPanel.blur();
    			displayPanel.repaint();
    			bi = displayPanel.getImage();
    		case 0:
    			displayPanel = new DisplayPanel(bi,false);
    			displayPanel.reset();
    			displayPanel.repaint();
    			bi = displayPanel.getImage();
    	}
    	if(re == 1){
    		displayPanel = new DisplayPanel(bi,true);
    		displayPanel.reverseLUT();
            displayPanel.applyFilter();
            displayPanel.repaint();
            bi = displayPanel.getImage();
    	}else if(re == -1){
    		displayPanel = new DisplayPanel(bi,true);
    		displayPanel.reset();
            displayPanel.repaint();
            bi = displayPanel.getImage();
    	}
        //super("javahome.idv.tw");
    	
        //this.setLayout(new GridLayout());
        //System.out.println(i+" & "+this.i);
        switch(i){
        	case 0:
        		break;
        	case 1:
        		bi = flip(bi);
        		break;
        	case 2:
        		bi = flip2(bi);
        		break;
        	case 3:
        		bi = flip2(flip(bi));
        		break;
        }
    	if(j == 1){
    		//bi = orig;
    	}else{		
    		temp = new RotateComponent(bi, j);
    		bi = temp.rotateImage(bi, j);        	
    	}
        if(k == 0){
        	//bi = orig;
        }else if(k == 1){
        	bi = IndexColorImage(bi);
        }else if(k == 2){
        	bi =  getGrayImage(bi);
        }
        isEntered = false;
        
        //JPanel panel = new JPanel();
        //panel.setLayout(new OverlayLayout(panel));
        //panel.add(new JLabel(new ImageIcon(bi)));
        //add(panel);
        //this.setVisible(true);
        //TRescaleOp(flag, light, cont);
        //return this;
        
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(bi, 0, 0, this);
    }
    /*public JPanel getPanel(){
    	return this;
    }*/
    public static BufferedImage flip(BufferedImage img) {				// �W�U����
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(w, h, img.getColorModel()
                .getTransparency());
        Graphics2D g2 = dimg.createGraphics();
        g2.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);
        g2.dispose();
        return dimg;
    }
    public static BufferedImage flip2(BufferedImage img) {				// ���k����
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(w, h, img.getType());
        Graphics2D g2 = dimg.createGraphics();
        g2.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g2.dispose();
        return dimg;
    }
    public BufferedImage IndexColorImage(BufferedImage image) {			// �¥�
        byte[] map = {0, 0, 0, (byte)255, (byte)255, (byte)255}; 
        IndexColorModel cm = new IndexColorModel(8, 2, map, 0, false, 1); 
        BufferedImage img = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_BYTE_INDEXED, cm);
        Graphics2D g2 = img.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return img;
    }
    BufferedImage getGrayImage(BufferedImage bi) {						// �Ƕ�
        BufferedImage img = new BufferedImage(bi.getWidth(), bi.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2 = (Graphics2D) img.getGraphics();
        g2.drawImage(bi, 0, 0, null);
        g2.dispose();
        return img;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageVFlipDemo();
            }
        });
    }
}
class RotateComponent extends JComponent {
    BufferedImage bi;
    int theta;
    public BufferedImage getImage(){
    	return bi;
    }
    public RotateComponent(BufferedImage bi, int theta) {
        this.bi = bi;
        this.theta = theta;
    }
    public Dimension getPreferredSize() {
        int max = Math.max(bi.getWidth(), bi.getHeight());
        return new Dimension(max, max);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        bi = rotateImage(bi, theta);
        g2.drawImage(bi, 0, 0, null);
    }

    BufferedImage rotateImage(BufferedImage sourceBI, float theta) {
        AffineTransform at = new AffineTransform();
        at.rotate(Math.toRadians(theta), sourceBI.getWidth() / 2,
                sourceBI.getHeight() / 2);
        BufferedImageOp bio = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BILINEAR);
        return bio.filter(sourceBI, null);
    }
    
}
class DisplayPanel extends JPanel {
    BufferedImage displayImage;
    BufferedImage biSrc, biDest, bi; 
    Graphics2D big;
    RescaleOp rescale;
    float scaleFactor = 1.0f;
    float offset = 10;
    boolean brighten, contrastInc;
    LookupTable lookupTable;
    DisplayPanel(BufferedImage bis, boolean option) {
        //setBackground(Color.gray); // panel background color
        loadImage(bis);
        setSize(displayImage.getWidth(this), displayImage.getWidth(this)); // panel
        if(option == true){
        	createBufferedImage(option);
        }else{
        	createBufferedImages2();
            bi = biSrc;
        }
    }
    public void createBufferedImages2() {
        biSrc = new BufferedImage(displayImage.getWidth(this), displayImage
            .getHeight(this), BufferedImage.TYPE_INT_RGB);

        big = biSrc.createGraphics();
        big.drawImage(displayImage, 0, 0, this);

        biDest = new BufferedImage(displayImage.getWidth(this), displayImage
            .getHeight(this), BufferedImage.TYPE_INT_RGB);
      }
    public void createBufferedImage(boolean option) {
        bi = new BufferedImage(displayImage.getWidth(this), displayImage
            .getHeight(this), BufferedImage.TYPE_INT_ARGB);

        big = bi.createGraphics();
        big.drawImage(displayImage, 0, 0, this);
      }

    public void sharpen() {
      float data[] = { -1.0f, -1.0f, -1.0f, -1.0f, 9.0f, -1.0f, -1.0f, -1.0f,
          -1.0f };
      Kernel kernel = new Kernel(3, 3, data);
      ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
          null);
      convolve.filter(biSrc, biDest);
      bi = biDest;
    }

    public void blur() {
      float data[] = { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f,
          0.0625f, 0.125f, 0.0625f };
      Kernel kernel = new Kernel(3, 3, data);
      ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
          null);
      convolve.filter(biSrc, biDest);
      bi = biDest;
    }
    public void reset(boolean option) {
        big.setColor(Color.black);
        big.clearRect(0, 0, bi.getWidth(this), bi.getHeight(this));
        big.drawImage(displayImage, 0, 0, this);
        bi = biSrc;
      }

	public void reverseLUT() {
	    byte reverse[] = new byte[256];
	    for (int i = 0; i < 256; i++) {
	      reverse[i] = (byte) (255 - i);
	    }
	    lookupTable = new ByteLookupTable(0, reverse);
	}
	
	public void reset() {
	    big.setColor(Color.black);
	    big.clearRect(0, 0, bi.getWidth(this), bi.getHeight(this));
	    big.drawImage(displayImage, 0, 0, this);
	}
	
	public void applyFilter() {
	    LookupOp lop = new LookupOp(lookupTable, null);
	    lop.filter(bi, bi);
	}

    public DisplayPanel(BufferedImage sbi) {
        setBackground(Color.black); 
        loadImage(sbi);
        setSize(displayImage.getWidth(this),
                displayImage.getWidth(this));
        createBufferedImages();
        
    }
    public BufferedImage getImage(){
    	return bi;
    }
    public void loadImage(BufferedImage sbi) {
        displayImage = sbi;
    }

    public void createBufferedImages() {
        biSrc = new BufferedImage(displayImage.getWidth(this),
                                  displayImage.getHeight(this),
                                  BufferedImage.TYPE_INT_RGB);

        big = biSrc.createGraphics();
        big.drawImage(displayImage, 0, 0, this);

        biDest = new BufferedImage(displayImage.getWidth(this),
                                   displayImage.getHeight(this),
                                   BufferedImage.TYPE_INT_RGB);
        bi = biSrc;
    }

    public void changeOffSet(int flag, float light) {
        //if (flag == 1 || flag == 0) {
            if (offset < 255 && offset > -255)
               offset = light;
        //}
    }

    public void changeScaleFactor(int flag, float cont) {
        //if (flag == 0 || flag == 1) {
            if (scaleFactor < 2 && scaleFactor > 0)
                scaleFactor = cont+1.0f;
        //}
    }

    public void rescale() {
    	//System.out.println(offset+"+"+scaleFactor);
        rescale = new RescaleOp(scaleFactor, offset, null);
        rescale.filter(biSrc, biDest);
        bi = biDest;
    }

    public void update(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        paintComponent(g);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(bi, 0, 0, this);
    }
    
}
