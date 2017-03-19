package com.zkx.crawler_demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zkx on 2017/3/19.
 */
public class TxtFilter {
    public String jiben(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String temp = "";
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }

            Pattern pattern = Pattern.compile("基本每股收益(.{20,}?)稀释");
            Matcher matcher = pattern.matcher(sb);
            String s = null;
            if (matcher.find()) {
                s = matcher.group(1);
            }
            System.out.println(s);
            if (s != null) {
                for (String i : s.split(" ")) {
                    System.out.println(i);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        TxtFilter filter = new TxtFilter();
        filter.jiben("wangfujing.txt");
    }
}
