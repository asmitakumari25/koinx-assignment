package com.koinx;

public class TransactionResponse {
    private int id;
    private long created_at;
    private String sentCoin;
    private String receivedCoin;
    private int sentCoinAmount;
    private int receivedCoinAmount;

    public TransactionResponse(int id, long created_at, String sentCoin, String receivedCoin, int sentCoinAmount, int receivedCoinAmount) {
        this.id = id;
        this.created_at = created_at;
        this.sentCoin = sentCoin;
        this.receivedCoin = receivedCoin;
        this.sentCoinAmount = sentCoinAmount;
        this.receivedCoinAmount = receivedCoinAmount;
    }

    public TransactionResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public String getSentCoin() {
        return sentCoin;
    }

    public void setSentCoin(String sentCoin) {
        this.sentCoin = sentCoin;
    }

    public String getReceivedCoin() {
        return receivedCoin;
    }

    public void setReceivedCoin(String receivedCoin) {
        this.receivedCoin = receivedCoin;
    }

    public int getSentCoinAmount() {
        return sentCoinAmount;
    }

    public void setSentCoinAmount(int sentCoinAmount) {
        this.sentCoinAmount = sentCoinAmount;
    }

    public int getReceivedCoinAmount() {
        return receivedCoinAmount;
    }

    public void setReceivedCoinAmount(int receivedCoinAmount) {
        this.receivedCoinAmount = receivedCoinAmount;
    }
}
