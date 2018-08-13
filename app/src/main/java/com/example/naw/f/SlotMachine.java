package com.example.naw.f;

import java.util.ArrayList;

public class SlotMachine {
    private int numberOfWheels;
    private ArrayList<Wheel> slots;

    public SlotMachine(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
        this.slots = new ArrayList<>();
        generateWheels();
    }

    private void generateWheels(){
        for(int i = 0; i <numberOfWheels; i++){
            Wheel wheel = new Wheel();
            this.slots.add(wheel);
        }
    }

    public ArrayList<Wheel> getSlots() {
        return slots;
    }


    public ArrayList<Symbols> spin(){
        ArrayList<Symbols> line = new ArrayList<>();
        for(Wheel wheel : slots){
            line.add(wheel.spin());
        }
        return line;
    }



    public ArrayList<Symbols> getTopLineSymbols(){
        ArrayList<Symbols> topSymbols = new ArrayList<>();
        for(Wheel wheel : getSlots()){
            Symbols top = wheel.getTopSymbol();
            topSymbols.add(top);
        }
        return topSymbols;
    }

    public ArrayList<Symbols> getBottomLineSymbols(){
        ArrayList<Symbols> bottomSymbols = new ArrayList<>();
        for(Wheel wheel : getSlots()){
            Symbols bottom = wheel.getBottomSymbol();
            bottomSymbols.add(bottom);
        }
        return bottomSymbols;
    }

    public String getSymbolImage(Symbols symbol){
        return symbol.getImageName();
    }

    public ArrayList<String> getLineImages(ArrayList<Symbols> line) {
        ArrayList<String> images = new ArrayList<>();
        for (Symbols symbol : line) {
            String image = getSymbolImage(symbol);
            images.add(image);
        }
        return images;
    }
}
