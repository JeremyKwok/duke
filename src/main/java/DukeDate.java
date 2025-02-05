import java.io.Serializable;

public class DukeDate implements Serializable {
    private String day;
    private String month;
    private String year;
    private String time;

    public String outputDate () {
        return day + " of " + month + " " + year + ", " + time;
    }

    public DukeDate (String day, String month, String year, String time) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;
    }

    public static DukeDate formatDate (String myDate) throws DukeException {

        String[] dParts = {};
        String time="", dt="";
        if (myDate.indexOf(" ") > -1) {
            time = myDate.split(" ")[1];
            dt = myDate.split(" ")[0];
        } else {
            throw new DukeException("☹ OOPS!!! The date is in an invalid format");
        }
        if (dt.indexOf("/") > -1){
            dParts = dt.split("/");
        } else {
            throw new DukeException("☹ OOPS!!! The date is in an invalid format");
        }

        if (validateDate(dParts, time)) {
            dParts[0] = convertDay(dParts[0]);
            dParts[1] = convertMonth(dParts[1]);
            time = getTime(time);
        } else {
            throw new DukeException("☹ OOPS!!! The date is in an invalid format");
        }

        return new DukeDate(dParts[0], dParts[1], dParts[2], time);
    }

    public static boolean validateDate(String[] dParts, String time) {
        String time2;
        int timeValue, time2Value;
        if (time.indexOf("-") > -1) {
           time2 = time.split("-",2)[1];
           time = time.split("-", 2) [0];
           timeValue = Integer.parseInt(time);
           time2Value = Integer.parseInt(time2);
            if (timeValue % 100 > 60 || timeValue < 0 || timeValue > 2360) {
                return false;
            } else if (time2Value % 100 > 60 || time2Value < 0 || time2Value > 2360) {
                return false;
            }
        }else {
            timeValue = Integer.parseInt(time);
            if (timeValue % 100 > 60 || timeValue < 0 || timeValue > 2360) {
                return false;
            }
        }


        if (dParts.length != 3) {
            return false;
        }
        for (String s: dParts) {
            if (!isNumeric(s)) {
                return false;
            }
        }
        int dayValue = Integer.parseInt(dParts[0]);
        int monthValue = Integer.parseInt(dParts[1]);
        if (dayValue < 1 || dayValue > 31) {
            return false;
        } else if (monthValue < 1 || monthValue > 12) {
            return false;
        } else if (dParts[2].length() > 4) {
            return false;
        }
        return true;
    }

    public static String getTime (String time) {
        String time2 = "";
        int timeValue, time2Value;
        if (time.indexOf("-") > -1) {
            time2 = time.split("-",2)[1];
            time = time.split("-", 2) [0];
            time = convertTime(time);
            time2 = convertTime(time2);
            return time + " - " + time2;
        }
        time = convertTime(time);
        return time;
    }

    public static String convertTime(String s) {

        int timeValue = Integer.parseInt(s);
        if (timeValue < 1200) {
            //am case
            if (timeValue / 100 != 0) {
                s = Integer.toString(timeValue / 100) + '.' + s.substring(2,4);
            } else {
                s = Integer.toString(timeValue / 100);
            }
            s += "am";
        } else if (timeValue < 1260) {
            if (timeValue / 100 != 0) {
                s = Integer.toString(timeValue / 100) + '.' + s.substring(2,4);
            } else {
                s = Integer.toString(timeValue / 100);
            }
            s += "pm";
        }
        else if (timeValue < 2360) {
            // pm case
            timeValue -= 1200;
            if (timeValue / 100 != 0) {
                s = Integer.toString(timeValue / 100) + '.' + s.substring(2,4);
            } else {
                s = Integer.toString(timeValue / 100);
            }
            s += "pm";
        }
        return s;
    }

    public static String convertMonth(String s) {
       int monthValue = Integer.parseInt(s);
        String[] months = new String[]{"January", "Febuary", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
       return months[monthValue-1];
    }

    public static String convertDay(String s) {
        int dayValue = Integer.parseInt(s);
        if (dayValue == 1 || dayValue % 10 == 1) {
            s += "st";
        } else if (dayValue == 2 || dayValue % 10 == 2) {
            s += "nd";
        } else if (dayValue == 3 || dayValue % 10 == 3) {
            s += "rd";
        } else {
            s += "th";
        }
        return s;
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[0-9]+");
    }

}
