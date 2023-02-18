import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RuleFromDmn {


    private String description;

    private List<InputEntry> inputEntryList;

    private OutputEntry outputEntry;

    private String id;

    public RuleFromDmn() {
    }

    public RuleFromDmn(String description, List<InputEntry> inputEntryList, OutputEntry outputEntry, String id) {
        this.description = description;
        this.inputEntryList = inputEntryList;
        this.outputEntry = outputEntry;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InputEntry> getInputEntryList() {
        return inputEntryList;
    }

    public void setInputEntryList(List<InputEntry> inputEntryList) {
        this.inputEntryList = inputEntryList;
    }

    public OutputEntry getOutputEntry() {
        return outputEntry;
    }

    public void setOutputEntry(OutputEntry outputEntry) {
        this.outputEntry = outputEntry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
