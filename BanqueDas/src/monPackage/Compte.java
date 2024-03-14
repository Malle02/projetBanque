package monPackage;

import java.util.Scanner;



class Compte {
    protected int numeroCompte;
    protected double solde;
    protected int numeroClient;
    protected String nomDetenteur;

    public Compte(int numeroCompte, double solde, int numeroClient, String nomDetenteur) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.numeroClient = numeroClient;
        
        this.nomDetenteur = nomDetenteur;
    }
    
    
    public static void main(String[] args) {
        PortefeuilleClients portefeuille = new PortefeuilleClients();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\nMenu Principal:");
            System.out.println("A. Ajouter un nouveau compte");
            System.out.println("B. Afficher le menu principal");
            System.out.println("C. Quitter");

            System.out.print("Choisissez une option (A, B, C, D) : ");
            char choix = scanner.next().toUpperCase().charAt(0);

            switch (choix) {
                

                case 'A':
                    ajouterNouveauCompte(portefeuille);
                    break;

                case 'B':
                    portefeuille.afficherMenu();
                    break;

                case 'C':
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }


    private static void ajouterNouveauCompte(PortefeuilleClients portefeuille) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro du compte : ");
        int numeroCompte = scanner.nextInt();
        
        System.out.print("Entrez le nom du deteneteur de compte : ");
        String nomDetenteur = scanner.next();

        System.out.print("Entrez le solde initial du compte : ");
        double soldeInitial = scanner.nextDouble();

        System.out.print("Entrez le numéro du client : ");
        int numeroClient = scanner.nextInt();

        System.out.print("Choisissez le type de compte (C pour Compte Courant, E pour Compte Epargne) : ");
        char typeCompte = scanner.next().toUpperCase().charAt(0);

        if (typeCompte == 'C') {
            System.out.print("Entrez le découvert autorisé pour le compte Courant : ");
            double decouvertAutorise = scanner.nextDouble();
            CompteCourant compteCourant = new CompteCourant(numeroCompte, soldeInitial, numeroClient, decouvertAutorise, nomDetenteur);
            portefeuille.ajouterCompte(compteCourant);
            System.out.println("Compte Courant ajouté avec succès.");
        } else if (typeCompte == 'E') {
            System.out.print("Entrez le taux de rémunération pour le compte Epargne : ");
            double taux = scanner.nextDouble();
            CompteEpargne compteEpargne = new CompteEpargne(numeroCompte, soldeInitial, numeroClient, taux, nomDetenteur);
            portefeuille.ajouterCompte(compteEpargne);
            System.out.println("Compte Epargne ajouté avec succès.");
        } else {
            System.out.println("Type de compte non valide.");
        }
    }



    public int getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public int getNumeroClient() {
        return numeroClient;
    }
    
    public String getnomDetenteur() {
        return nomDetenteur;
    }

    public void consulterSolde() {
        System.out.println("le compte de " + nomDetenteur + "le numero de compte " + numeroCompte + " et le solde du compte est : " + solde);
    }

    public void faireRetrait(double montant) {
        if (solde - montant >= 0 ) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué avec succès. Nouveau solde : " + solde);
        } else {
            System.out.println("Fonds insuffisants pour effectuer le retrait.");
        }
    }

    public void faireDepot(double montant) {
        solde += montant;
        System.out.println("Dépôt de " + montant + " effectué avec succès. Nouveau solde : " + solde);
    }
}






























