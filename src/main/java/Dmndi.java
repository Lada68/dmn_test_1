import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@JacksonXmlRootElement(localName = "DMNDI", namespace = "xmlncDMNDI")
public class Dmndi {
    @SerializedName("DMNDiagram")
    @Expose
//    @JacksonXmlProperty(localName = "dmndi:DMNDiagram")
    private DMNDiagram dMNDiagram;

    public DMNDiagram getDMNDiagram() {
        return dMNDiagram;
    }

    public void setDMNDiagram(DMNDiagram dMNDiagram) {
        this.dMNDiagram = dMNDiagram;
    }

    public Dmndi() {
    }

    public Dmndi(DMNDiagram dMNDiagram) {
        this.dMNDiagram = dMNDiagram;
    }

    @Override
    public String toString() {
        return "Dmndi{" +
                "dMNDiagram=" + dMNDiagram +
                '}';
    }
}
