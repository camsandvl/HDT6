import java.util.*;

class LinkedHashMapFactory implements PokemonMapFactory {
    public Map<String, List<String>> createMap() {
        return new LinkedHashMap<>();
    }
}
