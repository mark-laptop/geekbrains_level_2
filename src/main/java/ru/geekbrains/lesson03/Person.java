package ru.geekbrains.lesson03;

import java.util.Set;
import java.util.HashSet;

public class Person {

    private Set<String> phoneNumbers = new HashSet<>();
    private Set<String> emails = new HashSet<>();

    public Person() {
    }

    public Person(Set<String> phoneNumbers, Set<String> emails) {
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    public boolean removePhoneNumber(String phoneNumber) {
        return phoneNumbers.remove(phoneNumber);
    }

    public boolean removeEmail(String email) {
        return emails.remove(email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                '}';
    }
}
