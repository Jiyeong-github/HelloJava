package dev;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInputOutput {

    public void savefile(String inFile, String outFile){
        File in = new File(inFile);
        File out = new File(outFile);
        try {
            InputStream is = new FileInputStream(in);
            OutputStream os = new FileOutputStream(out);
            byte[] buffer = new byte[8 * 1024];
            int length;
            while((length = is.read(buffer)) >= 0){
                if (length>0) {
                    os.write(buffer, 0, length);
                }
            }
            os.flush();
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readTextFromFile(String file){
        File infile = new File(file);
        try {
            InputStream is = new FileInputStream(infile);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFileMyObject(String file, MyObject object){
        File outFile = new File(file);
        try {
            OutputStream os = new FileOutputStream(outFile);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyObject readFileMyObject(String file){
        File inFile = new File(file);
        try {
            InputStream is = new FileInputStream(inFile);
            ObjectInputStream ois = new ObjectInputStream(is);
            return (MyObject)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
