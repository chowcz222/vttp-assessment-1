package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
// import java.nio.file.Path;
// import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws Exception {


		File file = new File(args[0]);
		Reader reader = new FileReader(file);
		// Path p = Paths.get("C:\\Users\\bleac\\VISA\\assessment1\\task02\\TTT\\board0.txt");
		// Reader reader = new FileReader(p.toFile());
		BufferedReader br = new BufferedReader(reader);

		System.out.printf("Processing: %s", args[0]);

		String line = "x";
		int i = 0;
		String[][] board = new String[3][3];
		while(line != null) {
			line = br.readLine();
			if (line == null) {break;}
			String[] tempArray = line.split("");
			for (int j = 0; j < tempArray.length; j++){
				board[i][j] = tempArray[j];
			}
			i++;
		}

		br.close();

		System.out.println("Board:\n");
		for (int a = 0; a < 3; a++){
			for (int b = 0; b < 3; b++) {
				System.out.printf(board[a][b]);
			}
			System.out.println("");
		}

		System.out.println("\n-----------------------\n");

		int minUtility = 0;
		for (int a = 0; a < 3; a++){
			for (int b = 0; b < 3; b++) {
				if(board[a][b].equals(".")){
					board[a][b] = "X";
					int utility = checkWin(board);
					if (utility == 0) {
						for (int c = 0; c < 3; c++){
							for (int d = 0; d < 3; d++) {
								if(board[c][d].equals(".")) {
									board[c][d] = "O";
									utility = checkWin(board);
									board[c][d] = ".";
									if(utility == -1) { minUtility = -1;}
								}
							}
						}

					}
					if ( minUtility != -1) {
						board[a][b] = ".";
						int xCoord = a;
						int yCoord = b;
						System.out.printf("y=%d,  x=%d,  utility=%d\n", xCoord, yCoord, utility);
					} else {
					board[a][b] = ".";
					int xCoord = a;
					int yCoord = b;
					System.out.printf("y=%d,  x=%d,  utility=%d\n", xCoord, yCoord, minUtility);
					}
				}
				
			}
		}
	}



	public static int checkWin(String[][] board) {

		int xCount = 0;
		int oCount = 0;

		for (int i = 0; i < 3; i++ ){
			xCount = 0;
			oCount = 0;
			for (int j = 0; j < 3; j++) {
				if( board[i][j].equals("X")){
					xCount += 1;
				} else if ( board[i][j].equals("O")) {
					oCount += 1;
				}
			}
			if(xCount == 3){
				return 1;
			} else if (oCount == 3){
				return -1;
			}
		}

		for (int i = 0; i < 3; i++ ){
			xCount = 0;
			oCount = 0;
			for (int j = 0; j < 3; j++) {
				if( board[j][i].equals("X")){
					xCount += 1;
				} else if ( board[j][i].equals("O")) {
					oCount += 1;
				}
			}
			if(xCount == 3){
				return 1;
			} else if (oCount == 3){
				return -1;
			}
		}

		xCount = 0;
		oCount = 0;

		for (int i = 0; i < 3; i++ ){
			if( board[i][i].equals("X")){
				xCount += 1;
			} else if ( board[i][i].equals("O")) {
				oCount += 1;
			}
			if(xCount == 3){
				return 1;
			} else if (oCount == 3){
				return -1;
			}
		}

		xCount = 0;
		oCount = 0;

		
		if( board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")){
			return 1;
		} else if ( board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
			return -1;
		}

		return 0;

	}
}
