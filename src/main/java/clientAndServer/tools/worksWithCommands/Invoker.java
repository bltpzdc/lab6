package tools.worksWithCommands;

import commands.Command;
import commands.commandsClasses.withArgsElems.InsertAtCommand;
import commands.commandsClasses.withArgsElems.UpdateCommand;
import commands.commandsClasses.withElements.AddCommand;
import commands.commandsClasses.withElements.RemoveGreaterCommand;
import exeptions.InvalidNameException;
import exeptions.NonArgsExeption;
import exeptions.TooManyArgsException;

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
