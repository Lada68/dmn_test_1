import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bounds {
    @SerializedName("_height")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    public final String height;
    @SerializedName("_width")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    public final String width;
    @SerializedName("_x")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private final String x;
    @SerializedName("_y")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private final String y;

    public Bounds() {
        y = "100";
        x = "160";
        width = "180";
        height = "80";
    }

    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

}
