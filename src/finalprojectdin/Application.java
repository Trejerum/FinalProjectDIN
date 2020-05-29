/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectdin;

import finalprojectdin.controllers.CustomerListController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * 
 * @author Diego Corral
 */
public class Application extends javafx.application.Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/CustomerListView.fxml"));
        Parent root = (Parent) loader.load();
        CustomerListController controller = ((CustomerListController) loader.getController());
        controller.setStage(primaryStage);
        controller.initStage(root);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
