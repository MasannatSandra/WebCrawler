import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class WordGrowth {
    public static void main(String... args) {
        //keep track of the total words
        int total = 0;
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
                            //not unique but is a word
                            total++;
                        }
                        else if(word.equals("")){
                            //ignore
                            //not a word
                        }
                        //if word is new add it to hash map with a value of q
                        else {
                            wordCount.put(word,1);
                            //unique but is a word
                            total++;
                        }
                    }
                }//end of while loop
                myReader.close();
            } catch (Exception e) {
                System.out.println("an error oops");
            }//end of catch
            System.out.println("File: " + file);
            //prints unique word count (words in vocabulary)
            System.out.println(wordCount.size());
            //prints total word count (words in collection)
            System.out.println(total);
        }//end of file loop
    }//end of main
}
