import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Evento {
    private static final String[] TIPOS_EVENTO = {
            "Cumpleaños",
            "Boda",
            "Concierto privado",
            "Fiesta de graduacion",
            "Reunion familiar"
    };

    private final String tipoFiesta;
    private final int invitados;

    public Evento(String tipoFiesta, int invitados) {
        this.tipoFiesta = tipoFiesta;
        this.invitados = invitados;
    }

    public static Evento generar(Random random, int maxInvitados) {
        String tipo = TIPOS_EVENTO[random.nextInt(TIPOS_EVENTO.length)];
        int cantidad = 1 + random.nextInt(maxInvitados);
        return new Evento(tipo, cantidad);
    }

    public List<Amigos> organizar(List<Amigos> grupo, Random random) {
        List<Amigos> copia = new ArrayList<>(grupo);
        Collections.shuffle(copia, random);
        return new ArrayList<>(copia.subList(0, invitados));
    }

    public String getTipoFiesta() {
        return tipoFiesta;
    }

    public int getInvitados() {
        return invitados;
    }
}

