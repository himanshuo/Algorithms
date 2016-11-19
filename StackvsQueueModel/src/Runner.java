import java.util.ArrayList;

/**
 * Created by himanshu on 8/28/16.
 */
public class Runner {
    public static void main(String [] args){
        Line line = new Line(LINE_TYPE.STACK);
        final int PERSON_COUNT = 100;   // people
        final int TIME = 100;           // sec
        final int SERVICE_RATE = 10;    // people/sec
        final int ARRIVAL_RATE = 10;    // people/sec
        int num_persons_left = 0;
        for(int t =0; t < TIME; t++){
            //service from line
            for(int i=0; i<SERVICE_RATE; i++){
                line.service();
            }
            //additions to line
            for(int i=0; i< ARRIVAL_RATE;i++){
                int desire = (int)(Math.random() * 100);
                int patience = (int)(Math.random() * 100);
                Person p = new Person(desire, patience);
                if(p.waitOrNot(line)){
                 line.add(p);
                }

            }
        }
    }
}
