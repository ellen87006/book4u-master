package book4u;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class imageEdit extends JPanel{
	JFrame frame;
	JPanel panel;
	JLabel label1, angleLabel, picLabel, picMode, Light, Constract;
	JComboBox angleSelect, modeSelect;
	String[] angle = {"�w�]","0��","90��","180��","270��","���ɰw����","�f�ɰw����"};
	String[] mode = {"��l","�¥�","�Ƕ�"};
	JCheckBox topDownRotate;
	JCheckBox leftRightRotate;
	JRadioButton reverseColor;
	JRadioButton reset;
	JCheckBox sharpen;
	JCheckBox blur;
	ButtonGroup bgroup = new ButtonGroup();
	final JSlider light,contract;
	JTextField lightText,contractText;
	private static final Color colorRGB = new Color(98, 134, 167);
	//
	
	ImageVFlipDemo TBR;
	int controli,controlj, controlk, controls;
	int itd =0, ilr =0, ira = 0;
	int flag = 0;
	int reFlag =0;
	
	JPanel pp;
	JScrollPane jsp;
	float lloffset = 10.0f;
	float llscaleFactor = 1.0f;
	CardLayout card;
	//bufImage pic;
	BufferedImage bi;
	boolean yytest = false;
	//
	JPanel call(JPanel pan, String path){
		try{
			bi = ImageIO.read(new File(path));
			TBR = new ImageVFlipDemo(bi);
			yytest = true;
			pan.add(new JLabel(new ImageIcon(bi)));
			pan.updateUI();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.pp = pan;
		pp.updateUI();
		return pp;
	}
	//
	public imageEdit(){
		super(new BorderLayout());
		//frame = new JFrame();
		//frame.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(colorRGB);
		//frame.setVisible(true);
		//frame.setSize(500,500);
		//

		pp = new JPanel();
		/*
		JLabel orig = new JLabel(new ImageIcon(bi));
		JPanel ss = new JPanel();
		ss.add(orig);
		*/
		//  ��������������������  �H�U���ƪ�  ��������������������
		// 
		label1 = new JLabel("��V");
		label1.setBackground(colorRGB);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.anchor = GridBagConstraints.WEST;
		//
		angleLabel = new JLabel("����");
		angleLabel.setBackground(colorRGB);
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.anchor = GridBagConstraints.WEST;
		//
		angleSelect = new JComboBox(angle);
		
		angleSelect.setSelectedIndex(0);
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridx = 0;
		c3.gridy = 1;
		c3.anchor = GridBagConstraints.EAST;
		//
		topDownRotate = new JCheckBox("�W�U����");
		topDownRotate.setBackground(colorRGB);
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridx = 0;
		c4.gridy = 2;
		c4.anchor = GridBagConstraints.WEST;
		//
		leftRightRotate = new JCheckBox("���k����");
		leftRightRotate.setBackground(colorRGB);
		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 0;
		c5.gridy = 3;
		c5.anchor = GridBagConstraints.WEST;
		//
		LineComponent line = new LineComponent(0, 20, 200, 20, Color.WHITE);  //fx,fy,tx,ty
        line.setStroke(new BasicStroke(3f));
        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridx = 0;
        c6.gridy = 4;
        c6.gridwidth = 10;
        c6.anchor = GridBagConstraints.WEST;
		//
        picLabel = new JLabel("�Ϲ��W�j:");
        picLabel.setBackground(colorRGB);
        GridBagConstraints c7 = new GridBagConstraints();
        c7.gridx = 0;
        c7.gridy = 5;
        c7.anchor = GridBagConstraints.WEST;
        //
        reverseColor = new JRadioButton("Reverse Color");
        reverseColor.setBackground(colorRGB);
        GridBagConstraints c8 = new GridBagConstraints();
        c8.gridx = 0;
        c8.gridy = 6;
        c8.anchor = GridBagConstraints.WEST;
        //
        reset = new JRadioButton("�^�_");
        reset.setBackground(colorRGB);
        GridBagConstraints c9 = new GridBagConstraints();
        c9.gridx = 0;
        c9.gridy = 7;
        c9.anchor = GridBagConstraints.WEST;
        //
        picMode = new JLabel("�Ҧ�");
        picMode.setBackground(colorRGB);
        GridBagConstraints c10 = new GridBagConstraints();
        c10.gridx = 0;
        c10.gridy = 8;
        c10.anchor = GridBagConstraints.WEST;
        //
        modeSelect = new JComboBox(mode);
        modeSelect.setSelectedIndex(0);
        GridBagConstraints c11 = new GridBagConstraints();
        c11.gridx = 0;
        c11.gridy = 8;
        c11.anchor = GridBagConstraints.EAST;
        //
        Light = new JLabel("��G��:");
        Light.setBackground(colorRGB);
        GridBagConstraints c12 = new GridBagConstraints();
        c12.gridx = 0;
        c12.gridy = 9;
        c12.anchor = GridBagConstraints.WEST;
        //
        light = new JSlider(-255,255,0);
        light.setBackground(colorRGB);
        GridBagConstraints c13 = new GridBagConstraints();
        c13.gridx = 0;
        c13.gridy = 10;
        c13.anchor = GridBagConstraints.WEST;
        //
        lightText = new JTextField(10);
        lightText.setText("0");
        
        GridBagConstraints c14 = new GridBagConstraints();
        c14.gridx = 0;
        c14.gridy = 11;
        c14.gridwidth = 3;
        c14.anchor = GridBagConstraints.WEST;
        //
        Constract = new JLabel("����");
        Constract.setBackground(colorRGB);
        GridBagConstraints c15 = new GridBagConstraints();
        c15.gridx = 0;
        c15.gridy = 12;
        c15.anchor = GridBagConstraints.WEST;
        //
        contract = new JSlider(-100,100,0);
        contract.setBackground(colorRGB);
        GridBagConstraints c16 = new GridBagConstraints();
        c16.gridx = 0;
        c16.gridy = 13;
        c16.anchor = GridBagConstraints.WEST;
        //
        contractText = new JTextField(10);
        contractText.setText("0");
        GridBagConstraints c17 = new GridBagConstraints();
        c17.gridx = 0;
        c17.gridy = 14;
        c17.anchor = GridBagConstraints.WEST;
        //
        LineComponent line2 = new LineComponent(0, 20, 200, 20, Color.WHITE);  //fx,fy,tx,ty
        line2.setStroke(new BasicStroke(3f));
        GridBagConstraints c18 = new GridBagConstraints();
        c18.gridx = 0;
        c18.gridy = 15;
        c18.gridwidth = 5;
        c18.anchor = GridBagConstraints.WEST;
        //
        sharpen = new JCheckBox("�y�U��");
        sharpen.setBackground(colorRGB);
        GridBagConstraints c19 = new GridBagConstraints();
        c19.gridx = 0;
        c19.gridy = 16;
        c19.anchor = GridBagConstraints.WEST;
        //
        blur = new JCheckBox("�ҽk��");
        blur.setBackground(colorRGB);
        GridBagConstraints c20 = new GridBagConstraints();
        c20.gridx = 0;
        c20.gridy = 17;
        c20.anchor = GridBagConstraints.WEST;
        //  	�������������������� �H�W���ƪ�  ��������������������
        
        //      ���������������� �H�U���ƥ�B�z ����������������
        ImageHandler handler = new ImageHandler();
       
        topDownRotate.addItemListener(handler);
        leftRightRotate.addItemListener(handler);
        reverseColor.addItemListener(handler);
        reset.addItemListener(handler);
        sharpen.addItemListener(handler);
        blur.addItemListener(handler);
        angleSelect.addItemListener(handler);
        modeSelect.addItemListener(handler);
        
        
        light.addChangeListener(new ChangeListener(){
        	@Override 
        	public void stateChanged(ChangeEvent e){
        		lightText.setText(String.valueOf(light.getValue()));
        		lloffset = Integer.parseInt(String.valueOf(light.getValue()))/1.0f;
        		controls = 1;
        		//flag = 1;
        		pp.removeAll();
        		if(yytest){
	        		TBR.ImageVFlip(controli, controlj, controlk,controls, 1, lloffset, llscaleFactor, reFlag);
	        		pp.add(new JLabel(new ImageIcon(TBR.getImage())));
        		}
    			pp.updateUI();
        	}
        });
        light.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                String typed = lightText.getText();
                light.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 4) {
                	System.out.print("ho");
                    return;
                }
                int value = Integer.parseInt(typed);
                light.setValue(value);
            }
        });
        contract.addChangeListener(new ChangeListener(){
        	@Override 
        	public void stateChanged(ChangeEvent e){
        		contractText.setText(String.valueOf(contract.getValue()));
        		llscaleFactor = Integer.parseInt(String.valueOf(contract.getValue()))/100.0f;
        		//flag = 0;
        		controls = 1;
        		pp.removeAll();
        		if(yytest){
        			TBR.ImageVFlip(controli, controlj, controlk,controls, 0, lloffset, llscaleFactor, reFlag);
        			pp.add(new JLabel(new ImageIcon(TBR.getImage())));
        		}
    			pp.updateUI();
        		
        		//TBR.getPanel().updateUI();
        	}
        });
        contract.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke) {
                String typed = contractText.getText();
                contract.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                int value = Integer.parseInt(typed);
                contract.setValue(value);
            }
        });
        //		�������������������� �H�W���ƥ�B�z ��������������������
        //
        bgroup.add(reverseColor);
        bgroup.add(reset);
		panel.add(label1,c1);
		panel.add(angleLabel,c2);
		panel.add(angleSelect,c3);
		panel.add(topDownRotate,c4);
		panel.add(leftRightRotate,c5);
		panel.add(line,c6);
		panel.add(picLabel,c7);
		panel.add(reverseColor,c8);
		panel.add(reset,c9);
		panel.add(picMode,c10);
		panel.add(modeSelect,c11);
		panel.add(Light,c12);
		panel.add(light,c13);
		panel.add(lightText,c14);
		panel.add(Constract,c15);
		panel.add(contract,c16);
		panel.add(contractText,c17);
		panel.add(line2,c18);
		panel.add(sharpen,c19);
		panel.add(blur,c20);
		
		//
		
		
		
		
		//pp.add(BW.getPanel(),"9");
		//panel.updateUI();
		// frame.add(pp,BorderLayout.CENTER);
		//
		if(yytest){
			TBR = new ImageVFlipDemo(bi);
			//pp.add(TBR);
		}
		pp.updateUI();
		//frame2.setLayout(new BorderLayout());
		
		add(panel, BorderLayout.EAST);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new imageEdit();
	}
	private class ImageHandler implements ItemListener{
		
		public void itemStateChanged(ItemEvent e){
			pp.removeAll();
			if(e.getSource() == topDownRotate){
				if(e.getStateChange() == ItemEvent.SELECTED){
					itd = 1;
				}else if(e.getStateChange() == ItemEvent.DESELECTED){
					itd = 0;
				}
			}else if(e.getSource() == leftRightRotate){
				if(e.getStateChange() == ItemEvent.SELECTED){
					ilr = 2;
				}else if(e.getStateChange() == ItemEvent.DESELECTED){
					ilr = 0;
				}
			}else if(e.getSource() == reverseColor){
				reFlag = 1;
			}else if(e.getSource() == reset){
				reFlag = -1;
			}else if(e.getSource() == sharpen){
				if(e.getStateChange() == ItemEvent.SELECTED){
					flag = flag + 1;
				}else if(e.getStateChange() == ItemEvent.DESELECTED){
					if(flag >= 1)
						flag = flag - 1;
				}
			}else if(e.getSource() == blur){
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("flag "+ flag);
					flag = flag + 2;
				}else if(e.getStateChange() == ItemEvent.DESELECTED){
					
					if(flag >= 2)
						flag = flag - 2;
				}
			}else if(e.getSource() == angleSelect){				
				if(e.getStateChange() == ItemEvent.SELECTED){
					if(angle[0].equals(angleSelect.getSelectedItem())){
						// ��ϸ�J 
						controlj = 1;
					} else if(angle[1].equals(angleSelect.getSelectedItem())){
						controlj = 0;
						
					}else if(angle[2].equals(angleSelect.getSelectedItem())){
						controlj = 90;
						
					}else if(angle[3].equals(angleSelect.getSelectedItem())){
						controlj = 180;
					}else if(angle[4].equals(angleSelect.getSelectedItem())){
						controlj = 270;
						
					}else if(angle[5].equals(angleSelect.getSelectedItem())){
						controlj = 90;
						
					}else if(angle[6].equals(angleSelect.getSelectedItem())){
						controlj = -90;
					}
					
				}
			}else if(e.getSource() == modeSelect){
				panel.updateUI();
				if(e.getStateChange() == ItemEvent.SELECTED){
					if(mode[0].equals(modeSelect.getSelectedItem())){
						controlk = 0;
					} else if(mode[1].equals(modeSelect.getSelectedItem())){
						controlk = 1;
						
					} else if(mode[2].equals(modeSelect.getSelectedItem())){
						controlk = 2;
					}
					
				}
			}
			controli = itd+ilr;
			if(yytest){
				TBR.ImageVFlip(controli, controlj, controlk,controls, flag, lloffset, llscaleFactor, reFlag);
				pp.add(new JLabel(new ImageIcon(TBR.getImage())));
			}
			pp.updateUI();
			//card.show(pp,"2");
			
		}
		
	}
	
}
