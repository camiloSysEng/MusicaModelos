import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_AMIGOS = 8;
        Random random = new Random();

        List<Amigos> grupo = crearGrupoFijo(TOTAL_AMIGOS, random);
        Evento evento = Evento.generar(random, TOTAL_AMIGOS);

        List<Amigos> asistentes = evento.organizar(grupo, random);
        Musica musica = new Musica();
        musica.generar(evento.getTipoFiesta(), random);

        for (Amigos amigo : asistentes) {
            Instrumento instrumento = Instrumento.generarAleatorio(random);
            amigo.asignarInstrumento(instrumento);
            musica.agregarInstrumento(instrumento);
        }

        imprimirResumen(evento, grupo, asistentes, musica);

        for (Amigos amigo : asistentes) {
            System.out.println("- " + amigo.tocar(musica));
        }
    }

    private static List<Amigos> crearGrupoFijo(int total, Random random) {
        List<String> nombresBase = new ArrayList<>(List.of(
                "Ana", "Luis", "Maria", "Carlos", "Sofia", "Diego", "Valeria", "Mateo",
                "Paula", "Andres", "Juliana", "Nicolas", "Camila", "Martin", "Laura", "Jorge"
        ));
        Collections.shuffle(nombresBase, random);

        List<Amigos> grupo = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            String nombre = nombresBase.get(i);
            int edad = 18 + random.nextInt(23);
            String generoFav = Musica.GENEROS[random.nextInt(Musica.GENEROS.length)];
            grupo.add(new Amigos(nombre, edad, generoFav));
        }
        return grupo;
    }

    private static void imprimirResumen(Evento evento, List<Amigos> grupo, List<Amigos> asistentes, Musica musica) {
        System.out.println("=== Simulacion de evento musical ===");
        System.out.println("Tipo de evento: " + evento.getTipoFiesta());
        System.out.println("Grupo total: " + grupo.size() + " amigos");
        System.out.println("Asistentes: " + asistentes.size() );
        System.out.println("Genero musical: " + musica.genero());
        System.out.println("Duracion estimada: " + musica.tiempo() + " minutos");
        System.out.println("Instrumentos en escena: " + musica.getInstrumentos().size());
        System.out.println("--- Presentacion ---");
    }
}