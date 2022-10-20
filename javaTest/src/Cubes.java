import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cubes {
    public static void main(String[] args) {

        String s = "0 90263153 -827&()";

        System.out.println(isSumOfCubes(s));

    }
    private static String isSumOfCubes(String s) {
        final Pattern pattern = Pattern.compile("\\d{1,3}");
        final Matcher matcher = pattern.matcher(s);
        StringBuilder totalString = new StringBuilder(s.length());
        String matcherGroupNumber;
        int sumOfCubicNumbers = 0;
        double cubicNumber;
        while (matcher.find()) {
            matcherGroupNumber = matcher.group(0);
            cubicNumber = 0;
            for (int i = 0; i < matcherGroupNumber.length(); i++) {
                cubicNumber += Math.pow(Double.parseDouble(matcherGroupNumber.substring(i, i+1)), 3);
            }
            if (Double.parseDouble(matcherGroupNumber) == cubicNumber) {
                totalString.append(matcherGroupNumber).append(" ");
                sumOfCubicNumbers += Integer.parseInt(matcherGroupNumber);
            }
        }
        return (totalString.toString().equals("")) ? "Unlucky" : totalString.toString() + sumOfCubicNumbers + " Lucky";
    }
}