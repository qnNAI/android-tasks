package writer;

import android.content.Context;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileWriter implements Writer {
    private static final String FILENAME = "test.txt";

    @Override
    public void write(Context ctx) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE)));

        bw.write("Выберите правильный ответ");
        bw.newLine();
        bw.write("неправильный ответ");
        bw.newLine();
        bw.write("тоже неправильный");
        bw.newLine();
        bw.write("правильный ответ");
        bw.newLine();
        bw.write("абсолютно неверный ответ");
        bw.newLine();
        bw.write("3");
        bw.newLine();

        bw.write("Вопрос от Жака Фреско:");
        bw.newLine();
        bw.write("красный");
        bw.newLine();
        bw.write("инверсия");
        bw.newLine();
        bw.write("сосиски");
        bw.newLine();
        bw.write("абстракция");
        bw.newLine();
        bw.write("3");
        bw.newLine();

        bw.write("Что не является ключевым словом java?");
        bw.newLine();
        bw.write("new");
        bw.newLine();
        bw.write("int");
        bw.newLine();
        bw.write("this");
        bw.newLine();
        bw.write("null");
        bw.newLine();
        bw.write("4");
        bw.newLine();

        bw.close();
    }

    @Override
    public void write(List<String> data, Context ctx) throws IOException {
        return;
    }
}
