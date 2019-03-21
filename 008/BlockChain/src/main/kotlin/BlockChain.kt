class BlockChain(val difficulty: Int = 5) {

    init {
        println("Mining GENESIS block...")
    }

    private val _chain = mutableListOf(Block(BlockData("GENESIS"), "0".repeat(64)).apply { mineBlock(difficulty) })
    val chain: List<Block> get() = _chain

    fun add(data: BlockData) {
        _chain += Block(data, _chain.last().hash)
        _chain.last().mineBlock(difficulty)
    }

    fun isChainValid(): Boolean {
        var currentBlock: Block
        var previousBlock: Block
        val target = "0".repeat(difficulty)

        for (i in 1 until _chain.size) {
            currentBlock = _chain[i]
            previousBlock = _chain[i - 1]

            if (currentBlock.hash != currentBlock.calculateHash() ||
                previousBlock.hash != currentBlock.previousHash ||
                currentBlock.hash.substring(0, difficulty) != target) {
                System.err.println("Chain invalid")
                println()
                return false
            }
        }

        return true
    }
}
