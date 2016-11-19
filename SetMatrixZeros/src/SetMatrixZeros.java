import java.util.ArrayList;

/**
 * Created by himanshu on 8/30/16.
 */
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        //handle 0x0
        if(a == null || a.size() == 0 || a.get(0).size() == 0){
            return;
        }
        boolean topRowHasZeros = false;
        boolean leftColHasZeros = false;
        if(a.get(0).get(0) == 0){
            topRowHasZeros = true;
            leftColHasZeros = true;
        } else {
            for(int i=0; i< a.size();i++){
                if(a.get(i).get(0) == 0) leftColHasZeros = true;
            }
            for(int j=0; j< a.get(0).size();j++){
                if(a.get(0).get(j) == 0) topRowHasZeros = true;
            }
        }


        //set init values
        for(int i = 1;i<a.size();i++){
            for(int j=1;j<a.get(i).size();j++){
                int cur = a.get(i).get(j);
                if(cur == 0){
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }


        //rows
        for(int i = 1; i<a.size(); i++){
            if(a.get(i).get(0) == 0 ){
                for(int j = 0; j< a.get(i).size(); j++){
                    a.get(i).set(j, 0);
                }
            }
        }

        //cols
        for(int j = 1; j<a.get(0).size(); j++){
            if(a.get(0).get(j) == 0 ){
                for(int i = 0; i< a.size(); i++){
                    a.get(i).set(j, 0);
                }
            }
        }


        //top left
        if(a.get(0).get(0) == 0){
            //top row
            for(int i=0;i<a.get(0).size();i++) a.get(0).set(i,0);
            //top col
            for(int i =0; i< a.size();i++) a.get(i).set(0,0);
        }

        if(topRowHasZeros){
            for(int i=0;i<a.get(0).size();i++) a.get(0).set(i,0);
        }
        if(leftColHasZeros){
            for(int i =0; i< a.size();i++) a.get(i).set(0,0);
        }




    }
}