//
//import java.util.Scanner;
//
//public class Compte {
//  protected String titulaire;
//  protected int numeroCompte;
//  protected double solde;
//  protected double decouvertAutorise;
//  
//  
//  
//  
//  public String getTitulaire() {
//		return titulaire;
//	}
//	
//	public int getnumeroCompte() {
//		return numeroCompte;
//	}
//	
//	public double getSolde() {
//		return solde;
//	}
//	public double getdecouvertAutorise() {
//		return decouvertAutorise;
//	}
//	
//  
//  public static void main(String[] args) {
//      PortefeuilleClients portefeuille = new PortefeuilleClients();
//      portefeuilleCompteEpargne PortefeuilleEpargne = new portefeuilleCompteEpargne();
//      Scanner scanner = new Scanner(System.in);
//      char choix;
//      boolean continuer = true;
//
//      do {
//          System.out.println("\nMenu Principal:");
//          System.out.println("A. Afficher tous les comptes");
//          System.out.println("B. Ajouter un compte");
//          System.out.println("C. Rechercher et afficher le solde d'un compte");
//          System.out.println("D. Afficher les comptes avec solde négatif");
//          System.out.println("E. Modifier le découvert autorisé d'un compte");
//          System.out.println("F. Supprimer un compte");
//          System.out.println("G. Vider la collection");
//          System.out.println("I. Pour le menu des comptes Epargne");
//          System.out.println("H. Quitter");
//
//          System.out.print("Choisissez une option (A, B, C, ..., H) : ");
//          choix = scanner.next().toUpperCase().charAt(0);
//
//          switch (choix) {
//              case 'A':
//                  System.out.println("Tous les comptes en banque :");
//                  portefeuille.afficherComptes();
//                  break;
//
//              case 'B':
//                  int nombreComptes = Saisie.lire_int("Entrez le nombre de comptes à ajouter : ");
//                  portefeuille.ajouterComptes(nombreComptes);
//                  break;
//
//              case 'C':
//                  int numeroCompte = Saisie.lire_int("Entrez le numéro de compte pour rechercher le solde : ");
//                  portefeuille.rechercherEtAfficherSolde(numeroCompte);
//                  break;
//
//              case 'D':
//                  System.out.println("Comptes avec solde négatif :");
//                  portefeuille.afficherComptesSoldeNegatif();
//                  break;
//
//              case 'E':
//                  int numeroModif = Saisie.lire_int("Entrez le numéro de compte à modifier : ");
//                  double nouveauDecouvert = Saisie.lire_double("Entrez le nouveau découvert autorisé : ");
//                  portefeuille.modifierDecouvert(numeroModif, nouveauDecouvert);
//                  break;
//
//              case 'F':
//                  int numeroSuppr = Saisie.lire_int("Entrez le numéro de compte à supprimer : ");
//                  portefeuille.supprimerCompte(numeroSuppr);
//                  break;
//
//              case 'G':
//                  portefeuille.viderCollection();
//                  break;
//
//              case 'H':
//              	 continuer = false;
//                  System.out.println("Au revoir !");
//               
//                  break;
//              case 'I':
//                  char sousMenuChoix;
//                  boolean sousMenuContinuer = true;
//
//                  do {
//                  	System.out.println("\nSous Menu pour les comptes epargne ");
//                      System.out.println("A. Afficher tous les comptes Epargne");
//                      System.out.println("B. Ajouter un compte Epargne");
//                      System.out.println("C. Rechercher et afficher le solde d'un compte Epargne");
//
//                      System.out.println("D. Supprimer un compte");
//                      System.out.println("E. Vider la collection");
//
//                      System.out.println("F. Quitter");
//
//                      System.out.print("Choisissez une option (A, B, C, D) : ");
//                      sousMenuChoix = scanner.next().toUpperCase().charAt(0);
//
//                      switch (sousMenuChoix) {
//                      case 'A':
//                          System.out.println("Tous les comptes en Epargne :");
//                          PortefeuilleEpargne.afficherComptesEpargne();
//                          break;
//
//                      case 'B':
//                          int nombreComptesEpargne = Saisie.lire_int("Entrez le nombre de comptes à ajouter : ");
//                          PortefeuilleEpargne.ajouterComptesEpargne(nombreComptesEpargne);
//                          break;
//
//                      case 'C':
//                          int numeroCompteEpargne = Saisie.lire_int("Entrez le numéro de compte pour rechercher le solde : ");
//                          PortefeuilleEpargne.rechercherEtAfficherSoldeEpargne(numeroCompteEpargne);
//                          break;
//
//                      case 'D':
//                      	int numeroSupprimmer = Saisie.lire_int("Entrez le numéro de compte à supprimer : ");
//                      	PortefeuilleEpargne.supprimerCompteEpargne(numeroSupprimmer);
//                          break;
//
//                      case 'E':
//                      	PortefeuilleEpargne.viderCollection();
//                            break;
//                            
//                      case 'F':
//                     	 continuer = false;
//                         System.out.println("Au revoir !");
//                      
//                         break;
//
//                          default:
//                              System.out.println("Option invalide. Veuillez choisir une option valide.");
//                      }
//
//                      // Demander à l'utilisateur s'il veut continuer dans le sous-menu
//                      if (sousMenuContinuer) {
//                          System.out.print("Voulez-vous revenir au sous-menu Comptes Épargne ? (O/N) : ");
//                          char reponseSousMenu = scanner.next().toUpperCase().charAt(0);
//                          sousMenuContinuer = (reponseSousMenu == 'O');
//                      }
//
//                  } while (sousMenuContinuer);
//
//                  break;
//
//              default:
//                  System.out.println("Option invalide. Veuillez choisir une option valide.");
//          }
//          
//          // Demander à l'utilisateur s'il veut continuer
//          if (continuer) {
//              System.out.print("Voulez-vous revenir au menu principal ? (O/N) : ");
//              char reponse = scanner.next().toUpperCase().charAt(0);
//              continuer = (reponse == 'O');
//          }
//          if (!continuer) {
//              System.out.println("Au revoir et merci pour votre visite !");
//          }
//
//      } while (continuer);
//      
//  }
//  
//  
//  
//  
//
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  	
//  public Compte() {
//      Scanner scanner = new Scanner(System.in);
//      try {
//          System.out.print(" Saisissez le Nom du titulaire : ");
//          this.titulaire = scanner.nextLine();
//
//          System.out.print(" Saisissez le Numéro de compte : ");
//          this.numeroCompte = scanner.nextInt();
//
//          System.out.print(" Saisissez le Solde initial : ");
//          this.solde = scanner.nextDouble();
//
//          System.out.print("Saisissez le Montant du Découvert autorisé : ");
//          this.decouvertAutorise = scanner.nextDouble();
//      } catch (Exception e) {
//          System.out.println("Erreur lors de la saisie. Veuillez entrer des données valides.");
//          scanner.nextLine(); 
//          }
//  }
//
//  public double consulterSolde() {
//      return solde;
//  }
//
//
//
//  public void afficherInfos() {
//      System.out.println("Titulaire : " + titulaire);
//      System.out.println("Numéro de compte : " + numeroCompte);
//      System.out.println("Solde : " + solde + "€");
//      System.out.println("Découvert autorisé : " + decouvertAutorise + "€");
//  }
//
//  public int getNumeroCompte() {
//      return numeroCompte;
//  }
//
//  public void setDecouvertAutorise(double decouvertAutorise) {
//      if (decouvertAutorise < 0) {
//          throw new IllegalArgumentException("Le découvert autorisé ne peut pas être négatif.");
//      }
//      this.decouvertAutorise = decouvertAutorise;
//  }
//}



