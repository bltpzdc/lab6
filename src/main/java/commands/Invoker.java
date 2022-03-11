package commands;

import exeptions.InvalidNameException;
import exeptions.NonArgsExeption;
import exeptions.TooManyArgsException;

public class Invoker {

    public void findCommand(String name, String[] params) throws InvalidNameException, NonArgsExeption, TooManyArgsException {
        if (CommandManager.getCommands().get(name)==null) throw new InvalidNameException();
        else if ((CommandManager.getCommands().get(name).isWithArgs()==true)&&(params[0]=="")){throw new NonArgsExeption();}
        else if ((CommandManager.getCommands().get(name).isWithArgs()==false)&&(params[0]!="")){throw new TooManyArgsException();}
        CommandManager.getCommands().get(name).execute(params);
    }

}
