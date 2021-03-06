package com.xliic.openapi.report;

import org.eclipse.core.resources.IMarker;

//import com.intellij.codeInspection.ProblemHighlightType;
//import com.intellij.lang.annotation.HighlightSeverity;

public enum Severity {

    LOW,
    MEDIUM,
    HIGH,
    CRITICAL;

    public static Severity getSeverity(int criticality) {

        if (criticality <= 2) {
            return LOW;
        }
        else if (criticality == 3) {
            return MEDIUM;
        }
        else if (criticality == 4) {
            return HIGH;
        }
        else {
            return CRITICAL;
        }
    }

    public static int getMarkerSeverity(Severity severity) {

        int type;
        switch (severity) {
            case LOW:
                type = IMarker.SEVERITY_INFO;
                break;
            case MEDIUM:
                type = IMarker.SEVERITY_WARNING;
                break;
            case HIGH:
                type = IMarker.SEVERITY_ERROR;
                break;
            case CRITICAL:
                type = IMarker.SEVERITY_ERROR;
                break;
            default:
            	type = IMarker.SEVERITY_INFO;
                break;
        }
        return type;
    }

//    public static HighlightSeverity getHighlightSeverity(Severity severity) {
//
//        HighlightSeverity highlightSeverity;
//        switch (severity) {
//            case LOW:
//                highlightSeverity = HighlightSeverity.WEAK_WARNING;
//                break;
//            case MEDIUM:
//                highlightSeverity = HighlightSeverity.WARNING;
//                break;
//            case HIGH:
//            case CRITICAL:
//                highlightSeverity = HighlightSeverity.ERROR;
//                break;
//            default:
//                highlightSeverity = HighlightSeverity.INFORMATION;
//                break;
//        }
//        return highlightSeverity;
//    }
}
