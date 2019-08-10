import java.io.Serializable;

/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class represents the player and their score. 
 */

public class PlayerScore implements Serializable {
    private int score;
    private String name;


    /**
     * Constructor
     * @param name
     * @param score
     */
    public PlayerScore(String name, int score) {
    	 this.name = name;
        this.score = score;       
    }
    
    /**
     * Return the player score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Get the name of the player
     * @return name
     */
    public String getName() {
        return name;
    }

}