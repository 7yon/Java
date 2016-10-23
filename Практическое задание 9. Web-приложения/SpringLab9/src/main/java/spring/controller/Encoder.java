package spring.controller;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Encoder {

    public Encoder(){}

    public String encode(String stringForEncode) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        XZCompressorOutputStream xzOut = new XZCompressorOutputStream(bout);
        xzOut.write(stringForEncode.getBytes());
        xzOut.close();

        return Base64.encodeBase64String(bout.toByteArray());
    }
}
