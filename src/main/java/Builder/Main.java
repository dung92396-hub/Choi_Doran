package Builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder(1L, "Hoang Phuc")
                .setEducation(Education.UNIVERSITY)
                .setReligion(null)
                .setEthnic("Kinh")
                .build();
        System.out.println(user);

        User user2 = new User.Builder(2L, "Van Thanh").build();
        System.out.println(user2);
    }
}
