package ru.geekbrains.lesson03_2;

public class Person {

    private String phone;
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getPhone() != null ? !getPhone().equals(person.getPhone()) : person.getPhone() != null) return false;
        return getEmail() != null ? getEmail().equals(person.getEmail()) : person.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getPhone() != null ? getPhone().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
