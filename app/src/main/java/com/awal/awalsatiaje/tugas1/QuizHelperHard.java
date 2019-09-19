package com.awal.awalsatiaje.tugas1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class QuizHelperHard extends SQLiteOpenHelper{

    Context context;
    private static final int DATABASE_VERSION = 13;

    private static final String DATABASE_NAME_HARD = "mathsthr";
    private static final String TABLE_QUEST_HARD = "questhard";
    private static final String KEY_ID_HARD = "qidhard";
    private static final String KEY_QUES_HARD = "questionhard";
    private static final String KEY_ANSWER_HARD = "answerhard";
    private static final String KEY_OPTA_HARD = "optahard";
    private static final String KEY_OPTB_HARD = "optbhard";
    private static final String KEY_OPTC_HARD = "optchard";

    private SQLiteDatabase dbasehard;

    public QuizHelperHard(Context context) {
        super(context, DATABASE_NAME_HARD, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase dbhard) {

        dbasehard = dbhard;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_HARD + " ( "
                + KEY_ID_HARD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES_HARD
                + " TEXT, " + KEY_ANSWER_HARD + " TEXT, " + KEY_OPTA_HARD + " TEXT, "
                + KEY_OPTB_HARD + " TEXT, " + KEY_OPTC_HARD + " TEXT)";
        dbhard.execSQL(sql);
        addQuestionhard();

    }

    private void addQuestionhard() {
        QuestionHard q1 = new QuestionHard("18x20 = ?", "360", "340", "350", "360");
        this.addQuestionhard(q1);
        QuestionHard q2 = new QuestionHard("90:5 = ?", "15", "12", "18", "18");
        this.addQuestionhard(q2);
        QuestionHard q3 = new QuestionHard("22:2 = ?", "11", "12", "22", "11");
        this.addQuestionhard(q3);
        QuestionHard q4 = new QuestionHard("100:12 = ?", "8.3", "8.2", "8", "8.3");
        this.addQuestionhard(q4);
        QuestionHard q5 = new QuestionHard("12x5 = ?", "50", "60", "66", "60");
        this.addQuestionhard(q5);
        QuestionHard q6 = new QuestionHard("90-0 = ?", "90", "0", "91", "90");
        this.addQuestionhard(q6);
        QuestionHard q7 = new QuestionHard("22:2 = ?", "10", "11", "12", "11");
        this.addQuestionhard(q7);
        QuestionHard q8 = new QuestionHard("50x9 = ?", "470", "460", "450", "450");
        this.addQuestionhard(q8);
        QuestionHard q9 = new QuestionHard("50:4 = ?", "12.7", "12.5", "12.6", "12.5");
        this.addQuestionhard(q9);
        QuestionHard q10 = new QuestionHard("29x9 = ?", "261", "265", "266", "261");
        this.addQuestionhard(q10);
        QuestionHard q11 = new QuestionHard("2:2 = ?", "0", "1", "2", "1");
        this.addQuestionhard(q11);
        QuestionHard q12 = new QuestionHard("26:9 = ?", "2.8", "2.7", "2.9", "2.8");
        this.addQuestionhard(q12);
        QuestionHard q13 = new QuestionHard("44:8 = ?", "5.5", "5.3", "5.2", "5.5");
        this.addQuestionhard(q13);
        QuestionHard q14 = new QuestionHard("15x8 = ?", "121", "120", "122", "120");
        this.addQuestionhard(q14);
        QuestionHard q15 = new QuestionHard("19+15 = ?", "33", "31", "34", "34");
        this.addQuestionhard(q15);
        QuestionHard q16 = new QuestionHard("18x5 = ?", "89", "90", "91", "90");
        this.addQuestionhard(q16);
        QuestionHard q17 = new QuestionHard("16:8 = ?", "3", "2.5", "2", "2");
        this.addQuestionhard(q17);
        QuestionHard q18 = new QuestionHard("26:8 = ?", "3.2", "3", "2.3", "3.2");
        this.addQuestionhard(q18);
        QuestionHard q19 = new QuestionHard("15-8 = ?", "9", "7", "8", "7");
        this.addQuestionhard(q19);
        QuestionHard q20 = new QuestionHard("65-16 = ?", "48", "47", "49", "49");
        this.addQuestionhard(q20);
        QuestionHard q21 = new QuestionHard("83:25 = ?", "3.2", "3.3", "3.1", "3.3");
        this.addQuestionhard(q21);
        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbhard, int oldV, int newV) {

        dbhard.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_HARD);

        onCreate(dbhard);


    }

    public void addQuestionhard(QuestionHard quest) {


        ContentValues values = new ContentValues();
        values.put(KEY_QUES_HARD, quest.getQUESTIONHARD());
        values.put(KEY_ANSWER_HARD, quest.getANSWERHARD());
        values.put(KEY_OPTA_HARD, quest.getOPTAHARD());
        values.put(KEY_OPTB_HARD, quest.getOPTBHARD());
        values.put(KEY_OPTC_HARD, quest.getOPTCHARD());


        dbasehard.insert(TABLE_QUEST_HARD, null, values);
    }

    public List<QuestionHard> getAllQuestions() {
        List<QuestionHard> quesList = new ArrayList<QuestionHard>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST_HARD;
        dbasehard = this.getReadableDatabase();
        Cursor cursor = dbasehard.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            QuestionHard quest = new QuestionHard();
            quest.setIDHARD(cursor.getInt(0));
            quest.setQUESTIONHARD(cursor.getString(1));
            quest.setANSWERHARD(cursor.getString(2));
            quest.setOPTAHARD(cursor.getString(3));
            quest.setOPTBHARD(cursor.getString(4));
            quest.setOPTCHARD(cursor.getString(5));

            quesList.add(quest);
        }

        return quesList;
    }
}
