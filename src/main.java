import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class main {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
        int playerOneWins = 0;
        int playerTwoWins = 0;
        int draws = 0;
        
        for(int i = 0; i < 10000; i++) {
            List<int[][]> history= Simulation.playAGame();
            int result = history.get(history.size()-1)[0][0];
            if(result == 1)
            	playerOneWins++;
            else if(result == -1)
            	playerTwoWins++;
            else
            	draws++;
        }
        System.out.println("Player One Wins: " + playerOneWins);
        System.out.println("Player Two Wins: " + playerTwoWins);
        System.out.println("Draws: " + draws);


        
        
//        for (int[][] i : history) {
//            print2D(i);
//            System.out.println();
//	}

}
	

	}


