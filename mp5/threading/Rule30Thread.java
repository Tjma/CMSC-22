package threading;

public class Rule30Thread extends Thread{

	private static String input;
    private int min;
    private int max;
    private String ans = "";
    
    public Rule30Thread(int min, int max, String input) {
        if (min > max || min < 0 || max < 0) {
            throw new IllegalArgumentException("error");
        }
        this.min = min;
        this.max = max;
        this.input = input;
    }
    public void run(){
    	 for(int i = min; i <= max; i++){
             ans += solver(i);
         }
    }
	private char solver(int i) {
		// TODO Auto-generated method stub
		char ans ='0';
		
		if(i == 0){
	        if(input.charAt(i + 1) == '1' && input.charAt(i) == '1')
	            ans = '1';
	        if(input.charAt(i) == '1' &&  input.charAt(i + 1) != '1')
	            ans = '1';
	        if(input.charAt(i) != '1' && input.charAt(i + 1) == '1')
	            ans = '1';  
	        }
	        
	        else if(i == input.length() - 1 ){
	        if(input.charAt(i - 1) == '1' && input.charAt(i) != '1')
	            ans = '1';
	        if(input.charAt(i - 1) != '1' && input.charAt(i) == '1')
	            ans = '1';
	        }
	        
	        else{
	        if(input.charAt(i - 1) == '1' && input.charAt(i) != '1' && input.charAt(i + 1) != '1')
	            ans = '1';
	        if(input.charAt(i - 1) != '1' && input.charAt(i) == '1' && input.charAt(i + 1) == '1')
	            ans = '1';
	        if(input.charAt(i - 1) != '1' && input.charAt(i) == '1' &&  input.charAt(i + 1) != '1')
	            ans = '1';
	        if(input.charAt(i - 1) != '1' && input.charAt(i) != '1' && input.charAt(i + 1) == '1')
	            ans = '1';  
	        }
	        
	        return ans;
	    }
	    
	    public String getAns(){
	        return ans;
	    }
	}
