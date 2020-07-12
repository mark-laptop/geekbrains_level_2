package ru.geekbrains.lesson03;

import java.util.*;

public class Main {

    private static final String WORDS = "один два три четыре четыре один пять шесть один";
    private static final String SPACE_SYMBOL = " ";

    public static void main(String[] args) {

        firstTask(Main.WORDS);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumber("Иванов", "+7 (123) 123-12-12");
        phoneBook.addPhoneNumber("Петров", "+7 (234) 234-23-23");
        phoneBook.addPhoneNumber("Сидоров", "+7 (345) 345-34-34");
        phoneBook.addPhoneNumber("Федоров", "+7 (456) 456-45-45");
        phoneBook.addPhoneNumber("Сусликов", "+7 (567) 567-56-56");
        phoneBook.addPhoneNumber("ХэшМапов", "+7 (678) 678-67-67");

        phoneBook.printPhoneBook();

        System.out.println("============================================================");

        phoneBook.addPhoneNumber("ХэшМапов", "+7 (789) 789-78-78");

        phoneBook.printPhoneBook();

        System.out.println("============================================================");

        phoneBook.addEmail("ХэшМапов", "hashMap@mail.ru");

        phoneBook.printPhoneBook();

        System.out.println("============================================================");

        List<String> phoneNumbers = phoneBook.getPhoneNumbers("ХэшМапов");
        List<String> emails = phoneBook.getEmails("ХэшМапов");
        System.out.println(phoneNumbers);
        System.out.println("############################################################");
        System.out.println(emails);

        phoneBook.removePhoneNumber("ХэшМапов", "+7 (678) 678-67-67");
        System.out.println("============================================================");
        phoneBook.printPhoneBook();

        phoneBook.removePhoneNumber("Федоров", "+7 (456) 456-45-45");
        System.out.println("============================================================");
        phoneBook.printPhoneBook();

    }

    private static void firstTask(final String words) {
        String[] arrayWords = words.split(Main.SPACE_SYMBOL);

        // список слов без дубликатов
        Set<String> setWords = new HashSet<>(Arrays.asList(arrayWords));

        // создаем map с уникальными ключами
        HashMap<String, Integer> mapCountWords = new HashMap<>(setWords.size());
        for (String word : setWords) {
            mapCountWords.put(word, 0);
        }

        // если в map ключ уже присутствует увеличиваем значение ключа на 1
        for (String word : arrayWords) {
            if (mapCountWords.containsKey(word)) {
                mapCountWords.put(word, mapCountWords.get(word) + 1);
            }
        }

        for (Map.Entry<String, Integer> pair : mapCountWords.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

}
