public class Violin extends Instrumento {
    public Violin() {
        super("Violin");
    }

    @Override
    public String afinar() {
        return "afina su Violin.";
    }

    @Override
    public String tocar() {
        return "toca su Violin.";
    }
}

