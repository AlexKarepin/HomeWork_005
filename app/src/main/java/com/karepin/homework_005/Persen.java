package com.karepin.homework_005;

public class Persen {
    public String name;
    public String age;

    public Persen(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", возраст: " + age;
    }
}
