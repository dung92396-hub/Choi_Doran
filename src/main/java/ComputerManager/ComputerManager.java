package ComputerManager;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ComputerManager {
    private final List<Computer> computers = new ArrayList<>();

    public boolean containsComputer(Computer computer) {
        return computers.stream().anyMatch(c -> c.getId().equals(computer.getId()));
    }

    public boolean containsComputer(String id) {
        return computers.stream().anyMatch(c -> c.getId().equals(id));
    }

    // Add a computer instance
    public void add(Computer computer) {
        if (computer == null || containsComputer(computer)) return;
        computers.add(computer);
    }

    // Convenience add by fields
    public void add(String id, String brand, double price) {
        add(new Computer(id, brand, price));
    }

    // Add with config object
    public void add(String id, String brand, double price, ComputerConfig config) {
        add(new Computer(id, brand, price, config));
    }

    // Convenience: add with config fields
    public void add(String id, String brand, double price, String cpu, int ramGB, int storageGB, String gpu) {
        ComputerConfig cfg = new ComputerConfig(cpu, ramGB, storageGB, gpu);
        add(new Computer(id, brand, price, cfg));
    }

    public List<Computer> getAll() {
        return new ArrayList<>(computers);
    }

    // 1. Find computer by ID
    public Computer findById(String id) {
        return computers
                .stream()
                .filter(c -> c.isSameId(id))
                .findFirst()
                .orElseThrow();
    }

    // 2. Remove computer by ID
    public boolean removeById(String id) {
        Computer c = findById(id);
        if (c != null) {
            computers.remove(c);
            return true;
        }
        return false;
    }

    // 3. Count total computers
    public int size() {
        // TODO: Implement this method
        return 0;
    }

    // 4. Display all computers in table format
    public void displayAll() {
        // TODO: Implement this method
    }

    // 5. Find all computers by brand
    public List<Computer> findByBrand(String brand) {
        return computers
                .stream()
                .filter(c -> c.getBrand().equals(brand))
                .toList();
    }

    // 6. Filter computers by price range
    public List<Computer> filterByPriceRange(double min, double max) {
        return computers
                .stream()
                .filter(c -> c.isBetweenPrice(min, max))
                .toList();
    }

    // 7. Sort computers by price
    public List<Computer> sortByPrice(boolean ascending) {
        if (ascending) {
            return computers
                    .stream()
                    .sorted(Comparator.comparing(Computer::getPrice))
                    .toList();
        }
        return computers
                .stream()
                .sorted(Comparator.comparing(Computer::getPrice, Comparator.reverseOrder()))
                .toList();
    }

    // ==================== HashMap & HashSet Methods ====================

    // H1. Group computers by brand (HashMap<Brand, List<Computer>>)
    public Map<String, List<Computer>> groupByBrand() {
        return computers
                .stream()
                .collect(Collectors.groupingBy(Computer::getBrand));
    }

    // H2. Count computers by brand (HashMap<Brand, Integer>)
    public Map<String, Long> countByBrand() {
        return computers
                .stream()
                .collect(Collectors.groupingBy(
                        Computer::getBrand,
                        Collectors.counting()
                ));
    }

    // H3. Get unique brands as HashSet
    public Set<String> getUniqueBrands() {
        return computers
                .stream()
                .map(Computer::getBrand)
                .collect(Collectors.toCollection(HashSet::new));
    }

    // H4. Find brands with computers in price range (HashSet<String>)
    public Set<String> findBrandsInPriceRange(double min, double max) {
        // TODO: Implement this method
        // Return a HashSet of brand names that have computers within the price range
        return null;
    }

    // H5. Create price index (HashMap<Double, Computer>)
    public Map<Double, Computer> createPriceIndex() {
        // TODO: Implement this method
        // Return a HashMap where key is price, value is the computer at that price
        // Handle case where multiple computers might have same price
        return null;
    }

    // H6. Get computers by price with duplicates removed (HashSet<Computer>)
    public Set<Computer> getUniqueComputersByPrice(double price) {
        // TODO: Implement this method
        // Return a HashSet of computers with the given price (removes duplicates)
        return null;
    }

    // H7. Create brand-to-cheapest-price map (HashMap<String, Double>)
    public Map<String, Double> getCheapestPriceByBrand() {
        // TODO: Implement this method
        // Return a HashMap where key is brand, value is lowest price for that brand
        return null;
    }

    // H8. Find computers NOT in a given brand set (List<Computer>)
    public List<Computer> excludeBrands(Set<String> brandBlacklist) {
        // TODO: Implement this method
        // Return list of computers whose brands are NOT in the blacklist HashSet
        return null;
    }

    // H9. Create availability map by price (HashMap<String, Set<String>>)
    // Format: Price -> Set of Brand names available at that price
    public Map<Double, Set<String>> getAvailableBrandsByPrice() {
        // TODO: Implement this method
        // Return HashMap where key is price, value is HashSet of brands at that price
        return null;
    }

    // H10. Find brand intersection with price filter
    // (Set<String>: brands that have computers in price range AND in given brand set)
    public Set<String> findBrandIntersection(Set<String> brandSet, double minPrice, double maxPrice) {
        // TODO: Implement this method
        // Return HashSet of brands that are in brandSet AND have computers in price range
        return null;
    }

    // H11. Count computers by price range buckets (HashMap<String, Integer>)
    // Buckets: "0-500", "500-1000", "1000-1500", "1500+"
    public Map<String, Integer> countByPriceRange() {
        // TODO: Implement this method
        // Return HashMap with price range buckets as keys and computer counts as values
        return null;
    }

    // H12. Find duplicate brands (HashSet<String>)
    public Set<String> findDuplicateBrands() {
        // TODO: Implement this method
        // Return HashSet of brands that appear more than once
        return null;
    }

    // H13. Create computer ID to Computer map (HashMap<String, Computer>)
    public Map<String, Computer> createIdIndex() {
        // TODO: Implement this method
        // Return HashMap where key is computer ID, value is the Computer object
        return null;
    }

    // H14. Find brands common between two price ranges (Set<String>)
    public Set<String> findCommonBrands(double min1, double max1, double min2, double max2) {
        // TODO: Implement this method
        // Return HashSet of brands that have computers in BOTH price ranges
        return null;
    }

    // H15. Get statistics by brand (HashMap<String, Map<String, Object>>)
    // Format: Brand -> {count, avgPrice, minPrice, maxPrice}
    public Map<String, Map<String, Object>> getDetailedStatsByBrand() {
        // TODO: Implement this method
        // Return HashMap where key is brand, value is another Map with count/avg/min/max
        return null;
    }
}
