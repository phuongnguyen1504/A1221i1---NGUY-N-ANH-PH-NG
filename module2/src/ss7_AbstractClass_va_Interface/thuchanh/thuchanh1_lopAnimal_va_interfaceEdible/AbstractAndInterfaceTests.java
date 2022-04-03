package ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible;

import ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible.animal.Animal;
import ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible.animal.Chicken;
import ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible.animal.Tiger;
import ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible.edible.Edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals=new Animal[2];
        animals[0]=new Chicken();
        animals[1]=new Tiger();
        for (Animal animal: animals){
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken){
                Edible edibler=(Chicken)animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
