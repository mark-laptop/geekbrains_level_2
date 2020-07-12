package ru.geekbrains.lesson03_3;

import java.util.HashSet;
import java.util.Set;

public class Person {

    private Set<String> phones = new HashSet<>();
    private Set<String> emails = new HashSet<>();

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

   public void addPhone(String phone) {
        phones.add(phone);
   }

   public void addEmail(String email) {
        emails.add(email);
   }

    public void removePhone(String phone) {
        phones.remove(phone);
    }

    public void removeEmail(String email) {
        emails.remove(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;

        if (getPhones() != null ? !getPhones().equals(person.getPhones()) : person.getPhones() != null) return false;
        return getEmails() != null ? getEmails().equals(person.getEmails()) : person.getEmails() == null;
    }

    @Override
    public int hashCode() {
        int result = getPhones() != null ? getPhones().hashCode() : 0;
        result = 31 * result + (getEmails() != null ? getEmails().hashCode() : 0);
        return result;
    }
}
