public class Amigos {
    private final String nombre;
    private final int edad;
    private final String generoFavorito;
    private Instrumento instrumento;

    public Amigos(String nombre, int edad, String generoFavorito) {
        this.nombre = nombre;
        this.edad = edad;
        this.generoFavorito = generoFavorito;
    }

    public void asignarInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public String tocar(Musica musica) {
        if (instrumento == null) {
            return nombre + " no tiene instrumento asignado.";
        }

        StringBuilder salida = new StringBuilder();
        salida.append(nombre)
                .append(" (")
                .append(edad)
                .append(" años, favorito: ")
                .append(generoFavorito)
                .append(") :")
                .append(instrumento.afinar())
                .append(" ");

        if (instrumento.requiereSoplar()) {
            salida.append(instrumento.soplar()).append(" ");
        }

        salida.append(instrumento.interpretar(musica.genero()));
        return salida.toString();
    }
}

