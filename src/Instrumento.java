import java.util.Random;

public abstract class Instrumento {
    private static final String[] TIPOS = {
            "Guitarra",
            "Piano",
            "Violin",
            "Flauta",
            "Saxofon",
            "Bateria"
    };

    private final String tipo;

    protected Instrumento(String tipo) {
        this.tipo = tipo;
    }

    public static Instrumento generarAleatorio(Random random) {
        String tipo = TIPOS[random.nextInt(TIPOS.length)];
        switch (tipo) {
            case "Guitarra":
                return new Guitarra();
            case "Piano":
                return new Piano();
            case "Violin":
                return new Violin();
            case "Flauta":
                return new Flauta();
            case "Saxofon":
                return new Saxofon();
            default:
                return new Bateria();
        }
    }

    public abstract String afinar();

    public abstract String tocar();

    public String tocar(String nota) {
        return "toca " + nota + " con " + tipo + ".";
    }

    public boolean requiereSoplar() {
        return false;
    }

    public String soplar() {
        return "sopla para probar el sonido.";
    }

    public String interpretar(String genero) {
        return "interpreta " + genero + " con " + tipo + ".";
    }

    public String getTipo() {
        return tipo;
    }
}

