public class Flauta extends Instrumento {
    public Flauta() {
        super("Flauta");
    }

    @Override
    public String afinar() {
        return "se prepara con su Flauta.";
    }

    @Override
    public String tocar() {
        return "toca su Flauta.";
    }

    @Override
    public boolean requiereSoplar() {
        return true;
    }
}

