package telran.interview;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int [] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while(index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }
    static public int getMaxWithNegativePresentation(int [] array) {
        //returns maximal positive value for which exists negative one with the same abs value
        //if no pair of positive and negative values with the same abs value the method returns -1
        //complexity O[N] only one pass over the elements
        int res = -1;
        HashSet<Integer> helper = new HashSet<>();
        for(int num: array){
            if(helper.contains(-num)) {
                res = Math.max(Math.abs(num), res);
            }
            helper.add(num);
        }
        return res;
    }
    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
		List<LocalDate> dates) {
    //rolesHistory is the list containg dates and roles assigned to the employees at the appropriate dates
    //for example, date => 2019-01-01, role => Developer means that some employee (no matter who) was taken
    //role Developer at 2019-01-01
	//create List<DateRole> with roles matching with the given dates
	//most effective data structure
   TreeMap<LocalDate, String> historyMap = rolesHistory.stream().collect(Collectors.toMap(DateRole::date, DateRole::role, (v1, v2) -> v2, TreeMap::new));
   return dates.stream().map(d -> {
    var entry = historyMap.floorEntry(d);
    return entry == null ? new DateRole(d, null) : new DateRole(d, entry.getValue());
   }).toList();
}
public static boolean isAnagram(String word, String anagram) {
	
	//returns true if "anagram" string contains all
	// letters from "word" in another order (case sensitive)
	//O[N] (sorting is disallowed)
    boolean res = false;
    if(word.length() == anagram.length() && !word.equals(anagram)) {
        HashMap<Integer,Integer> lettersMap = getLettersMap(word);
    res =  checkAnagram(anagram, lettersMap);
    }
    
    return res;
}
private static boolean checkAnagram(String anagram, HashMap<Integer, Integer> lettersMap) {
   /* Java -7 */ 
    // int index = 0;
    // char[] letters = anagram.toCharArray();
    // Integer count = 0;
    // while(index < letters.length && (count = lettersMap.getOrDefault(letters[index], 0)) != 0) {
    //     lettersMap.put(letters[index], count - 1);
    //     index++;
    // }
    // return index == letters.length;
    /* Java - 8+ */
    return anagram.chars().allMatch(code -> lettersMap.compute(code, (k, v) -> v == null ? -1 : v - 1) > -1);
}
private static HashMap<Integer, Integer> getLettersMap(String word) {
   /* Java-7 */
//    HashMap<Character, Integer> res = new HashMap<>();
//    for(char letter: word.toCharArray()) {
//         Integer count = res.getOrDefault(letter, 0);
//         res.put(letter, count + 1);
//    }
//    return res;
 /*java 8+ */
 HashMap<Integer, Integer> resMap = new HashMap<>();
 word.chars().forEach(code -> resMap.merge(code, 1, Integer::sum));
 return resMap;
}
    
}
