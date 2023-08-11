package prj5;

import java.text.DecimalFormat;

/**
 * This is the user class that stores all the information for one singular user
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class User {
    private MonthsEnum month;
    private final String username;
    private final String channelName;
    private final String country;
    private final String mainTopic;
    private int likes;
    private final int posts;
    private int followers;
    private int comments;
    private int views;
    private final DecimalFormat decimalFormat;

    /**
     * Constructor that initializes its fields
     * @param month
     *             Month of data
     * @param username
     *                Username of user
     * @param channelName
     *                   Channel Name of user
     * @param country
     *               Country of user
     * @param mainTopic
     *                 Topic of channel
     * @param likes
     *             Number of likes for channel
     * @param posts
     *             Number of posts for channel
     * @param followers
     *                 Number of followers for channel
     * @param comments
     *                Number of comments for channel
     * @param views
     *             Number of views for channel
     */
    public User(MonthsEnum month, String username, String channelName,
        String country, String mainTopic, int likes, int posts, int followers,
        int comments, int views) {
        this.month = month;
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        decimalFormat = new DecimalFormat("#.#");
    }

    /**
     * Calculates engagement rate
     * @param traditionEngage
     *                       whether user wants traditional engagement or not
     * @return
     *        traditional engagement rate or reach engagement rate
     */
    public double calcEngage(boolean traditionEngage) {
        double result;
        if (traditionEngage) {
            result = ((double)(comments + likes) * 100) / followers;
        }
        else {
            result = ((double)(comments + likes) * 100) / views;
        }
        try {
            return Double.parseDouble(decimalFormat.format(result));
        }
        catch (Exception e) {
            return -1;
        }
    }

    /**
     * Getter for month
     * @return month
     *              Month of data
     */
    public MonthsEnum getMonth() {
        return month;
    }

    /**
     * Setter for month
     * @param month
     *             Sets month of data
     */
    public void setMonth(MonthsEnum month) {
        this.month = month;
    }

    /**
     * Getter for channel Name
     * @return channelName
     *                    Name of channel
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * Getter for likes
     * @return likes
     *              Likes of channel
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Setter for likes
     * @param likes
     *             Sets likes of channel
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Getter for followers
     * @return followers
     *                  number of followers
     */
    public int getFollowers() {
        return followers;
    }

    /**
     * Setter for followers
     * @param followers
     *                 Sets followers of channel
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     * Getter for comments
     * @return comments
     *                 number of comments
     */
    public int getComments() {
        return comments;
    }

    /**
     * Setter for comments
     * @param comments
     *                Sets comments of channel
     */
    public void setComments(int comments) {
        this.comments = comments;
    }

    /**
     * Getter for views
     * @return views
     *              number of views
     */
    public int getViews() {
        return views;
    }

    /**
     * Setter for views
     * @param views
     *             Sets views of channel
     */
    public void setViews(int views) {
        this.views = views;
    }

    /**
     * Makes a duplicate of the user
     * @return user
     *             New user with the exact same fields/attributes
     */
    public User makeDuplicate() {
        return new User(month, username, channelName, country, mainTopic, likes,
            posts, followers, comments, views);
    }
}
