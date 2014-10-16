package ru.xo.view;



import ru.xo.controller.FieldController;
import ru.xo.model.Cell;
import ru.xo.model.Coordinate;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Scanner;
import java.io.File; 
import java.io.IOException;

import javax.sound.sampled.*;

public class FieldView extends JPanel{

    public FieldController fieldController;
    public Cell.CellMark player;

    public FieldView(FieldController fieldController) {
        this.fieldController = fieldController;
        this.player = Cell.CellMark.X;
        setupUI();
    }

    private void setupUI(){
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(3, 3, 2, 2));
        this.setSize(120, 120);
        Cell[][] cells = fieldController.getCells();
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                JButton button = new JButton();
                button.setFocusable(false);
                button.setFont(new Font("Arial", Font.BOLD, 35));
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.addActionListener(new CellActionListener(new Coordinate(j,i)));
                this.add(button);
            }
        }
    }

    private class CellActionListener implements ActionListener{

        private Coordinate cellPosition;
        private Scanner sc = new Scanner(System.in);
        public void sound(){
        	try {  
        		File soundFile = new File("plak.wav");         
        		AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
        		Clip clip = AudioSystem.getClip();
        		clip.open(ais);
        		clip.setFramePosition(0);
        		clip.start();                
        	} catch(IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
        	    exc.printStackTrace();   }     	
        }
        
         
        public CellActionListener(Coordinate cellPosition) {
            this.cellPosition = cellPosition;                    
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            button.setText(player == Cell.CellMark.X ? "X" : "O");
            button.setForeground(player == Cell.CellMark.X ? Color.GREEN : Color.RED);
            button.removeActionListener(this);
            sound();
            FieldView.this.fieldController.markCell(cellPosition, FieldView.this.player);
            FieldView.this.player = player == Cell.CellMark.X ? Cell.CellMark.O : Cell.CellMark.X;
        }
    }
}
