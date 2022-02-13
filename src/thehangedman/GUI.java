package thehangedman;

public class GUI {
    //String LVL0 - LVL7 predstavuji jednotlive urovne sibenice
    private final String LVL4 = "#   ____       #\n";
    private final String LVL3 = "#   |/         #\n";
    private final String LVL2 = "#   |          #\n";
    private final String LVL1 = "#  /|\\         #\n";
    private final String LVL0 = "#  ----------  #\n";
    
    private final String LVL5 = "#   |/ o       #\n";
    private final String LVL6 = "#   | /|\\      #\n";
    private final String LVL7 = "#   | / \\      #\n";
    private final String LVLX = "################\n";
    private final String LVLY = "#              #\n";
    private int lvl=0;

    private char[] secretWord;
    private String gibbet; //retezec, ve kterem se spojuji urovne sibenice

    /**
     *zajistuje graficky vystup
     */
    public GUI(){
        compileGibbet();
    }
    
    /**
     *metoda sestavi sibenici z jednotlivych retezcu
     */
    public void compileGibbet(){
        switch(lvl){
            case 0: gibbet = LVLX + LVLY + LVLY + LVLY + LVLY + LVLY + LVLY + LVL0 + LVLY + LVLX; break;
            case 1: gibbet = LVLX + LVLY + LVLY + LVLY + LVLY + LVLY + LVL1 + LVL0 + LVLY + LVLX; break;
            case 2: gibbet = LVLX + LVLY + LVLY + LVLY + LVL2 + LVL2 + LVL1 + LVL0 + LVLY + LVLX; break;
            case 3: gibbet = LVLX + LVLY + LVLY + LVL3 + LVL2 + LVL2 + LVL1 + LVL0 + LVLY + LVLX; break;
            case 4: gibbet = LVLX + LVLY + LVL4 + LVL3 + LVL2 + LVL2 + LVL1 + LVL0 + LVLY + LVLX; break;
            case 5: gibbet = LVLX + LVLY + LVL4 + LVL5 + LVL2 + LVL2 + LVL1 + LVL0 + LVLY + LVLX; break;
            case 6: gibbet = LVLX + LVLY + LVL4 + LVL5 + LVL6 + LVL2 + LVL1 + LVL0 + LVLY + LVLX; break;
            case 7: gibbet = LVLX + LVLY + LVL4 + LVL5 + LVL6 + LVL7 + LVL1 + LVL0 + LVLY + LVLX; break;
        }
    }
    
    /**
     * Metoda sestavi pole znaku hadaneho slova, neuhadnute znaky nahrazuje pomlckou
     * @param word
     * @param usedChars
     */
    public void compileSecretWord(String word, String usedChars){
        secretWord=word.toCharArray();
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<usedChars.length(); j++){
                if(word.charAt(i)!=usedChars.charAt(j)){
                    secretWord[i]='-';
                }
                else{
                    secretWord[i]=usedChars.charAt(j);
                    break;
                }
            }
        }
    }
    
    /**
     *vykresli sibenici
     */
    public void drawGibbet(){
        System.out.println(gibbet);
    }

    /**
     *vypise hadane slovo se zakrytymi neuhadnutzmi znaky
     */
    public void drawSecretWord(){
        System.out.printf("Hadane slovo:   ");
        for(int i =0; i<secretWord.length; i++){
            System.out.printf(" %c ", secretWord[i]);
        }
    }

    /**
     *Nastavuje uroven
     * @param lvl
     */
    public void setLVL(int lvl){
        this.lvl=lvl;
    }

    /**
     *vypise retezec Start hry
     */
    public void start(){
        System.out.printf("\nVita Te hra Obesenec\n");
    }

    /**
     *Vypise retezec Vitezstvi
     */
    public void win(){
        System.out.printf("\nVyhral jsi\n");
    }

    /**
     *Vypise retezec prohra
     */
    public void defeat(){
        System.out.printf("\nProhral jsi\n");
    }
}
