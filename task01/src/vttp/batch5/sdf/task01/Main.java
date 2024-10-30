package vttp.batch5.sdf.task01;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{

		// File file = new File("C:\Users\bleac\VISA\assessment1\task01\day.csv");
		Path p = Paths.get("C:\\Users\\bleac\\VISA\\assessment1\\task01\\day.csv");
		Reader reader = new FileReader(p.toFile());
		BufferedReader br = new BufferedReader(reader);

		int[] positionList = new int[5];
		for(int i = 0; i < positionList.length;i++){
			positionList[i] = 0;
		}
		entry[] bikeList = new entry[5];
		int position = 0;

		String line = "x";
		String header = br.readLine();
		while(line != null) {
			int totalBikers = 0;
			line = br.readLine();
			if (null == line){ break;}
			String[] newUtility= line.split(",");
			totalBikers = Integer.parseInt(newUtility[8])+ Integer.parseInt(newUtility[9]);
			for(int i = 0; i < positionList.length; i++) {
				int a = i-1;
				int j = positionList.length;
				if(totalBikers > positionList[i]) {
					while(j > a){
						if(j < (positionList.length - 1)){
							positionList[j+1] = positionList[j];
						}
						j--;
					}
					positionList[i] = totalBikers;
					position = i;
					entry BikeEntry = new entry(position, Integer.parseInt(newUtility[0]), Integer.parseInt(newUtility[3]), Integer.parseInt(newUtility[1]), totalBikers, Integer.parseInt(newUtility[4]), Integer.parseInt(newUtility[2]));
					bikeList[i] = BikeEntry;
					break;
					
				}
			}

		}
	

		for (int i =0; i< bikeList.length; i++){

			System.out.println(bikeList[i] + "\n");
				
		}

		br.close();

			



			
	}


}

