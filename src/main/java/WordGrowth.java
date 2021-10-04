import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class WordGrowth {
    public static void main(String... args) {
        String vocab = "the";
        //hashmap key is the word, value is the count
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        //change the File name to the folder you want to loop in
        File dir = new File("./text - en");
        for (File file : dir.listFiles()) {
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    //only read letters and make all lowercase
                    String[] words = data.replaceAll("[^\\p{L} ]", "").toLowerCase().split("\\s+");
                    for (String word : words){
                        //if the word is already in the hashmap update the value by 1
                        if (wordCount.containsKey(word)){
                            int newVal = wordCount.get(word)+1;
                            wordCount.replace(word, newVal);
                        }
                        //if word is new add it to hash map with a value of q
                        else {
                            wordCount.put(word,1);
                        }
                    }
                }//end of while loop
                myReader.close();
            } catch (Exception e) {
                System.out.println("an error oops");
            }//end of catch
            System.out.println("File: " + file);
            System.out.println("vocab count: " + wordCount.get(vocab));
        }//end of file loop
    }//end of main
}