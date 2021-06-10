package com.example.strings.main;

import com.example.strings.algorithm.BoyerMoore;
import com.example.strings.algorithm.KMP;

public class Main {
    public static void main(String[] args) {
        String pat;
        String txt;
        if (args.length == 0) {
            pat = "rabrabracad";
            txt = "abacadabrrabrabracadabracabracadabrabrabracad";
        } else {
            pat = args[0];
            txt = args[1];
        }
        char[] pattern = pat.toCharArray();
        char[] text    = txt.toCharArray();

        BoyerMoore boyermoore1 = new BoyerMoore(pat);
        int offset1 = boyermoore1.search(txt);

        // print results
        System.out.println("text:    " + txt);

        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);

        System.out.println("\n\nFind all patterns:");
        KMP kmp = new KMP();
        kmp.findAll(pat, txt);
    }
}
