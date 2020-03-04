/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        */
/*File file = new File("hibernate.properties");*//*
Properties properties = new Properties();
properties.load(new FileReader(file));

        //Properties properties = new Properties();
        try(FileInputStream file = new FileInputStream("src/main/webapp/resources/hibernate.properties")) {
          properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = properties.getProperty("bdconfig");
        System.out.println(s);
    }
}
*/
