package collection;

import commands.*;
import commands.FileReader;
import exeptions.InvalidNameException;
import exeptions.NonArgsExeption;
import exeptions.TooManyArgsException;
import lombok.Getter;
import sources.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CollectionManager {
    @Getter
    private CustomVector<Movie> movieList;
    private UserInput userInput = new UserInput();
    private CollectionLoader loader;

    public CollectionManager(CollectionLoader loader){
        this.loader=loader;
        movieList=loader.getMovieList();
    }

    public void info(){
        String[] listik =  movieList.getClass().getName().split("\\.");
        System.out.println("Collection information:\n"+
                "Type: "+listik[listik.length-1]+".\n"+
                "Initialize date: "+movieList.getInitTime()+".\n"+
                "Element count: "+movieList.size());
    }

    public void show(){
        for (Movie i:movieList){
            System.out.println(i);
        }
        if (movieList.size()==0){
            System.out.println("There's no any elements in collection.");
        }
    }

    public void add(){
        System.out.println("Adding new element...");

        boolean fCreatedObj = false;
        var newElementBuilder = Movie.builder();
        Movie newElement = null;

        int id;
        ArrayList<Integer> idList = new ArrayList<>();
        if (movieList.size()>0) {
            for (Movie i : movieList) {
                idList.add(i.getID());
            }
            id = Collections.max(idList) + 1;
        }
        else {id=1;}
        newElementBuilder.id(id);
        newElementBuilder.creationDate(LocalDate.now());

        while (!fCreatedObj){
            String nameOfElement = userInput.getString("Enter name:");
            newElementBuilder.name(nameOfElement);
            double x = userInput.getDoubleX("Enter x coordinate (it can be only double):");
            float y = userInput.getFloatY("Enter y coordinate (it can be only double):");
            newElementBuilder.coordinates(new Coordinates(x, y));
            long oscarsCount = userInput.getLong("Enter oscars count (it can be only long): ");
            newElementBuilder.oscarsCount(oscarsCount);
            MovieGenre genre = userInput.getMovieGenre("Enter movie genre.\nChoose ACTION, MUSICAL or TRAGEDY:");
            newElementBuilder.genre(genre);
            MpaaRating mpaaRating = userInput.getMpaaRating("Enter mpaa rating. \nChoose G, PG, PG_13 or R:");
            newElementBuilder.mpaaRating(mpaaRating);
            String dirName = userInput.getString("Enter director's name:");
            Date birthday = userInput.getDate("Enter birthday of director (pattern \"dd-mm-yyyy\" (day-month-year)): ");
            EyeColor dirEyes = userInput.getEyeColor("Enter color of director's eyes.\nChoose GREEN, BLUE, ORANGE or BROWN:");
            HairColor dirHairs = userInput.getHairColor("Enter color of director's hairs.\nChoose RED, BLUE, ORANGE or BROWN:");
            Country country = userInput.getCountry("Enter nationality of director.\nChoose ITALY, SOUTH_KOREA or JAPAN");
            newElementBuilder.director(new Person(dirName, birthday, dirEyes, dirHairs, country));
            movieList.add(newElementBuilder.build());
            fCreatedObj=true;
        }
        Collections.sort(movieList);
        System.out.println("New element has been added to collection.");
    }

    public void update(int id){
        int needUpdate=0;
        for (Movie sch:movieList){
            if (sch.getID()==id) {needUpdate+=1;}
        }
        if ((needUpdate==0)&&(id>=0)){
            System.out.println("There is no any elements with this ID.");
        }
        if (needUpdate>0) {
            movieList.removeIf(i -> i.getID() == id);

            boolean fCreatedObj = false;
            var newElementBuilder = Movie.builder();
            Movie newElement = null;

            newElementBuilder.id(id);
            newElementBuilder.creationDate(LocalDate.now());

            while (!fCreatedObj) {
                String nameOfElement = userInput.getString("Enter name:");
                newElementBuilder.name(nameOfElement);
                double x = userInput.getDoubleX("Enter x coordinate (it can be only double):");
                float y = userInput.getFloatY("Enter y coordinate (it can be only double):");
                newElementBuilder.coordinates(new Coordinates(x, y));
                long oscarsCount = userInput.getLong("Enter oscars count (it can be only long): ");
                newElementBuilder.oscarsCount(oscarsCount);
                MovieGenre genre = userInput.getMovieGenre("Enter movie genre.\nChoose ACTION, MUSICAL or TRAGEDY:");
                newElementBuilder.genre(genre);
                MpaaRating mpaaRating = userInput.getMpaaRating("Enter mpaa rating. \nChoose G, PG, PG_13 or R:");
                newElementBuilder.mpaaRating(mpaaRating);
                String dirName = userInput.getString("Enter director's name:");
                Date birthday = userInput.getDate("Enter birthday of director (pattern \"dd-mm-yyyy\" (day-month-year)): ");
                EyeColor dirEyes = userInput.getEyeColor("Enter color of director's eyes.\nChoose GREEN, BLUE, ORANGE or BROWN:");
                HairColor dirHairs = userInput.getHairColor("Enter color of director's hairs.\nChoose RED, BLUE, ORANGE or BROWN:");
                Country country = userInput.getCountry("Enter nationality of director.\nChoose ITALY, SOUTH_KOREA or JAPAN");
                newElementBuilder.director(new Person(dirName, birthday, dirEyes, dirHairs, country));
                movieList.add(newElementBuilder.build());
                fCreatedObj = true;
            }
            System.out.println("Element has been updated.");
        }
    }

    public void remove(int id){
        int needRemove=0;
        for (Movie mo:movieList){
            if (mo.getID()==id){needRemove+=1;}
        }
        if ((needRemove==0)&&(id>=0)){
            System.out.println("There is no any elements with this ID.");
        }
        if (needRemove>0) {
            movieList.removeIf(i -> i.getID() == id);
            System.out.println("Element has been deleted from collection.");
        }
    }
    public void clear(){
        movieList.clear();
        System.out.println("All elements have been deleted from collection.");
    }
    public void help(){
        System.out.println("Commands :\n"+
                "info : collection information.\n"+
                "show : all elements of collection.\n"+
                "add {element} : add new element in collection.\n"+
                "update id {element} : update element value by its id.\n"+
                "remove_by_id id : delete element from collection by its id.\n"+
                "clear : delete all elements from collection.\n"+
                "save : save collection to the file.\n"+
                "execute_script file_name : read and execute script from the file.\n"+
                "exit : exit without saving collection to the file.\n"+
                "insert_at index {element} : add new element to the specified index.\n"+
                "remove_greater {element} : remove all elements that exceed the specified.\n"+
                "history : show last 8 commands without their arguments.\n"+
                "group_counting_by_id : group collection elements by their id and show count of elements in every group.\n"+
                "filter_less_than_mpaa_rating mpaaRating : show elements with mpaa rating lower than specified.\n"+
                "print_descending : show elements in descending order.");
    }
    public void save(){
        CollectionSaver saver = new CollectionSaver(this);
        saver.save();
    }
    public void insertAt(int index){
        if ((index>-1)&&(index<movieList.size())) {
            System.out.println("Adding new element...");
            boolean fCreatedObj = false;
            var newElementBuilder = Movie.builder();
            Movie newElement = null;

            int id;
            ArrayList<Integer> idList = new ArrayList<>();
            if (movieList.size() > 0) {
                for (Movie i : movieList) {
                    idList.add(i.getID());
                }
                id = Collections.max(idList) + 1;
            } else {
                id = 1;
            }
            newElementBuilder.id(id);
            newElementBuilder.creationDate(LocalDate.now());

            while (!fCreatedObj) {
                String nameOfElement = userInput.getString("Enter name:");
                newElementBuilder.name(nameOfElement);
                double x = userInput.getDoubleX("Enter x coordinate (it can be only double):");
                float y = userInput.getFloatY("Enter y coordinate (it can be only integer):");
                newElementBuilder.coordinates(new Coordinates(x, y));
                long oscarsCount = userInput.getLong("Enter oscars count (it can be only long): ");
                newElementBuilder.oscarsCount(oscarsCount);
                MovieGenre genre = userInput.getMovieGenre("Enter movie genre.\nChoose ACTION, MUSICAL or TRAGEDY:");
                newElementBuilder.genre(genre);
                MpaaRating mpaaRating = userInput.getMpaaRating("Enter mpaa rating. \nChoose G, PG, PG_13 or R:");
                newElementBuilder.mpaaRating(mpaaRating);
                String dirName = userInput.getString("Enter director's name:");
                Date birthday = userInput.getDate("Enter birthday of director (pattern \"dd-mm-yyyy\" (day-month-year)): ");
                EyeColor dirEyes = userInput.getEyeColor("Enter color of director's eyes.\nChoose GREEN, BLUE, ORANGE or BROWN:");
                HairColor dirHairs = userInput.getHairColor("Enter color of director's hairs.\nChoose RED, BLUE, ORANGE or BROWN:");
                Country country = userInput.getCountry("Enter nationality of director.\nChoose ITALY, SOUTH_KOREA or JAPAN");
                newElementBuilder.director(new Person(dirName, birthday, dirEyes, dirHairs, country));
                movieList.add(index, newElementBuilder.build());
                fCreatedObj = true;
            }
            System.out.println("New element has been added to collection.");
        }
        else if (index>0){
            System.out.println("Index is bigger than you can enter. Please, enter index from 0 to "+(movieList.size()-1)+".");
        }
        else if (index<1){
            System.out.println("Index can not be lower than 0. Please, enter index from 0 to "+(movieList.size()-1)+".");
        }
    }
    public void removeGreater(){
        UserInput userInput = new UserInput();
        int id = userInput.getInt("Enter ID. All elements with ID bigger than introduced will be deleted.");
        movieList.removeIf(nextMovie -> nextMovie.getID() > id);
        System.out.println("Elements have been deleted.");
    }
    public void mpaaRatingFilter(MpaaRating mpaaRating){
        MpaaRatingComparator comparator = new MpaaRatingComparator();
        int sch=0;
        for (Movie i:movieList){
            if (comparator.getIntValue(i.getMpaaRating())<comparator.getIntValue(mpaaRating)){
                System.out.println(i);
                sch+=1;
            }
        }
        if (sch==0){
            System.out.println("No elements with mpaa rating lower than introduced.");
        }
    }
    public void printDescending(){
        for (int i=movieList.size()-1;i>-1; i-=1){
            System.out.println(movieList.get(i));
        }
    }
    public void exit(){
        ConsoleReader.setRunnerFlag(false);
    }
    public void history(){
        if (HistorySafe.getHistory().isEmpty()){
            System.out.println("You have not entered commands yet");
        }
        else{
            String outPut="Last commands (from 1 to 8):\n";
            for (String i:HistorySafe.getHistory()){
                outPut = outPut+i+" ";
            }
            System.out.println(outPut);
        }
    }
    public void groupCountingId(){
        List<Movie> d2 = new ArrayList<>();
        List<Movie> ud2 = new ArrayList<>();
        for (Movie i:movieList){
            if (i.getID()%2==0){d2.add(i);}
            else{ud2.add(i);}
        }
        System.out.println("2 groups were created.\n" +
                "Count of group 1 (elements with ID which is divisible by 2):"+d2.size()+"\n" +
                "Count of group 2 (elements with ID which is not divisible by 2):"+ud2.size());
    }
    public void executeScript(String fileName) {
        FilesSafe filesSafe = new FilesSafe();
        FilesSaver filesSaver = new FilesSaver(filesSafe);
        String[] arrayOfParams;
        //String[] params={""};
        FileReader reader = new FileReader();
        FileChecker fileChecker = new FileChecker(filesSafe);
        if (fileChecker.check(fileName)) {
            reader.read(fileName);
            filesSaver.save(fileName);
            Invoker invoker = new Invoker();
            for (String i : reader.getCommandsList()) {
                String[] params={""};
                arrayOfParams = i.split(" +");
                if (arrayOfParams.length > 1) {
                    params = new String[arrayOfParams.length - 1];
                    System.arraycopy(arrayOfParams, 1, params, 0, arrayOfParams.length - 1);
                }
                if (params.length <= 1) {
                    try {
                        invoker.findCommand(arrayOfParams[0], params);
                        HistorySaver historySaver = new HistorySaver();
                        historySaver.save(arrayOfParams[0]);
                    } catch (InvalidNameException | NonArgsExeption | TooManyArgsException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Too many parameters. Use \"help\" to get a list of available commands.");
                }
            }
        }
        else{
            System.out.println("File recursion found.");
        }
        FilesSafe.setFileNamesList(new ArrayList<String>());
    }
}
