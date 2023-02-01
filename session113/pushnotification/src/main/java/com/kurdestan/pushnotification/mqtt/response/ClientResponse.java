package com.kurdestan.pushnotification.mqtt.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ClientResponse {




    @JsonProperty("recv_cnt")
    private Long recvCnt;


    @JsonProperty("send_msg.dropped.too_large")
    private Long sendMsgDroppedTooLarge;



    @JsonProperty("mailbox_len")
    private Long mailboxLen;


    @JsonProperty("expiry_interval")
    private Long expiryInterval;


    @JsonProperty("proto_name")
    private String protoName;



@JsonProperty("recv_msg.dropped")
    private Long recvMsgDropped;

    @JsonProperty("clientid")
    private String clientId;

    @JsonProperty("inflight_cnt")
    private Long inflightCnt;



    @JsonProperty("connected")
    private Boolean connected;


@JsonProperty("recv_pkt")
    private Long recvPkt;

    @JsonProperty("clean_start")
    private Boolean cleanStart;

    @JsonProperty("send_msg.dropped.expired")
    private Long sendMsgDroppedExpired;


    @JsonProperty("send_msg")
    private Long sendMsg;


    @JsonProperty("send_pkt")
    private Long sendPkt;




    @JsonProperty("awaiting_rel_max")
    private Long awaitingRelMax;




@JsonProperty("subscriptions_cnt")
    private Long subscriptionsCnt;


    @JsonProperty("created_at")
    private Date createdAt;


    @JsonProperty("mqueue_dropped")
    private Long mqueueDropped;


    @JsonProperty("reductions")
    private Long reductions;



    @JsonProperty("is_persistent")
    private Boolean isPersistent;

    @JsonProperty("keepalive")
    private Long keepalive;



    @JsonProperty("subscriptions_max")
    private String subscriptions_max;



    @JsonProperty("inflight_max")
    private Long inflightMax;



    @JsonProperty("mountpoint")
    private Long mountPoint;




    @JsonProperty("recv_msg.qos1")
    private Long recvMsgQos1;



    @JsonProperty("recv_msg.qos0")
    private Long recvMsgQos0;



    @JsonProperty("username")
    private String userName;


    @JsonProperty("enable_authn")
    private Boolean enableAuthn;


    @JsonProperty("is_bridge")
    private Boolean isBridge;


    @JsonProperty("send_msg.qos0")
    private Long sendMsgQos0;



    @JsonProperty("recvOct")
    private Long recvOct;



    @JsonProperty("send_oct")
    private Long sendOct;


    @JsonProperty("connected_at")
    private Date connectedAt;




    @JsonProperty("zone")
    private String zone;



    @JsonProperty("listener")
    private String listener;




    @JsonProperty("ip_address")
    private String ipAddress;



    @JsonProperty("node")
    private String node;



@JsonProperty("mqueue_len")
    private Long mqueueLen;


    @JsonProperty("mqueue_max")
    private Long mqueueMax;



    @JsonProperty("proto_ver")
    private Long protoVer;


    @JsonProperty("recv_msg.dropped.await_pubrel_timeout")
    private Long recvMsgDroppedAwaitPubrelTimeout;

    @JsonProperty("recv_msg")
    private Long recvMsg;

    @JsonProperty("send_msg.dropped")
    private Long sendMsgDropped;


@JsonProperty("heap_size")
    private Long heapSize;

    @JsonProperty("recv_msg.qos2")
    private Integer recvMsgQos2;


    @JsonProperty("send_msg.dropped.queue_full")
    private Long sendMsgDroppedQueueFull;


    @JsonProperty("port")
    private Integer port;


    @JsonProperty("send_msg.qos2")
    private Integer sendMsgQos2;

    @JsonProperty("awaiting_rel_cnt")
    private Long awaitingRelCnt;


    @JsonProperty("sendCnt")
    private Long sendCnt;

    @JsonProperty("send_msg.qos1")
    private Integer sendMsgQos1;



}
