package reader;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader implements Reader {
    private static final String FILENAME = "test.txt";

    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<String> read(Context ctx) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = null;
        try {
            BufferedInputStream bf = new BufferedInputStream(ctx.openFileInput(FILENAME));
            br = new BufferedReader(new InputStreamReader(bf, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines;
    }
}
