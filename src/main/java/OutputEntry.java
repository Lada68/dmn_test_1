import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OutputEntry {
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("text")
    @Expose
    private String text;


    public OutputEntry() {
    }

    public OutputEntry(String text, String id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OutputEntry{" +
                "text='" + text + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
