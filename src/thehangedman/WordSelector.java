package thehangedman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class WordSelector {
    private final int numberOfWords;
    private final String PATH = "src\\thehangedman\\Words.txt";
    private final Random random = new Random();
    private String word;
    
    /**
     * konstruktor vytvori objekt, ktery spocita slova v souboru a jedno naahodne vybere
     * a prevede na pole pismen word. Jedina public metoda getRandomWord() vraci nahodne slovo
     */
    public WordSelector(){
        numberOfWords=setNumberOfWords();
    }
    /**
     * metoda spocita slova v souboru
     * @return number of words
     */
    private int setNumberOfWords(){
        int i=0;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(new File(PATH)));
            String s;
            while((s=bfr.readLine())!=null){//cte po radcich, dokud hodnota neni null
                ++i;//pocitadlo ctenych radku
            }
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "chyba souboru", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
    
    /**
     * metoda vytvori nahodne cislo az do vyse poctu slov v souboru
     * @return random number
     */
    private int getRandomNumber(){
        return random.nextInt(numberOfWords)+1;//+1 aby v setRandomWord nebylo null
    }
    
    /**
     * metoda vybere slovo na radku urcenem nahodnym cislem
     * @return random word
     */
    private void generateRandomWord(){
        BufferedReader bfr;
        try {
            bfr = new BufferedReader(new FileReader(new File(PATH)));
            for(int i = 0; i<getRandomNumber(); ++i){  //hodni hranice cyklu je nahodne cislo dane metodou getRandomNumber()
            word=bfr.readLine();  //na konci cyklu bude v promenne word posledni cteny radek
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "chyba souboru", JOptionPane.ERROR_MESSAGE);
        }
    } 
    /**
     * verejna metoda vracejici nahodne slovo
     * @return random word charArray
     */
    public String getRandomWord(){
        generateRandomWord();
        return word;
    }
}
