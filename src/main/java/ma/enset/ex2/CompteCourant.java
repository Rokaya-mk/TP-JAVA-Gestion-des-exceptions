package ma.enset.ex2;

public class CompteCourant extends CompteBancaire {

    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double solde, String nomTitulaire, double decouvertAutorise) {
        super(numeroCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde + decouvertAutorise) {
            throw new FondsInsuffisantsException(
                    " dépassé sur le compte courant " + numeroCompte +
                            " (solde=" + solde + ", découvert autorisé=" + decouvertAutorise + ")");
        }
        solde -= montant;
    }
}
