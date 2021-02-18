package serv;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;
public class DynamicServer {

public static void main(String[] args) {


try { 
       if(System.getSecurityManager() == null) 
	        System.setSecurityManager(new RMISecurityManager());

      
       
       //Registry registry = LocateRegistry.getRegistry(1099); 
       Registry registry = LocateRegistry.createRegistry(5002);
    //   if(registry==null)
    	//   registry=LocateRegistry.createRegistry(5002);
      

       System.out.println( "Serveur : Construction de l'implementation");
      // FabCalculProduitMat fab=new FabCalculProduitMat();
       System.out.println("Objet Fabrique lie dans le RMIregistry");
       Properties p= System.getProperties();
       String url=p.getProperty("java.rmi.server.codebase");
       Class ClasseServeur = RMIClassLoader.loadClass(url,"serv.FabCalculProduitMat");

       registry.rebind("Fabrique",(Remote)ClasseServeur.newInstance());
       System.out.println ("Serveur prêt.") ;
       System.out.println("Attente des invocations des clients ...");
    }
catch (Exception e) {
	             System.out.println("Erreur de liaison de l'objet Fabrique");
                     System.out.println(e.toString());
                     }
} 
}  

