import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class InputExpression {
    @SerializedName("_id")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @SerializedName("_typeRef")
    @Expose
    @JacksonXmlProperty(isAttribute = true)
    private String typeRef;
    @SerializedName("text")
    @Expose
    private String text;



    public InputExpression() {
    }

    public InputExpression(String id, String typeRef, String text) {
        this.text = text;
        this.id = id;
        this.typeRef = typeRef;
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

    public String getTypeRef() {
        return typeRef;
    }

    public void setTypeRef(String typeRef) {
        this.typeRef = typeRef;
    }



}
