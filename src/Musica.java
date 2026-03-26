import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Musica {
    public static final String[] GENEROS = {
            "Rock",
            "Pop",
            "Salsa",
            "Jazz",
            "Reggae",
            "Balada"
    };

    private final List<Instrumento> instrumentos;
    private String genero;
    private int tiempoMinutos;

    public Musica() {
        this.instrumentos = new ArrayList<>();
        this.genero = "Sin definir";
        this.tiempoMinutos = 0;
    }

    public void generar(String tipoEvento, Random random) {
        this.genero = GENEROS[random.nextInt(GENEROS.length)];

        switch (tipoEvento) {
            case "Boda":
                this.tiempoMinutos = 90 + random.nextInt(31); // 90-120
                break;
            case "Concierto privado":
                this.tiempoMinutos = 60 + random.nextInt(31); // 60-90
                break;
            default:
                this.tiempoMinutos = 30 + random.nextInt(46); // 30-75
                break;
        }
    }

    public void agregarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }

    public String genero() {
        return genero;
    }

    public int tiempo() {
        return tiempoMinutos;
    }

    public List<Instrumento> getInstrumentos() {
        return Collections.unmodifiableList(instrumentos);
    }
}

