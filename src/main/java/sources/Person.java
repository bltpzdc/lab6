package sources;

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

    public String toString(){
        return name+" with "+eyeColor+" eyes and "+hairColor+" hairs. Was born "+birthday+" in "+nationality;
    }
}
