import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Action {
    @SerializedName("field")
    @Expose
    private String field;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("actionType")
    @Expose
    private String actionType;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("type")
    @Expose
    private Object type;

    public Action() {
    }

    public Action(String field, Integer value, String actionType, String operator,
                  Object type) {
        this.field = field;
        this.value = value;
        this.actionType = actionType;
        this.operator = operator;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getType() {
        return value;
    }

    public void setType(Object type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Action{" +
                "field='" + field + '\'' +
                ", value=" + value +
                ", actionType='" + actionType + '\'' +
                ", operator='" + operator + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
