package prj5;

/**
 * This is the test class for the user
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class UserTest extends student.TestCase {
    private User user1;
    private User user2;
    private User user3;

    /**
     * Sets up
     */
    public void setUp() {
        user1 =
            new User(MonthsEnum.JANUARY, "User1", "Channel1", "US", "Sports",
                100, 100, 100, 100, 200);
        user2 =
            new User(MonthsEnum.MARCH, "User1", "Channel1", "US",
                "Sports", 100, 100, 0, 100, 100);
        user3 =
            new User(MonthsEnum.FEBRUARY, "User1", "Channel1", "US", "Sports",
                100, 100, 50, 100, 0);

    }

    /**
     * Tests calcEngage method
     */
    public void testCalcEngage() {
        assertEquals(200, user1.calcEngage(true), 0.1);
        assertEquals(100, user1.calcEngage(false), 0.1);

        assertEquals(-1, user2.calcEngage(true), 0.1);
        assertEquals(200, user2.calcEngage(false), 0.1);

        assertEquals(400, user3.calcEngage(true), 0.1);
        assertEquals(-1, user3.calcEngage(false), 0.1);
    }

    /**
     * Tests getMonth method
     */
    public void testGetMonth() {
        assertEquals(MonthsEnum.JANUARY, user1.getMonth());
        assertEquals(MonthsEnum.MARCH, user2.getMonth());
        assertEquals(MonthsEnum.FEBRUARY, user3.getMonth());
    }

    /**
     * Tests setMonth method
     */
    public void testSetMonth() {
        user1.setMonth(MonthsEnum.APRIL);
        assertEquals(MonthsEnum.APRIL, user1.getMonth());
        user2.setMonth(MonthsEnum.MARCH);
        assertEquals(MonthsEnum.MARCH, user2.getMonth());
        user3.setMonth(MonthsEnum.JANUARY);
        assertEquals(MonthsEnum.JANUARY, user3.getMonth());
    }

    /**
     * Tests getChannelName method
     */
    public void testGetChannelName() {
        assertEquals("Channel1", user1.getChannelName());
        assertEquals("Channel1", user2.getChannelName());
        assertEquals("Channel1", user3.getChannelName());
    }

    /**
     * Tests getLikes method
     */
    public void testGetLikes() {
        assertEquals(100, user1.getLikes(), 0);
        assertEquals(100, user2.getLikes(), 0);
        assertEquals(100, user3.getLikes(), 0);

    }

    /**
     * Tests setLikes method
     */
    public void testSetLikes() {
        user1.setLikes(200);
        assertEquals(200, user1.getLikes(), 0);
        user2.setLikes(200);
        assertEquals(200, user2.getLikes(), 0);
        user3.setLikes(200);
        assertEquals(200, user3.getLikes(), 0);
    }

    /**
     * Tests getFollowers method
     */
    public void testGetFollowers() {
        assertEquals(100, user1.getFollowers(), 0);
        assertEquals(0, user2.getFollowers(), 0);
        assertEquals(50, user3.getFollowers(), 0);
    }

    /**
     * Tests setFollowers method
     */
    public void testSetFollowers() {
        user1.setFollowers(200);
        assertEquals(200, user1.getFollowers(), 0);
        user2.setFollowers(100);
        assertEquals(100, user2.getFollowers(), 0);
        user3.setFollowers(1000);
        assertEquals(1000, user3.getFollowers(), 0);
    }

    /**
     * Tests getComments method
     */
    public void testGetComments() {
        assertEquals(100, user1.getComments(), 0);
        assertEquals(100, user2.getComments(), 0);
        assertEquals(100, user3.getComments(), 0);
    }

    /**
     * Tests setComments method
     */
    public void testSetComments() {
        user1.setComments(0);
        assertEquals(0, user1.getComments(), 0);
        user2.setComments(200);
        assertEquals(200, user2.getComments(), 0);
        user3.setComments(150);
        assertEquals(150, user3.getComments(), 0);
    }

    /**
     * Tests getViews method
     */
    public void testGetViews() {
        assertEquals(200, user1.getViews(), 0);
        assertEquals(100, user2.getViews(), 0);
        assertEquals(0, user3.getViews(), 0);
    }

    /**
     * Tests setViews method
     */
    public void testSetViews() {
        user1.setViews(100);
        assertEquals(100, user1.getViews(), 0);
        user2.setViews(500);
        assertEquals(500, user2.getViews(), 0);
        user3.setViews(200);
        assertEquals(200, user3.getViews(), 0);
    }

    /**
     * Tests makeDuplicate method
     */
    public void testMakeDuplicate() {
        User user4 = new User(MonthsEnum.JANUARY, "User1", "Channel1",
            "US", "Sports", 100, 100, 100, 100, 200);
        assertEquals(user4.getMonth(), user1.makeDuplicate().getMonth());
        assertEquals(user4.getChannelName(), user1.makeDuplicate().getChannelName());
        assertEquals(user4.getComments(), user1.makeDuplicate().getComments());
        assertEquals(user4.getViews(), user1.makeDuplicate().getViews());
        assertEquals(user4.getLikes(), user1.makeDuplicate().getLikes());
        assertEquals(user4.getFollowers(), user1.makeDuplicate().getFollowers());
    }

}
