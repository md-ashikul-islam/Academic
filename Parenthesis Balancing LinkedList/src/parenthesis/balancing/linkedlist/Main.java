package parenthesis.balancing.linkedlist;


public class Main {

    
    public static void main(String[] args) {
        String expression = "1+2*(3/4)";
        char br = '0';
        boolean bool = false;
        int size = 0;
        int index = 0;

        Method m = new Method(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {

                m.push(expression.charAt(i));

            } else if (expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') {

                char bracket = m.pop();

                size = m.sizing();
                String s = "" + bracket + expression.charAt(i);

                if (s.equals("{}") || s.equals("[]") || s.equals("()")) {

                    bool = true;
                    continue;
                } else {

                    bool = false;
                    if (bracket == '0') {
                        br = expression.charAt(i);
                        index = i + 1;
                        break;
                    } else {
                        for (int j = 0; j < expression.length(); j++) {
                            if (bracket == expression.charAt(j)) {
                                br = bracket;
                                index = j + 1;

                                break;
                            }
                        }

                    }
                }

            }
        }

        if (bool == true && size == 0) {
            System.out.println("The Expression is correct");

        } else {
            if (br == '(' || br == '{' || br == '[') {
                System.out.println("The Expression is not correct");
                System.out.println("Error at character #" + index + ". " + "'" + br + "'" + "- not closed.");
            }
            if (br == ')' || br == '}' || br == ']') {
                System.out.println("The Expression is not correct");
                System.out.println("Error at character #" + index + ". " + "'" + br + "'" + "- not opened.");
            }

        }
    }

}
