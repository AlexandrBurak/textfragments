package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner sc1 = new Scanner(new File("input1.txt"));
        Scanner sc2 = new Scanner(new File("input2.txt"));
        ArrayList<String> txt = new ArrayList<>();
        while(sc1.hasNextLine()){
            txt.add(sc1.nextLine());
        }
        //String str = new String(text);
        ArrayList<String> lst = new ArrayList<>();
        while(sc2.hasNextLine()){
            lst.add(sc2.nextLine().replaceAll("\\[[0-9]\\]",""));
        }
        String str = "";
        for(int i = 0; i < txt.size(); i++){
            str = txt.get(i);
            for(int j = 0; j < lst.size(); j++){
                j++;
                String c = String.valueOf(j);
                str = str.replaceAll("\\["+c+"\\]", lst.get(j-1));
                txt.set(i, str);
                j--;
            }

        }
        PrintWriter pw = new PrintWriter(new File("output1.txt"));
        for(int i = 0; i < txt.size(); i++){
            pw.println(txt.get(i));
        }
        pw.flush();
        Scanner sc = new Scanner(new File("input2.txt"));
        StringBuffer text = new StringBuffer("");
        while(sc.hasNextLine()){
            text.append(sc.nextLine()+" ");
        }
        StringBuilder sb = new StringBuilder();
        String text_s = text.toString();
        StringTokenizer a = new StringTokenizer(text_s, "\\[([^\\[]|\\[.*?\\])*\\]");
        ArrayList<Integer> arlst = new ArrayList<>();
        while (a.hasMoreTokens()) {
            try {
                String token = a.nextToken();
                arlst.add(Integer.parseInt(token));

            } catch (NumberFormatException e) {

            }

        }

        Collections.sort(arlst);
        Collections.reverse(arlst);
        pw = new PrintWriter(new File("output3.txt"));
        for(int i = 0; i < arlst.size(); i++){
            pw.println(arlst.get(i));
        }
        pw.flush();
    }
}
