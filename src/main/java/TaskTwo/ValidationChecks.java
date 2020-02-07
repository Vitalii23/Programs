package TaskTwo;

import java.util.Stack;

public class ValidationChecks {

    public void run(String text){
        System.out.println(checks(text));
    }

    public static boolean checks(String in) {
        Stack<Character> stack = new Stack<Character>();
        char[] array = in.toCharArray();
        for (char bkt : array) {
            if (bkt == '{' || bkt == '(' || bkt == '[') {
                stack.push(bkt);
            } else if (bkt == '}' || bkt == ')' || bkt == ']') {
                if (stack.size() > 0) {
                    char high = stack.peek();
                    if (bkt == '}' && high == '{' || bkt == ')' && high == '(' || bkt == ']' && high == '[') {
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}