package Builder;

import java.time.LocalDate;

public class User {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String ethnic;
    private Education education;
    private String religion;
    private Double salaryPerYear;

    // mau builder
    public static class Builder {
        private User user = new User();

        // id va fullName la 2 thuoc tinh bac buoc, con lai la thuoc tinh tu chon
        public Builder(Long id, String fullName) {
            this.user.id = id;
            this.user.fullName = fullName;
        }

        public Builder setBirthday(LocalDate birthday) {
            this.user.birthday = birthday;
            return this;
        }

        public Builder setEthnic(String ethnic) {
            this.user.ethnic = ethnic;
            return this;
        }

        public Builder setEducation(Education education) {
            this.user.education = education;
            return this;
        }

        public Builder setReligion(String religion) {
            this.user.religion = religion;
            return this;
        }

        public Builder setSalaryPerYear(Double salaryPerYear) {
            this.user.salaryPerYear = salaryPerYear;
            return this;
        }

        public User build() {
            return user;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", ethnic='").append(ethnic).append('\'');
        sb.append(", education=").append(education);
        sb.append(", religion='").append(religion).append('\'');
        sb.append(", salaryPerYear=").append(salaryPerYear);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Double getSalaryPerYear() {
        return salaryPerYear;
    }

    public void setSalaryPerYear(Double salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }
}
