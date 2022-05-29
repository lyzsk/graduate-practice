package cn.sichu.graduate.practice.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 有限状态自动机，所有状态：
 * <ol>
 * <li>起始的空格</li>
 * <li>符号位</li>
 * <li>整数部分</li>
 * <li>左侧有整数的小数点</li>
 * <li>左侧无整数的小数点</li>
 * <li>小数部分</li>
 * <li>字符e/E</li>
 * <li>指数部分的符号位</li>
 * <li>指数部分的整数部分</li>
 * <li>末尾的空格</li>
 * </ol>
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer20 {
    enum State {
        STATE_INITIAL, STATE_INT_SIGN, STATE_INTEGER, STATE_POINT, STATE_POINT_WITHOUT_INT, STATE_FRACTION, STATE_EXP,
        STATE_EXP_SIGN, STATE_EXP_NUMBER, STATE_END
    }

    enum CharType {
        CHAR_NUMBER, CHAR_EXP, CHAR_POINT, CHAR_SIGN, CHAR_SPACE, CHAR_ILLEGAL
    }

    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>();
        initialMap.put(CharType.CHAR_SPACE, State.STATE_INITIAL);
        initialMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        initialMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        initialMap.put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        transfer.put(State.STATE_INITIAL, initialMap);

        Map<CharType, State> intSignMap = new HashMap<CharType, State>();
        intSignMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        intSignMap.put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        Map<CharType, State> integerMap = new HashMap<CharType, State>();
        integerMap.put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
        integerMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        integerMap.put(CharType.CHAR_POINT, State.STATE_POINT);
        integerMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_INTEGER, integerMap);

        Map<CharType, State> pointMap = new HashMap<CharType, State>();
        pointMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        pointMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        pointMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_POINT, pointMap);

        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>();
        pointWithoutIntMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        Map<CharType, State> fractionMap = new HashMap<CharType, State>();
        fractionMap.put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        fractionMap.put(CharType.CHAR_EXP, State.STATE_EXP);
        fractionMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_FRACTION, fractionMap);

        Map<CharType, State> expMap = new HashMap<CharType, State>();
        expMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expMap.put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        transfer.put(State.STATE_EXP, expMap);

        Map<CharType, State> expSignMap = new HashMap<CharType, State>();
        expSignMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        Map<CharType, State> expNumberMap = new HashMap<CharType, State>();
        expNumberMap.put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        expNumberMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        Map<CharType, State> endMap = new HashMap<CharType, State>();
        endMap.put(CharType.CHAR_SPACE, State.STATE_END);
        transfer.put(State.STATE_END, endMap);

        State state = State.STATE_INITIAL;
        for (int i = 0; i < s.length(); i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == state.STATE_INTEGER || state == state.STATE_POINT || state == State.STATE_FRACTION
            || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }

    private static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }
}
