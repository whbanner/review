package com.wh.copy;

public class Person implements Cloneable {
        String name;
        int age;
        Skill skill;

    public Person(String name, int age, Skill skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return this.name+"===="+this.age+"===="+this.skill.getName();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p= (Person) super.clone();
        Skill sKill1= (Skill) this.skill.clone();
        p.setSkill(sKill1);
        return p;
    }
}
