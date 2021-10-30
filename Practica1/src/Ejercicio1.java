import java.io.IOException;
import java.util.Scanner;

    public class Ejercicio1 {

        public static void main(String[] args) throws IOException, InterruptedException {
            Scanner in = new Scanner(System.in);
            int NumEscrito = in.nextInt();
            String path = "C:\\Program Files\\Google\\Chrome\\Application\\";
            Process p = null;

            try {
                for (int i = 0; i<NumEscrito; i++) {
                    p = Runtime.getRuntime().exec(path + "chrome.exe");
                }
                p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
