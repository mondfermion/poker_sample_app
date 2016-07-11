/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerrank;


import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author jan
 */
public class RankAgent {
    int vector_counter_values = 13;
    int vector_counter_suits = 4;   
    int rank = 0;
    int winner = 0;
    int pair_value;
    int last_card[] = {0,0,0};
    
    Vector<Vector<Integer>> values = new Vector<Vector<Integer>>();
    Vector<Vector<Integer>> suits = new Vector<Vector<Integer>>();
    Vector<Integer> not_empty_values = new Vector<Integer>();
    Vector<Integer> not_empty_suits = new Vector<Integer>();
    Vector<Integer> lenght_of_not_empty_values = new Vector<Integer>();
    String[] card_hand;
    
    
    
    RankAgent() {
        this.prepare_vector();
    }
    
    
    
    public int[] start_rankagent(String[] player_one, String[] player_two ){
        Vector<Integer> not_empty_values_player_one = new Vector<Integer>();
        Vector<Integer> not_empty_values_player_two = new Vector<Integer>();
        int rank_player_one = 0;
        int rank_player_two = 0;
        int value_player_one = 0;
        int value_player_two = 0;
        int[] highst_values = {0,0};
        int[][] last_card = {{},{}};
        
        
        
        this.card_sequencer(player_one);
        this.copy_vector(this.not_empty_values, not_empty_values_player_one);
        this.detect_same_values();
        rank_player_one = this.rank;
        highst_values[0] = this.pair_value;
        last_card[0] = this.last_card.clone();
        this.clear_vectors();
        this.prepare_vector();
        
        
        
        this.card_sequencer(player_two);
        this.copy_vector(this.not_empty_values, not_empty_values_player_two);
        this.detect_same_values();
        rank_player_two = this.rank;
        highst_values[1] = this.pair_value;
        last_card[1] = this.last_card.clone();
        this.clear_vectors();
        this.prepare_vector();
        



        if (rank_player_one == rank_player_two){
          same_rank(not_empty_values_player_one,not_empty_values_player_two,highst_values,last_card);            
        }
        
        else{
            if (rank_player_one > rank_player_two){
              this.winner = 1;
            }
            
            else{
                this.winner = 2;
            }
        }
        
       int[] game_parameters = new int[3];
       game_parameters[0] = rank_player_one;
       game_parameters[1] = rank_player_two;
       game_parameters[2] = this.winner;
       return game_parameters;
        
    }
    
    private void prepare_vector(){
    int i = 0;
        
        while(i < this.vector_counter_values){
            Vector<Integer> value = new Vector<Integer>();
            this.values.add(value);
            i = i + 1;
            
        }
        i = 0;
        while (i < this.vector_counter_suits) {
            Vector<Integer> suit = new Vector<Integer>();
            this.suits.add(suit); 
            i = i + 1;
            
        }
    }
    
    private void clear_vectors(){
        this.values.removeAllElements();
        this.suits.removeAllElements();
        this.not_empty_values.removeAllElements();
        this.not_empty_suits.removeAllElements();
        this.lenght_of_not_empty_values.removeAllElements();
    }
    
    private void copy_vector(Vector<Integer> original,Vector<Integer> duplicate ){
        int i = 0;
        int element = 0;
        
        while (i < original.size()){
           element = original.get(i);
           duplicate.add(element);
           i = i +1;
        }
        
      
        }
    
    private int winner_bigger_value(int highest_value_player_one, int highest_value_player_two){
        int i = 0;         
        if (highest_value_player_one < highest_value_player_two){
                       this.winner = 2;
                       i = 1;
                      
                   }
                   
        else if (highest_value_player_one > highest_value_player_two){
                this.winner = 1;
                i = 1;
        }
                   
        else{
            i = 0;       
        }
        
        return i;
    }
    
    private void detect_same_values(){
        //System.out.println(this.not_empty_values);
        if (this.lenght_of_not_empty_values.size() < 5){
          this.same_values();
        }
          
        else{
           this.no_same_values();
        }
    }
    
