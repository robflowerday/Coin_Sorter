package coinSorter;	// package that holds a group of related classes. In this case CoinSorter, TestCoinSorter, CoinSorterGUI and TestCoinSorterGUI

import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * 
 * @author ***** not given as instructed in the brief
 *
 * this class will create a Coin Sorter that can be used to exchange a total value of coins into one, or many denominations using a GUI
 * it inherits from CoinSorter class
 */
public class CoinSorterGUI extends CoinSorter {	// the extends keyword indicates that CoinSorterGUI is a subclass of CoinSorter and inherits its methods and attributes

	// Attributes	
	
	/* add validation test booleans */
	private boolean test1 = false;	// boolean used for validation
	private boolean test2 = false;	// boolean used for validation
	private boolean test3 = false;	// boolean used for validation
	
	/* set the default size of our scene (And therefore the window our program will run in) */
	private int defaultSceneWidth = 1000;	// default width that all scenes will be set to
	private int defaultSceneHeight = 700;	// default height that all scenes will be set to
	
	
	/* initialise the variables necessary to format the aesthetics of the objects */
	
	/* create default background for root nodes*/
	private Color defaultRootNodeBackgroundColour = Color.rgb(227, 233, 240);	// default background colour of the root node of any scene
	private CornerRadii defaultRootNodeBackgroundCornerRadii = new CornerRadii(0);	// default corner radii (roundness) of the root node background of any scene
	private Insets defaultRootNodeBackgroundInsets = new Insets(0);	// default padding of the root node background of any scene
	private Background defaultRootNodeBackground = new Background(new BackgroundFill(defaultRootNodeBackgroundColour, defaultRootNodeBackgroundCornerRadii, defaultRootNodeBackgroundInsets)); // default background object of a root node of any scene
	
	/* create default background and text formatting for buttons */
	private Color defaultButtonBackgroundColour = Color.rgb(85, 158, 209);	// default background colour of a button
	private CornerRadii defaultButtonBackgroundCornerRadii = new CornerRadii(10);	// default corner radii (roundness) of a button
	private Insets defaultButtonBackgroundInsets = new Insets(0);	// default padding of a button
	private Background defaultButtonBackground = new Background(new BackgroundFill(defaultButtonBackgroundColour, defaultButtonBackgroundCornerRadii, defaultButtonBackgroundInsets));	// default background object of a button
	private Color defaultButtonTextColour = Color.WHITE;
	
	private Color defaultHoverButtonBackgroundColour = Color.rgb(191, 144, 0);	// default background colour of a button as you hover over it
	private Background defaultHoverButtonBackground = new Background(new BackgroundFill(defaultHoverButtonBackgroundColour, defaultButtonBackgroundCornerRadii, defaultButtonBackgroundInsets));	// default background object of a button
	
	private Color defaultHoverQuitButtonBackgroundColour = Color.RED;	// default background colour of a quit button as you hover over it
	private Background defaultHoverQuitButtonBackground = new Background(new BackgroundFill(defaultHoverQuitButtonBackgroundColour, defaultButtonBackgroundCornerRadii, defaultButtonBackgroundInsets));	// default background object of a button
	
	/* create default font and colour for labels */
	private Font defaultFont = new Font("Kalorama", 16);	// default font and font size
	private Color defaultLabelColour = Color.rgb(55, 61, 110);	// default label colour
	private Color defaultErrorLabelColour = Color.RED.darker();	// default error label colour
	
	
	/* 
	 * Initialise all the buttons in the project
	 * pass text for each button as a parameter (we could have used the setText() method instead)
	 */
	
	/* Buttons to be used in multiple scenes */
	private Button quitProgramButton = new Button("Quit Program");	// button to terminate the program
	private Button mainMenuButton = new Button ("Main Menu");	// button to return to the main menu scene
	private Button calculateButton = new Button("Calculate");	// button to calculate something
	
	/* Buttons to be used only in the main menu scene */
	private Button coinCalculatorButton = new Button("Use Coin Calculator");	// button to set coin calculator scene
	private Button multipleCoinCalculatorButton = new Button("Use Multiple Coin Calculator");	// button to set multiple coin calculator scene
	private Button printCoinListButton = new Button("Display Current Coin List");	// button to display the current coin list
	private Button setDetailsButton = new Button("Set Details");	// button to set 'set details' scene
	private Button displayProgramConfigsButton = new Button("Display Program Configurations");	// button to display the current program configurations
	private Button clearHistoryButton = new Button("Clear History");	// button to clear user history
	
	/* Buttons to be used only in the set details scene */
	private Button setCurrencyButton = new Button("Set Currency");	// button to set currency
	private Button setMinCoinInButton = new Button("Set Minimum Coins to Exchange");	// button to set minCoinIn
	private Button setMaxCoinInButton = new Button("Set Maximum Coins to Exchange");	// button to set maxCoinIn
	private Button setAllConfigsButton = new Button("Set All Chosen Configurations Simultaneously");	// button to set all configuration user has inputed
	
	private Button[] buttonList = {quitProgramButton, mainMenuButton, calculateButton, coinCalculatorButton, multipleCoinCalculatorButton, printCoinListButton, setDetailsButton, displayProgramConfigsButton, clearHistoryButton, setCurrencyButton, setMinCoinInButton, setMaxCoinInButton, setAllConfigsButton};	// create a button list with all of our buttons so that we can loop through them
	
