class kStack{
    int arr[];
    int cap ;
    int freetop , k;
    int top[];
    int next[];
    kStack(int k1,int n){
        arr = new int[n];
        cap = n;
        freetop = 0;
        k = k1;
        top = new int[k];
        next = new int[n];

        for(int i=0;i<k;i++)
          top[i] = -1;
        for(int i=0;i<cap-1;i++)
            next[i] = i+1;
     
        next[cap-1] = -1;
    }
    void push(int x,int sn){
      
         int i = freetop;
         arr[freetop] = x;
         freetop = next[i];
         next[i] = top[sn];
         top[sn] = i;
    }
    int pop(int sn){
        int i = top[sn];
        top[sn] = next[i];
        next[i] = freetop;
        freetop = i;
        return arr[i];
    } 
}
public class KStackInArr {
    public static void main(String[] args) {
     int k = 3,n =10;

     kStack ks = new kStack(k,n);
     ks.push(15, 2); 
        ks.push(45, 2); 
       
        ks.push(17, 1); 
        ks.push(49, 1); 
        ks.push(39, 1); 
       
        ks.push(11, 0); 
        ks.push(9, 0); 
        ks.push(7, 0); 
      
        System.out.println("Popped element from stack 2 is " + ks.pop(2) ); 
        System.out.println("Popped element from stack 1 is " + ks.pop(1) ); 
        System.out.println("Popped element from stack 0 is " + ks.pop(0) );  
    }
}
