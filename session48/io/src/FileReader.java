import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        try(            FileInputStream fileInputStream=new FileInputStream("c:\\datafolder\\output-text.txt");
        ) {

            int i=0;
            while ((i=fileInputStream.read())!=-1)

            {

                System.out.println((char)i);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