	/* 
	 * Initialise all the Labels in the project as empty strings
	 *  */
	private Label explanationLabel = new Label("");	// explain the current scene to the user
	private Label inputLabel1 = new Label("");	// prompt the user for input
	private Label inputLabel2 = new Label("");	// prompt the user for input
	private Label inputLabel3 = new Label("");	// prompt the user for input
	private Label outputLabel1 = new Label("");	//display the output of an action performed
	private Label outputLabel2 = new Label("");	//display the output of an action performed
	private Label errorLabel1 = new Label("");	// display appropriate error if validation of an input fails
	private Label errorLabel2 = new Label("");	// display appropriate error if validation of an input fails
	private Label errorLabel3 = new Label("");	// display appropriate error if validation of an input fails
	
	/* Initialise all the text fields in the Project */
	private TextField inputTextField1 = new TextField();	//collect user input
	private TextField inputTextField2 = new TextField();	//collect user input
	
	/* Initialise all the text areas in the Project */
	private TextArea historyTextArea = new TextArea();	// store the user history
	
	/* Initialise all the titled panes in the Project */
	private TitledPane historyPane = new TitledPane("History", historyTextArea);	// store the user history text area with a label and allow suppression of the history
		
	/* Initialise all the choice boxes in the Project */
	private ChoiceBox currencyChoiceBox = new ChoiceBox();	// list the possible currencies
	
	/* Initialise all the scroll bars in the Project */
	private Slider minCoinInSlider = new Slider();	// collect user input for minimum coins to exchange
	private Slider maxCoinInSlider = new Slider();	// collect user input for maximum coins to exchange
	
	/* 
	 * Initialise all the HBoxes in the project
	 * pass the spacing between each node inside the HBox as a parameter (we could have used the setSpacing() method instead)
	 */
	private HBox inputHBox1 = new HBox(10);	// horizontal box that contains input nodes
	private HBox inputHBox2 = new HBox(10);	// horizontal box that contains input nodes
	private HBox inputHBox3 = new HBox(10);	// horizontal box that contains input nodes
	private HBox labelHBox1 = new HBox(200);	// horizontal box that contains label(s)
	private HBox labelHBox2 = new HBox();	// horizontal box that contains label(s)
	private HBox buttons = new HBox(10);	// horizontal box that contains buttons
	private HBox singleButtonHBox = new HBox();	// horizontal box that contains a button
	private HBox historyHBox = new HBox(30);	// horizontal box to contain, among other things, the History titled pane
	
	
	/* 
	 * Initialise all the VBoxes in the project
	 * pass the spacing between each node inside the HBox as a parameter (we could have used the setSpacing() method instead)
	 */
	
	/* VBoxes to be used in multiple scenes */
	private VBox inputVBox1 = new VBox(10);	// vertical box that contains input nodes
	private VBox inputVBox2 = new VBox(10);	// vertical box that contains input nodes
	private VBox root = new VBox(30);	// vertical box that contains all other nodes in the scene
	
	private String history = "";	// keep tack of the user history
	

	private Scene scene = new Scene(root, defaultSceneWidth, defaultSceneHeight);	// scene object that holds all nodes
	
	// Methods
	
	/* constructors */
	/**
	 * constructor takes all arguments of superclass constructor and sets them using the super constructor
	 */
	public CoinSorterGUI(String currencyIn, int minCoinInIn, int maxCoinInIn, ArrayList<Integer> coinListIn, String symbolIn) {
		super(currencyIn, minCoinInIn, maxCoinInIn, coinListIn, symbolIn);	//use super class constructors settings
	}

	/**
	 * constructor takes no arguments and sets attributes in super class to their default values 
	 */
	public CoinSorterGUI() {
		setCurrency("GBP (p)");	// set currency to "GBP (p)"
		setMinCoinIn(0);	// set minimum coin value in to 0
		setMaxCoinIn(10000);	// set maximum coin value in to 10,000
		setCoinList(getGBPCoinList());	// set the current available coin list to the GBP currency
		setSymbol("p");	// set the symbol to pennies, "p"
	}
	
	/* getters and setters */
	
	/* scene getters */
	/**
	 * return the scene, Scene object
	 */
	public Scene getScene() {
		return scene;
	}
	
	public int getDefaultSceneWidth() {
		return defaultSceneWidth;
	}
	
	public int getDefaultSceneHeight() {
		return defaultSceneHeight;
	}
	
	/* button getters */
	/**
	 * return the quit program button - Button object
	 */
	public Button getQuitProgramButton() {
		return quitProgramButton;
	}
	
	/**
	 * return the main menu button - Button object
	 */
	public Button getMainMenuButton() {
		return mainMenuButton;
	}
	
	/**
	 * return the coin calculator button - Button object
	 */
	public Button getCoinCalculatorButton() {
		return coinCalculatorButton;
	}
	
	/**
	 * return the multiple coin calculator button - Button object
	 */
	public Button getMultipleCoinCalculatorButton() {
		return multipleCoinCalculatorButton;
	}
	
	/**
	 * return the print coin list button - Button object
	 */
	public Button getPrintCoinListButton() {
		return printCoinListButton;
	}
	
	/**
	 * return the set details button - Button object
	 */
	public Button getSetDetailsButton() {
		return setDetailsButton;
	}
	
