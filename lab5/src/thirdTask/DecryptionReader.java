package thirdTask;

import java.io.*;

public class DecryptionReader extends FilterReader {
    private final int key;

    public DecryptionReader(Reader in, char keyChar) throws FileNotFoundException {
        super(in);
        this.key = (int) keyChar;
    }

    @Override
    public int read() throws IOException {
        int character = super.read();
        if (character == -1) {
            return -1;
        }
        return character - key;
    }
}
