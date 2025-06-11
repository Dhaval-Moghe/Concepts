import java.util.zip.CRC32;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CRCCollisionExample {
    private static long computeCRC32(byte[] data) {
        CRC32 crc = new CRC32();
        crc.update(data);
        return crc.getValue();
    }

    public static void main(String[] args) {
        // Step 1: Original text
        byte[] originalData = "Hello, CRC-32!".getBytes(StandardCharsets.UTF_8);
        long originalCRC = computeCRC32(originalData);

        // Step 2: Manually modifying bytes for collision
        byte[] collisionData = Arrays.copyOf(originalData, originalData.length);
        collisionData[5] ^= 0x5A;  // Bitwise tweak at a specific byte
        collisionData[10] ^= 0xA5; // Another tweak to maintain CRC integrity

        // Step 3: Compute CRC after modification
        long modifiedCRC = computeCRC32(collisionData);

        // Step 4: Print results
        System.out.println("Original CRC:  " + originalCRC);
        System.out.println("Modified CRC:  " + modifiedCRC);

        // Step 5: Check if a collision was achieved
        if (originalCRC == modifiedCRC) {
            System.out.println("CRC Collision Found! Different data, but same CRC.");
        } else {
            System.out.println("CRC Changed! The modification was detected.");
        }
    }
}



/* no collision is found in below example hence commented
public class CRC32CollisionExample {
    // Method to compute CRC-32 checksum
    private static long computeCRC32(String input) {
        CRC32 crc = new CRC32();
        crc.update(input.getBytes(StandardCharsets.UTF_8));
        return crc.getValue();
    }

    public static void main(String[] args) {
        // Step 1: Original text
        String original = "Hello, CRC-32!";
        long originalCRC = computeCRC32(original);

        // Step 2: Modified text (attempting collision)
        String collisionText = "Hello, CRC-32 ";  // Intentional space added

        // Step 3: Compute CRC for modified text
        long modifiedCRC = computeCRC32(collisionText);

        // Step 4: Compare results
        System.out.println("Original CRC:  " + originalCRC);
        System.out.println("Modified CRC:  " + modifiedCRC);

        if (originalCRC == modifiedCRC) {
            System.out.println("CRC Collision Found! The modified text produces the same CRC.");
        } else {
            System.out.println("CRC Changed! The modification was detected.");
        }
    }
}  */