	/**
	 * return the display program configs button - Button object
	 */
	public Button getDisplayProgramConfigsButton() {
		return displayProgramConfigsButton;
	}
	
	// overridden methods of the superclass
	
	
	// methods that customise the look of our objects
	
	/**
	 * take in a label and sets its colour and font using our created default attributes
	 */
	public void customiseLabel(Label labelIn) {
		labelIn.setFont(defaultFont);	// set default label font and font size
		labelIn.setTextFill(defaultLabelColour);	// set default label text colour
		labelIn.setWrapText(true);
	}		
	
	/**
	 * take in a label and sets its colour and font using our created default attributes
	 */
	public void customiseErrorLabel(Label labelIn) {
		labelIn.setFont(defaultFont);	// set default label font and font size
		labelIn.setTextFill(defaultErrorLabelColour);	// set default label text colour
	}	
	
	/**
	 * take in a button and sets its background and text formatting using our created default attributes
	 */
	public void customiseButton(Button buttonIn) {
		buttonIn.setBackground(defaultButtonBackground);	// set default background
		buttonIn.setTextFill(defaultButtonTextColour);	// set default text colour
		buttonIn.setFont(defaultFont);
	}	
	
	/**
	 * customise control objects using the methods customiseLabel(), customiseButton() and the default root node background
	 */
	public void customiseObjects() {
		/* set the colour font and font size of our labels using the customiseLabel() method */
		customiseLabel(explanationLabel);
		customiseLabel(inputLabel1);
		customiseLabel(inputLabel2);
		customiseLabel(inputLabel3);
		customiseLabel(outputLabel1);
		customiseLabel(outputLabel2);
		customiseErrorLabel(errorLabel1);
		customiseErrorLabel(errorLabel2);
		customiseErrorLabel(errorLabel3);
		
		/* set the background and text colour of our buttons using the customiseButton() method */
		customiseButton(quitProgramButton);
		customiseButton(mainMenuButton);
		customiseButton(calculateButton);
		customiseButton(coinCalculatorButton);
		customiseButton(multipleCoinCalculatorButton);
		customiseButton(printCoinListButton);
		customiseButton(setDetailsButton);
		customiseButton(displayProgramConfigsButton);
		customiseButton(clearHistoryButton);
		customiseButton(setCurrencyButton);
		customiseButton(setMinCoinInButton);
		customiseButton(setMaxCoinInButton);
		customiseButton(setAllConfigsButton);
		
		/* set the root node backgrounds to our created default background */
		root.setBackground(defaultRootNodeBackground);
	}
	

	/**
	 * align all of out containers to the centre of their available area
	 */
	public void alignCentre() {
		inputHBox1.setAlignment(Pos.CENTER);
		inputHBox2.setAlignment(Pos.CENTER);
		inputHBox3.setAlignment(Pos.CENTER);
		labelHBox1.setAlignment(Pos.CENTER);
		labelHBox2.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		singleButtonHBox.setAlignment(Pos.CENTER);
		historyHBox.setAlignment(Pos.CENTER);
		inputVBox1.setAlignment(Pos.CENTER);
		inputVBox2.setAlignment(Pos.CENTER);
		root.setAlignment(Pos.CENTER);
	}	
	
	// methods that set the default layout of our scenes

	
	/**
	 * empty the contents of all containers so they can be reused
	 */
	public void emptyContainers() {
		currencyChoiceBox.getItems().clear();
		inputHBox1.getChildren().clear();
		inputHBox2.getChildren().clear();
		inputHBox3.getChildren().clear();
		labelHBox1.getChildren().clear();
		labelHBox2.getChildren().clear();
		buttons.getChildren().clear();
		singleButtonHBox.getChildren().clear();
		historyHBox.getChildren().clear();
		inputVBox1.getChildren().clear();
		inputVBox2.getChildren().clear();
		root.getChildren().clear();
	}
	
	/**
	 * reset all the Label and text field values
	 */
	public void resetText() {
		
		/*  reset all labels to empty strings */
		explanationLabel.setText("");	
		inputLabel1.setText("");
		inputLabel2.setText("");
		inputLabel3.setText("");
		outputLabel1.setText("");
		outputLabel2.setText("");
		errorLabel1.setText("");
		errorLabel2.setText("");
		errorLabel3.setText("");
		
		/*  reset all text fields to empty strings */
		inputTextField1.setText("");
		inputTextField2.setText("");
	}
	
	
	/* position and set the relevant nodes for each scene*/
	
	/**
	 * position and set the nodes in the main menu page
	 */
	public void formatDefaultMainMenu() {
		
		emptyContainers();
		resetText();
		
		explanationLabel.setText("Welcome to the Coin Sorter."); 	// set the explanation message (in this case a welcome message) for the main menu scene
		historyTextArea.setText(history); 	// add the user history to the history text area
		historyPane.setMaxSize(200, 200); 	// set the maximum dimensions of the history titled pane
		historyPane.setExpanded(false); 	// set the initial expanded state of the titled pane to be collapsed
		
		labelHBox1.getChildren().addAll(explanationLabel, outputLabel1);	// add the descriptive labels to the label HBox
		buttons.getChildren().addAll(coinCalculatorButton, multipleCoinCalculatorButton, printCoinListButton, setDetailsButton,  displayProgramConfigsButton, clearHistoryButton, quitProgramButton);	// add all relevant buttons to the buttons HBox
		historyHBox.getChildren().addAll(clearHistoryButton, historyPane, quitProgramButton);	// add the history, and appropriate labels to the history HBox
		
		root.getChildren().addAll(labelHBox1, buttons, historyHBox);	// add the children nodes to the root node
		
		mainMenuLogic();
	}
	
