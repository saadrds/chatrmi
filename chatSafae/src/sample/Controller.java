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

   public Boolean clicked =false;
   public ServiceImp server;

    public String send() throws RemoteException {

        String message =tf.getText();
        lv.getItems().add("me : " + message);
        tf.setText("");
        clicked = true;
        server.getClient().send(message);
        return message;

    }
    public void start(){
        try{
            server = new ServiceImp("server",this);
            LocateRegistry.createRegistry(2000);
            Naming.rebind("rmi://localhost:2000/message",server);

            System.out.println("[System] Chat Remote Object is ready hh:");
            while(true){
                try{

                    if (server.getClient()!=null){
                        String message = send();
                        Service client =server.getClient();
                        this.insertInList(client.send(message));

                    }
                }catch (Exception e ){
                    e.printStackTrace();}
            }
        }catch(Exception e ){
            e.printStackTrace();}
    }


    public void connect(){
        new Thread(this::start).start();
}
    public void insertInList(String line){
        lv.getItems().add(line);
    }

}
