package algorithm.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteTest {
    public static void main(String[] args) {
        File f = new File("D:\\IdeaProjects\\test.txt");
        try {
            PrintWriter pw = new PrintWriter(f);
            for (int i = 100000; i >0; i--) {
                pw.println(i);

            }
            pw.flush();
            System.out.println("ok");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
