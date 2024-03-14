package monPackage;

class CompteCourant extends Compte {
    private double decouvertAutorise;

    public CompteCourant(int numeroCompte, double solde, int numeroClient, double decouvertAutorise, String nomDetenteur) {
        super(numeroCompte, solde, numeroClient, nomDetenteur);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        if (decouvertAutorise >= 0) {
            this.decouvertAutorise = decouvertAutorise;
            System.out.println("Découvert autorisé mis à jour avec succès.");
        } else {
            System.out.println("Le découvert autorisé ne peut pas être négatif.");
        }
    }
    
    
}

