/*Haroon Ahmad
 * L134122
 * AP-A
 */
import java.io.*;   

public class TicTacToeGame {


    public static void main( String[] args )
    {
    	System.out.println("This is A  Two Player Tic Tac Toe Game");
    	GameBoard gameBoard = new GameBoard();
    	GameAssistance assistanceObj = new GameAssistance();
		String positionInput=" ";
		
		gameBoard.displayGameBoard(); // display the game board (first time)
		
		//Infinite loop till game finishes
		while(1==1)
		{
			positionInput = assistanceObj.getPlayerInput("Player X: type in position (e.g., A1) "); // example how to take input
			int z=gameBoard.updateGameBoard(positionInput,'X');//Check if move is valid
			for(;z<0;)// Keep Getting input till a valid input comes 
			{
				System.out.println("Invalid Move please retry");
				positionInput = assistanceObj.getPlayerInput("Player X: type in position (e.g., A1) ");
				z=gameBoard.updateGameBoard(positionInput,'X');
			}
			//gameBoard.updateGameBoard(positionInput,'X');
			gameBoard.displayGameBoard();//Display Board again
			if(gameBoard.checkForWinner()=='X')
			{
				System.out.println("Player X is the winner");
				break;
			}
			else if(gameBoard.checkForWinner()=='O')
			{
				System.out.println("Player O is the winner");
				break;
			}
			else if(gameBoard.checkForWinner()=='D')//Check if all moves have been played
			{
				System.out.println("Match is Drawn");
				break;
			}
			else{//Second player Turn
			positionInput = assistanceObj.getPlayerInput("Player O: type in position (e.g., A1) "); // example how to take input
			z=gameBoard.updateGameBoard(positionInput,'O');
			for(;z<0;)
			{
				System.out.println("Invalid Move please retry");
				positionInput = assistanceObj.getPlayerInput("Player O: type in position (e.g., A1) ");
				z=gameBoard.updateGameBoard(positionInput,'O');
			}
			
			gameBoard.displayGameBoard();
			if(gameBoard.checkForWinner()=='X')
			{
				System.out.println("Player X is the winner");
				break;
			}
			else if(gameBoard.checkForWinner()=='O')
			{
				System.out.println("Player O is the winner");
				break;
			}
			else if(gameBoard.checkForWinner()=='D')
			{
				System.out.println("Match is Drawn");
				break;
			}
			}
			//same as player 1
		}
		
		/**** Implement code here  ********/
		
    }
    
}


