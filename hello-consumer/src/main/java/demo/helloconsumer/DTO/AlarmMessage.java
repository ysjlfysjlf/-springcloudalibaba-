package demo.helloconsumer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmMessage {
    private Integer scopedId;
    private String name;
    private String id0;
    private String id1;
    private String alarmMessage;
    private Long startTime;
    private String ruleName;

    @Override
    public String toString() {
        return "AlarmMessage{"+"scopedId="+scopedId+
                ",name="+name+
                ",id0="+id0+
                ",id1="+id1+
                ",alarmMessage="+
                alarmMessage+
                ",startTime="+
                startTime+
                ",ruleName="+
                ruleName+"}";
    }
}
