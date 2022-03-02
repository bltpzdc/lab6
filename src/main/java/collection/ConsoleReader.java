package collection;

import Commands.Invoker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleReader {
    private String[] arraysOfParams;

    public String[] getArrayOfParams(){
        return this.arraysOfParams;
    }

    public ConsoleReader(){
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            arraysOfParams = scanner.nextLine().split(" +");
            //System.out.println(Arrays.toString(arraysOfParams));
            String[] params = {""};
            if (arraysOfParams.length > 1) {
                params = new String[arraysOfParams.length - 1];
                System.arraycopy(arraysOfParams,1,params,0,arraysOfParams.length - 1);
            }

            invoker.findCommand(arraysOfParams[0], params);
        }
    }
}
