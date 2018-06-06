import java.util.*;
import java.io.*;

/*
 * This program parses text files for every word in the file, and will store it in
 * a HashMap with Key of type String, and Value of type Integer. The Key is the
 * word in the text file, and the Value is the number of times it appears in the
 * text file.
 *
 * Author Garrett Filippini
 * Date 5/7/18
 *
 */
public class parser {
    
    /*
     * Prints an array of String to the console.
     * @param arr: is an array of Strings in the text file.
     */
	public static void printArr(String[] arr) {
		for(String str:arr){
			System.out.print(str + " ");
		}
		System.out.println();
	}
	
    /*
     * This method returns a HashMap with the Key's being the words in the text file
     * and the values being the number of times the word appears in the text file.
     * @param arr: is an array of Strings in the text file.
     * @return: returns map, the HashMap.
     */
	public static HashMap<String, Integer> getWordCount(String[] arr) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String str:arr) {
			//System.out.println(str);
			if(!str.contains("//") && !str.contains("\\") && !str.contains("}")
					&& !str.contains("{") && !str.contains(":")) {
				if(map.containsKey(str.toLowerCase())) {
					map.put(str.toLowerCase(), map.get(str.toLowerCase())+1);
				} else {
					map.put(str.toLowerCase(), 1);
				}
			}
		}
		return map;
	}
    
    /*
     * Prints all of the Key's and Value's in the HashMap, which is the words and
     * the frequency of the words in the document.
     * @param map: Is the HashMap of the words in the document.
     */
	public static void printMap(HashMap<String, Integer> map) {
		for(String str: map.keySet()) {
			System.out.println(str + ": " + map.get(str));
		}
	}
    
    /*
     * Sorts the words in the document by frequency.
     * @param arr: Is an array of Word.
     * @return: A sorted array of Word objects by frequency.
     */
    //INCOMPLETE
	public static Word[] sortWord(Word[] arr) {
		Arrays.sort(arr);
		return arr;
	}
    
    public static Word[] getWordArr(HashMap<String, Integer> map) {
        Word[] arr = new Word[map.size()];
        int count = 0;
        for(String str:map.keySet()) {
            arr[count] = new Word(str, map.get(str));
            count++;
        }
        Arrays.sort(arr);
        return arr;
    }
    
    public static void printWords(Word[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].word + ": " + arr[i].frequency);
        }
    }
    
    /*
     * Main method, where we initialize the scanner and document to be loaded
     * into the parser.
     */
	public static void main(String[] args) {
		String output = "";
//		Scanner scan = new Scanner(System.in);
//		output = scan.nextLine();
//		String[] arrOutput = output.split(" ");
//		getWordCount(arrOutput);
        
        //INSERT FILE NAME IN THE QUOTATIONS, MAKE SURE IT IS IN THE SAME DIRECTORY
		File file = new File("Moynihan.txt");
		
		try{
			output = "";
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				output += sc.nextLine();
			}
			String[] arr = output.split(" ");
			HashMap<String, Integer> map = getWordCount(arr);
            Word[] wArr = getWordArr(map);
            printWords(wArr);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    /*
     * Word class that has two fields, frequency and word. Frequency is the number of
     * time the word appears in the document, and word is the String of the word that
     * appears.
     *
     * Author Garrett Filippini
     * Date 5/7/18
     *
     */
	private static class Word implements Comparable<Word>{
	
		public int frequency;
		public String word;
        
        /*
         * Constructor for Word class.
         */
		public Word(String word, int frequency) {
			this.word = word;
			this.frequency = frequency;
		}
        
        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (!(obj instanceof Word)) return false;
            Word that = (Word)obj;
            return this.word.equals(that.word) && this.frequency == that.frequency;
        }
	
        @Override
        public int compareTo(Word that){
            if(this.frequency > that.frequency) {
                return 1;
            } else if (this.frequency <that.frequency) {
                return -1;
            }
            return 0;
        }

	}
}

