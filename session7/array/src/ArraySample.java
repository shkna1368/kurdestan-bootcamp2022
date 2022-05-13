public class ArraySample {

    public static void main(String[] args) {

        int[] intArray=new int[3];
        intArray[0]=60;
        intArray[1]=70;
        intArray[2]=80;

        System.out.println("index1="+intArray[1]);

        intArray[1]=96;
        System.out.println(intArray[1]);

        //System.out.println(intArray[3]);



        System.out.println("array lenght:"+intArray.length);

        int[] intArray2={1,10,20,30};
        for(int i=0;i<intArray2.length;i++){

            System.out.println("element at index "+i+"="+intArray2[i]);
        }

        for (int el:intArray2){
            System.out.println("element="+el);
        }





        int[] numbers={1,2,3,4,5,6};

        for (int i=0;i<numbers.length;i++){

            if(numbers[i]%2==0){

                System.out.println("index "+i+" value "+numbers[i] +" zoj");
            }
            else {
                System.out.println("index "+i+" value "+numbers[i] +" fard");
            }
        }


    }
}
