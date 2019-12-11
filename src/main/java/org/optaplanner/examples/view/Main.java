package org.optaplanner.examples.view;





import org.optaplanner.database.HibernateUtil;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        primaryStage.setTitle("NeoPlexus Roster Beta Version 1.0");
    //    primaryStage.getIcons().add(new Image("/icons/icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

   
       public static void main(String[] args) {     
    	   if (HibernateUtil.setSessionFactory()) {
               launch(args);
               HibernateUtil.getSessionFactory().close();
           } else {
               Platform.runLater(() -> {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("An error has occured!");
                   alert.setHeaderText("Database Connection Error!");
                   alert.setContentText("Please contact the developer");
                   alert.showAndWait();
                   Platform.exit();
               });
           }

       }

   }