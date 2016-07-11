/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerrank;

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jan
 */
public class RankAgentTest {
    
    public RankAgentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of start_rankagent method, of class RankAgent.
     */
    @Test
    public void testHighCard() {
        System.out.println("HighCard");
        String[] player_one ={"2D","5D","8C","KH","QH"};
        String[] player_two = {"2C","5C","8D","QH","TH"};
        RankAgent instance = new RankAgent();
        int[] expResult = {1,1,1};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }

  @Test
    public void testPair() {
        System.out.println("Pair");
        String[] player_one ={"4D","4H","8C","KH","QH"};
        String[] player_two = {"4C","4H","8D","KH","TH"};
        RankAgent instance = new RankAgent();
        int[] expResult = {2,2,1};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  
    
    
    @Test
    public void testThreeOfAKind() {
        System.out.println("ThreeOfAKind");
        String[] player_one ={"4D","4H","4C","KH","QH"};
        String[] player_two = {"KC","4H","4D","4H","TH"};
        RankAgent instance = new RankAgent();
        int[] expResult = {4,4,0};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  
    
    @Test
    public void testTwoPair() {
        System.out.println("TwoPair");
        String[] player_one ={"6D","6H","8C","AC","AD"};
        String[] player_two = {"5C","5H","9D","AH","AS"};
        RankAgent instance = new RankAgent();
        int[] expResult = {3,3,2};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  

    
    
    @Test
    public void testStraight() {
        System.out.println("Straight");
        String[] player_one ={"6D","7H","8C","9H","TS"};
        String[] player_two = {"7C","8H","9D","TH","JS"};
        RankAgent instance = new RankAgent();
        int[] expResult = {5,5,2};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  
    
    @Test
    public void testFlush() {
        System.out.println("Flush");
        String[] player_one ={"6D","7D","8D","QD","QD"};
        String[] player_two = {"5C","5C","8C","AC","AC"};
        RankAgent instance = new RankAgent();
        int[] expResult = {6,6,2};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  
    
    @Test
    public void testFullHouse() {
        System.out.println("Full_House");
        String[] player_one ={"6D","6H","6C","QH","QS"};
        String[] player_two = {"5C","5H","5D","AH","AS"};
        RankAgent instance = new RankAgent();
        int[] expResult = {7,7,1};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    } 
    
    @Test
    public void testFourOfAKind() {
        System.out.println("FourOfAKind");
        String[] player_one ={"6D","6H","6C","6H","QS"};
        String[] player_two = {"5C","5H","5D","5H","AS"};
        RankAgent instance = new RankAgent();
        int[] expResult = {8,8,1};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  
    
    @Test
    public void testStraightFlush() {
        System.out.println("StraightFlush");
        String[] player_one ={"6D","7D","8D","9D","TD"};
        String[] player_two = {"5H","6H","7H","8H","9H"};
        RankAgent instance = new RankAgent();
        int[] expResult = {9,9,1};
        int[] result = instance.start_rankagent(player_one, player_two);
        assertArrayEquals(expResult, result);
        
        
    }  






    
    
}
