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
        ArrayList<Integer> useless = new ArrayList<>();
        while(sc1.hasNextLine()){
            txt.add(sc1.nextLine());
        }
        //String str = new String(text);
        ArrayList<String> frags = new ArrayList<>();
        ArrayList<String> lst = new ArrayList<>();
        String buff = "";
        while(sc2.hasNextLine()){
            buff = sc2.nextLine();
            lst.add(buff.replaceAll("\\[[0-9]\\]",""));
            frags.add(buff);
        }
        String str = "";
        for(int i = 0; i < txt.size(); i++){
            str = txt.get(i);
            for(int j = 0; j < lst.size(); j++){
                j++;
                String c = String.valueOf(j);
                String tmp = str;
                str = str.replaceAll("\\["+c+"\\]", lst.get(j-1));
                if(!tmp.equals(str)){
                    useless.add(Integer.valueOf(c));
                }
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
        ArrayList<Integer> tsk = new ArrayList<>();
        for(int i = 0; i < arlst.size(); i++){
            //System.out.println(useless.indexOf(arlst.get(i)));
            if(useless.indexOf(arlst.get(i)) == -1){
                tsk.add(arlst.get(i));
            }
        }
        Collections.sort(tsk);
        System.out.println(frags);
        pw = new PrintWriter(new File("output2.txt"));
        for(int i = 0; i < tsk.size(); i++){
            pw.println(frags.get(tsk.get(i) - 1));
        }
        pw.flush();

    }
}
