package CodeBase;

import java.awt.*;
import oneiros.games.OSprite;
import util.Resource;

public class Platform extends OSprite
{
    public int height = 2;
    public static String filePath = "platform.png";

    public Platform() {
        super(Resource.getImage(filePath));
    }

    public Rectangle getBase() {
        return new Rectangle(getX(), getY(), getWidth(), height);
    }
}