package demos.lect31;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MatcherTest {
    public static void main(String[] args) {
        var mtch = Pattern.compile("[a-zA-Z][\\w]*").matcher("");
        var group = 0;
// required args: args[0] a string, args[1] a reg-exp, args[2] an int
        if (args.length < 3) {
            System.err.println("Error: Missing arguments");
            return;
        }
        mtch.reset(args[0]);
        try {
            mtch.usePattern(Pattern.compile(args[1])); // may throw PatternSyntaxException
            group = Integer.parseInt(args[2]); // may throw NumberFormatException
        } catch (PatternSyntaxException e) {
            System.err.println("Argument 2 is not a valid regular expression");
            System.err.println("Using default regular expression and group");
        } catch (NumberFormatException e) {
            System.err.println("Argument 3 is not a valid integer, using default group");
        }
        if (group < 0 || group > mtch.groupCount()) {
            System.err.println("Argument 3 is not a valid group, using 0 as default");
            group = 0;
        }
        if (mtch.matches() && mtch.group(group) != null)
            System.out.println("Matched string "+mtch.group(group)+" at group " + group);

    }
}
