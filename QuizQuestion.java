/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class represents the quiz questions, the associated answer choices, and the correct answer.
 */
public class QuizQuestion {

	private final String question;
    private final int correctAnswerIndex;
    private final String[] answers;

    /**
     * Constructor 
     * @param question
     * @param correctAnswerIndex
     * @param answers
     */
    public QuizQuestion(String question, int correctAnswerIndex, String[] answers) {
        this.question = question;
    	this.correctAnswerIndex = correctAnswerIndex;
        this.answers = answers;
    }

    /**
     * Returns the question string
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer for the associated question
     * @return answer 
     */
    public String getCorrectAnswer() {
        return answers[correctAnswerIndex];
    }
    
    /**
     * Returns the multiple choice answers
     * @return answers
     */
    public String[] getAnswers() {
        return answers;
    }

}
