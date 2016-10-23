package spring.controller;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Decoder {

    public Decoder(){}

    public String decode(String stringForDecode) throws IOException {
        byte[] decodeString = new byte[100];

        byte[] result = Base64.decodeBase64(stringForDecode);

        ByteArrayInputStream bout = new ByteArrayInputStream(result);
        XZCompressorInputStream xzOut = new XZCompressorInputStream(bout);
        xzOut.read(decodeString);
        xzOut.close();

        return new String(decodeString);
    }
}