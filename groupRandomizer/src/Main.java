import java.io.*;
import java.util.*;

public class Main {
    static final int groupAmount = 10;

    public static void main(String[] args) {
        ArrayList<String> temp = new ArrayList<>();
        try {
/*            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);*/
            File namnfile = new File("src/nameList.txt");
            Scanner sc = new Scanner(namnfile);
            temp = new ArrayList<>();
            while (sc.hasNext())
                temp.add(sc.nextLine());
            sc.close();

            System.out.println(Arrays.deepToString(temp.toArray()));
            Collections.shuffle(temp);


            for (int i = 0; i < temp.size(); i++)
                System.out.println(temp.set(i, (i + 1) % groupAmount + " " + temp.get(i)));


            Collections.sort(temp);

            System.out.println(Arrays.deepToString(temp.toArray()));
            String result = Arrays.deepToString(temp.toArray()).replaceAll("[^a-zA-Z0-9 ,]", "").replace(",", "\n");
            System.out.println(result);
            try {
                File file = new File("src/result.txt");
                FileWriter fileWrite = new FileWriter(file);
                //BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
                fileWrite.write(result);
                fileWrite.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.println("--- done! ---");

        } catch (Exception e) {
            System.out.println(e);
        }


    }
/*     void main() {
        System.out.println("Hello world!");
    }*/
}
