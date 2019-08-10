import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class represents the application AniMath, an animal-based educational math game for preschoolers.
 * The game has 10 questions and allows the user to traverse from one to the next. 
 * As part of building the user interface, it uses graphics, colors, sounds, images, event handling, 
 * exception handling, Layout managers, file I/O, and other techniques. 
 * It keeps track of the current player's score and also allows the user to see the top 5 highest scorers. 
 */

public class MathQuiz {

	//all the fields
	private JFrame frame;
	private JPanel p1, p2, p3;
	private JLabel[] questionLabels;
	private JRadioButton[] answerRadioButtons;
	private ButtonGroup[] arrayGroups;
	private JPanel[] questionPanels;
	private CardLayout cl;
	private JLabel lb1, lb2, lb3;
	private JButton nextBtn, answerBtn, scoreBtn, quitBtn;
	private int score;
	String playerName = "";
	
	QuizCollection q = null;
	
	ArrayList<QuizQuestion> quizQuestions = null;
	ScoreManager scoreMgr = null;

	/**
	 * constructor
	 * @param name of the player
	 */
	public MathQuiz(String name) {
		this.playerName = name;
		scoreMgr = new ScoreManager();
		q = new QuizCollection();
		quizQuestions = q.getQuestions();
		initialize();
	}

