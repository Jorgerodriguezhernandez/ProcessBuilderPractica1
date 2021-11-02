import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Ejercicio3 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Introduzca la ruta del ARCHIVO: ");
            String ruta = sc.nextLine();
            File file = new File(ruta);
            if (!file.exists()) {
                System.out.println("Error, el ARCHIVO no existe");
            } else if (!file.isFile()) {
                System.out.println("Error, la ruta no pertenece a un ARCHIVO");
            } else {
                try {
                    ProcessBuilder[] Constructor = {
                            new ProcessBuilder("get-content", ruta),
                            new ProcessBuilder("svn status -q | find /c /v "+(char)34),};
                    List<Process> ArrProcess = ProcessBuilder.startPipeline(Arrays.asList(Constructor));
                    Process last = ArrProcess.get(ArrProcess.size() - 1);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(last.getInputStream()));
                    System.out.println("------------------");
                    System.out.println(reader.readLine());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

