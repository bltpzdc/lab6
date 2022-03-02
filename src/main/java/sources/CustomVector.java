package sources;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

public class CustomVector<T> extends Vector<T> {
    private final LocalDate initTime;
    public CustomVector(){
        initTime = LocalDate.now();
    }
    public LocalDate getInitTime(){
        return initTime;
    }
    public void info(){
        String[] listik =  this.getClass().getName().split("\\.");
        System.out.println("Collection information:\n"+
                "Type: "+listik[listik.length-1]+".\n"+
                "Initialize date: "+this.getInitTime()+".\n"+
                "Element count: "+this.size());
    }
    public void add(){
        System.out.println("lol");
    }
}
