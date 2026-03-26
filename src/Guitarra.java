public class Guitarra extends Instrumento {
    public Guitarra() {
        super("Guitarra");
    }

    @Override
    public String afinar() {
        return "afina su Guitarra.";
    }

    @Override
    public String tocar() {
        return "toca su Guitarra.";
    }
}

