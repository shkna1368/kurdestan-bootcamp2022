package com.kurdestan.pushnotification.mqtt.response;


import lombok.Data;

@Data
public class Meta {

    private Long count;
            private boolean hasnext;
         private Integer    limit;
           private Long  page;
}
