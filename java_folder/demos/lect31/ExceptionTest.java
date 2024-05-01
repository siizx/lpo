package demos.lect31;

public class ExceptionTest {
    public static void main(String[] args) {
        var timer = new TimerClass(30);
        timer.reset(-2);                          // line 7
        System.out.println(timer.getTime());      // not executed
    }
}