    private void card_sequencer(String[] card_hand) {
        this.card_hand = card_hand;
        int len = card_hand.length;
        int i = 0;
        //System.out.println(len);
        
        while(i < len){
          char[] card = card_hand[i].toCharArray();
          
          switch(card[0]){
              
              case '2':
                  this.values.get(0).add(i);
                  break;
              case '3':
                  this.values.get(1).add(i);
                  break;
              case '4':
                  this.values.get(2).add(i);
                  break;   
              case '5':
                  this.values.get(3).add(i);
                  break;  
              case '6':
                  this.values.get(4).add(i);
                  break;  
              case '7':
                  this.values.get(5).add(i);
                  break;
              case '8':
                  this.values.get(6).add(i);
                  break;
              case '9':
                  this.values.get(7).add(i);
                  break;
              case 'T':
                  this.values.get(8).add(i);
                  break;
              case 'J':
                  this.values.get(9).add(i);
                  break;
              case 'Q':
                  this.values.get(10).add(i);
                  break; 
              case 'K':
                  this.values.get(11).add(i);
                  break;
               case 'A':
                  this.values.get(12).add(i);
                  break;   
            }
          
           switch(card[1]){
              
              case 'C':
                  this.suits.get(0).add(i);
                  break;
              case 'D':
                  this.suits.get(1).add(i);
                  break;
              case 'H':
                  this.suits.get(2).add(i);
                  break;   
              case 'S':
                  this.suits.get(3).add(i);
                  break;  
              }
          i = i + 1;
         }
        
        i = 0;
        
        while(i < this.vector_counter_values){
            if(this.values.get(i).size() != 0){
                this.not_empty_values.add(i);
            }
            
            i = i+1;
        }
        
        i = 0;
        while(i < this.vector_counter_suits){
            if(this.suits.get(i).size() != 0){
                this.not_empty_suits.add(i);
            }
            
            i = i+1;
        }
        
        i = 0;
        while (i < this.not_empty_values.size()){
            
            this.lenght_of_not_empty_values.add(this.values.get(this.not_empty_values.get(i)).size());
            i = i + 1;
        }
            
        
        
    }
    
    private void no_same_values() {
        int i = 0;
        int counter = this.not_empty_values.size() - 1;
        int value = 0;
        int next_value = 0;
        int expected_value = 0;
        int is_straight = 0;
        
        while (i < counter){
            value = this.not_empty_values.get(i);
            next_value = this.not_empty_values.get(i+1);
            expected_value = value + 1;
                    
            if (next_value == expected_value) {
                is_straight = 1;
            }
            
            else {
                is_straight = 0;
                break;
            }
            i = i + 1;
        }
        
        if (is_straight == 1) {
            
            if (this.not_empty_suits.size() == 1){
                this.rank = 9;
            }
            
            else{
                this.rank = 5;
            }
        }
        
        else{
            if (this.not_empty_suits.size() == 1){
                this.rank = 6;
            }
            
            else{
                this.rank = 1;
            }
            
        }
    
    }
    
