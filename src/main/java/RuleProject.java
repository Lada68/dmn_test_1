import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

public class RuleProject implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long promotionId;
   private String name;
    private Integer processingOrder;
    private String criteriaAndAction;
    private Long createdBy;
    private OffsetDateTime createdAt;
    private Long updatedBy;
    private OffsetDateTime updatedAt;
   private Boolean active;

    public RuleProject() {
    }

    public RuleProject(Long id, Long promotionId, String name, Integer processingOrder, String criteriaAndAction, Long createdBy, OffsetDateTime createdAt, Long updatedBy, OffsetDateTime updatedAt, Boolean active) {
        this.id = id;
        this.promotionId = promotionId;
        this.name = name;
        this.processingOrder = processingOrder;
        this.criteriaAndAction = criteriaAndAction;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProcessingOrder() {
        return processingOrder;
    }

    public void setProcessingOrder(Integer processingOrder) {
        this.processingOrder = processingOrder;
    }

    public String getCriteriaAndAction() {
        return criteriaAndAction;
    }

    public void setCriteriaAndAction(String criteriaAndAction) {
        this.criteriaAndAction = criteriaAndAction;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "RuleProject{" +
                "id=" + id +
                ", promotionId=" + promotionId +
                ", name='" + name + '\'' +
                ", processingOrder=" + processingOrder +
                ", criteriaAndAction='" + criteriaAndAction + '\'' +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedBy=" + updatedBy +
                ", updatedAt=" + updatedAt +
                ", active=" + active +
                '}';
    }
}
