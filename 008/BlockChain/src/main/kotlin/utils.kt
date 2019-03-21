import java.security.MessageDigest

const val BLOCK_TEMPLATE = """
++================================ BLOCK ================================++
||data: %64s ||
||timestamp: %59d ||
||nonce: %63d ||
||prev: %s ||
||hash: %s ||
++=======================================================================++
"""

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
