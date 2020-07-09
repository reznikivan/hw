package iy.reznik;

import java.util.Arrays;
import java.util.Scanner;
 
public class HangConsoleView {
    HangModel model;
    Scanner in = new Scanner(System.in);
 
    public HangConsoleView(HangModel model) {
        this.model = model;
    }
 
    public Character interact() {
        System.out.println("Current situation: " + model.getUserView());
        System.out.println("Number of mistakes: " + model.getMistakes());
        System.out.println("Named letters: " + model.getState());
        System.out.println("Name next letter");
        char c = in.next().toLowerCase().charAt(0);
        return c;
    }
    public void congratulate() {
    	System.out.println("You won! Right word is " + model.word);
    }
}