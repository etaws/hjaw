package com.my.hjaw;

import java.util.LinkedList;
import java.util.List;

public class Expand {

    public String expand(String s) {

        List<Character> sStack = new LinkedList<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (c != ']') {
                sStack.add(c);
            } else {
                Character top = removeLast(sStack);

                List<Character> inner = new LinkedList<>();
                while (top != '[') {
                    inner.add(top);
                    top = removeLast(sStack);
                }

                if (sStack.isEmpty()) {
                    i += 1;
                    continue;
                }

                top = removeLast(sStack);
                int n = 0;
                int d = 1;
                while (true) {
                    n += ((top - '0') * d);
                    d *= 10;

                    if (sStack.isEmpty() || !isNum(getLast(sStack))) {
                        break;
                    }

                    top = removeLast(sStack);
                }

                int j = 0;
                while (j < n) {
                    int k = inner.size();
                    while (k > 0) {
                        sStack.add(inner.get(k - 1));
                        k--;
                    }

                    j++;
                }
            }

            ++i;
        }

        int ii = 0;
        StringBuilder r = new StringBuilder();
        while (ii < sStack.size()) {
            if (isNum(sStack.get(ii))) {
                return "";
            }
            r.append(sStack.get(ii));
            ii++;
        }

        return r.toString();
    }

    private <T> T removeLast(List<T> list) {
        return list.remove(list.size() - 1);
    }

    private <T> T getLast(List<T> list) {
        return list.get(list.size() - 1);
    }

    private boolean isNum(char c) {
        return Character.isDigit(c);
    }
}
