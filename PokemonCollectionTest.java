import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PokemonCollectionTest {
    private PokemonCollection collection;

    @Test
    void testAddPokemon() {
        Map<String, List<String>> testData = new HashMap<>();
        testData.put("Pikachu", Arrays.asList("Electric"));
        testData.put("Charmander", Arrays.asList("Fire"));

        collection = new PokemonCollection(testData);

        // Agregar Pokémon válidos
        assertDoesNotThrow(() -> collection.addPokemon("Pikachu"));
        assertDoesNotThrow(() -> collection.addPokemon("Charmander"));

        // Intentar agregar un Pokémon que no existe en testData
        collection.addPokemon("MissingNo");
    }

    @Test
    void testAddDuplicatePokemon() {
        Map<String, List<String>> testData = new HashMap<>();
        testData.put("Pikachu", Arrays.asList("Electric"));

        collection = new PokemonCollection(testData);

        // Agregar el mismo Pokémon dos veces
        collection.addPokemon("Pikachu");
        collection.addPokemon("Pikachu"); // Debería mostrar mensaje de duplicado

        // No podemos verificar `userCollection`, pero sabemos que el tamaño no debe cambiar
        assertDoesNotThrow(() -> collection.addPokemon("Pikachu"));
    }
}
