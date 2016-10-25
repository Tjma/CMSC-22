import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Game extends Frame {
    private Label lblChoice;
    private Label l1;
    private Label l2;
    private Frame frame;
    private CheckboxGroup box;
    private TextArea area;
    private Button btn;
    private TextField field;
    private TextField field2;
    private CheckboxGroup choice;
    private Checkbox paper;
    private Checkbox rock;
    private Checkbox scissor;
    private Checkbox spock;
    private Checkbox lizard;
    private int choiceState;
    private int compRand;
    private int scorePlayer=0;
    private int scoreComp=0;
    private int compChoice;
    private Dialog end;
    
    public int randInt(){
    	Random rand = new Random();
        compRand = rand.nextInt((4 - 0) + 0) + 0;
        return compRand;
    }
    
    public void resetScore() {
		scoreComp = 0;
		scorePlayer = 0;
		field2.setText(String.format("%d", scoreComp));
		field.setText(String.format("%d", scorePlayer));
		//textArea.setText("Results: \n");
	}
    	
    
    public Game(){
        setLayout(new FlowLayout());
        
        lblChoice = new Label("Your choice: ");
        box = new CheckboxGroup();
        area = new TextArea("Result: \n");
        btn = new Button("RockPaperScissorsLizardSpock!");
        field = new TextField();
        field2 = new TextField();
        l1 = new Label("Player's Score");
        l2 = new Label("Computer's Score");
        choice = new CheckboxGroup();
        rock = new Checkbox("Rock",false,choice);
        paper = new Checkbox("Paper",false,choice);
        scissor = new Checkbox("Scissor",false,choice);
        lizard = new Checkbox("Lizard",false,choice);
        spock = new Checkbox("Spock",false,choice);
        end = new Dialog(end,"Game Over!",false);
    
   
   
    
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    });
    
    
    btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        	String rocks = "ROCK.\n";
			String papers = "PAPER.\n";
			String scissors = "SCISSORS.\n";
			String lizards = "LIZARD.\n";
			String spocks = "SPOCK.\n";
			area.append("\nPlayer chose ");
			if(rock.getState() == true) {
				area.append(rocks);
				choiceState = 0;
			} if(paper.getState() == true){
				area.append(papers);
				choiceState = 1;
			} if(scissor.getState() == true){
				area.append(scissors);
				choiceState = 2;
			} if(lizard.getState() == true){
				area.append(lizards);
				choiceState = 3;
			} if(spock.getState() == true){
				area.append(spocks);
				choiceState = 4;
			}
			area.append("Computer chose ");
			compChoice = randInt();
			if(compChoice == 0){
				area.append(rocks);
			}else if(compChoice == 1){
				area.append(papers);
			}else if(compChoice == 2){
				area.append(scissors);
			}else if(compChoice == 3){
				area.append(lizards);
			}else if(compChoice == 4){
				area.append(spocks);
			}
			
			if(choiceState == 0){//rock
				if(compChoice == 0){
					area.append("\ntie\n");
				}else if(compChoice == 1){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 2){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 3){
					area.append("\nYOU WIN THIS ROUND.\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 4){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}
				
			}else if(choiceState == 1){//paper
				if(compChoice == 0){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 1){
					area.append("\ntie\n");
				}else if(compChoice == 2){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 3){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 4){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}
				
			}else if(choiceState == 2){//scissor
				if(compChoice == 0){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 1){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 2){
					area.append("\ntie\n");
				}else if(compChoice == 3){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 4){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}
				
			}else if(choiceState == 3){//lizard
				if(compChoice == 0){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 1){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 2){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 3){
					area.append("\ntie\n");
				}else if(compChoice == 4){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}
			}else if(choiceState == 4){//spock
				if(compChoice == 0){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 1){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 2){
					area.append("\nYOU WIN THIS ROUND,\n");
					scorePlayer += 1;
					field.setText(String.format("%d", scorePlayer));
				}else if(compChoice == 3){
					area.append("\nCOMPUTER WIN THIS ROUND.\n");
					scoreComp += 1;
					field2.setText(String.format("%d", scoreComp));
				}else if(compChoice == 4){
					area.append("\ntie\n");
				}
			}
			
			if(scorePlayer == 5 || scoreComp == 5) {
				Button oK = new Button("OK");
				String winner = "";
				if(scoreComp == 5) {
					winner = "Computer wins!\n";
				}
				if(scorePlayer == 5) {
					winner = "Player wins!\n";
				}
				Label winn = new Label(winner);
				
				
				field2.setText(String.format("%d", scoreComp));
				field.setText(String.format("%d", scorePlayer));
				end.setBounds(100, 50, 250, 150);
				end.setLayout(new FlowLayout());
				end.add(winn);
				oK.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent a) {
						end.setVisible(true);
						resetScore();
						end.remove(winn);
						end.remove(oK);
					}
				});
				end.add(oK);
				end.setVisible(true);
				end.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent w) {
						end.setVisible(false);
						resetScore();
						end.remove(winn);
						end.remove(oK);
					}
				});
			}
        }
        
    });
    field.setText(String.format("%d", scorePlayer));
    field2.setText(String.format("%d", scoreComp));
    add(lblChoice);
    add(rock);
    add(paper);
    add(scissor);
    add(lizard);
    add(spock);
    add(area);
    add(btn);
    add(l1);
    add(field);
    add(l2);
    add(field2);
    
    
    
    setTitle("RockPaperScissorsLizardSpock!");
    setSize(700,500);
    setVisible(true);
    
   
   /* box getSelectedCheckbox(){
    	
    }*/
 }
    
    
    public static void main(String[] args){
        new Game();
    }
}