package Cat;

import Animal.Animal;

public class Cat extends  Animal{
    public Cat(String catName) {
        Animal.addNewAnimal();
        if (catName!=null) {
            this.nameAnimal=catName;
        }else {
            this.nameAnimal="Безіменний";
        }
    }


    @Override
    public  void run(double length){
        if (length<=200 && length>=0) {
            System.out.printf("%s пробігла %.2f м.\n",nameAnimal ,length);
        }else if(length<0) {
            System.out.printf("Некоректа відсань %.2f м.(коти в мінус не бігають)\n",length);
        }else if(length>200 ){
            System.out.printf("Некоректа відсань %.2f м.(коти стільки  не бігають , забагато)\n", length);
        }

    }
    @Override
    public  void swim(double length){
        System.out.println("Коти не вміють плавати !");
    }
}
