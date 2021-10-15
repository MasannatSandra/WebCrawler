/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package count;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class Count
{
    static void CountWords(String filename, Map<String, Integer> words) throws FileNotFoundException
    {
        Scanner file = new Scanner (new File(filename));
        while(file.hasNext()){
            //read is the original text in the file that may have punctuation
            String read = file.next();
            Integer count = words.get(read.replaceAll("[^\\p{L} ]","").toLowerCase());
            //word is the cleaned up text
            String word = read.replaceAll("[^\\p{L} ]","").toLowerCase();
            if(count != null) {
                count++;
                words.replace(word, count);
            }
            else if (word.equals("")){
                //do nothing
            }
            else {
                words.put(word, 1);
            }
//            words = words.entrySet().stream()
//                    .sorted(Comparator.comparingInt(e -> e.getValue()))
//                    .collect(Collectors.toMap((entry) -> entry.getKey(), (entry) -> entry.getValue(),
//                            (a, b) -> { throw new AssertionError(); },
//                            LinkedHashMap::new
//                    ));
//
//            //words.entrySet().forEach(System.out::println);
//            words.put(word.toLowerCase(), count);
        }
        file.close();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String,Integer> words=new HashMap<String, Integer>();

//        File folder = new File("text - en");
//            //read through word which contain all the files
//            CountWords("./text/1.txt",words);
//            System.out.println(words);

        //for loop that goes through each file in the specified dir and calls the CountWords for each file
        File dir = new File("./text - ru");
        for (File file : dir.listFiles()) {
            CountWords(String.valueOf(file),words);
            }//end of for loop

        //code i found online for printing the hashmap in ascending order of values
        List<Map.Entry<String, Integer> > list = new LinkedList<Entry<String, Integer> >(words.entrySet());
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
