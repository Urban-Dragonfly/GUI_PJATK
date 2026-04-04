package pl.pjatk.s36691.gui.zad07;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;

        try {
            br = new BufferedReader(new FileReader("src/pl/pjatk/s36691/gui/zad07/messages.txt"));
            bw1 = new BufferedWriter(new FileWriter("src/pl/pjatk/s36691/gui/zad07/1.txt"));
            bw2 = new BufferedWriter(new FileWriter("src/pl/pjatk/s36691/gui/zad07/2.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] lineArray = line.trim().split("\\s+");
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                for (int i = 0; i < lineArray.length; i++) {
                    if (i % 2 == 0) {
                        sb1.append(lineArray[i]);
                        sb1.append(" ");
                    }  else {
                        sb2.append(lineArray[i]);
                        sb2.append(" ");
                    }
                }

                String s1 = sb1.toString().trim();
                String s2 = sb2.toString().trim();

                bw1.write(s1);
                bw1.newLine();
                bw2.write(s2);
                bw2.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null)
                br.close();
            if (bw1 != null)
                bw1.close();
            if (bw2 != null)
                bw2.close();
        }


    }
}
