import java.util.ArrayList;

/**
 * Created by himanshu on 8/28/16.
 */
public class Person {
    /*
    * A Person has
    *   * desire for a good [0-99]
    *   * patience to wait in a given line [0-99]
    * A Person can
    *   * estimate how long a line is given the number of people already in the line
    *   * determine whether to wait in a line or not
    *
    * */

    public int desire;
    public int patience;
    public Person(int desire, int patience){
        this.desire = desire;
        this.patience = patience;
    }

    public int estimateWaitTime(Line line){
        return line.numPeopleAhead();
    }

    public boolean waitOrNot(Line line){
        return this.patience + this.desire > this.estimateWaitTime(line);
    }

    public void wait(Line line){
        line.add(this);
    }
}
