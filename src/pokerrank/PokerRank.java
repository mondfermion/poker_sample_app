/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerrank;


import java.io.*;
import java.util.Arrays;


/**
 *
 * @author jan
 */
public class PokerRank {

    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {
        // TODO code application logic here
        String pair = new String("");
        FileReader pokerhands = new FileReader("input.txt");
        BufferedReader inputreader = new BufferedReader(pokerhands);
        RankAgent rankagent = new RankAgent();        
        try {
         
         
         do {   
          pair = inputreader.readLine();
          String[] players =   pair.split(":");
          String[] PlayerOne = players[0].split(" ");
          String[] PlayerTwo = players[1].split(" ");
          System.out.println("The cards of player one are: " +  Arrays.toString(PlayerOne));
          System.out.println("The cards of player two are: " + Arrays.toString(PlayerTwo));
          rankagent.card_sequencer(PlayerOne);
          rankagent.printer();
         }   
         
         while (pair != null);
        
        }
        
        
        catch(FileNotFoundException e) {
            System.err.println("inputfile can't be found");

        }
    }
    
}
