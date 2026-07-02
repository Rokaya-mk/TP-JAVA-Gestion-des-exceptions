package ma.enset;


import ma.enset.ex1.EntierNaturel;
import ma.enset.ex1.NombreNegatifException;
import ma.enset.ex2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<CompteBancaire> comptes = new ArrayList<>();

        // Ajout de comptes
        CompteCourant cc1 = new CompteCourant("CC001", 1000, "Roka", 500);
        CompteEpargne ce1 = new CompteEpargne("CE001", 2000, "Yassine", 0.03);
        CompteBancaire cb1 = new CompteBancaire("CB001", 300, "Sara");

        comptes.add(cc1);
        comptes.add(ce1);
        comptes.add(cb1);

        System.out.println("Soldes initiaux");
        for (CompteBancaire c : comptes) {
            c.afficherSolde();
        }

        // Dépôt
        cc1.deposer(200);
        System.out.println("\nAprès dépôt de 200 DH sur CC001 :");
        cc1.afficherSolde();

        // Retrait normal
        try {
            cb1.retirer(100);
            System.out.println("\nAprès retrait de 100 DH sur CB001 :");
            cb1.afficherSolde();
        } catch (FondsInsuffisantsException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            cb1.retirer(1000);
        } catch (FondsInsuffisantsException e) {
            System.out.println("\nErreur attendue : " + e.getMessage());
        }

        try {
            cc1.retirer(1400); // solde=1200, découvert=500 -> possible
            System.out.println("\nAprès retrait de 1400 DH sur CC001 (avec découvert) :");
            cc1.afficherSolde();
        } catch (FondsInsuffisantsException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            cc1.retirer(10000);
        } catch (FondsInsuffisantsException e) {
            System.out.println("\nErreur attendue : " + e.getMessage());
        }

        System.out.println();
        ce1.genererInterets();
        ce1.afficherSolde();

        // Transfert réussi
        try {
            ce1.transferer(500, "CB001", comptes);
            System.out.println("\nApres transfert de 500 DH de CE001 vers CB001 :");
            ce1.afficherSolde();
            cb1.afficherSolde();
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Transfert vers un compte inexistant
        try {
            cb1.transferer(50, "CC999", comptes);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.out.println("\nErreur attendue : " + e.getMessage());
        }

        // Suppression d'un compte de la liste
        comptes.remove(cb1);
        System.out.println("\n Comptes restants après suppression");
        for (CompteBancaire c : comptes) {
            c.afficherSolde();
        }}
}