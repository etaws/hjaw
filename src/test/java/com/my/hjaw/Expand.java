package com.my.hjaw;

import java.util.LinkedList;
import java.util.List;

public class Expand {

    public String expand(String s) {

        StringBuilder r = new StringBuilder();

        // 用状态机来实现。2 个状态：
        // 0：默认状态，非栈内
        // 1：栈内
        int state = 0;

        List<Integer> nStack = new LinkedList<>();
        List<String> sStack = new LinkedList<>();

        int i = 0;
        while (i < s.length()) {
            assert nStack.size() == sStack.size();

            char c = s.charAt(i);

            if (state == 0 && isNum(c)) {
                // 默认状态时，遇到一个「数字」
                String num = getNumber(i, s);
                int n = Integer.parseInt(num);
                if (n <= 0) {
                    throw new RuntimeException("bad str pattern: number should be positive");
                }
                nStack.add(n);
                // 初始化「当前栈」
                sStack.add("");
                i = i + num.length() + 1;

                // 进入状态 1：栈内操作
                state = 1;
            } else if (state == 0 && !isNum(c)) {
                // 默认状态时，遇到一个「非数字」
                r.append(c);
                i++;
            } else if (state == 1 && !isNum(c)) {
                if (c == ']') {
                    // 栈内时，是 ]，出栈
                    if (nStack.isEmpty()) {
                        // 但如果是栈是空的，直接输出当前字符就行了
                        r.append(c);
                    } else {
                        // 获取栈的数据
                        String in = getLast(sStack);
                        int n = getLast(nStack);
                        // 扩展
                        StringBuilder out = new StringBuilder();
                        for (int j = 0; j < n; j++) {
                            out.append(in);
                        }
                        // 弹出堆栈
                        removeLast(sStack);
                        removeLast(nStack);
                        // 输出数据（直接输出，或者放入上一层堆栈的数据中）
                        if (sStack.isEmpty()) {
                            r.append(out);
                            // 结束栈内操作
                            state = 0;
                        } else {
                            updateStackTop(sStack, out.toString());
                        }
                    }
                } else {
                    // 栈内时，非数字，且不是 ]，就给「当前栈」收集字符
                    updateStackTop(sStack, "" + c);
                }
                i++;
            } else if (state == 1 && isNum(c)) {
                // 栈内时遇到数字的话，需要新增一个栈

                // 解析出数字，并压栈
                String num = getNumber(i, s);
                int n = Integer.parseInt(num);
                if (n <= 0) {
                    throw new RuntimeException("bad str pattern: number should be positive");
                }
                nStack.add(n);
                sStack.add("");
                i = i + num.length() + 1;
            } else {
                assert false;
            }
        }
        return r.toString();
    }

    private <T> void removeLast(List<T> list) {
        list.remove(list.size() - 1);
    }

    private <T> T getLast(List<T> list) {
        return list.get(list.size() - 1);
    }

    // 更新 List 的最后一个 string：last = last + s
    private void updateStackTop(List<String> sStack, String s) {
        String last = sStack.get(sStack.size() - 1);
        last = last + s;
        sStack.set(sStack.size() - 1, last);
    }

    // e.g.
    // s is 'aa34[ab]'
    // i is 2
    // the the return is 34
    private String getNumber(int i, String s) {

        if (i + 2 > s.length()) {
            throw new RuntimeException("bad str pattern: missing []");
        }

        StringBuilder r = new StringBuilder();
        while (i < s.length()) {

            char c = s.charAt(i);
            if ((c != '[') && !isNum(c)) {
                throw new RuntimeException("bad str pattern: missing [");
            }

            if (c == '[') {
                return r.toString();
            }

            r.append(c);
            i++;
        }

        throw new RuntimeException("bad str pattern: missing [");
    }

    private boolean isNum(char c) {
        return Character.isDigit(c);
    }
}
