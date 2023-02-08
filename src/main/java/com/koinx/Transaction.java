package com.koinx;

public class Transaction {
    private String coin1;
    private String coin2;
    private int coin1Amount;
    private int coin2Amount;

    public Transaction(String coin1, String coin2, int coin1Amount, int coin2Amount) {
        this.coin1 = coin1;
        this.coin2 = coin2;
        this.coin1Amount = coin1Amount;
        this.coin2Amount = coin2Amount;
    }

    public Transaction() {
    }

    public String getCoin1() {
        return coin1;
    }

    public void setCoin1(String coin1) {
        this.coin1 = coin1;
    }

    public String getCoin2() {
        return coin2;
    }

    public void setCoin2(String coin2) {
        this.coin2 = coin2;
    }

    public int getCoin1Amount() {
        return coin1Amount;
    }

    public void setCoin1Amount(int coin1Amount) {
        this.coin1Amount = coin1Amount;
    }

    public int getCoin2Amount() {
        return coin2Amount;
    }

    public void setCoin2Amount(int coin2Amount) {
        this.coin2Amount = coin2Amount;
    }
}
