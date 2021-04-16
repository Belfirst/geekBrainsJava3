package ru.geekBrains;

import javax.swing.*;

public class StartChat {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatApp();
            }
        });
    }
}
