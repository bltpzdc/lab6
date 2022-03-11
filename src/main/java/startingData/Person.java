package startingData;

import java.util.Date;

public class Person {
    private String name;
    private java.util.Date birthday;
    private EyeColor eyeColor;
    private HairColor hairColor;
    private Country nationality;
    public Date getBirthday(){
        return birthday;
    }

    public Person(String name, Date birthday, EyeColor eyeColor, HairColor hairColor, Country nationality){
        this.name=name;
        this.birthday=birthday;
        this.eyeColor=eyeColor;
        this.hairColor=hairColor;
        this.nationality=nationality;
    }

    public String toString(){
        return name+" with "+eyeColor+" eyes and "+hairColor+" hairs. Was born "+birthday+" in "+nationality;
    }
}
