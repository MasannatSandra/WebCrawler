import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class SingleAnalysis {
    public static void main(String... args) {
        //hashmap key is the word, value is the count
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        try {
            //change the filename here
            File file = new File("./text - en/1.txt");
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




        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(wordCount.entrySet());
        //sort the hashmap by putting it into a linked list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        //print out the linked list
        for (Map.Entry<String, Integer> x : list) {
            System.out.println(x);
        }
    }//end of main
}