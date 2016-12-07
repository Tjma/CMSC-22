package threading;

import java.util.Scanner;

public class Rule30 {

	public static void main(String[] args) {
		int left,right,mid;
		System.out.println("Enter desired size: "); 
		Scanner in =  new Scanner(System.in); 
		int z = in.nextInt();
		long timeStart = System.currentTimeMillis();
		int[] cells = new int [z]; 
		int[] cells1 = new int [z]; 
		cells[(z/2)] = 1; 
		
		print10(cells);
		
		for(int i = 0; i < z-1; i++){
			for(int j = 0; j < z; ++j){
				left = cells[(j+z-1)%z];
				right = cells[(j+1)%z];
				mid = cells[j];
				
				if(j == 0){
					if(left == right)
						left = 0;
					else if(left == mid && left == 1){
						left = 0;
					}
				}else if(j == z-1){
					if (left == right)
						right = 0;
					else if (left == mid){
						right = 0;
					}
				}
				if(left == 0 && mid == 0 && right == 0){
					cells1[j] = 0;
				}else if(left == 1 && mid == 1 && right == 0){
					cells1[j] = 0;
				}else if(left == 1 && mid == 0 && right == 1){
					cells1[j] = 0;
				}else if(left == 1 && mid == 0 && right == 0){
					cells1[j] = 1;
				}else if(left == 0 && mid == 1 && right == 1){
					cells1[j] = 1;
				}else if(left == 0 && mid == 1 && right == 0){
					cells1[j] = 1;
				}else if(left == 0 && mid == 0 && right == 1){
					cells1[j] = 1;
				}else if(left == 1 && mid == 1 && right == 1){
					cells1[j] = 0;
				}
			}
			print10(cells1);
			
			int[] temp = cells;
			cells = cells1;
			cells1 = temp;
		}
		System.out.println("time lapsed: "+(System.currentTimeMillis() - timeStart));
//		System.out.println(" "+1%5);
//		System.out.println(" "+4%5);
	}
	
	public static void print10(int[] print){ 
		for (int x = 0; x < print.length; ++x){
			if (print[x] == 0)
				System.out.print ("0");
			else
				System.out.print ("1");
		}
		System.out.println();
	}
}


