import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Simulation {
	 /**setMap creates a map with keys from 1-9 that map to each position on the Tic-Tac-Toe Board*/
	 private static HashMap<Integer, int[]> setMap() {
	        HashMap<Integer, int[]> map= new HashMap<>();
	        int[] one= new int[2];
	        one[0]= 0;
	        one[1]= 0;
	        int[] two= new int[2];
	        two[0]= 0;
	        two[1]= 1;
	        int[] three= new int[2];
	        three[0]= 0;
	        three[1]= 2;
	        int[] four= new int[2];
	        four[0]= 1;
	        four[1]= 0;
	        int[] five= new int[2];
	        five[0]= 1;
	        five[1]= 1;
	        int[] six= new int[2];
	        six[0]= 1;
	        six[1]= 2;
	        int[] seven= new int[2];
	        seven[0]= 2;
	        seven[1]= 0;
	        int[] eight= new int[2];
	        eight[0]= 2;
	        eight[1]= 1;
	        int[] nine= new int[2];
	        nine[0]= 2;
	        nine[1]= 2;

	        map.put(1, one);
	        map.put(2, two);
	        map.put(3, three);
	        map.put(4, four);
	        map.put(5, five);
	        map.put(6, six);
	        map.put(7, seven);
	        map.put(8, eight);
	        map.put(9, nine);

	        return map;
	    }
	 
	 
	 
	 	/** playAGame returns the history of all the board states in a single game except the first state
	 	 *  The last entry in the last will be the result of the game.
	 	*/
	    public static List<int[][]> playAGame() throws Throwable {
	        int[][] board= new int[3][3];
	        HashMap<Integer, int[]> moves= setMap();
	        List<int[][]> history= new LinkedList<>();
	        boolean gameState= true;
	        int player= 1;
	        int movesPlayed= 0;
	        while (gameState) {


	        	//Pick a move
	        	List<Integer> keysAsArray = new ArrayList<Integer>(moves.keySet());
	        	Random r = new Random();
	        	int key = keysAsArray.get(r.nextInt(keysAsArray.size()));
	        	int[] move = moves.get(key);
	            board[move[0]][move[1]]= player;
	            
	            //Copy and add the new board
	            int [][] copy = new int[board.length][];
	            for(int i = 0; i < board.length; i++)
	                copy[i] = board[i].clone();
	            history.add(copy);
	            moves.remove(key);
	            //Check for end of Game
	            if(checkForWin(board, key, player) == player) {
	            	gameState = false;
	            	int[][] result = new int[1][1];
	            	result[0][0] = player;
	            	history.add(result);
	            }
	            
	            
	            movesPlayed++;     	            
	            player = -player;
	            if (movesPlayed == 9 && gameState) {
	                gameState= false;
	            	int[][] result = new int[1][1];
	            	result[0][0] = 0;
	            	history.add(result);
	            }

	        }
	        return history;

	    }

	    public static void print2D(int mat[][]) {
	        // Loop through all rows
	        for (int[] row : mat)

	            // converting each row as string
	            // and then printing in a separate line
	            System.out.println(Arrays.toString(row));
	    }
	    /**
	     * 
	     * @param board - Current board state
	     * @param move - last played move
	     * @param player - who played the move
	     * @return - player for win, 0 if still no winner
	     * @throws Exception - if move isn't 1-9
	     */
	    public static int checkForWin(int[][] board, int move, int player) throws Exception {
	    	switch (move) {
	    		case 1:
	    			if ((board[0][1] == player && board[0][2] == player) ||
	    			   (board[1][0] == player && board[2][0] == player) ||
	    			   (board[1][1] == player && board[2][2] == player))
	    				return player;
	    			else
	    				break;
	    		case 2:
	    			if ((board[0][0] == player && board[0][2] == player) ||
	    			    (board[1][1] == player && board[2][1] == player))
	    				return player;
	    			else
	    				break;
	    		case 3:
	    			if ((board[0][0] == player && board[0][1] == player) ||
	    			    (board[2][1] == player && board[2][2] == player) ||
	    			    (board[1][1] == player && board[2][0] == player))
	    				return player;
	    			else
	    				break;
	    		case 4:
	    			if ((board[1][1] == player && board[1][2] == player) ||
	    			    (board[0][0] == player && board[2][0] == player))
	    				return player;
	    			else
	    				break;
	    		case 5:
	    			if ((board[1][0] == player && board[1][2] == player) ||
	    			    (board[0][1] == player && board[2][1] == player) ||
	    			    (board[0][0] == player && board[2][2] == player) ||
	    			    (board[0][2] == player && board[2][0] == player))
	    				return player;
	    			else
	    				break;
	    		case 6:
	    			if ((board[1][1] == player && board[1][0] == player) ||
	    			    (board[0][2] == player && board[2][2] == player))
	    				return player;
	    			else
	    				break;
	    		case 7:
	    			if ((board[2][1] == player && board[2][2] == player) ||
	    			    (board[0][0] == player && board[0][1] == player) ||
	    			    (board[0][2] == player && board[1][1] == player))
	    				return player;
	    			else
	    				break;
	    		case 8:
	    			if ((board[1][1] == player && board[0][1] == player) ||
	    			    (board[2][0] == player && board[2][2] == player))
	    				return player;
	    			else
	    				break;
	    		case 9:
	    			if ((board[0][2] == player && board[1][2] == player) ||
	    			    (board[2][0] == player && board[2][1] == player) ||
	    			    (board[1][1] == player && board[0][0] == player))
	    				return player;
	    			else
	    				break;
	    		 default:
	    			 throw new Exception("Not a valid move");
	    			
	    			
	    	}
	    	return 0;
	    }
}
