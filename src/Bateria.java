public class Bateria extends Instrumento {
    public Bateria() {
        super("Bateria");
    }

    @Override
    public String afinar() {
        return "se prepara con su Bateria.";
    }

    @Override
    public String tocar() {
        return "toca su Bateria.";
    }
}

