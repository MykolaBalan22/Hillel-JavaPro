package Animal;

public abstract class Animal {
    private    static  int  counterAnimals=0 ;
    protected   String nameAnimal ;
    public  abstract void run(double length);
    public  abstract void swim(double length);
    public static void showAmountAnimals(){
        System.out.printf("Created : %d animals \n", counterAnimals);
    }
    protected static void addNewAnimal(){
        Animal.counterAnimals++;
    }
}
