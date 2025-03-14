import java.util.*;

class TreeMapFactory implements PokemonMapFactory {
    public Map<String, List<String>> createMap() {
        return new TreeMap<>();
    }
}

