public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        String[] c = new String[6];
        if (fullCommand.indexOf(" ") > -1) {
            c[0] = fullCommand.split(" ", 2)[0];
            c[1] = fullCommand.split(" ", 2)[1];
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else if (fullCommand.equals("bye")) {
            return new ExitCommand();
        } else if (fullCommand.equals("todo") || fullCommand.equals("event") || fullCommand.equals("deadline")) {
            throw new DukeException("☹ OOPS!!! The description of a " + fullCommand + " cannot be empty.");
        }
        else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means."
                    + "Please enter a command and description :-(");
        }
        if (c[0].equals("done")) {
            if (isNumeric(c[1])) {
                return new DoneCommand(c);
            } else {
                throw new DukeException("☹ OOPS!!! I'm sorry, but the task must be specified with a number.");
            }
        } else if (c[0].equals("delete")) {
            if (isNumeric(c[1])) {
                return new DeleteCommand(c);
            } else {
                throw new DukeException("☹ OOPS!!! I'm sorry, but the task must be specified with a number.");
            }
        }

        if (c[0].equals("find")) {
            return new FindCommand(c);
        } else if (!c[0].equals("todo") && !c[0].equals("deadline") && !c[0].equals("event")) {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means."
                    + "Please enter a command and description :-(");
        }
        if (c[0].equals("todo")) {
            return new AddCommand(c);
        } else if (c[0].equals("deadline") && c[1].indexOf(" /by ") > -1) {
            c[2] = c[1].split(" /by ", 2)[1];
            c[1] = c[1].split(" /by ", 2)[0];
        } else if (c[0].equals("event") && c[1].indexOf(" /at ") > -1) {
            c[2] = c[1].split(" /at ", 2)[1];
            c[1] = c[1].split(" /at ", 2)[0];
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means."
                    + "Please enter a command and description :-(");
        }
        if (c[1].equals("") || c[1] == null) {
            throw new DukeException("☹ OOPS!!! The description of a " + c[0] + " cannot be empty.");
        }
        String[] dParts = {};
        String time = "", dt = "";
        if (c[2].indexOf(" ") > -1) {
            time = c[2].split(" ", 2)[1];
            dt = c[2].split(" ", 2)[0];
        } else {
            throw new DukeException("☹ OOPS!!! The date is in an invalid format");
        }
        if (dt.indexOf("/") > -1){
            dParts = dt.split("/");
        } else {
            throw new DukeException("☹ OOPS!!! The date is in an invalid format");
        }
        if (validateDate(dParts, time)) {
            c[2] = convertDay(dParts[0]);
            c[3] = convertMonth(dParts[1]);
            c[4] = dParts[2];
            c[5] = getTime(time);
        } else {
            throw new DukeException("☹ OOPS!!! The date is in an invalid format");
        }
        return new AddCommand(c);
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
