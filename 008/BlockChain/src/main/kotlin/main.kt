fun main() {

    val blockChain = BlockChain(3)

    println("Mining block 1...")
    blockChain.add(BlockData("Hello"))

    println("Mining block 2...")
    blockChain.add(BlockData("I'm second block"))

    println("Mining block 3...")
    blockChain.add(BlockData("Hello there it's me, the third block"))

    println("BlockChain is ${if (blockChain.isChainValid()) "" else "not "}valid")

    blockChain.chain.forEach(::println)

}
