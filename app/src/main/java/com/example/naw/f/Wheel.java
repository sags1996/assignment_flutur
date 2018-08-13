package com.example.naw.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Wheel {
    private ArrayList<Symbols> allSymbols;
    private Symbols currentSymbol;
    public Wheel(){
        this.allSymbols = new ArrayList<>();
        generateSymbols();
        this.currentSymbol = getRandomSymbol();
    }
    private void generateSymbols(){
        Collections.addAll(this.allSymbols, Symbols.values());
    }


    public void setCurrentSymbol(Symbols currentSymbol) {
        this.currentSymbol = currentSymbol;
    }
    public Symbols getCurrentSymbol() {
        return currentSymbol;
    }
    public int getSymbolIndex(Symbols symbol){
        return this.allSymbols.indexOf(symbol);
    }

    private String getSymbolImage(Symbols symbol){
        return symbol.getImageName();
    }



    public Symbols getSymbolAtIndex(int index){
        return this.allSymbols.get(index);
    }

    public Symbols getRandomSymbol(){
        int randomIndex = randomInt(countSymbols());
        return getSymbolAtIndex(randomIndex);
    }

    private Symbols getPreviousSymbol(Symbols currentSymbol){
        int currentIndex = getSymbolIndex(currentSymbol);
        if(currentIndex == 0){
            int topIndex = countSymbols() - 1;
            return getSymbolAtIndex(topIndex);
        } else {
            int topIndex = currentIndex - 1;
            return getSymbolAtIndex(topIndex);
        }
    }

    public Symbols getTopSymbol(){
        Symbols currentSymbol = getCurrentSymbol();
        return getPreviousSymbol(currentSymbol);
    }

    public Symbols getBottomSymbol(){
        Symbols currentSymbol = getCurrentSymbol();
        int currentIndex = getSymbolIndex(currentSymbol);
        if(currentIndex == countSymbols() - 1){
            int bottomIndex = 0;
            return getSymbolAtIndex(bottomIndex);
        } else {
            int bottomIndex = currentIndex + 1;
            return getSymbolAtIndex(bottomIndex);
        }
    }

    public int countSymbols(){
        return this.allSymbols.size();
    }

    public int randomInt(int max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public Symbols spin(){
           Symbols newSymbol = getRandomSymbol();
            setCurrentSymbol(newSymbol);
            return newSymbol;
        }
    }





