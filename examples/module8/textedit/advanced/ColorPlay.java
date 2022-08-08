
package textedit.advanced;

import java.awt.Color;

/**
    A utility class for playing with color objects.

    @author Amit Jain
    @version 0.1
*/

public class ColorPlay
{
    /**
        Returns a color object corresponding to a color name.
        Currently only knows colors statically pre-defined in
        the java.awt.Color class.

        @param name The name of a color in English.
        @return An object of type java.awt.Color if the given color
                is recognized, null otherwise.

    */
    public static Color findColor (String name)
    {
        if (name.equals("white"))
            return Color.white;
        else if (name.equals("lightGray"))
            return Color.lightGray;
        else if (name.equals("gray"))
            return Color.gray;
        else if (name.equals("darkGray"))
            return Color.darkGray;
        else if (name.equals("black"))
            return Color.black;
        else if (name.equals("red"))
            return Color.red;
        else if (name.equals("pink"))
            return Color.pink;
        else if (name.equals("orange"))
            return Color.orange;
        else if (name.equals("yellow"))
            return Color.yellow;
        else if (name.equals("green"))
            return Color.green;
        else if (name.equals("magenta"))
            return Color.magenta;
        else if (name.equals("cyan"))
            return Color.cyan;
        else if (name.equals("blue"))
            return Color.blue;
        else
            return null;
    }

    /**
        Returns the English name for a color corresponding to a color object.
        Currently only knows colors statically pre-defined in
        the java.awt.Color class.

        @param color A color object.
        @return An string describing the color if the given color
                is recognized, null otherwise.

    */
    public static String nameColor (Color color)
    {
        if (color.equals(Color.white))
            return "white";
        else if (color.equals(Color.lightGray))
            return "lightGray";
        else if (color.equals(Color.gray))
            return "gray";
        else if (color.equals(Color.darkGray))
            return "darkGray";
        else if (color.equals(Color.black))
            return "black";
        else if (color.equals(Color.red))
            return "red";
        else if (color.equals(Color.pink))
            return "pink";
        else if (color.equals(Color.orange))
            return "orange";
        else if (color.equals(Color.yellow))
            return "yellow";
        else if (color.equals(Color.green))
            return "green";
        else if (color.equals(Color.magenta))
            return "magenta";
        else if (color.equals(Color.cyan))
            return "cyan";
        else if (color.equals(Color.blue))
            return "blue";
        else
            return null;
    }

}
