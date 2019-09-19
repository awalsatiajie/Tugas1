package com.awal.awalsatiaje.tugas1;

import android.app.Activity;

public class QuestionHard extends Activity{

    private int IDHARD;
    private String QUESTIONHARD;
    private String OPTAHARD;
    private String OPTBHARD;
    private String OPTCHARD;

    private String ANSWERHARD;


    public QuestionHard() {
        IDHARD = 0;
        QUESTIONHARD = "";
        OPTAHARD = "";
        OPTBHARD = "";
        OPTCHARD = "";

        ANSWERHARD = "";

    }

    public QuestionHard(String qUESTIONHARD, String oPTAHARD, String oPTBHARD, String oPTCHARD,
                        String aNSWERHARD) {
        QUESTIONHARD = qUESTIONHARD;
        OPTAHARD = oPTAHARD;
        OPTBHARD = oPTBHARD;
        OPTCHARD = oPTCHARD;

        ANSWERHARD = aNSWERHARD;

    }

    public int getIDHARD() {
        return IDHARD;
    }

    public String getQUESTIONHARD() {
        return QUESTIONHARD;
    }

    public String getOPTAHARD() {
        return OPTAHARD;
    }

    public String getOPTBHARD() {
        return OPTBHARD;
    }

    public String getOPTCHARD() {
        return OPTCHARD;
    }

    public String getANSWERHARD() {
        return ANSWERHARD;
    }

    public void setIDHARD(int idHARD) {
        IDHARD = idHARD;
    }

    public void setQUESTIONHARD(String qUESTIONHARD) {
        QUESTIONHARD = qUESTIONHARD;
    }

    public void setOPTAHARD(String oPTAHARD) {
        OPTAHARD = oPTAHARD;
    }

    public void setOPTBHARD(String oPTBHARD) {
        OPTBHARD = oPTBHARD;
    }

    public void setOPTCHARD(String oPTCHARD) {
        OPTCHARD = oPTCHARD;
    }

    public void setANSWERHARD(String aNSWERHARD) {
        ANSWERHARD = aNSWERHARD;
    }
}
