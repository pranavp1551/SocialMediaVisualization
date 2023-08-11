package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the reader class and reads the csv files and makes a DLList of Users
 * based on the data in the csv file
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class Reader {
    private final DLList<User> Users;

    /**
     * Constructor that takes in the name of file to be read
     * @param fileName
     * @throws FileNotFoundException
     */
    public Reader(String fileName) throws FileNotFoundException {
        Users = readUserFile(fileName);
        Sorter sorter = new Sorter(Users);
        sorter.intermediateSubmissionCalculations();
    }

    /**
     * Private method that takes in name of file
     * @param fileName
     *                name of file to be read
     * @return userList
     *                 LinkedList of type User
     * @throws FileNotFoundException
     */
    private DLList<User> readUserFile(String fileName)
        throws FileNotFoundException {
        DLList<User> userList = new DLList<>();
        Scanner file = new Scanner(new File(fileName));

        file.nextLine();

        label:
        while (file.hasNext()) {
            String[] user = file.nextLine().split(",", 10);

            MonthsEnum month;

            switch (user[0]) {
                case "January":
                    month = MonthsEnum.JANUARY;
                    break;
                case "February":
                    month = MonthsEnum.FEBRUARY;
                    break;
                case "March":
                    month = MonthsEnum.MARCH;
                    break;
                case "May":
                    month = MonthsEnum.MAY;
                    break;
                case "April":
                    month = MonthsEnum.APRIL;
                    break;
                case "June":
                    month = MonthsEnum.JUNE;
                    break;
                case "July":
                    month = MonthsEnum.JULY;
                    break;
                case "August":
                    month = MonthsEnum.AUGUST;
                    break;
                case "September":
                    month = MonthsEnum.SEPTEMBER;
                    break;
                case "October":
                    month = MonthsEnum.OCTOBER;
                    break;
                case "November":
                    month = MonthsEnum.NOVEMBER;
                    break;
                case "December":
                    month = MonthsEnum.DECEMBER;
                    break;
                default:
                    break label;
            }

            userList.add(new User(month, user[1], user[2], user[3], user[4],
                Integer.parseInt(user[5]), Integer.parseInt(user[6]),
                Integer.parseInt(user[7]), Integer.parseInt(user[8]),
                Integer.parseInt(user[9])));

        }

        return userList;
    }
}
