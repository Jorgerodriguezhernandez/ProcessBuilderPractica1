import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Ejercicio2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce la cantidad de navegadores que quieres ejecutar: ");
        int NumEscrito = in.nextInt();
        ArrayList<Process> ArrProcess = new ArrayList<Process>();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        try {
            System.out.println("El arranque del proceso fue: " + returnExecutionTime());
            for (int i = 0; i < NumEscrito; i++) {
                Process process = processBuilder.start();
                ArrProcess.add(process);
            }
            for (Process process : ArrProcess) {
                process.waitFor(500, TimeUnit.MILLISECONDS);
                process.destroy();
            }
            System.out.println("La finalización del proceso fue: " + returnExecutionTime());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String returnExecutionTime() {
        long Hora =LocalDateTime.now().getHour();
        long Minutos = LocalDateTime.now().getMinute();
        long Segundos = LocalDateTime.now().getSecond();

        return Hora + " : " + Minutos + " : " + Segundos;

    }
}
