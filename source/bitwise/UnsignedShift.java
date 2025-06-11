package bitwise;

public class UnsignedShift {

    public static void main(String[] args) {
        UnsignedShift unsignedShift = new UnsignedShift();
        unsignedShift.extractRGB();
        unsignedShift.getIPParts();
        unsignedShift.getHash();
        unsignedShift.imageProcessingPixelManipulation();
        unsignedShift.huffMannCompressionAlgorithm();

    }

    public void extractRGB() {
        int argb = 0xFF123456; // Example ARGB color stored in unsigned format hence need to use unsigned shift
        int alpha = (argb >>> 24) & 0xFF; // Extract Alpha component
        int red = (argb >>> 16) & 0xFF; // Extract Red component
        int green = (argb >>> 8) & 0xFF; // Extract Green component
        int blue = argb & 0xFF;          // Extract Blue component

        System.out.println("\n"+"\033[1mextractRGB\033[0m"); // used bold for effect \033[1m to start and \033[0m to stop

        System.out.println("Alpha: " + alpha); // Output: 255
        System.out.println("Red: " + red);     // Output: 18
        System.out.println("Green: " + green); // Output: 52
        System.out.println("Blue: " + blue);   // Output: 86
    }

    public void getIPParts() {
        int ipAddress = 0xC0A80164; // Example: 192.168.1.100 (Hexadecimal format)
        int firstOctet = (ipAddress >>> 24) & 0xFF;
        int secondOctet = (ipAddress >>> 16) & 0xFF;
        int thirdOctet = (ipAddress >>> 8) & 0xFF;
        int fourthOctet = ipAddress & 0xFF;

        System.out.println("\n"+"\033[1mIp Address\033[0m");
        System.out.println(firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet);
        // Output: 192.168.1.100
    }

    public void getHash(){
        int hash = 0xA5A5A5A5;
        hash >>>= 3; // Shift right 3 bits without preserving sign
        System.out.println("\n"+"\033[1mgetHash\033[0m");
        System.out.println(hash);
    }

    public void huffMannCompressionAlgorithm(){
        // Data compression schemes like Huffman encoding use bitwise shifts for efficient storage
        //Encoding bit streams using unsigned shifts:
        int bitStream = 0b110010101; // Example binary stream
        bitStream >>>= 2; // Shift bits for encoding
        System.out.println("\n"+"\033[1mhuffMannCompressionAlgorithm\033[0m");
        System.out.println(Integer.toBinaryString(bitStream)); // Output: 1100101

    }

    public void imageProcessingPixelManipulation(){
        int pixelData = 0xFA10; // Example pixel intensity
        int grayscale = (pixelData >>> 8) & 0xFF; // Extract high byte
        System.out.println("\n"+"\033[1mimageProcessingPixelManipulation\033[0m");
        System.out.println(grayscale); // Output: 250

    }
}
