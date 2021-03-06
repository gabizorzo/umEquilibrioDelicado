import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWithScanner {
    public static List<String> scan() throws IOException{
        Scanner in = new Scanner(System.in);

        System.out.print("Nome do arquivo de teste (colocar .txt no final): ");
        String file = in.next();
        Scanner scanner = new Scanner(new File(file));
        List<String> test = new ArrayList<String>();

        scanner.useDelimiter("\n");

        while(scanner.hasNext()){
            String next = scanner.next();
            test.add(next);
            // System.out.println(next);
        }
        scanner.close();
        
        return test;
    }

    public static void main(String[] args) throws IOException{
        System.out.println(scan());
    }


}