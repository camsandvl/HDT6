import java.util.*;

public class PokemonCollection {
    private Set<String> userCollection;
    private Map<String, List<String>> pokemonData;

    public PokemonCollection(Map<String, List<String>> pokemonData) {
        this.userCollection = new HashSet<>();
        this.pokemonData = pokemonData;
    }

    public void addPokemon(String name) {
        if (!pokemonData.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado en la base de datos.");
        } else if (userCollection.contains(name)) {
            System.out.println("Ese Pokémon ya está en tu colección.");
        } else {
            userCollection.add(name);
            System.out.println(name + " agregado a tu colección.");
        }
    }


    public void showCollection() {
        if (userCollection.isEmpty()) {
            System.out.println("Tu colección está vacía.");
        } else {
            System.out.println("Pokémon en tu colección:");
            for (String name : userCollection) {
                System.out.println(name);
            }
        }
    }

    public void showPokemonData(String name) {
        if (!pokemonData.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado en la base de datos.");
            return;
        }
        List<String> data = pokemonData.get(name);
        System.out.println("Name: " + name);
        System.out.println("Pokedex number: " + data.get(1));
        System.out.println("Type1: " + data.get(2));
        System.out.println("Type2: " + (data.get(3).isEmpty() ? "None" : data.get(3)));
        System.out.println("Classification: " + data.get(4));
        System.out.println("Height(m): " + data.get(5));
        System.out.println("Weight(kg): " + data.get(6));
        System.out.println("Abilities: " + data.get(7));
        System.out.println("Generation: " + data.get(8));
        System.out.println("Legendary Status: " + data.get(9));
    }

    public void showCollectionSortedByType1() {
        if (userCollection.isEmpty()) {
            System.out.println("Tu colección está vacía.");
            return;
        }
        List<String> sortedCollection = new ArrayList<>(userCollection);
        sortedCollection.sort(Comparator.comparing(pokemon -> pokemonData.get(pokemon).get(2)));
        System.out.println("Pokémon en tu colección ordenados por Type1:");
        for (String name : sortedCollection) {
            System.out.println("Name: " + name + ", Type1: " + pokemonData.get(name).get(2));
        }
    }

    public void showAllPokemonSortedByType1() {
        List<String> sortedPokemon = new ArrayList<>(pokemonData.keySet());
        sortedPokemon.sort(Comparator.comparing(pokemon -> pokemonData.get(pokemon).get(2)));
        System.out.println("Todos los Pokémon ordenados por Type1:");
        for (String name : sortedPokemon) {
            System.out.println("Name: " + name + ", Type1: " + pokemonData.get(name).get(2));
        }
    }
}
