package converter2;

/**
   This class implements the static milesToKm() method, which converts miles to kilometers.
 */

public class MetricConverter {

    /**
     *  mileToKm() converts miles to kilometers
     *  @param miles -- the number of miles to convert
     *  @return -- a double giving the number of kilometers
     */
    public static double milesToKm(double miles) {
        return miles / 0.62;
    }
}
