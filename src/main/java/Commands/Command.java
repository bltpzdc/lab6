package Commands;

public interface Command {
    public void execute(String[] params);
    public String getName();
}
