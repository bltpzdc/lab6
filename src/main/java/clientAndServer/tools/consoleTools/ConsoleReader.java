package tools.consoleTools;

import commands.commandsClasses.withArgs.ExecuteScript;
import commands.commandsClasses.withArgs.MpaaFilterCommand;
import commands.commandsClasses.withArgs.RemoveByIdCommand;
import commands.commandsClasses.withArgsElems.InsertAtCommand;
import commands.commandsClasses.withArgsElems.UpdateCommand;
import commands.commandsClasses.withElements.AddCommand;
import commands.commandsClasses.withElements.RemoveGreaterCommand;
import commands.commandsClasses.withoutAll.*;
import exeptions.NonArgsExeption;
import lombok.Getter;
import tools.ClientPacketsSender;
import exeptions.InvalidNameException;

import exeptions.TooManyArgsException;
import lombok.Setter;


import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ConsoleReader {
    @Getter
    private static boolean toExit = false;
    private String[] arraysOfParams;
    @Setter
    private static boolean runnerFlag=true;
    public String[] getArrayOfParams(){
        return this.arraysOfParams;
    }

    public void run(DatagramSocket clientSocket) throws Exception {
        ClientPacketsSender packetsSender = new ClientPacketsSender();
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            arraysOfParams = scanner.nextLine().split(" +");
            String[] params = {""};
            if (arraysOfParams.length > 1) {
                params = new String[arraysOfParams.length - 1];
                System.arraycopy(arraysOfParams,1,params,0,arraysOfParams.length - 1);
            }
            if (params.length<=1) {
                try {
                    switch (arraysOfParams[0]){
                        case ("show"):
                            ShowCommand showCommand = new ShowCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket, showCommand);
                            break;
                        case ("clear"):
                            ClearCommand clearCommand = new ClearCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,clearCommand);
                            break;
                        case ("group_counting_by_id"):
                            GroupCountingIdCommand groupCountingIdCommand = new GroupCountingIdCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,groupCountingIdCommand);
                            break;
                        case ("help"):
                            HelpCommand helpCommand = new HelpCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,helpCommand);
                            break;
                        case ("info"):
                            InfoCommand infoCommand = new InfoCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,infoCommand);
                            break;
                        case ("print_descending"):
                            PrintDescendingCommand printDescendingCommand = new PrintDescendingCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,printDescendingCommand);
                            break;
                        case ("history"):
                            HistoryCommand historyCommand= new HistoryCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,historyCommand);
                            break;
                        case ("exit"):
                            toExit = true;
                            break;
                        case ("execute_script"):
                            ExecuteScript executeScript = new ExecuteScript(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,executeScript);
                            break;
                        case ("filter_less_than_mpaa_rating"):
                            MpaaFilterCommand mpaaFilterCommand = new MpaaFilterCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,mpaaFilterCommand);
                            break;
                        case ("remove_by_id"):
                            RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,removeByIdCommand);
                            break;
                        case ("add"):
                            AddCommand addCommand = new AddCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,addCommand);
                            break;
                        case ("remove_greater"):
                            RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,removeGreaterCommand);
                            break;
                        case ("insert_at"):
                            InsertAtCommand insertAtCommand = new InsertAtCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,insertAtCommand);
                            break;
                        case ("update"):
                            UpdateCommand updateCommand = new UpdateCommand(arraysOfParams[0], params[0]);
                            packetsSender.send(clientSocket,updateCommand);
                            break;
                        default:
                            throw new InvalidNameException();
                    }
                } catch (InvalidNameException | NonArgsExeption | TooManyArgsException | IllegalArgumentException | IOException e) {
                    System.out.println(e.getMessage());
                    throw new Exception();
                }
            }
            else{
                System.out.println("Too many parameters. Use \"help\" to get a list of available commands.");
            }
            /*scanner.close();*/
        }
    }
}
