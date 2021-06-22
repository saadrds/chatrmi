package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Controller {
   @FXML
   private TextField tf;
   @FXML
    private ListView<String> lv;

       public String send(){
            try{
           String message =tf.getText();
           lv.getItems().add("me : " + message);
           tf.setText("");
           Service client = new ServiceImp("client",this);
           Service server = (Service) Naming.lookup("rmi://localhost:2000/message");
           server.send(message);
           System.out.println("[System] Chat Remote Object is ready:");
           server.setClient(client);

           //client.send(message);
           return message;}
            catch (Exception e){
                return e.toString();
            }



       }
   public void insertInList(String line){
       lv.getItems().add(line);
   }
}
