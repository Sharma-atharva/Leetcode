class Solution {
    public String compare(String str)
    {
        StringBuilder a=new StringBuilder();
        int n=str.length()-1,count=0;
        while(n>=0)
        {
         char ch=str.charAt(n);
          if(ch=='#')
          {
              count++;
          }
          else
          {
              if(count>0)
              count--;
              else
              a.append(ch);
          }
          n--;
        }
        return a.toString();
    }
    public boolean backspaceCompare(String s, String t) {
      if(compare(s).equals(compare(t)))return true;
      return false; 
    }
}