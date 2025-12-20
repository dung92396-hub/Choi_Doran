package Java8_pack.AnimalManger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
