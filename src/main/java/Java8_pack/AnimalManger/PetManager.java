package Java8_pack.AnimalManger;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PetManager {
    private List<Pet> pets;

    public PetManager() {
        this.pets = new ArrayList<>();
    }

    // easy
    // lọc các vật nuôi từ số tuổi yêu cầu trở lên
    public List<Pet> filterPetsByOld(int old) {
        return null;
    }

    // lọc các vật nuôi có tình trạng sức khoẻ tốt
    public List<Pet> filterGoodHeathOfPet() {
        return null;
    }

    // lọc ra các vật nuôi là chó
    public List<Pet> filterDogPets() {
        return null;
    }

    // Med.

    // xắp xếp các vật nuôi theo thứ tự tăng dần dựa trên độ tuôi
    public List<Pet> sortPetByOld() {
        return pets.
                stream()
                .sorted(Comparator.comparing(Pet::getOld))
                .toList();
    }

    // thống kê thú nuôi dựa trên tình trạng sức khoẻ
    public Map<Type, List<Pet>> mapHealth() {
        return pets
                .stream()
                .collect(Collectors.groupingBy(Pet::getType));
    }

    // tìm ra thú nuôi có lịch sử khám nhiều nhất
    public Pet maxPetHistory() {
        return pets
                .stream()
                .max(Comparator.comparing(Pet::historySize))
                .orElseThrow();
    }

    // lọc ra các vật nuôi có ngày khám trước dd/mm/yyyy
    public List<Pet> filterPetsBefore(LocalDate date) {
        return null;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
