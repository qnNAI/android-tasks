package reader;

import android.content.Context;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<String> read(Context ctx) throws IOException;
}
