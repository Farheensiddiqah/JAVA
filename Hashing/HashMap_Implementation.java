package Hashing;
import java.util.*;

public class HashMap_Implementation {
    static class HashMap<K,V> {
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;  //n-size
        private int N;  //buckets.length other size
        private LinkedList<Node> buckets[]; //N = buckets.length;

        //Optional==
        // @SuppressWarnings("unchecked")

        public HashMap(){
            this.N = 4; 
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        //put
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
        }

        private int searchinLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0; //data index

            for(int i=0;i<ll.size();i++){
                Node node  = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N=2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }

            //Nodes  -> add in bucket
            for(int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value){  ///O(lambda) -- O(1)
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); //only two cases valid or not valid

            if(di != -1){ //valid case
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{ //not valid -not exists-add in ll
                buckets[bi].add(new Node(key,value));
                n++; //size
            }

            //To check wheather rehasing is required or not
            double lambda = (double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){ //O(1)
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); //only two cases valid or not valid

            if(di != -1){ //valid case
                return true;
            }else{ //not valid -not exists
                return false;
            }
        }

        public V remove(K key){ //O(1)
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); //only two cases valid or not valid

            if(di != -1){ //valid case
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{ //not valid -not exists
                return null;
            }
        }

        public V get(K key){ //O(1)
            int bi = hashFunction(key);
            int di = searchinLL(key, bi); //only two cases valid or not valid

            if(di != -1){ //valid case
                Node node = buckets[bi].get(di);
                return node.value;
            }else{ //not valid -not exists-add in ll
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node: ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",150);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("Nepal",5);

        ArrayList<String> keys = hm.keySet();
        for(String key: keys){
            System.out.println(key);
        }

        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
