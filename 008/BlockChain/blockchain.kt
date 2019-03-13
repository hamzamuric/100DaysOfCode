import java.util.Date
import java.security.MessageDigest

fun sha256(input: String): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val hash: ByteArray = digest.digest(input.toByteArray()) // UTF-8
    val hexString = StringBuilder()
    for (byte in hash) {
        val hex = (byte.toInt() and 0xff).toString(16)
        if (hex.length == 1) hexString.append(0)
        hexString.append(hex)
    }
    return hexString.toString()
}

data class BlockData(val message: String)

class Block(val data: BlockData, val previousHash: String) {
    val timestamp: Long = Date().time
    val hash: String = calculateHash()

    fun calculateHash() = sha256(previousHash + timestamp.toString() + 
data)

    override fun toString() = """

        ++================================ BLOCK 
================================++
        ||prev: $previousHash ||
        ||hash: $hash ||
        
++=======================================================================++

    """.trimIndent()
}

class BlockChain {
    val chain = mutableListOf(Block(BlockData("GENESIS"), 
"0".repeat(64)))

    fun add(data: BlockData) {
        chain += Block(data, chain.last().hash)
    }

    fun isChainValid(): Boolean {
        var currentBlock: Block
        var previousBlock: Block

        for (i in 1 until chain.size) {
            currentBlock = chain[i]
            previousBlock = chain[i - 1]

            if (currentBlock.hash != currentBlock.calculateHash() ||
                previousBlock.hash != currentBlock.previousHash) {
                return false
            }
        }

        return true
    }

}

fun main() {

    val blockChain = BlockChain()
    blockChain.add(BlockData("Hello"))
    blockChain.chain.forEach(::println)

    println("BlockChain is ${if (blockChain.isChainValid()) "" else "not 
"}valid")
}
