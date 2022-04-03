package ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible.animal;


import ss7_AbstractClass_va_Interface.thuchanh.thuchanh1_lopAnimal_va_interfaceEdible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat(){
        return "could be fried";
    }
}
