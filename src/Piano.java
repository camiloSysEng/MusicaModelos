public class Piano extends Instrumento {
    public Piano() {
        super("Piano");
    }

    @Override
    public String afinar() {
        return "se prepara con su Piano.";
    }

    @Override
    public String tocar() {
        return "toca su Piano.";
    }
}

