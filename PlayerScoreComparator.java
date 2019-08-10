import java.util.Comparator;

/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class implements the Comparator interface, and provides specialized sorting 
 * of PlayerScore objects based on the scores.
 */

public class PlayerScoreComparator implements Comparator<PlayerScore> {

	/**
	 * Implement the compare method of the interface
	 * @param score1
	 * @param score2
	 * @return the higher score of the score1 and score2 objects
	 */
	public int compare(PlayerScore score1, PlayerScore score2) {

		int sc1 = score1.getScore();
		int sc2 = score2.getScore();

		if (sc1 > sc2) {
			return -1;
		} else if (sc1 < sc2) {
			return +1;
		} else {
			return 0;
		}
	}
}