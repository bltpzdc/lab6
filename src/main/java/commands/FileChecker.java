package commands;

import java.util.Objects;

public class FileChecker {
    private final FilesSafe filesSafe;

    public FileChecker(FilesSafe filesSafe){
        this.filesSafe=filesSafe;
    }

    public boolean check(String fileName){
        int sch=0;
        for (String i:filesSafe.getFileNamesList()){
            if (Objects.equals(fileName, i)){sch++;}
        }
        if (sch==0){return true;}
        else{return false;}
    }
}
