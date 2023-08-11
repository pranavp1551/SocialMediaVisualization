package prj5;

import java.util.Iterator;

/**
 * This is the sorter class and it is the back end logic of the system
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class Sorter {
    private final DLList<User> users;
    private DLList<User> usersRelevant;
    private DLList<Bar> graphBars;
    private MonthsEnum month;
    private boolean engageTraditional;

    /**
     * Constructor that takes in Linked List of User and
     * initializes its values
     * @param userList
     *                Linked list of users
     */
    public Sorter(DLList<User> userList) {
        users = userList;
        usersRelevant = null;
        graphBars = new DLList<Bar>();
        month = MonthsEnum.FIRST_QUARTER;
        engageTraditional = true;
    }

    /**
     * This method sets the month of this sorter and the sorter reevaluates what
     * the graph bars should be
     */
    public void setMonth(MonthsEnum month) {
        this.month = month;
        getRelevantUsers();
        updateBars();
    }

    /**
     * Getter for relevant users that will be displayed in the front end
     */
    private void getRelevantUsers() {
        Iterator<User> data = users.iterator();
        DLList<User> usersCombined = new DLList<>();
        User tempUser;
        if (month == MonthsEnum.FIRST_QUARTER) {

            while (data.hasNext()) {
                tempUser = data.next();
                if (tempUser.getMonth() != MonthsEnum.JANUARY
                    && tempUser.getMonth() != MonthsEnum.FEBRUARY
                    && tempUser.getMonth() != MonthsEnum.MARCH) {
                    continue;
                }

                Iterator<User> dataCombined = usersCombined.iterator();
                User tempUserCombined;

                boolean userAdded = false;
                while (dataCombined.hasNext()) {
                    tempUserCombined = dataCombined.next();
                    if (tempUser.getChannelName()
                        .equals(tempUserCombined.getChannelName())) {
                        tempUserCombined.setComments(tempUser.getComments()
                            + tempUserCombined.getComments());
                        tempUserCombined.setLikes(
                            tempUser.getLikes() + tempUserCombined.getLikes());
                        tempUserCombined.setViews(
                            tempUser.getViews() + tempUserCombined.getViews());

                        if (tempUser.getMonth() == MonthsEnum.MARCH) {
                            tempUserCombined.setFollowers(
                                tempUser.getFollowers());
                        }

                        userAdded = true;
                        break;
                    }
                }
                if (!userAdded) {
                    usersCombined.add(tempUser.makeDuplicate());
                    usersCombined.get(usersCombined.size() - 1)
                        .setMonth(MonthsEnum.FIRST_QUARTER);
                }
            }
            usersRelevant = usersCombined;
            return;
        }

        while (data.hasNext()) {
            tempUser = data.next();

            if (tempUser.getMonth() == month) {
                usersCombined.add(tempUser);
            }
        }
        usersRelevant = usersCombined;
    }

    /**
     * Updates the bars using and iterator and channel names
     */
    private void updateBars() {
        graphBars = new DLList<>();

        Iterator<User> data = usersRelevant.iterator();
        User tempUser = null;
        while (data.hasNext()) {
            tempUser = data.next();
            if (tempUser.getMonth() == month) {
                graphBars.add(new Bar(tempUser.getChannelName(),
                    tempUser.calcEngage(engageTraditional)));
            }
        }
    }

    /**
     * This is the method for the intermediate submission calculations, so it is
     * the one that does the printing of the data in the form that was asked for
     */
    public void intermediateSubmissionCalculations() {
        getRelevantUsers();
        updateBars();
        graphBars.insertionSort(new StringComparator());
        Iterator<Bar> bars = graphBars.iterator();
        Bar tempBar = null;
        while (bars.hasNext()) {
            tempBar = bars.next();
            System.out.println(tempBar.getName());
            if (tempBar.getValue() == -1) {
                System.out.println("traditional: N/A");
            }
            else {
                System.out.println("traditional: " + tempBar.getValue());
            }
            System.out.println("==========");
        }
        System.out.println("**********");
        System.out.println("**********");

        engageTraditional = false;
        updateBars();
        graphBars.insertionSort(new ValueComparator());
        bars = graphBars.iterator();
        while (bars.hasNext()) {
            tempBar = bars.next();
            System.out.println(tempBar.getName());
            if (tempBar.getValue() == -1) {
                System.out.println("reach: N/A");
            }
            else {
                System.out.println("reach: " + tempBar.getValue());
            }
            System.out.println("==========");
        }
    }
}
