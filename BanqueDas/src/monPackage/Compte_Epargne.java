package monPackage;
class CompteEpargne extends Compte {
    private double taux;

    public CompteEpargne(int numeroCompte, double solde, int numeroClient, double taux, String nomDetenteur) {
        super(numeroCompte, solde, numeroClient, nomDetenteur);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }
    
    

    public void augmenterTaux(double pourcentage) {
        taux += (taux * pourcentage) / 100;
        System.out.println("Taux augmenté avec succès. Nouveau taux : " + taux);
    }
}

