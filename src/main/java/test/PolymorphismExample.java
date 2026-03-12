package test;

public class PolymorphismExample {
    static void main(String[] args) {
        Bird bird = new Penguin();
        //bird.swim();
        bird.eat();
        System.out.println(bird.count +" Birds are There");
    }
}
class Bird {
    int count = 90;
    void fly() {
        System.out.println(count +" Bird are flying");
    }

    void eat() {
        System.out.println(count +" Bird are Eating");
    }
}

class Penguin extends Bird {
    int count = 70;
    void swim() {
        System.out.println(count +" Penguins are swimming");
    }

    void eat() {
        System.out.println(count +" Penguins are Eating");
    }
}
