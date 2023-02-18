import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//@JacksonXmlRootElement(localName = "dmndi:DMNDiagram")
public class DMNDiagram {
    @SerializedName("DMNShape")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "dmndi:DMNShape")
    private  DMNShape dMNShape;


    public DMNShape getDMNShape() {
        return dMNShape;
    }

    public void setDMNShape(DMNShape dMNShape) {
        this.dMNShape = dMNShape;
    }

    public DMNDiagram() {

    }

    public DMNDiagram(DMNShape dMNShape) {
        this.dMNShape = dMNShape;
    }

    @Override
    public String toString() {
        return "DMNDiagram{" +
                "dMNShape=" + dMNShape +
                '}';
    }
}
