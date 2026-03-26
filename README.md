# Musica - Simulacion de evento musical

Este proyecto simula una fiesta donde un grupo de amigos es contratado para tocar musica.
La idea principal es que todo cambie en cada ejecucion: el tipo de evento, cuantas personas
asisten y que instrumento le toca a cada amigo.

## Que hace el programa

El programa arranca con un grupo fijo de 8 amigos. Nadie confirma asistencia antes, entonces
se elige al azar cuantas personas del grupo van al evento (siempre minimo 1 y maximo 8).

Despues se genera el evento y el estilo musical de la presentacion. A cada amigo asistente se
le asigna un solo instrumento para ese evento. Con eso, el programa imprime un resumen general
y luego muestra como participa cada amigo durante la presentacion.

En pocas palabras: cada corrida cuenta una version distinta de la misma historia.

## Clases principales (explicado simple)

- `Main`: organiza todo el flujo de la simulacion.
- `Evento`: decide el tipo de fiesta y cuanta gente asiste.
- `Musica`: define el genero que se va a tocar y la duracion estimada.
- `Amigos`: guarda los datos de cada amigo y muestra su participacion.
- `Instrumento` (abstracta): base para todos los instrumentos.
- Subclases de instrumentos: `Guitarra`, `Piano`, `Violin`, `Flauta`, `Saxofon`, `Bateria`.

## Reglas que se cumplen

- Grupo fijo de `8` amigos.
- Nombres sin repetir.
- Atributos como edad o genero favorito pueden repetirse.
- Asistentes aleatorios entre `1` y `N`.
- Cada asistente toca solo un instrumento por evento.
- Sin semilla fija: los resultados cambian cada vez.

## Diagrama UML (PlantUML)

```plantuml
@startuml

class Main {
  +{static} main(args : String[]) : void
}

class Evento {
  -tipoFiesta : String
  -invitados : int
  +Evento(tipoFiesta : String, invitados : int)
  +{static} generar(random : Random, maxInvitados : int) : Evento
  +organizar(grupo : List<Amigos>, random : Random) : List<Amigos>
  +getTipoFiesta() : String
  +getInvitados() : int
}

class Musica {
  +{static} GENEROS : String[]
  -instrumentos : List<Instrumento>
  -genero : String
  -tiempoMinutos : int
  +Musica()
  +generar(tipoEvento : String, random : Random) : void
  +agregarInstrumento(instrumento : Instrumento) : void
  +genero() : String
  +tiempo() : int
  +getInstrumentos() : List<Instrumento>
}

class Amigos {
  -nombre : String
  -edad : int
  -generoFavorito : String
  -instrumento : Instrumento
  +Amigos(nombre : String, edad : int, generoFavorito : String)
  +asignarInstrumento(instrumento : Instrumento) : void
  +tocar(musica : Musica) : String
}

abstract class Instrumento {
  -tipo : String
  +{static} generarAleatorio(random : Random) : Instrumento
  +afinar() : String
  +tocar() : String
  +tocar(nota : String) : String
  +requiereSoplar() : boolean
  +soplar() : String
  +interpretar(genero : String) : String
  +getTipo() : String
}

class Guitarra
class Piano
class Violin
class Flauta
class Saxofon
class Bateria

Instrumento <|-- Guitarra
Instrumento <|-- Piano
Instrumento <|-- Violin
Instrumento <|-- Flauta
Instrumento <|-- Saxofon
Instrumento <|-- Bateria

Main ..> Evento : crea
Main ..> Musica : crea
Main ..> Amigos : usa
Main ..> Instrumento : genera
Evento ..> Amigos : organiza asistentes
Musica "1" o-- "0..*" Instrumento : instrumentos
Amigos "1" --> "0..1" Instrumento : asigna
Amigos ..> Musica : toca segun genero

@enduml