	/**
	 * position and set the nodes in the coin calculator page
	 */
	public void formatDefaultCoinCalculator() {
		
		emptyContainers();
		resetText();
		explanationLabel.setText("Give the Coin Sorter an amount to exchange and a coin to exchange it into.\n\tWe'll tell you how many of those coins you'll get and what remains.");
		inputLabel1.setText("Enter amount to Exchange between " + getMinCoinIn() + " and " + getMaxCoinIn() + " : ");
		inputLabel2.setText("Enter coin to use in Exchange from coin list " + getCoinList() + " : ");
		
		labelHBox1.getChildren().add(explanationLabel);
		inputHBox1.getChildren().addAll(inputLabel1, inputTextField1, errorLabel2);
		inputHBox2.getChildren().addAll(inputLabel2, inputTextField2, errorLabel3);
		buttons.getChildren().addAll(mainMenuButton, quitProgramButton);
		
		root.getChildren().addAll(labelHBox1, inputHBox1, inputHBox2, calculateButton, outputLabel1, buttons);
		
		coinCalculatorLogic();
	}
	
	
	/**
	 * position and set the nodes in the coin calculator page
	 */
	public void formatDefaultMultipleCoinCalculator() {
		
		emptyContainers();
		resetText();
		
		explanationLabel.setText("	Give the Coin Sorter an amount to exchange and if you like, a coin to exclude\nfrom the exchange. We'll tell you how many of of each coin you'll get and what remains.");
		inputLabel1.setText("Enter amount to Exchange " + getMinCoinIn() + " and " + getMaxCoinIn() + " : ");
		inputLabel2.setText("(Optional) Enter coin to exclude from Exchange " + getCoinList() + " : ");
		
		labelHBox1.getChildren().add(explanationLabel);
		inputHBox1.getChildren().addAll(inputLabel1, inputTextField1, errorLabel2);
		inputHBox2.getChildren().addAll(inputLabel2, inputTextField2, errorLabel3);
		buttons.getChildren().addAll(mainMenuButton, quitProgramButton);
		
		root.getChildren().addAll(labelHBox1, inputHBox1, inputHBox2, calculateButton, outputLabel1, buttons);
		
		multipleCoinCalculatorLogic();
	}	
	
	
	/**
	 * position and set the nodes in the set details page
	 */
	public void formatDefaultSetDetails() {
		
		emptyContainers();
		resetText();
		
		explanationLabel.setText("Please choose any of the below options");

		inputLabel1.setText("Currency: ");
		inputLabel2.setText("Min coin value in: ");
		inputLabel3.setText("Max coin value in: ");
		
		currencyChoiceBox.getItems().addAll("GBP (p)", "EUR (cent)", "USD (cent)");
		currencyChoiceBox.setMinWidth(49);
		
		/* format sliders */
		minCoinInSlider.setMin(0);
		minCoinInSlider.setMax(10000);
		minCoinInSlider.setValue(40);
		minCoinInSlider.setShowTickLabels(true);
		minCoinInSlider.setShowTickMarks(true);
		minCoinInSlider.setMajorTickUnit(5000);
		minCoinInSlider.setMinorTickCount(4);
		minCoinInSlider.setBlockIncrement(1000);
		
		maxCoinInSlider.setMin(0);
		maxCoinInSlider.setMax(10000);
		maxCoinInSlider.setValue(40);
		maxCoinInSlider.setShowTickLabels(true);
		maxCoinInSlider.setShowTickMarks(true);
		maxCoinInSlider.setMajorTickUnit(5000);
		maxCoinInSlider.setMinorTickCount(4);
		maxCoinInSlider.setBlockIncrement(1000);
		
		
		inputHBox1.getChildren().addAll(inputLabel1, currencyChoiceBox, setCurrencyButton, errorLabel1);
		inputHBox2.getChildren().addAll(inputLabel2, inputTextField1, minCoinInSlider, setMinCoinInButton, errorLabel2);
		inputHBox3.getChildren().addAll(inputLabel3, inputTextField2, maxCoinInSlider, setMaxCoinInButton, errorLabel3);
		
		singleButtonHBox.getChildren().add(setAllConfigsButton);

		outputLabel1.setText("Current currency: " + getCurrency() + "\nCurrent min coin value in: " + getMinCoinIn() + "\nCurrent max coin value in: " + getMaxCoinIn());

		buttons.getChildren().addAll(mainMenuButton, quitProgramButton);		
				
		root.getChildren().addAll(explanationLabel, inputHBox1, inputHBox2, inputHBox3, singleButtonHBox, outputLabel1, buttons);	// add the children nodes to the root node
		
		setDetailsLogic();
	}
	
