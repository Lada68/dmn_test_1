import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

public class RuleXml {
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("inputEntry")
    @Expose
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<InputEntry> inputEntry;
    @SerializedName("outputEntry")
    @Expose
    @XmlAttribute
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OutputEntry> outputEntry;


    public RuleXml() {
    }

    public RuleXml(String id, String description, List<InputEntry> inputEntry, List<OutputEntry> outputEntry) {
        this.id = id;
        this.description = description;
        this.inputEntry = inputEntry;
        this.outputEntry = outputEntry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InputEntry> getInputEntry() {
        return inputEntry;
    }

    public void setInputEntry(List<InputEntry> inputEntry) {
        this.inputEntry = inputEntry;
    }

    public List<OutputEntry> getOutputEntry() {
        return outputEntry;
    }

    public void setOutputEntry(List<OutputEntry> outputEntry) {
        this.outputEntry = outputEntry;
    }

    @Override
    public String toString() {
        return "RuleXml{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", inputEntry=" + inputEntry +
                ", outputEntry=" + outputEntry +
                '}';
    }
}
