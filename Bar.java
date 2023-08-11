package prj5;

/**
 * This stores the data for a singular bar to be used in the window class for
 * drawing the bars
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class Bar {
    private String name;
    private double value;

    /**
     * Constructor that initializes name and value fields
     * @param name
     *            name under bar
     * @param value
     *             value represented by the bar
     */
    public Bar(String name, double value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter for name
     * @return name
     *             name under bar
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name
     *            name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for value
     * @return value
     *              value to represented under the bar
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter for value
     * @param value
     *             value to be set
     */
    public void setValue(double value) {
        this.value = value;
    }
}
