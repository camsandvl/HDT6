import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PokemonMapFactory factory = null;

        // Selección de la implementación de Map
        System.out.println("Seleccione la implementación de Map:");
        System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: factory = new HashMapFactory(); break;
            case 2: factory = new TreeMapFactory(); break;
            case 3: factory = new LinkedHashMapFactory(); break;
            default:
                System.out.println("Opción inválida. Se usará HashMap por defecto.");
                factory = new HashMapFactory();
        }

        // Leer datos del CSV
        Map<String, List<String>> pokemonData = PokemonCSVReader.readCSV("pokemon_data_pokeapi.csv", factory);
        PokemonCollection collection = new PokemonCollection(pokemonData);

        // Menú
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar colección");
            System.out.println("3. Mostrar colección ordenada por tipo primario");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo primario");
            System.out.println("5. Mostrar datos de un Pokémon");
            System.out.println("6. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = scanner.nextLine();
                    collection.addPokemon(name);
                    break;
                case 2:
                    collection.showCollection();
                    break;
                case 3:
                    collection.showCollectionSortedByType1();
                    break;
                case 4:
                    collection.showAllPokemonSortedByType1();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del Pokémon a consultar: ");
                    String pokemonName = scanner.nextLine();
                    collection.showPokemonData(pokemonName);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}



