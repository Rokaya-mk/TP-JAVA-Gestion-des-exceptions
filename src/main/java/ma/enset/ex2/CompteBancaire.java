package ma.enset.ex2;


public class CompteBancaire {

    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    public CompteBancaire(String numeroCompte, double solde, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException(
                    "Fonds insuffisants sur le compte " + numeroCompte +
                            " (solde=" + solde + ", retrait demandé=" + montant + ")");
        }
        solde -= montant;
    }

    public void afficherSolde() {
        System.out.println("Compte " + numeroCompte + " (" + nomTitulaire + ") - Solde : " + solde + " DH");
    }

    public void transferer(double montant, String numeroCompteDestination, java.util.List<CompteBancaire> comptes)
            throws FondsInsuffisantsException, CompteInexistantException {

        CompteBancaire destinataire = null;
        for (CompteBancaire c : comptes) {
            if (c.getNumeroCompte().equals(numeroCompteDestination)) {
                destinataire = c;
                break;
            }
        }

        if (destinataire == null) {
            throw new CompteInexistantException("Le compte " + numeroCompteDestination + " n'existe pas.");
        }

        this.retirer(montant);       // peut lancer FondsInsuffisantsException
        destinataire.deposer(montant);
    }
}