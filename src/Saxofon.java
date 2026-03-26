public class Saxofon extends Instrumento {
    public Saxofon() {
        super("Saxofon");
    }

    @Override
    public String afinar() {
        return "afina su Saxofon.";
    }

    @Override
    public String tocar() {
        return "toca su Saxofon.";
    }

    @Override
    public boolean requiereSoplar() {
        return true;
    }
}

