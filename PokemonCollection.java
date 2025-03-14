import java.util.*;

class PokemonCollection {
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
}
