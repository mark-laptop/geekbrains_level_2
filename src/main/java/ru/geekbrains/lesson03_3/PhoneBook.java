package ru.geekbrains.lesson03_3;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    private final Map<String, Set<Person>> map = new HashMap<>();

    public List<String> getPhonesBySurname(String surName) {
        Set<Person> personSet = map.get(surName);
        if (personSet == null) return null;

        List<String> phoneList = new ArrayList<>();
        for (Person person : personSet) {
            phoneList.addAll(person.getPhones());
        }
        return phoneList;
    }

    public List<String> getEmailBySurname(String surName) {
        Set<Person> personSet = map.get(surName);
        if (personSet == null) return null;

        List<String> emailList = new ArrayList<>();
        for (Person person : personSet) {
            emailList.addAll(person.getEmails());
        }
        return emailList;


    }

    public void addPerson(String surName, Person person) {
        Set<Person> personSet = getPersons(surName);
        if(personSet == null) {
            personSet = new HashSet<>();
            personSet.add(person);
            map.put(surName, personSet);
        } else {
            personSet.add(person);
        }
    }

    public void removePerson(String surName, Person person) {
        Set<Person> personSet = getPersons(surName);
        if(personSet != null) {
            personSet.remove(person);
        }
    }

    public Set<Person> getPersons(String surName) {
        return map.get(surName);
    }
}
