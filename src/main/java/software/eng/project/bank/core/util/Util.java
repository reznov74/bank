package software.eng.project.bank.core.util;

public class Util {
    public int fallowUpCode(){
        return 0;
    }
    private static final String ALPHA_NUMERIC_STRING = "0123456789";
    public static String accountNumberGenerator(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

}