	/**
	 * Initialize the User Interface with components
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setSize(550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setTitle("AniMath - Math Learning Game");

		p1 = new JPanel();
		p1.setLayout(new BorderLayout());

		lb1 = new JLabel("  Hello " + playerName + "! Welcome to AniMath!");
		ImageIcon icon = new ImageIcon("src/images/mario.jpg");
		lb3 = new JLabel(icon);

		cl = new CardLayout();

		p2 = new JPanel();
		p2.setLayout(cl);

		questionPanels = new JPanel[quizQuestions.size()];// 10

		// A series of panels on which will rotate and show questions and answers
		for (int i = 0; i < questionPanels.length; i++) {

			questionPanels[i] = new JPanel();
			p2.add(questionPanels[i], String.valueOf(i));
			questionPanels[i].setLayout(new GridLayout(4, 1));

		}

		//RadioButtons representing multiple choice answers
		answerRadioButtons = new JRadioButton[quizQuestions.size() * 4]; // 40

		int index = 0;
		for (int ii = 0; ii < quizQuestions.size(); ii++) {
			String[] answersQz = quizQuestions.get(ii).getAnswers();
			for (int jj = 0; jj < answersQz.length; jj++) {
				answerRadioButtons[index] = new JRadioButton();
				answerRadioButtons[index].setText(answersQz[jj]);
				index += 1;

			}
		}

		//Multiple choice radio button groups
		arrayGroups = new ButtonGroup[quizQuestions.size()];

		int j = 0;
		for (int i = 0; i < arrayGroups.length; i++) {

			arrayGroups[i] = new ButtonGroup();

			arrayGroups[i].add(answerRadioButtons[j]);
			arrayGroups[i].add(answerRadioButtons[j + 1]);
			arrayGroups[i].add(answerRadioButtons[j + 2]);
			arrayGroups[i].add(answerRadioButtons[j + 3]);

			j += 4;
		}

		// Labels array with questions
		questionLabels = new JLabel[quizQuestions.size()];

		for (int i = 0; i < questionLabels.length; i++) {
			questionLabels[i] = new JLabel();
			questionLabels[i].setText(quizQuestions.get(i).getQuestion());
		}

		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		// Display the top 5 players with scores
		scoreBtn = new JButton("Top 5 Scores");
		scoreBtn.setEnabled(true);
		scoreBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String top5Scores = scoreMgr.displayTopFivePlayerScores();
				JOptionPane.showMessageDialog(null, top5Scores, "Top 5 Players", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Rotate panels with questions
		nextBtn = new JButton("Next Question");
		nextBtn.setEnabled(false);
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(p2);
				nextBtn.setEnabled(false);
				answerBtn.setEnabled(true);
				nextBtn.setText("Next Question");
			}
		});

		answerBtn = new JButton("Submit Your Answer");
		answerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextBtn.setEnabled(true);

				//when the right answer is selected
				if (answerRadioButtons[1].isSelected() || answerRadioButtons[5].isSelected()
						|| answerRadioButtons[9].isSelected() || answerRadioButtons[14].isSelected()
						|| answerRadioButtons[19].isSelected() || answerRadioButtons[21].isSelected()
						|| answerRadioButtons[28].isSelected() || answerRadioButtons[26].isSelected()
						|| answerRadioButtons[34].isSelected()) {
					score += 10;
					JOptionPane.showMessageDialog(null, "Yay! That's right!", "Good job!", JOptionPane.INFORMATION_MESSAGE);
					
				} else if (answerRadioButtons[37].isSelected()) {
					score += 10;
					JOptionPane.showMessageDialog(null, "Yay! That's right! You have scored: " + score + 
							" points", "Good job!", JOptionPane.INFORMATION_MESSAGE);
					scoreMgr.addScore(playerName, score);
					nextBtn.setText("Play Again?");
					score = 0; // reset points
				} else if (answerRadioButtons[36].isSelected() || answerRadioButtons[38].isSelected()
						|| answerRadioButtons[39].isSelected()) {
					((JButton) e.getSource()).setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Oops! That's not correct. You scored: " + score +
							" points", "Sorry!", JOptionPane.ERROR_MESSAGE);
					
					
					((JButton) e.getSource()).setBackground(Color.white);
					scoreMgr.addScore(playerName, score);
					nextBtn.setText("Play Again?");
					score = 0; // reset points
				} else {
					((JButton) e.getSource()).setBackground(Color.red);
					
					JOptionPane.showMessageDialog(null, "Oops! That's not correct.", "Sorry!", JOptionPane.ERROR_MESSAGE);
				
					((JButton) e.getSource()).setBackground(Color.white);
				}
				for (int i = 0; i < 10; i++) {
					arrayGroups[i].clearSelection();
				}
				answerBtn.setEnabled(false);
			}

		});
		
		// Graciously exit the game
		quitBtn = new JButton("Quit");
		quitBtn.setEnabled(true);
		quitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for playing!" , 
						"Have a good day!", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});


	}

	/*
	 * Add all the components to the panels and display the frame
	 */
	private void visualize() {
		p1.add(lb3, BorderLayout.WEST);
		p1.add(lb1, BorderLayout.CENTER);
		p1.setSize(500,  400);
		p3.add(nextBtn);
		p3.add(answerBtn);
		p3.add(scoreBtn);
		p3.add(quitBtn);

		JLabel[] imglabels = new JLabel[quizQuestions.size()];
		imglabels[0] = new JLabel(new ImageIcon("src/images/bees.png"));
		imglabels[1] = new JLabel(new ImageIcon("src/images/chimp.jpg"));
		imglabels[2] = new JLabel(new ImageIcon("src/images/dog.jpg"));
		imglabels[3]= new JLabel(new ImageIcon("src/images/mice.png"));
		imglabels[4] = new JLabel(new ImageIcon("src/images/octopus.jpg"));
		imglabels[5] = new JLabel(new ImageIcon("src/images/goldfish.png"));
		imglabels[6] = new JLabel(new ImageIcon("src/images/peacock.jpg"));
		imglabels[7]= new JLabel(new ImageIcon("src/images/pigs.png"));
		imglabels[8] = new JLabel(new ImageIcon("src/images/pony.png"));
		imglabels[9] = new JLabel(new ImageIcon("src/images/sheep.jpg"));
		
		
		int q = 0;
		for (int w = 0; w < quizQuestions.size(); w++) {

			questionPanels[w].add(questionLabels[w]);
			questionPanels[w].add(imglabels[w]);
			questionPanels[w].add(answerRadioButtons[q]);
			questionPanels[w].add(answerRadioButtons[q + 1]);
			questionPanels[w].add(answerRadioButtons[q + 2]);
			questionPanels[w].add(answerRadioButtons[q + 3]);


			questionPanels[w].setBackground(Color.cyan);
			q += 4;
		}

		//place panels
		frame.add(p1, BorderLayout.NORTH);
		frame.add(p2, BorderLayout.CENTER);
		frame.add(p3, BorderLayout.SOUTH);

		cl.show(p2, "0");
		frame.setVisible(true);

	}

	/*
	 * validate the player name
	 */
	public static boolean isValidName(String name) {
		String regex = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		regex = regex.trim();
	    return name.matches(regex);
	}
	
	/*
	 * Entry point to the game
	 */
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog(null, "Welcome to AniMath! Please enter your name.", "Welcome", JOptionPane.PLAIN_MESSAGE);
	    if (name == null) {
	    	System.exit(0);
	    }
	    if (!MathQuiz.isValidName(name) || name.equals(" ")) {
	    	JOptionPane.showMessageDialog(null, "That is not a valid name!" , 
					"Have a good day!", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
	    }
		MathQuiz quizApp = new MathQuiz(name);
		quizApp.visualize();
		try
        { 
            String filePath = "src/audio/PinkPanther30.wav"; 
            AudioPlayer audioPlayer =  
                            new AudioPlayer(filePath); 
              
            audioPlayer.play(); 
            while (true) 
            { 
               
            }  
        }
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace();           
        } 
	}
}