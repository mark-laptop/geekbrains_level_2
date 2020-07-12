package ru.geekbrains.lesson03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private final Map<String, Person> map = new HashMap<>();

    private Person getPerson(String surName) {
        return map.get(surName);
    }

    public List<String> getPhoneNumbers(String surName) {
        Person person = getPerson(surName);
        if (person == null) return null;
        Set<String> phoneNumbers = person.getPhoneNumbers();
        return new ArrayList<>(phoneNumbers);
    }

    public List<String> getEmails(String surName) {
        Person person = getPerson(surName);
        if (person == null) return null;
        Set<String> emails = person.getEmails();
        return new ArrayList<>(emails);
    }

    public void addPhoneNumber(String surName, String phoneNumber) {
        Person person;
        if ((person = map.get(surName)) != null) {
            person.addPhoneNumber(phoneNumber);
        } else {
            person =  new Person();
            person.addPhoneNumber(phoneNumber);
            map.put(surName, person);
        }
    }

    public void addEmail(String surName, String email) {
        Person person;
        if ((person = map.get(surName)) != null) {
            person.addEmail(email);
        } else {
            person =  new Person();
            person.addEmail(email);
            map.put(surName, person);
        }
    }

    public boolean removePhoneNumber(String surName, String phoneNumber) {
        Person person;
        if ((person = map.get(surName)) != null) {
            return person.removePhoneNumber(phoneNumber);
        }
        return false;
    }

    public boolean removeEmail(String surName, String email) {
        Person person;
        if ((person = map.get(surName)) != null) {
            return person.removeEmail(email);
        }
        return false;
    }

    public Person remove(String surName) {
        return map.remove(surName);
    }

    public void printPhoneBook() {
        for (Map.Entry<String, Person> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
