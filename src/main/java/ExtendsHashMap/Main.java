package ExtendsHashMap;

public class Main {
    public static void main(String[] args) {
        HoangPhucMap<String, String> map = new HoangPhucMap<>();
        map.put("Phuc", "123");
        map.put("Anh", "345");
        map.put("Tung", "987");

        System.out.println("Before map");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        map.replaceKey("Anh", "John");
        System.out.println("After map");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
        
    }
}
