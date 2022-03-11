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
}
