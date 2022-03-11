package commands;

public interface Command {
    public void execute(String[] params);
    public String getName();
    public boolean isWithElement();
    public boolean isWithArgs();
}
