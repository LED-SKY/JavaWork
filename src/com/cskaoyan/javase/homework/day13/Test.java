package com.cskaoyan.javase.homework.day13;

/**
 * @description: 如何快速写出Java程序员的第一个一百行代码？
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Test {
}

class Person {
    private int age;
    private String name;
    private int id;
    private String gender;
    private String nation;

    public Person() {
    }

    public Person(int age, String name, int id, String gender, String nation) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.nation = nation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (getId() != person.getId()) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        if (getGender() != null ? !getGender().equals(person.getGender()) : person.getGender() != null) return false;
        return getNation() != null ? getNation().equals(person.getNation()) : person.getNation() == null;
    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getId();
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getNation() != null ? getNation().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }

}
