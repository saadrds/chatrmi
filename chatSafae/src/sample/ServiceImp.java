package sample;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImp extends UnicastRemoteObject implements Service {
    public String name;
    public Service client=null;

    public ServiceImp(String n,Controller c)  throws RemoteException {
        this.name=n;
        this.c = c;
    }
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public void setClient(Service c){
        client = c;
    }

    public Service getClient(){
        return client;
    }

    public String send(String s) throws RemoteException{
        System.out.println("safae li ktbat " + s);
        c.insertInList("saad : " + s);
        return s;
    }
    public Controller c;
}
