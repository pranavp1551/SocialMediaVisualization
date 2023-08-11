package prj5;

/**
 * This is the test class for the Sorter class
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class SorterTest extends student.TestCase {
    private Sorter sorter;
    private DLList<User> users;

    /**
     * This runs once before every test method
     */
    public void setUp() {
        users = new DLList<>();
        sorter = new Sorter(users);
    }

    /**
     * This method tests the intermediateSubmissionCalculations method and makes
     * sure that it prints the correct lines of code in the console
     */
    public void testIntermediateSubmissionCalculations() {
        systemOut().clearHistory();

        //No users test
        sorter.intermediateSubmissionCalculations();

        //1 User test
        users.add(
            new User(MonthsEnum.JANUARY, "User1", "Channel1", "US", "Sports",
                100, 100, 100, 100, 100));
        sorter.intermediateSubmissionCalculations();

        //2 Users test
        users.add(
            new User(MonthsEnum.JANUARY, "User2", "Channel2", "US", "Sports",
                100, 100, 0, 100, 0));
        sorter.intermediateSubmissionCalculations();

        //Users over months test
        users.add(
            new User(MonthsEnum.FEBRUARY, "User2", "Channel2", "US", "Sports",
                100, 100, 100, 100, 100));
        sorter.intermediateSubmissionCalculations();

        //Users over months test
        users.add(
            new User(MonthsEnum.MARCH, "User2", "Channel2", "US", "Sports", 100,
                100, 100, 100, 100));
        sorter.intermediateSubmissionCalculations();

        //Adds a non-first quarter month user test
        users.add(
            new User(MonthsEnum.MAY, "User2", "Channel2", "US", "Sports", 100,
                100, 100, 100, 100));
        sorter.intermediateSubmissionCalculations();

        //Changes the month test
        sorter.setMonth(MonthsEnum.JANUARY);
        sorter.intermediateSubmissionCalculations();

        assertEquals("**********\n" + "**********\n" + "Channel1\n"
                + "traditional: 200.0\n" + "==========\n" + "**********\n"
                + "**********\n" + "Channel1\n" + "reach: 200.0\n" + "==========\n"
                + "Channel1\n" + "traditional: 200.0\n" + "==========\n"
                + "Channel2\n" + "traditional: N/A\n" + "==========\n"
                + "**********\n" + "**********\n" + "Channel1\n" + "reach: 200.0\n"
                + "==========\n" + "Channel2\n" + "reach: N/A\n" + "==========\n"
                + "Channel1\n" + "traditional: 200.0\n" + "==========\n"
                + "Channel2\n" + "traditional: 400.0\n" + "==========\n"
                + "**********\n" + "**********\n" + "Channel2\n" + "reach: 400.0\n"
                + "==========\n" + "Channel1\n" + "reach: 200.0\n" + "==========\n"
                + "Channel1\n" + "traditional: 200.0\n" + "==========\n"
                + "Channel2\n" + "traditional: 300.0\n" + "==========\n"
                + "**********\n" + "**********\n" + "Channel2\n" + "reach: 300.0\n"
                + "==========\n" + "Channel1\n" + "reach: 200.0\n" + "==========\n"
                + "Channel1\n" + "traditional: 200.0\n" + "==========\n"
                + "Channel2\n" + "traditional: 300.0\n" + "==========\n"
                + "**********\n" + "**********\n" + "Channel2\n" + "reach: 300.0\n"
                + "==========\n" + "Channel1\n" + "reach: 200.0\n" + "==========\n"
                + "Channel1\n" + "traditional: 200.0\n" + "==========\n"
                + "Channel2\n" + "traditional: N/A\n" + "==========\n"
                + "**********\n" + "**********\n" + "Channel1\n" + "reach: 200.0\n"
                + "==========\n" + "Channel2\n" + "reach: N/A\n" + "==========\n",
            systemOut().getHistory());
    }
}
