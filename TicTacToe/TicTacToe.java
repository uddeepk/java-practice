import java.util.Scanner;

public class TicTacToe {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		
		int [][] a = new int [3][3] ;
		//boolean [][] b = new boolean [3][3];
		boolean fill = false ;
		
		int r;
		int c;
		
		boolean win = false;
		int turns = 0;
		while(win==true || turns < 9){
			displayBoard(a);
			System.out.print("Enter a row (0, 1, or 2) for player "+ ((turns%2==0)?"X":"O")+": ");
			r = input.nextInt();
			System.out.print("Enter a column (0, 1, or 2) for player "+ ((turns%2==0)?"X":"O")+": ");
			c = input.nextInt();
			if ( a[r][c]==0) {
				a[r][c] = (int)((turns%2==0)?'X':'O');
			}
			else {
				System.out.println("The cell is already filled. Choose a different cell.");
				continue;
			}
			
			if( checkBoard(a)) {
				win=true;
				break;
			}
			
			turns++;
		} 
		displayBoard(a);
		System.out.println(win?(((turns%2==0)?"X":"O")+" player won") : "It is a draw.") ;
	}
	
	public static void displayBoard(int [][] a) {
		for(int i = 0 ; i < a.length ; i++) {
			System.out.println("_____________") ; //"|xXx|xOx|xOx|"
			for(int j = 0 ; j < a[i].length ; j++) {
				System.out.print("| " + (((char)a[i][j]=='X'||(char)a[i][j]=='O')?(char)a[i][j] : ' ')+" "); //use printf??
			}
			System.out.print("|\n");
		}
		System.out.println("_____________");
	}
	
	public static boolean checkBoard(int [][] a) {
		//check rows
		for(int i = 0 ; i < a.length ; i++) {
			if(rowMatch(a , i)) {
				return true;
			}
		}
		//check columns
		for(int j = 0 ; j < 3 ; j++) {
			if ( columnMatch(a , j)) {
				return true;
			}
		}
		
		// check main diagonal
		
		if ( pDiagonal(a ) ) {
			return true;
		}
		
		if ( sDiagonal(a)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean rowMatch ( int[][] a, int r ) {
		for(int j = 0 ; j < a[r].length-1 ; j++) {
			if(a[r][j] == 0 || a[r][j]!=a[r][j+1]) {
				return false;
			}
		}
		return true;
	}
	public static boolean columnMatch(int [][] a, int c) {
		for( int i =0 ; i<a[c].length-1 ; i++) {
			if(a[i][c] == 0 || a[i][c]!=a[i+1][c]) {
				return false;
			}
		}
		return true;
	}
	public static boolean pDiagonal(int [][] a) {
		for(int n =0 ; n<2 ; n++) {
			if(a[n][n] == 0 || a[n][n]!=a[n+1][n+1]) {
				return false;
			}
		}
		return true;
	}
	public static boolean sDiagonal(int[][] a) {
		for(int n = 2 ; n > 0 ; n--) {
			if(a[n][2-n] == 0 || a[n][2-n]!=a[n-1][2-(n-1)]) {
				return false;
			}
		}
		return true;
	}
}
