public class HumanRunner {
    public static void main(String[] args) {
        Human rebwar=new Human("Rebwar","Sanandaji",26,180,90,"Black",0);

        rebwar.printAttributes();
        rebwar.calculateBMI();

        rebwar.setAge(27);

        rebwar.printAttributes();

        Human awin=new Human("Awin","kurdestani",24,170,78,"Blue",1);

        awin.printAttributes();
        awin.calculateBMI();
        awin.setWeight(60);

        System.out.println("awin age:"+awin.getAge());

////////////////
        Human h1=new Human();
        h1.setName("hiwa");
        h1.setFamily("ahmadi");
        h1.setGender(0);
        h1.setEyeColor("Brown");
        h1.setHeight(190);
        h1.setWeight(75);

        h1.printAttributes();
        h1.calculateBMI();








    }
}
