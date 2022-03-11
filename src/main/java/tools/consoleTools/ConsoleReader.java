package tools.consoleTools;

import tools.insideCommands.HistorySaver;
import tools.worksWithCommands.Invoker;
import exeptions.InvalidNameException;
import exeptions.NonArgsExeption;
import exeptions.TooManyArgsException;
import lombok.Setter;

import java.util.Scanner;

public class ConsoleReader {
    private String[] arraysOfParams;
    @Setter
    private static boolean runnerFlag=true;
    public String[] getArrayOfParams(){
        return this.arraysOfParams;
    }

    public void run(){
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);
        while(runnerFlag&&(scanner.hasNext())){
            arraysOfParams = scanner.nextLine().split(" +");
            String[] params = {""};
            if (arraysOfParams.length > 1) {
                params = new String[arraysOfParams.length - 1];
                System.arraycopy(arraysOfParams,1,params,0,arraysOfParams.length - 1);
            }
            if (params.length<=1) {
                try {
                    invoker.findCommand(arraysOfParams[0], params);
                    HistorySaver saver = new HistorySaver();
                    saver.save(arraysOfParams[0]);
                } catch (InvalidNameException | NonArgsExeption | TooManyArgsException e) {
                    System.out.println(e.getMessage());
                }
            }
            else{
                System.out.println("Too many parameters. Use \"help\" to get a list of available commands.");
            }
        }
    }
}
