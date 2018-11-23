package com.seedsir.tp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seedsir.tp.beans.Client;

public class CreationClient extends HttpServlet{
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String mail = request.getParameter("mailClient");
		
		String message;
		
		if(nom.trim().isEmpty()||adresse.trim().isEmpty() || telephone.trim().isEmpty()) {
			message="Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br>"
					+ "<a href= \"creerClient.jsp\"> Cliquez ici</a> pour accéder au formulaire de création d'un client.";
		}
		else {
			message ="Client créé avec succès";
		}
		/*
         * Création du bean Client et initialisation avec les données récupérées
         */
		Client client =new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setTelephone(telephone);
		client.setMail(mail);
		
		/* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "client", client );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
		         
	}
	
		
}
