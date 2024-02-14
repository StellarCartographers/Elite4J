/*
 * This file is part of Elite4J, licensed under MIT.
 * 
 * Copyright (c) 2024 StellarCartographers.
 * 
 * You should have received a copy of the MIT license along with this program.  
 * If not, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.livery.ship.general;

import lombok.*;

import java.awt.Color;

import elite.dangerous.util.Functions;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public abstract class Detailing
{
    private final DetailColor color;

    public static class Weapons extends Detailing
    {
        public static final Weapons NONE = new Weapons(DetailColor.NONE);

        public Weapons(DetailColor color)
        {
            super(color);
        }
    }

    public static class Engines extends Detailing
    {
        public static final Engines NONE = new Engines(DetailColor.NONE);

        public Engines(DetailColor color)
        {
            super(color);
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    enum DetailColor
    {
        BLUE(Color.BLUE),
        CYAN(Color.CYAN),
        GREEN(Color.GREEN),
        PURPLE(new Color(102, 0, 153)),
        RED(Color.RED),
        WHITE(Color.WHITE),
        YELLOW(Color.YELLOW),
        NONE(null);

        Color color;

        @Override
        public String toString()
        {
            return Functions.Capitalize(super.toString());
        }

        public Color getJavaColor()
        {
            return color == null ? Color.getColor("", Color.TRANSLUCENT) : color;
        }
    }
}
