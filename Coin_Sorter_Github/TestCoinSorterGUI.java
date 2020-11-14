package coinSorter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * @author ***** not given as instructed in the brief
 *
 * this class will create an object of CoinSorterGUI and run the coin sorter Application
 * it inherits from Application class to do so
 */
public class TestCoinSorterGUI extends Application {
	public void start(Stage stage) {
		
		CoinSorterGUI test = new CoinSorterGUI();

		test.customiseObjects();	// set the default object formatting we have chosen
		test.alignCentre();	// align all objects to the centre of their available area
		
		test.formatDefaultMainMenu();	// create and position nodes in the first scene
		
		stage.setScene(test.getScene());	// set the scene onto the stage
		stage.show();	// show the stage
	}
	
	public static void main(String[] args) {	// so that the application can be run from the IDE
		launch(args);	// use the launch method taking arguments from the main method
	}
	
}
