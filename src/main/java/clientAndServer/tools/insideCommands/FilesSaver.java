package clientAndServer.tools.insideCommands;

import java.util.List;

public class FilesSaver {
    private final FilesSafe filesSafe;

    public FilesSaver(FilesSafe filesSafe){
        this.filesSafe=filesSafe;
    }

    public void save(String fileName){
        List<String> list = filesSafe.getFileNamesList();
        list.add(fileName);
        filesSafe.setFileNamesList(list);
    }
}
