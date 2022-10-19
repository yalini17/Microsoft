class Solution {
public List findRepeatedDnaSequences(String s) {   

List<String> answer = new ArrayList<String>();
	
    if(s.length()<=10)
        return answer;
		
    Map<String,Integer> map = new HashMap<String,Integer>();
    StringBuilder txt = new StringBuilder(s.substring(0,10));
    map.put(txt.toString(),map.getOrDefault(txt,0)+1);
    
    for(int i=10;i<s.length();i++){   
        txt.deleteCharAt(0);      
        txt.append(s.charAt(i));
        map.put(txt.toString(),map.getOrDefault(txt.toString(),0)+1); 
    }
    
    for (Map.Entry<String,Integer> entry : map.entrySet()) 
            if(entry.getValue()>1)
                    answer.add(entry.getKey());
    return answer;
}
}
