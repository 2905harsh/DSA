class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String ele : strs){
            String temp = getSortedString(ele);
             if(map.containsKey(temp)){
                map.get(temp).add(ele);

             }
             else{
                map.put(temp,new ArrayList<>(List.of(ele)));
             }

        }
        return new ArrayList<>(map.values());
    }

    public String getSortedString(String s){
        int []smallAlphabets = new int[26];
        for(char ch : s.toCharArray()){
            smallAlphabets[ch-97] += 1;
        }
        String ans ="";
        for(int i =0;i<26;i++){
            int count = smallAlphabets[i];
            if(count>=1){
                while(count>0){
                    ans+=(char)(97 + i);
                    count--;
                }
            }
        }
        return ans;
}
}
