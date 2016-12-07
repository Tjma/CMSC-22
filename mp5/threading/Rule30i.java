package threading;

import java.util.*;

public class Rule30i {
	public static int THREAD_COUNT = 10;
	
	public static void main(String[] args) {
		System.out.println("Enter desired size: ");
		Scanner sc = new Scanner(System.in);
		int z = sc.nextInt();
		long timeStart = System.currentTimeMillis();
		String cell = "";
		String cell1 = "";
		int min = 0,max = 0;
		
		
		for(int i = 0; i < z; i++)
        {
          if(i == z/2){cell += '1';}
          else{cell += '0';}   
        }  System.out.println(cell);
        

        if(z < THREAD_COUNT){
            THREAD_COUNT = z;
        }
        
        Rule30Thread[] worker = new Rule30Thread[THREAD_COUNT];
        int itemsPerThread = z / THREAD_COUNT;
        max = itemsPerThread - 1;
        
        for(int i = 0; i < z - 1; i++){
        	for( int j = 0; j < THREAD_COUNT; j++){
        		if(j == THREAD_COUNT - 1){
        			max = z-1;
        		}
        		worker[j] = new Rule30Thread(min,max,cell);
        		min = max +1;
        		max = min + itemsPerThread - 1;
        	}
        for(int j = 0; j < THREAD_COUNT; j++){
        	worker[j].start();
        }
        
        for(int j = 0; j < THREAD_COUNT; j++){
        	while(worker[j].isAlive()){
        		try{
        			worker[j].join();
        		}catch (InterruptedException e){
        			System.err.println("thread interrupted: " + e.getMessage());
        		}
        	}
        }
        for(int j = 0; j < THREAD_COUNT; j++){
            cell1 += worker[j].getAns();
        }
        
        System.out.println(cell1);
        
        cell = cell1;
        cell1 = "";
        
        min = 0;
        max = itemsPerThread - 1;
    }
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - timeStart));
	}
}
