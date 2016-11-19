import java.util.ArrayList;

/**
 * Created by himanshu on 8/28/16.
 */
enum LINE_TYPE {STACK, QUEUE};
public class Line {

    LINE_TYPE type;
    ArrayList<Person> line;
    public Line(LINE_TYPE type){
        this.type = type;
        line = new ArrayList<Person>();

    }

    public void add(Person p){
        if(this.type == LINE_TYPE.QUEUE){
            line.add(p);    //add to end of list
        }
    }

    public void service(){
        if(this.type == LINE_TYPE.QUEUE){
            line.remove(0);
        }
    }

    public int numPeopleAhead(){
        if(this.type == LINE_TYPE.QUEUE){
            return this.line.size();
        } else {
            return 0;
        }
    }
}
