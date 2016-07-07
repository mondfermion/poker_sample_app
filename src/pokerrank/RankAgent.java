/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerrank;

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
    Vector<Vector<Integer>> values = new Vector<Vector<Integer>>();
    Vector<Vector<Integer>> suits = new Vector<Vector<Integer>>();
    Vector<Integer> not_empty_values = new Vector<Integer>();
    Vector<Integer> not_empty_suits = new Vector<Integer>();
    Vector<Integer> lenght_of_not_empty_values = new Vector<Integer>();
    String[] card_hand;
    
    
    
    RankAgent() {
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
    
    public void card_sequencer(String[] card_hand) {
        this.card_hand = card_hand;
        int len = card_hand.length;
        int i = 0;
        
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
            if(this.values.get(i).size() != 0){
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
    
    
    public void printer(){
        int i = 0;
        while(i < 13){
        System.out.println(i);
        System.out.println(this.values.get(i));
        i = i + 1;
        }
        System.out.println(this.not_empty_values);
        
    }
    public void no_same_values() {
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
    
    public void same_values(){
        int i = 0;
        if (this.lenght_of_not_empty_values.size() == 4){
            this.rank = 2;
        }
        
        else if (this.lenght_of_not_empty_values.size() == 3){
           i = 0;
           
           while (i < 3){
               if(this.lenght_of_not_empty_values.get(i) == 3){
                   this.rank = 4;
                   break;
               }
               
               else if(this.lenght_of_not_empty_values.get(i) == 2){
                   this.rank = 3;
                   break;        
               }
               
               i = i + 1;
           }
        }
        
        else if (this.lenght_of_not_empty_values.size() == 2){
            i = 0;
            while (i < 2){
                if(this.lenght_of_not_empty_values.get(i) == 4){
                   this.rank = 8;
                   break;
               }
                
                
                else if(this.lenght_of_not_empty_values.get(i) == 2){
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
    
    public void same_rank(Vector<Integer> values_player_one, Vector<Integer> values_player_two){
        int highest_value_player_one = values_player_one.get(values_player_one.size() - 1);
        int highest_value_player_two = values_player_two.get(values_player_two.size() - 1);
        if (this.rank == 9 | this.rank == 5  ){
            
            
            if(highest_value_player_one == highest_value_player_two){
                winner = 0;
            }
            else if(highest_value_player_one > highest_value_player_two){
                winner = 1;
            }
            else{
                winner = 2;
            }
           
            
        }
        
        if (this.rank == 1 | this.rank == 6){
            if (highest_value_player_one == highest_value_player_two){
                int i = 1;
                while(i < 5)    
                   highest_value_player_one = values_player_one.get(values_player_one.size() - 1 - i); 
                   
                        
            }
        }
    }
    
}
