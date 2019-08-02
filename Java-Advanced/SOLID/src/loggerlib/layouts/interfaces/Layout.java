package loggerlib.layouts.interfaces;

import loggerlib.enumartions.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}