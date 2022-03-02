package exeptions;

import java.util.Scanner;

public class InvalidNameException extends Exception{

    public InvalidNameException(String message){
        super(message);
    }

    public static void main(String[] args) throws InvalidNameException {
        Scanner sc = new Scanner(System.in);
        Integer id = null;
        while(id==null){
            System.out.println("Ведите id");
            String musor;
            if (sc.hasNextInt()){
                id = sc.nextInt();
            }
            else{
                musor=sc.next();
                System.out.println("Некорректное id. Попробуйте снова.");
            }
        }
    }
}
