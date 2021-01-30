
package xmarksthespot;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
/**
 *
 * @author John R. McKahan II
 */
public class FXMLDocumentController implements Initializable {
    
    //This is the string that holds the correct location of the treasure
    public String correctButtonName;
    
   
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;      
    @FXML
    private Button four;
    @FXML
    private Button seven;
    @FXML
    private Button five;
    @FXML
    private Button eight;
    @FXML
    private Button six;
    @FXML
    private Button nine;
    @FXML
    private Button ten;
    @FXML
    
    //The buttons are put into an array, this will be used to randomly select a winner
    public static String[] buttonList = {"one","two","three","four","five","six","seven",
    "eight","nine","ten"}; 
    
    
    // This is the main method that handles the game
    public void buttonPress(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String selectedButton = clickedButton.getId();
        System.out.print(selectedButton);
    
        // If the user correctly guesses the winning button
        if (correctButtonName.equals(selectedButton)) {
            
            //Displays a popup alerting the user that they won the game.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Win!");
            alert.setHeaderText("Congratulations, you found the treasure!");
            alert.setContentText("Would you like to play again?");
            ButtonType okButton = new ButtonType("Play again");
            ButtonType noThanksButton = new ButtonType("No Thanks!");
            alert.getButtonTypes().setAll(okButton, noThanksButton);
            Optional<ButtonType> result = alert.showAndWait();
           
            //If the user selects "Play again" a new button will be randomly selected
            if (result.get() == okButton ){
                //Chooses a random button from the list of buttons
                correctButtonName = buttonList[(int)(Math.random() * buttonList.length)];
            }
            //If the user does not select "Play again", the application will be closed
            else {System.exit(0);}
      
        }
        
        //If the user chooses any button except for the winning button
        else if (!selectedButton.equals(correctButtonName)) {
            
            //Displays a popup alerting the user that they did not find the treasure.
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("No treasure!");
            alert2.setHeaderText("There was no treasure found on that island");
            alert2.setContentText("Would you like to continue searching for treasure?");
            ButtonType ayeCaptain = new ButtonType ("Continue Searching");
            ButtonType noCaptain = new ButtonType ("Quit");
            alert2.getButtonTypes().setAll(ayeCaptain,noCaptain);
            Optional<ButtonType> result2 = alert2.showAndWait();
            
                if (result2.get() == ayeCaptain){
                    //The search for treasure continues!
                }
                else{ 
                    System.exit(0);
                }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
//This generates a random button from the list of buttons to be selected as the winning button.
    correctButtonName = buttonList[(int)(Math.random() * buttonList.length)];
    
/* If you want to test out the program but hate guessing, this will give you the correct button name.
 This is a cheat code for "X Marks The Spot!".
 System.out.print(correctButtonName);
*/
    }    
    
}
