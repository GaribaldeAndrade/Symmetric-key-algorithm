package vernam;

public class StringGenerator {
    public static String getRandomString(int i) {
        String theAlpha;
        StringBuilder builder;

        theAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create the StringBuffer
        builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {

            // generate numeric
            int myindex = (int) (theAlpha.length()
                    * Math.random());

            // add the characters
            builder.append(theAlpha
                    .charAt(myindex));
        }

        return builder.toString();
    }
}
