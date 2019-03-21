import java.util.Date

class Block(val data: BlockData, val previousHash: String) {
    val timestamp: Long = Date().time
    var hash: String = calculateHash()
    var nonce = 0L

    internal fun calculateHash() = sha256(previousHash + timestamp.toString() + nonce.toString() + data)

    internal fun mineBlock(difficulty: Int) {
        val target = "0".repeat(difficulty)
        while (hash.substring(0, difficulty) != target) {
            nonce++
            hash = calculateHash()
        }
        println("Block mined: $hash")
    }

    override fun toString(): String {
        return String.format(BLOCK_TEMPLATE, data.toString(), timestamp, nonce, previousHash, hash)
    }
}