	// methods that set the actions taken when each of our buttons is pressed
	
	
	/**
	 * provides instructions to be followed as each button is pressed on the main menu page
	 */
	public void mainMenuLogic() {
		coinCalculatorButton.setOnAction(e -> {
			formatDefaultCoinCalculator();	// go to coin calculator page
		});
		
		multipleCoinCalculatorButton.setOnAction(e -> {
			formatDefaultMultipleCoinCalculator();	// go to multiple coin calculator page
		});
		
		printCoinListButton.setOnAction(e -> {
			outputLabel1.setText(printCoinList());
			history = "Display Current Coin List:" + printCoinList() + "\n\n" + history;
			historyTextArea.setText(history);
		});
		
		setDetailsButton.setOnAction(e -> {
			formatDefaultSetDetails();	// go to set details page
		});
		
		displayProgramConfigsButton.setOnAction(e -> {
			outputLabel1.setText(displayProgramConfigs());
			history = "Display Program Configurations:" + displayProgramConfigs() + "\n" + history;
			historyTextArea.setText(history);
		});
		
		clearHistoryButton.setOnAction(e -> {
			history = "";
			historyTextArea.setText(history);	// set history text area to an empty string
		});
		
		quitProgramButton.setOnAction(e -> {
			System.exit(0);	// end the program
		});
		
		/* even though this button is not on this page, it is set here, as we will now not have to set it on any other page */
		mainMenuButton.setOnAction(e -> {
			formatDefaultMainMenu();
		});
		
		/* set the buttons so that the colour of their background changes when you hover of them, and again when you stop hovering over them */
		for (Button button : buttonList) {
			button.setOnMouseMoved(e -> {	// perform action whilst hovering over the button
				button.setBackground(defaultHoverButtonBackground);	// change the background of the button
			});
			
			button.setOnMouseExited(e -> {	// perform action whilst no longer hovering over the button
				button.setBackground(defaultButtonBackground);	// change the background of the button
			});
		}
		
		quitProgramButton.setOnMouseMoved(e -> {	// perform action whilst hovering over the button
			quitProgramButton.setBackground(defaultHoverQuitButtonBackground);	// change the background of the button
		});
		quitProgramButton.setOnMouseExited(e -> {	// perform action whilst no longer hovering over the button
			quitProgramButton.setBackground(defaultButtonBackground);	// change the background of the button
		});
	}
		
	/**
	 * provides instructions to be followed as each button is pressed on the coin calculator page
	 */
	public void coinCalculatorLogic() {
		
		calculateButton.setOnAction(e -> {
			
			/* set the error and output labels text to empty strings */
			errorLabel1.setText("");
			errorLabel2.setText("");
			outputLabel1.setText("");
			
			validateTotalCoinValue();	// collect, validate and set if valid the users chosen total coin value to exchange or display the appropriate error message
			validateExcludedCoin();	// collect, validate and set if valid the users chosen coin denomination or display the appropriate error message
			
			if ((errorLabel2.getText().equals(""))&&(errorLabel3.getText().equals(""))) {	// check if the validations threw any errors
				outputLabel1.setText(coinCalculator(getTotalCoinIn(), getExcludedCoin()));	// if no errors appear, use the coinCalculator method on the validated user choices and display the results
				history = "coin calculator used:\ncoin value exchanged: " + getTotalCoinIn() + "\ncoin to be used in exchange: " + getExcludedCoin() + getSymbol() + "\nresult: " + coinCalculator(getTotalCoinIn(), getExcludedCoin()) + "\n\n" + history;	// log the result in history
			}
		});
	}
	
	/**
	 * provides instructions to be followed as each button is pressed on the multiple coin calculator page
	 */
	public void multipleCoinCalculatorLogic() {
		
		calculateButton.setOnAction(e -> {
			
			/* reset the error and output labels text to empty strings */
			errorLabel2.setText("");
			errorLabel3.setText("");
			outputLabel1.setText("");
			
			validateTotalCoinValue();	// collect, validate and set if valid the users chosen total coin value to exchange or display the appropriate error message
		
			if (inputTextField2.getText().equals("")) {	// if no value is entered for a coin to exclude, we can assume the user doesn't want to exclude a coin
				if (errorLabel2.getText().equals("")) {	// if validateTotalCoinValue did not throw an error
					outputLabel1.setText(multiCoinCalculator(getTotalCoinIn())); 	// display the result of multiCoinCalculator with no excluded coin
					history = "multiple coin calculator used:\ncoin value exchanged: " + getTotalCoinIn() + "\nresult: " + multiCoinCalculator(getTotalCoinIn()) + "\n\n" + history;	// log the result in history
				}
			} else {	// else we assume the user wishes to exclude a coin
				
				validateExcludedCoin();	// collect, validate and set if valid the users chosen coin denomination or display the appropriate error message
				
				if ((errorLabel2.getText().equals(""))&&(errorLabel3.getText().equals(""))) {	// check if the validations threw any errors
					outputLabel1.setText(multiCoinCalculator(getTotalCoinIn(), getExcludedCoin()));	// if no errors appear, use the multiCoinCalculator method on the validated user choices and display the results
					history = "multiple coin calculator used:\ncoin value exchanged: " + getTotalCoinIn() + "\ncoin excluded from exchange: " + getExcludedCoin() + getSymbol() + "\nresult: " + multiCoinCalculator(getTotalCoinIn(), getExcludedCoin()) + "\n\n" + history;	// log the result in history
				}
			}
		});
	}
	
