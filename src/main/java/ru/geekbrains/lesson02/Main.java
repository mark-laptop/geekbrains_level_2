package ru.geekbrains.lesson02;

public class Main {

    private static final String DATA = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    private static final int SIZE_ARRAY = 4;
    private static final String[][] EMPTY_STRING_MULTI_ARRAY = new String[0][0];
    private static final String NEW_LINE_SYMBOL = "\n";
    private static final String SPACE_SYMBOL = " ";

    public static void main(String[] args) {

        try {
            String[][] result = convertStringToStringMultiArray(Main.DATA);
            int sum = getSumElementArray(result);
            System.out.println(sum);
            System.out.println(sum / 2);
        } catch (IncorrectSizeArrayException | IncorrectMethodArgumentException | ParseStringToDigitException e) {
            e.printStackTrace();
        }

    }

    public static String[][] convertStringToStringMultiArray(final String data) {
        if (data == null) throw new IncorrectMethodArgumentException("argument is null");
        if (data.isEmpty()) return Main.EMPTY_STRING_MULTI_ARRAY;

//        String[][] result = new String[Main.SIZE_ARRAY][Main.SIZE_ARRAY];
        String[][] result = new String[Main.SIZE_ARRAY][];

        String[] tempArray = data.split(Main.NEW_LINE_SYMBOL);
        if (tempArray.length != Main.SIZE_ARRAY) throw new IncorrectSizeArrayException("size array != 4");

        for (int indexColumn = 0; indexColumn < Main.SIZE_ARRAY; indexColumn++) {
            result[indexColumn] = tempArray[indexColumn].split(Main.SPACE_SYMBOL);
            if (result[indexColumn].length != Main.SIZE_ARRAY) throw new IncorrectSizeArrayException(
                                                            String.format("size array[%d] != 4", indexColumn));
        }

        return result;
    }

    public static int getSumElementArray(final String[][] stringArray) {
        int sum = 0;
        if (stringArray == null) throw new IncorrectMethodArgumentException("argument is null");
        if (stringArray.length == 0) return sum;

        for (int indexColumn = 0; indexColumn < stringArray.length; indexColumn++) {
            for (int indexRow = 0; indexRow < stringArray[indexColumn].length; indexRow++) {
                sum += convertsStringToInt(stringArray, indexColumn, indexRow);
            }
        }
        return sum;
    }

    public static int convertsStringToInt(final String[][] array, final int indexColumn, final int indexRow) {
        int result = 0;
        if (array == null) throw new IncorrectMethodArgumentException("argument is null");
        if (array.length == 0) return result;

        try {
            return Integer.parseInt(array[indexColumn][indexRow]);
        } catch (NumberFormatException e) {
            throw new ParseStringToDigitException(
                                String.format("element array[%d][%d] incorrect (not digit)", indexColumn, indexRow));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IncorrectSizeArrayException(
                                String.format("index out of bound array[%d][%d]", indexColumn, indexRow));
        }
    }
}
