//package monPackage;
//
//import java.util.ArrayList;
//
//
//public class portefeuilleCompteEpargne {
//	
//	    private ArrayList<Compte_Epargne> comptes;
//	    private int nbr;
//
//	    public portefeuilleCompteEpargne() {
//	        comptes = new ArrayList<Compte_Epargne>();
//	        nbr = 0;
//	    }
//
//	    public void ajouterComptesEpargne(int nombreComptes) {
//	        for (int i = 0; i < nombreComptes; i++) {
//	            try {
//	            	Compte_Epargne compte = new Compte_Epargne();
//	                comptes.add(compte);
//	                nbr++;
//	            } catch (Exception e) {
//	                System.out.println("Erreur lors de la création du compte.");
//	            }
//	        }
//	    }
//
//	    public void afficherComptesEpargne() {
//	        for (Compte_Epargne compte : comptes) {
//	            compte.afficherInfos();
//	        }
//	    }
//
//	 
//
//	    public void rechercherEtAfficherSoldeEpargne(int numeroCompte) {
//	        for (Compte_Epargne compte : comptes) {
//	            if (compte.getNumeroCompte() == numeroCompte) {
//	                System.out.println("Solde du compte " + numeroCompte + " : " + compte.consulterSolde() + "€");
//	                return;
//	            }
//	        }
//	        System.out.println("Compte non trouvé.");
//	    }
//
//	  
//	    public void ajouterCompteEpargne(Compte_Epargne compte) {
//	        comptes.add(compte);
//	        nbr++;
//	    }
//
//	   
//
//	    public void supprimerCompteEpargne(int numeroCompte) {
//	        for (Compte_Epargne compte : comptes) {
//	            if (compte.getNumeroCompte() == numeroCompte) {
//	                comptes.remove(compte);
//	                nbr--;
//	                System.out.println("Compte " + numeroCompte + " supprimé.");
//	                return;
//	            }
//	        }
//	        System.out.println("Compte non trouvé.");
//	    }
//
//	    public void viderCollection() {
//	        comptes.clear();
//	        nbr = 0;
//	        System.out.println("La collection a été vidée.");
//	    }
//	    
//	    
//	    
//	   
//	        
//		
//		
//	}
//
//
