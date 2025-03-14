import java.io.*;
import java.util.*;

class PokemonCSVReader {
    public static Map<String, List<String>> readCSV(String filePath, PokemonMapFactory factory) {
        Map<String, List<String>> pokemonData = factory.createMap();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Omitir la primera línea (encabezado)
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[0];
                List<String> attributes = Arrays.asList(values);
                pokemonData.put(name, attributes);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return pokemonData;
    }
}
