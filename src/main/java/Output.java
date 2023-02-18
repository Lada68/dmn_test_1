import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Output {
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("_label")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String label;
    @SerializedName("_name")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @SerializedName("_typeRef")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String typeRef;
    @SerializedName("_biodi:width")
    @Expose
    @JacksonXmlProperty(isAttribute = true, localName = "biodi:width")
    private String biodiWidth;
    public Output() {
    }
    public Output(String id, String label, String name, String typeRef, String biodiWidth) {
        this.id = id;
        this.label = label;
        this.name = name;
        this.typeRef = typeRef;
        this.biodiWidth = biodiWidth;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeRef() {
        return typeRef;
    }

    public void setTypeRef(String typeRef) {
        this.typeRef = typeRef;
    }

    public String getBiodiWidth() {
        return biodiWidth;
    }

    public void setBiodiWidth(String biodiWidth) {
        this.biodiWidth = biodiWidth;
    }
    @Override
    public String toString() {
        return "Output{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", typeRef='" + typeRef + '\'' +
                ", biodiWidth='" + biodiWidth + '\'' +
                '}';
    }
}
