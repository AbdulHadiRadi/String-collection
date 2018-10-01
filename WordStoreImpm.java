public class  WordStoreImpm implements WordStore
{
    private String [] words;
    private int [] num;
    private int count;
    //constructor
   public WordStoreImpm(int number){
     words = new String [number];
     num = new int [number]; 
     count = 0;
   }
   public void expand(){
       String [] words1 = new String [words.length*2];
       for(int i = 0; i < words.length; i++){
           words1[i] = words[i];
        }
        words = words1;
       int [] num1 = new int [num.length*2];
       for(int i = 0; i < num.length; i++){
           num1[i] = num[i];
        }
       num = num1;
    }
   public void add(String word){     
       if(count == words.length) expand();
       if(!repeatedWord(word))
       {
           words[count] = word;
           num[count] = 1;
           count++;
       }
      
   }
   private boolean repeatedWord(String word){
       for(int i=0; i<count; i++){
           if(words[i].equals(word)){
               num[i] = num[i]+1;
               return true;
            }
        }
       return false;
    }
    //Returns the number of times a String is in the collection 
   public int count(String word){
       for(int i=0; i<count; i++){
           if(words[i].equals(word)) return num[i];
        }
        return 0;
    }
   public void remove (String word){
       for(int i=0; i<count; i++){
           if(words[i].equals(word)) {
               num[i] = num[i]-1;
        }
    } 
   }
}
