import java.io.File; 
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
  
/**
 * @author Natampalli, Ashwin
 * 19SP CS-170-01 (076011) (Hybrid)
 * Final Project
 * Due Date: May 15, 2019
 */
/**
 * This class generates the music that plays while the game is running.
 */

public class AudioPlayer  { 
  
    //To store current position 
    Long currentFrame; 
    Clip clip; 
      
    AudioInputStream audioInputStream; 
    static String filePath; 
  
    //Constructor to initialize streams and clip 
    public AudioPlayer(String filePath) 
        throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  
    { 
        //Create AudioInputStream object 
    	this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
          
        //Create clip reference 
        clip = AudioSystem.getClip(); 
          
        //Open audioInputStream to the clip 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
        
    }
    
    /*
     * Method to play the audio 
     */
    public void play()  
    { 
        //start the clip 
        clip.start(); 
    } 
    
    /*
     * Main method
     */
    public static void main(String[] args)  
    { 
    	try
        { 
            filePath = "src/audio/PinkPanther30.wav"; 
            AudioPlayer audioPlayer = new AudioPlayer(filePath);   
            audioPlayer.play(); 
   
            //keep playing the music until the user quits
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