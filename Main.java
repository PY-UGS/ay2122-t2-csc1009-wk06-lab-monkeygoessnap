import java.util.*;

public class Main {

    static void addAndSortLL(LinkedList<Integer>ll, int value) {
        ll.add(value);
        ll.sort(null);
    }

    static void swapValuesLL(LinkedList<Integer>ll, int indexOne, int indexTwo) {
        int val1, val2;
        try {
            val1 = ll.get(indexOne);
            val2 = ll.get(indexTwo);
        } catch (Exception e) {
            return;
        }
        ll.set(indexOne, val2);
        ll.set(indexTwo, val1);
    }

    static int findIndexLL() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        Random random = new Random();
        for (int i=0;i<500;i++){
            ll.add(random.nextInt(1000,10000));
        }
        int toCheck = random.nextInt(1000,10000);
        System.out.println("Finding index of: "+ toCheck);
        return ll.indexOf(toCheck);
    }

    static void printSortedHM(HashMap<Integer,Integer>hm) {
        System.out.print("List: ");
        for (int i=0;i<hm.size();i++){
            System.out.print(hm.get(i) + " ");
        }
        System.out.println();
    }

    static void addAndSortHM(HashMap<Integer, Integer>hm, int value) {
        //add
        hm.put(hm.size(),value);
        //sort
        List<Integer> list = new ArrayList<Integer>(hm.values());
        list.sort(null);
        for (int i=0;i<list.size();i++) {
            hm.put(i,list.get(i));
        }
    }

    static void swapValuesHM(HashMap<Integer, Integer>hm, int indexOne, int indexTwo) {
        Integer val1 = hm.get(indexOne);
        Integer val2 = hm.get(indexTwo);
        if (val1.equals(null)|| val2.equals(null)) {
            return;
        }
        hm.put(indexOne, val2);
        hm.put(indexTwo, val1);
    }

    static int findIndexHM() {
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        Random random = new Random();
        for (int i=0;i<500;i++) {
            hm.put(i, random.nextInt(1000,10000));
        }
        Integer toCheck = random.nextInt(1000,10000);
        System.out.println("Finding index of: "+toCheck);
        for (Map.Entry<Integer,Integer> m : hm.entrySet()){
            if (toCheck.equals(m.getValue())) {
                return m.getKey();
            };
        }
        return -1;
    }

    public static void main(String[] args) {

        //init LL
        LinkedList<Integer> ll = new LinkedList<Integer>();

        //original given list using LinkedList
        for (int i=1;i<12;i+=2) {
            ll.add(i);
        }
        System.out.print("Original List: " + ll + "\n");

        //addAndSort using LinkedList
        int val = 2;
        addAndSortLL(ll,val);
        System.out.print("After adding and sorting "+ val + ": " + ll + "\n\n");

        //swapValues using LinkedList
        System.out.print("Original List: " + ll + "\n");
        int indexOne = 0, indexTwo = 2;
        swapValuesLL(ll, indexOne, indexTwo);
        System.out.print("After swapping index " + indexOne + " and " + indexTwo + ": " + ll + "\n\n");

        //findIndex using LinkedList
        System.out.print("Index: " + findIndexLL() + "\n\n");

        //init HashMap
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=1,j=0;i<12;i+=2,j++){
            hm.put(j,i);
        }

        //original given list into Map form
        System.out.print("Original HashMap: ");
        printSortedHM(hm);

        //addAndSort using HashMap
        addAndSortHM(hm, val);
        System.out.print("HashMap after adding and sorting "+ val + ": ");
        printSortedHM(hm);
        System.out.println();

        //swapValues using HashMap
        System.out.print("Original HashMap: ");
        printSortedHM(hm);
        System.out.print("HashMap after swapping index " + indexOne + " and " + indexTwo + ": ");
        swapValuesHM(hm, indexOne, indexTwo);
        printSortedHM(hm);
        System.out.println();

        //findIndex using HashMap
        System.out.print("Index: " + findIndexHM() + "\n\n");
    }
}
