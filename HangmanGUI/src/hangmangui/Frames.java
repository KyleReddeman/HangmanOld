package hangmangui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kfcomputerscience2
 */
public class Frames {

    JLabel displayWord = new JLabel();
    JLabel displayLettersUsed = new JLabel();
    JLabel picLabel;
    Paint paint = new Paint();
    JPanel panel = new JPanel();
    JPanel playPanel = new JPanel();
    JFrame frame = new JFrame();
    JFrame hangFrame = new JFrame();
    JFrame playFrame = new JFrame();
    JButton button = new JButton("GUESS");
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");
    
    
    GameLogic gameLogic = new GameLogic();//*****************************************
    int wonCounter = 0;  //**********************************************************
  //  String word = "df";//gameLogic.getWord();//can switch between getWord() and getWordUser()
    String word = gameLogic.word;
    String used = " ";//*************************************************************
    int length = gameLogic.getLength(word);//****************************************
    int counter = 0;
    int incorrectCounter = 0;
    char[] letters = gameLogic.getChar(word, length);
    char[] lettersGuessed = gameLogic.initializeLettersGuessed(length);
    char[] lettersUsed = gameLogic.initializeLettersUsed();
    
    void close()
    {
        frame.dispose();
        playFrame.dispose();
        hangFrame.dispose();
    }

    public Frames() 
    {
        
        
        Font font = button.getFont();
        button.setFont(new Font(font.getName(), Font.PLAIN, 25));
        displayWord.setFont(new Font(font.getName(), Font.PLAIN, 25));
        displayLettersUsed.setFont(new Font(font.getName(), Font.PLAIN, 25));
        
        ImageIcon image= new ImageIcon(getClass().getResource("hangedMan.jpeg"));
        picLabel = new JLabel(image);
                
                
        frame.setVisible(true);
        frame.setLayout(new GridLayout(1, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 800);
        
        panel.setLayout(null);
        panel.setBackground(new Color(127,255,212));
        
       
        
        button.setBounds(20,0,100,100);
        displayWord.setBounds(20,100,720,100);
        displayLettersUsed.setBounds(20,200,720,100);
        
        //panel.add(button);
        panel.add(displayWord);
        panel.add(displayLettersUsed);
        panel.addKeyListener(new keys());
        
        //button.addActionListener(new guess());
        button.addKeyListener(new keys());
        frame.addKeyListener(new keys());

        frame.add(paint);
        frame.add(panel);
        paint.addKeyListener(new keys());
        

        
        
        playPanel.setLayout(null);
        yes.setBounds(10, 10, 180, 150);
        no.setBounds(210, 10, 180, 150);
        yes.addActionListener(new yes());
        no.addActionListener(new no());
        yes.setFont(new Font(font.getName(), Font.PLAIN, 50));
        no.setFont(new Font(font.getName(), Font.PLAIN, 50));
        yes.setForeground(new Color(128, 30, 35));
        no.setForeground(new Color(128, 30, 35));
        
        playPanel.add(yes);
        playPanel.add(no);
        playPanel.addKeyListener(new keys());
        playPanel.setBackground(new Color(127, 225, 220));
        
        playFrame.setTitle("Play Again");
        playFrame.setSize(400, 190);
        playFrame.setLocation(520, 200);
        playFrame.add(playPanel);
        playFrame.addKeyListener(new keys());
        
        
    }

    class guess implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            char guess = gameLogic.getGuess();
            //boolean beenDone= 
            boolean contains = gameLogic.containsGuess(length, guess, letters);
            int[] positions = gameLogic.getPosition(length, letters, guess);
            int howManyLetters=gameLogic.howManyLetters(length, letters, guess);
            String wordDisplay=gameLogic.wordDisplay(length, guess, letters, contains, positions, howManyLetters, lettersGuessed);
            used= gameLogic.lettersUsed(used, guess);
            displayWord.setText(wordDisplay);
            displayLettersUsed.setText(used);
            int wonCounter=gameLogic.wonCounter(length, guess, letters, contains, positions, howManyLetters, lettersGuessed);
            if(contains==false)
            {
                
                paint.repaint();
                incorrectCounter++;  
                
            }
            if(incorrectCounter>5)
            {
                JOptionPane.showMessageDialog(null, "Sorry You Lost!\nThe Correct Word Was: "+word, "Lost", 1);
                hangFrame.setVisible(true);
                hangFrame.setDefaultCloseOperation(hangFrame.EXIT_ON_CLOSE);
                hangFrame.add(picLabel);
                hangFrame.pack();
                playFrame.setVisible(true);
                
            }
            if(wonCounter==length)
            {
                JOptionPane.showMessageDialog(null, "You Won!", "Won", 1);
                playFrame.setVisible(true);
            }
            counter++;     
            
        }

    }
    class yes implements ActionListener 
    {

        public void actionPerformed(ActionEvent e) 
        {
            close();
            Frames frames = new Frames();
        }

    }
    class no implements ActionListener 
    {

        public void actionPerformed(ActionEvent e) 
        {
            close();
        }

    }
    class keys implements KeyListener
    {

        public void keyTyped(KeyEvent e) 
        {
            
        }

        public void keyPressed(KeyEvent e) 
        {
            
            char guess =e.getKeyChar();
            boolean beenDone=gameLogic.beenDone(guess);
            if (beenDone==false)
            {
            boolean contains = gameLogic.containsGuess(length, guess, letters);
            int[] positions = gameLogic.getPosition(length, letters, guess);
            int howManyLetters=gameLogic.howManyLetters(length, letters, guess);
            String wordDisplay=gameLogic.wordDisplay(length, guess, letters, contains, positions, howManyLetters, lettersGuessed);
            used= gameLogic.lettersUsed(used, guess);
            displayWord.setText(wordDisplay);
            displayLettersUsed.setText(used);
            int wonCounter=gameLogic.wonCounter(length, guess, letters, contains, positions, howManyLetters, lettersGuessed);
            if(contains==false)
            {
                
                paint.repaint();
                incorrectCounter++;  
                
            }
            if(incorrectCounter>5)
            {
                JOptionPane.showMessageDialog(null, "Sorry You Lost!\nThe Correct Word Was: "+word, "Lost", 1);
                hangFrame.setVisible(true);
                hangFrame.setDefaultCloseOperation(hangFrame.EXIT_ON_CLOSE);
                hangFrame.add(picLabel);
                hangFrame.pack();
                playFrame.setVisible(true);
                
            }
            if(wonCounter==length)
            {
                JOptionPane.showMessageDialog(null, "You Won!", "Won", 1);
                playFrame.setVisible(true);
            }
            counter++;  
            }
            else
                JOptionPane.showMessageDialog(null, "You already used that letter!", "Go Again", 1);
        }

        public void keyReleased(KeyEvent e)
        {
            
        }
        
    }
           
}
