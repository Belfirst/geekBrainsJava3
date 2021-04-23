package ru.geekBrains.history;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class History {
    private FileOutputStream out;

    public void writingToFile(String message){
        byte[] outData = message.getBytes(StandardCharsets.UTF_8);
        try {
            out.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String login){

        List<String> file = null;
        try {
            file = new ArrayList<>(Files.readAllLines(Path.of("history_" + login + ".txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();

        if(file.size() > 100) {
            for(int i = file.size() - 100; i < file.size(); i++){
                sb.append(file.get(i));
            }
            return sb.toString();
        }

        String message = String.join("\n", file);
        System.out.println(message);
        return message;
    }

    public void openFile(String login){
        try {
            out = new FileOutputStream("history_" + login + ".txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile(){
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
