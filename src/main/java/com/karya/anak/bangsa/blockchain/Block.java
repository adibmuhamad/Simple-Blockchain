package com.karya.anak.bangsa.blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {

    private int index;
    private long timestamp;
    private String hash;
    private String previousHash;
    private String data;
    private int nonce;

    Block(int index, long timestamp, String previousHash, String data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;
        nonce = 0;
        hash = Block.calculateHash(this);
    }

    int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    String getHash() {
        return hash;
    }

    String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    private String str() {
        return index + timestamp + previousHash + data + nonce;
    }

    public String toString() {
        return "Block #" + index + " [previousHash : " + previousHash + ", " +
                "timestamp : " + new Date(timestamp) + ", " + "data : " + data + ", " +
                "hash : " + hash + "]";
    }

    static String calculateHash(Block block) {
        if (block != null) {
            MessageDigest digest;

            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                return null;
            }

            String txt = block.str();
            final byte bytes[] = digest.digest(txt.getBytes());
            final StringBuilder builder = new StringBuilder();

            for (final byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    builder.append('0');
                }

                builder.append(hex);
            }

            return builder.toString();
        }

        return null;
    }

    void mineBlock(int difficulty) {
        nonce = 0;

        while (!getHash().substring(0,  difficulty).equals(Utils.zeros(difficulty))) {
            nonce++;
            hash = Block.calculateHash(this);
        }
    }
}
