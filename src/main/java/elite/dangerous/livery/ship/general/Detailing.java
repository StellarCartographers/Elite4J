package elite.dangerous.livery.ship.general;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import space.tscg.misc.StringUtil;

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

        @Nullable
        Color color;

        @Override
        public String toString()
        {
            return StringUtil.capitalize(super.toString());
        }

        @Nullable
        public Color getJavaColor()
        {
            return color;
        }
    }
}
