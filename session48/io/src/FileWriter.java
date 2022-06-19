import java.io.*;

public class FileWriter {

    public static void main(String[] args) {
        try(OutputStream outputStream=new FileOutputStream("c:\\datafolder\\output-text.txt")) {
            Writer outWriter=new OutputStreamWriter(outputStream);
            outWriter.write("Hi Kurdestan");
            outWriter.flush();
            outWriter.close();
            System.out.println("success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