class GameBoard{
		private char[] boardArr = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};
		
		
		void displayGameBoard(){
			System.out.println("  " + " A   B   C\n");
			System.out.println("1: " + boardArr[0] + " | " + boardArr[1] + " | " + boardArr[2]);
			System.out.println("  -----------");
			System.out.println("2: " + boardArr[3] + " | " + boardArr[4] + " | " + boardArr[5]);
			System.out.println("  -----------");
			System.out.println("3: " + boardArr[6] + " | " + boardArr[7] + " | " + boardArr[8]);
		}
		
		char[] getGameboard(){
			return boardArr;
		}
		
		
		char checkForWinner(){ 
			// This function checks if there is a winner on the board. 
			//If so, it should return 'X' or 'O' based on the winner. 
			//it should return 'N' if no winner found
			boolean flag=false;
			for(int i=0;i<9;i++)//Check if board is filled
			{
				if(boardArr[i]=='-')
				{
					flag=true;
				}
			}
			for(int i=0;i<9;i=i+3)//i increments vertically
			{
				if(i==0)
				{
					if(boardArr[i]=='X' && boardArr[i+4]=='X' && boardArr[i+8]=='X' )//Diagonal conditions
					{
						return 'X';
					}
					else if(boardArr[i]=='X' && boardArr[i+3]=='X' && boardArr[i+6]=='X')//Vertical Conditions
					{
						return 'X';
					}
					if(boardArr[i]=='O' && boardArr[i+4]=='O' && boardArr[i+8]=='O' )//Horizontal for player O
					{
						return 'O';
					}
					else if(boardArr[i]=='O' && boardArr[i+3]=='O' && boardArr[i+6]=='O')
					{
						return 'O';
					}
				}
				if(i==6)//If loop is checking the 6th box
				{
					if(boardArr[i]=='X' && boardArr[i-2]=='X' && boardArr[i-4]=='X')//checking horizontally
					{
						return 'X';
					}
					else if(boardArr[i]=='O' && boardArr[i-2]=='O' && boardArr[i-4]=='O')
					{
						return 'O';
					}
				}
				if(boardArr[i]=='X' && boardArr[i+1]=='X' && boardArr[i+2]=='X')////checking horizontally
				{
					return 'X';
				}
				else if(boardArr[i]=='O' && boardArr[i+1]=='O' && boardArr[i+2]=='O')
				{
					return 'O';
				}
				if(flag==false)
				{
					return 'D';//Declare as Draw
				}
				return 'N';//Other wise do next turn
					
			}
		/**** implement here ********/
		
		return 'N';
		}
		
		
		int updateGameBoard(String move, char XorO){ 
		// This function is called after user has typed in a column and row e.g., (A2).
		// The first parameter to this function is a column and rows (which is called move) and the second one is if player is X or O
		//This function is to place the move. If the board position is already filled, it returns a 1, else returns 0. 
	    //The grid should be updated with 'X' or 'O' as appropriate.
			if(move.charAt(1)=='1')
			{
				if(move.charAt(0)=='A')
				{
					if(boardArr[0]=='-' )//checking if empty
					{
						boardArr[0]=XorO;//A1
						return 0;
					}
					else
					{
						return -1;
					}
				}
				else if(move.charAt(0)=='B')
				{
					if(boardArr[1]=='-')//B1
					{
						boardArr[1]=XorO;
					}
					else
					{
						return -1;
					}
				}
				else if(move.charAt(0)=='C')
				{
					if(boardArr[2]=='-')//C1
					{
						boardArr[2]=XorO;
					}
					else
					{
						return -1;
					}
				}
			}
			else if(move.charAt(1)=='2')
			{
				if(move.charAt(0)=='A')//A2
				{
					if(boardArr[3]=='-')
					{
						boardArr[3]=XorO;
					}
					else
					{
						return -1;
					}
				}
				else if(move.charAt(0)=='B')//B2
				{
					if(boardArr[4]=='-')
					{
						boardArr[4]=XorO;
					}
					else
					{
						return -1;
					}
				}
				else if(move.charAt(0)=='C')//C2
				{
					if(boardArr[5]=='-')
					{
						boardArr[5]=XorO;
					}
					else
					{
						return -1;
					}
				}
			}
			else if(move.charAt(1)=='3')//A3,B3,C3
			{
				if(move.charAt(0)=='A')
				{
					if(boardArr[6]=='-')
					{
						boardArr[6]=XorO;
					}
					else
					{
						return -1;
					}
				}
				else if(move.charAt(0)=='B')
				{
					if(boardArr[7]=='-')
					{
						boardArr[7]=XorO;
					}
					else
					{
						return -1;
					}
				}
				else if(move.charAt(0)=='C')
				{
					if(boardArr[8]=='-')//checking if empty
					{
						boardArr[8]=XorO;
					}
					else
					{
						return -1;
					}
				}
			}
			else
			{
				return -1;
			}
		/**** Implement code here ********/
		
		return 0;
		}
		

}	



class GameAssistance{
	public String getPlayerInput(String message){
		String enteredLine = null;
		System.out.print(message + "> ");
		try{
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			enteredLine = bufferReader.readLine();
			if (enteredLine.length() == 0)
				return null;
			} catch (IOException e){
				System.out.println("IOException: " + e);
			}
		return enteredLine;
	}

}