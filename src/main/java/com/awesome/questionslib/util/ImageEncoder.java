package com.awesome.questionslib.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageEncoder {

    public final static float DEFAULT_IMG_SCALE = 0.25f;
    public final static float DEFAULT_IMG_QUALITY = 0.5f;

    public static String base64(byte[] imgData, String contentType) {
        String prefix = String.format("data:%s;base64,", contentType);
        return prefix + Base64.getEncoder().withoutPadding().encodeToString(imgData);
    }

    public static byte[] compressImage(InputStream inputStream) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Thumbnails.of(inputStream).scale(DEFAULT_IMG_SCALE).outputQuality(DEFAULT_IMG_QUALITY).toOutputStream(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
