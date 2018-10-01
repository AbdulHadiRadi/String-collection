
public class WordStoreImp implements WordStore
{
    private Dictionary[] storedWords;
    private int count; 
    public WordStoreImp(int length){
        storedWords = new Dictionary [length];
        count = 0;
    }
    public void expand (){
        Dictionary[] temporaryWords = storedWords;
        storedWords = new Dictionary[temporaryWords.length*2];
        for(int i=0; i<temporaryWords.length; i++){
            for(; temporaryWords[i]!= null; temporaryWords[i] = temporaryWords[i].next){
                int position = getIndex(temporaryWords[i].first);  
                storedWords[position] = new Dictionary (temporaryWords[i].first, storedWords[position]);
            }
        }
    }     
    public void add(String word){     
       // if(count / storedWords.length==0.2) expand(); 
        int position = getIndex(word);
        if(storedWords[position]==null){
         storedWords[position] = new Dictionary (word, null);
         count++;
        }
        else{
             Dictionary ptr = storedWords[position];
          for(; ptr!=null; ptr = ptr.next){
            if(ptr.first.equals(word))
                ptr.Ccount++;
                break;
          }
          storedWords[position] = new Dictionary (word, storedWords[position]);
      }
    }
    public int count(String word){
        int position = getIndex(word);
        if(storedWords[position]== null) return 0;
        if(storedWords[position].first.equals(word))return storedWords[position].Ccount;
        Dictionary ptr = storedWords[position];
        for(; ptr.next!=null; ptr = ptr.next){
            if(ptr.next.first.equals(word))
               return ptr.Ccount;
        }
        return 0; 
    }
    public void remove (String word){
       /* int position = getIndex(word);
        if(storedWords[position]== null) return;
        if(storedWords[position].first.equals(word)){
            storedWords[position] = storedWords[position].next; 
        }
        else{   
            Dictionary ptr = storedWords[position];
            for(; ptr.next!=null; ptr = ptr.next){ 
                if(ptr.next.first.equals(word)){
                    ptr.next = ptr.next.next;
                    break;
                }
            }
        }*/
           int position = getIndex(word);
        if(storedWords[position]== null) return;    
        else{
            Dictionary ptr = storedWords[position];
           for(; ptr!=null; ptr = ptr.next){
            if(ptr.first.equals(word))
                ptr.Ccount--;
           }
        }
    }
    private int getIndex(String word){
        int pos = 13;
        int size = storedWords.length;
        for(int i=0; i<word.length(); i++){
            pos = pos + word.charAt(i)*31^i;
        }
        return pos % size;
    }
    private static class Dictionary 
    {
        String first;
        Dictionary next;
        int Ccount;
        Dictionary(String first,Dictionary next)
        {
            this.first = first ;
            this.next = next ;
            Ccount = 1;
        }
    }
}
