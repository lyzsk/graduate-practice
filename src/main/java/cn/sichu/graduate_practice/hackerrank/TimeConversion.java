package cn.sichu.graduate_practice.hackerrank;

public class TimeConversion {
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String[] timelist = s.split(":");
        String hours = timelist[0];
        String minutes = timelist[1];
        String seconds = timelist[2].substring(0, 2);
        String end = timelist[2].substring(2, 4);

        if (end.equals("AM")) {
            if (hours.equals("12")) {
                hours = "00";
            }
        } else {
            if (!hours.equals("12")) {
                int h = Integer.parseInt(hours);
                h += 12;
                hours = String.format("%d", h);
            }
        }
        return new String(hours + ":" + minutes + ":" + seconds);
    }
}
