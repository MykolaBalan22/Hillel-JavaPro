package Dog;

import Animal.Animal;

public class Dog extends Animal {

    public Dog(String dogName) {
        Animal.addNewAnimal();
        if (dogName!=null) {
            this.nameAnimal=dogName;
        }else {
            this.nameAnimal="Безіменний";
        }
    }


    @Override
    public void run(double length) {
        if (length<=500 && length>=0) {
            System.out.printf("%s пробіг %.2f м. \n",nameAnimal ,length);
        }else if(length<0) {
            System.out.printf("Некоректа відсань %.2f м.(собаки в мінус не бігають)\n",length);
        }else if(length>500 ){
            System.out.printf("Некоректа відсань %.2f м.(собаки стільки  не бігають , забагато)\n", length);
        }
    }

    @Override
    public void swim(double length) {
        if (length<=10 && length>=0) {
            System.out.printf("%s проплив  %.2f м.\n",nameAnimal ,length);
        }else if(length<0) {
            System.out.printf("Некоректа відсань %.2f м.(собаки в мінус не плавають)\n",length);
        }else if(length>10 ){
            System.out.printf("Некоректа відсань %.2f м.(собаки стільки  не плавають , забагато)\n", length);
        }
    }
}
