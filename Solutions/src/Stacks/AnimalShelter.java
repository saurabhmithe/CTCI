package Stacks;

import java.util.LinkedList;

public class AnimalShelter {

    /*

    An animal shelter, which holds only dogs and cats, operates on a strictly"first in,
    first out" basis. People must adopt either the "oldest" (based on arrival time) of
    all animals at the shelter, or they can select whether they would prefer a dog or
    a cat (and will receive the oldest animal of that type). They cannot select which
    specific animal they would like. Create the data structures to maintain this system
    and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
    You may use the built-in Linked L is t data structure.

    */

    LinkedList<Long> cat = new LinkedList<>();
    LinkedList<Long> dog = new LinkedList<>();

    public void enqueue(String type) {
        long current = System.currentTimeMillis();
        if (type.equals("cat")) cat.addFirst(current);
        else dog.addFirst(current);
    }

    public long dequeueAny() {
        if (cat.getLast() < dog.getLast()) {
            long oldestCat = cat.getLast();
            cat.removeLast();
            return oldestCat;
        } else {
            long oldestDog = dog.getLast();
            dog.removeLast();
            return oldestDog;
        }
    }

    public long dequeueCat() {
        long oldestCat = cat.getLast();
        cat.removeLast();
        return oldestCat;
    }

    public long dequeueDog() {
        long oldestDog = dog.getLast();
        dog.removeLast();
        return oldestDog;
    }

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue("cat");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        animalShelter.enqueue("cat");
        animalShelter.dequeueAny();
        animalShelter.dequeueDog();
        animalShelter.dequeueCat();
    }

}
