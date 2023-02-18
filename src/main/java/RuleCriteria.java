import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RuleCriteria {
    @SerializedName("entity")
    @Expose
    private String entity;
    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private Object value;

    public RuleCriteria() {
    }

    public RuleCriteria(String entity, String field, String operator, String type, Object value) {
        this.entity = entity;
        this.field = field;
        this.operator = operator;
        this.type = type;
        this.value = value;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RuleCriteria{" +
                "entity='" + entity + '\'' +
                ", field='" + field + '\'' +
                ", operator='" + operator + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
