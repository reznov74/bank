package software.eng.project.bank.core.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

enum MediaType{

}
enum FlowType{

}
@Entity
public class AccessCardAccountFlow extends AccountFlow {


    @Enumerated(EnumType.STRING)
    @Column(name = "media_type")
    @NotNull
    MediaType mediaType;

    @Enumerated(EnumType.STRING)
    @Column(name = "flow_type")
    @NotNull
    FlowType flowType;

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public FlowType getFlowType() {
        return flowType;
    }

    public void setFlowType(FlowType flowType) {
        this.flowType = flowType;
    }
}
