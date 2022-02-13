package thehangedman;

import java.util.Scanner;

public class Input {
    private String usedChars = " "; //mezera, abych se vyhnul null
    Scanner sc = new Scanner(System.in);
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    public Input(){
    }
    
    /**
     * Metoda odfiltruje z klavesnice vic znaku nez jeden, znak mimo abecedni rozsah, a drive pouzity znak
     * @return odfiltrovany jednopismenny string
     */
    public String getChar(){
        System.out.printf("\nrozsah pismen: %s\nVyber znak:", ALPHABET);
        String s=sc.nextLine();
        s=s.toLowerCase();
        if(s.length()>1){ //porovnani jestli je to jen jeden znak
            System.out.printf("\nZadal jsi vice znaku: %s", s);
            getChar();
        }
        else if(!ALPHABET.contains(s)){ //porovnani, jestli je znak v seznamu
            System.out.printf("\nZadal jsi spatny znak: %s", s);
            getChar();
        }
        else if(usedChars.contains(s)){
            System.out.printf("\nTohle jsi uz zadaval: %s", s);
            getChar();
        }
        usedChars+=s;
        return s;
    }
    public String getUsedChars(){
        return usedChars;
    }
}
