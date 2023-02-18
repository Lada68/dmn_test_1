import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//@JacksonXmlRootElement(localName = "dmndi:DMNShape", namespace = "https://www.omg.org/spec/DMN/20191111/DMNDI/")
public class DMNShape {
    @SerializedName("Bounds")
    @Expose
    @JacksonXmlProperty(localName = "dc:Bounds")
    private Bounds bounds;
    @SerializedName("_dmnElementRef")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String dmnElementRef;

    public DMNShape() {
    }

    public DMNShape(Bounds bounds, String dmnElementRef) {
        this.bounds = bounds;
        this.dmnElementRef = dmnElementRef;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public String getDmnElementRef() {
        return dmnElementRef;
    }

    public void setDmnElementRef(String dmnElementRef) {
        this.dmnElementRef = dmnElementRef;
    }

    @Override
    public String toString() {
        return "DMNShape{" +
                "bounds=" + bounds +
                ", dmnElementRef='" + dmnElementRef + '\'' +
                '}';
    }
}
