/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectdin.controllers;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private Button buttonCreateCustomer;
    
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

        // Create the scene
        Scene scene = new Scene(root);
        
        // Associate the scene to the stage
        stage.setScene(scene);
        
        // Set the window properties
        stage.setTitle("Customer List");
        stage.setResizable(false);
        
        // Set event handlers
        buttonClose.setOnAction(this::handleButtonCloseAction);
        buttonCreateCustomer.setOnAction(this::handleButtonCreateCustomerAction);
        
        // Show the window
        stage.show();
    }
    
    private void loadCustomerTableData() {
        
        
        LOGGER.info("Customers loaded correctly...");
    }
    
    /**
     * Handles the action of the create customer button. Opens 
     * CreateCustomerView for creating a customer.
     * @param event Action event.
     */
    private void handleButtonCreateCustomerAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/finalprojectdin/views/CreateCustomerView.fxml"));
            Parent root = (Parent) loader.load();
            CreateCustomerController controller = ((CreateCustomerController) loader.getController());
            controller.setStage(new Stage());
            controller.initStage(root);
        } catch (IOException ex) {
            LOGGER.warning("There was an error trying to open SignUpView. " + ex.getMessage());
        }
    }
    
    /**
     * Handles the close button action. Closes the application.
     * @param event Action event.
     */
    private void handleButtonCloseAction(ActionEvent event) {
        LOGGER.info("Closing customer list view...");
        stage.hide();
    }
}
