package ma.enset.ex1;

public class EntierNaturel {

    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("Valeur négative interdi à la construction", val);
        }
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("Valeur négative interdi lors de l'affectation", val);
        }
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException {
        if (val - 1 < 0) {
            throw new NombreNegatifException("Décrémentation impossible : résultat négatif", val - 1);
        }
        val = val - 1;
    }

    @Override
    public String toString() {
        return "val=" + val ;
    }
}