	/**
	 * provides instructions to be followed as each button is pressed or slider is used on the set details page
	 */
	public void setDetailsLogic() {
		
		setCurrencyButton.setOnAction(e -> {
			
			errorLabel1.setText("");	// reset error label to empty string
			
			if (currencyChoiceBox.getValue() != null) {	// check for user input in the currency dropdown
				setCurrency((String) currencyChoiceBox.getValue());	// collect the users choice and set it to the currency
				outputLabel1.setText("Current currency: " + getCurrency() + "\nCurrent min coin value in: " + getMinCoinIn() + "\nCurrent max coin value in: " + getMaxCoinIn());	// display this change to the user configurations
				history = "Set currency:\ncurrency: " + getCurrency() + "\n\n" + history;	// log the change in history
			} else {
				errorLabel1.setText("A currency must be chosen\nfrom the dropdown menu");	// else, tell the user they have given no input
			}
		});
		
		setMinCoinInButton.setOnAction(e -> {
			
			errorLabel2.setText("");
			
			validateMinCoinIn();	// collect user input, validate that it is an integer within the right bounds and either set minCoinIn variable or display the relevant error
			
			if (errorLabel2.getText().equals("")) {	// if there are no errors
				outputLabel1.setText("Current currency: " + getCurrency() + "\nCurrent min coin value in: " + getMinCoinIn() + "\nCurrent max coin value in: " + getMaxCoinIn());	// display this change to the user configurations
				history = "Set minimum accepted coin value in:\nmin coin value in: " + getMinCoinIn() + "\n\n" + history;	// log the change in history

			}
		});
		
		setMaxCoinInButton.setOnAction(e -> {
			
			errorLabel3.setText("");
			
			validateMaxCoinIn();	// collect user input, validate that it is an integer within the right bounds and either set maxCoinIn variable or display the relevant error
			
			if (errorLabel2.getText().equals("")) {	// if there are no errors
				outputLabel1.setText("Current currency: " + getCurrency() + "\nCurrent min coin value in: " + getMinCoinIn() + "\nCurrent max coin value in: " + getMaxCoinIn());	// display this change to the user configurations
				history = "Set maximum accepted coin value in:\nmax coin value in: " + getMaxCoinIn() + "\n\n" + history;	// log the change in history
			}
		});
		
		setAllConfigsButton.setOnAction(e -> {
			
			boolean change = false;	// used to assess weather the settings have changed
			
			/* reset the error labels text to empty strings and test booleans to false*/
			errorLabel1.setText("");
			errorLabel2.setText("");
			errorLabel3.setText("");
			
			test1 = false;
			test2 = false;
			test3 = false;
			
			/* assess which of the 3 labels the user has indicated they want to change */
			
			if (currencyChoiceBox.getValue() != null) {
				test1 = true;	// if the user has chosen a currency, test1 is set to true
			}
			
			if (!inputTextField1.getText().equals("")) {
				test2 = true;	// if the user has populated the min coin in text field, test2 is set to true
			}
			
			if (!inputTextField2.getText().equals("")) {
				test3 = true;	// if the user has populated the max coin in text field, test3 is set to true
			}
			
			/* temporarily store the current setting for minimum accepted coin value of the coin calculators in case we need to reset them and to assess whether a change has been made */
			int tempMinCoinIn = getMinCoinIn();	// store value of minimum coin accepted in tempMinCoinIn
			int tempMaxCoinIn = getMaxCoinIn();	// store value of maximum coin accepted in tempMaxCoinIn
			String tempCurrency = getCurrency();	// store value of currency in tempCurrency
			
			if (test2 && test3) {	// if the user has given input for both minimum acceptable coin value in and maximum acceptable coin value in
				
				if ((isInt(inputTextField1.getText())) && (isInt(inputTextField2.getText()))) {	// if the user inputs for minimum acceptable coin value in and maximum acceptable coin value in are both valid integers
					
					if (toInt(inputTextField1.getText()) > toInt(inputTextField2.getText())) {	// if the user inputs for minimum acceptable coin value in is greater than the user inputs for maximum acceptable coin value in
						errorLabel1.setText("you cannot set the minimum\naccepted coin value to be\nhigher then the maximum \naccepted coin value"); 	// display an error to the user
					} else {
						
						if (toInt(inputTextField1.getText()) > getMaxCoinIn()) {	// if the user value of minimum acceptable coin value in is greater than current value of maximum acceptable coin value in
							validateMaxCoinIn();	// validate and set maxCoinInValue or display relevant error
							validateMinCoinIn();	// validate and set minCoinInValue or display relevant error
							
						} else {	// to avoid an unwanted error, validation must occur the other way around
							validateMinCoinIn();	// validate and set minCoinInValue or display relevant error
							validateMaxCoinIn();	// validate and set maxCoinInValue or display relevant error
						}
					}
				} else {	// else use our validation methods to show the appropriate error messages
					validateMinCoinIn();
					validateMaxCoinIn();
				}	
			} else if (test2) {	// else the user has only given an input for the minimum acceptable coin value in
				validateMinCoinIn();	// validate and set minCoinInValue or display relevant error

			} else if (test3) {	// else the user has only given an input for the maximum acceptable coin value in
				validateMaxCoinIn();	// validate and set maxCoinInValue or display relevant error

			}
			
			if (errorLabel2.getText().equals("") && errorLabel3.getText().equals("")) {	// if both error labels are empty
				if (test1) {	// if user choice for currency is not null
					setCurrency((String) currencyChoiceBox.getValue());	// collect the users choice and set it to the currency

				}
				outputLabel1.setText("Current currency: " + getCurrency() + "\nCurrent min coin value in: " + getMinCoinIn() + "\nCurrent max coin value in: " + getMaxCoinIn());	// display this change to the user configurations
				
				/* assessing whether a change has been made */
				if ((!getCurrency().equals(tempCurrency)) || (getMinCoinIn() != tempMinCoinIn) || (getMaxCoinIn() != tempMaxCoinIn)) {	// if a change to the configurations has been made by the user
					history = "Set multiple configurations:\ncurrency: " + getCurrency() + "\nmin coin value in: " + getMinCoinIn() + "\nmax coin value in: " + getMaxCoinIn() + "\n\n" + history;	// log the change in history

				}
				
			} else {	// if an error is displayed
				
				setMinCoinIn(tempMinCoinIn);	// reset maxCoinIn value
				setMaxCoinIn(tempMaxCoinIn);	// reset minCoinIn value
				
				outputLabel1.setText("Current currency: " + getCurrency() + "\nCurrent min coin value in: " + getMinCoinIn() + "\nCurrent max coin value in: " + getMaxCoinIn());	// reset output text

			}
		});
		
		/* set logic of the text fields and sliders */

		inputTextField1.setOnKeyReleased(e -> {	// if a character is typed into the minimum accepted coin text field
			if (isInt(inputTextField1.getText())) {	// if the text field holds only a valid integer
				minCoinInSlider.setValue(toInt(inputTextField1.getText()));	// set the slider to that value
			} else {	// if the text field holds something other than an integer
				minCoinInSlider.setValue(0);	// set the slider to 0
			}
		});
		
		minCoinInSlider.setOnMouseDragged(e -> {	// when the slider is dragged
			inputTextField1.setText("" + (int) minCoinInSlider.getValue());	// set the text field to the slider value
		});
			
		minCoinInSlider.setOnKeyReleased(e -> {	// when the keyboard left and right keys are used on the slider
			inputTextField1.setText("" + (int) minCoinInSlider.getValue());	// set the text field to the slider value
		});
		
		minCoinInSlider.setOnMouseClicked(e -> {	// when someone clicks a point on the slider
			inputTextField1.setText("" + (int) minCoinInSlider.getValue());	// set the text field to the slider value
		});

		inputTextField2.setOnKeyReleased(e -> {	// if a character is typed into the maximum accepted coin text field
			if (isInt(inputTextField2.getText())) {	// if the text field holds only a valid integer
				maxCoinInSlider.setValue(toInt(inputTextField2.getText()));	// set the slider to that value
			} else {	// if the text field holds something other than an integer
				maxCoinInSlider.setValue(0);	// set the slider to 0
			}
		});
		
		maxCoinInSlider.setOnMouseDragged(e -> {	// when the slider is dragged
			inputTextField2.setText("" + (int) maxCoinInSlider.getValue());	// set the text field to the slider value
		});
			
		maxCoinInSlider.setOnKeyReleased(e -> {	// when the keyboard left and right keys are used on the slider
			inputTextField2.setText("" + (int) maxCoinInSlider.getValue());	// set the text field to the slider value
		});
		
		maxCoinInSlider.setOnMouseClicked(e -> {	// when someone clicks a point on the slider
			inputTextField2.setText("" + (int) maxCoinInSlider.getValue());	// set the text field to the slider value
		});
	}		
	
