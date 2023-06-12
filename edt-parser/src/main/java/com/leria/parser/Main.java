package com.leria.parser;

import java.io.File;

import com.leria.parser.Config.*;
import com.leria.parser.Models.Leria.objects.Timetabling;
import com.leria.parser.Parser.Parser;

public class Main {
  public static void main(String[] args) {
    String filename;
    if (args.length != 1) {
      System.out.println("Usage: java -jar edt-parser-1.0.jar <config_file>");
      System.out.println("Using default config file: edt-parser\\config.xml");
      filename = "C:\\Users\\Adrie\\Documents\\Dev\\edt\\edt-parser\\config.xml";
    } else {
      filename = args[0];
    }
    try {
      File file = new File(filename);
      ConfigurationFile config = ConfigurationParser.parse(file);
      Timetabling timetable = Parser.parseTimetable(config);
      timetable.exportXML("src\\main\\java\\com\\leria\\parser\\Data\\timetable.xml");
    } catch (Exception e) {
      System.out.println("<ERROR> " + e.getMessage());
    }
  }
}