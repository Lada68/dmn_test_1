import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DecisionTable {
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("_hitPolicy")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String hitPolicy;
    @SerializedName("_biodi:annotationsWidth")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "biodi:annotationsWidth")
    private String biodiAnnotationsWidth;
    @SerializedName("input")
    @Expose
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Input> input;
    @SerializedName("output")
    @Expose
    private Output output;
    @SerializedName("rule")
    @Expose
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RuleXml> rule;

    public DecisionTable() {
    }

    public DecisionTable(String id, String hitPolicy, String biodiAnnotationsWidth, List<Input> input, Output output, List<RuleXml> rule) {
        this.id = id;
        this.hitPolicy = hitPolicy;
        this.biodiAnnotationsWidth = biodiAnnotationsWidth;
        this.input = input;
        this.output = output;
        this.rule = rule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHitPolicy() {
        return hitPolicy;
    }

    public void setHitPolicy(String hitPolicy) {
        this.hitPolicy = hitPolicy;
    }

    public String getBiodiAnnotationsWidth() {
        return biodiAnnotationsWidth;
    }

    public void setBiodiAnnotationsWidth(String biodiAnnotationsWidth) {
        this.biodiAnnotationsWidth = biodiAnnotationsWidth;
    }

    public List<Input> getInput() {
        return input;
    }

    public void setInput(List<Input> input) {
        this.input = input;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public List<RuleXml> getRule() {
        return rule;
    }

    public void setRule(List<RuleXml> rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "DecisionTable{" +
                "id='" + id + '\'' +
                ", hitPolicy='" + hitPolicy + '\'' +
                ", biodiAnnotationsWidth='" + biodiAnnotationsWidth + '\'' +
                ", input=" + input +
                ", output=" + output +
                ", rule=" + rule +
                '}';
    }
}
