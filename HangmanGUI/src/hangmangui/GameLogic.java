package hangmangui;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author kfcomputerscience2
 */
public class GameLogic 
{
    Random random=new Random();
    Scanner input=new Scanner(System.in);
    String wordDisplay;
    String word=getWordUser();// can switch between get word and get word word bank
    char[] beenDone=new char[30];
    int counter=0;
       
    String[] kylesBank()
    {
        String[] wordBank={"random", "craft", "whiz", "combs", "wreck", "ambidextrous", "lynch", "frown", "quartz", "plight", "debt", "refactor", "file", "default", "multiple", "project", "retro", "ski", "page", "fusion", "atomic", "bank", "java", "mention", "athletic", "sign", "zoom", "mind", "aardvark", "design", "weather", "share", "detail", "program", "season", "lavender", "acrimomy", "concatenate", "logitech", "compose", "circle", "draft", "xbox", "skins", "word", "void", "ignore", "used", "dynamic", "pharmicist", "algebra", "sphere", "bowl", "puzzles", "website", "binary", "converter", "inbox", "twitter", "rubix", "bananas", "wrecking","nutrition","purification","bandwagon","peeking","pneumonia","pneumatic","keyhole","microwave","razzmatazz","schizophrenia","whomever","rhubarb","zodiac","menapause", "tortilla"};
        return wordBank;
    }
    char[] initializeLettersUsed()
    {
        char[] lettersUsed=new char [26];
        for (int i=0; i<26; i++)
                   lettersUsed[i]=' ';                   
        return lettersUsed;
    }
    String lettersUsed(String used, char guess)
    {
        used+=guess+" ";
        return used;
    }
    boolean beenDone(char guess)
    {
        if (counter>0)
        {
            for (int i=0; i<counter; i++)
            {
                if(beenDone[i]==guess)
                    return true;
            }
        }
        beenDone[counter]=guess;
        counter++;
        return false;
    }
    char[] initializeLettersGuessed(int length)
    {
        char[] lettersGuessed=new char[length];
        for (int i=0; i<length; i++)
            lettersGuessed[i]='_';
        return lettersGuessed;
    }
    int wonCounter( int length, char guess, char[] letters, boolean contains, int[] positions, int howManyLetters, char[] lettersGuessed){
          
        int wonCounter = 0;        
        for (int i=0; i<length; i++)
        {
            if (lettersGuessed[i]!='_')
                wonCounter++;
        }
         return wonCounter;   
    }
    String getWord()
    {
        String[] wordBank=kylesBank();
        String word=wordBank[random.nextInt(wordBank.length)];
        System.out.println(wordBank.length);
        return word;
    }
    
    String getWordUser()
    {
        String word=JOptionPane.showInputDialog("Enter Word");
        word=word.toLowerCase();
        word=word.trim();
        return word;
    }
    char getGuess()
    {
        String guessString=JOptionPane.showInputDialog("Enter Guess");
        guessString=guessString.toLowerCase();
        guessString=guessString.trim();
        char guess=guessString.charAt(0);
        return guess;
    }
    boolean containsGuess(int length, char guess, char[] letters)
    {
        int counter=0;
        for (int i=0; i<length; i++)
        {
            if (letters[i]==guess)
                counter++;
        }
        if (counter>=1)
                return true;
        else 
            return false;
    }
    String[] stacysBank(){
        String[] wordBank={"astronomy","mansion","frisbee","architect","opossum","rosetta","suite","concoction","fjord","syzygy","assassinate","aristocrat","zimbabwe"};
        return wordBank;
    }
    String wordDisplay(int length, char guess, char[] letters, boolean contains, int[] positions, int howManyLetters, char[] lettersGuessed)
    {
          String wordDisplay="";
            if (contains==true)
            {
                for (int i=0; i<howManyLetters; i++)
                    lettersGuessed[positions[i]]=guess;                 
            }
        for (int i=0; i<length; i++)
        {
            wordDisplay+=lettersGuessed[i]+" ";
        }
        return wordDisplay;   
    }
    int howManyLetters(int length, char[] letters, char guess)
    {
        int counter=0;
        for (int i=0; i<length; i++){
            if (letters[i]==guess)
                counter++;       
        }
        return counter;
    }   
    int[] getPosition(int length, char[] letters, char guess)
    {
        int counter=0;
        int pCounter=0;
        for (int i=0; i<length; i++){
            if (letters[i]==guess)
                counter++;
        }
        int[] positions=new int[counter];
        for (int i=0; i<length; i++){
            if (letters[i]==guess){
                positions[pCounter]=i;
                pCounter++;
            }
        }
        return positions;
    }
    int getLength(String guess)
    {
        return guess.length();
    }
    char[] getChar(String word, int length) 
    {
        char [] letters=new char[length];
        
        for (int i=0; i<length; i++)
            letters[i]=word.charAt(i);
        return letters;
    }
}
