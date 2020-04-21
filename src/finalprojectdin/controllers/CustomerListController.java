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
import javafx.stage.Stage;

/**
 *
 * @author Diego Corral
 */
public class CustomerListController {
    
    /**
     * Logger for CustomerListController class.
     */
    private static final Logger LOGGER = Logger.getLogger("finalprojectdin.controllers.CustomerListController");
    
    /**
     * Stage of the controller.
     */
    private Stage stage;
    
    /**
     * Button for creating a customer.
     */
    @FXML
    private Button ButtonCreateCustomer;
    
    /**
     * Button that closes the application.
     */
    @FXML
    private Button buttonClose;
    
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

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customer List");
        stage.setResizable(false);
        stage.show();
        
        buttonClose.setOnAction(this::handleButtonCloseAction);
    }
    
    /**
     * Handles the action of the create customer button. Opens 
     * CreateCustomerView for creating a customer.
     * @param event Action event.
     */
    public void handleButtonCreateCustomerAction(ActionEvent event) {
        
    }
    
    /**
     * Handles the close button action. Closes the application.
     * @param event Action event.
     */
    public void handleButtonCloseAction(ActionEvent event) {
        LOGGER.info("Closing application...");
        stage.hide();
    }
}
