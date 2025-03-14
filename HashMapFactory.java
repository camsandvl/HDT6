import java.util.*;

class HashMapFactory implements PokemonMapFactory {
    public Map<String, List<String>> createMap() {
        return new HashMap<>();
    }
}

