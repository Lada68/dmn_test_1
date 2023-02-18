import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RuleFromJson {
    @SerializedName("condition")
    @Expose
    private String conditional;
    @SerializedName("rules")
    @Expose
    private List<RuleCriteria>ruleCriteriaList;
    @SerializedName("actions")
    @Expose
    private List<Action> actionList;

    public String getConditional() {
        return conditional;
    }

    public void setConditional(String conditional) {
        this.conditional = conditional;
    }

    public List<RuleCriteria> getRuleCriteriaList() {
        return ruleCriteriaList;
    }

    public void setRuleCriteriaList(List<RuleCriteria> ruleCriteriaList) {
        this.ruleCriteriaList = ruleCriteriaList;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public RuleFromJson() {
    }

    public RuleFromJson(String conditional, List<RuleCriteria> ruleCriteriaList, List<Action> actionList) {
        this.conditional = conditional;
        this.ruleCriteriaList = ruleCriteriaList;
        this.actionList = actionList;
    }

    @Override
    public String toString() {
        return "RuleFromJson{" +
                "conditional='" + conditional + '\'' +
                ", ruleCriteriaList=" + ruleCriteriaList +
                ", actionList=" + actionList +
                '}';
    }
}
