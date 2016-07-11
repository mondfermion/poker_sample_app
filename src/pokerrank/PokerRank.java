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
          try{   
          pair = inputreader.readLine();
          String[] players =   pair.split(":");
          String[] PlayerOne = players[0].split(" ");
          String[] PlayerTwo = players[1].split(" ");
          
         
          System.out.println("The cards of player one are: " +  Arrays.toString(PlayerOne));
          System.out.println("The cards of player two are: " + Arrays.toString(PlayerTwo));
          
         int[] parameters = rankagent.start_rankagent(PlayerOne, PlayerTwo);
         
         System.out.println("Ranks and winner: " + Arrays.toString(parameters));
         
         if(parameters[2] == 1){
           System.out.println("Player one wins");
         }
         else if(parameters[2] == 2){
           System.out.println("Player two wins");
         }
         
         else{
           System.out.println("tie");
         }
             
          }
          
         catch(NullPointerException e) {
             System.out.println("End of file");
         }
         }   
         
         while (pair != null);
        
        }
        
        
        catch(FileNotFoundException e) {
            System.err.println("inputfile can't be found");

        }
    }
    
}
