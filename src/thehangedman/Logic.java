package thehangedman;

public class Logic {
    
    private String word;
    private final GUI gui;
    private final WordSelector ws;
    private final Input in;
    private boolean alive=true;
    private boolean completed=false;
    private int lvl=0; //hodnota urcuje uroven sibenice
    private String goodChars;
    private String c;
    
    /**
     *slepuje jednotlive casti
     */
    public Logic(){
        this.in = new Input();
        this.ws = new WordSelector();
        this.gui = new GUI();
    }
    
    //obvola metody pro zahajeni hry
    private void start(){
        gui.start();//text pri zahajeni
        word=ws.getRandomWord();//prirazeni nahodneho slova
        gui.compileSecretWord(word, " ");//prvni sestaveni skryteho slova
        gui.drawGibbet();//vykresleni sibenice
        gui.drawSecretWord();//vykresleni skryteho slova
        
    }

    /**
     *obstarava beh hry
     */
    public void run(){
        start();
        while(isAlive() & !isCompleted()){//dokud hrac zije a slovo neni cele uhanute
            c=in.getChar();//do c se nacte znak z klavesnice
            if(!word.contains(c)){// a pokud neni spravny
                badChar();
            }
            else{
                goodChar();
            }
            gui.drawGibbet(); //vykresli sibenici
            gui.drawSecretWord();//vykresli tajne slovo
        }
        end();
    }
    
    //vola metody pro vitezstvi, nebo prohru
    private void end(){
        if(completed){
            gui.win();
        }
        else if(!alive){
            gui.defeat();
        }
    }
    //obvola metody pro spatny znak
    private void badChar(){
        lvl++;  //navysi uroven
        gui.setLVL(lvl);//nastavi uroven sibenice
        gui.compileGibbet();//sestavi novou sibenici
        setAlive();//nastavi zivot ci smrt
        System.out.printf("\nSpatne\n");
    }
    //obvola metody pro dobry znak
    private void goodChar(){
        for(int i = 0; i<word.length(); i++){//prochazi celym slovem, kvuli vicenasobnemu vyskytu jednoho znaku
            if(word.substring(i, i+1).equals(c)){
                if(goodChars==null){//pokud v goodChars nic neni
                    goodChars=c;//priradi se c
                }
                else goodChars+=c;//jinak se pripoji      
            }
        }
        setCompleted();//nastavi kompletnost, nebo nekompletnost slova
        System.out.printf("\nSpravne\n");
        gui.compileSecretWord(word, in.getUsedChars());//nastavi skryte slovo
    }
    //boolean, vyhodnocuje zivot
    private void setAlive(){
        this.alive = lvl<7;
    }
    private boolean isAlive(){
        return alive;
    }
    //boolean, vyhodnocuje, zdali jsou uhadnuta vsechna pismena
    private void setCompleted(){
        this.completed = word.length()==goodChars.length();
    }
    private boolean isCompleted(){
        return completed;
    }
    
}
