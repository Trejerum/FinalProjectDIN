/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectdin.controllers;

import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Diego Corral
 */
public class CreateCustomerController {
    
    /**
     * Logger for CreateCustomerController class.
     */
    private static final Logger LOGGER = Logger.getLogger("finalprojectdin.controllers.CreateCustomerController");
    
    /**
     * Stage of the controller.
     */
    private Stage stage;
    
    /**
     * Text field for the users first name.
     */
    @FXML
    private TextField textFieldFirstName;
    
    /**
     * Text field for the users last name.
     */
    @FXML
    private TextField textFieldLastName;
    
    /**
     * Text field for the users middle initial.
     */
    @FXML
    private TextField textFieldMiddleInitial;
    
    /**
     * Text field for the users street.
     */
    @FXML
    private TextField textFieldStreet;
    
    /**
     * Text field for the users city.
     */
    @FXML
    private TextField textFieldCity;
    
    /**
     * Text field for the users state.
     */
    @FXML
    private TextField textFieldState;
    
    /**
     * Text field for the users zip.
     */
    @FXML
    private TextField textFieldZip;
    
    /**
     * Text field for the users phone.
     */
    @FXML
    private TextField textFieldPhone;
    
    /**
     * Text field for the users email.
     */
    @FXML
    private TextField textFieldEmail;
    
    /**
     * Error label for the first name.
     */
    @FXML
    private Label labelErrorFirstName;
    
    /**
     * Error label for the last name.
     */
    @FXML
    private Label labelErrorLastName;
    
    /**
     * Error label for the middle initial.
     */
    @FXML
    private Label labelErrorMiddleInitial;
    
    /**
     * Error label for the Street.
     */
    @FXML
    private Label labelErrorStreet;
    
    /**
     * Error label for the city.
     */
    @FXML
    private Label labelErrorCity;
    
    /**
     * Error label for the state.
     */
    @FXML
    private Label labelErrorState;
    
    /**
     * Error label for the zip.
     */
    @FXML
    private Label labelErrorZip;
    
    /**
     * Error label for the phone.
     */
    @FXML
    private Label labelErrorPhone;
    
    /**
     * Error label for the email.
     */
    @FXML
    private Label labelErrorEmail;
    
    /**
     * Button for canceling the customer creation.
     */
    @FXML
    private Button buttonCancel;
    
    /**
     * Button for submiting the form.
     */
    @FXML
    private Button buttonAccept;
    
    /**
     * Method that sets the stage of the controller.
     * @param stage The stage.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
     * This method initializes the stage and shows the window, sets the
     * visibility of the components and assigns the listeners.
     *
     * @param root Root to assign to the scene.
     */
    public void initStage(Parent root) {
        // Create the scene
        Scene scene = new Scene(root);
        
        // Associate the scene to the stage
        stage.setScene(scene);
        
        // Set window properties
        stage.setTitle("Create Customer");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        setErrorLabelsVisibility(false);
        
        // Set event handlers
        buttonAccept.setOnAction(this::handleButtonAcceptAction);
        buttonCancel.setOnAction(this::handleButtonCancelAction);
        
        // Show the window
        stage.show();
    }
    
    /**
     * Handles the action of the accept button.
     * @param event Action event.
     */
    private void handleButtonAcceptAction(ActionEvent event) {
        if(validateFields()) {
            LOGGER.info("aaa");
        }
    }
    
    /**
     * Handles the action of the close button.
     * @param event Action event.
     */
    private void handleButtonCancelAction(ActionEvent event) {
        LOGGER.info("Closing create customer view...");
        stage.hide();
    }
    
    /**
     * Validates the text field of the create customer window.
     * @return true if correct, false if incorrect.
     */
    private boolean validateFields() {
        
        boolean isValid = true;
        
        // Make all the error labels invisible
        setErrorLabelsVisibility(false);
        
        // Validate the first name text field
        if(textFieldFirstName.getText().isEmpty() || 
                textFieldFirstName.getText().length() < 3 ||
                textFieldFirstName.getText().length() > 128) {
            labelErrorFirstName.setVisible(true);
            isValid = false;
        } 
        
        // Validate the last name text field
        if(textFieldLastName.getText().isEmpty() || 
                textFieldLastName.getText().length() < 3 ||
                textFieldLastName.getText().length() > 128) {
            labelErrorLastName.setVisible(true);
            isValid = false;
        } 
        
        // Validate middle initial text field
        if(textFieldMiddleInitial.getText().isEmpty() ||
                textFieldMiddleInitial.getText().length() != 1) {
            labelErrorMiddleInitial.setVisible(true);
            isValid = false;
        } 
        
        // Validate the street text field
        if(textFieldStreet.getText().isEmpty() || 
                textFieldStreet.getText().length() < 3 ||
                textFieldStreet.getText().length() > 128) {
            labelErrorStreet.setVisible(true);
            isValid = false;
        } 
        
        // Validate the city text field
        if(textFieldCity.getText().isEmpty() || 
                textFieldCity.getText().length() < 3 ||
                textFieldCity.getText().length() > 128) {
            labelErrorCity.setVisible(true);
            isValid = false;
        }
        
        // Validate the state text field
        if(textFieldState.getText().isEmpty() || 
                textFieldState.getText().length() < 3 ||
                textFieldState.getText().length() > 128) {
            labelErrorState.setVisible(true);
            isValid = false;
        } 
        
        // Validate the zip text field
        if(textFieldZip.getText().isEmpty() || 
                textFieldZip.getText().length() < 3 ||
                textFieldZip.getText().length() > 128) {
            labelErrorZip.setVisible(true);
            isValid = false;
        } 
        
        // Validate the phone text field
        if(textFieldPhone.getText().isEmpty() || 
                textFieldPhone.getText().length() < 3 ||
                textFieldPhone.getText().length() > 128) {
            labelErrorPhone.setVisible(true);
            isValid = false;
        } 
        
        // Validate the email text field
        if(textFieldEmail.getText().isEmpty() || 
                textFieldEmail.getText().length() < 3 ||
                textFieldEmail.getText().length() > 128) {
            labelErrorEmail.setVisible(true);
            isValid = false;
        }
        
        return isValid;
    }
    
    /**
     * Sets the value of all the error labels.
     * @param value True if visible, false if invisible.
     */
    private void setErrorLabelsVisibility(boolean value) {
        labelErrorFirstName.setVisible(value);
        labelErrorLastName.setVisible(value);
        labelErrorMiddleInitial.setVisible(value);
        labelErrorStreet.setVisible(value);
        labelErrorCity.setVisible(value);
        labelErrorState.setVisible(value);
        labelErrorZip.setVisible(value);
        labelErrorPhone.setVisible(value);
        labelErrorEmail.setVisible(value);
    }
}
