package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root =loader.load();
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toString());
        primaryStage.setTitle("Chat Application Safae");
        primaryStage.setScene(scene);
        primaryStage.show();
        Controller c = loader.getController();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
