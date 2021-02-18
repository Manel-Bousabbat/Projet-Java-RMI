package serv;

import java.rmi.*;
import java.rmi.server.*;

public class FabCalculProduitMat extends UnicastRemoteObject implements FabProduitMatInterface{
    
   
   public FabCalculProduitMat()throws RemoteException {}; 
    public ProduitMatInterface newProduitMat() throws RemoteException {       
   return new ProduitMat();}
}

