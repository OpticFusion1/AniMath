import java.util.ArrayList;

/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class represents the collection of QuizQuestions that are displayed 
 * to the user. The quiz questions, the associated answer choices, and the correct
 * answer are encapsulated in the QuizQuestion class.
 */

public class QuizCollection {

	//collection of quiz questions, associated choices, and correct answer
	private ArrayList<QuizQuestion> questionList = new ArrayList<QuizQuestion>();
	
	/**
	 * Default constructor
	 */
	public QuizCollection() {
		addQuizQuestions();
	}
	
	/**
	 * @return the list of questions
	 */
	public ArrayList<QuizQuestion> getQuestions() {
		return questionList;
	}
	
	/**
	 * Create the questions and assign the correct answers, and add them to the ArrayList
	 */
	private void addQuizQuestions() {

        String question = "  How many bees are in the meadow?";
        String[] answers1 = { "One", "Six", "Three", "Four" };
        QuizQuestion quizQuestion = new QuizQuestion(question, 1, answers1);//3
        this.questionList.add(quizQuestion);

        question = "  How many fingers does the chimp have?";
        String[] answers2 = { "Six", "Five", "Three", "One" };//7
        quizQuestion = new QuizQuestion(question, 1, answers2);
        this.questionList.add(quizQuestion);
        
        question = "  How many eyes does the dog have?";
        String[] answers3 = { "Four", "Two", "One", "Ten" };//11
        quizQuestion = new QuizQuestion(question, 1, answers3);
        this.questionList.add(quizQuestion);
        
        question = "  How many mice are there in the picture?";
        String[] answers4 = { "Four", "Nine", "Ten", "Seven" };//15
        quizQuestion = new QuizQuestion(question, 2, answers4);
        this.questionList.add(quizQuestion);
        
        question = "  How many tentacles does the octopus have?";
        String[] answers5 = { "Five", "Three", "Six", "Eight" };//19
        quizQuestion = new QuizQuestion(question, 3, answers5);
        this.questionList.add(quizQuestion);
        
        question = "  How many goldfish are there in the picture?";
        String[] answers6 = { "Two", "One", "Three", "four" };//23
        quizQuestion = new QuizQuestion(question, 1, answers6);
        this.questionList.add(quizQuestion);
        
        question = "  How many feathers does the peacock have?";
        String[] answers7 = { "Eight", "Five", "Nine", "Seven" };//27
        quizQuestion = new QuizQuestion(question, 2, answers7);
        this.questionList.add(quizQuestion);
        
        question = "  How many pigs are there in the picture?";
        String[] answers8 = { "Three", "Four", "Two", "Five" };//31
        quizQuestion = new QuizQuestion(question, 0, answers8);
        this.questionList.add(quizQuestion);
        
        question = "  How many ponies are there in the picture?";
        String[] answers9 = { "Three", "Four", "Seven", "Five" };//35
        quizQuestion = new QuizQuestion(question, 2, answers9);
        this.questionList.add(quizQuestion);
        
        question = "  How many legs does the sheep have?";
        String[] answers10 = { "Two", "Four", "Three", "One" };//39
        quizQuestion = new QuizQuestion(question, 1, answers10);
        this.questionList.add(quizQuestion);
        
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuizCollection q = new QuizCollection();
		
		ArrayList<QuizQuestion> quizQuestions = q.getQuestions();
		
	}

}
