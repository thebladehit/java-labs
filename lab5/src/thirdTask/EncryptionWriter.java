package thirdTask;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class EncryptionWriter extends FilterWriter {
    private final int key;

    protected EncryptionWriter(Writer out, char keyChar) {
        super(out);
        this.key = (int) keyChar;
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c + key);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            write(str.charAt(i));
        }
    }
}
