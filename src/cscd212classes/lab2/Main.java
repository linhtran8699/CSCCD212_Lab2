package cscd212classes.lab2;

import cscd212Lib.lab2.HelpersMethods;

public class Main {

    public static void main(final String[] args) throws NoSuchFieldException, IllegalAccessException {
        Canvas canvas = new Canvas(6, 7);
        Color black = new Color("yellow", new short[]{255, 255, 0, 255});
        canvas.setColor(1, 2, black);
        canvas.setColor(1, 4, black);
        canvas.setColor(3, 1, black);
        canvas.setColor(4, 2, black);
        canvas.setColor(4, 3, black);
        canvas.setColor(4, 4, black);
        canvas.setColor(3, 5, black);
        System.out.println(HelpersMethods.toString(canvas));
    }
}