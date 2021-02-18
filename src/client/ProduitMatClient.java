package client;

import java.lang.System;

import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;

import serv.FabProduitMatInterface;
import serv.ProduitMatInterface;

public class ProduitMatClient {
	public ProduitMatClient() {
		try {
			// taille des matrices à multiplier

			System.out.print("saisir la taille des matrices: n=");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int A[][] = new int[n][n];
			int B[][] = new int[n][n];
			int R1[][] = new int[n][n];
			int R2[][] = new int[n][n];
			int R3[][] = new int[n][n];
			int R4[][] = new int[n][n];

			// remplissage de matrice A
			System.out.println("Saisir de la première matrice");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("A[" + (i) + "," + (j) + "]=");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					A[i][j] = Integer.parseInt(br1.readLine());
				}

			}

			// remplissage de matrice B
			System.out.println("Saisir de la deuxième matrice");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print("B[" + (i) + "," + (j) + "]=");
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					B[i][j] = Integer.parseInt(br2.readLine());

				}

			}
			// fin bloc
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			Registry reg = LocateRegistry.getRegistry("localhost", 5002);
			FabProduitMatInterface fabrique = (FabProduitMatInterface) reg.lookup("Fabrique");

			// creation des 4 objets

			ProduitMatInterface ProduitMatObj1;
			ProduitMatObj1 = (ProduitMatInterface) fabrique.newProduitMat();

			ProduitMatInterface ProduitMatObj2;
			ProduitMatObj2 = (ProduitMatInterface) fabrique.newProduitMat();

			ProduitMatInterface ProduitMatObj3;
			ProduitMatObj3 = (ProduitMatInterface) fabrique.newProduitMat();

			ProduitMatInterface ProduitMatObj4;
			ProduitMatObj4 = (ProduitMatInterface) fabrique.newProduitMat();

//Recuperation resultats des 4 objets:
			R1 = ProduitMatObj1.CalculProduitMat(n, A, B, 0, n / 2, 0, n / 2);
			R2 = ProduitMatObj2.CalculProduitMat(n, A, B, 0, n / 2, n / 2, n);
			R3 = ProduitMatObj3.CalculProduitMat(n, A, B, n / 2, n, 0, n / 2);
			R4 = ProduitMatObj4.CalculProduitMat(n, A, B, n / 2, n, n / 2, n);

			// Recuperation de Resultat final
			int[][] C = new int[n][n];
			for (int i = 0; i < R1.length; i++) {
				for (int j = 0; j < R1[0].length; j++) {
					C[i][j] = R1[i][j];
				}
			}
			for (int i = 0; i < R2.length; i++) {
				for (int j = 0; j < R2[0].length; j++) {
					C[i][R2.length + j] = R2[i][j];
				}
			}
			for (int i = 0; i < R3.length; i++) {
				for (int j = 0; j < R3[0].length; j++) {
					C[R3.length + i][j] = R3[i][j];
				}
			}
			for (int i = 0; i < R4.length; i++) {
				for (int j = 0; j < R4[0].length; j++) {
					C[R4.length + i][R4[0].length + j] = R4[i][j];
				}
			}

			System.out.println("Le Resultat de produit Matriciel de A est B =");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(C[i][j] + " ");

				}
				System.out.println("\n");
			}

		}

		catch (Exception e) {
			System.out.println("Erreur d'acces a l'objet distant.");
			System.out.println(e.toString());
		}
	}
}
