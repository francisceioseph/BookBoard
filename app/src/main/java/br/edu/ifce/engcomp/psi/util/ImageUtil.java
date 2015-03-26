package br.edu.ifce.engcomp.psi.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by FAMÍLIA on 25/03/2015.
 */
public class ImageUtil {

    //Pega imagem armazenada localmente e converte em byte
   public static byte [] getImage(Resources resource, int drawable){
       Bitmap bitmap = BitmapFactory.decodeResource(resource,drawable);
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
       byte[] imageBytes = stream.toByteArray();
       return imageBytes;
   }

    //Trata o tamanho da imagem
    public static Bitmap changeSizeImage(byte[] bytes, int width, int height){

        int targetW = width;
        int targetH = height;

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;

        BitmapFactory.decodeByteArray(bytes,0,bytes.length,bmOptions);

        int imageW = bmOptions.outWidth;
        int imageH = bmOptions.outHeight;

        int scaleFactor = Math.min(imageW/targetW, imageH/targetW);

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length,bmOptions);
        return bitmap;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}
