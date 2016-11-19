import java.util.ArrayList;

/**
 * Created by himanshu on 10/16/16.
 */
public class RearrangeArray {

    public static void encode(ArrayList<Integer> arr){
        int n = arr.size();
        for(int i=0;i<n;i++){
            int originalVal = arr.get(i) % n;
            int valToEncode = arr.get(originalVal) % n;

            int encoded = originalVal + (valToEncode % n)*n;
            arr.set(i, encoded);
            System.out.println(encoded);
        }
    }

    public static void reproduceOriginal(ArrayList<Integer> encoded){
        int n = encoded.size();
        System.out.printf("ORIGINAL: ");
        for(int i =0;i<n;i++){
            System.out.printf("%d ", encoded.get(i)%n);
        }
        System.out.println("");
    }

    public static void getEncodedVals(ArrayList<Integer> encoded){
        int n = encoded.size();
        System.out.printf("ENCODED VALS: ");
        for(int i =0;i<n;i++){
            System.out.printf("%d ", encoded.get(i)/n);
        }
        System.out.println("");
    }

    public static ArrayList<Integer> arrToList(int[] arr){
        ArrayList<Integer> out = new ArrayList<Integer>();
        for(Integer i: arr) out.add(i);
        return out;
    }

    public static void rearrange(ArrayList<Integer> a){
        int n = a.size();
        for(int i=0;i<n;i++){
            int originalVal = a.get(i) % n;
            int valToEncode = a.get(originalVal) % n;

            int encoded = originalVal + (valToEncode % n)*n;
            a.set(i, encoded);
        }

        for(int i =0;i<n;i++){
            a.set(i, a.get(i)/n);
        }
    }

    public static void main(String args[]) {

        ArrayList<Integer> original = arrToList(new int[]{1, 2, 3, 0});
        System.out.println(original);
        //vals to encode: [2 3 0 1]
        rearrange(original);
        System.out.println(original);
    }

}