	/**
	 * overrides method in super class CoinSorter
	 * differences: 
	 * takes out do while loop
	 * uses getters and setters to access private variables
	 * takes input from a TextField object instead of Scanner object
	 * gives output to a Label object rather than the console
	 * 
	 * method used to take user input as their chosen coin value to exchange
	 * validate that it is a valid integer and that it is between the minimum and maximum allowed values for the coin sorter calculators
	 */
	@Override
	public void validateTotalCoinValue() {
		
		/* set the variables we will use, to be empty Strings or integers that are out of the desired range */
		setAnswerString("");
		setTotalCoinIn(-999);
		setAnswerInt(-999);
		errorLabel2.setText("");
		
		setAnswerString(inputTextField1.getText());	//collect user input for the total coin value
		
		if (isInt(getAnswerString())) {	// check if the input can be cast to an int
			setAnswerInt(toInt(getAnswerString()));	// if answerString can be cast to an int, do so
			
			if (isBetween(getAnswerInt(), getMinCoinIn(), getMaxCoinIn()) == 0) {	// check if answerInt is between the minimum and maximum allowed values
				setTotalCoinIn(getAnswerInt());	// if answerInt is between these values, set totalCoinIn equal to answerInt
			} else if (isBetween(getAnswerInt(), getMinCoinIn(), getMaxCoinIn()) == 1) {	// else if it is greater than the max allowed value display the appropriate error
				errorLabel2.setText("The response you gave was\ngreater than the maximum\nallowed value: " + getMaxCoinIn());
			} else {	// else it must be less than the min allowed value, display the appropriate error
				errorLabel2.setText("The response you gave was\nless than the minimum\nallowed value: " + getMinCoinIn());
			}
		} else {	// if it cannot be cast to an int, we display the appropriate error
			if (getAnswerString().equals("")) {
				errorLabel2.setText("You gave no response");	// user entered no input
			} else {
				errorLabel2.setText("The response you gave either:\nwasn't an integer,\nwas less than -2147483648 or\nwas greater than 2147483647");	// input entered was not a valid integer
			}
		}
	}
	
