import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class WordGrowth {
    public static void main(String... args) {
        //hashmap key is the word, value is the count
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        //change the File name to the folder you want to loop in
        File dir = new File("./text - ru");
        for (File file : dir.listFiles()) {
            int fileCount = 0;
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
                            //not unique but is a word
                            fileCount++;
                        }
                        else if(word.equals("")){
                            //ignore
                            //not a word
                        }
                        //if word is new add it to hash map with a value of q
                        else {
                            wordCount.put(word,1);
                            //unique but is a word
                            fileCount++;
                        }
                    }
                }//end of while loop
                myReader.close();
            } catch (Exception e) {
                System.out.println("an error oops");
            }//end of catch
//            System.out.println("File: " + file);
            System.out.println(fileCount);
        }//end of file loop
    }//end of main
}
