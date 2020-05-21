/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectdin.controllers;

import finalprojectdin.classes.Customer;
import finalprojectdin.clients.CustomerClient;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 * Controller for the CustomerListView.fxml view. Shows the customers created 
 * on the application.
 * @author Diego Corral
 */
public class CustomerListController {
    
    /**
     * Logger for CustomerListController class.
     */
    private static final Logger LOGGER = Logger.getLogger("finalprojectdin.controllers.CustomerListController");
    
    /**
     * Client for the communication with the server.
     */
    private static final CustomerClient CLIENT = new CustomerClient();
    
    /**
     * Stage of the controller.
     */
    private Stage stage;
    
    /**
     * The customers of the application.
     */
    Set<Customer> customers;
    
    /**
     * Button for creating a customer.
     */
    @FXML
    private Button buttonCreateCustomer;
    
    /**
     * Button for refreshing the table data.
     */
    @FXML
    private Button buttonRefresh;
    
    /**
     * Button that closes the application.
     */
    @FXML
    private Button buttonClose;
    
    /**
     * Table that shows all the customers of the application with their data.
     */
    @FXML
    private TableView tableViewCustomer;
    
    /**
     * Table column for the customers id.
     */
    @FXML
    private TableColumn tableColumnId;
    
    /**
     * Table column for the customers first name.
     */
    @FXML
    private TableColumn tableColumnFirstName;
    
    /**
     * Table column for the customers last name.
     */
    @FXML
    private TableColumn tableColumnLastName;
    
    /**
     * Table column for the customers middle initial.
     */
    @FXML
    private TableColumn tableColumnMiddleInitial;
    
    /**
     * Table column for the customers street.
     */
    @FXML
    private TableColumn tableColumnStreet;
    
    /**
     * Table column for the customers city.
     */
    @FXML
    private TableColumn tableColumnCity;
    
    /**
     * Table column for the customers state.
     */
    @FXML
    private TableColumn tableColumnState;
    
    /**
     * Table column for the customers zip.
     */
    @FXML
    private TableColumn tableColumnZip;
    
    /**
     * Table column for the customers phone.
     */
    @FXML
    private TableColumn tableColumnPhone;
    
    /**
     * Table column for the customers email.
     */
    @FXML
    private TableColumn tableColumnEmail;
    
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
        buttonRefresh.setOnAction(this::handleButtonRefreshAction);
        
        // Show the window
        stage.show();
        
        // Load the customers from the server.
        loadCustomerTableData();

    }
    
    /**
     * Loads all the customers from the server.
     */
    private void loadCustomerTableData() {
        
        try {
            ObservableList<Customer> observableShops = FXCollections.observableArrayList();
            
            customers = CLIENT.findAll_XML(new GenericType<Set<Customer>>() {});
            
            LOGGER.info("Customers loaded correctly...");
            
            tableColumnId.setCellValueFactory(new PropertyValueFactory("id"));
            tableColumnFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
            tableColumnLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
            tableColumnMiddleInitial.setCellValueFactory(new PropertyValueFactory("middleInitial"));
            tableColumnStreet.setCellValueFactory(new PropertyValueFactory("street"));
            tableColumnCity.setCellValueFactory(new PropertyValueFactory("city"));
            tableColumnState.setCellValueFactory(new PropertyValueFactory("state"));
            tableColumnZip.setCellValueFactory(new PropertyValueFactory("zip"));
            tableColumnPhone.setCellValueFactory(new PropertyValueFactory("phone"));
            tableColumnEmail.setCellValueFactory(new PropertyValueFactory("email"));
            
            observableShops.addAll(customers);
            tableViewCustomer.setItems(observableShops);
            
        } catch(ClientErrorException ex){
            LOGGER.severe(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not connect with the server."
                    + " Please try again later.", ButtonType.OK);
            alert.showAndWait();
        } catch(Exception ex) {
            LOGGER.severe(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.WARNING, "Could not connect with the server."
                    + " Please try again later.", ButtonType.OK);
            alert.showAndWait();
        }
        
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
            LOGGER.warning(ex.getMessage());
        } catch (Exception ex) {
            LOGGER.warning(ex.getMessage());
        }
    }
    
    /**
     * Reloads the customers from the server.
     * @param event Action event.
     */
    private void handleButtonRefreshAction(ActionEvent event) {
        loadCustomerTableData();
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
