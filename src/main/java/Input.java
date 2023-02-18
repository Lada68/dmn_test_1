import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNs;

public class Input {
    @SerializedName("inputExpression")
    @Expose
    private InputExpression inputExpression;
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("_label")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String label;
    @SerializedName("_biodi:width")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "biodi:width")
    private String biodiWidth;
    @SerializedName("_camunda:inputVariable")
    @Expose
    @JacksonXmlProperty(localName = "camunda:inputVariable", isAttribute = true)
    private String camundaInputVariable;
    public Input() {
    }
    public Input(InputExpression inputExpression, String id, String label, String biodiWidth, String camundaInputVariable) {
        this.inputExpression = inputExpression;
        this.id = id;
        this.label = label;
        this.biodiWidth = biodiWidth;
        this.camundaInputVariable = camundaInputVariable;
    }
    public InputExpression getInputExpression() {
        return inputExpression;
    }

    public void setInputExpression(InputExpression inputExpression) {
        this.inputExpression = inputExpression;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBiodiWidth() {
        return biodiWidth;
    }

    public void setBiodiWidth(String biodiWidth) {
        this.biodiWidth = biodiWidth;
    }

    public String getCamundaInputVariable() {
        return camundaInputVariable;
    }

    public void setCamundaInputVariable(String camundaInputVariable) {
        this.camundaInputVariable = camundaInputVariable;
    }
    @Override
    public String toString() {
        return "Input{" +
                "inputExpression=" + inputExpression +
                ", id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", biodiWidth='" + biodiWidth + '\'' +
                ", camundaInputVariable='" + camundaInputVariable + '\'' +
                '}';
    }
}
