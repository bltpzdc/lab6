package clientAndServer.tools.worksWithCommands;

import clientAndServer.commands.Command;
import clientAndServer.exeptions.InvalidNameException;
import clientAndServer.exeptions.NonArgsExeption;
import clientAndServer.exeptions.TooManyArgsException;

public class Invoker {

    public Command findCommand(String name, String[] params) throws InvalidNameException, NonArgsExeption, TooManyArgsException {
        if (CommandManager.getCommands().get(name)==null) throw new InvalidNameException();
        else if ((CommandManager.getCommands().get(name).isWithArgs()==true)&&(params[0]=="")){throw new NonArgsExeption();}
        else if ((CommandManager.getCommands().get(name).isWithArgs()==false)&&(params[0]!="")){throw new TooManyArgsException();}
        Command com = CommandManager.getCommands().get(name);
        com.setParams(params[0]);
        return com;
    }

    public void execute(Command command){
        if (command.isWithElement()&&!command.isWithArgs()){
            CommandManager.getCommands().get(command.getName()).execute(command.getMovie());
        }
        else if (command.isWithArgs()&&command.isWithElement()){
            CommandManager.getCommands().get(command.getName()).execute(command.getParams(), command.getMovie());
        }
        else {
            CommandManager.getCommands().get(command.getName()).execute(command.getParams());
        }
    }
}
