package ma.enset;


import ma.enset.ex1.EntierNaturel;
import ma.enset.ex1.NombreNegatifException;

public class Main {
    public static void main(String[] args) {

        try {
            EntierNaturel e1 = new EntierNaturel(5);
            System.out.println("e1 créé : " + e1);

            e1.decrementer();
            System.out.println("Après décrémentation : " + e1);

            e1.setVal(10);
            System.out.println("Après setVal(10) : " + e1);

            e1.setVal(-3);

        } catch (NombreNegatifException ex) {
            System.out.println("Erreur : " + ex.getMessage());
            System.out.println("Valeur erronée capturée : " + ex.getValeurErronee());
        }

        try {
            EntierNaturel e2 = new EntierNaturel(1);
            e2.decrementer();
            System.out.println("e2 après 1ère décrémentation : " + e2);
            e2.decrementer();
        } catch (NombreNegatifException ex) {
            System.out.println("Erreur : " + ex.getMessage());
            System.out.println("Valeur erronée capturée : " + ex.getValeurErronee());
        }

        try {
            EntierNaturel e3 = new EntierNaturel(-7);
        } catch (NombreNegatifException ex) {
            System.out.println("Erreur : " + ex.getMessage());
            System.out.println("Valeur erronée capturée : " + ex.getValeurErronee());
        }
    }
}