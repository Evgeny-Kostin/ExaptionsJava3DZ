import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * DataInput
 */
public class DataInput {

    public void enter() throws IOException{
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите через пробел ФАМИЛИЮ,ИМЯ,ОТЧЕСТВО, дату рождения (в формате dd.mm.yyyy), номер телефона (целое число), пол (f или m): ");
            String ownData = scanner.nextLine();
            String[] dataArrayStrings=ownData.split(" ");
            if (dataArrayStrings.length !=6){
                throw new IOException("Введено неверное кол-во данных. Введите данные повторно. ");
            
            }

            String firstName = dataArrayStrings[0];
            String secondName = dataArrayStrings[1];
            String mName = dataArrayStrings[2];
            String birthDay = dataArrayStrings[3];
            String phoneNumber = dataArrayStrings[4];
            String sexUser = dataArrayStrings[5];

            if (!firstName.matches("[A-Za-zA-Яа-яЁё]+")){
                throw new IOException("Неверный формат ввода фамилии. Введите данные повторно.");
            }
            if (!secondName.matches("[A-Za-zA-Яа-яЁё]+")){
                throw new IOException("Неверный формат ввода имени. Введите данные повторно.");
            }
            if (!mName.matches("[A-Za-zA-Яа-яЁё]+")){
                throw new IOException("Неверный формат ввода имени. Введите данные повторно.");
            }
            if (!birthDay.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IOException("Неверный формат даты. Введите в формате dd.mm.yyyy : ");
            }
            if (!phoneNumber.matches("\\d{11}")) {
                throw new IOException("Неверный формат телефонного номера. Введите в формате ххххххххххх : ");
            }
            if (!sexUser.equalsIgnoreCase("f") && !sexUser.equalsIgnoreCase("m")) {
                throw new IOException("Неверный формат пола. Введите f или m");
            }
            try (FileWriter writer = new FileWriter(firstName + ".txt", true)){
                writer.write("<" + firstName.toUpperCase() + ">");
                writer.write("<" + secondName.toUpperCase() + ">");
                writer.write("<" + mName.toUpperCase() + ">");
                writer.write("<" + birthDay.toUpperCase() + ">");
                writer.write("<" + phoneNumber.toUpperCase() + ">");
                writer.write("<" + sexUser.toUpperCase() + ">");
                writer.write("\n");
                System.out.println("Данные записаны в файл" + firstName + ".txt");
                

                
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}