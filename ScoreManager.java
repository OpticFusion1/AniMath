import java.util.*;
import java.io.*;

/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class gets the existing scores, updates the latest score, sorts the top 5 scores, and stores them in a file. 
 */

public class ScoreManager {
	
    // A collection of PlayerScore objects
    private ArrayList<PlayerScore> scores;

    // The name of the file where the scores will be saved
    private static final String SCORE_FILE = "src/playerscores.dat";

    // I/O streams to manipulate the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    /**
     * Constructor
     */
    public ScoreManager() {
        scores = new ArrayList<PlayerScore>();
    }
    
    /**
     * This method imports the player names and scores from a file and populates the list. 
     */
	public void importPlayerScores() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(SCORE_FILE));
			scores = (ArrayList<PlayerScore>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + SCORE_FILE);
		} catch (IOException e) {
			System.out.println("I/O Exception: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not found: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("I/O Exception: " + e.getMessage());
			}
		}
	}
	
	/**
	 * This method implements the export of player scores to a file.
	 */
	public void exportPlayerScores() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(SCORE_FILE));
			outputStream.writeObject(scores);
		} catch (FileNotFoundException e) {
			System.out.println("Export File Not Found:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception while exporting the score file: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("I/O Exception while exporting the score file: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Adds the score to the array list collection and updates the score file
	 * @param name
	 * @param score
	 */
	public void addScore(String name, int score) {
		importPlayerScores();
		scores.add(new PlayerScore(name, score));
		exportPlayerScores();
	}
	
	/**
	 * Gets the scores of the players in a sorted order
	 * @return scores collection
	 */
	public ArrayList<PlayerScore> getScores() {
		importPlayerScores();
		sort();
		return scores;
	}
	
	/**
	 * Sort the array list collection based on player scores
	 */
	private void sort() {
		PlayerScoreComparator comparator = new PlayerScoreComparator();
		Collections.sort(scores, comparator);
	}
	
	/**
	 * This method displays the top five player scores
	 * @return topScoreStr 
	 */
	public String displayTopFivePlayerScores() {
		String topScoreStr = "";
		int numPlayers = 5;

		ArrayList<PlayerScore> scores;
		scores = getScores();

		int i = 0;
		int x = scores.size();
		if (x > numPlayers) {
			x = numPlayers;
		}
		while (i < x) {
			topScoreStr += (i + 1) + ".\t" + " Player: " + scores.get(i).getName() +
					"\t\t" + " - with Score: " + scores.get(i).getScore() + "\n";
			i++;
		}
		return topScoreStr;
	}
}