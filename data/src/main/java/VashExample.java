import vash.Vash;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class VashExample {

    public static void main(String[] args) {
        String algorithm = "1.1";

        // The seed string is the value that we are hashing.
        String data = "Irina";

        // The width and height are the dimensions of the output image
        int width = 128;
        int height = 128;

        // Use the high level interface
        BufferedImage img1 = null;
        try {
            img1 = Vash.createImage(algorithm, data, width, height);

            File outputfile = new File("forvash.jpg");
            ImageIO.write(img1, "jpg", outputfile);
            System.out.println(outputfile.getAbsolutePath());

        } catch(NoSuchAlgorithmException | IOException e) {
            // Vash makes heavy use of the system's crytographic primitives, including
            //	SHA-512 and SHA-256, which were under export regulations some years ago.
            //	Everything we need should be present on any modern machine, so this should
            //	never get thrown in practice.
            System.err.println("Missing cryptographic primitives: " + e.toString());
            System.exit(1);
        }
    }
}
