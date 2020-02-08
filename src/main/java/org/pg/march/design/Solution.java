package org.pg.march.design;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys(int numToys, 
	                                      int topToys, 
                                          List<String> toys, 
										  int numQuotes, 
										  List<String> quotes)
    {
        // WRITE YOUR CODE HERE
        if(toys == null || toys.size() == 0 || quotes == null){
            return new ArrayList<String>();
        }
        Set<String> toySet = new HashSet<>(toys);
        Map<String, Integer> map = new HashMap<>(toySet.size());
        for(String quote : quotes){
            String[] keywords = quote.split(" ");
            Set<String> keyWordSet = new HashSet<>(Arrays.asList(keywords));
            for(String keyword : keyWordSet){
                if(keyword != null && !keyword.trim().isEmpty()){
                    keyword = keyword.trim().toLowerCase();
                    if(toySet.contains(keyword)){
                        map.put(keyword, map.getOrDefault(keyword, 0) + 1);
                    }
                }
            }
        }
        Comparator<Tuple> comparator = new Comparator<Tuple> (){
            @Override
            public int compare(Tuple t1, Tuple t2){
                if(t1.count == t2.count){
                    return t1.val.compareTo(t2.val);
                }
                return Integer.compare(t2.count, t1.count);
            }
        };
        PriorityQueue<Tuple> pq = new PriorityQueue<>(comparator);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(new Tuple(entry.getKey(), entry.getValue()));
        }
        ArrayList<String> res = new ArrayList<>();
        while(topToys > 0 && !pq.isEmpty()){
            res.add(pq.poll().val);
        }
        return res;
    }
    
    private static class Tuple{
        private String val;
        private int count;
        
        public Tuple(String val, int count){
            this.val = val;
            this.count = count;
        }
    }
    // METHOD SIGNATURE ENDS
}