class Solution {
    public int firstUniqChar(String s) {
     HashMap<Character,Integer> map = new HashMap<>();
     Queue<Character> q = new LinkedList<>();
     for(char ch : s.toCharArray()){
         map.put(ch,map.getOrDefault(ch,0)+1);
         q.offer(ch);
     }
     while(!q.isEmpty()&&map.get(q.peek())>1){
          q.poll();
     }

    return (q.isEmpty())?-1:s.indexOf(q.peek());
    }
}
