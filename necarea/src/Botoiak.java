import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;

import javax.swing.*;
import java.awt.*;

public class Botoiak extends JFrame{

    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
	
	
    public void Botoiak() {
    	this.setTitle("Botoien adibidea");
    	jButton1.setText("Pelikulak");
    	jButton2.setText("Pertsonak");
    	jButton3.setText("Etiketak");
    	this.getContentPane().add(jButton3, BorderLayout.EAST);
    	this.getContentPane().add(jButton2, BorderLayout.CENTER);
    	this.getContentPane().add(jButton1, BorderLayout.WEST);
    }

    public static void main(String[] args){
    	Frame frame= new Botoiak();
    	frame.setVisible(true);
    }	
}
