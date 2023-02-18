import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Decision {
    @SerializedName("decisionTable")
    @Expose
    private DecisionTable decisionTable;
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("_name")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    public Decision() {

    }

    public Decision(DecisionTable decisionTable, String id, String name) {
        this.decisionTable = decisionTable;
        this.id = id;
        this.name = name;
    }

    public DecisionTable getDecisionTable() {
        return decisionTable;
    }

    public void setDecisionTable(DecisionTable decisionTable) {
        this.decisionTable = decisionTable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Decision{" +
                "decisionTable=" + decisionTable +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
