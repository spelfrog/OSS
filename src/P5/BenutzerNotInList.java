package P5;
/**
 * <p>Überschrift: Exception wenn auf nicht vorhandene User in der Db zugegriffen wird</p>
 *
 * <p>Copyright: Constantin Kalversberg Copyright (c) 2019</p>
 * <p>Organisation: FH Aachen, FB05 </p>
 * @author Constantin Kalversberg
 * @version 1.0
 */
public class BenutzerNotInList extends Exception {
    /**
     * Constructs an instance of <code>BenutzerNotinList</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BenutzerNotInList(String msg) {
        super(msg);
    }
}