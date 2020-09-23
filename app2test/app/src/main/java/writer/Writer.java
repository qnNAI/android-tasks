package writer;

import android.content.Context;

import java.io.IOException;
import java.util.List;

public interface Writer {
    void write(Context ctx) throws IOException;

    void write(List<String> data, Context ctx) throws IOException;
}
