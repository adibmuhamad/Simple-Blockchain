package com.karya.anak.bangsa.blockchain;

public class Main {

    public static void main(String[] args) {

        //add block
        BlockChain blockchain = new BlockChain(4);
        blockchain.addBlock(blockchain.newBlock("Hello World!!!!"));
        blockchain.addBlock(blockchain.newBlock("Teting 1"));
        blockchain.addBlock(blockchain.newBlock("Testing 2"));

        //check block and print
        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
        System.out.println(blockchain);

        // add an invalid block to corrupt Blockchain
        blockchain.addBlock(new Block(15, System.currentTimeMillis(), "aaaabbb", "Block invalid"));

        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
    }
}
