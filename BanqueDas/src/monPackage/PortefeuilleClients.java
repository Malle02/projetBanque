package monPackage;

 import java.util.ArrayList;
 import java.util.Scanner;


class PortefeuilleClients {
    private ArrayList<Compte> comptes;
   

    public PortefeuilleClients() {
        comptes = new ArrayList<>();
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\nMenu Principal:");
            System.out.println("A. Afficher la liste des comptes en découvert");
            System.out.println("B. Augmenter le taux de rémunération des comptes Epargne");
            System.out.println("C. Afficher la liste des clients avec un compte Courant et un compte Epargne");
            System.out.println("D. Travailler sur un compte");
            System.out.println("E. Quitter");

            System.out.print("Choisissez une option (A, B, C, D, E) : ");
            char choix = scanner.next().toUpperCase().charAt(0);

            switch (choix) {
                case 'A':
                    afficherComptesDecouvert();
                    break;

                case 'B':
                    augmenterTauxEpargne();
                    break;

                case 'C':
                    afficherClientsAvecDeuxComptes();
                    break;

                case 'D':
                    travaillerSurCompte();
                    break;

                case 'E':
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private void afficherComptesDecouvert() {
        System.out.println("Liste des comptes en découvert :");
        for (Compte compte : comptes) {
            if (compte.getSolde() < 0) {
                compte.consulterSolde();
            }
        }
    }

    private void augmenterTauxEpargne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le pourcentage d'augmentation du taux : ");
        double pourcentage = scanner.nextDouble();

        for (Compte compte : comptes) {
            if (compte instanceof CompteEpargne) {
                CompteEpargne compteEpargne = (CompteEpargne) compte;
                compteEpargne.augmenterTaux(pourcentage);
            }
        }
    }

    private void afficherClientsAvecDeuxComptes() {
        System.out.println("Liste des clients avec un compte Courant et un compte Epargne :");
        for (Compte compteCourant : comptes) {
            if (compteCourant instanceof CompteCourant) {
                int numeroClient = compteCourant.getNumeroClient();
                String nomDetenteurCourant = ((Compte) compteCourant).getnomDetenteur(); 
                boolean aCompteEpargne = false;

                for (Compte compte : comptes) {
                    if (compte instanceof CompteEpargne && compte.getNumeroClient() == numeroClient) {
                        aCompteEpargne = true;
                        break;
                    }
                }

                if (aCompteEpargne) {
                    System.out.println("Le Client " + nomDetenteurCourant + " avec le numéro : " + numeroClient);
                }
            }
        }
    }


    private void travaillerSurCompte() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro du compte : ");
        int numeroCompte = scanner.nextInt();

        Compte compte = trouverCompteParNumero(numeroCompte);

        if (compte != null) {
            travaillerSurUnCompte(compte);
        } else {
            System.out.println("Compte non trouvé.");
        }
    }

    private Compte trouverCompteParNumero(int numeroCompte) {
        for (Compte compte : comptes) {
            if (compte.getNumeroCompte() == numeroCompte) {
                return compte;
            }
        }
        return null;
    }

    private void travaillerSurUnCompte(Compte compte) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\nMenu Compte:");
            System.out.println("A. Consulter le solde");
            System.out.println("B. Faire un retrait");
            System.out.println("C. Faire un dépôt");
            System.out.println("D. Afficher et éventuellement modifier le découvert autorisé");
            System.out.println("E. Supprimer le compte");
            System.out.println("F. Revenir au menu principal");

            System.out.print("Choisissez une option (A, B, C, D, E, F) : ");
            char choix = scanner.next().toUpperCase().charAt(0);

            switch (choix) {
                case 'A':
                    compte.consulterSolde();
                    break;

                case 'B':
                    System.out.print("Entrez le montant du retrait : ");
                    double montantRetrait = scanner.nextDouble();
                    compte.faireRetrait(montantRetrait);
                    break;

                case 'C':
                    System.out.print("Entrez le montant du dépôt : ");
                    double montantDepot = scanner.nextDouble();
                    compte.faireDepot(montantDepot);
                    break;

                case 'D':
                    if (compte instanceof CompteCourant) {
                        System.out.println("Le découvert autorisé actuel est : " + ((CompteCourant) compte).getDecouvertAutorise());
                        System.out.print("Voulez-vous modifier le découvert autorisé ? (O/N) : ");
                        char reponse = scanner.next().toUpperCase().charAt(0);
                        if (reponse == 'O') {
                            System.out.print("Entrez le nouveau montant du découvert autorisé : ");
                            double nouveauDecouvert = scanner.nextDouble();
                            ((CompteCourant) compte).setDecouvertAutorise(nouveauDecouvert);
                        }
                    } else {
                        System.out.println("Cette opération n'est pas disponible pour le compte Epargne.");
                    }
                    break;

                case 'E':
                    supprimerCompte(compte);
                    continuer = false;
                    break;

                case 'F':
                    continuer = false;
                    break;

                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private void supprimerCompte(Compte compte) {
        comptes.remove(compte);
        System.out.println("Compte supprimé avec succès.");
    }
   }