package com.kurdestan.pushnotification.mqtt.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class Metric {
 @JsonProperty("messages.dropped.count")
   private long messagesDroppedCount;



 @JsonProperty("messages.dropped.rate")
 private long  messagesDroppedRate;

 @JsonProperty("messages.in.count")
 private long   messagesInCount;


 @JsonProperty("messages.in.rate")
 private long     messagesInRate ;

 @JsonProperty("messages.out.count")
 private long    messagesOutCount;

 @JsonProperty("messages.out.rate")
 private long   messagesOutRate;

 @JsonProperty("messages.qos0.in.count")
 private long messagesQos0InCount;

 @JsonProperty("messages.qos0.in.rate")
 private long messagesQos0InRate;


 @JsonProperty("messages.qos0.out.count")
 private long  messagesQos0OutCount;

 @JsonProperty("messages.qos0.out.rate")
 private long       messagesQos0OutRate;


 @JsonProperty("messages.qos1.in.count")
 private long  messagesQos1InCount;

 @JsonProperty("messages.qos1.in.rate")
 private long      messagesQos1InRate;

 @JsonProperty("messages.qos1.out.count")
 private long       messagesQos1OutCount;

 @JsonProperty("messages.qos1.out.rate")
 private long       messagesQos1OutRate;

 @JsonProperty("messages.qos2.in.count")
 private long       messagesQos2InCount;

 @JsonProperty("messages.qos2.in.rate")
 private long       messagesQos2InRate;

 @JsonProperty("messages.qos2.out.count")
 private long        messagesQos2OutCount;


 @JsonProperty("messages.qos2.out.rate")
 private long       messagesQos2OutRate;
}