    private void same_values(){
        int i = 0;
        if (this.lenght_of_not_empty_values.size() == 4){
            this.rank = 2;
            i = 0;
            int ii = 0;
            while (i<4){
              if(this.lenght_of_not_empty_values.get(i) == 2){
               this.pair_value = this.not_empty_values.get(i);             
              } 
              
              if(this.lenght_of_not_empty_values.get(i) == 1){                 
                this.last_card[ii] = this.not_empty_values.get(i);
                ii = ii+1;

              } 
              
              i = i+1;
            }

            
            
        }
        
        else if (this.lenght_of_not_empty_values.size() == 3){
           i = 0;
           boolean single_card_found = false;
           
           
           while (i < 3){
               
               if (this.lenght_of_not_empty_values.get(i) == 1){
                 this.last_card[0] = this.not_empty_values.get(i);
                 single_card_found = true;
                       }
               
               else if(this.lenght_of_not_empty_values.get(i) == 3){
                 this.pair_value = this.not_empty_values.get(i);
                 this.rank = 4;
                 break;
               }
               
               else if(this.lenght_of_not_empty_values.get(i) == 2){
                      int temp_higest_value = this.not_empty_values.get(i);
                      int temp_highst_value_two = 0;
                      while(i < 3){
                       i = i + 1;
                       if (this.lenght_of_not_empty_values.get(i) == 1){
                         this.last_card[0] = this.not_empty_values.get(i);
                         single_card_found = true;
                       }
                      if(this.lenght_of_not_empty_values.get(i) == 2){
                        temp_highst_value_two = this.not_empty_values.get(i);
                        if( single_card_found == true){                          
                          break;                          
                        }                                             
                    }  
                     
                   }
                                             
                   if(temp_higest_value > temp_highst_value_two){
                      this.pair_value = temp_higest_value; 
                   }  
                   
                   else{
                       this.pair_value = temp_highst_value_two;
                   }
                    
                    this.rank = 3;
                    break;
                   
                   }
                   i = i +1;
                                     
               }
                             
           }
        
        
        else if (this.lenght_of_not_empty_values.size() == 2){
            i = 0;
            while (i < 2){
                if(this.lenght_of_not_empty_values.get(i) == 4){
                   this.pair_value = this.not_empty_values.get(i);
                   this.rank = 8;
                   break;
               }
                
                
                else if(this.lenght_of_not_empty_values.get(i) == 3){
                   this.pair_value = this.not_empty_values.get(i);
                   this.rank = 7;
                   break;        
               }
                
                i = i + 1;
            
            }
                
        }
        
        if (this.rank < 7){
            if (this.not_empty_suits.size() == 1){
                this.rank = 6;
            }
        }
            
    }
    
    private void same_rank(Vector<Integer> values_player_one, Vector<Integer> values_player_two,int[] highst_values, int[][] last_card){
        int highest_value_player_one = values_player_one.get(values_player_one.size() - 1);
        int highest_value_player_two = values_player_two.get(values_player_two.size() - 1);
        int winner_selected = 0;
        
        
        


        
        if (this.rank == 9 | this.rank == 5  ){
            
            
            if(highest_value_player_one == highest_value_player_two){
                this.winner = 0;
            }
            else if(highest_value_player_one > highest_value_player_two){
                this.winner = 1;
            }
            else{
                this.winner = 2;
            }
           
            
        }
        
        if (this.rank == 1 | this.rank == 6){
            
            if (highest_value_player_one == highest_value_player_two){
                int i = 1;
                
                while(i < 5) {   
                   highest_value_player_one = values_player_one.get(values_player_one.size() - 1 - i);
                   highest_value_player_two = values_player_two.get(values_player_two.size() - 1 - i);
                   winner_selected = this.winner_bigger_value(highest_value_player_one, highest_value_player_two);
                   if (winner_selected == 1){
                       break;
                   }
                   i = i + 1;
                   
                }   
                
                if (winner_selected == 0){
                    this.winner = 0;
                }
                
            }
            
            else{
                this.winner_bigger_value(highest_value_player_one, highest_value_player_two);
            }
        }
        
        if (this.rank == 8 | this.rank == 2 | this.rank == 7 | this.rank == 4 | this.rank == 3 ){
            winner_selected = this.winner_bigger_value(highst_values[0], highst_values[1]);
            if(winner_selected == 0){
                System.out.println("Hallo");
              System.out.println(last_card[0][0]);
              System.out.println(last_card[1][0]);
            if(this.rank == 3 & last_card[0][0] > last_card[1][0]){
                this.winner = 1;    
                }
            else if (this.rank == 3 & last_card[0][0] == last_card[1][0]){
                this.winner = 0;
            }
            else if (this.rank == 3){
                this.winner = 2;
            }
            else if(this.rank == 2 ){
              

              int  i = 0;
              while (i < 3){
               if(last_card[0][2-i] != last_card[1][2-i]){
                 if(last_card[0][2-i] > last_card[1][2-i]){
                   this.winner = 1; 
                   break;
                 }
                 
                 else{
                     this.winner = 2; 
                     break;
                 }
               }
               
               else{
                   this.winner = 0;
               }
               //System.out.println(last_card[0][2-i]);
               //System.out.println(last_card[1][2-i]);
               i = i+1;
               
              }
                
            }
                                                
            }
                                                           
        }
    }
    }