	/**
	 * overrides method in super class CoinSorter
	 * differences: 
	 * takes out do while loop
	 * uses getters and setters to access private variables
	 * takes input from a TextField object instead of Scanner object
	 * gives output to a Label object rather than the console
	 * 
	 * method used to take user input as their chosen coin value to set as the minimum allowed value for the coin sorter calculators
	 * validate that it is a valid integer and that it is between 0 and the maximum allowed values for the coin sorter calculators
	 */
	@Override
	public void validateMinCoinIn() {
		
		/* set the variables we will use, to be empty Strings or integers that are out of the desired range */
		setAnswerString("");
		setAnswerInt(-999);
		errorLabel2.setText("");
		
		setAnswerString(inputTextField1.getText());	//collect user input for the total coin value
		
		if (isInt(getAnswerString())) {	// check if the input can be cast to an int
			setAnswerInt(toInt(getAnswerString()));	// if answerString can be cast to an int, do so
			
			if (isBetween(getAnswerInt(), 0, getMaxCoinIn()) == 0) {	// check if answerInt is between 0 and maximum allowed values
				setMinCoinIn(getAnswerInt());	// if answerInt is between these values, set minCoinIn equal to answerInt
			} else if (isBetween(getAnswerInt(), 0, getMaxCoinIn()) == 1) {	// else if it is greater than the max allowed value display the appropriate error
				errorLabel2.setText("The response you gave was\ngreater than the maximum\nallowed value: " + getMaxCoinIn());
			} else {	// else it must be less than the min allowed value, display the appropriate error
				errorLabel2.setText("The response you gave was\nless than the minimum\nallowed value: 0");
			}
		} else {	// if it cannot be cast to an int, we display the appropriate error
			if (getAnswerString().equals("")) {
				errorLabel2.setText("You gave no response");	// user entered no input
			} else {
				errorLabel2.setText("The response you gave either:\nwasn't an integer,\nwas less than -2147483648 or\nwas greater than 2147483647");	// input entered was not a valid integer
			}
		}
	}
	
	/**
	 * overrides method in super class CoinSorter
	 * differences: 
	 * takes out do while loop
	 * uses getters and setters to access private variables
	 * takes input from a TextField object instead of Scanner object
	 * gives output to a Label object rather than the console
	 * 
	 * method used to take user input as their chosen coin value to set as the maximum allowed value for the coin sorter calculators
	 * validate that it is a valid integer and that it is between the minimum allowed value for the coin sorter calculators and 2147483648
	 */
	@Override
	public void validateMaxCoinIn() {
		
		/* set the variables we will use, to be empty Strings or integers that are out of the desired range */
		setAnswerString("");
		setAnswerInt(-999);
		errorLabel3.setText("");
		
		setAnswerString(inputTextField2.getText());	//collect user input for the total coin value
		
		if (isInt(getAnswerString())) {	// check if the input can be cast to an int
			setAnswerInt(toInt(getAnswerString()));	// if answerString can be cast to an int, do so
			
			if (isBetween(getAnswerInt(), getMinCoinIn(), 2147483647) == 0) {	// check if answerInt is between 0 and maximum allowed values
				setMaxCoinIn(getAnswerInt());	// if answerInt is between these values, set maxCoinIn equal to answerInt
			} else {	// else it must be less than the min allowed value, display the appropriate error
				errorLabel3.setText("The response you gave was\nless than the minimum\nallowed value: " + getMinCoinIn());
			}
		} else {	// if it cannot be cast to an int, we display the appropriate error
			if (getAnswerString().equals("")) {
				errorLabel3.setText("You gave no response");	// user entered no input
			} else {
				errorLabel3.setText("The response you gave either:\nwasn't an integer,\nwas less than -2147483648 or\nwas greater than 2147483647");	// input entered was not a valid integer
			}
		}
	}
	
	
	/**
	 * overrides method in super class CoinSorter
	 * differences: 
	 * takes out do while loop
	 * uses getters and setters to access private variables
	 * takes input from a TextField object instead of Scanner object
	 * gives output to a Label object rather than the console
	 * 
	 * method used to take user input as their chosen coin denomination and
	 * validates that it is a valid integer and that it is in the coin list
	 */
	@Override
	public void validateExcludedCoin() {
		
		/* set the variables we will use, to be empty Strings or integers that are out of the desired range */
		setAnswerString("");
		setAnswerInt(-999);
		errorLabel3.setText("");
		
		setAnswerString(inputTextField2.getText());	//collect user input for the total coin value
		
		if (isInt(getAnswerString())) {	// check if the input can be cast to an int
			setAnswerInt(toInt(getAnswerString()));	// if answerString can be cast to an int, do so
			
			if (inCoinList(getAnswerInt(), getCoinList())) {	// check if the user input is in the current coin list
				setExcludedCoin(getAnswerInt());	// if user input in coin list, set it as excluded coin
			} else {	// else print appropriate error
				errorLabel3.setText(getAnswerInt() + " is not a valid coin\ndenomination in the curent coin list");
			}
		} else {	// if it cannot be cast to an int, we display the appropriate error
			if (getAnswerString().equals("")) {
				errorLabel3.setText("You gave no response");	// user entered no input
			} else {
				errorLabel3.setText("The response you gave either:\nwasn't an integer,\nwas less than -2147483648 or\nwas greater than 2147483647");	// input entered was not a valid integer
			}
		}
	}		
}