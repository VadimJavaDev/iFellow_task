public class Task {

    public static String validBrackets(String input) {
        StringBuilder builder = new StringBuilder();            // Можно использовать StringBuffer, если требуется
        StringBuilder result = new StringBuilder();             // Аналогично
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                if (input.substring(i).contains("" + ')')) {
                    builder.append(ch);
                    count++;
                }
            }

            if (ch == ')' && count > 0) {
                builder.append(ch);
                count--;
            }

            if (count == 0) {
                result.append(builder);
                builder.setLength(0);
            }

            if (count > 0 && i == input.length() - 1) {
                while (count > 0) {
                    builder.deleteCharAt(builder.indexOf("("));
                    count--;
                }
                result.append(builder);
            }

            if (count < 0 && i == input.length() - 1) {
                while (count < 0) {
                    builder.deleteCharAt(builder.indexOf(")"));
                    count--;
                }
                result.append(builder);
            }
        }
        return result.length() + " - " + result;
    }

    public static void main(String[] args) {

//            Проверка на ваших тест-кейсах
        System.out.println(validBrackets("(()"));
        System.out.println(validBrackets(")()())"));
        System.out.println(validBrackets(")(()())"));
        System.out.println(validBrackets(")("));
        System.out.println(validBrackets("())(()())(()"));

//            Проверка на моих тест-кейсах
//        System.out.println(validBrackets("((((()))()()))()"));
//        System.out.println(validBrackets("(())()))((()"));
//        System.out.println(validBrackets("))))((("));
//        System.out.println(validBrackets("()()()()))(()()()"));
    }
}
